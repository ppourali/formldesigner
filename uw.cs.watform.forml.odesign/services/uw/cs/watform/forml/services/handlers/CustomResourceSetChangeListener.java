package uw.cs.watform.forml.services.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.common.ui.util.WorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeContainerSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeEditPart;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeListEditPart;
import org.eclipse.sirius.diagram.ui.part.ValidateAction;
import org.eclipse.sirius.diagram.ui.tools.api.util.EditPartTools;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import uw.cs.watform.forml.extensions.ViewPart_PropertyEditor;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.DistanceBasedRanking.ClassDiagramRelationsMap;
import uw.cs.watform.forml.services.internal.triggers.AutosizeTrigger;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

/**
 * This is a customized resource set listener for changing any (semantic)
 * resource in the diagram/model.
 * 
 * 
 * @author ppourali
 * 
 */
public class CustomResourceSetChangeListener implements ResourceSetListener {

	private IEditorPart editorPart;

	public CustomResourceSetChangeListener(IEditorPart editor) {
		this.editorPart = editor;
	}

	@Override
	public NotificationFilter getFilter() {
		return null;
		// return NotificationFilter.;

	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("restriction")
	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {

		for (Iterator iter = event.getNotifications().iterator(); iter.hasNext();) {
			Notification notification = (Notification) iter.next();

			Object notifier = notification.getNotifier();

			if (notifier instanceof EObject) {
				EObject eObject = (EObject) notifier;

				//WorldModel wm = ModelUtils.getTypedRootForObject(eObject, WorldModel.class);
				//if (wm != null) {
					//ClassDiagramRelationsMap.updateClassDiagramMap(wm);
				//}

//				if (!(eObject instanceof DSemanticDiagramSpec)) {
//
//					// only respond to changes to structural features of the
//					// object
//					if (notification.getFeature() instanceof EStructuralFeature) {
//						EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
//
//						//clearPropertyEditor();
//						
//						RepresentationsUtils.RunVaidation(editorPart);
//					}
//
//				}

			}
		}
	}

	private void clearPropertyEditor() {

		ViewPart_PropertyEditor myView = (ViewPart_PropertyEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView("com.uwaterloo.cs.forml.odesign.PropertyEditor");

		if (myView != null) {
			myView.clearChildren();
		}
	}
	// System.out.println(event.getSource());

	// try {
	//
	// WorkbenchPartDescriptor workbenchPartDescriptor = new
	// WorkbenchPartDescriptor(editorPart.getSite().getId(),
	// editorPart.getClass(), editorPart.getSite().getPage());
	// ValidateAction va = new ValidateAction(workbenchPartDescriptor);
	//
	// va.run();
	// } catch (Exception e) {
	//
	// }

//	private void RunVaidation() {
//		try {
//			WorkbenchPartDescriptor workbenchPartDescriptor = new WorkbenchPartDescriptor(editorPart.getSite().getId(),
//					editorPart.getClass(), editorPart.getSite().getPage());
//			ValidateAction va = new ValidateAction(workbenchPartDescriptor);
//			va.run();
//		} catch (Exception e) {
//
//		}
//
//	}

	@Override
	public boolean isAggregatePrecommitListener() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrecommitOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPostcommitOnly() {

		return true;
	}

}
