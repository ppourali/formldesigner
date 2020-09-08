package uw.cs.watform.forml.services.utilities;

import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.Component;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.EnumConst;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.InputList;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.OutputList;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.Role;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.atomic;
import uw.cs.watform.forml.forml.setExpr;
import uw.cs.watform.forml.forml.setExpr2;
import uw.cs.watform.forml.forml.setExpr3;
import uw.cs.watform.forml.forml.setExprBase;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.FrmShellForCrossReferenceView_TreeStyle;
import uw.cs.watform.forml.services.internal.MessageDialogs;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;

public class ModelOperations2 extends ModelOperations {

	/**
	 * Changes message type from Input to Output based.
	 * 
	 * @param refMsg
	 * @param msg
	 * @param dialogResult only this message || all the messages
	 */
	public static void changeMessageTypeForTheFeatures(RefMessage refMsg, Message msg, int dialogResult) {

		if (refMsg.getRefMsg() instanceof Input) {

			Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(msg);
			if (referrers.size() > 0) {
				final Display display = Display.getDefault();
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						try {
							FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new FrmShellForCrossReferenceView_TreeStyle(
									display, referrers, refMsg.getRefMsg());
							messageDeleteBox.open();

							if (messageDeleteBox.ConfirmFlag)
								changeInputMessageType(refMsg, msg, dialogResult);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} else {
				changeInputMessageType(refMsg, msg, dialogResult);
			}
		} else if (refMsg.getRefMsg() instanceof Output) {
			Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(msg);
			if (referrers.size() > 0) {
				final Display display = Display.getDefault();
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						try {
							FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new FrmShellForCrossReferenceView_TreeStyle(
									display, referrers, refMsg.getRefMsg());
							messageDeleteBox.open();

							if (messageDeleteBox.ConfirmFlag)
								changeOutputMessageType(refMsg, msg, dialogResult);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			} else {
				changeOutputMessageType(refMsg, msg, dialogResult);
			}
		}
	}

	public static boolean chageAssociationType(Roleable src, Roleable dst) {
		if (src == null && dst == null) {
			return false;
		}
		try {
			// TODO write code to change association
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static void changeOutputMessageType(RefMessage refMsg, Message msg, int dialogResult) {
		WorldModel wm = ModelUtils.getWorldModel(refMsg);

		EList<Feature> parentFeatures = new BasicEList<Feature>();

		Input newMessage = FormlFactory.eINSTANCE.createInput();
		if (dialogResult == JOptionPane.YES_OPTION) {
			parentFeatures.addAll((((Output) msg).getFroms()));

			newMessage.setName(msg.getName());
			newMessage.getAttributes().addAll(msg.getAttributes());
			newMessage.getTos().addAll(parentFeatures);

			ModelDeleteOperations.removeMessageFromWorldModel(msg);
		} else if (dialogResult == JOptionPane.NO_OPTION) {
			parentFeatures.add((Feature) ModelUtils.getTypedRootForObject(refMsg, Feature.class));

			String name = MessageDialogs.InputNewMessageName();
			while (!NameUniquenessVerifier.verify(msg, name, false)) {
				name = MessageDialogs.InputNewMessageName();
			}
			newMessage.setName(name);
			newMessage.getAttributes().addAll(msg.getAttributes());
			newMessage.getTos().addAll(parentFeatures);
		}

		for (Feature f : parentFeatures) {

			// remove refMessage from all the features containing
			// the input message
			for (RefMessage r : f.getOutputlist().getOutputs()) {
				if (r.getRefMsg().equals(msg)) {
					EcoreUtil2.remove(r);
					break;
				}
			}

			// add it as a new output message
			RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();
			newRefMsg.setRefMsg(newMessage);

			if (!ModelUtils.getWorldModelObjectsByType(f, Input.class).contains(newRefMsg.getRefMsg())) {
				ModelUtils.getWorldModel(refMsg).getConcepts().add(newRefMsg.getRefMsg());
			}

			if (f.getInputlist() == null) {
				InputList newIL = FormlFactory.eINSTANCE.createInputList();
				f.setInputlist(newIL);
			}
			f.getInputlist().getInputs().add(newRefMsg);
		}

	}

	private static void changeInputMessageType(RefMessage refMsg, Message msg, int dialogResult) {

		WorldModel wm = ModelUtils.getWorldModel(refMsg);

		EList<Feature> parentFeatures = new BasicEList<Feature>();

		Output newMessage = FormlFactory.eINSTANCE.createOutput();
		if (dialogResult == JOptionPane.YES_OPTION) {
			parentFeatures.addAll((((Input) msg).getTos()));

			newMessage.setName(msg.getName());
			newMessage.getAttributes().addAll(msg.getAttributes());
			newMessage.getFroms().addAll(parentFeatures);

			ModelDeleteOperations.removeMessageFromWorldModel(msg);
		} else if (dialogResult == JOptionPane.NO_OPTION) {
			parentFeatures.add((Feature) ModelUtils.getTypedRootForObject(refMsg, Feature.class));

			String name = MessageDialogs.InputNewMessageName();
			while (!NameUniquenessVerifier.verify(msg, name, false)) {
				name = MessageDialogs.InputNewMessageName();
			}
			newMessage.setName(name);
			newMessage.getAttributes().addAll(msg.getAttributes());
			newMessage.getFroms().addAll(parentFeatures);

		}

		for (Feature f : parentFeatures) {

			// remove refMessage from all the features containing
			// the input message
			for (RefMessage r : f.getInputlist().getInputs()) {
				if (r.getRefMsg().equals(msg)) {
					EcoreUtil2.remove(r);
					break;
				}
			}

			// add it as a new output message
			RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();
			newRefMsg.setRefMsg(newMessage);

			if (!ModelUtils.getWorldModelObjectsByType(f, Output.class).contains(newRefMsg.getRefMsg())) {
				ModelUtils.getWorldModel(refMsg).getConcepts().add(newRefMsg.getRefMsg());
			}

			if (f.getOutputlist() == null) {
				OutputList newOL = FormlFactory.eINSTANCE.createOutputList();
				f.setOutputlist(newOL);
			}
			f.getOutputlist().getOutputs().add(newRefMsg);
		}

	}

	private static void mergeTwoMessages(Message existingMessage, RefMessage refMessage) {
		Feature parentFeature = (Feature) (ModelOperations.getTypedRootForObject(refMessage, Feature.class));

		ModelDeleteOperations.removeMessageFromFeature(parentFeature, refMessage);

		RefMessage newRefMsg = FormlFactory.eINSTANCE.createRefMessage();

		newRefMsg.setRefMsg(existingMessage);

		if (existingMessage instanceof Input) {
			((Input) newRefMsg.getRefMsg()).getTos().add(parentFeature);
			parentFeature.getInputlist().getInputs().add(newRefMsg);

		} else if (existingMessage instanceof Output) {
			((Output) newRefMsg.getRefMsg()).getFroms().add(parentFeature);
			parentFeature.getOutputlist().getOutputs().add(newRefMsg);
		}
	}

	public static void preMergeProcessing(Message existingMessage, RefMessage refMessage) {

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(refMessage.getRefMsg());
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@java.lang.Override
			protected void doExecute() {

				Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(refMessage.getRefMsg());
				if (referrers.size() > 0) {
					final Display display = Display.getDefault();
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							try {
								FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new FrmShellForCrossReferenceView_TreeStyle(
										display, referrers, refMessage.getRefMsg());
								messageDeleteBox.open();

								if (messageDeleteBox.ConfirmFlag)
									mergeTwoMessages(existingMessage, refMessage);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					mergeTwoMessages(existingMessage, refMessage);
				}

			}
		});
	}

	/**
	 * Creating a new message for the feature.
	 * 
	 * @param parentFeature
	 * @param oldRefMessage
	 * @param newMessageName
	 */
	public static void createNewMessageForTheFeature(Feature parentFeature, String newMessageName, AttributeType type,
			Message oldmsg) {

		RefMessage newRefMessage = FormlFactory.eINSTANCE.createRefMessage();
		Message newMessage = null;

		if (oldmsg instanceof Input) {
			newMessage = FormlFactory.eINSTANCE.createInput();
			((Input) newMessage).getTos().add(parentFeature);

		} else if (oldmsg instanceof Output) {
			newMessage = FormlFactory.eINSTANCE.createOutput();
			((Output) newMessage).getFroms().add(parentFeature);

		}

		if (newMessageName.trim().length() > 0) {

			String newName = WorldModelCommonServices.parseMessageName(newMessageName);

			if (!NameUniquenessVerifier.verify(oldmsg, newName, true)) {
				return;
			}

			newMessage.setName(newName);
			newMessage.setType(type);

			List<Attribute> newAttrList = WorldModelCommonServices
					.parseMessageParams(ModelUtils.getWorldModel(parentFeature), newMessageName);

			newMessage.getAttributes().clear();
			newMessage.getAttributes().addAll(newAttrList);

		}

		ModelUtils.getWorldModel(parentFeature).getConcepts().add(newMessage);
		newRefMessage.setRefMsg(newMessage);
		if (newMessage instanceof Input)
			parentFeature.getInputlist().getInputs().add(newRefMessage);
		else if (newMessage instanceof Output)
			parentFeature.getOutputlist().getOutputs().add(newRefMessage);

	}

	/**
	 * Creating a new message for the feature with minimal settings.
	 * 
	 * @param parentFeature
	 * 
	 * @param newMessageName
	 */
	public static <T extends EObject> Message createNewMessageForTheFeatureMinimal(Feature parentFeature,
			String newMessageName, Class<T> type) {

		RefMessage newRefMessage = FormlFactory.eINSTANCE.createRefMessage();
		Message newMessage = null;

		if (type.equals(Input.class)) {
			newMessage = FormlFactory.eINSTANCE.createInput();
			((Input) newMessage).getTos().add(parentFeature);

		} else if (type.equals(Output.class)) {
			newMessage = FormlFactory.eINSTANCE.createOutput();
			((Output) newMessage).getFroms().add(parentFeature);

		}

		if (newMessageName.trim().length() > 0) {

			String newName = WorldModelCommonServices.parseMessageName(newMessageName);

			if (!NameUniquenessVerifier.verify(newMessage, newName, true)) {
				return null;
			}

			newMessage.setName(newName);
		}

		ModelUtils.getWorldModel(parentFeature).getConcepts().add(newMessage);
		newRefMessage.setRefMsg(newMessage);
		if (newMessage instanceof Input)
			parentFeature.getInputlist().getInputs().add(newRefMessage);
		else if (newMessage instanceof Output)
			parentFeature.getOutputlist().getOutputs().add(newRefMessage);

		return newMessage;

	}

	public static void editMessageForOneFeature(Feature parentFeature, Message oldMessage, RefMessage refMessage,
			String newMessageName, AttributeType newType) {
		// Remove the message from the feature
		ModelDeleteOperations.removeMessageFromFeature(parentFeature, refMessage);

		// and then create new msg based on the new
		// renamed message
		createNewMessageForTheFeature(parentFeature, newMessageName, newType, oldMessage);

	}

	public static void CreateFunctionForEntity(EObject currentObject, String newName) {

		Function newFunction = FormlFactory.eINSTANCE.createFunction();

		Entity entity = ModelUtils2.getTypedRootForObject(currentObject, Entity.class);

		if (entity != null) {
			if (newName.trim().equals("")) {
				int autoincrementForName = ModelUtils.getObjectsByTypeInAnObjectElement(entity, Function.class).size();
				newName = "Func" + String.valueOf(autoincrementForName);
				while (!NameUniquenessVerifier.verify(newFunction, entity, newName, false)) {
					autoincrementForName++;
					newName = "Func" + String.valueOf(autoincrementForName);
				}
			}

			newFunction.setName(newName);

			entity.getFunctions().add(newFunction);
		}
	}

	// public static void CreateAttributeForEntity(EObject attributeParent) {
	//
	// Attribute newAttribute = FormlFactory.eINSTANCE.createAttribute();
	//
	// int autoincrementForName = 0;
	// if (attributeParent instanceof Entity) {
	// autoincrementForName =
	// ModelUtils.getObjectsByTypeInAnObjectElement(attributeParent,
	// Attribute.class)
	// .size();
	// } else if (attributeParent instanceof Feature) {
	// autoincrementForName =
	// ModelUtils.getObjectsByTypeInAnObjectElement(attributeParent,
	// Attribute.class)
	// .size();
	// }
	//
	// String newName = "Att" + String.valueOf(autoincrementForName);
	// while (!NameUniquenessVerifier.verify(newAttribute, attributeParent,
	// newName, false)) {
	// autoincrementForName++;
	// newName = "Att" + String.valueOf(autoincrementForName);
	// }
	// newAttribute.setName(newName);
	//
	// AttributeType intType = FormlFactory.eINSTANCE.createIntType();
	// newAttribute.setType(intType);
	//
	// if (attributeParent instanceof Entity) {
	// ((Entity) attributeParent).getAttributes().add(newAttribute);
	// } else if (attributeParent instanceof Feature) {
	// ((Feature) attributeParent).getAttributes().add(newAttribute);
	//
	// }
	//
	// }

	public static void CreateNewAttribute(EObject currentobject, String newAttributeName) {

		Attribute newAttribute = FormlFactory.eINSTANCE.createAttribute();

		EObject attributeParent = ModelUtils2.getTypedRootForObject(currentobject, Entity.class);

		if (attributeParent != null) {
			if (attributeParent instanceof Entity) {
				ModelOperations.addNewAttributeToEntity((Entity) attributeParent, newAttribute, newAttributeName);
			}
		} else {
			attributeParent = ModelUtils2.getTypedRootForObject(currentobject, Feature.class);
			if (attributeParent != null) {
				if (attributeParent instanceof Feature) {
					ModelOperations.addNewAttributeToFeature((Feature) attributeParent, newAttribute, newAttributeName);
				}
			}
		}

	}

	public static Attribute CopyAttributes(EObject attributeParent, Attribute att) {

		Attribute newAttribute = FormlFactory.eINSTANCE.createAttribute();

		newAttribute.setCtrl(att.isCtrl());
		newAttribute.setName(att.getName());

		if (att.getType() != null) {
			AttributeType newAttType = FormlFactory.eINSTANCE.createAttributeType();
			String attTypeStr = ModelUtils2.convertAttributeTypeToString(att.getType());
			newAttType = ModelUtils2.createAttributeType(attTypeStr);
			newAttribute.setType(newAttType);
		}

		if (att.getMultiplicity() != null)
			newAttribute.setMultiplicity(att.getMultiplicity());

		if (attributeParent instanceof Entity) {
			if (NameUniquenessVerifier.verify(newAttribute, (Entity) attributeParent, newAttribute.getName(), true)) {
				((Entity) attributeParent).getAttributes().add(newAttribute);
			}
		} else if (attributeParent instanceof Feature) {
			if (NameUniquenessVerifier.verify(newAttribute, (Feature) attributeParent, newAttribute.getName(), true)) {
				((Feature) attributeParent).getAttributes().add(newAttribute);
			}
		}

		return newAttribute;
	}

	public static void CreateEnumerationConstant(Enumeration parentEnum) {

		EnumConst newEnumCons = FormlFactory.eINSTANCE.createEnumConst();

		int autoincrementForName = ModelUtils.getObjectsByTypeInAnObjectElement(parentEnum, EnumConst.class).size();
		String newName = "cons" + String.valueOf(autoincrementForName);

		while (!NameUniquenessVerifier.verify(newEnumCons, parentEnum, newName, false)) {
			autoincrementForName++;
			newName = "cons" + String.valueOf(autoincrementForName);
		}
		newEnumCons.setName(newName);

		parentEnum.getConstant().add(newEnumCons);

	}

	// True = IsAddObject , False=IsRemoveObject
	public static void setTransitionTrigger(Transition trans, ExprRef trigerItem, boolean isAddObject) {
		Trigger trigger = FormlFactory.eINSTANCE.createTrigger();
		WCE wce = FormlFactory.eINSTANCE.createWCE();
		if (trigerItem instanceof Message) {
			if (isAddObject)
				wce.setAddobj((Message) trigerItem);
			else
				wce.setRemobj((Message) trigerItem);
		} else if (trigerItem instanceof Attribute) {
			wce.setAttr((Attribute) trigerItem);
		} else if (trigerItem instanceof Function) {
			wce.setAddobj((Function) trigerItem);
		}
		trigger.setWce(wce);
		trans.setTrig(trigger);

	}

	public static void setTransitionGuard(Transition trans, Guard newguard) {

		if (newguard != null) {
			trans.setGuard(newguard);
		}
//		if (newguard != null) {
//			if (trans.getGuard() == null) {
//				trans.setGuard(newguard);
//			} else {
//				if (trans.getGuard().getPredicate() == null) {
//					trans.setGuard(newguard);
//				} else {
//					List<impPred> impreds = ModelUtils2.getObjectsByTypeInAnObjectElement(trans, impPred.class);
//
//					List<andPred> andpreds = ModelUtils2.getObjectsByTypeInAnObjectElement(newguard, andPred.class);
//					if (!andpreds.isEmpty()) {
//						andpreds.get(0).getPreds().addAll(impreds);
//					}
//				}
//			}
//
//		}
	}

	// True = IsAddObject , False=IsRemoveObject
	public static void setoraddTransitionAction(Transition trans, String aID, ExprRef actionItem, boolean isAddObject,
			boolean overwriteActions) {

		if (overwriteActions == true)
			trans.getList().getActions().clear();

		aID = aID.trim().replace(" ", "");

		// if(actionItem instanceof Attribute)
		// {

		// }
		// else {
		if (isAddObject) {
			if (trans.getList() != null) {
				WCA newWCA = FormlFactory.eINSTANCE.createWCA();
				Action newAction = FormlFactory.eINSTANCE.createAction();
				newAction.setType((ExprRef) actionItem);

				if (aID.equals(""))
					newWCA.setName("a" + String.valueOf(trans.getList().getActions().size() + 1));
				else
					newWCA.setName(aID);

				newWCA.setAction(newAction);

				trans.getList().getActions().add(newWCA);
			} else if (trans.getList() == null) { // here to work on Friday

				WCA newWCA = FormlFactory.eINSTANCE.createWCA();
				Action newAction = FormlFactory.eINSTANCE.createAction();
				newAction.setType((ExprRef) actionItem);

				if (aID.equals(""))
					newWCA.setName("a1");
				else
					newWCA.setName(aID);

				newWCA.setAction(newAction);
				WCAList wcaList = FormlFactory.eINSTANCE.createWCAList();
				wcaList.getActions().add(newWCA);
				trans.setList(wcaList);
			}
		} else {
			if (trans.getList() != null) {
				WCA newWCA = FormlFactory.eINSTANCE.createWCA();
				Action newAction = FormlFactory.eINSTANCE.createAction();
				setExpr expr1 = FormlFactory.eINSTANCE.createsetExpr();
				setExpr2 expr2 = FormlFactory.eINSTANCE.createsetExpr2();
				setExpr3 expr3 = FormlFactory.eINSTANCE.createsetExpr3();
				setExprBase baseExpr = FormlFactory.eINSTANCE.createsetExprBase();
				atomic atomic = FormlFactory.eINSTANCE.createatomic();
				atomic.setRef(actionItem);
				baseExpr.setAtom(atomic);
				expr3.setBase(baseExpr);
				expr2.getExpr().add(expr3);
				expr1.getExpr().add(expr2);
				newAction.setMinexpr(expr1);

				if (aID.equals(""))
					newWCA.setName("a" + String.valueOf(trans.getList().getActions().size() + 1));
				else
					newWCA.setName(aID);

				newWCA.setAction(newAction);

				trans.getList().getActions().add(newWCA);
			} else if (trans.getList() == null) { // here to work on Friday

				WCA newWCA = FormlFactory.eINSTANCE.createWCA();
				Action newAction = FormlFactory.eINSTANCE.createAction();
				setExpr expr1 = FormlFactory.eINSTANCE.createsetExpr();
				setExpr2 expr2 = FormlFactory.eINSTANCE.createsetExpr2();
				setExpr3 expr3 = FormlFactory.eINSTANCE.createsetExpr3();
				setExprBase baseExpr = FormlFactory.eINSTANCE.createsetExprBase();
				atomic atomic = FormlFactory.eINSTANCE.createatomic();
				atomic.setRef(actionItem);
				baseExpr.setAtom(atomic);
				expr3.setBase(baseExpr);
				expr2.getExpr().add(expr3);
				expr1.getExpr().add(expr2);
				newAction.setMinexpr(expr1);

				if (aID.equals(""))
					newWCA.setName("a1");
				else
					newWCA.setName(aID);

				newWCA.setAction(newAction);
				WCAList wcaList = FormlFactory.eINSTANCE.createWCAList();
				wcaList.getActions().add(newWCA);
				trans.setList(wcaList);
			}
		}
		// }
	}

	public static boolean createAssociations(Roleable src, Roleable dst) {
		if (src == null && dst == null) {
			return false;
		}
		try {
			Association association = FormlFactory.eINSTANCE.createAssociation();
			association.setName("association_" + src.getName() + "_" + dst.getName());

			Role srcRole = FormlFactory.eINSTANCE.createRole();
			srcRole.setName(src.getName().toLowerCase());
			srcRole.setType(src);
			association.setSrcRole(srcRole);

			Role desRole = FormlFactory.eINSTANCE.createRole();
			desRole.setName(dst.getName().toLowerCase());
			desRole.setType(dst);
			association.setDesRole(desRole);

			ModelUtils.getWorldModel(src).getConcepts().add(association);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void CreateNewStateOnAnyObject(EObject parentComponent) {
		if (parentComponent != null) {
			if (parentComponent instanceof Region) {
				if (((Region) parentComponent).getStates().isEmpty()) {
					createNewInitialStateWithRefState((Region) parentComponent);

				} else {
					ModelOperations.CreateNewState((Region) parentComponent);
				}
			} else if (parentComponent instanceof State) {
				// if no region in the state
				EList<Component> regions = ((State) parentComponent).getRegions();
				if (regions.isEmpty()) {
					// add a region
					Region newRegion = FormlFactory.eINSTANCE.createRegion();
					((State) parentComponent).getRegions().add(newRegion);

					ModelOperations.createNewInitialState(newRegion);
				}
				// if there is at least on region, get the first one
				else if (regions.size() > 0) {
					// add to the first region
					Region parentRegion = (Region) ((State) parentComponent).getRegions().get(0);

					ModelOperations.CreateNewState(parentRegion);
				}
			}
		}
	}

}
