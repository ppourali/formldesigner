package uw.cs.watform.forml.services.GUI.TransitionDialogBox;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.CustomEmbeddedEditorResourceProvider;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.odesign.GUI.tabularGuard.CommonSpace;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForContextualUI;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences2;

public class oldDNDOperationsForListItems {
/*	private static CommonSpaceForContextualUI commonspace;
	private static List dragSource;

	public static EmbeddedEditor editor_Event;
	public static EmbeddedEditorModelAccess partialEditorModelAccess_Event;

	public static EmbeddedEditor editor_Action;
	public static EmbeddedEditorModelAccess partialEditorModelAccess_Action;

	public static EmbeddedEditor editor_Guard;
	public static EmbeddedEditorModelAccess partialEditorModelAccess_Guard;

	public static void setDragSource(List dragList) {

		// Allow data to be copied from the drag source
		int operations = DND.DROP_MOVE | DND.DROP_COPY;
		DragSource source = new DragSource(dragList, operations);

		// Provide data in Text format
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		source.setTransfer(types);

		source.addDragListener(new DragSourceListener() {
			public void dragStart(DragSourceEvent event) {
				// Only start the drag if there is actually text in the
				// label - this text will be what is dropped on the target.
				if (dragList.getSelectionCount() == 0) {
					event.doit = false;
				}
			}

			public void dragSetData(DragSourceEvent event) {
				// Provide the data of the requested type.
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = dragList.getSelection()[0];
					dragSource = dragList;
					// getCommonspace().setDraggedDataForGuard((ExprRef) dragLabel.getData());

					// if (((ExprRef) dragLabel.getData()) instanceof Message)
					// getCommonspace().setDraggedDataForAction((Concept) dragLabel.getData());
				}
			}

			public void dragFinished(DragSourceEvent event) {
			}
		});
	}

	public static void setDragDropTargetForEvent(Control targetControl) {
		// Allow data to be copied or moved to the drop target
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;

		// Receive data in Text or File format
		final TextTransfer textTransfer = TextTransfer.getInstance();
		Transfer[] types = new Transfer[] { textTransfer };

		DropTarget target = new DropTarget(targetControl, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
				if (textTransfer.isSupportedType(event.currentDataType)) {
					// NOTE: on unsupported platforms this will return null
					Object o = textTransfer.nativeToJava(event.currentDataType);
					String t = (String) o;

				}
			}

			public void dragOperationChanged(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {
				if (dragSource == null)
					return;

				if (textTransfer.isSupportedType(event.currentDataType)) {
					if (event.widget instanceof DropTarget) {
						if (((DropTarget) event.widget).getControl() instanceof StyledText) {
							Object element = dragSource.getData(((String) event.data));

							commonspace.setTriggeringEventOnDrop(element);

							// ((StyledText) ((DropTarget) event.widget).getControl()).setText(((String)
							// event.data));

							updateEventModel();
							// updateGuardModel("");
							// updateActionModel();
						}
					}
					dragSource = null;
//					if (getCommonspace().getDraggedDataForGuard() != null) {
//						//String text = ((String) event.data);
//
//						//((StyledText) targetControl).setText(text);
//						getCommonspace().setTriggeringEObject(getCommonspace().getDraggedDataForGuard());
//						if (getCommonspace().getTriggeringEObject() instanceof Attribute) {
//							getCommonspace().getBtnTriggeringEventAdding().setVisible(false);
//							getCommonspace().setIsAddingtriggeringEObject(CommonOperations.getEventMode());
//
//						} else {
//							getCommonspace().getBtnTriggeringEventAdding().setVisible(true);
//							getCommonspace().setIsAddingtriggeringEObject(CommonOperations.getEventMode());
//						}
//					}
				}
			}

		});
	}

	protected static void updateEventModel() {
		Resource originalResource = commonspace.getCurrentTransition().getTrig().eResource();

		CustomEmbeddedEditorResourceProvider resourceProvider = ModelUtils.getInjector()
				.getInstance(CustomEmbeddedEditorResourceProvider.class);

		XtextResource xTextResource = resourceProvider.createResource(commonspace.getCurrentTransition().getTrig());

		ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

		String semanticElementFragment = originalResource.getURIFragment(commonspace.getCurrentTransition().getTrig());
		EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		partialEditorModelAccess_Event.updateModel(pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1],
				pre_editable_suff_Fixes[2]);
		editor_Event.getViewer().getTextWidget().setEnabled(true);

	}

	protected static void updateGuardModel(String guardText) {
		Resource originalResource = commonspace.getCurrentTransition().getGuard().eResource();

		CustomEmbeddedEditorResourceProvider resourceProvider = ModelUtils.getInjector()
				.getInstance(CustomEmbeddedEditorResourceProvider.class);

		XtextResource xTextResource = resourceProvider.createResource(commonspace.getCurrentTransition().getGuard());

		ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

		String semanticElementFragment = originalResource.getURIFragment(commonspace.getCurrentTransition().getGuard());
		EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		if (guardText.contentEquals(""))
			guardText = pre_editable_suff_Fixes[1];

		partialEditorModelAccess_Guard.updateModel(pre_editable_suff_Fixes[0], guardText, pre_editable_suff_Fixes[2]);
		editor_Guard.getViewer().getTextWidget().setEnabled(true);
	}

	protected static void updateActionModel() {
		Resource originalResource = commonspace.getCurrentTransition().getList().eResource();

		CustomEmbeddedEditorResourceProvider resourceProvider = ModelUtils.getInjector()
				.getInstance(CustomEmbeddedEditorResourceProvider.class);

		XtextResource xTextResource = resourceProvider.createResource(commonspace.getCurrentTransition().getList());

		ICompositeNode rootNode = xTextResource.getParseResult().getRootNode();

		String semanticElementFragment = originalResource.getURIFragment(commonspace.getCurrentTransition().getList());
		EObject semanticElementInDocument = xTextResource.getEObject(semanticElementFragment);

		String[] pre_editable_suff_Fixes = findPartsForNode(rootNode, semanticElementInDocument);

		partialEditorModelAccess_Action.updateModel(pre_editable_suff_Fixes[0], pre_editable_suff_Fixes[1],
				pre_editable_suff_Fixes[2]);
		editor_Action.getViewer().getTextWidget().setEnabled(true);
	}

	protected static String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		try {
			String allText = rootNode.getText();

			ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

			String prefix = allText.substring(0, elementNode.getOffset() - 1);
			String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

			String suffix = allText.substring(elementNode.getEndOffset());

			parts[0] = prefix;
			parts[1] = editablePart;
			parts[2] = suffix;
		} catch (Exception e) {
			parts[0] = "";
			parts[1] = "[]";
			parts[2] = "";
		}
		return parts;
	}

	public static void setDragDropTargetForGuard(Control targetControl) {
		// Allow data to be copied or moved to the drop target
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;

		// Receive data in Text or File format
		final TextTransfer textTransfer = TextTransfer.getInstance();
		Transfer[] types = new Transfer[] { textTransfer };

		DropTarget target = new DropTarget(targetControl, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
				if (textTransfer.isSupportedType(event.currentDataType)) {
					// NOTE: on unsupported platforms this will return null
					Object o = textTransfer.nativeToJava(event.currentDataType);
					String t = (String) o;

				}
			}

			public void dragOperationChanged(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {
				if (dragSource == null)
					return;

				if (textTransfer.isSupportedType(event.currentDataType)) {

					Object element = dragSource.getData(((String) event.data));

					String guardtext = commonspace.setGuardOnDrop(element, editor_Guard);

					// commonspace.embeddedEditor_Guard.saveEditor(true);

					updateGuardModel("");
					// commonspace.embeddedEditor_Guard.saveEditor(true);

					// updateEventModel();
					// updateActionModel();

					dragSource = null;

				}
			}

		});
	}

	public static void setDragDropTargetForAction(Control targetControl) {
		// Allow data to be copied or moved to the drop target
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;

		// Receive data in Text or File format
		final TextTransfer textTransfer = TextTransfer.getInstance();
		Transfer[] types = new Transfer[] { textTransfer };

		DropTarget target = new DropTarget(targetControl, operations);
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_SELECT | DND.FEEDBACK_SCROLL;
				if (textTransfer.isSupportedType(event.currentDataType)) {
					// NOTE: on unsupported platforms this will return null
					Object o = textTransfer.nativeToJava(event.currentDataType);
					String t = (String) o;

				}
			}

			public void dragOperationChanged(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {
				if (dragSource == null)
					return;

				if (textTransfer.isSupportedType(event.currentDataType)) {

					Object element = dragSource.getData(((String) event.data));

					commonspace.setActionOnDrop(element);

					updateActionModel();
					// updateEventModel();
					// updateGuardModel("");

					dragSource = null;
//					if (getCommonspace().getDraggedDataForGuard() != null) {
//						//String text = ((String) event.data);
//
//						//((StyledText) targetControl).setText(text);
//						getCommonspace().setTriggeringEObject(getCommonspace().getDraggedDataForGuard());
//						if (getCommonspace().getTriggeringEObject() instanceof Attribute) {
//							getCommonspace().getBtnTriggeringEventAdding().setVisible(false);
//							getCommonspace().setIsAddingtriggeringEObject(CommonOperations.getEventMode());
//
//						} else {
//							getCommonspace().getBtnTriggeringEventAdding().setVisible(true);
//							getCommonspace().setIsAddingtriggeringEObject(CommonOperations.getEventMode());
//						}
//					}
				}
			}

		});
	}

	private static void addActionByDrop(Table table_Actions, Concept operation, int[] table_Actions_widths) {

	}

	public static CommonSpaceForContextualUI getCommonspace() {
		return commonspace;
	}

	public static void setCommonspace(CommonSpaceForContextualUI cs) {
		commonspace = cs;
	}

	

	private static void setDropTagets(StyledText styledText, Class type) {
		if (Trigger.class.equals(type)) {
			setDragDropTargetForEvent(styledText);
		} else if (Guard.class.equals(type)) {
			setDragDropTargetForGuard(styledText);
		} else if (WCAList.class.equals(type)) {
			setDragDropTargetForAction(styledText);
		}
	}
*/
}
