package uw.cs.watform.forml.viewpoint.xtext.support;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.BadLocationException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.impl.FeatureModuleImpl;
import uw.cs.watform.forml.forml.impl.SystemImpl;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;

public class NOTUSED2_frmShellForTransitionLabel {
	public Composite embeddedComposite;
	public Text txtEid;
	public Composite txtWCE;
	public Composite txtGuard;
	public Composite txtAid;
	public Composite composite;
	private java.awt.event.KeyListener suggestKeyListener ;

	private int currRow;
	private System root;
	private Feature curFeature;

	public boolean ConfirmFlag=false;
	private final Display display;
	final Shell shell ;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	public NOTUSED2_frmShellForTransitionLabel(EObject t, Display display) {

		//super(display);
		this.display=display;
		shell = new Shell(display);
		shell.setSize(556, 169);

		shell.setMinimumSize(new Point(0, 0));
		//setSize(new Point(282, 311));
		shell.setText("Transition Label");
		//setSize(521, 396);

		//		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		//		tabFolder.setBounds(10, 10, 246, 189);
		//		
		//		TabItem tbtmTabular = new TabItem(tabFolder, SWT.NONE);
		//		tbtmTabular.setText("Tabular");
		//		
		//		Composite composite = new Composite(tabFolder, SWT.NONE);
		//		tbtmTabular.setControl(composite);
		//		composite.setLayout(null);
		//		
		//		Label lblNewLabel = new Label(composite, SWT.NONE);
		//		lblNewLabel.setBounds(0, 23, 55, 15);
		//		lblNewLabel.setText("lblTLabel");
		//		
		//		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		//		lblNewLabel_1.setBounds(0, 0, 55, 15);
		//		lblNewLabel_1.setText("New Label");
		//		
		//		TabItem tbtmTextual = new TabItem(tabFolder, SWT.NONE);
		//		tbtmTextual.setText("Textual");
		//		
		//		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		//		tbtmTextual.setControl(scrolledComposite);
		//		scrolledComposite.setExpandHorizontal(true);
		//		scrolledComposite.setExpandVertical(true);
		//	}
		//}




		//root=FormlFactory.eINSTANCE.createSystem();
		//root=(System) getTypedRoot(t, "System");



		//curFeature=FormlFactory.eINSTANCE.createFeature();
		//curFeature=((FeatureModule) getTypedRoot(t, "FeatureModule")).getFeatureref();


		constructDesign(shell);

		populateValues(t);		


		//suggestionPopulate();


		//setKeyListenersForTextBoxes();

	}

	//		private void setKeyListenersForTextBoxes() {
	//
	//			txtEid.addKeyListener(new KeyListener() {
	//
	//				@java.lang.Override
	//				public void keyTyped(KeyEvent e) {
	//					// TODO Auto-generated method stub
	//
	//				}
	//
	//				@java.lang.Override
	//				public void keyReleased(KeyEvent e) {
	//					// TODO Auto-generated method stub
	//
	//				}
	//
	//				@java.lang.Override
	//				public void keyPressed(KeyEvent e) {
	//					if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
	//						ConfirmFlag=true;
	//						dispose();
	//					}
	//
	//				}
	//			});

	//			txtAid.addKeyListener(new KeyListener() {
	//
	//				@java.lang.Override
	//				public void keyTyped(KeyEvent e) {
	//					// TODO Auto-generated method stub
	//
	//				}
	//
	//				@java.lang.Override
	//				public void keyReleased(KeyEvent e) {
	//					// TODO Auto-generated method stub
	//
	//				}
	//
	//				@java.lang.Override
	//				public void keyPressed(KeyEvent e) {
	//					if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
	//						ConfirmFlag=true;
	//						dispose();
	//					}
	//
	//				}
	//			});


	//txtWCE.addKeyListener(suggestKeyListener);
	//txtGuard.addKeyListener(suggestKeyListener);
	//txtAction.addKeyListener(suggestKeyListener);
	//txtCondition.addKeyListener(suggestKeyListener);
	//}

	//	private MouseListener doublClickListener(List<ExprRef> suggestableAtts)
	//	{
	//
	//		return new MouseListener() {
	//
	//			@java.lang.Override
	//			public void mouseReleased(MouseEvent e) {
	//				// TODO Auto-generated method stub
	//
	//				//dblclick
	//				if(e.getClickCount()==2){
	//					try{
	//						frmTabularGuard ftg = new frmTabularGuard(root,suggestableAtts);
	//						ftg.setAlwaysOnTop(true);
	//						ftg.setVisible(true);
	//						((JTextField)(e.getSource())).setText( ftg.returnData());
	//					}
	//					catch(Exception ex)
	//					{
	//						ex.printStackTrace();
	//					}
	//				}
	//
	//
	//
	//			}
	//
	//			@java.lang.Override
	//			public void mousePressed(MouseEvent e) {
	//				// TODO Auto-generated method stub
	//
	//			}
	//
	//			@java.lang.Override
	//			public void mouseExited(MouseEvent e) {
	//				// TODO Auto-generated method stub
	//
	//			}
	//
	//			@java.lang.Override
	//			public void mouseEntered(MouseEvent e) {
	//				// TODO Auto-generated method stub
	//
	//			}
	//
	//			@java.lang.Override
	//			public void mouseClicked(MouseEvent e) {
	//				// TODO Auto-generated method stub
	//
	//			}
	//		};
	//	}

	//	private void insertAtCursor(JTextField myField, String myValue) {
	//
	//		int caretPos = myField.getCaretPosition();
	//
	//		String beforeCaret=myField.getText().substring(0, caretPos);
	//		String afterCaret=myField.getText().substring(caretPos);
	//
	//		myField.setText(beforeCaret + myValue+ afterCaret);
	//		myField.setCaretPosition(caretPos+myValue.length());
	//
	//	}
	//
	//	private void suggestionPopulate() {
	//		suggestKeyListener= new java.awt.event.KeyListener() {
	//
	//			@java.lang.Override
	//			public void keyTyped(java.awt.event.KeyEvent e) {
	//				// TODO Auto-generated method stub
	//
	//			}
	//
	//			@java.lang.Override
	//			public void keyReleased(java.awt.event.KeyEvent e) {
	//				// TODO Auto-generated method stub
	//
	//			}
	//
	//			@java.lang.Override
	//			public void keyPressed(java.awt.event.KeyEvent e) {
	//				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
	//					ConfirmFlag=true;
	//					dispose();
	//				}
	//				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SPACE) {
	//
	//					ActionListener menuListener = new ActionListener() {
	//						public void actionPerformed(ActionEvent event) {
	//							String curText=((JTextField)e.getSource()).getText();
	//
	//							String selectedItemOnPopup=event.getActionCommand();
	//							int delimeterIndex=selectedItemOnPopup.lastIndexOf(":");
	//							if(delimeterIndex==-1)
	//								delimeterIndex=selectedItemOnPopup.length();
	//							selectedItemOnPopup=selectedItemOnPopup.substring(0, delimeterIndex).trim();
	//
	//							insertAtCursor(((JTextField)e.getSource()),selectedItemOnPopup );
	//						}
	//					};
	//
	//
	//					int xLoc=((JTextField)e.getSource()).getLocation().x;
	//					int yLoc=((JTextField)e.getSource()).getLocation().y;
	//
	//					if(e.getSource().equals(txtWCE)){
	//						PopupContainer pc;
	//						try {
	//							pc = new PopupContainer("WCE",root,curFeature,((JTextField)e.getSource()).getText(0,((JTextField)e.getSource()).getCaretPosition()),menuListener);
	//							pc.show(e.getComponent(),0,16);
	//						} catch (BadLocationException e1) {
	//							// TODO Auto-generated catch block
	//							e1.printStackTrace();
	//						}
	//
	//					}
	//					else if(e.getSource().equals(txtAction)){
	//						PopupContainer pc;
	//						try {
	//							pc = new PopupContainer("WCA",root,curFeature,((JTextField)e.getSource()).getText(0,((JTextField)e.getSource()).getCaretPosition()),menuListener);
	//							pc.show(e.getComponent(),0,16);						
	//						} catch (BadLocationException e1) {
	//							// TODO Auto-generated catch block
	//							e1.printStackTrace();
	//						}
	//
	//					} 
	//				}
	//			}
	//		};
	//	}

	private EObject getTypedRoot(EObject t, String className) {

		EObject retObj = t; 
		switch (className)
		{
		case "System":
		{
			System sm=FormlFactory.eINSTANCE.createSystem();

			while(true)
			{
				t=t.eContainer();
				if (t.getClass()==SystemImpl.class){
					retObj= t;
					break;
				}

				if (t.eContainer()==null)
					break;
			}
			break;
		}
		case "FeatureModule":
		{
			FeatureModule sm=FormlFactory.eINSTANCE.createFeatureModule();

			while(true)
			{
				t=t.eContainer();
				if (t.getClass()==FeatureModuleImpl.class){
					retObj= t;
					break;
				}

				if (t.eContainer()==null)
					break;
			}
			break;
		}

		default:
			break;
		}

		return retObj;		

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


		shell.setText("Transition Label");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(10, 10, 267, 449);

		TabItem tbtmTabular = new TabItem(tabFolder, SWT.NONE);
		tbtmTabular.setText("Tabular");

		composite = new Composite(tabFolder, SWT.NONE);
		tbtmTabular.setControl(composite);


		TabItem tbtmTextual = new TabItem(tabFolder, SWT.NONE);
		tbtmTextual.setText("Textual Label");

		embeddedComposite = new Composite(tabFolder, SWT.BORDER | SWT.EMBEDDED |SWT.WRAP );
		embeddedComposite.setVisible(true);
		tbtmTextual.setControl(embeddedComposite);
		embeddedComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite.setLayout(null);

		Label lblId = new Label(composite,SWT.BORDER);
		lblId.setBounds(10, 33, 73, 22);
		lblId.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblId.setText("ID");


		Label lblWcEvent = new Label(composite,SWT.BORDER);
		lblWcEvent.setBounds(10, 55, 73, 22);
		lblWcEvent.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblWcEvent.setText("WC Event");
		//txtWCE.addKeyListener(suggestKeyListener);

		Label lblGaurd = new Label(composite,SWT.BORDER);
		lblGaurd.setBounds(10, 77, 73, 22);
		lblGaurd.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblGaurd.setText("Gaurd");
		//txtGuard.addMouseListener(doublClickListener(curFeature.getAttributes()));


		Label lblActionId = new Label(composite,SWT.BORDER);
		lblActionId.setBounds(10, 99, 73, 65);
		lblActionId.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblActionId.setText("Actions");

		Label lblProperty = new Label(composite, SWT.BORDER);
		lblProperty.setText("Property");
		lblProperty.setBackground(SWTResourceManager.getColor(220, 220, 220));
		lblProperty.setBounds(10, 5, 73, 22);

		Label lblValue = new Label(composite, SWT.BORDER);
		lblValue.setText("Value");
		lblValue.setBackground(SWTResourceManager.getColor(220, 220, 220));
		lblValue.setBounds(89, 5, 159, 22);

		SashForm sashForm = new SashForm(composite, SWT.VERTICAL);
		sashForm.setSashWidth(2);
		sashForm.setLocation(89, 33);
		sashForm.setSize(159, 212);
		formToolkit.paintBordersFor(sashForm);



		txtEid = new Text(sashForm,SWT.BORDER);


		txtWCE = new Composite(sashForm, SWT.BORDER);

		txtWCE.setVisible(true);
		//tbtm.setControl(txtWCE);
		txtWCE.setLayout(new FillLayout());


		txtGuard = new Composite(sashForm,SWT.BORDER);

		txtAid = new Composite(sashForm,SWT.BORDER);
		sashForm.setWeights(new int[] {1, 1, 1, 3});

		//txtCondition.addMouseListener(doublClickListener(curFeature.getAttributes()));


		//			Button btnNewButton = new Button(composite,SWT.NONE);
		//			btnNewButton.setText("...");
		//			btnNewButton.addActionListener(new ActionListener() {
		//				public void actionPerformed(ActionEvent arg0) {
		//					frmLookForEverything fle=new frmLookForEverything(root);
		//					fle.setVisible(true);
		//				}
		//			});
		//			btnNewButton.setBounds(195, 41, 21, 16);
		//			getContentPane().add(btnNewButton);



		//setAlwaysOnTop(true);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setResizable(false);
		//setSize(new Dimension(222, 150));


		//this.setLocation(MouseInfo.getPointerInfo().getLocation());
		//
		//			addWindowListener(new WindowAdapter() 
		//			{
		//				public void windowClosing(WindowEvent e)
		//				{
		//					ConfirmFlag=true;
		//				}
		//			});

		//			getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		//					KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.SHIFT_DOWN_MASK), "Cancel"); //$NON-NLS-1$
		//			getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
		//				public void actionPerformed(ActionEvent e)
		//				{
		//					ConfirmFlag=false;
		//					dispose();
		//				}
		//			});


	}


	private void populateValues(EObject t) {

		String tno="0";
		try{

			int i=0;
			for(EObject eobj:t.eContainer().eContents())
			{

				if(eobj.getClass().equals(t.getClass()))
				{

					i++;
				}
			}

			tno=String.valueOf(i);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void open() {
		shell.open();  
		while (!shell.isDisposed ()) {  
			if (!display .readAndDispatch ()) display.sleep ();  
		}

	}
}
