package uw.cs.watform.forml.services.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListElementSpec;
import org.eclipse.swt.widgets.Display;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.services.GUI.FrmEditFeatureMessage;
import uw.cs.watform.forml.services.GUI.FrmShellForMessageEdit;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.FrmShellForCrossReferenceView_TreeStyle;
import uw.cs.watform.forml.services.internal.MessageDialogs;
import uw.cs.watform.forml.services.rename.NameUniquenessVerifier;
import uw.cs.watform.forml.services.rename.ServiceClass;
import uw.cs.watform.forml.services.utilities.ModelDeleteOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations;
import uw.cs.watform.forml.services.utilities.ModelOperations2;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.WorldModelCommonServices;
import uw.cs.watform.forml.services.virtualresource.CustomVirtualResource;

/**
 * All the services related to Message changes.
 * 
 * 
 * @author ppourali
 */
public final class JS_MessageServices extends ServiceClass {

	public JS_MessageServices() {

	}

	/*
	 * Populates label for Message signature.
	 */
	public static String PopulateMessageSignature(EObject t) {
		try {
			if (((RefMessage) t).getRefMsg() == null)
				return "";

			Message m = (Message) ((RefMessage) t).getRefMsg();

			String returnLabel = m.getName() + '(';

			String Parameters = "";
			if (m.getAttributes() != null) {
				for (ExprRef e : m.getAttributes()) {
					Attribute p = (Attribute) e;
					if (p.getType() != null) {
						String attType = ModelUtils2.convertAttributeTypeToString(p.getType());
						Parameters += p.getName() + ":" + attType + ",";
					} else
						Parameters += p.getName() + ",";
				}

				if (Parameters.length() > 0)
					Parameters = Parameters.substring(0, Parameters.length() - 1);
			}

			returnLabel += Parameters + ')';

			if (m.getType() != null) {
				String msgType = ModelUtils2.convertAttributeTypeToString(m.getType());
				returnLabel += " : " + msgType.trim();
			}

			return returnLabel;
		} catch (Exception e) {
			e.printStackTrace();
			return "Invalid Message Signature";
		}
	}

	/*
	 * Service to change message types from Input to Output.
	 */
	public static void MessageTypeChange(EObject t) {
		try {
			int dialogResult = MessageDialogs.ConfirmChangeMessageTypeImpact();

			RefMessage refMsg = (RefMessage) t;
			Message msg = refMsg.getRefMsg();

			if (dialogResult == JOptionPane.YES_OPTION) {
				ModelOperations2.changeMessageTypeForTheFeatures(refMsg, msg, JOptionPane.YES_OPTION);
			} else if (dialogResult == JOptionPane.NO_OPTION) {
				ModelOperations2.changeMessageTypeForTheFeatures(refMsg, msg, JOptionPane.NO_OPTION);
			} else
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Opens dialog for message edit by double click.
	 */
	public static void EditFeatureMessageLabelByDoubleClick(EObject t) {
		RefMessage refmsg = ((RefMessage) ((DNodeListElementSpec) t).getTarget());
		Message oldMessage = (Message) refmsg.getRefMsg();

		//Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(oldMessage);
		// if (referrers.size() == 0) {
		// openEditMessageForm(refmsg);
		// return;
		// }

		List<List<Attribute>> ToBeEdited_Atts = new ArrayList<List<Attribute>>();
		List<List<Attribute>> ToBeAdded_Atts = new ArrayList<List<Attribute>>();
		List<List<Attribute>> ToBeDeleted_Atts = new ArrayList<List<Attribute>>();

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(oldMessage);
		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@java.lang.Override
			protected void doExecute() {
				try {
					final Display display = Display.getDefault();
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							try {
								while (ToBeEdited_Atts.size() < 10) {
									List<Attribute> a = new ArrayList<Attribute>();
									a.add(null);
									a.add(null);
									ToBeEdited_Atts.add(a);

								}
								FrmShellForMessageEdit messageDeleteBox = new FrmShellForMessageEdit(display,
										oldMessage, ToBeEdited_Atts, ToBeAdded_Atts, ToBeDeleted_Atts);
								messageDeleteBox.open();

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Service to direct edit message label. If has uses in feature modules , it
	 * will open a dialog for change management.
	 */
	public static void EditFeatureMessageLabel(EObject t, String newMessageName, CustomVirtualResource vres) {

		try {

			Message oldMessage = (Message) ((RefMessage) t).getRefMsg();

			HashMap<EObject, String> map_GuardToText = ModelUtils2.getGuardUsageText(oldMessage);

			if (newMessageName.trim().length() > 0) {
				String newName = WorldModelCommonServices.parseMessageName(newMessageName);

				String newType = WorldModelCommonServices.parseMessageType(newMessageName);

				AttributeType typeToBeSet = ModelUtils2.createAttributeType(newType);

				// The new message name is the same as another existing message
				// name, so we might need to Merge the newnamed message with the
				// already existing message
				Message ifExisitngMessage = NameUniquenessVerifier.verifyAndReturnMessage((Message) oldMessage, newName,
						false);
				if (ifExisitngMessage != null) {
					// do you want to use the existing feature ?
					int dialogResult = MessageDialogs.ConfirmMergeMessagesIfAlreadyExist(newName);

					if (dialogResult == 0) {
						ModelOperations2.preMergeProcessing(ifExisitngMessage, (RefMessage) t);
					}

					return;
				}

				// Assume default behaviour should be just as NONE option
				int confirmDialogResult = -1;
				// If we're changing only message parameters but the message
				// name is
				// still the same, it should be propagated to all the messages
				// by
				// default
				if (newName.equalsIgnoreCase(oldMessage.getName())) {
					confirmDialogResult = MessageDialogs.ConfirmChangeMessageNameImpact(oldMessage,
							JOptionPane.YES_NO_OPTION);

					if (confirmDialogResult == JOptionPane.NO_OPTION)
						return;

				} else {
					confirmDialogResult = MessageDialogs.ConfirmChangeMessageNameImpact(oldMessage,
							JOptionPane.YES_NO_CANCEL_OPTION);

					if (confirmDialogResult == JOptionPane.CANCEL_OPTION)
						return;
					// It creates a new message for the feature rather than
					// propagating the change to all the message
					else if (confirmDialogResult == JOptionPane.NO_OPTION) {

						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(oldMessage);
						final CommandStack commandStack = editingDomain.getCommandStack();
						commandStack.execute(new RecordingCommand(editingDomain) {

							@java.lang.Override
							protected void doExecute() {
								Feature parentFeature = (Feature) (ModelUtils.getTypedRootForObject(t, Feature.class));
								RefMessage refMessage = (RefMessage) t;

								Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(oldMessage);
								if (referrers.size() > 0) {
									final Display display = Display.getDefault();
									Display.getDefault().syncExec(new Runnable() {
										public void run() {
											try {

												FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new FrmShellForCrossReferenceView_TreeStyle(
														display, referrers, oldMessage);
												messageDeleteBox.open();

												if (messageDeleteBox.ConfirmFlag)
													ModelOperations2.editMessageForOneFeature(parentFeature, oldMessage,
															refMessage, newMessageName, typeToBeSet);

											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
								} else {
									ModelOperations2.editMessageForOneFeature(parentFeature, oldMessage, refMessage,
											newMessageName, typeToBeSet);
								}

							}
						});
					}
				}

				// propagates the message name change to all the referring
				// messages
				if (confirmDialogResult == JOptionPane.YES_OPTION || confirmDialogResult == -1) {

					List<List<Attribute>> ToBeEdited_Atts = new ArrayList<List<Attribute>>();
					List<List<Attribute>> ToBeAdded_Atts = new ArrayList<List<Attribute>>();
					List<List<Attribute>> ToBeDeleted_Atts = new ArrayList<List<Attribute>>();

					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(oldMessage);
					final CommandStack commandStack = editingDomain.getCommandStack();
					commandStack.execute(new RecordingCommand(editingDomain) {

						@java.lang.Override
						protected void doExecute() {
							try {
								final Display display = Display.getDefault();
								Display.getDefault().syncExec(new Runnable() {
									public void run() {
										try {
											boolean isReferenced = false;

											List<Attribute> newAttrList = WorldModelCommonServices
													.parseMessageParams(ModelUtils.getWorldModel(t), newMessageName);

											List<ExprRef> notCoveredAttList = new ArrayList<ExprRef>();
											notCoveredAttList.addAll(oldMessage.getAttributes());

											for (Attribute new_att : newAttrList) {
												boolean isNewAttExists = false;
												for (ExprRef curr_att : oldMessage.getAttributes()) {
													if (((Attribute) curr_att).getName()
															.equalsIgnoreCase(new_att.getName())) {
														List<Attribute> a = new ArrayList<Attribute>();
														a.add((Attribute) curr_att);
														a.add(new_att);
														ToBeEdited_Atts.add(a);

														notCoveredAttList.remove((Attribute) curr_att);

														isNewAttExists = true;

														if (isReferenced == false) {
															Collection<Setting> referrers = ModelUtils2
																	.findReferencedObjects(curr_att,
																			ModelUtils.getBehaviourModel(curr_att));
															if (referrers.size() > 0) {
																isReferenced = true;
															}
														}

														break;
													}
												}
												if (isNewAttExists == false) {
													List<Attribute> a = new ArrayList<Attribute>();
													a.add(null);

													a.add(new_att);
													ToBeAdded_Atts.add(a);
												}
											}

											for (ExprRef ncl : notCoveredAttList) {
												List<Attribute> a = new ArrayList<Attribute>();
												a.add((Attribute) ncl);

												a.add(null);
												ToBeDeleted_Atts.add(a);

												if (isReferenced == false) {
													Collection<Setting> referrers = ModelUtils2.findReferencedObjects(
															ncl, ModelUtils.getBehaviourModel(ncl));
													if (referrers.size() > 0) {
														isReferenced = true;
													}
												}

											}

											// open the form if there are
											// references to the attributes of
											// the message in the behavioural
											// model
											if (isReferenced == true) {
												FrmShellForMessageEdit messageDeleteBox = new FrmShellForMessageEdit(
														display, oldMessage, ToBeEdited_Atts, ToBeAdded_Atts,
														ToBeDeleted_Atts);
												messageDeleteBox.open();
											} else {
												ModelOperations.EditMessage(newName, typeToBeSet, oldMessage,
														newAttrList);
											}

										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});

							} catch (Exception e) {

							}
						}
					});
				} else
					return;

				ModelUtils2.checkGuardsForSoundNess(t, vres, map_GuardToText);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Service to create a new input message with a unique name.
	 */
	public static void createNewInputMessage(EObject any) {
		Feature parentFeature = ModelUtils.getTypedRootForObject(any, Feature.class);
		if (parentFeature != null) {
			ModelOperations.addNewInputMessageToFeature((Feature) parentFeature, FormlFactory.eINSTANCE.createInput(),
					"");
		}
	}

	/*
	 * Service to add the dropped message into its new parent feature.
	 */
	public static void containerDropMessage(EObject newContainerFeature, RefMessage refMessage) {
		ModelOperations.importMessageToFeature((Feature) newContainerFeature, refMessage.getRefMsg());
	}

	/*
	 * Service to create a new output message with a unique name.
	 */
	public static void createNewOutputMessage(EObject any) {
		Feature parentFeature = ModelUtils.getTypedRootForObject(any, Feature.class);
		if (parentFeature != null) {
			ModelOperations.addNewOutputMessageToFeature((Feature) parentFeature, FormlFactory.eINSTANCE.createOutput(),
					"");
		}
	}

	/*
	 * Service to delete messages from features.
	 */
	public static void deleteMessageFromFeature(EObject F, EObject refMsg) {
		Message msg = ((RefMessage) refMsg).getRefMsg();

		// Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(msg);

		// if (referrers.size() == 0) {
		// ModelDeleteOperations.removeMessageFromFeature((Feature) F, (RefMessage)
		// refMsg);
		// } else {

		// DeleteMessageWithReferenceBox((Feature) F, (RefMessage) refMsg, referrers);
		// }

		Collection<Setting> referrers = ModelUtils2.getReferencesBySemanticType(msg);

		if (referrers.size() == 0) {
			ModelDeleteOperations.removeMessageFromFeature((Feature) F, (RefMessage) refMsg);
		} else {
			DeleteMessageWithReferenceBox((Feature) F, (RefMessage) refMsg, msg, referrers);
		}
	}

	private static CustomVirtualResource createVirtualOriginalResource(EObject element) {
		return new CustomVirtualResource(element);

	}

	/**
	 * if a message has cross references in feature modules, it will show a dialog
	 * to manages the changes and references
	 * 
	 * @param F
	 * @param refMsg
	 * @param msg
	 * @param crossRefs
	 */
	public static void DeleteMessageWithReferenceBox(Feature F, RefMessage refMsg, Message msg,
			Collection<Setting> crossRefs) {

		final Display display = Display.getDefault();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {

					CustomVirtualResource vres = createVirtualOriginalResource(refMsg);

					// FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new
					// FrmShellForCrossReferenceView_TreeStyle(
					// display, crossRefs, refMsg.getRefMsg());

					FrmShellForCrossReferenceView_TreeStyle messageDeleteBox = new FrmShellForCrossReferenceView_TreeStyle(
							display, crossRefs, refMsg.getRefMsg());

					messageDeleteBox.open();

					if (messageDeleteBox.ConfirmFlag == true)
						ModelDeleteOperations.removeMessageFromFeature((Feature) F, msg, refMsg);
					else if (messageDeleteBox.ConfirmFlag == false) {
						vres.revertBack();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Opens Edit Message Form
	 */
	public static void openEditMessageForm(EObject t) {
		try {
			Message msg = ((RefMessage) t).getRefMsg();

			FrmEditFeatureMessage frmEditMsg = new FrmEditFeatureMessage(msg);
			frmEditMsg.setVisible(true);

			if (frmEditMsg.confirmFlag == true) {
				(msg).setName(frmEditMsg.newMessage.getName());

				(msg).getAttributes().clear();
				(msg).getAttributes().addAll(frmEditMsg.newMessage.getAttributes());
			}
			frmEditMsg.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
