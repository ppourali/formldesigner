package uw.cs.watform.forml.services.handlers;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Text;

/**
 * This is a customized edit part listener for adding and removing child edit
 * parts.
 * 
 * @author ppourali
 * 
 */

public class CustomEditPartListener implements EditPartListener {

	public CustomEditPartListener() {
	}

	@Override
	public void childAdded(EditPart child, int index) {
		System.err.println(child);
		// sizeAction action = new sizeAction(sizeAction.PARAMETER_autosize, l);
		// Command cmd = action.getCommand();

		// System.out.println("-----------------");
		// System.out.println(child.getViewer().getControl().getLocation());
		// System.out.println(index);
		// System.out.println(child);
		// if(child.getModel() instanceof Node)
		// {
		// Node model=((Node)child.getModel());
		// if (model.getElement() instanceof DNodeSpec)
		// {
		// DNodeSpec element=(DNodeSpec)model.getElement();
		// if(element.getTarget() instanceof OrNode)
		// {
		// Point p=new Point(100,100);
		// ((DNodeEditPart) child).getFigure().setLocation(p);
		//
		// LayoutData layoutData =
		// SiriusLayoutDataManager.INSTANCE.getData((AbstractDNode) child,
		// true);
		// Point newLocation=new Point(100,100);
		// Dimension newSize=new Dimension(100,100);
		// layoutData = new RootLayoutData(element.getTarget(), newLocation,
		// newSize);
		// SiriusLayoutDataManager.INSTANCE.addData(layoutData);
		//
		//
		// //System.out.println(((DNodeEditPart)
		// child).getFigure().get);//.getBounds());
		// }
		// }
		// }
		// System.out.println("-----------------");
	}

	@Override
	public void partActivated(EditPart editpart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partDeactivated(EditPart editpart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removingChild(EditPart child, int index) {
		// WorkbenchPartDescriptor workbenchPartDescriptor = new
		// WorkbenchPartDescriptor(editorPart.getSite().getId(),
		// editorPart.getClass(), editorPart.getSite().getPage());
		// ValidateAction va = new ValidateAction(workbenchPartDescriptor);
		//
		// va.run();

	}

	@Override
	public void selectedStateChanged(EditPart editpart) {
		// TODO Auto-generated method stub

	}

}
