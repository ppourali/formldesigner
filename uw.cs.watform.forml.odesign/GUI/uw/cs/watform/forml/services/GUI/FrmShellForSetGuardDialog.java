package uw.cs.watform.forml.services.GUI;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForGuard;

public class FrmShellForSetGuardDialog extends AbstractShellContainer {

	public boolean ConfirmFlag = false;
	private final Display display;

	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Composite composite_1;

	final FrmShellForSetGuardDialog shellContainer = this;
	private Composite composite_2;
	private CLabel lblNote;
	private Transition transition;

	public XtextEmbeddedEditorForGuard guard_embeddedEditor;

	public FrmShellForSetGuardDialog(Display display, Transition trans, EditPart ep) {
		this.transition = trans;
		this.display = display;
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.TOOL | SWT.ON_TOP);
		//addShellListenerForAutoDisposeOnDeactive();

		shell.setSize(524, 105);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");

		constructDesign(shell);
		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		composite_1 = new Composite(shell, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd_composite_1.heightHint = 45;
		gd_composite_1.widthHint = 323;
		composite_1.setLayoutData(gd_composite_1);
		formToolkit.adapt(composite_1);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		composite_2 = new Composite(composite_1, SWT.NONE);
		formToolkit.adapt(composite_2);
		formToolkit.paintBordersFor(composite_2);

		lblNote = new CLabel(shell, SWT.NONE);
		GridData gd_lblNote = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_lblNote.heightHint = 14;
		lblNote.setLayoutData(gd_lblNote);
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		formToolkit.adapt(lblNote);
		formToolkit.paintBordersFor(lblNote);
		lblNote.setText("Please use Shift+Enter to save the modifications in the embedder.");

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {

			}
		});

		addKeyListener();

		createTransitionEditor();

		shell.setLocation(findLocation(ep));
	}

	private Point findLocation(EditPart ep) {
		DEdgeEditPart edgeEditPart = (DEdgeEditPart) ep;

		IFigure figure = edgeEditPart.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();
		DiagramRootEditPart diagramEditPart = (DiagramRootEditPart) edgeEditPart.getRoot();
		IFigure contentPane = diagramEditPart.getContentPane();
		contentPane.translateToAbsolute(bounds);
		EditPartViewer viewer = edgeEditPart.getViewer();
		Control control = viewer.getControl();
		while (control != null && false == control instanceof Shell) {
			bounds.translate(control.getBounds().x, control.getBounds().y);
			control = control.getParent();
		}

		int x = bounds.x;
		int y = bounds.y + 100;

		if ((x + shell.getBounds().width) > display.getBounds().width)
			x = display.getBounds().width - (shell.getBounds().width) - 10;

		if ((y + shell.getBounds().height) > display.getBounds().height)
			y = display.getBounds().height - (shell.getBounds().height) - 10;

		Point loc = new Point(x, y);

		return loc;
	}

	private void createTransitionEditor() {

		// Create Editor For Guard
		guard_embeddedEditor = new XtextEmbeddedEditorForGuard(null, ModelUtils.getInjector());
		guard_embeddedEditor.shellContainer = shellContainer;
		if (transition.getGuard() == null) {
			Guard newGuard = FormlFactory.eINSTANCE.createGuard();
			transition.setGuard(newGuard);
		}
		composite_2.dispose();
		composite_2 = new Composite(composite_1, SWT.NONE);

		guard_embeddedEditor.showEditor(transition.getGuard(), null, this.composite_2);

		composite_2.update();
		composite_2.pack();
		composite_2.setSize(composite_1.getSize());
	}

	private void constructDesign(Shell shell) {
		// TODO Auto-generated method stub

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

		shell.setText("Set Guard");

	}

	public void open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private void addKeyListener() {

		// table_references.getItem(0).addKeyListener(new KeyListener() {
		//
		// @Override
		// public void keyReleased(KeyEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void keyPressed(KeyEvent e) {
		// switch (e.keyCode) {
		// case SWT.CR:
		// JOptionPane.showMessageDialog(null, e);
		// case SWT.ESC:
		// JOptionPane.showMessageDialog(null, "ESC");
		// break;
		// }
		//
		// }
		// });
	}
}
