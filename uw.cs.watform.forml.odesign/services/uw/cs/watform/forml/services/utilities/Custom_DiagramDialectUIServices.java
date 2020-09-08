package uw.cs.watform.forml.services.utilities;

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
