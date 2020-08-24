package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.TransferData;

public class AbstractDNDForFeatureNodeVeiwer extends ViewerDropAdapter {

	private static HashMap<String, EObject> dragedEObjects = new HashMap<String, EObject>();

	protected AbstractDNDForFeatureNodeVeiwer(Viewer viewer) {
		super(viewer);
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		return true;

	}

	@Override
	public boolean performDrop(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

	public static EObject getDragedEObjectsByKey(String key) {
		return dragedEObjects.get(key);
	}

	public static void addDragedEObjects(String key, Object value) {
		if (value instanceof EObject) {
			dragedEObjects.put(key, (EObject) value);
		}

	}

}
