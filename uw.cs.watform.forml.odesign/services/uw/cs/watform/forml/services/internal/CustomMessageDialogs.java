package uw.cs.watform.forml.services.internal;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * All the message dialogs are declared in this class.
 * 
 * 
 * @author ppourali
 */
public class CustomMessageDialogs {
	
	public static int dlgErrorMessageEdit(Shell shell, String title, String text) {
		MessageDialog dialog = new MessageDialog(shell, title, null,
			    text, MessageDialog.ERROR, new String[] {"OK"}, 0);
			int result = dialog.open();
			return result;
	}

}