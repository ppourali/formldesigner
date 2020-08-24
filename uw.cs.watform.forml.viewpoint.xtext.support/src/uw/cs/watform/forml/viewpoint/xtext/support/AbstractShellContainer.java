package uw.cs.watform.forml.viewpoint.xtext.support;

import java.awt.MouseInfo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public abstract class AbstractShellContainer {

	XtextEmbeddedEditorForTransition editor_Transition;
	XtextEmbeddedEditorForWCE editor_WCE;
	XtextEmbeddedEditorForGuard editor_Guard;
	XtextEmbeddedEditorForWCA editor_WCA;

	protected Shell shell = null;

	public void addShellListenerForAutoDisposeOnDeactive() {
		shell.addShellListener(new ShellListener() {

			@Override
			public void shellIconified(ShellEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void shellDeiconified(ShellEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void shellDeactivated(ShellEvent e) {
				double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
				double mouseY = MouseInfo.getPointerInfo().getLocation().getY();

				double shellStartX = shell.getLocation().x;
				double shellEndX = shellStartX + shell.getSize().x;

				double shellStartY = shell.getLocation().y;
				double shellEndY = shellStartY + shell.getSize().y;

				if (!((shellStartX <= mouseX && mouseX <= shellEndX) && (shellStartY <= mouseY && mouseY <= shellEndY)))
					shell.dispose();

			}

			@Override
			public void shellClosed(ShellEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void shellActivated(ShellEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}
	// Rectangle bound_txtEid=new Rectangle (89, 10, 73, 22);

	// Rectangle bound_txtWCE=new Rectangle (89, 38, 145, 22);
	// Rectangle bound_txtGuarad=new Rectangle (89, 66, 222, 22);
	// Rectangle bound_txtWCA=new Rectangle(89, 94,403, 22);

}
