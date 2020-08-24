package uw.cs.watform.forml.services.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Relationship;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.WorldModel;

public class AssociationUtils extends AbstractModelUtils {

	public static boolean hasAssociationType(Roleable element, Roleable current) {
		WorldModel wm = getWorldModel(element);

		List<Association> associations = EcoreUtil2.getAllContentsOfType(wm, Association.class);
		for (Association assoc : associations) {

			if (assoc.getSrcRole().getType().equals(element) && assoc.getDesRole().getType().equals(current))
				return true;

			if (assoc.getSrcRole().getType().equals(current) && assoc.getDesRole().getType().equals(element))
				return true;

		}
		
		if (current instanceof Entity) {
			Entity supertype = ((Entity) current).getSuperType();
			if (supertype != null) {
			
				// find classes with direct relation to the supertype and add to the list
				if (hasAssociationType(element, supertype))
					return true;
			}
		}
		return false;
	}

	public static boolean hasCompositionType(Roleable element, Roleable current) {
		WorldModel wm = getWorldModel(element);

		List<Composition> compositions = EcoreUtil2.getAllContentsOfType(wm, Composition.class);
		for (Composition comp : compositions) {

			if (comp.getWhole().getType().equals(current) && comp.getPart().getType().equals(element))
				return true;
		}

		if (current instanceof Entity) {
			Entity supertype = ((Entity) current).getSuperType();
			if (supertype != null) {
			
				// find classes with direct relation to the supertype and add to the list
				if (hasCompositionType(element, supertype))
					return true;
			}
		}
		
		return false;
	}

	public static boolean hasAggregationType(Roleable element, Roleable current) {
		WorldModel wm = getWorldModel(element);

		List<Aggregation> aggragations = EcoreUtil2.getAllContentsOfType(wm, Aggregation.class);
		for (Aggregation aggr : aggragations) {

			if (aggr.getWhole().getType().equals(current) && aggr.getPart().getType().equals(element))
				return true;
		}
		
		if (current instanceof Entity) {
			Entity supertype = ((Entity) current).getSuperType();
			if (supertype != null) {
			
				// find classes with direct relation to the supertype and add to the list
				if (hasAggregationType(element, supertype))
					return true;
			}
		}
		return false;
	}

	public static boolean hasGeneralizationType(Roleable element, Roleable current) {

		if (element instanceof Entity && current instanceof Entity) {
			Entity supertype = ((Entity) current).getSuperType();
			if (supertype != null) {
				// add super type to the direct association list
				if (supertype.equals(element))
					return true;
			}
		}
		
		
		return false;
	}

	public static List<Roleable> getAssociatedEntities(Roleable element) {
		WorldModel wm = getWorldModel(element);
		List<Roleable> associatedEntities = new ArrayList<Roleable>();

		List<Association> associations = EcoreUtil2.getAllContentsOfType(wm, Association.class);
		for (Association assoc : associations) {

			if (assoc.getSrcRole().getType().equals(element))
				associatedEntities.add(assoc.getDesRole().getType());

			if (assoc.getDesRole().getType().equals(element))
				associatedEntities.add(assoc.getSrcRole().getType());

		}

		List<Composition> compositions = EcoreUtil2.getAllContentsOfType(wm, Composition.class);
		for (Composition comp : compositions) {

			if (comp.getWhole().getType().equals(element))
				associatedEntities.add(comp.getPart().getType());

			// if (comp.getPart().getType().equals(element))
			// associatedEntities.add(comp.getWhole().getType());
		}
//
		List<Aggregation> aggragations = EcoreUtil2.getAllContentsOfType(wm, Aggregation.class);
		for (Aggregation aggr : aggragations) {

			if (aggr.getWhole().getType().equals(element))
				associatedEntities.add(aggr.getPart().getType());

			// if (aggr.getPart().getType().equals(element))
			// associatedEntities.add(aggr.getWhole().getType());
		}
//
		if (element instanceof Entity) {
			Entity supertype = ((Entity) element).getSuperType();
			if (supertype != null) {
				// add super type to the direct association list
				associatedEntities.add(((Entity) element).getSuperType());
				// find classes with direct relation to the supertype and add to the list
				List<Roleable> associationToTheSuperClass = getAssociatedEntities(supertype);
				for (Roleable r : associationToTheSuperClass) {
					if (!associatedEntities.contains(r))
						associatedEntities.add(r);
				}

//				
//				//find classes with direct relation to the supertype and add to the list
//				for (Association assoc : associations) {
//
//					if (assoc.getSrcRole().getType().equals(element))
//						associatedEntities.add(assoc.getDesRole().getType());
//
//					if (assoc.getDesRole().getType().equals(element))
//						associatedEntities.add(assoc.getSrcRole().getType());
//					
//					
//				}
			}

		}

		associatedEntities.remove(element);

		// for (Composition assoc : EcoreUtil2.getAllContentsOfType(wm,
		// Composition.class)) {
		//
		// if (assoc.getWhole().getType().equals(element))
		// associatedEntities.add(assoc.getDesRole().getType());
		//
		// if (assoc.getDesRole().getType().equals(element))
		// associatedEntities.add(assoc.getSrcRole().getType());
		// }

		return associatedEntities;
	}

	public static List<Roleable> getIndirectAssociations(Roleable selfRoleable) {
		List<Roleable> indirectAssociatedEntities = new ArrayList<Roleable>();
		java.util.List<Roleable> directRoleables = getAssociatedEntities(selfRoleable);
		for (Roleable df : directRoleables) {
			java.util.List<Roleable> indirectRoleables = getAssociatedEntities(df);
			indirectRoleables.removeAll(directRoleables);
			indirectRoleables.remove(selfRoleable);
			for (Roleable f : indirectRoleables) {
				if (!f.equals(selfRoleable)) {
					if (!indirectAssociatedEntities.contains(f)) {
						indirectAssociatedEntities.add(f);
					}
				}
			}
		}

		return indirectAssociatedEntities;
	}

	public static List<Relationship> getBiDirectedAssociations(Roleable element) {
		WorldModel wm = getWorldModel(element);
		List<Relationship> associations = new ArrayList<Relationship>();

		for (Relationship assoc : EcoreUtil2.getAllContentsOfType(wm, Relationship.class)) {
			if (assoc instanceof Association) {
				if (((Association) assoc).getSrcRole().getType().equals(element)
						|| (((Association) assoc).getDesRole().getType().equals(element)))
					associations.add(assoc);
			} else if (assoc instanceof Composition) {
				if (((Composition) assoc).getPart().getType().equals(element)
						|| (((Composition) assoc).getWhole().getType().equals(element)))
					associations.add(assoc);
			} else if (assoc instanceof Aggregation) {
				if (((Aggregation) assoc).getPart().getType().equals(element)
						|| (((Aggregation) assoc).getWhole().getType().equals(element)))
					associations.add(assoc);
			}
		}

		return associations;
	}
}
