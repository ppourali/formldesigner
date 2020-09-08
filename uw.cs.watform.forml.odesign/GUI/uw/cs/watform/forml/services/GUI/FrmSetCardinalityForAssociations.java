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

import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;;


public class FrmSetCardinalityForAssociations extends JDialog {

	private JPopupMenu popup;

	private List<Attribute> suggestableAttributes;

	private int currRow;
	private JTextField txtSrcLower;
	private JTextField txtSrcUpper;
	private JCheckBox chckbxSourceRoleMultiplicity;
	private JCheckBox chckbxDestinationRoleMultiplicity;

	public boolean ConfirmFlag=false;

	private int srcValue=-1;
	private String srcMany="";
	private int srcCardLower=-1;
	private int srcCardUpper=-1;

	private int desValue=-1;
	private String desMany="";
	private int desCardLower=-1;
	private int desCardUpper=-1;


	private JTextField txtDesLower;
	private JTextField txtDesUpper;
	private JTextField txtName;

	public Multiplicity sourceMultiplicity,destinationMultiplicity;
	private Concept associationToBeEdited;

	public String AssociationName="";
	public String SourceRoleName="";
	public String DestinationRoleName="";

	private JTextField txtSrcRoleName;
	private JTextField txtDesRoleName;

	public FrmSetCardinalityForAssociations(Association a) {

		Multiplicity srcMultiplicity=null;
		if(a.getSrcRole().getMultiplicity()!=null)
		{
			srcMultiplicity=a.getSrcRole().getMultiplicity();
		}


		Multiplicity desMultiplicity=null;
		if(a.getDesRole().getMultiplicity()!=null)
		{
			desMultiplicity=a.getDesRole().getMultiplicity();
		}


		constructDesign();

		this.associationToBeEdited=a;

		this.sourceMultiplicity=srcMultiplicity;
		this.destinationMultiplicity=desMultiplicity;



		AssociationName=a.getName();
		this.SourceRoleName=a.getSrcRole().getName();
		this.DestinationRoleName=a.getDesRole().getName();


		setCurrentValues( srcMultiplicity,desMultiplicity);
	}


	private void setCurrentValues( Multiplicity srcMultiplicity,Multiplicity desMultiplicity) {

		txtName.setText(this.AssociationName);
		txtSrcRoleName.setText(this.SourceRoleName);
		txtDesRoleName.setText(this.DestinationRoleName);

		int srcLower=0, srcUpper=0;

		if(srcMultiplicity!=null)
		{
			if(srcMultiplicity.getCardinality()!=null)
			{
				srcLower=srcMultiplicity.getCardinality().getLower();
				if(srcMultiplicity.getCardinality().getMany()!=null && srcMultiplicity.getCardinality().getMany().trim()!="")
					srcUpper=-1;
				else
					srcUpper=srcMultiplicity.getCardinality().getUpper();
			}
			else
			{
				if(srcMultiplicity.getMany()!=null && srcMultiplicity.getMany().trim()!="")
				{
					srcUpper=-1;
				}
				else
				{
					srcLower=srcMultiplicity.getValue();
					srcUpper=srcMultiplicity.getValue();
				}
			}
		}
		else
			chckbxSourceRoleMultiplicity.setSelected(false);
		txtSrcLower.setText(String.valueOf(srcLower));

		if (srcUpper==-1)
			txtSrcUpper.setText("*");
		else
			txtSrcUpper.setText(String.valueOf(srcUpper));


		// fill the desTextBox
		int desLower=0, desUpper=0;
		if(desMultiplicity!=null)
		{
			if(desMultiplicity.getCardinality()!=null){
				desLower=desMultiplicity.getCardinality().getLower();
				if(desMultiplicity.getCardinality().getMany()!=null && desMultiplicity.getCardinality().getMany().trim()!="")
					desUpper=-1;
				else
					desUpper=desMultiplicity.getCardinality().getUpper();
			}
			else
			{
				if(desMultiplicity.getMany()!=null && desMultiplicity.getMany().trim()!="")
				{
					desUpper=-1;
				}
				else
				{
					desLower=desMultiplicity.getValue();
					desUpper=desMultiplicity.getValue();
				}
			}
		}
		else
			chckbxDestinationRoleMultiplicity.setSelected(false);
		txtDesLower.setText(String.valueOf(desLower));

		if (desUpper==-1)
			txtDesUpper.setText("*");
		else
			txtDesUpper.setText(String.valueOf(desUpper));
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
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					if (verifyAndSetAssociationName())
					{
						AssociationName=txtName.getText().replace("", "");

						SourceRoleName=txtSrcRoleName.getText().trim();
						setResultsForSrcRole();

						DestinationRoleName=txtDesRoleName.getText().trim();
						setResultsForDesRole();

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
		btnConfirm.setBounds(165, 185, 75, 23);
		getContentPane().add(btnConfirm);

		JButton btnCanel = new JButton("Cancel");
		btnCanel.setBounds(80, 185, 75, 23);
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmFlag=false;
				hide();
			}
		});
		getContentPane().add(btnCanel);

		JPanel panel = new JPanel();
		panel.setName("cardinality");
		panel.setBounds(10, 55, 145, 119);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLower = new JLabel("Lower");
		lblLower.setBounds(10, 68, 29, 14);
		panel.add(lblLower);
		lblLower.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblSourceRole = new JLabel("Source Role");
		lblSourceRole.setBounds(10, 41, 75, 14);
		getContentPane().add(lblSourceRole);

		JLabel lblDestinationRole = new JLabel("Destination Role");
		lblDestinationRole.setBounds(165, 41, 97, 14);
		getContentPane().add(lblDestinationRole);

		txtSrcLower = new JTextField();
		txtSrcLower.setBounds(49, 65, 86, 20);
		panel.add(txtSrcLower);
		txtSrcLower.setName("txtLower");
		txtSrcLower.setColumns(10);

		JLabel lblUpper = new JLabel("Upper");
		lblUpper.setBounds(10, 93, 29, 14);
		panel.add(lblUpper);
		lblUpper.setHorizontalAlignment(SwingConstants.RIGHT);

		txtSrcUpper = new JTextField();
		txtSrcUpper.setBounds(49, 90, 86, 20);
		txtSrcUpper.setToolTipText("enter -1 or * for Many");
		panel.add(txtSrcUpper);
		txtSrcUpper.setName("txtUpper");
		txtSrcUpper.setColumns(10);

		chckbxSourceRoleMultiplicity = new JCheckBox("Multiplicity");
		chckbxSourceRoleMultiplicity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ActiveDeactiveTextBoxes();
			}
		});
		chckbxSourceRoleMultiplicity.setSelected(true);
		chckbxSourceRoleMultiplicity.setBounds(10, 41, 129, 23);
		panel.add(chckbxSourceRoleMultiplicity);

		txtSrcRoleName = new JTextField();
		txtSrcRoleName.addKeyListener(new KeyAdapter() {
			@java.lang.Override
			public void keyTyped(KeyEvent e) {
				if (txtSrcRoleName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else
					btnConfirm.setEnabled(true);
			}
		});
		txtSrcRoleName.setToolTipText("enter -1 or * for Many");
		txtSrcRoleName.setText((String) null);
		txtSrcRoleName.setName("txtUpper");
		txtSrcRoleName.setColumns(10);
		txtSrcRoleName.setBounds(49, 11, 86, 23);
		panel.add(txtSrcRoleName);

		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName_1.setBounds(10, 11, 29, 23);
		panel.add(lblName_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setName("cardinality");
		panel_1.setBounds(165, 55, 145, 119);
		getContentPane().add(panel_1);

		JLabel label_1 = new JLabel("Lower");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 66, 29, 14);
		panel_1.add(label_1);

		txtDesLower = new JTextField();
		txtDesLower.setMinimumSize(new Dimension(6, 15));
		txtDesLower.setPreferredSize(new Dimension(6, 15));
		txtDesLower.setText("0");
		txtDesLower.setName("txtLower");
		txtDesLower.setColumns(10);
		txtDesLower.setBounds(51, 63, 86, 20);
		panel_1.add(txtDesLower);

		JLabel label_2 = new JLabel("Upper");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(12, 91, 29, 14);
		panel_1.add(label_2);

		txtDesUpper = new JTextField();
		txtDesUpper.setMinimumSize(new Dimension(6, 15));
		txtDesUpper.setPreferredSize(new Dimension(6, 15));
		txtDesUpper.setToolTipText("enter -1 or * for Many");
		txtDesUpper.setName("txtUpper");
		txtDesUpper.setColumns(10);
		txtDesUpper.setBounds(51, 88, 86, 20);
		panel_1.add(txtDesUpper);

		chckbxDestinationRoleMultiplicity = new JCheckBox("Multiplicity");
		chckbxDestinationRoleMultiplicity.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ActiveDeactiveTextBoxes();
			}
		});
		chckbxDestinationRoleMultiplicity.setSelected(true);
		chckbxDestinationRoleMultiplicity.setBounds(6, 39, 133, 23);
		panel_1.add(chckbxDestinationRoleMultiplicity);

		txtDesRoleName = new JTextField();
		txtDesRoleName.addKeyListener(new KeyAdapter() {
			@java.lang.Override
			public void keyTyped(KeyEvent e) {
				if (txtDesRoleName.getText().trim().equals(""))
					btnConfirm.setEnabled(false);
				else
					btnConfirm.setEnabled(true);
			}
		});
		txtDesRoleName.setMinimumSize(new Dimension(6, 15));
		txtDesRoleName.setPreferredSize(new Dimension(6, 15));
		txtDesRoleName.setToolTipText("enter -1 or * for Many");
		txtDesRoleName.setText((String) null);
		txtDesRoleName.setName("txtUpper");
		txtDesRoleName.setColumns(10);
		txtDesRoleName.setBounds(51, 9, 86, 23);
		panel_1.add(txtDesRoleName);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 9, 31, 23);
		panel_1.add(lblName);

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
		setSize(new Dimension(323, 243));

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

		return NameUniquenessVerifier.verify((Association)associationToBeEdited, txtName.getText().replace(" ", ""));	
		
//		
//		for(ExprRef c:ModelUtils.RootFinderForWorldModel(associationToBeEdited).getConcepts())
//		{
//			if(c instanceof Concept){
//				if (((Concept)c).getName().equals(txtName.getText().trim()))
//				{
//					if ((c instanceof Association) && !(c.equals(associationToBeEdited))){
//						JOptionPane.showMessageDialog(this,"An Association with the defined name already exists. Please Change the name." );
//						return false;
//					}
//				}
//			}
//		}
//
//		AssociationName=txtName.getText();
//		return true;
	}


	protected void ActiveDeactiveTextBoxes() {
		try{
			txtSrcLower.setEnabled(chckbxSourceRoleMultiplicity.isSelected());
			txtSrcUpper.setEnabled(chckbxSourceRoleMultiplicity.isSelected());

			txtDesLower.setEnabled(chckbxDestinationRoleMultiplicity.isSelected());
			txtDesUpper.setEnabled(chckbxDestinationRoleMultiplicity.isSelected());
		}
		catch(NullPointerException npe){

		}
	}

	private void setResultsForSrcRole(){

		// src Cardinality
		if(	chckbxSourceRoleMultiplicity.isSelected() && !(txtSrcLower.getText().trim().equals("0") && txtSrcUpper.getText().trim().equals("0")))
		{
			boolean srcCardLowerSetTocardUpperFlag=false;

			if(txtSrcLower.getText().trim().equals(""))
			{
				if(! txtSrcUpper.getText().trim().equals(""))
				{
					srcCardLowerSetTocardUpperFlag=true;
				}
				else 
					srcCardLower=0;
			}
			else
			{
				srcCardLower=(Integer.parseInt(txtSrcLower.getText()));	
			}

			if(txtSrcUpper.getText().trim().equals(""))
			{
				if(srcCardLower>=0)
				{
					srcCardUpper=srcCardLower;
				}
				else
					srcCardUpper=0;
			}
			else if (txtSrcUpper.getText().trim().equals("*"))
			{
				srcMany="*";
			}
			else if (txtSrcUpper.getText().trim().equals("-1"))
			{
				srcMany="*";
			}
			else
			{
				srcCardUpper=(Integer.parseInt(txtSrcUpper.getText()));

				if (srcCardUpper<srcCardLower)
				{
					JOptionPane.showMessageDialog(null, "Upper Bound cannot be less that the Lower Bound.");
					return;
				}

				if(srcCardLowerSetTocardUpperFlag)
					srcCardLower=srcCardUpper;
			}


			Multiplicity newMultiplicity=FormlFactory.eINSTANCE.createMultiplicity();

			if(this.srcMany.equals("*") && this.srcCardLower==-1)
			{
				newMultiplicity.setMany("*");
			}
			else
			{
				if (this.srcCardLower==this.srcCardUpper)
				{
					newMultiplicity.setValue(this.srcCardLower);
				}
				else
				{
					Cardinality cardinality=FormlFactory.eINSTANCE.createCardinality();
					cardinality.setLower(this.srcCardLower);
					if(this.srcCardUpper==-1)
						cardinality.setMany("*");
					else
						cardinality.setUpper(this.srcCardUpper);


					newMultiplicity.setCardinality(cardinality);
				}
			}

			sourceMultiplicity=newMultiplicity;
		}
		else
			sourceMultiplicity=null;
	}

	private void setResultsForDesRole(){

		// des Cardinality
		if(	chckbxDestinationRoleMultiplicity.isSelected() && !(txtDesLower.getText().trim().equals("0") && txtDesUpper.getText().trim().equals("0")))
		{
			boolean desCardLowerSetTocardUpperFlag=false;

			if(txtDesLower.getText().trim().equals(""))
			{
				if(! txtDesUpper.getText().trim().equals(""))
				{
					desCardLowerSetTocardUpperFlag=true;
				}
				else 
					desCardLower=0;
			}
			else
			{
				desCardLower=(Integer.parseInt(txtDesLower.getText()));	
			}

			if(txtDesUpper.getText().trim().equals(""))
			{
				if(desCardLower>=0)
				{
					desCardUpper=desCardLower;
				}
				else
					desCardUpper=0;
			}
			else if (txtDesUpper.getText().trim().equals("*"))
			{
				desMany="*";
			}
			else if (txtDesUpper.getText().trim().equals("-1"))
			{
				desMany="*";
			}
			else
			{
				desCardUpper=(Integer.parseInt(txtDesUpper.getText()));

				if (desCardUpper<desCardLower)
				{
					JOptionPane.showMessageDialog(null, "Upper Bound cannot be less that the Lower Bound.");
					return;
				}

				if(desCardLowerSetTocardUpperFlag)
					desCardLower=desCardUpper;
			}


			Multiplicity newMultiplicity=FormlFactory.eINSTANCE.createMultiplicity();

			if(this.desMany.equals("*") && this.desCardLower==-1)
			{
				newMultiplicity.setMany("*");
			}
			else
			{
				if (this.desCardLower==this.desCardUpper)
				{
					newMultiplicity.setValue(desCardLower);
				}
				else
				{
					Cardinality cardinality=FormlFactory.eINSTANCE.createCardinality();
					cardinality.setLower(this.desCardLower);
					if(this.desCardUpper==-1)
						cardinality.setMany("*");
					else
						cardinality.setUpper(this.desCardUpper);


					newMultiplicity.setCardinality(cardinality);
				}
			}
			destinationMultiplicity=newMultiplicity;
		}
		else
			destinationMultiplicity=null;
	}
}

