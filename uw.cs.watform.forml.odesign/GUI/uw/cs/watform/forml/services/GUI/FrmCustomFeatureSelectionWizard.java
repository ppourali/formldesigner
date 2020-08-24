package uw.cs.watform.forml.services.GUI;

import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Dimension;
import java.awt.Window.Type;
import java.util.List;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.utilities.ModelUtils;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.TextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

public class FrmCustomFeatureSelectionWizard extends JDialog {

	private JTextField txtSearchText;
	private JLabel lblError;
	private JTree tree;
	private DefaultTreeModel treeModel;

	private WorldModel wm;

	JButton btnFinish;
	JButton btnCreate;

	public boolean ConfirmFlag = false;
	public boolean createFlag = false;

	public Feature selectedFeature;

	public FrmCustomFeatureSelectionWizard(WorldModel worldmodel) {

		this.wm = worldmodel;

		ConstructDesign();

		MakeTree();
	}

	private void MakeTree() {

		btnFinish.setEnabled(false);
		btnCreate.setEnabled(false);

		List<EObject> features = ModelUtils.getFeaturesWithoutFeatureModules(wm);

		// Fetch the root node
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
		root.removeAllChildren();
		root.setUserObject(wm);

		for (EObject f : features) {
			DefaultMutableTreeNode featureTreeNode = new DefaultMutableTreeNode();
			featureTreeNode.setUserObject(f);

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

		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCustomFeatureSelectionWizard.class
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

		JLabel lblSelectTheFeature = new JLabel("   Select the feature:");
		lblSelectTheFeature.setBounds(0, 0, 423, 60);
		lblSelectTheFeature.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblSelectTheFeature.setOpaque(true);
		lblSelectTheFeature.setBackground(Color.WHITE);
		lblSelectTheFeature.setPreferredSize(new Dimension(91, 60));
		lblSelectTheFeature.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblSelectTheFeature);

		JLabel lblEnterFeatureName = new JLabel("Enter Feature Name:");
		lblEnterFeatureName.setBounds(10, 71, 108, 14);
		getContentPane().add(lblEnterFeatureName);

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
					selectedFeature = (Feature) nodeInfo;
					btnFinish.setEnabled(true);
					btnCreate.setEnabled(false);

				} else {
					selectedFeature = null;
					btnFinish.setEnabled(false);
					btnCreate.setEnabled(true);

				}

			}
		});
		tree.setRowHeight(18);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		tree.setAutoscrolls(true);

		Icon leafIcon = new ImageIcon(FrmCustomFeatureSelectionWizard.class
				.getResource("/uw/cs/watform/forml/services/GUI/res/icon_SelectionWizardItems.png"));

		MyRendererForFeatureSelection renderer = new MyRendererForFeatureSelection(leafIcon);
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

				String NewFeatureNewName = txtSearchText.getText().replace(" ", "").trim();
				if (NameUniquenessVerifier.verify(wm, NewFeatureNewName, false)) {
					Feature newFeature = FormlFactory.eINSTANCE.createFeature();
					newFeature.setName(NewFeatureNewName);
					ConfirmFlag = true;
					createFlag = true;
					selectedFeature = newFeature;
					hide();
				} else {
					lblError.setText("A Feature with the name: " + NewFeatureNewName + " already exists.");
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

		selectedFeature = null;

		String SearchText = txtSearchText.getText().trim();
		if (SearchText.equals("")) {
			MakeTree();
		} else {
			List<EObject> features = ModelUtils.getFeaturesWithoutFeatureModules(wm);

			// Fetch the root node
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
			root.removeAllChildren();
			root.setUserObject(wm);

			for (EObject f : features) {
				if (((Feature) f).getName().toLowerCase().contains(SearchText.toLowerCase())) {
					DefaultMutableTreeNode featureTreeNode = new DefaultMutableTreeNode();
					featureTreeNode.setUserObject(f);

					root.insert(featureTreeNode, root.getChildCount());
				}
			}
			treeModel.reload();

			if (root.getChildCount() != 1 && !SearchText.equals(""))
				btnCreate.setEnabled(true);
			else
				btnCreate.setEnabled(false);

		}
	}
}

class MyRendererForFeatureSelection extends DefaultTreeCellRenderer {
	Icon icon;

	public MyRendererForFeatureSelection(Icon icon) {
		this.icon = icon;
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {

		// setIcon(icon);

		if (leaf) {
			setIcon(icon);
		} else {
			setToolTipText(null); // no tool tip
		}

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		// JOptionPane.showMessageDialog(null, node.getUserObject());
		Object nodeObject = node.getUserObject();

		String nodeName = "";
		if (nodeObject instanceof Feature)
			nodeName = "Feature: " + ((Feature) nodeObject).getName();
		else
			nodeName = "WorldModel";

		return super.getTreeCellRendererComponent(tree, nodeName, sel, expanded, leaf, row, hasFocus);
	}
}