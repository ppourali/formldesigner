package uw.cs.watform.forml.extensions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.common.base.Charsets;
import com.google.inject.Injector;

import uw.cs.watform.forml.base.xtext.utils.jface.viewers.StyledTextXtextAdapter;
import uw.cs.watform.forml.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.CustomEmbeddedEditorFactory;

public class MyView extends ViewPart {

	private Injector xtextInjector;

	private Resource originalResource;

	private XtextResource xtextResource;

	private String semanticElementFragment;

	private Decorations xtextEditorComposite;

	private EmbeddedEditor xTextEmbeddedEditor;

	EObject elementToShow;

	public Composite parentPart;

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

	private XtextResource createVirtualXtextResource(URI uri, EObject semanticElement) throws IOException {
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
		xtextVirtualResource.save(out, Collections.emptyMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));

		return xtextVirtualResource;
	}

	public MyView() {

	}

	public void in(EObject originalSemanticElement) {
		for (Control child : parentPart.getChildren()) {
			child.dispose();
			child = null;
		}

		try {
			elementToShow = originalSemanticElement;
			xtextInjector = ModelUtils.getInjector();

			if (originalSemanticElement == null) {
				return;
			}
			this.originalResource = originalSemanticElement.eResource();
			// Clone root EObject
			EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));

			this.xtextResource = createVirtualXtextResource(originalResource.getURI(), semanticElement);

			createXtextEditorStyledText(elementToShow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

		String prefix = "";//allText.substring(0, elementNode.getOffset() - 1);
		String editablePart = ModelUtils.getTextForModelObjects(semanticElementInDocument);//allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

		String suffix ="";// allText.substring(elementNode.getEndOffset());

		parts[0] = prefix;
		parts[1] = editablePart;
		parts[2] = suffix;

		return parts;
	}

	protected void createXtextEditor(EObject semanticElementInDocument) throws Exception {

		// EObject semanticElementInDocument ;//=
		// xtextResource.getEObject(semanticElementFragment);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		xtextEditorComposite = new Decorations(parentPart, SWT.BORDER);
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

		EmbeddedEditorModelAccess xtextPartialEditor = xTextEmbeddedEditor.createPartialEditor(
				pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1], pre_editable_suff_Fixes[2], true);

		xtextEditorComposite.pack();

	}

	protected void createXtextEditorStyledText(EObject semanticElementInDocument) throws Exception {

		// EObject semanticElementInDocument ;//=
		// xtextResource.getEObject(semanticElementFragment);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticElementInDocument);
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@java.lang.Override
			protected void doExecute() {
				try {
					final Display display = Display.getDefault();
					Display.getDefault().syncExec(new Runnable() {
						public void run() {

							createControl(parentPart, semanticElementInDocument);
						}
					});

					// oldMessage.getAttributes().clear();
					// oldMessage.getAttributes().addAll(newAttrList);
				} catch (Exception e) {

				}
			}
		});

	}

	public void createControl(Composite parent, EObject elem) {

		// Transition trans=FormlFactory.eINSTANCE.createTransition();
		// trans.setName("test_t");

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		IXtextFakeContextResourcesProvider fake = new IXtextFakeContextResourcesProvider() {

			@Override
			public void populateFakeResourceSet(ResourceSet fakeResourceSet, XtextResource fakeResource) {

				fakeResource.getContents().clear();
				fakeResource.getContents().add(EcoreUtil.getRootContainer(elem));

				try {
					fakeResource.save(out, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
					fakeResource.reparse(new String(out.toByteArray(), Charsets.UTF_8));

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		StyledTextXtextAdapter adapter = new StyledTextXtextAdapter(xtextInjector, fake);
		StyledText styledText = new StyledText(parent, SWT.WRAP | SWT.MULTI);
		adapter.adapt(styledText);

		ICompositeNode node = NodeModelUtils.findActualNodeFor(
				(adapter.getFakeResourceContext().getFakeResource().getEObject(semanticElementFragment)));// .getContents().get(0)).getGreetings().get(1)));
		String s = node.getText();
		java.lang.System.out.println(s);

		java.lang.System.out.println(node.getOffset() + "," + node.getLength());

		java.lang.System.out.println(new String(out.toByteArray(), Charsets.UTF_8).length());

		styledText.setText(new String(out.toByteArray(), Charsets.UTF_8));

		java.lang.System.out.println(styledText.getText().length());
		adapter.setVisibleRegion(node.getOffset(), node.getLength());

	}

	@SuppressWarnings("restriction")
	@Override
	public void createPartControl(Composite parent) {
		for (Control child : parent.getChildren()) {
			child.dispose();
			child = null;
		}

		this.parentPart = parent;
		Composite top = new Composite(parent, SWT.NONE);

		if (xtextInjector == null || xtextResource == null)
			return;

		EmbeddedEditorFactory factory = xtextInjector.getInstance(EmbeddedEditorFactory.class);
		EmbeddedEditor editor = factory.newEditor(new IEditedResourceProvider() {

			@Override
			public XtextResource createResource() {
				return xtextResource;
			}
		}).showErrorAndWarningAnnotations().withParent(top);

		ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor(elementToShow);
		String prefix = allText.substring(0, elementNode.getOffset() - 1);
		String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());
		String suffix = allText.substring(elementNode.getEndOffset());

		EmbeddedEditorModelAccess model = editor.createPartialEditor(prefix, editablePart, suffix, true);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
