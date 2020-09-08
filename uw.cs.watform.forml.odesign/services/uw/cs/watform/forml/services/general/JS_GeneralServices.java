package uw.cs.watform.forml.services.general;

import org.eclipse.emf.ecore.EObject;

public class JS_GeneralServices {

	public static boolean isNull(EObject t)
	{
		return (t==null);
	}
	
	public static boolean notNull(EObject t)
	{
		return !(t==null);
	}
}
