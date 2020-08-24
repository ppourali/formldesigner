/******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo  - initial API and implementation
 ****************************************************************************/

package uw.cs.watform.forml.viewpoint.xtext.support;

import java.awt.MouseInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.merge.BatchMerger;
import org.eclipse.emf.compare.merge.IBatchMerger;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class LabelViewXtextEmbeddedEditorForTransition {

	private static int MIN_EDITOR_WIDTH = 100;

	private static int MIN_EDITOR_HEIGHT = 100;

	protected IGraphicalEditPart hostEditPart;

	protected IEditorPart diagramEditor;

	protected EmbeddedEditorModelAccess xtextPartialEditor;

	protected final Injector xtextInjector;

	protected Resource originalResource;

	protected XtextResource xtextResource;

	protected String semanticElementFragment;

	protected Composite xtextEditorComposite;

	protected EmbeddedEditor xTextEmbeddedEditor;

	public LabelViewXtextEmbeddedEditorForTransition(IGraphicalEditPart editPart, Injector xtextInjector) {
		this.hostEditPart = editPart;
		this.xtextInjector = xtextInjector;

	}

	protected EObject resolveSemanticElement(IGraphicalEditPart hostEditPart) {
		EObject eObject = hostEditPart.resolveSemanticElement();
		if (isDSemanticDecorator(eObject)) {
			DSemanticDecorator semanticDecorator = (DSemanticDecorator) eObject;
			return semanticDecorator.getTarget();
		}
		return resolveSemanticElement(hostEditPart);
	}

	private boolean isDSemanticDecorator(EObject eObject) {
		return ViewpointPackage.eINSTANCE.getDSemanticDecorator().isInstance(eObject);
	}

	public void showEditor(EObject originalelem, DiagramEditPart diagramEditPart, boolean firstTime) {
		try {

			hostEditPart = diagramEditPart;

			EObject originalSemanticElement = originalelem;// resolveSemanticElement(hostEditPart);
			if (originalSemanticElement == null) {
				return;
			}
			this.originalResource = originalSemanticElement.eResource();
			// Clone root EObject
			EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
			if (this.xtextResource == null) {
				this.xtextResource = createVirtualXtextResource(originalResource.getURI(), semanticElement);
			}

			// TODO manage multi resource with Xtext Linking or Scoping service
			semanticElementFragment = originalResource.getURIFragment(originalSemanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			// IDiagramEditDomain diagramEditDomain = hostEditPart
			// .getDiagramEditDomain();
			// diagramEditor = ((DiagramEditDomain) diagramEditDomain)
			// .getEditorPart();
			if (firstTime)
				createXtextEditor();
			else
				createXtextEditorForEdit();
		} catch (Exception e) {
			Activator.logError(e);
		} finally {
			if (hostEditPart != null) {
				hostEditPart.refresh();
			}
		}
	}

	/**
	 * Close this editor.
	 * 
	 * @param isReconcile
	 */
	public void closeEditor(boolean isReconcile) {
		if (xtextPartialEditor != null) {
			if (isReconcile) {
				try {
					updateXtextResource();
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
			// xtextEditor.dispose();
			if (xtextEditorComposite != null) {
				this.xtextEditorComposite.dispose();
				xtextEditorComposite = null;
			}
			xtextPartialEditor = null;
		}
	}

	protected XtextResource createVirtualXtextResource(URI uri, EObject semanticElement) throws IOException {
		IResourceFactory resourceFactory = xtextInjector.getInstance(IResourceFactory.class);
		// TODO use the synthetic scheme.
		XtextResourceSet rs = xtextInjector.getInstance(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		// Create virtual resource
		XtextResource xtextVirtualResource = (XtextResource) resourceFactory
				.createResource(URI.createURI(uri.toString()));
		rs.getResources().add(xtextVirtualResource);

		// Populate virtual resource with the given semantic element to edit
		xtextVirtualResource.getContents().add(semanticElement);

		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		xtextVirtualResource.save(out, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));

		return xtextVirtualResource;
	}

	protected void updateXtextResource() throws IOException, BadLocationException {
		String newText = xtextPartialEditor.getSerializedModel();
		xtextResource.reparse(newText);
		EcoreUtil.resolveAll(xtextResource);
		final IParseResult parseResult = xtextResource.getParseResult();
		if (!parseResult.hasSyntaxErrors() && !hasDanglingRefs(xtextResource)) {
			reconcile(originalResource, xtextResource);
			// XtextSourceViewer viewer = xTextEmbeddedEditor.getViewer();
			// if (viewer.canDoOperation(ISourceViewer.FORMAT)) {
			// viewer.doOperation(ISourceViewer.FORMAT);
			// }
		}
	}

	private boolean hasDanglingRefs(XtextResource xtextResource2) {
		return EcoreUtil.UnresolvedProxyCrossReferencer.find(xtextResource2).size() > 0;
	}

	private void reconcile(Resource resourceInSirius, XtextResource resourceInEmbeddedEditor) {
		try {

			IComparisonScope scope = new DefaultComparisonScope(resourceInSirius, resourceInEmbeddedEditor, null);
			final Comparison comparison = EMFCompare.builder().build().compare(scope);

			IMerger.Registry mergerRegistry = EMFCompareRCPPlugin.getDefault().getMergerRegistry();
			final IBatchMerger merger = new BatchMerger(mergerRegistry);

			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(originalResource);
			editingDomain.getCommandStack()
					.execute(new RecordingCommand(editingDomain, "update resource after direct text edit") {

						@Override
						protected void doExecute() {
							merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());
						}
					});
		} catch (Exception e) {
			Activator.logError(e);
		}

	}

	/**
	 * Create the XText editor
	 * 
	 * @param editorInput
	 *            the editor input
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	protected void createXtextEditor() throws Exception {

		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
		Composite parentComposite = (Composite) diagramEditPart.getViewer().getControl();

		EObject semanticElementInDocument = xtextResource.getEObject(semanticElementFragment);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

		int startIndex = allText.indexOf("{", elementNode.getOffset()) + 1;
		// int endIndex=elementNode.getEndOffset()-1;

		String prefix = allText.substring(0, startIndex);
		String editablePart = allText.substring(startIndex, startIndex + 1);

		String suffix = allText.substring(startIndex + 1);

		xtextEditorComposite = new Decorations(parentComposite, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		xtextEditorComposite.pack();
		xtextEditorComposite.update();
		xtextEditorComposite.setLayout(new FillLayout());

		CustomEmbeddedEditorFactory factory = new CustomEmbeddedEditorFactory();
		xtextInjector.injectMembers(factory);
		xTextEmbeddedEditor = factory.newEditor(new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				return xtextResource;
			}
		}).showErrorAndWarningAnnotations().withParent(xtextEditorComposite);

		xtextPartialEditor = xTextEmbeddedEditor.createPartialEditor(prefix, editablePart, suffix, true);

		addKeyVerifyListener();
		addTextModifyListener();
		addKeyListener();
		setEditorBounds();

		// XtextSourceViewer viewer = xTextEmbeddedEditor.getViewer();
		// if (viewer.canDoOperation(ISourceViewer.FORMAT)) {
		// viewer.doOperation(ISourceViewer.FORMAT);
		// }
		//
		xtextEditorComposite.forceFocus();
		// xTextEmbeddedEditor.getViewer().setVisibleRegion(start, length);
		xtextEditorComposite.setVisible(true);
		xTextEmbeddedEditor.getViewer().getTextWidget().setText("");
		// IRegion modelRange=new IRegion() {
		//
		// @Override
		// public int getOffset() {
		// // TODO Auto-generated method stub
		// return elementNode.getOffset();
		// }
		//
		// @Override
		// public int getLength() {
		// // TODO Auto-generated method stub
		// return elementNode.getEndOffset()-elementNode.getOffset();
		// }
		// };
		// xTextEmbeddedEditor.getViewer().setVisibleRegion(elementNode.getOffset(),
		// elementNode.getEndOffset()-elementNode.getOffset());
		// xtextEditorComposite.update();
		// xtextEditorComposite.pack();
		// xtextEditorComposite.setSize(105, 57);
		// xtextEditorComposite.pack();

		// Composite parentComposite =shellContainer.composite_1;// (Composite)
		// diagramEditPart.getViewer().getControl();
		// System.out.println(parentComposite);
		// //.getControl();
		// viewEmbeddedEditor vee=new viewEmbeddedEditor();
		// vee.xtextResource=this.xtextResource;
		// vee.xtextInjector=this.xtextInjector;
		// vee.editablePart=editablePart;
		// vee.prefix=prefix;
		// vee.suffix=suffix;
		// vee.createPartControl(parentComposite);
		// vee.setFocus();

		// createPC(shellContainer.composite_1,
		// EcoreUtil2.getRootContainer(semanticElementInDocument),
		// semanticElementInDocument );

	}

	protected void createXtextEditorForEdit() throws Exception {

		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
		Composite parentComposite = (Composite) diagramEditPart.getViewer().getControl();

		EObject semanticElementInDocument = xtextResource.getEObject(semanticElementFragment);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor(semanticElementInDocument);
		String prefix = allText.substring(0, elementNode.getOffset() - 1);
		String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());
		String suffix = allText.substring(elementNode.getEndOffset());
		xtextEditorComposite = new Decorations(parentComposite, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);

		xtextEditorComposite = new Decorations(parentComposite, SWT.RESIZE | SWT.ON_TOP | SWT.BORDER);
		xtextEditorComposite.pack();
		xtextEditorComposite.update();
		xtextEditorComposite.setLayout(new FillLayout());

		CustomEmbeddedEditorFactory factory = new CustomEmbeddedEditorFactory();
		xtextInjector.injectMembers(factory);
		xTextEmbeddedEditor = factory.newEditor(new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				return xtextResource;
			}
		}).showErrorAndWarningAnnotations().withParent(xtextEditorComposite);

		xtextPartialEditor = xTextEmbeddedEditor.createPartialEditor(prefix, editablePart, suffix, true);

		addKeyVerifyListener();
		addTextModifyListener();
		addKeyListener();
		setEditorBounds();

		xtextEditorComposite.forceFocus();
		xtextEditorComposite.setVisible(true);

	}

	// public void createPC(Composite parent, EObject elem, EObject
	// semanticElementInDocument) {
	// System model = FormlFactory.eINSTANCE.createSystem();
	// WorldModel wm=FormlFactory.eINSTANCE.createWorldModel();
	// BehaviourModel bm=FormlFactory.eINSTANCE.createBehaviourModel();
	//
	// model.setWorldmodel(wm);
	// model.setBehaviourmodel(bm);
	// //model.setWorldmodel(EcoreUtil2.copy(((System)elem).getWorldmodel()));
	// //model.setBehaviourmodel(EcoreUtil2.copy(((System)elem).getBehaviourmodel()));
	//
	// model.getWorldmodel().getConcepts().addAll(((System)elem).getWorldmodel().getConcepts());
	// model.getBehaviourmodel().getFeaturemodules().addAll(((System)elem).getBehaviourmodel().getFeaturemodules());
	//
	//
	// //Greeting g1 = MyDslFactory.eINSTANCE.createGreeting();
	// //Greeting g2 = MyDslFactory.eINSTANCE.createGreeting();
	// //Greeting g3 = MyDslFactory.eINSTANCE.createGreeting();
	// //g1.setName("G1");
	// //g2.setName("G2");
	// //g3.setName("G3");
	// //model.getGreetings().add(g1);
	// //model.getGreetings().add(g2);
	// //model.getGreetings().add(g3);
	//
	// //ByteArrayOutputStream out = new ByteArrayOutputStream();
	// //createVirtualXtextResource(
	// //originalResource.getURI(), elem);
	//
	// EObject semanticElement = EcoreUtil.copy(originalResource
	// .getContents().get(0));
	//
	// IResourceFactory resourceFactory = xtextInjector
	// .getInstance(IResourceFactory.class);
	// // TODO use the synthetic scheme.
	// XtextResourceSet rs = xtextInjector.getInstance(XtextResourceSet.class);
	// rs.setClasspathURIContext(getClass());
	// // Create virtual resource
	// XtextResource xtextVirtualResource = (XtextResource) resourceFactory
	// .createResource(URI.createURI(originalResource.getURI().toString()));
	// rs.getResources().add(xtextVirtualResource);
	//
	// // Populate virtual resource with the given semantic element to edit
	// xtextVirtualResource.getContents().add(semanticElement);
	//
	// // Save and reparse in order to initialize virtual Xtext resource
	// ByteArrayOutputStream out = new ByteArrayOutputStream();
	// //xtextVirtualResource.save(out,
	// SaveOptions.newBuilder().format().getOptions().toOptionsMap());
	// //xtextVirtualResource.reparse(new String(out.toByteArray()));
	//
	// IXtextFakeContextResourcesProvider fake = new
	// IXtextFakeContextResourcesProvider() {
	//
	// @Override
	// public void populateFakeResourceSet(ResourceSet fakeResourceSet,
	// XtextResource fakeResource) {
	// fakeResource.getContents().clear();
	// fakeResource.getContents().add(model);
	// //((System)fakeResource.getContents().get(0)).setBehaviourmodel(((System)xtextResource.getContents().get(0)).getBehaviourmodel());
	// //((System)fakeResource.getContents().get(0)).setWorldmodel(((System)xtextResource.getContents().get(0)).getWorldmodel());
	// //((System)fakeResource.getContents().get(0)).setWorldmodel(wm);
	// try {
	// fakeResource.save(out,
	// SaveOptions.newBuilder().format().getOptions().toOptionsMap());
	// fakeResource.reparse(new String(out.toByteArray(), Charsets.UTF_8));
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// };
	//
	//
	// StyledTextXtextAdapter adapter = new
	// StyledTextXtextAdapter(xtextInjector, fake );
	//
	// StyledText styledText = shellContainer.styledText;//new
	// StyledText(parent,SWT.NONE);
	// adapter.adapt(styledText);
	//
	// //java.lang.System.out.println(((System)adapter.getFakeResourceContext().getFakeResource().getContents().get(0)).getWorldmodel().getConcepts().get(0));
	// ICompositeNode node =
	// NodeModelUtils.findActualNodeFor(semanticElementInDocument);;
	// styledText.setText(new String(out.toByteArray(), Charsets.UTF_8));
	// //adapter.setVisibleRegion(node.getOffset(), node.getLength());
	// }

	protected void addTextModifyListener() {
		xTextEmbeddedEditor.getViewer().addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {
				try {

					xTextEmbeddedEditor.getDocument().getValidationJob().join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // .checkAndUpdateAnnotations();
				immidiateUpdate(true);
				xTextEmbeddedEditor.getDocument().checkAndUpdateAnnotations();
				// JOptionPane.showMessageDialog(null, event);
			}
		});
	}

	protected void addKeyListener() {
		xTextEmbeddedEditor.getViewer().getTextWidget().addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.SHIFT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					e.doit = false;
					closeEditor(true);
				}
				if ((e.stateMask & SWT.SHIFT) != 0 && keyCode == SWT.ESC) {
					e.doit = false;
				}

			}
		});
	}

	public void immidiateUpdate(boolean isReconcile) {
		if (xtextPartialEditor != null) {
			if (isReconcile) {
				try {
					updateXtextResource();
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
		}
	}

	private void addKeyVerifyListener() {
		final StyledText xtextTextWidget = xTextEmbeddedEditor.getViewer().getTextWidget();
		xtextTextWidget.addVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.SHIFT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					e.doit = false;
					closeEditor(true);
				}
				if ((e.stateMask & SWT.SHIFT) != 0 && keyCode == SWT.ESC) {
					e.doit = false;
					closeEditor(false);
				}

			}
		});
	}

	private void setEditorBounds() {
		// mind the added newlines
		String editString = xtextPartialEditor.getEditablePart();

		int numLines = StringUtil.getNumLines(editString);
		int numColumns = StringUtil.getMaxColumns(editString);

		IFigure figure = hostEditPart.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();
		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
		IFigure contentPane = diagramEditPart.getContentPane();
		contentPane.translateToAbsolute(bounds);
		EditPartViewer viewer = hostEditPart.getViewer();
		Control control = viewer.getControl();
		while (control != null && false == control instanceof Shell) {
			bounds.translate(control.getBounds().x, control.getBounds().y);
			control = control.getParent();
		}

		Font font = figure.getFont();
		FontData fontData = font.getFontData()[0];
		int fontHeightInPixel = fontData.getHeight();

		int width = Math.max(fontHeightInPixel * (numColumns + 3), MIN_EDITOR_WIDTH);
		int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
		// xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width,
		// height);
		// xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120,
		// width + 250, height + 50);

		// xtextEditorComposite.setBounds( 100, 100, 50, 50);

		 int x=(int)MouseInfo.getPointerInfo().getLocation().getX();
		 int y=(int)MouseInfo.getPointerInfo().getLocation().getY();

		// xtextEditorComposite.setBounds(0,0, width + 100, height);
		xtextEditorComposite.setBounds(bounds.x, bounds.y, width + 100, height);

	}

}
