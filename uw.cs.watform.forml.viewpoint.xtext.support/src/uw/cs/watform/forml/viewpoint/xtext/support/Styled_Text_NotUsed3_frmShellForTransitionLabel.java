package uw.cs.watform.forml.viewpoint.xtext.support;

import java.awt.MouseInfo;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.impl.FeatureModuleImpl;
import uw.cs.watform.forml.forml.impl.SystemImpl;

public class Styled_Text_NotUsed3_frmShellForTransitionLabel {
	public Composite embeddedComposite;
	public Text txtEid;
	public Composite txtWCE;
	public Composite txtGuard;
	public Composite txtWCA;
	public Composite composite;
	private java.awt.event.KeyListener suggestKeyListener ;
	public StyledText styledText;
	private int currRow;
	private System root;
	private Feature curFeature;

	public boolean ConfirmFlag=false;
	private final Display display;
	final Shell shell ;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private TabItem tabItem_1;
	public Composite composite_1;
	private TabFolder tabFolder;

	public String old_transitionName;
	public StyledText styledText_1;

	public Styled_Text_NotUsed3_frmShellForTransitionLabel(Transition trans, Display display) {

		old_transitionName=trans.getName();

		//super(display);
		this.display=display;
		shell = new Shell(display);

		shell.setSize(556, 171);

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
		shell.setTabList(new Control[]{tabFolder});

		shell.addDisposeListener(new DisposeListener() {


			@Override
			public void widgetDisposed(DisposeEvent e) {
				if(! old_transitionName.trim().equalsIgnoreCase(txtEid.getText().trim().replace(" ", "")))
					trans.setName(txtEid.getText().trim().replace(" ", ""));

			}
		});


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
		shell.setLocation((int)MouseInfo.getPointerInfo().getLocation().getX(),(int)MouseInfo.getPointerInfo().getLocation().getY());

		tabFolder = new TabFolder(shell, SWT.NONE);
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
		composite.setLayout(new FormLayout());

		Label lblId = new Label(composite,SWT.BORDER);
		FormData fd_lblId = new FormData();
		fd_lblId.bottom = new FormAttachment(0, 32);
		fd_lblId.right = new FormAttachment(0, 83);
		fd_lblId.top = new FormAttachment(0, 10);
		fd_lblId.left = new FormAttachment(0, 10);
		lblId.setLayoutData(fd_lblId);
		lblId.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblId.setText("ID");


		Label lblWcEvent = new Label(composite,SWT.BORDER);
		FormData fd_lblWcEvent = new FormData();
		fd_lblWcEvent.bottom = new FormAttachment(0, 32);
		fd_lblWcEvent.right = new FormAttachment(0, 194);
		fd_lblWcEvent.top = new FormAttachment(0, 10);
		fd_lblWcEvent.left = new FormAttachment(0, 89);
		lblWcEvent.setLayoutData(fd_lblWcEvent);
		lblWcEvent.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblWcEvent.setText("WC Event");
		//txtWCE.addKeyListener(suggestKeyListener);

		Label lblGaurd = new Label(composite,SWT.BORDER);
		FormData fd_lblGaurd = new FormData();
		fd_lblGaurd.bottom = new FormAttachment(0, 32);
		fd_lblGaurd.right = new FormAttachment(0, 295);
		fd_lblGaurd.top = new FormAttachment(0, 10);
		fd_lblGaurd.left = new FormAttachment(0, 200);
		lblGaurd.setLayoutData(fd_lblGaurd);
		lblGaurd.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblGaurd.setText("Gaurd");
		//txtGuard.addMouseListener(doublClickListener(curFeature.getAttributes()));


		Label lblActionId = new Label(composite,SWT.BORDER);
		FormData fd_lblActionId = new FormData();
		fd_lblActionId.bottom = new FormAttachment(0, 32);
		fd_lblActionId.right = new FormAttachment(0, 522);
		fd_lblActionId.top = new FormAttachment(0, 10);
		fd_lblActionId.left = new FormAttachment(0, 302);
		lblActionId.setLayoutData(fd_lblActionId);
		lblActionId.setBackground(SWTResourceManager.getColor(176, 224, 230));
		lblActionId.setText("Actions");



		txtEid = new Text(composite,SWT.BORDER);
		FormData fd_txtEid = new FormData();
		fd_txtEid.bottom = new FormAttachment(0, 95);
		fd_txtEid.right = new FormAttachment(0, 83);
		fd_txtEid.top = new FormAttachment(0, 38);
		fd_txtEid.left = new FormAttachment(0, 10);
		txtEid.setLayoutData(fd_txtEid);
		addKeyListener();
		txtEid.setTabs(0);


		txtWCE = new Composite(composite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		FormData fd_txtWCE = new FormData();
		fd_txtWCE.bottom = new FormAttachment(0, 95);
		fd_txtWCE.right = new FormAttachment(0, 194);
		fd_txtWCE.top = new FormAttachment(0, 38);
		fd_txtWCE.left = new FormAttachment(0, 89);
		txtWCE.setLayoutData(fd_txtWCE);

		txtWCE.setVisible(true);
		//tbtm.setControl(txtWCE);
		txtWCE.setLayout(new FillLayout());


		txtGuard = new Composite(composite,SWT.BORDER);
		txtGuard.setLayout(null);
		FormData fd_txtGuard = new FormData();
		fd_txtGuard.bottom = new FormAttachment(0, 95);
		fd_txtGuard.right = new FormAttachment(0, 295);
		fd_txtGuard.top = new FormAttachment(0, 38);
		fd_txtGuard.left = new FormAttachment(0, 200);
		txtGuard.setLayoutData(fd_txtGuard);
		
		styledText_1 = new StyledText(txtGuard, SWT.BORDER | SWT.WRAP);
		styledText_1.setBounds(0, 0, 60, 43);
		formToolkit.adapt(styledText_1);
		formToolkit.paintBordersFor(styledText_1);

		txtWCA = new Composite(composite,SWT.BORDER | SWT.NO_BACKGROUND);
		FormData fd_txtWCA = new FormData();
		fd_txtWCA.bottom = new FormAttachment(0, 95);
		fd_txtWCA.right = new FormAttachment(0, 522);
		fd_txtWCA.top = new FormAttachment(0, 38);
		fd_txtWCA.left = new FormAttachment(0, 302);
		txtWCA.setLayoutData(fd_txtWCA);
		txtWCA.setLayout(null);
		composite.setTabList(new Control[]{txtEid, txtWCE, txtGuard});

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("New Item");

		styledText = new StyledText(tabFolder, SWT.BORDER|SWT.MULTI | SWT.WRAP);
		tabItem.setControl(styledText);
		formToolkit.paintBordersFor(styledText);

		tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("New Item");

		composite_1 = new Composite(tabFolder, SWT.NONE);
		tabItem_1.setControl(composite_1);
		formToolkit.paintBordersFor(composite_1);



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

	public void open() {
		shell.open();  
		while (!shell.isDisposed ()) {  
			if (!display .readAndDispatch ()) display.sleep ();  
		}

	}



	private void addKeyListener()
	{
		txtEid.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.SHIFT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					e.doit = false;
					//closeEditor(false);
				}

				if ((e.stateMask & SWT.SHIFT) != 0 && e.keyCode == SWT.ESC) 
				{
					shell.close();
				}

			}

			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
