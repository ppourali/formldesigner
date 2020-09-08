package uw.cs.watform.forml.services.DistanceBasedRanking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class ClassDiagramRelationsMap {

	// parent (generalization) class attributes and functions
	private static final int prio_CatC = 1400;

	// whole-part (composition, aggregation) class attributes and functions
	private static final int prio_CatD = 1200;

	// association class attributes and functions
	private static final int prio_CatE = 1000;

	// Not related
	private static final int prio_CatF = 800;
	
	static HashMap<URI, List<URI>> map_Generalization = new HashMap<URI, List<URI>>();
	static HashMap<URI, List<URI>> map_WholePart = new HashMap<URI, List<URI>>();
	static HashMap<URI, List<URI>> map_Associations = new HashMap<URI, List<URI>>();

	static List<Integer> allGeneralizationDists = new ArrayList<Integer>();
	static List<Integer> allWholePartDists = new ArrayList<Integer>();
	static List<Integer> allAssociationDists = new ArrayList<Integer>();

	public static void updateGeneralizingMap(EObject ele) {
		WorldModel wm = ModelUtils.getWorldModel(ele);
		if (wm == null)
			return;

		List<Roleable> allRoleables = ModelUtils.getObjectsByTypeInAnObjectElement(wm, Roleable.class);

		// List<Roleable> superTypes = new ArrayList<Roleable>();

		for (Roleable roleable : allRoleables) {
			if (roleable instanceof Entity) {
				if (((Entity) roleable).getSuperType() != null) {
					updateMap(map_Generalization, roleable, ((Entity) roleable).getSuperType());
				}
			}
		}

	}

	public static void updateWholePartMap(EObject ele) {
		WorldModel wm = ModelUtils.getWorldModel(ele);
		if (wm == null)
			return;

		if (wm != null) {

			List<Composition> compositions = EcoreUtil2.getAllContentsOfType(wm, Composition.class);
			List<Aggregation> aggregations = EcoreUtil2.getAllContentsOfType(wm, Aggregation.class);

			for (Composition comp : compositions) {
				updateMap(map_WholePart, comp.getPart().getType(), comp.getWhole().getType());
				updateMap(map_WholePart, comp.getWhole().getType(), comp.getPart().getType());
			}

			for (Aggregation aggr : aggregations) {
				updateMap(map_WholePart, aggr.getPart().getType(), aggr.getWhole().getType());
				updateMap(map_WholePart, aggr.getWhole().getType(), aggr.getPart().getType());
			}
		}

	}

	public static void updateAssociationMap(EObject ele) {
		WorldModel wm = ModelUtils.getWorldModel(ele);
		if (wm == null)
			return;

		if (wm != null) {

			List<Association> assocations = EcoreUtil2.getAllContentsOfType(wm, Association.class);

			for (Association assoc : assocations) {
				Roleable src = assoc.getSrcRole().getType();
				Roleable dst = assoc.getDesRole().getType();
				updateMap(map_Associations, src, dst);
				updateMap(map_Associations, dst, src);
			}
		}

	}

	private static void updateMap(HashMap<URI, List<URI>> map_updatig, Roleable key, Roleable newVal) {

		List<URI> values = map_updatig.get(getURI(key));

		if (values == null) {
			values = new ArrayList<URI>();
		}

		if (!values.contains(getURI(newVal))) {
			values.add(getURI(newVal));
			map_updatig.put(getURI(key), values);
		}
	}

	static void initMaps(EObject ele) {
		updateGeneralizingMap(ele);
		updateAssociationMap(ele);
		updateWholePartMap(ele);
	}

	public static int getMinDistance(EObject obj1, EObject self) {
		initMaps(self);
//System.out.println(obj1);
		Roleable selfClass = ModelUtils.getTypedRootForObject(self, Roleable.class);
		Roleable distantClass = ModelUtils.getTypedRootForObject(obj1, Roleable.class);

		if (selfClass == distantClass)
			return 0;

		allGeneralizationDists.clear();
		findDistInGeneralization(getURI(distantClass), getURI(selfClass), 0, new ArrayList<URI>());
		int distance_Generalization = getMinDist(allGeneralizationDists);
		if (distance_Generalization > -1)
			return prio_CatC - (2 * distance_Generalization);

		allWholePartDists.clear();
		findDistInWholePart(getURI(distantClass), getURI(selfClass), 0, new ArrayList<URI>());
		int distance_WholePart = getMinDist(allWholePartDists);
		if (distance_WholePart > -1)
			return prio_CatD - (2 * distance_WholePart);

		allAssociationDists.clear();
		findDistInAssociation(getURI(distantClass), getURI(selfClass), 0, new ArrayList<URI>());
		int distance_Association = getMinDist(allAssociationDists);
		if (distance_Association > -1) {
			// System.out.println(selfClass+" -->> "+distantClass+" : " +
			// distance_Association);
			return prio_CatE - (2 * distance_Association);
		}
		// not connected at all!
		return prio_CatF;
	}

	private static int getMinDist(List<Integer> list) {
		if (list.isEmpty())
			return -1;

		int min = Integer.MAX_VALUE;
		for (Integer i : list)
			if (i < min)
				min = i;

		return min;
	}

	private static void findDistInGeneralization(URI distantClass, URI selfClass, int dist, List<URI> CLosedList) {
		List<URI> relatedClasses = map_Generalization.get(selfClass);
		if (CLosedList.contains(selfClass))
			return;
		if (relatedClasses == null || relatedClasses.isEmpty()) {
			return;
		} else if (relatedClasses.contains(distantClass)) {
			allGeneralizationDists.add(dist + 1);
			return;
		} else {
			for (URI c : relatedClasses) {
				if (CLosedList.contains(CLosedList))
					continue;
				CLosedList.add(selfClass);
				findDistInGeneralization(distantClass, c, dist + 1, CLosedList);
			}
		}
	}

	private static void findDistInWholePart(URI distantClass, URI selfClass, int dist, List<URI> CLosedList) {
		List<URI> relatedClasses = map_WholePart.get(selfClass);
		if (CLosedList.contains(selfClass))
			return;

		if (relatedClasses == null || relatedClasses.isEmpty()) {
			return;
		} else if (relatedClasses.contains(distantClass)) {
			allWholePartDists.add(dist + 1);
			return;
		} else {
			for (URI c : relatedClasses) {
				if (CLosedList.contains(CLosedList))
					continue;
				CLosedList.add(selfClass);
				findDistInWholePart(distantClass, c, dist + 1, CLosedList);
			}
		}
	}

	static URI getURI(EObject eObject) {
		return EcoreUtil.getURI(eObject);
	}

	private static void findDistInAssociation(URI distantClass, URI selfClass, int dist, List<URI> CLosedList) {

		List<URI> relatedClasses = map_Associations.get(selfClass);

		if (CLosedList.contains(selfClass))
			return;

		if (relatedClasses == null || relatedClasses.isEmpty()) {
			return;
		} else if (relatedClasses.contains(distantClass)) {
			allAssociationDists.add(dist + 1);
			return;
		} else {
			for (URI c : relatedClasses) {
				if (CLosedList.contains(CLosedList))
					continue;
				CLosedList.add(selfClass);
				findDistInAssociation(distantClass, c, dist + 1, CLosedList);
			}
		}
	}

}
