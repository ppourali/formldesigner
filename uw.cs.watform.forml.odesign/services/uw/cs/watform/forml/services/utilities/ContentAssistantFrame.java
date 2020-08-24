package uw.cs.watform.forml.services.utilities;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.*;
import uw.cs.watform.forml.forml.impl.*;


import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Frame;
import java.awt.Point;
import java.awt.ComponentOrientation;
import java.awt.Dialog.ModalityType;

public class ContentAssistantFrame extends JDialog {

//	public static JList<String> listOfElements ;
//
//	public static String returnText="";
//	private static DefaultListModel listModel;
//	public ContentAssistantFrame(String type,System root, Feature curFeature,String rootString) {
//		setAlwaysOnTop(true);
//		setModal(true);
//		setUndecorated(true);
//		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//		//setAlwaysOnTop(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setLocation(new Point(100, 100));
//		
//
//		setSize(new Dimension(200, 150));
//		JScrollPane scrollPane = new JScrollPane();
//		getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//		listModel= new DefaultListModel();
//		listOfElements = new JList(listModel);
//		listOfElements.setBackground(new Color(255,255,204));
//		
//		scrollPane.setViewportView(listOfElements);
//
//		
//		listOfElements.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listOfElements.setLayoutOrientation(JList.VERTICAL_WRAP);
//		listOfElements.setVisibleRowCount(-1);
//
//
//		listOfElements.addKeyListener(new KeyListener() {
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
//				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
//					dispose();
//				else if(e.getKeyCode()==KeyEvent.VK_ACCEPT)
//				{
//					returnText=listOfElements.getSelectedValue();
//					dispose();;
//				}
//				
//			}
//		});
//
//		String excludeMsgType="";
//		if(type.equals("WCA"))
//			excludeMsgType="Input";
//		else if(type.equals("WCE"))
//			excludeMsgType="Output";
//		
//		
//		
//		if (!rootString.trim().equals("")){
//			
//			String[] exprs=rootString.split(" ");
//			
//			rootString=exprs[exprs.length-1];
//			
//			String[] tokens=rootString.split("\\.");
//			
//			Feature featureRoot=FormlFactory.eINSTANCE.createFeature();
//			
//			if(tokens.length==0)
//				populateList(excludeMsgType,root, curFeature);
//			else{
//				featureRoot=findFeature(root,tokens[tokens.length-1]);
//				java.lang.System.out.println(featureRoot);
//				if(featureRoot==null)
//					populateList(excludeMsgType,root, curFeature );
//				else
//					populateList(excludeMsgType,featureRoot );
//			}
//		}
//		else
//			populateList(excludeMsgType,root, curFeature);
//
//	}
//
//
//	private Feature findFeature(System root, String prevString) {
//
//		for(EObject p:root.getWorldmodel().getConcepts())
//		{
//			if(p.getClass()==forml.impl.FeatureImpl.class)
//				if(((Feature)p).getName().equals(prevString))
//				{
//					return ((Feature)p);
//				}
//		}
//
//		return null;
//	}
//
//
//	private EObject objFinder(EObject root,String[] tokens, int tokenCounter)
//	{
//		EObject retobj=root;
//		for (EObject obj:root.eContents())
//		{
//			if (obj.toString().contains(tokens[tokenCounter]))
//			{
//				retobj=objFinder(obj, tokens,++tokenCounter);
//				break;
//			}
//		}
//
//		return retobj;
//	}
//
//	
//
//	private void populateList(String excludeMsgType, System root, Feature curFeature)
//	{
//		 
//		
//		for(EObject p:root.getWorldmodel().getConcepts())
//		{
//			if(p.getClass()==forml.impl.FeatureImpl.class)
//				if(p==curFeature)
//				{
//					for (Attribute att:curFeature.getAttributes()){
//
//						listModel.addElement(att.getName()+" : "+att.getType().getName());
//
//					}
//					for (Message msg:curFeature.getMessages()){
//						
//						if(msg.getMessageType().getLiteral().equals(excludeMsgType))
//							continue;
//						
//						listModel.addElement(msg.getName()+" : "+msg.getMessageType().getLiteral());
//					}
//				}
//				else
//				{
//					listModel.addElement(((Feature)p).getName()+" : Feature");
//				}
//
//		}
//		
//
//	}
//
//	private void populateList(String excludeMsgType,Feature curFeature)
//	{
//
//		for (Attribute att:curFeature.getAttributes()){
//			listModel.addElement(att.getName()+" : "+att.getType().getName());
//		}
//		for (Message msg:curFeature.getMessages()){
//			
//			if(msg.getMessageType().getLiteral().equals(excludeMsgType))
//				continue;
//			listModel.addElement(msg.getName()+" : "+msg.getMessageType().getLiteral());
//		}
//
//	}
//	
	
}
