package uw.cs.watform.forml.services.GUI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.services.utilities.ModelUtils;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.Dimension;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;

public class FrmLookForEverything extends JFrame {
	private JTextField txtSearchText;
	private List<EObject> allElements;

	private JList list;
	DefaultListModel listModel;

	public FrmLookForEverything(uw.cs.watform.forml.forml.System root) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setType(Type.POPUP);
		setSize(new Dimension(400, 300));

		allElements=EcoreUtil2.eAllContentsAsList(root);

		//System.out.println(allElements.size());




		setAlwaysOnTop(true);
		setTitle("Search");

		txtSearchText = new JTextField();
		txtSearchText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				search();

			}
		});
		getContentPane().add(txtSearchText, BorderLayout.NORTH);
		txtSearchText.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);


		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setBackground(new Color(245, 245, 245));
		scrollPane.setViewportView(list);
	}
	protected void search() {
		String searchText=txtSearchText.getText().trim().toLowerCase();

		//System.out.println(allElements.size());

		listModel.clear();

		for(EObject elem:allElements)
		{
			//listModel.addElement(elem);

			String attributeName = "name";
			EDataType resultingDataType = null;
			EList<EAttribute> eAllAttributes = elem.eClass().getEAllAttributes();
			for (EAttribute eAttribute : eAllAttributes) {
				if(eAttribute.getName().equals(attributeName)){
					//resultingDataType = (EDataType) elem.eGet(eAttribute);
					try{
						if(elem.eGet(elem.eClass().getEStructuralFeature("name")).toString().toLowerCase().contains(searchText))
						{
							listModel.addElement(elem);
							break;
						}
					}
					catch(Exception e)
					{

					}
				}           
			}


		}    

		//System.out.println(elem);
		//if(elem.eGet(elem.eClass().getEStructuralFeature("name"))!=null)
		//if(elem.eGet(elem.eClass().getEStructuralFeature("name")).toString().equalsIgnoreCase(searchText))
		//{
		//listModel.addElement(elem);
		//}
		//}




	}

}
