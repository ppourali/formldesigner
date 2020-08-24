package FPC;

import FPC_FeatureNode.CustomCompositeFeaturePreview;
import FPC_FeatureNode.FrmFPC_FeatureNode;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CustomControlFeaturePreview;

public class FPC_SingletonData {
	private static Roleable CurrentRoleable;
	private static FrmFPC_FeatureNode shell;
	private static CustomCompositeFeaturePreview FeaturesListDialog;

	public static Roleable getCurrentRoleable() {
		return CurrentRoleable;
	}

	public static void setCurrentRoleable(Roleable currentRoleable) {
		CurrentRoleable = currentRoleable;
	}

	public static FrmFPC_FeatureNode getShell() {
		return shell;
	}

	public static void setShell(FrmFPC_FeatureNode shell) {
		FPC_SingletonData.shell = shell;
	}

	public static CustomCompositeFeaturePreview getFeaturesListDialog() {
		return FeaturesListDialog;
	}

	public static void setFeaturesListDialog(CustomCompositeFeaturePreview featuresListDialog) {
		FeaturesListDialog = featuresListDialog;
	}
}
