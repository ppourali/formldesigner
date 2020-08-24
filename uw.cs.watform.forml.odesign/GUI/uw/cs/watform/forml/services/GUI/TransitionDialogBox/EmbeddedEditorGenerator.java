package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.CustomEmbeddedEditorResourceProvider;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForContextualUI;

public class EmbeddedEditorGenerator {

	public static EmbeddedEditorModelAccess partialEditorModelAccess_Event;
	public static EmbeddedEditorModelAccess partialEditorModelAccess_Guard;
	public static EmbeddedEditorModelAccess partialEditorModelAccess_Action;
	public static XtextEmbeddedEditorForContextualUI embeddedEditor_Action;
	public static XtextEmbeddedEditorForContextualUI embeddedEditor_Event;
	public static XtextEmbeddedEditorForContextualUI embeddedEditor_Guard;
	public static EmbeddedEditor editor_Event;
	public static EmbeddedEditor editor_Guard;
	public static EmbeddedEditor editor_Action;

	public static void createTransitionEditor(Transition trans, boolean isEdit, Class type, Composite parentComposite,
			boolean dispose) {

		try {
			// Create Editor For the Whole Transition
			XtextEmbeddedEditorForContextualUI transition_embeddedEditor = new XtextEmbeddedEditorForContextualUI(
					ModelUtils.getInjector(), isEdit); //

			if (parentComposite != null) {

				parentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));
				parentComposite.layout(true, true);

				transition_embeddedEditor.createEditor(parentComposite, trans, type);

				parentComposite.layout(true, true);
				parentComposite.redraw();

				if (Trigger.class.equals(type)) {
					partialEditorModelAccess_Event = transition_embeddedEditor.partialEditorModelAccess;
					editor_Event = transition_embeddedEditor.editor;
					embeddedEditor_Event = transition_embeddedEditor;

				} else if (Guard.class.equals(type)) {
					partialEditorModelAccess_Guard = transition_embeddedEditor.partialEditorModelAccess;
					editor_Guard = transition_embeddedEditor.editor;
					embeddedEditor_Guard = transition_embeddedEditor;
				} else if (WCAList.class.equals(type)) {
					partialEditorModelAccess_Action = transition_embeddedEditor.partialEditorModelAccess;
					editor_Action = transition_embeddedEditor.editor;
					embeddedEditor_Action = transition_embeddedEditor;

				}

				setDropTagets(transition_embeddedEditor.editor.getViewer().getTextWidget(), type);

			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private static void updateActionModel() {
		Transition currentTransition = CommonSpaceForContextualUI.getCurrentTransition();
		Resource originalResource = currentTransition.eResource();

//		FeatureNode f = (FeatureNode) originalResource.getContents().get(0).eContents().get(0).eContents().get(0)
//				.eContents().get(1);
		// System.out.println("Start: " + f.getFeature().getAttributes().size());

		CustomEmbeddedEditorResourceProvider resourceProvider = ModelUtils.getInjector()
				.getInstance(CustomEmbeddedEditorResourceProvider.class);

		XtextResource xTextResource = resourceProvider.createResource(currentTransition);

		ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

		String semanticElementFragment = originalResource.getURIFragment(currentTransition.getList());
		EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		partialEditorModelAccess_Action.updateModel(pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1],
				pre_editable_suff_Fixes[2]);
		editor_Action.getViewer().getTextWidget().setEnabled(true);

		embeddedEditor_Action.saveEditor(true);
	}

	private static void updateEventModel() {
		Resource originalResource = CommonSpaceForContextualUI.getCurrentTransition().eResource();

		// FeatureNode
		// f=(FeatureNode)originalResource.getContents().get(0).eContents().get(0).eContents().get(0).eContents().get(1);
		// System.out.println("Start: "
		// +f.getFeature().getAttributes().size() );

		CustomEmbeddedEditorResourceProvider resourceProvider = ModelUtils.getInjector()
				.getInstance(CustomEmbeddedEditorResourceProvider.class);

		XtextResource xTextResource = resourceProvider
				.createResource(CommonSpaceForContextualUI.getCurrentTransition().getTrig());

		ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

		String semanticElementFragment = originalResource
				.getURIFragment(CommonSpaceForContextualUI.getCurrentTransition().getTrig());
		EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		partialEditorModelAccess_Event.updateModel(pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1],
				pre_editable_suff_Fixes[2]);
		editor_Event.getViewer().getTextWidget().setEnabled(true);

		embeddedEditor_Event.saveEditor(true);

	}

	@SuppressWarnings("restriction")
	private static void updateGuardModel(String guardText) {
		Resource originalResource = CommonSpaceForContextualUI.getCurrentTransition().eResource();

		// FeatureNode
		// f=(FeatureNode)originalResource.getContents().get(0).eContents().get(0).eContents().get(0).eContents().get(1);
		// System.out.println("Start: "
		// +f.getFeature().getAttributes().size() );

		CustomEmbeddedEditorResourceProvider resourceProvider = ModelUtils.getInjector()
				.getInstance(CustomEmbeddedEditorResourceProvider.class);

		XtextResource xTextResource = resourceProvider
				.createResource(CommonSpaceForContextualUI.getCurrentTransition());

		ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

		String semanticElementFragment = originalResource
				.getURIFragment(CommonSpaceForContextualUI.getCurrentTransition().getGuard());
		EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		if (guardText.contentEquals("")) {
			partialEditorModelAccess_Guard.updateModel(pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1],
					pre_editable_suff_Fixes[2]);
		} else {
			partialEditorModelAccess_Guard.updateModel(pre_editable_suff_Fixes[0], guardText,
					pre_editable_suff_Fixes[2]);
		}

		embeddedEditor_Guard.saveEditor(true);
		// System.out.println("end: "
		// +f.getFeature().getAttributes().size() );

		editor_Guard.getViewer().getTextWidget().setEnabled(true);

		pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		return;
	}

	public static String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		try {
			String allText = rootNode.getText();

			ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

			String prefix = allText.substring(0, elementNode.getOffset() - 1);
			String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

			String suffix = allText.substring(elementNode.getEndOffset());

			parts[0] = prefix;
			parts[1] = editablePart;
			parts[2] = suffix;
		} catch (Exception e) {
			parts[0] = "";
			parts[1] = "[]";
			parts[2] = "";
		}
		return parts;
	}

	public static void clearOrImportTransitionEvent(Trigger trig) {
		if (trig == null) {
			CommonSpaceForContextualUI.getCurrentTransition().setTrig(null);
		} else {
			Trigger newtrig = FormlFactory.eINSTANCE.createTrigger();
			newtrig = EcoreUtil.copy(trig);
			CommonSpaceForContextualUI.getCurrentTransition().setTrig(newtrig);
		}
		UpdateXtextModel(true, false, false, null);
	}

	public static void clearOrImportTransitionGuard(Guard guard) {
		if (guard == null) {
			CommonSpaceForContextualUI.getCurrentTransition().setGuard(null);
		} else {
			Guard newguard = FormlFactory.eINSTANCE.createGuard();
			newguard = EcoreUtil.copy(guard);
			CommonSpaceForContextualUI.getCurrentTransition().setGuard(newguard);
		}
		UpdateXtextModel(false, true, false, "");
	}

	public static void clearOrImportTransitionAction(WCAList wcaList) {
		if (wcaList == null) {
			CommonSpaceForContextualUI.getCurrentTransition().setList(null);
		} else {

			WCAList newWCAList = FormlFactory.eINSTANCE.createWCAList();
			newWCAList = EcoreUtil.copy(wcaList);
			CommonSpaceForContextualUI.getCurrentTransition().setList(newWCAList);
		}
		UpdateXtextModel(false, false, true, null);
	}

	private static void setDropTagets(StyledText styledText, Class type) {
		if (Trigger.class.equals(type)) {
			DNDOperationsForEvent.setDragDropTarget(styledText);
		} else if (Guard.class.equals(type)) {
			DNDOperationsForGuard.setDragDropTarget(styledText);
		} else if (WCAList.class.equals(type)) {
			DNDOperationsForAction.setDragDropTarget(styledText);
		}
	}

	public static boolean UpdateXtextModel(boolean isEventUpdate, boolean isGuardUpdate, boolean isActionUpdate,
			String guardText) {
		if (isEventUpdate) {
			updateEventModel();
		}
		if (isGuardUpdate) {
			try {
				updateGuardModel(guardText);
			} catch (RuntimeException re) {
				Shell shell = editor_Guard.getViewer().getTextWidget().getShell();
				if (re.getMessage().startsWith("No EObjectDescription could be found in Scope atomic.ref")) {
					MessageBox dialog = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);

					dialog.setText("Error");
					dialog.setMessage(
							"The selected element cannot be used. The main reason for this issue can be due to the fact that there is no association/link between the selected entity and the State-Machine's entity. Please create and association first and then try again.");

					dialog.open();
					return false;
				}

			}
		}
		if (isActionUpdate) {
			updateActionModel();
		}
		return true;
	}
}
