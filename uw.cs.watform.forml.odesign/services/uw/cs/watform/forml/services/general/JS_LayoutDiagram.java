package uw.cs.watform.forml.services.general;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.business.api.query.EObjectQuery;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusLayoutDataManager;
import org.eclipse.sirius.diagram.ui.business.internal.view.LayoutData;
import org.eclipse.sirius.diagram.ui.business.internal.view.RootLayoutData;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeEditPart;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Transition;

/**
 * All the services related to diagram layouting.
 * 
 * 
 * @author ppourali
 */
public final class JS_LayoutDiagram {

	private static String event, guard, aid, condition, action;
	private static Transition priority;

	private static final String CLASS_DIAGRAM_Name = "Features/Entities Class Diagram";// WorldModel_FeatureClasses_Diagram"; //$NON-NLS-1$
	private static final String CLASS_DIAGRAM_Id = "WorldModel_FeatureClasses_Diagram"; //$NON-NLS-1$
	private static final String FRAGMENT_DIAGRAM_Id = "Fragment_Diagram"; //$NON-NLS-1$

	private static final String FeatureModel_DIAGRAM_Id = "WorldModel_FeatureModel_Diagram"; //$NON-NLS-1$

	private static final String FeatureModule_DIAGRAM_Id = "FeatureModule_Diagram"; //$NON-NLS-1$

	public JS_LayoutDiagram() {

		// DialectManager.INSTANCE.getAllRepresentations(this);
	}

	@SuppressWarnings("restriction")
	public static void setOrNodePosition(EObject t,AbstractDNode createdView) {
		DiagramEditPart diagramEditPart = null;
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) editor;
			diagramEditPart = diagramEditor.getDiagramEditPart();
		}
		
		
		LayoutData layoutData = 
				SiriusLayoutDataManager.INSTANCE.getData(createdView, true);
		Point newLocation=new Point(100,100);
		Dimension newSize=new Dimension(100,100);
				layoutData = new RootLayoutData(((FeatureNode)t).getOrs().get(0), newLocation, 
				newSize);
				SiriusLayoutDataManager.INSTANCE.addData(layoutData);
				

		if (diagramEditPart != null) {
			ArrayList<EObject> result = new ArrayList<EObject>(
					new EObjectQuery(((FeatureNode)t).getOrs().get(0)).getInverseReferences(ViewpointPackage.Literals.DSEMANTIC_DECORATOR__TARGET));

			EditPart editpart=diagramEditPart.findEditPart(diagramEditPart.getRoot(), t);

			 for (Iterator children = diagramEditPart.getChildren().iterator(); children
			            .hasNext();) {
			            EditPart child = (EditPart) children.next();
			            if (child instanceof DNodeEditPart) {
			            	System.out.println(child.getViewer().getContents().getModel());
			            	//((DNodeEditPart)child).setTooltipText("this is my tooltip");
			            	
			    			//LayoutData layoutData = SiriusLayoutDataManager.INSTANCE.getData(((DNodeEditPart)child).setTooltipText("this is my tooltip"), true);
			    			//Point newLocation=new Point(100,100);
			    			//Dimension newSize=new Dimension(100,100);
			    			//layoutData = new RootLayoutData(t, newLocation, newSize);
			    			//SiriusLayoutDataManager.INSTANCE.addData(layoutData);

			            }
			        }
			

		}
	}

	public static void LayoutRegionOnCreate(EObject t) {
		// DiagramEditPart diagramEditPart = null;
		// IEditorPart editor = PlatformUI.getWorkbench()
		// .getActiveWorkbenchWindow().getActivePage()
		// .getActiveEditor();
		//
		// if (editor instanceof DiagramEditor) {
		// DiagramEditor diagramEditor = (DiagramEditor) editor;
		// diagramEditPart = diagramEditor.getDiagramEditPart();
		// }
		//
		// if(diagramEditPart !=null)
		// {
		// installpolicity(diagramEditPart);
		//
		// }
		// ArrangeRequest arrangeRequest = new
		// ArrangeRequest(ActionIds.ACTION_ARRANGE_SELECTION);
		// List<Object> partsToArrange = new ArrayList<Object>();
		// partsToArrange.add(diagramEditPart);
		//
		//
		//
		//
		// ArrayList<EObject> result = new ArrayList<EObject>(new EObjectQuery
		// (t).getInverseReferences(ViewpointPackage.Literals.DSEMANTIC_DECORATOR__TARGET));
		// System.out.println(((DNodeContainerSpec)result.get(0)).getNodes());
		// ((DNodeContainerSpec)result.get(0)).getNodes().get(0).setWidth(50);
		//
		// arrangeRequest.setPartsToArrange(partsToArrange);
		// diagramEditPart.performRequest(arrangeRequest);
		// }

	}
	//
	// private static void installpolicity (Object ob)
	// {
	// if(ob instanceof EditPart)
	// {
	// for(Object o:((EditPart)ob).getChildren())
	// if(o instanceof EditPart)
	// {
	// ((EditPart)o).installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
	// PreferredSizeHandlerEditPolicy());
	// installpolicity(o);
	// }
	// }
	// }

	public static void LayoutFeatureModuleOnStart(EObject t) {
		// LayoutData layoutData =
		// SiriusLayoutDataManager.INSTANCE.getData(createdView, true);
		// layoutData = new RootLayoutData(layoutData.getTarget(), newLocation,
		// newSize);
		// SiriusLayoutDataManager.INSTANCE.addData(layoutData);
		//
		// DiagramEditPart diagramEditPart = null;
		// IEditorPart editor = PlatformUI.getWorkbench()
		// .getActiveWorkbenchWindow().getActivePage()
		// .getActiveEditor();
		//
		//
		//
		// if (editor instanceof DiagramEditor) {
		// DiagramEditor diagramEditor = (DiagramEditor) editor;
		// diagramEditPart = diagramEditor.getDiagramEditPart();
		// }
		// ArrangeRequest arrangeRequest = new
		// ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
		// List<Object> partsToArrange = new ArrayList<Object>(1);
		// partsToArrange.add(diagramEditPart);
		// arrangeRequest.setPartsToArrange(partsToArrange);
		// diagramEditPart.performRequest(arrangeRequest);

		// EditPartViewer viewer = diagramEditPart.getViewer();
		// if (viewer instanceof SiriusDiagramGraphicalViewer) {
		// try{
		// Diagram diagramModel = (Diagram)diagramEditPart.getModel();
		// final DSemanticDiagram diagram =
		// (DSemanticDiagram)diagramModel.getElement();
		// if
		// (FeatureModule_DIAGRAM_Id.equals(diagram.getDescription().getName()))
		// {
		// ArrangeRequest arrangeRequest = new
		// ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
		// List<Object> partsToArrange = new ArrayList<Object>(1);
		// partsToArrange.add(diagramEditPart);
		// arrangeRequest.setPartsToArrange(partsToArrange);
		// diagramEditPart.performRequest(arrangeRequest);
		// }
		// }
		// catch (Exception excep)
		// {
		//
		// }
		// }
		// for (Object child :diagramEditPart.getChildren())
		// {
		// if (child instanceof EditPart)
		// {
		// EObject elem=
		// (ViewUtil.resolveSemanticElement((View)((EditPart)child).getModel()));
		// if(elem instanceof StateMachine)
		// {
		// ((View)((EditPart)child).getModel())
		// }
		// }
		// }

	}

	public static void setLayouat(EObject t) {
		// JOptionPane.showMessageDialog(null, t);
		// SiriusLayoutDataManager.INSTANCE.addData(new
		// RootLayoutData(createdView,
		// newLocation, new Dimension(-1, -1)));

		ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
		Command command = commandService.getCommand("de.cau.cs.kieler.kiml.ui.command.layout");

		try {
			command.executeWithChecks(new ExecutionEvent());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotEnabledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotHandledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
