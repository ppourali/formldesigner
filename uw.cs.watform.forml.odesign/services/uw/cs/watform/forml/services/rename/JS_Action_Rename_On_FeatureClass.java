package uw.cs.watform.forml.services.rename;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.EnumConst;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Message;


/**
 * This is a java service class used in Sirius to handle renaming entities on
 * Feature Class.
 * 
 * 
 * @author ppourali
 * 
 */
public class JS_Action_Rename_On_FeatureClass extends ServiceClass {
//
//	public static Resource getModelStateBeforeEdit(EObject t) {
//		//final Copier copier = new Copier();
//		//final EObject copiedContents = copier.copy(t);
//		// copier.copyReferences();
//		return t.eResource();// EcoreUtil.copy(t).eResource();
//		// System newSys=FormlFactory.eINSTANCE.createSystem();
//		// newSys=Ecorecopier ModelUtils.getSystem(t);
//
//		// return newSys.eResource();
//	}
//
//	public static Resource getModelStateAfterEdit(EObject t) {
//		return t.eResource();
//	}

//	public static void compare(Resource resourceSet1, Resource resourceSet2) {
//
//		// Configure EMF Compare
//		org.eclipse.emf.compare.match.eobject.IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
//		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
//	        matchEngineFactory.setRanking(20);
//	        org.eclipse.emf.compare.match.IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
//	        matchEngineRegistry.add(matchEngineFactory);
//		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
//
//		// Compare the two models
//		IComparisonScope scope = EMFCompare.createDefaultScope(resourceSet1, resourceSet2);
//		Comparison Com = comparator.compare(scope);
//		EList<Diff> diffs = Com.getDifferences();
//	}

	public static boolean Rename_Entity(EObject t, String newName) {
		
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Entity) t, newName, true)) {
			((Entity) t).setName(newName);
			ShowRenameConfirmation();
			return true;
		}

		return false;
	}

	public static boolean Rename_FeatureClass(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Feature) t, newName, true)) {
			((Feature) t).setName(newName);
			ShowRenameConfirmation();
			return true;
		}

		return false;

	}

	public static boolean Rename_Message(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Message) t, newName, true)) {
			((Message) t).setName(newName);
			ShowRenameConfirmation();
			return true;
		}

		return false;
	}

	public static boolean Rename_Association(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Association) t, newName)) {
			((Association) t).setName(newName);
			
			return true;
		}

		return false;
	}

	public static boolean Rename_Composition(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Composition) t, newName)) {
			((Composition) t).setName(newName);
			return true;
		}

		return false;
	}

	public static boolean Rename_Aggregation(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Aggregation) t, newName)) {
			((Aggregation) t).setName(newName);
			return true;
		}

		return false;
	}

	public static boolean Rename_Enum(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((Enumeration) t, newName, true)) {
			((Enumeration) t).setName(newName);
			ShowRenameConfirmation();
			return true;
		}

		return false;
	}

	public static boolean Rename_EnumCons(EObject t, String newName) {
		newName = newName.replace(" ", "");

		if (NameUniquenessVerifier.verify((EnumConst) t, (Enumeration) t.eContainer(), newName, true)) {
			((EnumConst) t).setName(newName);
			ShowRenameConfirmation();
			return true;
		}

		return false;
	}
}
