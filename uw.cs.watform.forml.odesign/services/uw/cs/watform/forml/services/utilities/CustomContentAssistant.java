package uw.cs.watform.forml.services.utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

public class CustomContentAssistant extends JDialog   {
	
	private JList list;
   

	public CustomContentAssistant(PopupObjects objects, String prevPath) {
        setVisible(false);
        
       

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setUndecorated(true);
		setType(Type.POPUP);
		setSize(new Dimension(250, 155));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setBackground(new Color(255, 250, 205));
		
		final AbstractAction escapeAction = new AbstractAction() {
		    private static final long serialVersionUID = 1L;

		    @Override
		    public void actionPerformed(ActionEvent ae) {
		        dispose();
		    }
		};
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE_KEY");
		getRootPane().getActionMap().put("ESCAPE_KEY", escapeAction);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		populateList(objects,prevPath);
		setAlwaysOnTop(true);
		setAutoRequestFocus(true);
		setFocusable(true);
		
		this.setVisible(true);
		
	}
	
	
	
	private void populateList(PopupObjects objects, String prevPath)
	{
	    DefaultListModel model = new DefaultListModel();
		for(PopupObjects p:objects.getFields())
		{
			model.addElement(p.getName()+":"+p.getReturnType());
			
			
		}
		
		list.setModel(model);
	}
	
}
