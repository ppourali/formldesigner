package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

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
