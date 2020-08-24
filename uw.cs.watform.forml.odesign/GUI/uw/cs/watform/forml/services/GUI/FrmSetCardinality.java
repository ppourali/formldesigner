package uw.cs.watform.forml.services.GUI;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.awt.MouseInfo;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.forml.impl.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;;


public class FrmSetCardinality extends JDialog {

	private JPopupMenu popup;

	private List<Attribute> suggestableAttributes;

	private int currRow;
	private JTextField txtLower;
	private JTextField txtUpper;


	public boolean ConfirmFlag=false;

	public int Value=-1;
	public String Many="";
	public int cardLower=-1;
	public int cardUpper=-1;

	public FrmSetCardinality(int lower, int upper) {

		constructDesign();

		setCurrentValues(lower, upper);
	}


	private void setCurrentValues(int lower, int upper) {
		txtLower.setText(String.valueOf(lower));
		
		if (upper==-1)
			txtUpper.setText("*");
		else
			txtUpper.setText(String.valueOf(upper));

	}


	private void constructDesign() {
		// TODO Auto-generated method stub
		setType(Type.UTILITY);
		getContentPane().setBackground(new Color(255, 239, 213));
		setModal(true);
		setBackground(new Color(173, 216, 230));
		getContentPane().setForeground(new Color(173, 216, 230));

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

		getContentPane().setLayout(null);
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setResultsAndExit();
			}
		});
		button.setBounds(91, 101, 75, 23);
		getContentPane().add(button);

		JButton btnCanel = new JButton("Cancel");
		btnCanel.setBounds(10, 101, 75, 23);
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmFlag=false;
				hide();
			}
		});
		getContentPane().add(btnCanel);

		JPanel panel = new JPanel();
		panel.setName("cardinality");
		panel.setBounds(10, 11, 156, 69);
		getContentPane().add(panel);

		JLabel lblLower = new JLabel("Lower");
		panel.add(lblLower);
		lblLower.setHorizontalAlignment(SwingConstants.RIGHT);


		txtLower = new JTextField();
		panel.add(txtLower);
		txtLower.setName("txtLower");
		txtLower.setColumns(10);

		JLabel lblUpper = new JLabel("Upper");
		panel.add(lblUpper);
		lblUpper.setHorizontalAlignment(SwingConstants.RIGHT);

		txtUpper = new JTextField();
		txtUpper.setToolTipText("enter -1 or * for Many");
		panel.add(txtUpper);
		txtUpper.setName("txtUpper");
		txtUpper.setColumns(10);



		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(184, 156));

		this.setLocation(MouseInfo.getPointerInfo().getLocation());

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
		getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
			public void actionPerformed(ActionEvent e)
			{
				ConfirmFlag=false;
				dispose();
			}
		});
	}

	private void setResultsAndExit(){

		try{

			boolean cardLowerSetTocardUpperFlag=false;
			
			if(txtLower.getText().trim().equals(""))
			{
				if(! txtUpper.getText().trim().equals(""))
				{
					cardLowerSetTocardUpperFlag=true;
				}
				else 
					cardLower=0;
			}
			else
			{
				cardLower=(Integer.parseInt(txtLower.getText()));	
			}

			if(txtUpper.getText().trim().equals(""))
			{
				if(cardLower>=0)
				{
					cardUpper=cardLower;
				}
				else
					cardUpper=0;
			}
			else if (txtUpper.getText().trim().equals("*"))
			{
				Many="*";
			}
			else if (txtUpper.getText().trim().equals("-1"))
			{
				Many="*";
			}
			else
			{
				cardUpper=(Integer.parseInt(txtUpper.getText()));

				if (cardUpper<cardLower)
				{
					JOptionPane.showMessageDialog(null, "Upper Bound cannot be less that the Lower Bound.");
					return;
				}
				
				if(cardLowerSetTocardUpperFlag)
					cardLower=cardUpper;
			}

			ConfirmFlag=true;
			hide();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please check the inputs.");
		}
	}
}

