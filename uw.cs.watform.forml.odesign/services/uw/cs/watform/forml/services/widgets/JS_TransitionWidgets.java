package uw.cs.watform.forml.services.widgets;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.services.GUI.FrmCustomActionSelectionWizard;
import uw.cs.watform.forml.services.GUI.FrmCustomTriggeringEventSelectionWizard;
import uw.cs.watform.forml.services.utilities.ModelDeleteOperations;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * This is a java service class used in Sirius to handle deleting entities on
 * Feature Models.
 * 
 * 
 * @author ppourali
 * 
 */
public class JS_TransitionWidgets {

	public static void widgetDeleteTriggeringEvent(EObject t) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(t));

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				final Display display = Display.getDefault();
				display.syncExec(new Runnable() {
					public void run() {
						try {
							if (t instanceof Transition) {
								Transition trans = ((Transition) t);

								EcoreUtil.delete(trans.getTrig());
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			}
		});

	}

	public static void widgetDeleteGuard(EObject t) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(t));

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				final Display display = Display.getDefault();
				display.syncExec(new Runnable() {
					public void run() {
						try {
							if (t instanceof Transition) {
								Transition trans = ((Transition) t);

								EcoreUtil.delete(trans.getGuard().getPredicate());
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			}
		});

	}

	public static void widgetChangeTriggeringEvent(EObject t) {

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(t));

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				final Display display = Display.getDefault();
				display.syncExec(new Runnable() {
					public void run() {
						try {
							if (t instanceof Transition) {
								Transition trans = ((Transition) t);

								Roleable parentFeature = ModelUtils.getTypedRootForObject(trans, FeatureModule.class)
										.getFeatureref();

								boolean hasevent = true;
								try {
									trans.getTrig().getWce().getAddobj();
									trans.getTrig().getWce().getAttr();
									trans.getTrig().getWce().getRemobj();
								} catch (Exception e) {
									hasevent = false;
								}

								try {
									if (parentFeature instanceof Feature) {
										WorldModel wm = ModelUtils.getWorldModel(t.eCrossReferences().get(0));
										FrmCustomTriggeringEventSelectionWizard featureSelection = new FrmCustomTriggeringEventSelectionWizard(
												wm, trans, (Feature) parentFeature);
										featureSelection.setModal(true);
										featureSelection.setAlwaysOnTop(true);
										featureSelection.setVisible(true);
										if (featureSelection.ConfirmFlag) {

											Message selectedMessage = featureSelection.selectedOperation;

											if (featureSelection.createFlag) {
												ModelUtils.getWorldModel(parentFeature).getConcepts()
														.add(selectedMessage);
												RefMessage newRefMessage = FormlFactory.eINSTANCE.createRefMessage();
												newRefMessage.setRefMsg(selectedMessage);
												((Feature) parentFeature).getInputlist().getInputs().add(newRefMessage);
											}
											if (hasevent) {
												trans.getTrig().getWce().setAddobj(selectedMessage);
											} else {
												Trigger trig = FormlFactory.eINSTANCE.createTrigger();
												WCE wce = FormlFactory.eINSTANCE.createWCE();
												wce.setAddobj(selectedMessage);
												trig.setWce(wce);
												trans.setTrig(trig);
											}

										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			}
		});

	}

	public static void widgetChangeActions(EObject t) {

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(t));

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				final Display display = Display.getDefault();
				display.syncExec(new Runnable() {
					public void run() {
						try {
							if (t instanceof Transition) {
								Transition trans = ((Transition) t);

								Roleable parentFeature = ModelUtils.getTypedRootForObject(trans, FeatureModule.class)
										.getFeatureref();

								try {
									trans.getList();
								} catch (Exception e) {
									WCAList wcalist = FormlFactory.eINSTANCE.createWCAList();
									trans.setList(wcalist);
								}

								try {
									if (parentFeature instanceof Feature) {
										WorldModel wm = ModelUtils.getWorldModel(t.eCrossReferences().get(0));
										FrmCustomActionSelectionWizard featureSelection = new FrmCustomActionSelectionWizard(
												wm, trans, (Feature) parentFeature);
										featureSelection.setModal(true);
										featureSelection.setAlwaysOnTop(true);
										featureSelection.setVisible(true);
										if (featureSelection.ConfirmFlag) {

											Message selectedMessage = featureSelection.selectedOperation;

											if (featureSelection.createFlag) {
												ModelUtils.getWorldModel(parentFeature).getConcepts()
														.add(selectedMessage);
												RefMessage newRefMessage = FormlFactory.eINSTANCE.createRefMessage();
												newRefMessage.setRefMsg(selectedMessage);
												((Feature) parentFeature).getOutputlist().getOutputs()
														.add(newRefMessage);
											}

											WCA wca = FormlFactory.eINSTANCE.createWCA();
											wca.setName("a" + (trans.getList().getActions().size() + 1));
											Action action = FormlFactory.eINSTANCE.createAction();
											// action.setName("");
											action.setType(selectedMessage);
											wca.setAction(action);
											trans.getList().getActions().add(wca);
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			}
		});
	}

	// public static void widgetDeleteAction(EObject t, List<Button>
	// action_checkboxes) {
	// if (action_checkboxes == null || action_checkboxes.isEmpty())
	// return;
	//
	// TransactionalEditingDomain editingDomain =
	// TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(t));
	//
	// final CommandStack commandStack = editingDomain.getCommandStack();
	// commandStack.execute(new RecordingCommand(editingDomain) {
	//
	// @Override
	// protected void doExecute() {
	//
	// final Display display = Display.getDefault();
	// display.syncExec(new Runnable() {
	// public void run() {
	// try {
	// if (t instanceof Transition) {
	// Transition trans = ((Transition) t);
	//
	// for (Button b : action_checkboxes) {
	// if (b.getSelection())
	// EcoreUtil.delete(((Action) b.getData()).eContainer());
	// }
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// });
	// }
	// });
	//
	// }

	public static void widgetDeleteAction(EObject t) {
//		if (action_checkboxes == null || action_checkboxes.isEmpty())
//			return;

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ModelUtils.getWorldModel(t));

		final CommandStack commandStack = editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {

				final Display display = Display.getDefault();
				display.syncExec(new Runnable() {
					public void run() {
						try {
							if (t instanceof Transition) {
								Transition trans = ((Transition) t);

								trans.getList().getActions().clear();

							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});
			}
		});

	}

	// Delete feature node
	public static void Delete_FeatureNode(EObject t) {
		Feature feature_to_be_deleted = ((Feature) t);

		// removing feature out of the tos list of any message pointing to it
		for (RefMessage refmsg : feature_to_be_deleted.getInputlist().getInputs()) {
			Input im = (Input) refmsg.getRefMsg();

			(im).getTos().remove(feature_to_be_deleted);

			if (im.getTos().isEmpty())
				ModelUtils.getWorldModel(feature_to_be_deleted).getConcepts().remove(im);
		}

		// removing feature out of the froms list of any message pointing to it
		for (RefMessage refmsg : feature_to_be_deleted.getOutputlist().getOutputs()) {
			Output om = (Output) refmsg.getRefMsg();

			(om).getFroms().remove(feature_to_be_deleted);

			if (om.getFroms().isEmpty())
				ModelUtils.getWorldModel(feature_to_be_deleted).getConcepts().remove(om);

		}

		ModelDeleteOperations.removeFeatureModuleFromBehaviouralModel(feature_to_be_deleted);

		EcoreUtil2.remove(feature_to_be_deleted);

	}

}
