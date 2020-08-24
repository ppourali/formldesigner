package uw.cs.watform.forml.services.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.diagram.business.api.query.EObjectQuery;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

//import com.apple.dnssd.TXTRecord;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.CustomControls.CustomSearchTextForWCE;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;
import uw.cs.watform.forml.viewpoint.xtext.support.AbstractShellContainer;

public class FrmShellForTriggerOperationsView extends AbstractShellContainer {
	public List<List<ExprRef>> suggestableItems;

	private java.awt.event.KeyListener suggestKeyListener;

	public boolean ConfirmFlag = false;
	private final Display display;
	public ExprRef returenItem;

	public final FormToolkit formToolkit;

	// final FrmShellForTriggerOperationsView shellContainer = this;
	private CustomSearchTextForWCE comp_SearchBar;
	private org.eclipse.swt.widgets.List lstOperations;

	private Feature parentFeature;

	public boolean plusFalg = true;
	public boolean minusFalg = false;

	public FrmShellForTriggerOperationsView(Display display, Feature containerFeature, List<List<ExprRef>> suggItems,
			EditPart ep) {

		this.display = display;
		formToolkit = new FormToolkit(display);

		this.suggestableItems = suggItems;
		this.parentFeature = containerFeature;

		shell = new Shell(display, SWT.POP_UP | SWT.ON_TOP);
		addShellListenerForAutoDisposeOnDeactive();

		
		shell.setBackground(SWTResourceManager.getColor(230, 230, 250));

		shell.setSize(350, 240);

		shell.setMinimumSize(new Point(0, 0));
		shell.setText("Transition Label");

		constructDesign(shell);
		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.horizontalSpacing = 1;
		shell.setLayout(gl_shell);

		comp_SearchBar = new CustomSearchTextForWCE(shell, this, parentFeature);
		comp_SearchBar.setLayout(new FillLayout(SWT.VERTICAL));
		GridData gd_comp_SearchBar = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_comp_SearchBar.heightHint = 36;
		gd_comp_SearchBar.widthHint = 335;
		comp_SearchBar.setLayoutData(gd_comp_SearchBar);
		formToolkit.adapt(comp_SearchBar);
		formToolkit.paintBordersFor(comp_SearchBar);

		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_scrolledComposite = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_scrolledComposite.heightHint = 161;
		scrolledComposite.setLayoutData(gd_scrolledComposite);
		formToolkit.adapt(scrolledComposite);
		formToolkit.paintBordersFor(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		lstOperations = new org.eclipse.swt.widgets.List(scrolledComposite, SWT.BORDER | SWT.V_SCROLL);
		lstOperations.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.ITALIC));
		formToolkit.adapt(lstOperations, true, true);
		scrolledComposite.setContent(lstOperations);
		scrolledComposite.setMinSize(lstOperations.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {

			}
		});

		addListeners();

		populateOperationsList("");

		comp_SearchBar.setListObject(lstOperations);

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

	private String getName(ExprRef e) {
		String name = "";

		if (e instanceof Message)
			name = ((Message) e).getName();
		else if (e instanceof Attribute)
			name = ((Attribute) e).getName();

		return name;
	}

	private boolean listItemContainsFilter(String strFilter, List<ExprRef> con) {
		if (getName(con.get(1)).toLowerCase().contains(strFilter.toLowerCase())) {
			return true;
		}
		if (con.get(0) instanceof Feature) {
			if (((Feature) con.get(0)).getName().toLowerCase().contains(strFilter.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public void populateOperationsList(String strFilter) {

		lstOperations.removeAll();

		if (strFilter.equals("")) {
			for (List<ExprRef> con : suggestableItems) {
				Feature parent = (Feature) con.get(0);
				if (con.get(1) instanceof Message)
					lstOperations.add(getName(con.get(1)) + " () : " + parent.getName());
				else if (con.get(1) instanceof Attribute)
					lstOperations.add(getName(con.get(1)) + " : " + parent.getName());

				lstOperations.setData(getName(con.get(1)).toLowerCase().trim(), con.get(1));
			}

		} else {

			for (List<ExprRef> con : suggestableItems) {
				if (listItemContainsFilter(strFilter, con)) {
					Feature parent = (Feature) con.get(0);
					if (con.get(1) instanceof Message)
						lstOperations.add(getName(con.get(1)) + " () : " + parent.getName());
					else if (con.get(1) instanceof Attribute)
						lstOperations.add(getName(con.get(1)) + " : " + parent.getName());
					lstOperations.setData(getName(con.get(1)).toLowerCase().trim(), con.get(1));
				}
			}

		}

		if (lstOperations.getItemCount() > 0)
			lstOperations.select(0);
		else if (lstOperations.getItemCount() == 0 && !strFilter.contains(".")) {
			lstOperations.add("Create Input Message in " + this.parentFeature.getName());
			lstOperations.setData("Create Input Message in " + this.parentFeature.getName(), this.parentFeature);

			// lstOperations.add("Create Output Message");
			// lstOperations.setData("Create Output Message", null);

			lstOperations.add("Create Attribute in " + this.parentFeature.getName());
			lstOperations.setData("Create Attribute in " + this.parentFeature.getName(), this.parentFeature);
		}

		else if (lstOperations.getItemCount() == 0 && strFilter.contains(".")) {

			String[] parentFeatureName0_NewObjectName1 = parseStrFilter(strFilter);
			if (parentFeatureName0_NewObjectName1 == null)
				return;

			String parentFeatureName = parentFeatureName0_NewObjectName1[0];
			String newObjectName = parentFeatureName0_NewObjectName1[1];

			Feature referenceFeature = WorldModelCommonServices.getFeatureByName(parentFeatureName);
			if (referenceFeature != null) {

				lstOperations.add("Create Input Message in " + parentFeatureName);
				lstOperations.setData("Create Input Message in " + parentFeatureName, referenceFeature);

				lstOperations.add("Create Attribute in " + parentFeatureName);
				lstOperations.setData("Create Attribute in " + parentFeatureName, referenceFeature);
			}
		}
	}

	private String[] parseStrFilter(String strFilter) {

		String[] returnString = strFilter.split("\\.");
		if (returnString.length == 2) {
			returnString[0].replace(" ", "").replace(".", "").replace("+", "").replace("-", "");;
			returnString[1].replace(" ", "").replace(".", "").replace("+", "").replace("-", "");;
			return returnString;
		} else {
			return null;
		}
	}

	private String[] getNewObjectName(String strFilter) {

		String[] returnString = strFilter.split("\\.");
		if (returnString.length == 2) {
			returnString[0].replace(" ", "").replace(".", "");
			returnString[1].replace(" ", "").replace(".", "").replace("+", "").replace("-", "");
			return returnString;
		} else {
			returnString = new String[2];
			returnString[0] = "";
			returnString[1] = strFilter.replace(" ", "").replace(".", "").replace("+", "").replace("-", "");
			return returnString;
		}
	}

	private TraverseListener createTraverseHandler() {
		return new TraverseListener() {

			@Override
			public void keyTraversed(TraverseEvent e) {

				if (e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
					// btnConfirmDelete.setFocus();
				} else if (e.detail == SWT.TRAVERSE_ESCAPE) {
					e.doit = false;
					ConfirmFlag = false;
					shell.dispose();
				}
			}
		};
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

		shell.setText("Select Triggering Event");
		// shell.setLocation((int)
		// MouseInfo.getPointerInfo().getLocation().getX(),
		// (int) MouseInfo.getPointerInfo().getLocation().getY());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		shell.setLocation(dim.width / 2 - shell.getSize().x / 2, dim.height / 2 - shell.getSize().y / 2);

	}

	public void open() {
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

	private void addListeners() {
		lstOperations.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				Object retItem = analyzeReturnItem();
				if (retItem != null) {
					if (retItem instanceof ExprRef) {
						returenItem = (ExprRef) retItem;
						setAddEvent();
					} else {
						setNoEvent();
					}
					shell.dispose();
				}
			}
		});

		lstOperations.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {

					Object retItem = analyzeReturnItem();

					if (retItem instanceof ExprRef) {
						returenItem = (ExprRef) retItem;
						setAddEvent();
					} else {
						setNoEvent();
					}
					shell.dispose();

				} else if (e.keyCode == SWT.KEYPAD_ADD) {

					Object retItem = analyzeReturnItem();
					if (retItem != null) {

						if (retItem instanceof ExprRef) {
							returenItem = (ExprRef) retItem;
							setAddEvent();
						} else {
							setNoEvent();
						}
						shell.dispose();
					}

				} else if (e.keyCode == SWT.KEYPAD_SUBTRACT) {

					Object retItem = analyzeReturnItem();
					if (retItem != null) {

						if (retItem instanceof ExprRef) {
							returenItem = (ExprRef) retItem;
							setRemoveEvent();
						} else {
							setNoEvent();
						}
						shell.dispose();
					}

				} else if (e.keyCode == SWT.ESC) {
					setNoEvent();
					shell.dispose();
				}

			}
		});
	}

	public void setNoEvent() {
		plusFalg = false;
		minusFalg = false;
		ConfirmFlag = false;
	}

	public void setAddEvent() {
		plusFalg = true;
		minusFalg = false;
		ConfirmFlag = true;
	}

	public void setRemoveEvent() {
		plusFalg = false;
		minusFalg = true;
		ConfirmFlag = true;
	}

	public Object analyzeReturnItem() {
		Object retItem = null;
		if (lstOperations.getSelectionCount() > 0) {
			String selectedText = lstOperations.getItem(lstOperations.getSelectionIndex());
			String DataKey = "";
			if (selectedText.contains("(")) {
				DataKey = selectedText.substring(0, selectedText.indexOf("(")).toLowerCase().trim();
				retItem = lstOperations.getData(DataKey);
			} else if (selectedText.contains(":")) {
				DataKey = selectedText.substring(0, selectedText.indexOf(":")).toLowerCase().trim();
				retItem = lstOperations.getData(DataKey);
			} else if (selectedText.startsWith("Create Input Message in ")) {

				DataKey = selectedText;
				Feature referenceFeature = (Feature) lstOperations.getData(DataKey);

				Input newMessage = FormlFactory.eINSTANCE.createInput();

				if (referenceFeature != null) {
					ModelOperations2.addNewInputMessageToFeature(referenceFeature, newMessage,
							getNewObjectName(comp_SearchBar.txtFilter.getText().trim())[1]);

					retItem = newMessage;
				}
			}

			else if (selectedText.contains("Create Attribute in ")) {
				DataKey = selectedText;
				Feature referenceFeature = (Feature) lstOperations.getData(DataKey);

				Attribute newatt = FormlFactory.eINSTANCE.createAttribute();
				if (referenceFeature != null) {
					ModelOperations2.addNewAttributeToFeature(referenceFeature, newatt,
							getNewObjectName(comp_SearchBar.txtFilter.getText().trim())[1]);

					retItem = newatt;
				}
			}
		}
		return retItem;
	}

}
