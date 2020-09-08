package uw.cs.watform.forml.services.general;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.swt.widgets.Display;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.forml.impl.SPLImpl;
import uw.cs.watform.forml.forml.impl.WorldModelImpl;
import uw.cs.watform.forml.services.GUI.FrmSetCardinality;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FrmFPC_FeatureNode;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;

/**
 * All the services related to Feature Models.
 * 
 * 
 * @author ppourali
 */
public final class JS_FeatureModelServices {
	public JS_FeatureModelServices() {
		

	}

	public static void OpenFPCFeatureNode(EObject any) {
		Roleable roleable = null;
		if (any instanceof DNode) {
			roleable = ((FeatureNode) ((DNode) any).getTarget()).getFeature();

		}

		try {
			if (roleable == null)
				return;

			// if there is no other transition editor open
			if (FPC_SingletonData.getShell() == null) {
				CustomVirtualResource vres = ModelUtils2.createVirtualOriginalResource(roleable);

				FPC_SingletonData.setCurrentRoleable(roleable);
				FrmFPC_FeatureNode fmc = new FrmFPC_FeatureNode(Display.getDefault());
				fmc.open();

				if (FPC_SingletonData.confirmFlag == false) {
					vres.revertBack();
				}

				FPC_SingletonData.setShell(null);
			} else {
				FPC_SingletonData.getShell().getShell().setActive();
			}

//				final Copier copierback = new Copier();
			//
//				final Collection<EObject> copiedContentsBack = copierback.copyAll(copiedContents);
//				copierback.copyReferences();
//				originalResource.getContents().set(0, newXMIResource.getContents().get(0));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static boolean noExistingSPL(EObject t) {
		if (ModelUtils.getWorldModelObjectsByType(t, SPL.class).size() > 0)
			return false;

		return true;
	}
	// public static void ValidateDiagram(EObject t) {
	//
	// final Session session =
	// SessionManager.INSTANCE.getSession(ModelUtils.getWorldModel(t));
	// JS_DashboardServices ds=new JS_DashboardServices();
	// final Collection<DRepresentation>
	// representation=ds.getRepresentationsForFeatureModel(ModelUtils.getWorldModel(t));
	//
	// //final Session session = SessionManager.INSTANCE.getSession(t);
	// //final Collection<DRepresentation> representation =
	// DialectManager.INSTANCE
	// // .getRepresentations(ModelUtils.getWorldModel(t), session);
	//
	// if (representation.iterator().hasNext())
	// {
	// IEditorPart editorPart = DialectUIManager.INSTANCE.openEditor(session,
	// representation.iterator().next(),
	// new NullProgressMonitor());
	// WorkbenchPartDescriptor workbenchPartDescriptor = new
	// WorkbenchPartDescriptor(editorPart.getSite().getId(),
	// editorPart.getClass(), editorPart.getSite().getPage());
	// ValidateAction va = new ValidateAction(workbenchPartDescriptor);
	//
	// va.run();
	// }
	// }

	/*
	 * Find the corresponding Feature Module of a feature(ndoe) and navigates to its
	 * diagram.
	 */
	public static FeatureModule findFMtoNavigateFromFeatureNode(EObject t) {

		Roleable feature = null;
		if (t instanceof FeatureNode) {
			feature = ((FeatureNode) t).getFeature();
		} else if (t instanceof Feature) {
			feature = (Feature) t;
		} else if (t instanceof Entity) {
			feature = (Entity) t;
		}
		if (feature != null) {

			for (FeatureModule fm : ModelUtils.getSystem(t).getBehaviourmodel().getFeaturemodules()) {
				if (fm.getFeatureref().equals(feature))
					return fm;
			}
		}

		return null;
	}

	public static void CreateFeatureNode(EObject t) {
		Node parentNode = (Node) refineContextToAddFeatureNode(t);
		ModelOperations2.CreateNewFeatureNode(parentNode, FeatureNode.class);
	}

	public static void CreateAndNode(EObject t) {
		Node parentNode = (Node) refineContextToAddFeatureNode(t);
		ModelOperations2.CreateNewFeatureNode(parentNode, AndNode.class);
	}

	public static void CreateOrNode(EObject t) {
		Node parentNode = (Node) refineContextToAddFeatureNode(t);
		ModelOperations2.CreateNewFeatureNode(parentNode, OrNode.class);
	}

	public static void CreateXorNode(EObject t) {
		Node parentNode = (Node) refineContextToAddFeatureNode(t);
		ModelOperations2.CreateNewFeatureNode(parentNode, XORNode.class);
	}

	/*
	 * When user clicks on feature model to insert a new feature node, this service
	 * decides under which Feature node should be inserted.
	 */
	public static EObject refineContextToAddFeatureNode(EObject t) {

		Node returnObject = FormlFactory.eINSTANCE.createNode();

		// if it is the worldmodel
		if (t.getClass() == WorldModelImpl.class) {
			// find SPL and return
			for (ExprRef c : ((WorldModel) t).getConcepts()) {
				if (c.getClass() == SPLImpl.class)
					returnObject = (SPL) c;
			}
		} else
			returnObject = (Node) t;

		return returnObject;
	}

	/*
	 * Populates multiplicity label for Feature Nodes.
	 */
	public static String showMultiplicityForFeatureNodes(EObject t) {

		String returnLabel = "";
		try {

			Multiplicity multiplicity = ((FeatureNode) t).getMultiplicity();

			if (multiplicity != null) {
				if (multiplicity.getCardinality() != null) {
					if (multiplicity.getCardinality().getMany() != null
							&& multiplicity.getCardinality().getMany().trim() != "")
						returnLabel += multiplicity.getCardinality().getLower() + ".."
								+ multiplicity.getCardinality().getMany();
					else
						returnLabel += multiplicity.getCardinality().getLower() + ".."
								+ multiplicity.getCardinality().getUpper();

				} else {
					if (multiplicity.getMany() != null && multiplicity.getMany().trim() != "") {
						returnLabel += "*";
					} else {
						returnLabel += multiplicity.getValue();
					}
				}
			}
		} catch (Exception e) {
			returnLabel = "";
		}

		// if (returnLabel.trim().equals("0..*"))
		// returnLabel = "";

		return "[" + returnLabel + "]";
	}

	/*
	 * Opens multiplicity editing dialog and sets its result for the multiplicity
	 * 
	 */
	public static Multiplicity getFeatureNodeMultiplicity(EObject t) {
		Multiplicity oldMultiplicity = ((FeatureNode) t).getMultiplicity();
		try {
			int oldLower = 0, oldUpper = 0;

			if (oldMultiplicity != null) {

				if (oldMultiplicity.getCardinality() != null) {
					oldLower = oldMultiplicity.getCardinality().getLower();
					if (oldMultiplicity.getCardinality().getMany() != null
							&& oldMultiplicity.getCardinality().getMany().trim() != "")
						oldUpper = -1;
					else
						oldUpper = oldMultiplicity.getCardinality().getUpper();
				} else {
					if (oldMultiplicity.getMany() != null && oldMultiplicity.getMany().trim() != "") {
						oldUpper = -1;
					} else {
						oldLower = oldMultiplicity.getValue();
						oldUpper = oldMultiplicity.getValue();
					}
				}
			}

			FrmSetCardinality frmSetCard = new FrmSetCardinality(oldLower, oldUpper);
			frmSetCard.setVisible(true);

			if (frmSetCard.ConfirmFlag) {

				Multiplicity newMultiplicity = FormlFactory.eINSTANCE.createMultiplicity();

				if (frmSetCard.Many.equals("*") && frmSetCard.cardLower == -1) {
					newMultiplicity.setMany("*");
				} else {
					if (frmSetCard.cardLower == frmSetCard.cardUpper) {
						newMultiplicity.setValue(frmSetCard.cardLower);
					} else {
						Cardinality cardinality = FormlFactory.eINSTANCE.createCardinality();
						cardinality.setLower(frmSetCard.cardLower);
						if (frmSetCard.cardUpper == -1)
							cardinality.setMany("*");
						else
							cardinality.setUpper(frmSetCard.cardUpper);

						newMultiplicity.setCardinality(cardinality);
					}
				}
				return newMultiplicity;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oldMultiplicity;
	}

	public static boolean isAndNode(EObject any) {
		if (any.eContainer() instanceof AndNode)
			return true;

		return false;
	}

	public static boolean isOrNode(EObject any) {
		if (any.eContainer() instanceof OrNode)
			return true;

		return false;
	}

	public static boolean isXorNode(EObject any) {
		if (any.eContainer() instanceof XORNode)
			return true;

		return false;
	}

	public static boolean isOptional(EObject any) {
		if (any instanceof FeatureNode) {
			FeatureNode fn = ((FeatureNode) any);
			if (fn.getMultiplicity() != null) {
				Multiplicity mult = fn.getMultiplicity();
				if (mult.getCardinality() != null) {
					Cardinality card = mult.getCardinality();
					if (card.getLower() == 0) {
						return true;
					} else {
						return false;
					}
				}

				if (mult.getValue() == 0) {
					return true;
				}

			}
		}

		return false;
	}

	public static boolean isMadatory(EObject any) {
		if (any instanceof FeatureNode) {
			FeatureNode fn = ((FeatureNode) any);
			if (fn.getMultiplicity() != null) {
				Multiplicity mult = fn.getMultiplicity();
				if (mult.getCardinality() != null) {
					Cardinality card = mult.getCardinality();
					if (card.getLower() > 0) {
						return true;
					} else {
						return false;
					}
				}
				if (mult.getValue() > 0) {
					return true;
				}

			}
		}

		return false;
	}

	public static void createSPL(EObject any) {
		ModelUtils.getOrCreateSPLRoot(any);
	}

	public static void MoveLogicalNodes(EObject newSemanticContainer, EObject movingNode,
			EObject oldSemanticContainer) {
		try {
			//EcoreUtil2.remove(movingNode);
			if (movingNode instanceof OrNode) {
				if (newSemanticContainer instanceof FeatureNode) {
					((FeatureNode) newSemanticContainer).getOrs().add((OrNode) movingNode);
				} else if (newSemanticContainer instanceof SPL) {
					((SPL) newSemanticContainer).getOrs().add((OrNode) movingNode);
				}
			} else if (movingNode instanceof AndNode) {
				if (newSemanticContainer instanceof FeatureNode) {
					((FeatureNode) newSemanticContainer).getAnds().add((AndNode) movingNode);
				} else if (newSemanticContainer instanceof SPL) {
					((SPL) newSemanticContainer).getAnds().add((AndNode) movingNode);
				}
			} else if (movingNode instanceof XORNode) {
				if (newSemanticContainer instanceof FeatureNode) {
					((FeatureNode) newSemanticContainer).getXors().add((XORNode) movingNode);
				} else if (newSemanticContainer instanceof SPL) {
					((SPL) newSemanticContainer).getXors().add((XORNode) movingNode);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
