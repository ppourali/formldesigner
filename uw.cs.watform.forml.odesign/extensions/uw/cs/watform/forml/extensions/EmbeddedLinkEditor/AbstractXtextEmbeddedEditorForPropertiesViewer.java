package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

import uw.cs.watform.forml.viewpoint.xtext.support.Activator;
import uw.cs.watform.forml.viewpoint.xtext.support.CustomEmbeddedEditorFactory;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class AbstractXtextEmbeddedEditorForPropertiesViewer {

	protected EmbeddedEditorModelAccess xtextPartialEditor;

	protected final Injector xtextInjector;

	public Resource originalResource;

	protected XtextResource xtextResource;

	protected String semanticElementFragment;

	protected Composite xtextEditorComposite;

	protected EmbeddedEditor xTextEmbeddedEditor;
	private EObject original_semanticElement;

	public AbstractXtextEmbeddedEditorForPropertiesViewer(EObject semElem, Injector xtextInjector) {
		this.xtextInjector = xtextInjector;
		this.original_semanticElement = semElem;

	}

	protected EObject resolveSemanticElement() {

		return this.original_semanticElement;
	}

	private boolean isDSemanticDecorator(EObject eObject) {
		return ViewpointPackage.eINSTANCE.getDSemanticDecorator().isInstance(eObject);
	}

	public void showEditor(EObject originalelem, DiagramEditPart diagramEditPart, Composite referenceCompsiteOnShell) {
		try {
			this.xtextEditorComposite = referenceCompsiteOnShell;

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
			createXtextEditor();
		} catch (Exception e) {
			Activator.logError(e);
		} finally {

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

	@SuppressWarnings("restriction")
	protected void updateXtextResourceForImmidiateUpdate() throws IOException, BadLocationException {

		String newText = xtextPartialEditor.getSerializedModel();
		xtextResource.reparse(newText);
		EcoreUtil.resolveAll(xtextResource);
		final IParseResult parseResult = xtextResource.getParseResult();

		if (!parseResult.hasSyntaxErrors() && !hasDanglingRefs(xtextResource)) {
			// changedElement = xtextResource.getEObject(semanticElementFragment);
			// isChanged = true;

			reconcile(originalResource, xtextResource);
			XtextSourceViewer viewer = xTextEmbeddedEditor.getViewer();
			if (viewer.canDoOperation(ISourceViewer.FORMAT)) {
				viewer.doOperation(ISourceViewer.FORMAT);
			}
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
		// DiagramRootEditPart diagramEditPart = (DiagramRootEditPart)
		// hostEditPart
		// .getRoot();

		EObject semanticElementInDocument = xtextResource.getEObject(semanticElementFragment);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		// xtextEditorComposite=shellContainer.embeddedComposite;

		GridLayout gl = new GridLayout();
		xtextEditorComposite.setLayout(gl);

		CustomEmbeddedEditorFactory factory = new CustomEmbeddedEditorFactory();
		xtextInjector.injectMembers(factory);
		xTextEmbeddedEditor = factory.newEditor(new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				return xtextResource;
			}
		}).showErrorAndWarningAnnotations().withParent(xtextEditorComposite);

		xtextPartialEditor = xTextEmbeddedEditor.createPartialEditor(pre_editable_suff_Fixes[0],
				pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

		addTextModifyListener();
		addKeyVerifyListener();
		addKeyListener();
		addFocusListener();
		// setEditorBounds();

		// XtextSourceViewer viewer = xTextEmbeddedEditor.getViewer();
		// if (viewer.canDoOperation(ISourceViewer.FORMAT)) {
		// viewer.doOperation(ISourceViewer.FORMAT);
		// }
		//
		//xtextEditorComposite.forceFocus();
		xtextEditorComposite.setVisible(true);

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

		//
		// IXtextFakeContextResourcesProvider contextProvider=new
		// IXtextFakeContextResourcesProvider() {
		//
		// @Override
		// public void populateFakeResourceSet(ResourceSet fakeResourceSet,
		// XtextResource fakeResource) {
		// fakeResource=(XtextResource) originalResource;
		// fakeResourceSet=originalResource.getResourceSet();
		// }
		// };
		// //
		// //
		// StyledTextXtextAdapter xTextAdaptor = new
		// StyledTextXtextAdapter(xtextInjector,contextProvider);
		// xTextAdaptor.adapt(shellContainer.styledText);

		// xTextAdaptor.updateFakeResourceContext();
		// xTextAdaptor.setVisibleRegion(100, 20);

	}

	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

		String prefix = allText.substring(0, elementNode.getOffset() - 1);
		String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

		String suffix = allText.substring(elementNode.getEndOffset());

		parts[0] = prefix;
		parts[1] = editablePart;
		parts[2] = suffix;

		return parts;
	}

	protected void addFocusListener() {
		xTextEmbeddedEditor.getViewer().getTextWidget().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				updateForListener(true);
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void updateForListener(boolean isCounsil) {
		try {
			xTextEmbeddedEditor.getDocument().getValidationJob().join();
			immidiateUpdate(true);
			xTextEmbeddedEditor.getDocument().checkAndUpdateAnnotations();
		} catch (Exception excep) {
			// TODO Auto-generated catch block
			excep.printStackTrace();
		}
	}

	protected void addTextModifyListener() {

		xTextEmbeddedEditor.getViewer().addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {
				updateForListener(true);
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
				updateForListener(true);
			}
		});
	}

	public void immidiateUpdate(boolean isReconcile) {
		if (xtextPartialEditor != null) {
			if (isReconcile) {
				try {
					//updateXtextResourceForImmidiateUpdate();
					// updateXtextResource();
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
		}
	}

	protected void addKeyVerifyListener() {
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
//		if (hostEditPart != null) {
//			String editString = xtextPartialEditor.getEditablePart();
//
//			int numLines = StringUtil.getNumLines(editString);
//			int numColumns = StringUtil.getMaxColumns(editString);
//
//			IFigure figure = hostEditPart.getFigure();
//			Rectangle bounds = figure.getBounds().getCopy();
//			DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) hostEditPart.getRoot();
//			IFigure contentPane = diagramEditPart.getContentPane();
//			contentPane.translateToAbsolute(bounds);
//			EditPartViewer viewer = hostEditPart.getViewer();
//			Control control = viewer.getControl();
//			while (control != null && false == control instanceof Shell) {
//				bounds.translate(control.getBounds().x, control.getBounds().y);
//				control = control.getParent();
//			}
//
//			Font font = figure.getFont();
//			FontData fontData = font.getFontData()[0];
//			int fontHeightInPixel = fontData.getHeight();
//
//			int width = Math.max(fontHeightInPixel * (numColumns + 3), MIN_EDITOR_WIDTH);
//			int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
//			// xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width,
//			// height);
//			// xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120,
//			// width + 250, height + 50);
//
//			// xtextEditorComposite.setBounds( 100, 100, 50, 50);
//			xtextEditorComposite.setBounds(bounds.x, bounds.y, width + 250, height + 50);
//		}
	}

}
