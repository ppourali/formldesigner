package uw.cs.watform.forml.services.utilities;

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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import uw.cs.watform.forml.viewpoint.xtext.support.Activator;

public class XTextUtils {

	protected final Injector xtextInjector;

	public Resource originalResource;

	protected XtextResource xtextResource;

	protected String semanticElementFragment;

	public EObject changedElement = null;

	public XTextUtils() {
		this.xtextInjector = ModelUtils.getInjector();
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

	public void initResource(EObject originalelem) {
		try {

			EObject originalSemanticElement = originalelem;
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

		} catch (Exception e) {
			Activator.logError(e);
		} finally {

		}
	}

	protected XtextResource createVirtualXtextResource(URI uri, EObject semanticElement) throws IOException {
		IResourceFactory resourceFactory = xtextInjector.getInstance(IResourceFactory.class);

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

	public void updateXtextResource(EObject originalelem, String NEWText) throws IOException, BadLocationException {

		try {
			ICompositeNode rootNode = xtextResource.getParseResult().getRootNode();
			String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, originalelem);

			String newText = pre_editable_suff_Fixes[0] + " [" + NEWText + "] " + pre_editable_suff_Fixes[2];
			xtextResource.reparse(newText);
			EcoreUtil.resolveAll(xtextResource);
			final IParseResult parseResult = xtextResource.getParseResult();
			if (!parseResult.hasSyntaxErrors() && !hasDanglingRefs(xtextResource)) {
				changedElement = xtextResource.getEObject(semanticElementFragment);
				reconcile(originalResource, xtextResource);
			} else {
				System.err.println("The guard cannot be serialized.");
			}
		} catch (Exception exc) {
			Activator.logError(exc);
		}

	}

	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument.eContainer()));

		String prefix = allText.substring(0, elementNode.getOffset() - 1);

		int start = prefix.length();
		int openGuardindex = 0;
		int closeGuardindex = 0;
		for (int i = start; i < allText.length(); i++) {
			if (allText.charAt(i) == '[') {
				openGuardindex = i;
				break;
			}
		}

		for (int i = openGuardindex; i < allText.length(); i++) {

			if (allText.charAt(i) == ']') {
				closeGuardindex = i;
				break;
			}
		}

		prefix = allText.substring(0, openGuardindex - 1);
		String editablePart = allText.substring(openGuardindex, closeGuardindex);

		String suffix = allText.substring(closeGuardindex + 1);

		parts[0] = prefix;
		parts[1] = editablePart;
		parts[2] = suffix;

		return parts;
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
}
