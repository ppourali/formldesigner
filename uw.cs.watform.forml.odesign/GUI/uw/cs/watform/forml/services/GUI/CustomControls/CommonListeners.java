package uw.cs.watform.forml.services.GUI.CustomControls;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class CommonListeners {

	public static KeyListener NumericalKeyListener(Text text, boolean isUpper) {
		return new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.character >= '0' && e.character <= '9') || e.character == '*') {
					if (e.character == '*') {
						if (!isUpper || !text.getText().trim().equals(""))
							e.doit = false;
						else
							e.doit = true;
					} else {
						if (text.getText().contains("*"))
							e.doit = false;
						else
							e.doit = true;
					}
				} else if ((e.character >= 'a' && e.character <= 'z') || (e.character >= 'A' && e.character <= 'Z')
						|| " !@#$%^&.-+/\\~,|[]{}?<>".indexOf(e.character) > -1) {
					e.doit = false;
				}
			}
		};
	}

}
