package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import org.eclipse.swt.widgets.Shell;

import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;

public class CommonSpaceForContextualUI {
	private static Transition currentTransition;
	private static Roleable currentFeatureOrEntityClass;

	protected static FrmShellForSetGuardGraphicallyDialog shell;
	private static CustomControlFeaturePreview FeaturesListDialog;
	public static boolean replaceAllAction;
	public static boolean confirmFlag;

	public static Transition getCurrentTransition() {
		if (currentTransition.getTrig() == null) {
			Trigger trig = FormlFactory.eINSTANCE.createTrigger();
			currentTransition.setTrig(trig);
		}
		if (currentTransition.getGuard() == null) {
			Guard guard = FormlFactory.eINSTANCE.createGuard();
			currentTransition.setGuard(guard);
		}
		if (currentTransition.getList() == null) {
			WCAList wcaList = FormlFactory.eINSTANCE.createWCAList();
			currentTransition.setList(wcaList);
		}

		return currentTransition;
	}

	public static void setCurrentTransition(Transition t) {
		currentTransition = t;
	}

	public static Roleable getCurrentFeatureOrEntityClass() {
		return currentFeatureOrEntityClass;
	}

	public static void setCurrentFeatureOrEntityClass(Roleable currentClass) {
		currentFeatureOrEntityClass = currentClass;
	}

	public static FrmShellForSetGuardGraphicallyDialog getShell() {
		return shell;
	}

	public static void setShell(FrmShellForSetGuardGraphicallyDialog frmShellForSetGuardGraphicallyDialog) {
		shell = frmShellForSetGuardGraphicallyDialog;
	}

	public static void rollbackEveryThing() {
//		ModelUtils.getTypedRootForObject(currentTransition, System.class).setWorldmodel(originalSystem.getWorldmodel());
//		;
//		ModelUtils.getTypedRootForObject(currentTransition, System.class)
//				.setBehaviourmodel(originalSystem.getBehaviourmodel());
//		;
	}

	public static CustomControlFeaturePreview getFeaturesListDialog() {
		return FeaturesListDialog;
	}

	public static void setFeaturesListDialog(CustomControlFeaturePreview featuresListDialog) {
		FeaturesListDialog = featuresListDialog;
	}
}
