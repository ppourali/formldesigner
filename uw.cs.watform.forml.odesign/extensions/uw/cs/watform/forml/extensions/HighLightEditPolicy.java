package uw.cs.watform.forml.extensions;

import javax.swing.JOptionPane;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class HighLightEditPolicy extends SelectionEditPolicy  {


	
	@Override
	protected void showSelection() {
		//super.showPrimarySelection();
		//JOptionPane.showMessageDialog(null,this.getHostFigure());
//		try {
//			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("com.uwaterloo.cs.forml.odesign.view1");
//		} catch (PartInitException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	protected void hideSelection() {
		//super.
		
	}

}
