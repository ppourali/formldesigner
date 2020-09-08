package uw.cs.watform.forml.services.general;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.impl.FeatureModuleImpl;
import uw.cs.watform.forml.forml.impl.RegionImpl;
import uw.cs.watform.forml.forml.impl.StateImpl;

/**
 * All the services related to Fragments.
 * 
 * 
 * @author ppourali
 */
public final class JS_FragmentServices {


	public JS_FragmentServices() {

		//DialectManager.INSTANCE.getAllRepresentations(this);
	}


	public static String showFragmentSelectionPanel(EObject t)
	{
		JOptionPane.showMessageDialog(null, t);

		return "";
	}


	public static String setFragmentName(EObject t)
	{
		//JOptionPane.showMessageDialog(null, t);
		
		return getQualifiedNameOfTheFragment(((StateContext)t).getRef());
	}

	private static String getQualifiedNameOfTheFragment(EObject t) {

		String statePath="}";

		//JOptionPane.showMessageDialog(null, t);

		while(t.getClass()!=FeatureModuleImpl.class)
		{
			if(t.getClass()==StateImpl.class)
				statePath= ((State)t).getName()+statePath;

			if(t.getClass()==RegionImpl.class)
				statePath=((Region)t).getName()+statePath;

			t=t.eContainer();

			
			if(t.getClass()==StateImpl.class || t.getClass()==RegionImpl.class)
				statePath="."+statePath;
			
		}

		statePath=((FeatureModuleImpl)t).getFeatureref().getName()+"{"+statePath;

		return statePath;

	}	

//	public static List<FeatureImpl> getFragmentableFeatureList(EObject viewLement, EObject t) {
//
//		String statePath="}";
//
//		Feature currentFeature=FormlFactory.eINSTANCE.createFeature();
//		
//		
//		JOptionPane.showMessageDialog(null, t);
//
//		while(t.getClass()!=SystemImpl.class)
//		{		
//			
//			JOptionPane.showMessageDialog(null, t);
//
//			if(t.getClass()==FeatureModuleImpl.class)
//				currentFeature= ((forml.FeatureModule)t).getRelatedFeature();
//
//			t=t.eContainer();
//		}
//		
//		JOptionPane.showMessageDialog(null, currentFeature);
//
//		List <FeatureImpl> fragmentableFeatures=new ArrayList<FeatureImpl>();
//
//		for(EObject p:((System)t).getWorldmodel().getConcepts())
//		{
//			if(p.getClass()==forml.impl.FeatureImpl.class)
//			{
//				if(p!=currentFeature)
//				{
//					fragmentableFeatures.add((FeatureImpl)p);
//				}
//			}
//		}
//
//		JOptionPane.showMessageDialog(null, fragmentableFeatures);
//		return fragmentableFeatures;
//
//	}	

	
	
}
