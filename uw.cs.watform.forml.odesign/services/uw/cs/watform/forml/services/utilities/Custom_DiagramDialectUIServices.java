package uw.cs.watform.forml.services.utilities;

/*******************************************************************************
 * Copyright (c) 2007, 2017 THALES GLOBAL SERVICES and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
//import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.query.URIQuery;
import org.eclipse.sirius.business.api.session.CustomDataConstants;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.DslCommonPlugin;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterSiriusVariables;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
//import org.eclipse.sirius.common.ui.tools.api.util.EclipseUIUtil;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.DiagramPlugin;
import org.eclipse.sirius.diagram.business.api.diagramtype.DiagramTypeDescriptorRegistry;
import org.eclipse.sirius.diagram.business.api.diagramtype.IDiagramTypeDescriptor;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.description.DescriptionFactory;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramExtensionDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.diagram.description.concern.provider.ConcernItemProviderAdapterFactory;
import org.eclipse.sirius.diagram.description.filter.provider.FilterItemProviderAdapterFactory;
import org.eclipse.sirius.diagram.description.provider.DescriptionItemProviderAdapterFactory;
import org.eclipse.sirius.diagram.description.style.provider.StyleItemProviderAdapterFactory;
import org.eclipse.sirius.diagram.description.tool.EdgeCreationDescription;
import org.eclipse.sirius.diagram.description.tool.ToolFactory;
import org.eclipse.sirius.diagram.description.tool.provider.ToolItemProviderAdapterFactory;
import org.eclipse.sirius.diagram.provider.DiagramItemProviderAdapterFactory;
import org.eclipse.sirius.diagram.ui.business.api.DiagramExportResult;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.eclipse.sirius.diagram.ui.business.internal.command.CreateAndStoreGMFDiagramCommand;
import org.eclipse.sirius.diagram.ui.business.internal.dialect.DiagramDialectArrangeOperation;
import org.eclipse.sirius.diagram.ui.business.internal.dialect.DiagramDialectUIServices;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.eclipse.sirius.diagram.ui.internal.refresh.DiagramRefresherHelper;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.sirius.diagram.ui.provider.Messages;
import org.eclipse.sirius.diagram.ui.tools.api.editor.DDiagramEditor;
import org.eclipse.sirius.diagram.ui.tools.api.part.DiagramEditPartService;
import org.eclipse.sirius.diagram.ui.tools.api.preferences.SiriusDiagramUiPreferencesKeys;
import org.eclipse.sirius.diagram.ui.tools.internal.decoration.SiriusDecoratorProvider;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.tools.api.profiler.SiriusTasksKey;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIServices;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportFormat.ExportDocumentFormat;
import org.eclipse.sirius.ui.business.api.dialect.ExportResult;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.RepresentationExtensionDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Custom_DiagramDialectUIServices {//extends DiagramDialectUIServices {

//	@Override
//	public IEditorPart openEditor(Session session, DRepresentation dRepresentation, IProgressMonitor monitor) {
//		DialectEditor result = null;
//		try {
//			monitor.beginTask(Messages.DiagramDialectUIServices_diagramOpeningMonitorTaskName, 15);
//			DslCommonPlugin.PROFILER.startWork(SiriusTasksKey.OPEN_DIAGRAM_KEY);
//
//			if (dRepresentation instanceof DSemanticDiagram) {
//				final DSemanticDiagram diag = (DSemanticDiagram) dRepresentation;
//				final Collection<EObject> gmfDiags = session.getServices()
//						.getCustomData(CustomDataConstants.GMF_DIAGRAMS, diag);
//
//				if (gmfDiags.isEmpty()) {
//					/*
//					 * we have our diagrams but not the gmf ones => old aird version or corrupted
//					 * file
//					 */
//					TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
//					domain.getCommandStack().execute(new CreateAndStoreGMFDiagramCommand(session, diag));
//
//					gmfDiags.addAll(session.getServices().getCustomData(CustomDataConstants.GMF_DIAGRAMS, diag));
//					monitor.worked(1);
//				}
//
//				// If the current DDiagram is shared on a CDO repository and
//				// some
//				// needed Viewpoints are not activated (for example a
//				// contributed
//				// activated layer)
//				Set<Viewpoint> viewpointsActivated = null;
//				if (URIQuery.CDO_URI_SCHEME.equals(diag.eResource().getURI().scheme())) {
//					viewpointsActivated = activateNeededViewpoints(session, diag, monitor);
//				}
//				for (final EObject object : gmfDiags) {
//					final Diagram gmfDiag = (Diagram) object;
//					if (gmfDiag != null) {
//						result = openEditor(session, gmfDiag, dRepresentation, monitor);
//						new DiagramDialectArrangeOperation().arrange(result, diag);
//						monitor.worked(3);
//					}
//				}
//				if (viewpointsActivated != null && !viewpointsActivated.isEmpty()) {
//					informOfActivateNeededViewpoints(viewpointsActivated);
//				}
//			}
//			DslCommonPlugin.PROFILER.stopWork(SiriusTasksKey.OPEN_DIAGRAM_KEY);
//		} finally {
//			monitor.done();
//		}
//		return result;
//	}
//	
//	private DialectEditor getEditor(Session session, Diagram gmfDiag, DRepresentation dRepresentation,
//			IProgressMonitor monitor) {
//		DialectEditor dialectEditor = null;
//		URI uri = EcoreUtil.getURI(gmfDiag);
//		String editorName = DialectUIManager.INSTANCE.getEditorName(dRepresentation);
//		DRepresentationQuery query = new DRepresentationQuery(dRepresentation);
//		URI repDescURI = Optional.ofNullable(query.getRepresentationDescriptor())
//				.map(repDesc -> EcoreUtil.getURI(repDesc)).orElse(null);
//		monitor.worked(1);
//		final IEditorInput editorInput = new SessionEditorInput(uri, repDescURI, editorName, session);
//		monitor.subTask(MessageFormat.format(Messages.DiagramDialectUIServices_diagramEditorOpeningMonitorTaskName,
//				dRepresentation.getName()));
//		RunnableWithResult<DialectEditor> runnable = new RunnableWithResult.Impl<DialectEditor>() {
//
//			@Override
//			public void run() {
//				final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//				try {
//					IEditorPart editorPart = page.openEditor(editorInput, DDiagramEditor.EDITOR_ID);
//					if (editorPart instanceof DialectEditor) {
//						setResult((DialectEditor) editorPart);
//					}
//				} catch (final PartInitException e) {
//					DiagramPlugin.getDefault().logError(Messages.DiagramDialectUIServices_diagramEditorOpeningError, e);
//				}
//			}
//
//		};
//		displaySyncExec(runnable);
//		monitor.worked(10);
//		if (runnable.getResult() != null) {
//			dialectEditor = runnable.getResult();
//		}
//		return dialectEditor;
//	}
//	
//	
//
//	private DialectEditor openEditor(Session session, Diagram gmfDiag, DRepresentation dRepresentation,
//			IProgressMonitor monitor) {
//		DialectEditor dialectEditor = null;
//		URI uri = EcoreUtil.getURI(gmfDiag);
//		String editorName = DialectUIManager.INSTANCE.getEditorName(dRepresentation);
//		DRepresentationQuery query = new DRepresentationQuery(dRepresentation);
//		URI repDescURI = Optional.ofNullable(query.getRepresentationDescriptor())
//				.map(repDesc -> EcoreUtil.getURI(repDesc)).orElse(null);
//		monitor.worked(1);
//		final IEditorInput editorInput = new SessionEditorInput(uri, repDescURI, editorName, session);
//		monitor.subTask(MessageFormat.format(Messages.DiagramDialectUIServices_diagramEditorOpeningMonitorTaskName,
//				dRepresentation.getName()));
//		RunnableWithResult<DialectEditor> runnable = new RunnableWithResult.Impl<DialectEditor>() {
//
//			@Override
//			public void run() {
//				final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//				try {
//					IEditorPart editorPart = page.openEditor(editorInput, DDiagramEditor.EDITOR_ID);
//					if (editorPart instanceof DialectEditor) {
//						setResult((DialectEditor) editorPart);
//					}
//				} catch (final PartInitException e) {
//					DiagramPlugin.getDefault().logError(Messages.DiagramDialectUIServices_diagramEditorOpeningError, e);
//				}
//			}
//
//		};
//		displaySyncExec(runnable);
//		monitor.worked(10);
//		if (runnable.getResult() != null) {
//			dialectEditor = runnable.getResult();
//		}
//		return dialectEditor;
//	}
//
//	private static void displaySyncExec(Runnable r) {
//		getCurrentDisplay().syncExec(r);
//	}
//
//	private static void displayAsyncExec(Runnable r) {
//		getCurrentDisplay().asyncExec(r);
//	}
//
//	private static Display getCurrentDisplay() {
//		Display d;
//		if (PlatformUI.isWorkbenchRunning()) {
//			d = PlatformUI.getWorkbench().getDisplay();
//		} else {
//			d = Display.getDefault();
//		}
//		return d;
//	}
//
//	private Set<Viewpoint> activateNeededViewpoints(Session session, DDiagram dDiagram, IProgressMonitor monitor) {
//		Set<Viewpoint> neededViewpoints = DialectManager.INSTANCE.getRequiredViewpoints(dDiagram);
//		Set<Viewpoint> selectedViewpoints = new LinkedHashSet<Viewpoint>();
//		for (Viewpoint viewpoint : session.getSelectedViewpoints(false)) {
//			selectedViewpoints.add(SiriusResourceHelper.getCorrespondingViewpoint(session, viewpoint));
//		}
//		neededViewpoints.removeAll(selectedViewpoints);
//		if (!neededViewpoints.isEmpty()) {
//			Command changeViewpointsSelectionCmd = new ChangeViewpointSelectionCommand(session,
//					new ViewpointSelectionCallback(), neededViewpoints, Collections.<Viewpoint>emptySet(),
//					new SubProgressMonitor(monitor, neededViewpoints.size()));
//			session.getTransactionalEditingDomain().getCommandStack().execute(changeViewpointsSelectionCmd);
//			monitor.worked(1);
//		}
//		return neededViewpoints;
//	}
//
//	private void informOfActivateNeededViewpoints(Set<Viewpoint> viewpointsActivated) {
//		Iterator<Viewpoint> iterator = viewpointsActivated.iterator();
//		Viewpoint neededSirius = iterator.next();
//		String viewpointsName = neededSirius.getName();
//		while (iterator.hasNext()) {
//			neededSirius = iterator.next();
//			viewpointsName += ", " + neededSirius.getName(); //$NON-NLS-1$
//		}
//		final String description = viewpointsName;
//		displayAsyncExec(new Runnable() {
//
//			@Override
//			public void run() {
//				MessageDialog.openInformation(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
//						Messages.DiagramDialectUIServices_requiredViewpointsDialogTitle, MessageFormat.format(
//								Messages.DiagramDialectUIServices_requiredViewpointsDialogMessage, description));
//			}
//
//		});
//	}

}
