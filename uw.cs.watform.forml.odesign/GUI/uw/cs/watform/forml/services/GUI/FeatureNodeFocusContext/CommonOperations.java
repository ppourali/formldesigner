package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import uw.cs.watform.forml.odesign.GUI.tabularGuard.CommonSpace;

public class CommonOperations {

	private static CommonSpace commonspace;
	
	public static void btnToggleTriggeringAddRemove() {
		if (commonspace.getBtnTriggeringEventAdding().getText().trim().equals("+")) {
			commonspace.getBtnTriggeringEventAdding().setText("-");
			commonspace.setIsAddingtriggeringEObject(getEventMode());
		} else if (commonspace.getBtnTriggeringEventAdding().getText().trim().equals("-")) {
			commonspace.getBtnTriggeringEventAdding().setText("+");
			commonspace.setIsAddingtriggeringEObject(getEventMode());
		}
	}

	public static int getEventMode() {
		int mode = 0;
		if (commonspace.getBtnTriggeringEventAdding().isVisible()) {
			if (commonspace.getBtnTriggeringEventAdding().getText().equals("+"))
				mode = 0;
			else if (commonspace.getBtnTriggeringEventAdding().getText().equals("-"))
				mode = 1;
		} else if (!commonspace.getBtnTriggeringEventAdding().isVisible()) {
			mode = 2;
		}
		return mode;
	}

	public static CommonSpace getCommonspace() {
		return commonspace;
	}

	public static void setCommonspace(CommonSpace commonspace) {
		CommonOperations.commonspace = commonspace;
	}

}
