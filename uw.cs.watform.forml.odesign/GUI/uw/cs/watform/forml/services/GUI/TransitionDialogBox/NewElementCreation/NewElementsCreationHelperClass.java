package uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CommonSpaceForContextualUI;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomControlFeaturePreview;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomListForClasses;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.EmbeddedEditorGenerator;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class NewElementsCreationHelperClass {

	public static void createNewElement(Class type, Composite composite_ExpandBarHolder, Roleable selectedRoleable,
			CustomListForClasses selectedList, CustomControlFeaturePreview customControlFeaturePreview,
			String newName) {
		composite_ExpandBarHolder.setRedraw(false);
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedRoleable);
		editingDomain.getCommandStack()
				.execute(new RecordingCommand(editingDomain, "update resource in the specification editor") {

					@Override
					protected void doExecute() {

						if (selectedRoleable != null) {

							boolean isNotDuplicate = ModelOperations.checkIfNotDuplicateInWorldModel(type, newName,
									selectedRoleable, true);
							if (isNotDuplicate == false)
								return;

							if (selectedRoleable instanceof Feature || selectedRoleable instanceof Entity) {

								if (type.equals(Attribute.class)) {
									ModelOperations2.CreateNewAttribute(selectedRoleable, newName);
								} else {
									if (selectedRoleable instanceof Feature) {
										if (type.equals(Input.class)) {
											ModelOperations.addNewInputMessageToFeature((Feature) selectedRoleable,
													FormlFactory.eINSTANCE.createInput(), newName);
										} else if (type.equals(Output.class)) {
											ModelOperations.addNewOutputMessageToFeature((Feature) selectedRoleable,
													FormlFactory.eINSTANCE.createOutput(), newName);
										}
									} else if (selectedRoleable instanceof Entity) {
										if (type.equals(Function.class)) {
											ModelOperations2.CreateFunctionForEntity((Entity) selectedRoleable,
													newName);
										}
									}
								}

							}

							RejointModelsInMemory();

							RepopulateLists(type, selectedList, customControlFeaturePreview, "");

						}

					}
				});
		composite_ExpandBarHolder.setRedraw(true);
		composite_ExpandBarHolder.redraw();
	}

	public static boolean CreateNewAssociation(Object srcElement, CustomListForClasses targetList,
			String selectionItemText) {
		boolean successOperation = ModelOperations2
				.createAssociations(CommonSpaceForContextualUI.getCurrentFeatureOrEntityClass(), (Roleable) srcElement);

		if (successOperation) {
			RejointModelsInMemory();
			if (targetList == null || selectionItemText == null || selectionItemText.equals(""))
				CommonSpaceForContextualUI.getFeaturesListDialog().populateList();
			else
				CommonSpaceForContextualUI.getFeaturesListDialog().populateList(targetList, selectionItemText);

		}

		return successOperation;

	}

	public static void createNewEntity(Class type, Composite composite_ExpandBarHolder, Roleable selectedRoleable,
			CustomListForClasses selectedList, CustomControlFeaturePreview customControlFeaturePreview,
			String newName) {
		composite_ExpandBarHolder.setRedraw(false);
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(selectedRoleable);
		editingDomain.getCommandStack()
				.execute(new RecordingCommand(editingDomain, "update resource in the specification editor") {

					@Override
					protected void doExecute() {

						if (selectedRoleable != null) {

							boolean isNotDuplicate = ModelOperations.checkIfNotDuplicateInWorldModel(type, newName,
									selectedRoleable, true);
							if (isNotDuplicate == false)
								return;

							if (type.equals(Entity.class)) {
								ModelOperations.CreateNewEntity(selectedRoleable, newName);
							} else if (type.equals(Feature.class)) {
								// TODO:Make sure of non duplicated feature names
								Node parentNode = ModelUtils.getSPLRoot(selectedRoleable);
								ModelOperations.CreateNewFeature(parentNode);
							}

							RejointModelsInMemory();

							RepopulateLists(type, selectedList, customControlFeaturePreview, newName);

						}

					}
				});
		composite_ExpandBarHolder.setRedraw(true);
		composite_ExpandBarHolder.redraw();

	}

	public static void setType(Object data, Object type, CustomListForClasses releventLeftSideList,
			CustomControlFeaturePreview customControlFeaturePreview) {
		ModelUtils2.setType(data, type);

		RejointModelsInMemory();

		customControlFeaturePreview.populateList(releventLeftSideList, false, true, false);

//		
//		int currentIndex = releventLeftSideList.getSelectionIndex();
//		releventLeftSideList.deselectAll();
//		releventLeftSideList.setSelection(currentIndex);
//		releventLeftSideList.notifyListeners(SWT.Selection, new Event());
//		// RepopulateLists(Attribute.class, releventLeftSideList, this);

	}
	
	public static boolean ChangeAssociationType(Object srcElement, CustomListForClasses targetList,
			String selectionItemText) {
		boolean successOperation = ModelOperations2.chageAssociationType(CommonSpaceForContextualUI.getCurrentFeatureOrEntityClass(), (Roleable) srcElement);

		if (successOperation) {
			RejointModelsInMemory();
			if (targetList == null || selectionItemText == null || selectionItemText.equals(""))
				CommonSpaceForContextualUI.getFeaturesListDialog().populateList();
			else
				CommonSpaceForContextualUI.getFeaturesListDialog().populateList(targetList, selectionItemText);

		}

		return successOperation;

	}

	protected static void RepopulateLists(Class type, CustomListForClasses selectedList,
			CustomControlFeaturePreview customControlFeaturePreview, String newName) {
		if (type.equals(Entity.class) || type.equals(Feature.class)) {
			customControlFeaturePreview.chkShowUsedClasses.setSelection(false);
			customControlFeaturePreview.populateList(selectedList, newName);
			//selectedList.select(3);
		} else {
			customControlFeaturePreview.populateList(selectedList, false, true, false);
			// customControlFeaturePreview.doOnSelect(selectedList);
		}
	}

	protected static void RejointModelsInMemory() {
		EmbeddedEditorGenerator.UpdateXtextModel(true, true, true, "");

	}
}
