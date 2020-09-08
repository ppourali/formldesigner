package uw.cs.watform.forml.services.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.utilities.ModelUtils;;


public class FrmConfirmMessageDelete extends JDialog {

	private JTextField txtMsgName;
	private JTable tblAttributes;

	private DefaultTableModel tableModel;

	public Message newMessage=FormlFactory.eINSTANCE.createMessage();

	Message msg=FormlFactory.eINSTANCE.createMessage();
	Collection<EObject> crossReferences;
	public boolean confirmFlag=false;


	public FrmConfirmMessageDelete(Message refMsg, Collection<EObject> crossRefs) {
		setTitle("Delete Message");

		this.msg=refMsg;
		this.crossReferences=crossRefs;
		constructDesign();
		fillTableModel();
		txtMsgName.setText(refMsg.getName());
	}


	private void fillTableModel() {
		List<Transition> alreaddyAdded=new ArrayList<Transition>();

		for(EObject ref:crossReferences)
		{

			Transition parentTransition=ModelUtils.getTypedRootForObject(ref, Transition.class);

			if(parentTransition!=null)
			{
				if(! alreaddyAdded.contains(parentTransition))
				{
					FeatureModule fm=ModelUtils.getTypedRootForObject(parentTransition, FeatureModule.class);
					String text=ModelUtils.getTextForModelObjects(parentTransition);
					
					tableModel.addRow(new Object[]{ fm.getFeatureref().getName(),text});
					alreaddyAdded.add(parentTransition);
				}
			}
		}
		
		tblAttributes.setModel(tableModel);
		tblAttributes.getColumnModel().getColumn(0).setResizable(false);
		tblAttributes.getColumnModel().getColumn(0).setPreferredWidth(45);
	}


	private void constructDesign() {
		// TODO Auto-generated method stub

		setType(Type.UTILITY);
		setModal(true);
		setAlwaysOnTop(true);
		getContentPane().setBackground(new Color(255, 239, 213));
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
				confirmFlag=true;
				dispose();
			}
		});
		btnConfirm.setBounds(175, 184, 75, 23);
		getContentPane().add(btnConfirm);

		JButton btnCanel = new JButton("Cancel");
		btnCanel.setBounds(90, 184, 75, 23);
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmFlag=false;
				dispose();
			}
		});
		getContentPane().add(btnCanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 45, 316, 128);
		getContentPane().add(scrollPane);

		tblAttributes = new JTable();
		tblAttributes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAttributes);
		tblAttributes.setBackground(new Color(176, 224, 230));
		tblAttributes.setName("tblAtts");
		tblAttributes.setPreferredSize(new Dimension(100, 100));
		tblAttributes.setRowSelectionAllowed(false);

		tableModel= new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Feature","Transition"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};



		JLabel lblMessageName = new JLabel("Message Name:");
		lblMessageName.setBounds(10, 11, 95, 23);
		getContentPane().add(lblMessageName);
		lblMessageName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMessageName.setHorizontalAlignment(SwingConstants.TRAILING);

		txtMsgName = new JTextField();
		txtMsgName.setEnabled(false);
		
		txtMsgName.setBounds(115, 11, 121, 23);
		getContentPane().add(txtMsgName);


		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(342, 242));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
		getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
			public void actionPerformed(ActionEvent e)
			{
				confirmFlag=false;
				dispose();
			}
		});
	}


}

