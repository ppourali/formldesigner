package uw.cs.watform.forml.services.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.services.rename.JS_Action_Rename_On_FeatureClass;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;

public class FrmSetCardinalityForCompositionAggregation extends JDialog {

	private JPopupMenu popup;

	private List<Attribute> suggestableAttributes;

	private int currRow;
	private JTextField txtWholeLower;
	private JTextField txtWholeUpper;
	private JCheckBox chckbxWholeRoleMultiplicity;
	private JCheckBox chckbxPartRoleMultiplicity;

	public boolean ConfirmFlag=false;

	private int wholeValue=-1;
	private String wholeMany="";
	private int wholeCardLower=-1;
	private int wholeCardUpper=-1;

	private int partValue=-1;
	private String partMany="";
	private int partCardLower=-1;
	private int partCardUpper=-1;


	private JTextField txtPartLower;
	private JTextField txtPartUpper;
	private JTextField txtName;

	public Multiplicity wholeMultiplicity,partMultiplicity;
	private Concept associationToBeEdited;

	public String AssociationName;
	public String WholeRoleName;
	public String PartRoleName;

	private JTextField txtWholeRoleName;
	private JTextField txtPartRoleName;

	/**
	 * @wbp.parser.constructor
	 */
	public FrmSetCardinalityForCompositionAggregation(Composition a) {

		constructPartign();


		setGlobalValues(a);



		setCurrentValues(wholeMultiplicity,partMultiplicity);
	}

	private void setGlobalValues(Composition a) {
		Multiplicity wholeMultiplicity=null;
		if(a.getWhole().getMultiplicity()!=null)
		{
			wholeMultiplicity=a.getWhole().getMultiplicity();
		}

		Multiplicity partMultiplicity=null;
		if(a.getPart().getMultiplicity()!=null)
		{
			partMultiplicity=a.getPart().getMultiplicity();
		}

		this.wholeMultiplicity=wholeMultiplicity;
		this.partMultiplicity=partMultiplicity;
		this.associationToBeEdited=a;

		AssociationName=a.getName();
		this.WholeRoleName=a.getWhole().getName();
		this.PartRoleName=a.getPart().getName();
	}


	public FrmSetCardinalityForCompositionAggregation(Aggregation a) {

		constructPartign();


		setGlobalValues(a);


		setCurrentValues(wholeMultiplicity,partMultiplicity);
	}

	private void setGlobalValues(Aggregation a) {
		Multiplicity wholeMultiplicity=null;
		if(a.getWhole().getMultiplicity()!=null)
		{
			wholeMultiplicity=a.getWhole().getMultiplicity();
		}

		Multiplicity partMultiplicity=null;
		if(a.getPart().getMultiplicity()!=null)
		{
			partMultiplicity=a.getPart().getMultiplicity();
		}

		this.wholeMultiplicity=wholeMultiplicity;
		this.partMultiplicity=partMultiplicity;
		this.associationToBeEdited=a;

		AssociationName=a.getName();
		this.WholeRoleName=a.getWhole().getName();
		this.PartRoleName=a.getPart().getName();
	}


	private void setCurrentValues(Multiplicity wholeMultiplicity,Multiplicity partMultiplicity) {

		txtName.setText(this.AssociationName);
		txtWholeRoleName.setText(this.WholeRoleName);
		txtPartRoleName.setText(this.PartRoleName);

		int wholeLower=0, wholeUpper=0;

		if(wholeMultiplicity!=null)
		{
			if(wholeMultiplicity.getCardinality()!=null)
			{
				wholeLower=wholeMultiplicity.getCardinality().getLower();
				if(wholeMultiplicity.getCardinality().getMany()!=null && wholeMultiplicity.getCardinality().getMany().trim()!="")
					wholeUpper=-1;
				else
					wholeUpper=wholeMultiplicity.getCardinality().getUpper();
			}
			else
			{
				if(wholeMultiplicity.getMany()!=null && wholeMultiplicity.getMany().trim()!="")
				{
					wholeUpper=-1;
				}
				else
				{
					wholeLower=wholeMultiplicity.getValue();
					wholeUpper=wholeMultiplicity.getValue();
				}
			}
		}
		else
			chckbxWholeRoleMultiplicity.setSelected(false);

		txtWholeLower.setText(String.valueOf(wholeLower));

		if (wholeUpper==-1)
			txtWholeUpper.setText("*");
		else
			txtWholeUpper.setText(String.valueOf(wholeUpper));


		// fill the partTextBox
		int partLower=0, partUpper=0;
		if(partMultiplicity!=null)
		{
			if(partMultiplicity.getCardinality()!=null){
				partLower=partMultiplicity.getCardinality().getLower();
				if(partMultiplicity.getCardinality().getMany()!=null && partMultiplicity.getCardinality().getMany().trim()!="")
					partUpper=-1;
				else
					partUpper=partMultiplicity.getCardinality().getUpper();
			}
			else
			{
				if(partMultiplicity.getMany()!=null && partMultiplicity.getMany().trim()!="")
				{
					partUpper=-1;
				}
				else
				{
					partLower=partMultiplicity.getValue();
					partUpper=partMultiplicity.getValue();
				}
			}
		}
		else
			chckbxPartRoleMultiplicity.setSelected(false);

		txtPartLower.setText(String.valueOf(partLower));

		if (partUpper==-1)
			txtPartUpper.setText("*");
		else
			txtPartUpper.setText(String.valueOf(partUpper));
	}


	private void constructPartign() {
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
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					if (verifyAndSetAssociationName())
					{
						AssociationName=txtName.getText().replace("", "");
						//java.lang.System.out.println(AssociationName);
						WholeRoleName=txtWholeRoleName.getText().trim();
						setResultsForWholeRole();

						PartRoleName=txtPartRoleName.getText().trim();
						setResultsForPartRole();
						ConfirmFlag=true;

						hide();
					}
				}
				catch(Exception excep)
				{
					excep.printStackTrace();
				}
			}
		});
		btnConfirm.setBounds(165, 189, 75, 23);
		getContentPane().add(btnConfirm);

		JButton btnCanel = new JButton("Cancel");
		btnCanel.setBounds(80, 189, 75, 23);
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmFlag=false;
				hide();
			}
		});
		getContentPane().add(btnCanel);

		JPanel panel = new JPanel();
		panel.setName("cardinality");
		panel.setBounds(10, 59, 145, 119);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLower = new JLabel("Lower");
		lblLower.setBounds(8, 66, 29, 14);
		panel.add(lblLower);
		lblLower.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblWholeRole = new JLabel("Whole Role");
		lblWholeRole.setBounds(10, 45, 75, 14);
		getContentPane().add(lblWholeRole);

		JLabel lblPartRole = new JLabel("Part Role");
		lblPartRole.setBounds(165, 45, 97, 14);
		getContentPane().add(lblPartRole);

		txtWholeLower = new JTextField();
		txtWholeLower.setBounds(47, 63, 86, 20);
		panel.add(txtWholeLower);
		txtWholeLower.setName("txtLower");
		txtWholeLower.setColumns(10);

		JLabel lblUpper = new JLabel("Upper");
		lblUpper.setBounds(8, 91, 29, 14);
		panel.add(lblUpper);
		lblUpper.setHorizontalAlignment(SwingConstants.RIGHT);

		txtWholeUpper = new JTextField();
		txtWholeUpper.setBounds(47, 88, 86, 20);
		txtWholeUpper.setToolTipText("enter -1 or * for Many");
		panel.add(txtWholeUpper);
		txtWholeUpper.setName("txtUpper");
		txtWholeUpper.setColumns(10);

		chckbxWholeRoleMultiplicity = new JCheckBox("Multiplicity");
		chckbxWholeRoleMultiplicity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				ActiveDeactiveTextBoxes();
			}
		});
		chckbxWholeRoleMultiplicity.setSelected(true);
		chckbxWholeRoleMultiplicity.setBounds(8, 39, 131, 23);
		panel.add(chckbxWholeRoleMultiplicity);

		txtWholeRoleName = new JTextField();
		txtWholeRoleName.addKeyListener(new KeyAdapter() {
			@java.lang.Override
			public void keyTyped(KeyEvent e) {
				if (txtWholeRoleName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else
					btnConfirm.setEnabled(true);
			}
		});
		txtWholeRoleName.setToolTipText("enter -1 or * for Many");
		txtWholeRoleName.setText((String) null);
		txtWholeRoleName.setPreferredSize(new Dimension(6, 15));
		txtWholeRoleName.setName("txtUpper");
		txtWholeRoleName.setMinimumSize(new Dimension(6, 15));
		txtWholeRoleName.setColumns(10);
		txtWholeRoleName.setBounds(49, 11, 86, 23);
		panel.add(txtWholeRoleName);

		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(8, 11, 31, 23);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setName("cardinality");
		panel_1.setBounds(165, 59, 145, 119);
		getContentPane().add(panel_1);

		JLabel label_1 = new JLabel("Lower");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(6, 66, 29, 14);
		panel_1.add(label_1);

		txtPartLower = new JTextField();
		txtPartLower.setText("0");
		txtPartLower.setName("txtLower");
		txtPartLower.setColumns(10);
		txtPartLower.setBounds(45, 63, 86, 20);
		panel_1.add(txtPartLower);

		JLabel label_2 = new JLabel("Upper");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(6, 91, 29, 14);
		panel_1.add(label_2);

		txtPartUpper = new JTextField();
		txtPartUpper.setToolTipText("enter -1 or * for Many");
		txtPartUpper.setName("txtUpper");
		txtPartUpper.setColumns(10);
		txtPartUpper.setBounds(45, 88, 86, 20);
		panel_1.add(txtPartUpper);

		chckbxPartRoleMultiplicity = new JCheckBox("Multiplicity");
		chckbxPartRoleMultiplicity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ActiveDeactiveTextBoxes();
			}
		});
		chckbxPartRoleMultiplicity.setSelected(true);
		chckbxPartRoleMultiplicity.setBounds(6, 39, 129, 23);
		panel_1.add(chckbxPartRoleMultiplicity);

		txtPartRoleName = new JTextField();
		txtPartRoleName.addKeyListener(new KeyAdapter() {
			@java.lang.Override
			public void keyTyped(KeyEvent e) {
				if (txtPartRoleName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else
					btnConfirm.setEnabled(true);
			}
		});
		txtPartRoleName.setToolTipText("enter -1 or * for Many");
		txtPartRoleName.setText((String) null);
		txtPartRoleName.setPreferredSize(new Dimension(6, 15));
		txtPartRoleName.setName("txtUpper");
		txtPartRoleName.setMinimumSize(new Dimension(6, 15));
		txtPartRoleName.setColumns(10);
		txtPartRoleName.setBounds(49, 11, 86, 23);
		panel_1.add(txtPartRoleName);

		JLabel label_3 = new JLabel("Name");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(8, 11, 31, 23);
		panel_1.add(label_3);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@java.lang.Override
			public void keyTyped(KeyEvent e) {
				if (txtName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else
					btnConfirm.setEnabled(true);
			}
		});
		txtName.setToolTipText("enter -1 or * for Many");
		txtName.setText((String) null);
		txtName.setName("txtUpper");
		txtName.setColumns(10);
		txtName.setBounds(141, 11, 121, 23);
		getContentPane().add(txtName);

		JLabel lblAssociationName = new JLabel("Association Name:");
		lblAssociationName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAssociationName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAssociationName.setBounds(10, 11, 121, 23);
		getContentPane().add(lblAssociationName);



		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(324, 245));

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

	protected boolean verifyAndSetAssociationName() {

		if(associationToBeEdited instanceof Composition)
		{
			return NameUniquenessVerifier.verify((Composition)associationToBeEdited, txtName.getText().replace(" ", ""));	
		}
		else if(associationToBeEdited instanceof Aggregation)
		{
			return NameUniquenessVerifier.verify((Aggregation)associationToBeEdited, txtName.getText().replace(" ", ""));	
		}

		return false;
		//		for(ExprRef c:ModelUtils.RootFinderForWorldModel(associationToBeEdited).getConcepts())
		//		{
		//			if(c instanceof Concept){
		//				if (((Concept)c).getName().equals(txtName.getText().trim()))
		//				{
		//					if (((c instanceof Composition) ||(c instanceof Aggregation)) && !(c.equals(associationToBeEdited))){
		//						JOptionPane.showMessageDialog(this,"An Association with the defined name already exists. Please Change the name." );
		//						return false;
		//					}
		//				}
		//			}
		//		}
		//AssociationName=txtName.getText();
		//return true;
	}

	protected void ActiveDeactiveTextBoxes() {
		try{
			txtWholeLower.setEnabled(chckbxWholeRoleMultiplicity.isSelected());
			txtWholeUpper.setEnabled(chckbxWholeRoleMultiplicity.isSelected());

			txtPartLower.setEnabled(chckbxPartRoleMultiplicity.isSelected());
			txtPartUpper.setEnabled(chckbxPartRoleMultiplicity.isSelected());
		}
		catch(NullPointerException npe){

		}
	}

	private void setResultsForWholeRole(){

		// whole Cardinality
		if(	chckbxWholeRoleMultiplicity.isSelected() && !(txtWholeLower.getText().trim().equals("0") && txtWholeUpper.getText().trim().equals("0")))
		{
			boolean wholeCardLowerSetTocardUpperFlag=false;

			if(txtWholeLower.getText().trim().equals(""))
			{
				if(! txtWholeUpper.getText().trim().equals(""))
				{
					wholeCardLowerSetTocardUpperFlag=true;
				}
				else 
					wholeCardLower=0;
			}
			else
			{
				wholeCardLower=(Integer.parseInt(txtWholeLower.getText()));	
			}

			if(txtWholeUpper.getText().trim().equals(""))
			{
				if(wholeCardLower>=0)
				{
					wholeCardUpper=wholeCardLower;
				}
				else
					wholeCardUpper=0;
			}
			else if (txtWholeUpper.getText().trim().equals("*"))
			{
				wholeMany="*";
			}
			else if (txtWholeUpper.getText().trim().equals("-1"))
			{
				wholeMany="*";
			}
			else
			{
				wholeCardUpper=(Integer.parseInt(txtWholeUpper.getText()));

				if (wholeCardUpper<wholeCardLower)
				{
					JOptionPane.showMessageDialog(null, "Upper Bound cannot be less that the Lower Bound.");
					return;
				}

				if(wholeCardLowerSetTocardUpperFlag)
					wholeCardLower=wholeCardUpper;
			}


			Multiplicity newMultiplicity=FormlFactory.eINSTANCE.createMultiplicity();

			if(this.wholeMany.equals("*") && this.wholeCardLower==-1)
			{
				newMultiplicity.setMany("*");
			}
			else
			{
				if (this.wholeCardLower==this.wholeCardUpper)
				{					
					newMultiplicity.setValue(this.wholeCardLower);
				}
				else
				{
					Cardinality cardinality=FormlFactory.eINSTANCE.createCardinality();
					cardinality.setLower(this.wholeCardLower);
					if(this.wholeCardUpper==-1)
						cardinality.setMany("*");
					else
						cardinality.setUpper(this.wholeCardUpper);


					newMultiplicity.setCardinality(cardinality);
				}
			}

			wholeMultiplicity=newMultiplicity;
		}
		else
			wholeMultiplicity=null;
	}

	private void setResultsForPartRole(){

		if(	chckbxPartRoleMultiplicity.isSelected() && !(txtPartLower.getText().trim().equals("0") && txtPartUpper.getText().trim().equals("0")))
		{
			// part Cardinality
			boolean partCardLowerSetTocardUpperFlag=false;

			if(txtPartLower.getText().trim().equals(""))
			{
				if(! txtPartUpper.getText().trim().equals(""))
				{
					partCardLowerSetTocardUpperFlag=true;
				}
				else 
					partCardLower=0;
			}
			else
			{
				partCardLower=(Integer.parseInt(txtPartLower.getText()));	
			}

			if(txtPartUpper.getText().trim().equals(""))
			{
				if(partCardLower>=0)
				{
					partCardUpper=partCardLower;
				}
				else
					partCardUpper=0;
			}
			else if (txtPartUpper.getText().trim().equals("*"))
			{
				partMany="*";
			}
			else if (txtPartUpper.getText().trim().equals("-1"))
			{
				partMany="*";
			}
			else
			{
				partCardUpper=(Integer.parseInt(txtPartUpper.getText()));

				if (partCardUpper<partCardLower)
				{
					JOptionPane.showMessageDialog(null, "Upper Bound cannot be less that the Lower Bound.");
					return;
				}

				if(partCardLowerSetTocardUpperFlag)
					partCardLower=partCardUpper;
			}


			Multiplicity newMultiplicity=FormlFactory.eINSTANCE.createMultiplicity();

			if(this.partMany.equals("*") && this.partCardLower==-1)
			{
				newMultiplicity.setMany("*");
			}
			else
			{
				if (this.partCardLower==this.partCardUpper)
				{
					newMultiplicity.setValue(this.partCardLower);
				}
				else
				{
					Cardinality cardinality=FormlFactory.eINSTANCE.createCardinality();
					cardinality.setLower(this.partCardLower);
					if(this.partCardUpper==-1)
						cardinality.setMany("*");
					else
						cardinality.setUpper(this.partCardUpper);


					newMultiplicity.setCardinality(cardinality);
				}
			}
			partMultiplicity=newMultiplicity;
		}
		else
			partMultiplicity=null;


	}
}

