package uw.cs.watform.forml.services.GUI;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class CustomMessageDialog {

	public static int ShowQuestionDialog(String MessageText, int type, String[] buttons, int defaultButton) {

		FakeJDialog dialog = new FakeJDialog();

		int rc = JOptionPane.showOptionDialog(dialog, MessageText, "Confirmation", type, JOptionPane.QUESTION_MESSAGE,
				null, buttons, buttons[defaultButton]);
		return rc;

	}
}

class FakeJDialog extends JDialog {
	public FakeJDialog() {

		//setVisible(true);
		setAlwaysOnTop(true);

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}