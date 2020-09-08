package uw.cs.watform.forml.services.GUI;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.impl.BoolTypeImpl;
import uw.cs.watform.forml.forml.impl.EntityImpl;
import uw.cs.watform.forml.forml.impl.FeatureImpl;
import uw.cs.watform.forml.forml.impl.IntTypeImpl;
import uw.cs.watform.forml.forml.impl.ReferenceTypeImpl;
import uw.cs.watform.forml.forml.impl.StringTypeImpl;


public class PopupContainer extends JPopupMenu {

	String excludeMsgType="";
	public PopupContainer(String type, System root, Feature curFeature, String rootString, ActionListener menuListener)
	{

		this.setBackground(new Color(255,255,204));

		if(type.equals("WCA"))
			excludeMsgType="Input";
		else if(type.equals("WCE"))
			excludeMsgType="Output";



		if (!rootString.trim().equals("")){

			String[] exprs=rootString.split(" ");

			rootString=exprs[exprs.length-1];

			String[] tokens=rootString.split("\\.");

			Feature featureRoot=FormlFactory.eINSTANCE.createFeature();

			if(tokens.length==0)
				populateList(root, curFeature, menuListener);
			else{
				featureRoot=findFeature(root,tokens[tokens.length-1]);
				//java.lang.System.out.println(featureRoot);
				if(featureRoot==null)
				{
					Entity entityRoot=FormlFactory.eINSTANCE.createEntity();
					entityRoot=findEntity(root,tokens[tokens.length-1]);
					if(entityRoot!=null)
					{
						populateList(entityRoot, menuListener);
					}
					else
						populateList(root, curFeature, menuListener);
				}
				else
				{
					populateList(featureRoot, menuListener);
				}
			}
		}
		else
			populateList(root, curFeature, menuListener);

	}


	private Feature findFeature(System root, String prevString) {

		for(EObject p:root.getWorldmodel().getConcepts())
		{
			if(p.getClass()==FeatureImpl.class)
				if(((Feature)p).getName().equals(prevString))
				{
					return ((Feature)p);
				}
		}

		return null;
	}

	private Entity findEntity(System root, String prevString) {

		for(EObject p:root.getWorldmodel().getConcepts())
		{
			if(p.getClass()==EntityImpl.class)
				if(((Entity)p).getName().equals(prevString))
				{
					return ((Entity)p);
				}
		}

		return null;
	}


	private EObject objFinder(EObject root,String[] tokens, int tokenCounter)
	{
		EObject retobj=root;
		for (EObject obj:root.eContents())
		{
			if (obj.toString().contains(tokens[tokenCounter]))
			{
				retobj=objFinder(obj, tokens,++tokenCounter);
				break;
			}
		}

		return retobj;
	}


	private void populateList(System root, Feature curFeature, ActionListener menuListener)
	{
		for(EObject p:root.getWorldmodel().getConcepts())
		{
			if(p instanceof FeatureImpl)
			{
				if(p==curFeature)
				{
					
						for (ExprRef att:curFeature.getAttributes())
						{
							createMenuItem((Attribute)att, menuListener);
						}
					
					if(excludeMsgType.equals("Output") && curFeature.getInputlist()!=null)
					{
						for (RefMessage msg:curFeature.getInputlist().getInputs())
						{
							createMenuItem(msg.getRefMsg(),menuListener,"in");
						}
					}
					if(excludeMsgType.equals("Input") && curFeature.getOutputlist()!=null)
					{
						for (RefMessage msg:curFeature.getOutputlist().getOutputs())
						{
							createMenuItem(msg.getRefMsg(),menuListener,"out");
						}								
					}
				}
				else
				{
					createMenuItem((Feature)p, menuListener);
				}
			}
			else if(p instanceof EntityImpl)
			{
				createMenuItem((Entity)p, menuListener);
			}

		}

	}

	private void createMenuItem(Entity entity, ActionListener menuListener) {
		JMenuItem menuItem = new JMenuItem(entity.getName()+" : Entity");
		menuItem.setBackground(new Color(255,255,204));
		menuItem.addActionListener(menuListener);
		menuItem.setOpaque(true);

		add(menuItem);
	}


	private void createMenuItem(Feature feature, ActionListener menuListener)
	{
		JMenuItem menuItem = new JMenuItem((feature).getName()+" : Feature");
		menuItem.setBackground(new Color(255,255,204));
		menuItem.addActionListener(menuListener);
		menuItem.setOpaque(true);

		add(menuItem);
	}

	private void createMenuItem(Attribute att, ActionListener menuListener)
	{
		String Attribute_Type="<T>";
		if (att.getType()!=null)
		{
			if(att.getType().getClass().equals(IntTypeImpl.class))
				Attribute_Type="int";
			else if(att.getType().getClass().equals(BoolTypeImpl.class))
				Attribute_Type="bool";
			else if(att.getType().getClass().equals(StringTypeImpl.class))
				Attribute_Type="string";
			else if(att.getType().getClass().equals(ReferenceTypeImpl.class))
				Attribute_Type=((ReferenceType)att.getType()).getRef().getName();

			JMenuItem menuItem = new JMenuItem((att).getName()+" : "+Attribute_Type);
			menuItem.setBackground(new Color(255,255,204));
			menuItem.addActionListener(menuListener);
			menuItem.setOpaque(true);

			add(menuItem);
		}
		if(excludeMsgType.equals("Output"))
		{
			JMenuItem menuItemForAttChange = new JMenuItem(att.getName()+"~(o)");
			menuItemForAttChange.setBackground(new Color(255,255,204));
			menuItemForAttChange.addActionListener(menuListener);
			menuItemForAttChange.setOpaque(true);

			add(menuItemForAttChange);
		}
	}

	private void createMenuItem(Message msg, ActionListener menuListener, String suffix)
	{
		JMenuItem menuItem = new JMenuItem(msg.getName()+" : "+suffix);
		menuItem.setBackground(new Color(255,255,204));
		menuItem.addActionListener(menuListener);
		menuItem.setOpaque(true);

		add(menuItem);

		if(excludeMsgType.equals("Output"))
		{
			JMenuItem menuItemForAddConcept = new JMenuItem(msg.getName()+"+(o)");
			menuItemForAddConcept.setBackground(new Color(255,255,204));
			menuItemForAddConcept.addActionListener(menuListener);
			menuItemForAddConcept.setOpaque(true);

			add(menuItemForAddConcept);

			JMenuItem menuItemForRemoveConcept = new JMenuItem(msg.getName()+"-(o)");
			menuItemForRemoveConcept.setBackground(new Color(255,255,204));
			menuItemForRemoveConcept.addActionListener(menuListener);
			menuItemForRemoveConcept.setOpaque(true);

			add(menuItemForRemoveConcept);
		}
	}

	private void populateList(Feature curFeature, ActionListener menuListener)
	{
			for (ExprRef att:curFeature.getAttributes())
			{
				createMenuItem((Attribute)att, menuListener);
			}
		if(excludeMsgType.equals("Output") &&curFeature.getInputlist()!=null)
		{
			for (RefMessage msg:curFeature.getInputlist().getInputs())
			{
				createMenuItem(msg.getRefMsg(),menuListener,"in");
			}
		}
		if(excludeMsgType.equals("Input") && curFeature.getOutputlist()!=null)
		{
			for (RefMessage msg:curFeature.getOutputlist().getOutputs())
			{
				createMenuItem(msg.getRefMsg(),menuListener,"out");
			}								
		}
	}

	private void populateList(Entity curEntity, ActionListener menuListener)
	{
		for (ExprRef att:curEntity.getAttributes())
		{
			createMenuItem((Attribute)att, menuListener);
		}
	}
}
