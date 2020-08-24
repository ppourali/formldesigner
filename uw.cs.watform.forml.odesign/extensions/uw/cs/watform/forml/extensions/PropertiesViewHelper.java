package uw.cs.watform.forml.extensions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Trigger;

public class PropertiesViewHelper {
	public static Label lblSavedOrStillErroneous;

	public static <T extends EObject> void setStatusLabel(boolean success, Class<T> type) {
		if (lblSavedOrStillErroneous != null) {
			String text = "";
			if (success) {
				lblSavedOrStillErroneous.setForeground(SWTResourceManager.getColor(0, 102, 0));
				if (type.equals(Trigger.class))
					text = "Event has been successfully saved.";
				else if (type.equals(Guard.class))
					text = "Guard has been successfully saved.";
				else if (type.equals(Action.class))
					text = "Action has been successfully saved.";
			} else {
				lblSavedOrStillErroneous.setForeground(SWTResourceManager.getColor(255, 0, 0));
				text = "The changes contain error and cannot be saved";
			}
			lblSavedOrStillErroneous.setText(text);
			lblSavedOrStillErroneous.pack();
			lblSavedOrStillErroneous.redraw();
			lblSavedOrStillErroneous.update();
			
			
		}
	}
}
