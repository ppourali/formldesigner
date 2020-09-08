package uw.cs.watform.forml.services.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.eclipse.emf.common.util.EList;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;

public class FrmCustomTriggeringEventSelectionWizard extends JDialog {

	private JTextField txtSearchText;
	private JLabel lblError;
	private JTree tree;
	private DefaultTreeModel treeModel;

	private WorldModel wm;
	private Transition transition;

	JButton btnFinish;
	JButton btnCreate;

	public boolean ConfirmFlag = false;
	public boolean createFlag = false;

	public Message selectedOperation;
	private Feature parentFeature;

	public FrmCustomTriggeringEventSelectionWizard(WorldModel worldmodel, Transition tran, Feature feature) {

		this.wm = worldmodel;
		this.transition = tran;
		this.parentFeature = feature;

		ConstructDesign();

		MakeTree();
	}

	private void MakeTree() {

		btnFinish.setEnabled(false);
		btnCreate.setEnabled(false);

		// Fetch the root node
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
		root.removeAllChildren();
		root.setUserObject(wm);

		DefaultMutableTreeNode thisFeatureTreeNode = new DefaultMutableTreeNode();
		thisFeatureTreeNode.setUserObject(this.parentFeature);

		if (this.parentFeature.getInputlist() != null) {
			EList<RefMessage> messages = this.parentFeature.getInputlist().getInputs();
			for (RefMessage m : messages) {
				DefaultMutableTreeNode messageTreeNode = new DefaultMutableTreeNode();
				messageTreeNode.setUserObject(m.getRefMsg());

				thisFeatureTreeNode.insert(messageTreeNode, thisFeatureTreeNode.getChildCount());
			}
		}
		root.insert(thisFeatureTreeNode, root.getChildCount());

		List<Feature> features = ModelUtils.getObjectsByTypeInAnObjectElement(wm, Feature.class);
		for (Feature f : features) {
			if (this.parentFeature.equals(f))
				continue;

			DefaultMutableTreeNode featureTreeNode = new DefaultMutableTreeNode();
			featureTreeNode.setUserObject(f);

			if (f.getInputlist() != null) {
				EList<RefMessage> messages = f.getInputlist().getInputs();
				for (RefMessage m : messages) {
					DefaultMutableTreeNode messageTreeNode = new DefaultMutableTreeNode();
					messageTreeNode.setUserObject(m.getRefMsg());

					featureTreeNode.insert(messageTreeNode, featureTreeNode.getChildCount());
				}
			}
			root.insert(featureTreeNode, root.getChildCount());
		}

		treeModel.reload();
	}

	private void ConstructDesign() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCustomTriggeringEventSelectionWizard.class
				.getResource("/uw/cs/watform/forml/services/GUI/res/icon_SelectionWizard.png")));

		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Selection Wizard");
		setSize(new Dimension(429, 319));

		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// this.setLocation(dim.width/2-this.getSize().width/2,
		// dim.height/2-this.getSize().height/2);

		// pack();
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblSelectTheOperation = new JLabel("   Select an operation:");
		lblSelectTheOperation.setBounds(0, 0, 423, 60);
		lblSelectTheOperation.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblSelectTheOperation.setOpaque(true);
		lblSelectTheOperation.setBackground(Color.WHITE);
		lblSelectTheOperation.setPreferredSize(new Dimension(91, 60));
		lblSelectTheOperation.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblSelectTheOperation);

		JLabel lblEnterOperationName = new JLabel("Enter Operation Name:");
		lblEnterOperationName.setBounds(10, 71, 403, 14);
		getContentPane().add(lblEnterOperationName);

		txtSearchText = new JTextField();
		txtSearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				MakeTreeForSearch();
			}
		});
		txtSearchText.setBounds(10, 96, 403, 20);
		getContentPane().add(txtSearchText);
		txtSearchText.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 127, 403, 95);
		getContentPane().add(scrollPane);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("World Model");

		// Create the tree model and add the root node to it
		treeModel = new DefaultTreeModel(root);

		tree = new JTree(treeModel);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				// Returns the last path element of the selection.
				// This method is useful only when the selection model allows a
				// single selection.
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

				if (node == null) {
					btnCreate.setEnabled(true);
					// Nothing is selected.
					return;
				}

				Object nodeInfo = node.getUserObject();

				if (node.isLeaf()) {
					if (nodeInfo instanceof Message) {
						selectedOperation = (Message) nodeInfo;
						btnFinish.setEnabled(true);
						
					} else {
						selectedOperation = null;
						btnFinish.setEnabled(false);
						//btnCreate.setEnabled(false);
					}

				} else {
					selectedOperation = null;
					btnFinish.setEnabled(false);
					//btnCreate.setEnabled(false);
				}
				btnCreate.setEnabled(false);
			}
		});
		tree.setRowHeight(18);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		tree.setAutoscrolls(true);

		MyRendererForMessageSelection renderer = new MyRendererForMessageSelection(this.parentFeature);
		tree.setCellRenderer(renderer);
		scrollPane.setViewportView(tree);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 233, 403, 7);
		getContentPane().add(separator);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmFlag = false;
				hide();
			}
		});
		btnCancel.setBounds(324, 257, 89, 23);
		getContentPane().add(btnCancel);

		btnFinish = new JButton("Select");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmFlag = true;
				hide();
			}
		});
		btnFinish.setEnabled(false);
		btnFinish.setBounds(225, 257, 89, 23);
		getContentPane().add(btnFinish);

		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// String NewOperationNewName = txtSearchText.getText().replace(" ", "").trim();

				RefMessage newRefMessage = FormlFactory.eINSTANCE.createRefMessage();
				Message newMessage = null;
				newMessage = FormlFactory.eINSTANCE.createInput();
				((Input) newMessage).getTos().add(parentFeature);

				String newName = WorldModelCommonServices
						.parseMessageName(txtSearchText.getText().replace(" ", "").trim());

				if (NameUniquenessVerifier.verify(newMessage, newName, false)) {
					newMessage.setName(newName);

					ConfirmFlag = true;
					createFlag = true;
					selectedOperation = newMessage;
					hide();
				} else {
					lblError.setText("An operation with the name: " + newName + " already exists.");
				}

			}
		});
		btnCreate.setEnabled(false);
		btnCreate.setBounds(10, 257, 89, 23);
		getContentPane().add(btnCreate);

		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(12, 238, 401, 14);
		getContentPane().add(lblError);

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				"Cancel"); //$NON-NLS-1$
		getRootPane().getActionMap().put("Cancel", new AbstractAction() { //$NON-NLS-1$
			public void actionPerformed(ActionEvent e) {
				ConfirmFlag = false;
				dispose();
			}
		});

	}

	protected void MakeTreeForSearch() {

		lblError.setText("");

		btnFinish.setEnabled(false);
		btnCreate.setEnabled(false);

		selectedOperation = null;

		String SearchText = txtSearchText.getText().trim();
		if (SearchText.equals("")) {
			MakeTree();
		} else {

			DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
			root.removeAllChildren();
			root.setUserObject(wm);

			DefaultMutableTreeNode thisFeatureTreeNode = new DefaultMutableTreeNode();
			thisFeatureTreeNode.setUserObject(this.parentFeature);

			if (this.parentFeature.getInputlist() != null) {
				EList<RefMessage> messages = this.parentFeature.getInputlist().getInputs();
				for (RefMessage m : messages) {
					DefaultMutableTreeNode messageTreeNode = new DefaultMutableTreeNode();
					messageTreeNode.setUserObject(m.getRefMsg());

					thisFeatureTreeNode.insert(messageTreeNode, thisFeatureTreeNode.getChildCount());
				}
			}
			root.insert(thisFeatureTreeNode, root.getChildCount());

			List<Feature> features = ModelUtils.getObjectsByTypeInAnObjectElement(wm, Feature.class);
			for (Feature f : features) {
				if (this.parentFeature.equals(f))
					continue;

				DefaultMutableTreeNode featureTreeNode = new DefaultMutableTreeNode();
				featureTreeNode.setUserObject(f);

				if (f.getInputlist() != null) {
					EList<RefMessage> messages = f.getInputlist().getInputs();
					for (RefMessage m : messages) {
						DefaultMutableTreeNode messageTreeNode = new DefaultMutableTreeNode();
						messageTreeNode.setUserObject(m.getRefMsg());

						featureTreeNode.insert(messageTreeNode, featureTreeNode.getChildCount());
					}
				}
				root.insert(featureTreeNode, root.getChildCount());
			}

			treeModel.reload();

			if (root.getChildCount() != 1 && !SearchText.equals(""))
				btnCreate.setEnabled(true);
			else
				btnCreate.setEnabled(false);

		}
	}
}

class MyRendererForMessageSelection extends DefaultTreeCellRenderer {

	Icon messageIcon = new ImageIcon(FrmCustomTriggeringEventSelectionWizard.class
			.getResource("/uw/cs/watform/forml/services/GUI/res/icon_CreateFeature.png"));

	Icon featureIcon = new ImageIcon(FrmCustomTriggeringEventSelectionWizard.class
			.getResource("/uw/cs/watform/forml/services/GUI/res/icon_CreateFeatureMessage.png"));

	Feature parentFeature;

	public MyRendererForMessageSelection(Feature parentf) {
		this.parentFeature = parentf;
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		Object nodeObject = node.getUserObject();

		if (nodeObject instanceof Message) {
			setIcon(messageIcon);
		} else if ((nodeObject instanceof Feature)) {
			setIcon(featureIcon);
		}

		String nodeName = "";
		if (nodeObject instanceof Message)
			nodeName = "Operation: " + ((Message) nodeObject).getName();
		else if ((nodeObject instanceof Feature)) {
			if (nodeObject.equals(this.parentFeature))
				nodeName = "(this) " + ((Feature) nodeObject).getName();
			else
				nodeName = ((Feature) nodeObject).getName();
		} else
			nodeName = "WorldModel";

		return super.getTreeCellRendererComponent(tree, nodeName, sel, expanded, leaf, row, hasFocus);
	}
}