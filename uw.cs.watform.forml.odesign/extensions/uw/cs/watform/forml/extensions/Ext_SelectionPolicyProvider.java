package uw.cs.watform.forml.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeContainerSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListElementSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListSpec;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.Transition;

public class Ext_SelectionPolicyProvider implements IEditPolicyProvider {

	private List listeners = new ArrayList(1);

	@Override
	public void addProviderChangeListener(IProviderChangeListener listener) {
		this.listeners.add(listener);
	}

	@SuppressWarnings("restriction")
	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateEditPoliciesOperation) {
			CreateEditPoliciesOperation castedOperation = (CreateEditPoliciesOperation) operation;
			EditPart editPart = castedOperation.getEditPart();
			Object model = editPart.getModel();
			if (model instanceof View) {
				View view = (View) model;
				if (view.getElement() instanceof DEdgeSpec) {
					if (((DEdgeSpec) view.getElement()).getTarget() instanceof Transition) {
						return true;
					}
				} else if (view.getElement() instanceof DNodeContainerSpec) {
					if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof State) {
						return true;
					}
					if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof Region) {
						return true;
					}
					if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof Feature) {
						return true;
					}
				} else if (view.getElement() instanceof DNodeListElementSpec) {
					if (((DNodeListElementSpec) view.getElement()).getTarget() instanceof RefMessage) {
						return true;
					}
				} else if (view.getElement() instanceof DNodeListSpec) {
					return true;
				}

			}
		}
		return false;
	}

	@Override
	public void removeProviderChangeListener(IProviderChangeListener listener) {
		this.listeners.remove(listener);
	}

	@SuppressWarnings("restriction")
	@Override
	public void createEditPolicies(EditPart editPart) {

		EObject semanticObject = null;
		Object model = editPart.getModel();
		if (model instanceof View) {
			View view = (View) model;
			if (view.getElement() instanceof DEdgeSpec) {
				if (((DEdgeSpec) view.getElement()).getTarget() instanceof Transition) {
					semanticObject = (Transition) ((DEdgeSpec) view.getElement()).getTarget();
				}
			} else if (view.getElement() instanceof DNodeContainerSpec) {
				if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof State) {
					semanticObject = (State) ((DNodeContainerSpec) view.getElement()).getTarget();
				}
				if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof Region) {
					semanticObject = (Region) ((DNodeContainerSpec) view.getElement()).getTarget();
				}
				if (((DNodeContainerSpec) view.getElement()).getTarget() instanceof Feature) {
					semanticObject = (Feature) ((DNodeContainerSpec) view.getElement()).getTarget();
				}
			} else if (view.getElement() instanceof DNodeListElementSpec) {
				if (((DNodeListElementSpec) view.getElement()).getTarget() instanceof RefMessage) {
					semanticObject = (RefMessage) ((DNodeListElementSpec) view.getElement()).getTarget();
				}

			} else if (view.getElement() instanceof DNodeListSpec) {

				ContainerAutoSizeEditPolicy(editPart);

			}
		}

		if (semanticObject == null)
			return;
		else if (semanticObject instanceof State)
			StateEditPolicyInstallation(editPart, (State) semanticObject);
//		else if (semanticObject instanceof Transition)
//			TransitionEditPolicyInstallation(editPart, (Transition) semanticObject);
		else if (semanticObject instanceof Region)
			RegionEditPolicyInstallation(editPart, (Region) semanticObject);
		//else if (semanticObject instanceof RefMessage)
			//RefMessageEditPolicyInstallation(editPart, (RefMessage) semanticObject);
		// else if (semanticObject instanceof Feature)
		// ContainerAutoSizeEditPolicy(editPart, (Feature) semanticObject);

	}

	private void RefMessageEditPolicyInstallation(EditPart editPart1, RefMessage semanticObject) {
		(editPart1).addEditPartListener(new EditPartListener() {

			@Override
			public void selectedStateChanged(EditPart editpart2) {
				if (editpart2.getSelected() == EditPart.SELECTED_PRIMARY) {
					try {
						RefMessage refMessage = null;
						Object model = editpart2.getModel();
						if (model instanceof View) {
							View view = (View) model;
							if (view.getElement() instanceof DNodeListElementSpec) {
								if (((DNodeListElementSpec) view.getElement()).getTarget() instanceof RefMessage) {
									refMessage = (RefMessage) ((DNodeListElementSpec) view.getElement()).getTarget();
								}

							}
						}

						if (refMessage == null)
							return;

						IWorkbenchPart ActivePart = (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().getActivePart());
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
								"com.uwaterloo.cs.forml.odesign.PropertyEditor", null,
								org.eclipse.ui.IWorkbenchPage.VIEW_VISIBLE);

						ViewPart_PropertyEditor myView = (ViewPart_PropertyEditor) PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage()
								.findView("com.uwaterloo.cs.forml.odesign.PropertyEditor");

						if (myView != null) {

							myView.createMessageViewer(refMessage.getRefMsg());
							ActivePart.setFocus();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					clearPropertyEditor();
				}
			}

			@Override
			public void removingChild(EditPart child, int index) {
				// TODO Auto-generated method stub

			}

			@Override
			public void partDeactivated(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void partActivated(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void childAdded(EditPart child, int index) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void clearPropertyEditor() {

		ViewPart_PropertyEditor myView = (ViewPart_PropertyEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView("com.uwaterloo.cs.forml.odesign.PropertyEditor");

		if (myView != null) {
			myView.clearChildren();
		}
	}

	private void RegionEditPolicyInstallation(EditPart editPart, Region semanticObject) {
		// editPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		// PreferredSizeHandlerEditPolicy());

		(editPart).addEditPartListener(new EditPartListener() {

			@Override
			public void selectedStateChanged(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removingChild(EditPart child, int index) {
				// TODO Auto-generated method stub

			}

			@Override
			public void partDeactivated(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void partActivated(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void childAdded(EditPart child, int index) {

			}
		});

	}

	private void TransitionEditPolicyInstallation(EditPart editPart, Transition semanticObject) {

	
		(editPart).addEditPartListener(new EditPartListener() {

			@Override
			public void selectedStateChanged(EditPart editpart) {
				if (editpart.getSelected() == EditPart.SELECTED_PRIMARY) {
					try {
						Transition trans = null;
						Object model = editPart.getModel();
						if (model instanceof View) {
							View view = (View) model;
							if (view.getElement() instanceof DEdgeSpec) {
								if (((DEdgeSpec) view.getElement()).getTarget() instanceof Transition) {
									trans = (Transition) ((DEdgeSpec) view.getElement()).getTarget();
								}

							}
						}

						if (trans == null)
							return;

						IWorkbenchPart ActivePart = (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().getActivePart());

						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
								"com.uwaterloo.cs.forml.odesign.PropertyEditor", null,
								org.eclipse.ui.IWorkbenchPage.VIEW_VISIBLE);

						ViewPart_PropertyEditor myView = (ViewPart_PropertyEditor) PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage()
								.findView("com.uwaterloo.cs.forml.odesign.PropertyEditor");

						if (myView != null) {

							myView.createTransitionViewer(trans);
							ActivePart.setFocus();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					clearPropertyEditor();
				}
			}

			@Override
			public void removingChild(EditPart child, int index) {
				// TODO Auto-generated method stub

			}

			@Override
			public void partDeactivated(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void partActivated(EditPart editpart) {
				// TODO Auto-generated method stub

			}

			@Override
			public void childAdded(EditPart child, int index) {
				// TODO Auto-generated method stub

			}
		});
		// .installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new
		// HighLightEditPolicy());
		// ((SelectionEditPolicy)editPart.getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE))
		// (editPart).installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		// CustomConnectionEditPolicy());

	}

	private void StateEditPolicyInstallation(EditPart editPart, State semanticObject) {

		// ConnectionHandleEditPolicy a = new ConnectionHandleEditPolicy();
		// editPart.installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
		// a);
		//
		// editPart.installEditPolicy(EditPolicy.LAYOUT_ROLE, new
		// XYLayoutEditPolicy() {
		// @Override
		// protected Command getResizeChildrenCommand(ChangeBoundsRequest
		// request) {
		// CompoundCommand result = new CompoundCommand();
		// result.add(super.getResizeChildrenCommand(request));
		// AdjustIdentityAnchorCommand command = new
		// AdjustIdentityAnchorCommand(TransactionUtil
		// .getEditingDomain(semanticObject), request);
		// result.add(new ICommandProxy(command));
		// return result;
		// }
		//
		// @Override
		// protected Command getCreateCommand(CreateRequest request) {
		// // TODO Auto-generated method stub
		// return null;
		// }
		// });
		//
		// editPart.installEditPolicy(EnlargeContainerEditPolicy.ROLE, new
		// EnlargeContainerEditPolicy());

		// editPart.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new
		// PreferredSizeHandlerEditPolicy());

	}

	protected void fireProviderChanged() {
		ProviderChangeEvent event = new ProviderChangeEvent(this);
		Iterator iterListener = this.listeners.iterator();
		while (iterListener.hasNext()) {
			IProviderChangeListener listener = (IProviderChangeListener) iterListener.next();
			listener.providerChanged(event);
		}
	}

	private void ContainerAutoSizeEditPolicy(EditPart editPart) {

	}

}
