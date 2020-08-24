package uw.cs.watform.forml.services.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.awt.MouseInfo;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.forml.impl.*;
import uw.cs.watform.forml.services.utilities.ContentAssistantFrame;
import uw.cs.watform.forml.services.utilities.CustomContentAssistant;
import uw.cs.watform.forml.services.utilities.PopupObjects;
import sun.security.krb5.internal.crypto.EType;


public class setTransitionLabel extends JDialog {

//	private JPopupMenu popup;
//
//	public JTextField txtEid;
//	public JTextField txtWCE;
//	public JTextField txtGuard;
//	public JTextField txtAid;
//	public JTextField txtAction;
//	public JTextField txtCondition;
//	public JComboBox txtPriority;
//
//	private java.awt.event.KeyListener suggestKeyListener ;
//
//	private int currRow;
//	private System root;
//	private Feature curFeature;
//
//	public boolean ConfirmFlag=false;
//
//	public setTransitionLabel(EObject t) {
//
//
//		root=FormlFactory.eINSTANCE.createSystem();
//		root=(System) getTypedRoot(t, "System");
//
//
//
//		curFeature=FormlFactory.eINSTANCE.createFeature();
//		curFeature=((FeatureModule) getTypedRoot(t, "FeatureModule")).getRelatedFeature();
//
//
//		constructDesign();
//
//		populateValues(t);		
//
//
//		suggestionPopulate();
//
//
//		setKeyListenersForTextBoxes();
//
//	}
//
//	private void setKeyListenersForTextBoxes() {
//
//		txtEid.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
//					ConfirmFlag=true;
//					dispose();
//				}
//				
//			}
//		});
//		
//		txtAid.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
//					ConfirmFlag=true;
//					dispose();
//				}
//				
//			}
//		});
//
//
//		txtWCE.addKeyListener(suggestKeyListener);
//		txtGuard.addKeyListener(suggestKeyListener);
//		txtAction.addKeyListener(suggestKeyListener);
//		txtCondition.addKeyListener(suggestKeyListener);
//	}
//
//	private MouseListener doublClickListener(List<Attribute> suggestableAtts)
//	{
//
//		return new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//				if(e.getClickCount()==2){
//					frmTabularGuard ftg = new frmTabularGuard(root,suggestableAtts);
//					ftg.setVisible(true);
//					((JTextField)(e.getSource())).setText( ftg.returnData());
//
//				}
//
//
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		};
//	}
//
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
//			@Override
//			public void keyTyped(java.awt.event.KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void keyReleased(java.awt.event.KeyEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
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
//
//	private EObject getTypedRoot(EObject t, String className) {
//
//		EObject retObj = t; 
//		switch (className)
//		{
//		case "System":
//		{
//			System sm=FormlFactory.eINSTANCE.createSystem();
//
//			while(true)
//			{
//				t=t.eContainer();
//				if (t.getClass()==SystemImpl.class){
//					retObj= t;
//					break;
//				}
//
//				if (t.eContainer()==null)
//					break;
//			}
//			break;
//		}
//		case "FeatureModule":
//		{
//			FeatureModule sm=FormlFactory.eINSTANCE.createFeatureModule();
//
//			while(true)
//			{
//				t=t.eContainer();
//				if (t.getClass()==FeatureModuleImpl.class){
//					retObj= t;
//					break;
//				}
//
//				if (t.eContainer()==null)
//					break;
//			}
//			break;
//		}
//
//		default:
//			break;
//		}
//
//		return retObj;		
//
//	}
//
//	private void constructDesign() {
//		// TODO Auto-generated method stub
//		setType(Type.UTILITY);
//		getContentPane().setBackground(new Color(255, 239, 213));
//		setModal(true);
//		setBackground(new Color(173, 216, 230));
//		getContentPane().setForeground(new Color(173, 216, 230));
//
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//		getContentPane().setLayout(null);
//
//		JLabel lblNewLabel = new JLabel("Property");
//		lblNewLabel.setLocation(1, 1);
//		lblNewLabel.setPreferredSize(new Dimension(94, 22));
//		lblNewLabel.setSize(new Dimension(94, 22));
//		lblNewLabel.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setOpaque(true);
//		getContentPane().add(lblNewLabel);
//
//		JLabel lblValue = new JLabel("Value");
//		lblValue.setBounds(96, 1, 98, 22);
//		lblValue.setPreferredSize(new Dimension(98, 22));
//		lblValue.setOpaque(true);
//		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
//		lblValue.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
//		getContentPane().add(lblValue);
//
//		JLabel lblId = new JLabel("ID");
//		lblId.setBounds(1, 24, 94, 16);
//		lblId.setPreferredSize(new Dimension(94, 16));
//		lblId.setFocusable(false);
//		lblId.setOpaque(true);
//		lblId.setBackground(new Color(176, 224, 230));
//		lblId.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		getContentPane().add(lblId);
//
//		txtEid = new JTextField();
//		txtEid.setLocation(96, 24);
//		txtEid.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//		txtEid.setMargin(new Insets(0, 0, 0, 0));
//		txtEid.setSize(new Dimension(98, 16));
//		txtEid.setMinimumSize(new Dimension(6, 15));
//		txtEid.setPreferredSize(new Dimension(98, 16));
//		getContentPane().add(txtEid);
//
//		JLabel lblWcEvent = new JLabel("WC Event");
//		lblWcEvent.setBounds(1, 41, 94, 16);
//		lblWcEvent.setPreferredSize(new Dimension(94, 16));
//		lblWcEvent.setFocusable(false);
//		lblWcEvent.setOpaque(true);
//		lblWcEvent.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		lblWcEvent.setBackground(new Color(176, 224, 230));
//		getContentPane().add(lblWcEvent);
//
//		txtWCE = new JTextField();
//		txtWCE.setBounds(96, 41, 98, 16);
//		txtWCE.setMargin(new Insets(0, 0, 0, 0));
//		txtWCE.setPreferredSize(new Dimension(98, 16));
//		txtWCE.addKeyListener(suggestKeyListener);
//		getContentPane().add(txtWCE);
//
//		JLabel lblGaurd = new JLabel("Gaurd");
//		lblGaurd.setBounds(1, 58, 94, 16);
//		lblGaurd.setPreferredSize(new Dimension(94, 16));
//		lblGaurd.setFocusable(false);
//		lblGaurd.setOpaque(true);
//		lblGaurd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		lblGaurd.setBackground(new Color(176, 224, 230));
//		getContentPane().add(lblGaurd);
//
//		txtGuard = new JTextField();
//		txtGuard.setBounds(96, 58, 98, 16);
//		txtGuard.setMargin(new Insets(0, 0, 0, 0));
//		txtGuard.setPreferredSize(new Dimension(98, 16));
//		txtGuard.addMouseListener(doublClickListener(curFeature.getAttributes()));
//		getContentPane().add(txtGuard);
//
//		JLabel lblActionId = new JLabel("Action ID");
//		lblActionId.setBounds(1, 75, 94, 16);
//		lblActionId.setPreferredSize(new Dimension(94, 16));
//		lblActionId.setFocusable(false);
//		lblActionId.setOpaque(true);
//		lblActionId.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		lblActionId.setBackground(new Color(176, 224, 230));
//		getContentPane().add(lblActionId);
//
//		txtAid = new JTextField();
//		txtAid.setBounds(96, 75, 98, 16);
//		txtAid.setMargin(new Insets(0, 0, 0, 0));
//		txtAid.setPreferredSize(new Dimension(98, 16));
//		getContentPane().add(txtAid);
//
//		JLabel lblWcAction = new JLabel("WC Action");
//		lblWcAction.setBounds(1, 92, 94, 16);
//		lblWcAction.setPreferredSize(new Dimension(94, 16));
//		lblWcAction.setFocusable(false);
//		lblWcAction.setOpaque(true);
//		lblWcAction.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		lblWcAction.setBackground(new Color(176, 224, 230));
//		getContentPane().add(lblWcAction);
//
//		txtAction = new JTextField();
//		txtAction.setBounds(96, 92, 98, 16);
//		txtAction.setMargin(new Insets(0, 0, 0, 0));
//		txtAction.setPreferredSize(new Dimension(98, 16));
//		txtAction.addKeyListener(suggestKeyListener);
//		getContentPane().add(txtAction);
//
//		JLabel lblCondition = new JLabel("Condition");
//		lblCondition.setBounds(1, 109, 94, 16);
//		lblCondition.setPreferredSize(new Dimension(94, 16));
//		lblCondition.setFocusable(false);
//		lblCondition.setOpaque(true);
//		lblCondition.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		lblCondition.setBackground(new Color(176, 224, 230));
//		getContentPane().add(lblCondition);
//
//		txtCondition = new JTextField();
//		txtCondition.setBounds(96, 109, 98, 16);
//		txtCondition.setMargin(new Insets(0, 0, 0, 0));
//		txtCondition.setPreferredSize(new Dimension(98, 16));
//		txtCondition.addMouseListener(doublClickListener(curFeature.getAttributes()));
//		getContentPane().add(txtCondition);
//
//		txtPriority = new JComboBox();
//		txtPriority .setBounds(96, 109, 98, 16);
//
//		txtPriority .setPreferredSize(new Dimension(98, 16));
//		getContentPane().add(txtPriority );
//
//
//		setAlwaysOnTop(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setResizable(false);
//		setSize(new Dimension(200, 150));
//
//
//		this.setLocation(MouseInfo.getPointerInfo().getLocation());
//
//		addWindowListener(new WindowAdapter() 
//		{
//			public void windowClosing(WindowEvent e)
//			{
//				ConfirmFlag=true;
//			}
//
//
//		});
//
//		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
//				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, InputEvent.SHIFT_DOWN_MASK), "Cancel"); //$NON-NLS-1$
//		getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
//			public void actionPerformed(ActionEvent e)
//			{
//				ConfirmFlag=false;
//				dispose();
//			}
//		});
//
//
//	}
//
//
//	private void populateValues(EObject t) {
//
//		String tno="0";
//		try{
//
//			int i=0;
//			for(EObject eobj:t.eContainer().eContents())
//			{
//
//				if(eobj.getClass().equals(t.getClass()))
//				{
//
//					i++;
//				}
//			}
//
//			tno=String.valueOf(i);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//
//		txtEid.setText("t"+tno);
//		txtWCE.setText("WCE()+o");
//		txtGuard.setText("");
//		txtAid.setText("a1");
//		txtAction.setText("+WCA(o)");
//		txtCondition.setText("");
//
//
//	}

}
