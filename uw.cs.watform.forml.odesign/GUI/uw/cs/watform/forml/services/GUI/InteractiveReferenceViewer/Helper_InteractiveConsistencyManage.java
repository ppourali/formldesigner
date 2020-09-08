package uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import org.eclipse.sirius.business.api.session.CustomDataConstants;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.DslCommonPlugin;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.ui.business.internal.command.CreateAndStoreGMFDiagramCommand;
import org.eclipse.sirius.diagram.ui.provider.Messages;
import org.eclipse.sirius.tools.api.profiler.SiriusTasksKey;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

public class Helper_InteractiveConsistencyManage {

	static String EDITOR_ID = "org.eclipse.sirius.diagram.ui.part.SiriusDiagramEditorID"; //$NON-NLS-1$
	public static Transition transition;

	private static List<IEditorReference> Editors_Before = new ArrayList<IEditorReference>();
	private static IEditorPart Active_Editor_Before;
	private static HashMap<MPartSashContainerElement, MElementContainer<MUIElement>> map_Editor_Parent = new HashMap<MPartSashContainerElement, MElementContainer<MUIElement>>();

	public static List<IEditorReference> getEditors_Before() {
		return Editors_Before;
	}

	public static void setEditors_Before() {
		Editors_Before.clear();
		for (IEditorReference e : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			Editors_Before.add(e);
		}
	}

	public static IEditorPart getActive_Editor_Before() {
		return Active_Editor_Before;
	}

	public static void setActive_Editor_Before() {
		Active_Editor_Before = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	public static void ReactivateEditorAndResetEditors() {
		try {

			if (Active_Editor_Before != null) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.openEditor(Active_Editor_Before.getEditorInput(), EDITOR_ID);
			}

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void CloseJustOpenedEditors() {

		for (IEditorReference e : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			if (!Editors_Before.contains(e)) {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(e.getEditor(false),
						true);
			}
		}

		for (MPartSashContainerElement p : map_Editor_Parent.keySet()) {
			if (getMap_Editor_Parent(p) != null) {
				p.setParent(getMap_Editor_Parent(p));
			}
		}
	}

	public static void OpenRelatedEditors(EObject any, Session session, DRepresentation current_representation,
			Shell parent, int xoffset, int yoffset) throws PartInitException {

		NullProgressMonitor monitor = new NullProgressMonitor();

		IEditorInput editorInputForRepresentation = getEditorInput(session, current_representation, monitor);

		Helper_InteractiveConsistencyManage.setEditors_Before();
		// Helper_InteractiveConsistencyManage.setActive_Editor_Before();

		boolean isAlreadyOpen = false;

		IEditorPart editor = null;
		IEditorReference editorReference = null;

		for (IEditorReference e : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences()) {
			if (e.getEditorInput().equals(editorInputForRepresentation)) {
				isAlreadyOpen = true;
				editor = e.getEditor(true);
				editorReference = e;

				break;
			}
		}
		if (!isAlreadyOpen) {
			editor = DialectUIManager.INSTANCE.openEditor(session, current_representation, monitor);
		}

		if (editor == null)
			return;

		EModelService s = (EModelService) editor.getSite().getService(EModelService.class);
		MPartSashContainerElement p = (MPart) editor.getSite().getService(MPart.class);
		setMap_Editor_Parent(p, p.getParent());
		// MElementContainer<MUIElement> lll = p.getParent();

		if (p.getCurSharedRef() != null)
			p = p.getCurSharedRef();

		int x = parent.getLocation().x+xoffset;
		int y = parent.getLocation().y + yoffset;

		s.detach(p, x, y, parent.getSize().x, parent.getSize().y);

		RepresentationsUtils.SelectAndRevealElementsInDiagram(any, transition,editor);
		// s.bringToTop(p);
	}

	private static IEditorInput getEditorInput(Session session, DRepresentation dRepresentation,
			IProgressMonitor monitor) {
		DialectEditor result = null;
		try {
			monitor.beginTask(Messages.DiagramDialectUIServices_diagramOpeningMonitorTaskName, 15);
			DslCommonPlugin.PROFILER.startWork(SiriusTasksKey.OPEN_DIAGRAM_KEY);

			if (dRepresentation instanceof DSemanticDiagram) {
				final DSemanticDiagram diag = (DSemanticDiagram) dRepresentation;
				final Collection<EObject> gmfDiags = session.getServices()
						.getCustomData(CustomDataConstants.GMF_DIAGRAMS, diag);

				if (gmfDiags.isEmpty()) {
					/*
					 * we have our diagrams but not the gmf ones => old aird version or corrupted
					 * file
					 */
					TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
					domain.getCommandStack().execute(new CreateAndStoreGMFDiagramCommand(session, diag));

					gmfDiags.addAll(session.getServices().getCustomData(CustomDataConstants.GMF_DIAGRAMS, diag));
					monitor.worked(1);
				}

				for (final EObject object : gmfDiags) {
					final Diagram gmfDiag = (Diagram) object;
					if (gmfDiag != null) {
						DialectEditor dialectEditor = null;
						URI uri = EcoreUtil.getURI(gmfDiag);
						String editorName = DialectUIManager.INSTANCE.getEditorName(dRepresentation);
						DRepresentationQuery query = new DRepresentationQuery(dRepresentation);
						URI repDescURI = Optional.ofNullable(query.getRepresentationDescriptor())
								.map(repDesc -> EcoreUtil.getURI(repDesc)).orElse(null);
						monitor.worked(1);
						final IEditorInput editorInput = new SessionEditorInput(uri, repDescURI, editorName, session);
						return editorInput;
					}
				}

			}

		} finally {
			monitor.done();
		}
		return null;
	}

	public static MElementContainer<MUIElement> getMap_Editor_Parent(MPartSashContainerElement p) {
		return map_Editor_Parent.get(p);
	}

	public static void setMap_Editor_Parent(MPartSashContainerElement p, MElementContainer<MUIElement> parent) {
		map_Editor_Parent.put(p, parent);
	}

}
