package uw.cs.watform.forml.services.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.resource.ImageFileFormat;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.business.api.refresh.DiagramCreationUtil;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart;
import org.eclipse.sirius.diagram.ui.tools.internal.part.SiriusDiagramGraphicalViewer;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ScalingPolicy;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.Helper_InteractiveConsistencyManage;

public class RepresentationsUtils {
	public static final String CLASS_DIAGRAM_Name = "Features/Entities Class Diagram";// WorldModel_FeatureClasses_Diagram"; //$NON-NLS-1$
	public static final String CLASS_DIAGRAM_Id = "WorldModel_FeatureClasses_Diagram"; //$NON-NLS-1$
	public static final String FRAGMENT_DIAGRAM_Id = "Fragment_Diagram"; //$NON-NLS-1$

	public static final String FeatureModel_DIAGRAM_Id = "WorldModel_FeatureModel_Diagram"; //$NON-NLS-1$

	public static final String FeatureModule_DIAGRAM_Id = "FeatureModule_Diagram"; //$NON-NLS-1$
	public static final String DASHBOARD_DIAGRAM_DESCRIPTION_ID = "DashBoard_Diagram"; //$NON-NLS-1$

	public static boolean notFeatureModuleExists(EObject t) {

		Roleable feature = null;
		if (t instanceof FeatureNode) {
			feature = ((FeatureNode) t).getFeature();
		} else if (t instanceof Feature) {
			feature = (Feature) t;
		} else if (t instanceof Entity) {
			feature = (Entity) t;
		}

		if (ModelUtils.getBehaviourModel(t) == null)
			return true;

		if (feature != null) {
			FeatureModule correspondingFuatureModule = ModelUtils.getFeatureModuleForFeature(feature);

			if (correspondingFuatureModule != null) {
				if (!objectAlreadyHasRepresentation(correspondingFuatureModule))
					return true;
				else
					return false;
			} else
				return true;

		}
		return false;

	}

	public static boolean isFeatureModuleExists(EObject t) {
		Roleable feature = ModelUtils2.GetRoleable(t);
//		feature=ModelUtils2.GetRoleable(t);
//		if (t instanceof FeatureNode) {
//			feature = ((FeatureNode) t).getFeature();
//		} else if (t instanceof Feature) {
//			feature = (Feature) t;
//		} else if (t instanceof Entity) {
//			feature = (Entity) t;
//		}

		if (ModelUtils.getBehaviourModel(t) == null)
			return false;

		if (feature != null) {
			FeatureModule correspondingFuatureModule = ModelUtils.getFeatureModuleForFeature(feature);

			if (correspondingFuatureModule != null) {
				if (!objectAlreadyHasRepresentation(correspondingFuatureModule))
					return false;
				else
					return true;
			} else
				return false;

		}
		return false;
	}

	/**
	 * Get the all representations except the dashboard.
	 *
	 * @param any Semantic element
	 * @return All the representations available in the session except the
	 *         dashboard.
	 */
	public static Collection<DRepresentation> getAllRepresentations(EObject any) {
		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		final List<DRepresentation> result = Lists.newArrayList(representations);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
			
				if (DASHBOARD_DIAGRAM_DESCRIPTION_ID.equals(diagram.getDescription().getName())) {
					result.remove(representation);
				}
			}
		}

		result.removeAll(removeDanglingRepresentations(result));
		return result;
	}

//	public static DRepresentation CopyRepresentation(String newName, DRepresentation representation) {
//		final Session session = SessionManager.INSTANCE.getSession(((DSemanticDecorator) representation).getTarget());
//
//		try {
//			DRepresentation copiedRep = DialectManager.INSTANCE.copyRepresentation(representation, newName, session,
//					new NullProgressMonitor());
//			return copiedRep;
//
//		} catch (
//
//		final Exception e) {
//			java.lang.System.out.println("Open representation " + representation.getName() + " failed"); //$NON-NLS-1$ //$NON-NLS-2$
//			java.lang.System.out.println(e);
//		}
//
//		return null;
//	}

	/**
	 * Get a representation description.
	 *
	 * @param eObject                     Semantic object
	 * @param session                     Session
	 * @param representationDescriptionId Representation description id
	 * @return Representation description
	 */
	public static RepresentationDescription getRepresentationDescription(EObject eObject, Session session,
			String representationDescriptionId) {
		final Collection<RepresentationDescription> representationDescriptions = DialectManager.INSTANCE
				.getAvailableRepresentationDescriptions(session.getSelectedViewpoints(false), eObject);
		for (final RepresentationDescription representationDescription : representationDescriptions) {
			if (representationDescriptionId.equals(representationDescription.getName())) {
				return representationDescription;
			}
		}
		return null;
	}

	/**
	 * Get the all representations except the dashboard sorted by name.
	 *
	 * @param any Semantic element
	 * @return All the representations available in the session except the
	 *         dashboard.
	 */
	public static Collection<DRepresentation> getRepresentationsSortedByName(EObject any) {
		final Collection<DRepresentation> representations = getAllRepresentations(any);
		final Function<DRepresentation, String> getNameFunction = new Function<DRepresentation, String>() {
			public String apply(DRepresentation from) {
				return from.getName().toLowerCase();
			}
		};
		final Ordering<DRepresentation> nameOrdering = Ordering.natural().onResultOf(getNameFunction);
		return nameOrdering.immutableSortedCopy(representations);
	}

	/**
	 * Get the all representations for Feature Model.
	 *
	 * @param any Semantic element
	 * @return All representations available for Feature Model.
	 */
	public static Collection<DRepresentation> getRepresentationsForFeatureModel(EObject any) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		final List<DRepresentation> result = Lists.newArrayList(representations);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
				if (!FeatureModel_DIAGRAM_Id.equals(diagram.getDescription().getName())) {
					result.remove(representation);
				}
			}
		}

		result.removeAll(removeDanglingRepresentations(result));
		return result;
	}

	/**
	 * Checks if any representation has been created for a Feature Model.
	 * 
	 * @param any
	 * @return false if representation created, true otherwise.
	 */
	public static boolean isFeatureModelRepresentationCreated(EObject any) {
		if (getRepresentationsForFeatureModel(any).size() > 0)
			return false;

		return true;
	}

	/**
	 * Checks if any representation has been created for a Feature Class.
	 * 
	 * @param any
	 * @return false if representation created, true otherwise.
	 */
	public static boolean isClassDiagramRepresentationCreated(EObject any) {
		if (getRepresentationsForFeatureClassDiagram(any).size() > 0)
			return false;

		return true;
	}

	/**
	 * Get the all representations for Feature Module sorted by name.
	 *
	 * @param any Semantic element
	 * @return All representations available for Feature Module sorted by name.
	 */
	public static Collection<DRepresentation> getRepresentationsForFeatureModulesSortedbyName(EObject any) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		final List<DRepresentation> result = Lists.newArrayList(representations);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
				if (!FeatureModule_DIAGRAM_Id.equals(diagram.getDescription().getName())) {
					result.remove(representation);
				}
			}
		}

		result.removeAll(removeDanglingRepresentations(result));

		final Function<DRepresentation, String> getNameFunction = new Function<DRepresentation, String>() {
			public String apply(DRepresentation from) {
				return from.getName().toLowerCase();
			}
		};
		final Ordering<DRepresentation> nameOrdering = Ordering.natural().onResultOf(getNameFunction);
		return nameOrdering.immutableSortedCopy(result);
	}

	/**
	 * Get the all representations for Feature and Class Diagram.
	 *
	 * @param any Semantic element
	 * @return All representations available for Feature and Class Diagram.
	 */
	public static Collection<DRepresentation> getRepresentationsForFeatureClassDiagram(EObject any) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		final List<DRepresentation> result = Lists.newArrayList(representations);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
				if (!CLASS_DIAGRAM_Id.equals(diagram.getDescription().getName())) {
					result.remove(representation);
				}
			}
		}

		result.removeAll(removeDanglingRepresentations(result));
		return result;
	}

	/**
	 * Get the all representations for Fragment Diagram.
	 *
	 * @param any Semantic element
	 * @return All representations available for Fragment Diagram.
	 */
	public static Collection<DRepresentation> getRepresentationsForFragmentDiagram(EObject any) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		final List<DRepresentation> result = Lists.newArrayList(representations);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
				if (!FRAGMENT_DIAGRAM_Id.equals(diagram.getDescription().getName())) {
					result.remove(representation);
				}
			}
		}

		result.removeAll(removeDanglingRepresentations(result));
		return result;
	}

	/**
	 * Open an existing representation.
	 *
	 * @param representation The representation to open
	 */
	public static void openRepresentation(final DRepresentation representation) {

		final Session session = SessionManager.INSTANCE.getSession(((DSemanticDecorator) representation).getTarget());

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					monitor.beginTask("Open representation " + representation.getName(), 100); //$NON-NLS-1$
					DialectUIManager.INSTANCE.openEditor(session, representation, monitor);
					monitor.done();
				}
			});
		} catch (final Exception e) {
			java.lang.System.out.println("Open representation " + representation.getName() + " failed"); //$NON-NLS-1$ //$NON-NLS-2$
			java.lang.System.out.println(e);
		}
	}

	/**
	 * Gets Representations for a particular object.
	 * 
	 * @param any
	 * @return
	 */
	public static Collection<DRepresentation> getRepresentationForAnyObject(EObject any,
			boolean returnOneSpecificDiagram) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(any, session);

		// exportRepresentationForAnyObject(session, representations.iterator().next());
		return representations;
	}

	public static void openRepresentationForAnyObject(EObject any) {

		try {
			Collection<DRepresentation> rep = getRepresentationForAnyObject(any, true);
			if (rep.iterator().hasNext())
				openRepresentation(rep.iterator().next());

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open Representations for a particular object detached.
	 * 
	 * @param any
	 * @return
	 */
	public static void openRepresentationInAParentShell(Shell parent, EObject any, int xOffset, int yOffset) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(any, session);
		DRepresentation current_representation = representations.iterator().next();

		// final IWorkbenchPage newpage =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		try {
			Helper_InteractiveConsistencyManage.OpenRelatedEditors(any, session, current_representation, parent,
					xOffset, yOffset);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// p.setParent(lll);

		// System.out.println(
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews());
		// System.out.println(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getOpenPerspectives()[0]
		// .getLabel());

		// System.out.println(((IEditorPart) editor).getEditorSite().toString());
		// editor.createPartControl(parent);
		// editor.getEditorSite().getPart().getSite().getShell().setSize(new
		// Point(100,100));

		// if (current_representation instanceof DSemanticDiagram) {
		// DSemanticDiagram diagram = (DSemanticDiagram) current_representation;
		// DiagramEditPart e = doInitGmfDiagram(session, parent, diagram);

		// DDiagramEditor editor = ((DDiagramEditor) partRef.getPart(true));

		// ((IEditorPart)e).createPartControl(parent);
		// current_representation,

		// e.createPartControl(parent);
		// }

		// final IEditorPart part = EclipseUIUtil.getActiveEditor();

		// String editorName =
		// DialectUIManager.INSTANCE.getEditorName(representations.iterator().next());
		// editorName+="";
	}

	/**
	 * Export Representations for a particular object as image.
	 * 
	 * @param any
	 * @return
	 */
	private static boolean exportRepresentationForAnyObject(EObject any) {
		Collection<DRepresentation> rep = getRepresentationForAnyObject(any, true);
		if (rep.size() > 0) {
			final Session session = SessionManager.INSTANCE.getSession(any);

			exportRepresentationForAnyRepresentation(session, rep.iterator().next());
			return true;
		}
		return false;
	}

	/**
	 * Export Representations for a particular object as image.
	 * 
	 * @param any
	 * @return
	 */
	public static Image exportRepresentationForAnyObjectAsSWTImage(EObject any) {
		Collection<DRepresentation> rep = getRepresentationForAnyObject(any, true);
		if (rep.size() > 0) {
			if (rep.iterator().hasNext()) {
				DRepresentation drep = rep.iterator().next();
				if (drep instanceof DDiagram) {
					Diagram gmfDiagram = getAssociatedGMFDiagram((DDiagram) drep);
					Image image = renderToSWTImage(gmfDiagram);
					return image;
				}
			}

		}
		return null;
	}

	public static org.eclipse.swt.graphics.Image renderToSWTImage(Diagram diagram) {
		if (null == diagram) {
			throw new NullPointerException("Argument 'diagram' is null"); //$NON-NLS-1$
		}

		try {
			DiagramEditPart diagramEP = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram);
			CustomDiagramImageGenerator imageGenerator = new CustomDiagramImageGenerator(diagramEP);

			return imageGenerator.createSWTImageDescriptorForDiagram().createImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private static Diagram getAssociatedGMFDiagram(DDiagram dDiagram) {

		final DiagramCreationUtil util = new DiagramCreationUtil(dDiagram);
		util.findAssociatedGMFDiagram();
		return util.getAssociatedGMFDiagram();
	}

	/**
	 * Export Representations for a particular object as image.
	 * 
	 * @param any
	 * @return
	 */
	private static boolean exportRepresentationForAnyRepresentation(Session session, DRepresentation representation) {

		ScalingPolicy sc = ScalingPolicy.NO_SCALING;

		ExportFormat exportFormat = new ExportFormat(ExportDocumentFormat.NONE, ImageFileFormat.JPG, sc);
		try {
			DialectUIManager.INSTANCE.export(representation, session, new Path("D:/image.jpg"), exportFormat,
					new NullProgressMonitor());
		} catch (SizeTooLargeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Checks if a particular object already has a representation.
	 * 
	 * @param any
	 * @return
	 */
	public static boolean objectAlreadyHasRepresentation(EObject any) {

		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(any, session);

		if (representations.size() > 0)
			return true;
		else
			return false;

		// final Session session = SessionManager.INSTANCE.getSession(any);
		// final Collection<DRepresentation> featureModule_representations =
		// getRepresentationsForFeatureModulesSortedbyName(any);
		// final Collection<DRepresentation> Fragment_representations =
		// getRepresentationsForFragmentDiagram(any);
		// //DialectManager.INSTANCE.getRepresentations(any, session);
		// //final List<DRepresentation> result =
		// Lists.newArrayList(representations);
		//
		// if (featureModule_representations.size() > 0 ||
		// Fragment_representations.size()>0)
		// return true;
		// else
		// return false;
	}

	private static List<DRepresentation> removeDanglingRepresentations(List<DRepresentation> representations) {

		final List<DRepresentation> resultToBeRemoved = new ArrayList<DRepresentation>();

		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				if (isDanglingRepresentation(representation))
					resultToBeRemoved.add(representation);
			}
		}

		return resultToBeRemoved;
	}

	private static boolean isDanglingRepresentation(DRepresentation representation) {
		return (new DRepresentationQuery(representation).isDanglingRepresentation());
	}

	public static DEdgeEditPart findEditPart(EObject t) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (page == null) {
			return null;
		} else {
			IEditorPart editor = page.getActiveEditor();
			if (editor instanceof DiagramEditor && editor != null) {
				DiagramEditor diagramEditor = (DiagramEditor) editor;
				DiagramEditPart diagramEditPart = diagramEditor.getDiagramEditPart();

				if (diagramEditPart != null) {

					// EditPart editpart =
					// diagramEditPart.findEditPart(diagramEditPart,
					// t);

					List<EditPart> allchildren = new ArrayList<EditPart>();
					HashSet all = EditPartUtilities.getAllNestedConnectionEditParts(diagramEditPart);

					for (Iterator children = all.iterator(); children.hasNext();) {

						DEdgeEditPart dEdgeEP = (((DEdgeEditPart) children.next()));

						if (dEdgeEP.getModel() instanceof Edge) {
							Edge model = ((Edge) dEdgeEP.getModel());

							if (model.getElement() instanceof DEdgeSpec) {
								for (EObject so : ((DEdgeSpec) model.getElement()).getSemanticElements()) {

									if (so == t)
										return dEdgeEP;

								}
							}
						}

						// EditPart child = (EditPart) children.next();
						// allchildren.add(child);
						// if (child instanceof DEdgeEditPart) {
						// return ((DEdgeEditPart) child);
						// }
					}
					// State s = ((Transition) t).getSrc();
					// EditPart editpart =
					// diagramEditPart.findEditPart(diagramEditPart, s);
					// for (EditPart ep : allchildren) {
					// java.lang.System.out.println(ep);
					// }
				}
			}
		}

		return null;
	}

	private static EditPart goThoroughchildren(EditPart editPart) {

		for (Iterator children = editPart.getChildren().iterator(); children.hasNext();) {
			EditPart child = (EditPart) children.next();
			if (child instanceof EditPart) {

				return null;// ((EditPart) child).getModel();
			}

			goThoroughchildren(child);
			// if (child instanceof DEdgeEditPart) {
			// return ((DEdgeEditPart) child);
			// }
		}
		return null;
	}

	public static void RunVaidation(IEditorPart editorPart) {

		// try {
		// WorkbenchPartDescriptor workbenchPartDescriptor = new
		// WorkbenchPartDescriptor(editorPart.getSite().getId(),
		// editorPart.getClass(), editorPart.getSite().getPage());
		// ValidateAction va = new ValidateAction(workbenchPartDescriptor);
		// va.run();
		// } catch (Exception e) {
		//
		// }

	}

	public static void SelectAndRevealElementsInDiagram(EObject elementToSelect, EObject element,
			IEditorPart editorPart) {
		if (elementToSelect.eResource() == null)
			return;

		if (!(editorPart instanceof DiagramEditor))
			return;

		List editParts = findEditPartsForElement(editorPart, element, EditPart.class);
		// System.out.println(transition.getName());

		if (editParts.size() > 0) {
			IGraphicalEditPart editPart = (IGraphicalEditPart) editParts.get(0);
			((DiagramEditor) editorPart).getDiagramGraphicalViewer().select(editPart);
			((DiagramEditor) editorPart).getDiagramGraphicalViewer().reveal(editPart);
		}
	}

	public static List findEditPartsForElement(IEditorPart editorPart, EObject element, Class editPartClass) {

		if (editorPart != null && editorPart instanceof DiagramEditor) {
			if (editorPart instanceof DiagramEditor) {
				DiagramEditPart diagramEditPart = ((DiagramEditor) editorPart).getDiagramEditPart();

				EditPartViewer viewer = diagramEditPart.getViewer();
				if (viewer instanceof SiriusDiagramGraphicalViewer) {

					List elems = ((SiriusDiagramGraphicalViewer) viewer).findEditPartsForElement(element,
							editPartClass);

					return elems;
				}
			}
		}

		return null;
	}
}
