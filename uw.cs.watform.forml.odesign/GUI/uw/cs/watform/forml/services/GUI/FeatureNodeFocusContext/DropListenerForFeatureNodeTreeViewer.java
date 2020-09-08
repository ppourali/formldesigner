//package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;
//
//import org.eclipse.jface.viewers.TreeViewer;
//import org.eclipse.swt.custom.StyledText;
//import org.eclipse.swt.dnd.DND;
//import org.eclipse.swt.dnd.DragSource;
//import org.eclipse.swt.dnd.DragSourceEvent;
//import org.eclipse.swt.dnd.DragSourceListener;
//import org.eclipse.swt.dnd.DropTarget;
//import org.eclipse.swt.dnd.DropTargetEvent;
//import org.eclipse.swt.dnd.DropTargetListener;
//import org.eclipse.swt.dnd.TextTransfer;
//import org.eclipse.swt.dnd.Transfer;
//import org.eclipse.swt.widgets.Control;
//
//import uw.cs.watform.forml.forml.Roleable;
//import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.NewElementsCreationHelperClass;
//import uw.cs.watform.forml.services.utilities.ModelOperations2;
//
//public class DropListenerForFeatureNodeTreeViewer {
//
//	protected static TreeViewer dragSource;
//
//	public static void setDragSource(TreeViewer dragList) {
//
//		setDragSourceAsList(dragList);
//	}
//
//	protected static void setDragSourceAsList(TreeViewer dragList) {
//
//		// Allow data to be copied from the drag source
//		int operations = DND.DROP_MOVE | DND.DROP_COPY;
//		DragSource source = new DragSource(dragList, operations);
//
//		// Provide data in Text format
//		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
//		source.setTransfer(types);
//
//		source.addDragListener(new DragSourceListener() {
//			public void dragStart(DragSourceEvent event) {
//				// Only start the drag if there is actually text in the
//				// label - this text will be what is dropped on the target.
//				if (dragList.getSelectionCount() == 0) {
//					event.doit = false;
//				}
//			}
//
//			public void dragSetData(DragSourceEvent event) {
//				// Provide the data of the requested type.
//				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
//					event.data = dragList.getSelection()[0].getText();
//					dragSource = dragList;
//					// getCommonspace().setDraggedDataForGuard((ExprRef) dragLabel.getData());
//
//					// if (((ExprRef) dragLabel.getData()) instanceof Message)
//					// getCommonspace().setDraggedDataForAction((Concept) dragLabel.getData());
//				}
//			}
//
//			public void dragFinished(DragSourceEvent event) {
//			}
//		});
//	}
//
//	public static void setDragDropTarget(Control targetControl) {
//		// Allow data to be copied or moved to the drop target
//		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
//
//		// Receive data in Text or File format
//		final TextTransfer textTransfer = TextTransfer.getInstance();
//		Transfer[] types = new Transfer[] { textTransfer };
//
//		DropTarget target = new DropTarget(targetControl, operations);
//		target.setTransfer(types);
//
//		target.addDropListener(new DropTargetListener() {
//			public void dragEnter(DropTargetEvent event) {
//				if (event.detail == DND.DROP_DEFAULT) {
//					if ((event.operations & DND.DROP_COPY) != 0) {
//						event.detail = DND.DROP_COPY;
//					} else {
//						event.detail = DND.DROP_NONE;
//					}
//				}
//
//			}
//
//			public void dragOver(DropTargetEvent event) {
//				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
//				// if (textTransfer.isSupportedType(event.currentDataType)) {
//				// NOTE: on unsupported platforms this will return null
//				// Object o = textTransfer.nativeToJava(event.currentDataType);
//				// String t = (String) o;
//
//				// }
//			}
//
//			public void dragOperationChanged(DropTargetEvent event) {
//				if (event.detail == DND.DROP_DEFAULT) {
//					if ((event.operations & DND.DROP_COPY) != 0) {
//						event.detail = DND.DROP_COPY;
//					} else {
//						event.detail = DND.DROP_NONE;
//					}
//				}
//
//			}
//
//			public void dragLeave(DropTargetEvent event) {
//			}
//
//			public void dropAccept(DropTargetEvent event) {
//			}
//
//			public void drop(DropTargetEvent event) {
//				if (dragSource == null)
//					return;
//
//				if (textTransfer.isSupportedType(event.currentDataType)) {
//					if (event.widget instanceof DropTarget) {
//						if (((DropTarget) event.widget).getControl() instanceof Table) {
//							if (dragSource.getParent() instanceof CustomListForClasses) {
//
//								CustomListForClasses customListCompositeForSource = ((CustomListForClasses) dragSource
//										.getParent());
//								Object srcElement = customListCompositeForSource.getData(((String) event.data));
//
//								if (srcElement instanceof Roleable) {
//									// NewElementsCreationHelperClass.CreateNewAssociation(srcElement);
//
//									if (((DropTarget) event.widget).getControl().getParent() != null
//											&& ((DropTarget) event.widget).getControl()
//													.getParent() instanceof CustomListForClasses) {
//										CustomListForClasses customListCompositeForTarget = ((CustomListForClasses) ((DropTarget) event.widget)
//												.getControl().getParent());
//
//										NewElementsCreationHelperClass.CreateNewAssociation(srcElement,
//												customListCompositeForTarget, ((String) event.data));
//									} else {
//										NewElementsCreationHelperClass.CreateNewAssociation(srcElement, null, "");
//									}
//
//								}
//							}
//						}
//					}
//					dragSource = null;
//				}
//			}
//
//		});
//	}
//}

package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.widgets.TreeItem;

import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.services.general.JS_FeatureModelServices;
import uw.cs.watform.forml.services.reconnect.JS_Action_Reconnect_On_FeatureModel;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class DropListenerForFeatureNodeTreeViewer extends AbstractDNDForFeatureNodeVeiwer {

	private final TreeViewer viewer;

	public DropListenerForFeatureNodeTreeViewer(TreeViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	public void drop(DropTargetEvent event) {
		// System.out.println(event.data);
		if (event.item instanceof TreeItem) {
			TreeItem treeItem = ((TreeItem) event.item);
			Object droppedOnFeature = treeItem.getData();
			performDrop(event.data, droppedOnFeature);
		}

		super.drop(event);
	}

	// This method performs the actual drop
	// We simply add the String we receive to the model and trigger a refresh of the
	// viewer by calling its setInput method.
	public boolean performDrop(Object source, Object dest) {
		EObject draggedEObject = this.getDragedEObjectsByKey(source.toString());
		if (draggedEObject != null && dest != null) {
			if (draggedEObject instanceof Node && dest instanceof Node) {
				Node movingFeatureNode = ((Node) draggedEObject);
				Node oldParenttFeatureNode = ModelUtils.getTypedRootForObject(movingFeatureNode.eContainer(),
						Node.class);
				Node newParenttFeatureNode = ((Node) dest);

				if (movingFeatureNode instanceof OrNode || movingFeatureNode instanceof XORNode
						|| movingFeatureNode instanceof AndNode) {
					JS_FeatureModelServices.MoveLogicalNodes(newParenttFeatureNode, movingFeatureNode,
							oldParenttFeatureNode);
				} else {
					JS_Action_Reconnect_On_FeatureModel.Reconnect_Nodes(movingFeatureNode, oldParenttFeatureNode,
							newParenttFeatureNode);
				}
			}
		}

		// System.out.println(draggedEObject);
		// ContentProviderTree.INSTANCE.getModel().add(data.toString());
		// viewer.setInput(ContentProviderTree.INSTANCE.getModel());
		return false;
	}

}
