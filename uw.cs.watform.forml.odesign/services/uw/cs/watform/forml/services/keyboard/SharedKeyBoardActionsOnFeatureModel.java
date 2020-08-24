package uw.cs.watform.forml.services.keyboard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeEditPart;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * 
 * Handles the actions for feature model diagram keyboard hits.
 * 
 * @author ppourali
 */
@SuppressWarnings({ "unused", "restriction" })
public final class SharedKeyBoardActionsOnFeatureModel {

	private static List<Node> findSemanticContainers(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart)
	{
		List <Node> selectedContainers=new ArrayList<Node>();

		if(viewer.getSelectedEditParts()==null)
		{
			selectedContainers.add(ModelUtils.getSPLRoot(null));
			return selectedContainers;
		}
		else if(viewer.getSelectedEditParts()!=null)
		{
			if (viewer.getSelectedEditParts().size()==0)
			{
				selectedContainers.add(ModelUtils.getSPLRoot(null)); //return SPL
				return selectedContainers;
			}

			for(Object c:viewer.getSelectedEditParts())
			{
				if(c!=null && c instanceof DNodeEditPart)
				{
					Node f=findAssociatedSemanticContainer((DNodeEditPart)c);
					if(f!=null)
					{
						if(! selectedContainers.contains(f))
							selectedContainers.add(f);
					}
				}
			}
		}

		return selectedContainers;
	}

	private static Node findAssociatedSemanticContainer(DNodeEditPart parentFeatureContainer) {
		// if feature selected or any of feature parts are selected
		if(parentFeatureContainer!=null)
		{
			if(parentFeatureContainer.getModel() instanceof View)
			{
				View v=(View)(parentFeatureContainer.getModel());
				if(v.getElement().eCrossReferences().get(0) instanceof Node)
					return (Node)v.getElement().eCrossReferences().get(0);
			}
		}
		return null;
	}

	public static void createFeatureNode(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		
		for(Node parentFeatureNode:findSemanticContainers(viewer, parentDiagramEditPart))
		{
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();//TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack(); 
			commandStack.execute(new RecordingCommand(editingDomain) { 

				@Override 
				protected void doExecute() { 
					if(parentFeatureNode instanceof Node)
					{
						ModelOperations.CreateNewFeatureNode(parentFeatureNode,FeatureNode.class);
					}
					
				} 
			}); 
		}
	}

	public static void createAndNode(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		for(Node parentFeatureNode:findSemanticContainers(viewer, parentDiagramEditPart))
		{
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();//TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack(); 
			commandStack.execute(new RecordingCommand(editingDomain) { 

				@Override 
				protected void doExecute() { 
					if(parentFeatureNode instanceof Node)
					{
						ModelOperations.CreateNewFeatureNode(parentFeatureNode,AndNode.class);
					}
					
				} 
			}); 
		}
	}

	public static void createOrNode(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		for(Node parentFeatureNode:findSemanticContainers(viewer, parentDiagramEditPart))
		{
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();//TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack(); 
			commandStack.execute(new RecordingCommand(editingDomain) { 

				@Override 
				protected void doExecute() { 
					if(parentFeatureNode instanceof Node)
					{
						ModelOperations.CreateNewFeatureNode(parentFeatureNode,OrNode.class);
					}
					
				} 
			}); 
		}
		
	}

	public static void createXorNode(EditPartViewer viewer, DiagramEditPart parentDiagramEditPart) {
		for(Node parentFeatureNode:findSemanticContainers(viewer, parentDiagramEditPart))
		{
			TransactionalEditingDomain editingDomain = parentDiagramEditPart.getEditingDomain();//TransactionUtil.getEditingDomain(v.getElement().eCrossReferences().get(0));
			final CommandStack commandStack = editingDomain.getCommandStack(); 
			commandStack.execute(new RecordingCommand(editingDomain) { 

				@Override 
				protected void doExecute() { 
					if(parentFeatureNode instanceof Node)
					{
						ModelOperations.CreateNewFeatureNode(parentFeatureNode,XORNode.class);
					}
					
				} 
			}); 
		}
		
	}


	

}
