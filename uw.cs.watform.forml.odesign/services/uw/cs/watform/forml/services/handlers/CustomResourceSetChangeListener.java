package uw.cs.watform.forml.services.handlers;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import uw.cs.watform.forml.extensions.ViewPart_PropertyEditor;

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
