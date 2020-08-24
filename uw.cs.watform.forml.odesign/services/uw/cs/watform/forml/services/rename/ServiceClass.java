package uw.cs.watform.forml.services.rename;

import uw.cs.watform.forml.services.internal.MessageDialogs;

public class ServiceClass {

	protected static void ShowRenameConfirmation() {
		MessageDialogs.DisplayChangeElementNameImpact();
	}
}
