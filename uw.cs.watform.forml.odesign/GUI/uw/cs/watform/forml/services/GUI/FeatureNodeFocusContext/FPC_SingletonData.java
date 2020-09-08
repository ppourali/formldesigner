package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import uw.cs.watform.forml.forml.Roleable;

public class FPC_SingletonData {
	private static Roleable CurrentRoleable;
	private static FrmFPC_FeatureNode shell;
	private static CustomCompositeFeaturePreview FeaturesListDialog;
	public static boolean confirmFlag;
	private static CustomCompositeTreeViewer FeaturesTreeViewer;

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

	public static void SelectTreeFeatureCorrespondingToSelectedItem(Object roleable) {
		getFeaturesTreeViewer().selectCorrespondingItemOnTreeViewer(roleable);
	}

	public static CustomCompositeTreeViewer getFeaturesTreeViewer() {
		return FeaturesTreeViewer;
	}

	public static void setFeaturesTreeViewer(CustomCompositeTreeViewer featuresTreeViewer) {
		FeaturesTreeViewer = featuresTreeViewer;
	}
}
