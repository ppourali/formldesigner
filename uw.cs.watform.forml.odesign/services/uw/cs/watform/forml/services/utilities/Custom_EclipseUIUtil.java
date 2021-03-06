package uw.cs.watform.forml.services.utilities;

/**
 * Static useful eclipse ui methods.
 * 
 * @author mchauvin
 */
public final class Custom_EclipseUIUtil {

//    /**
//     * Avoid instantiation.
//     */
//    private Custom_EclipseUIUtil() {
//
//    }
//
//    private static IWorkbenchWindow getActiveWindow() {
//        final IWorkbench workbench = PlatformUI.getWorkbench();
//        if (workbench != null) {
//            final RunnableWithResult<IWorkbenchWindow> getActiveWorkbenchWindowRunnable = new RunnableWithResult.Impl<IWorkbenchWindow>() {
//                @Override
//                public void run() {
//                    setResult(workbench.getActiveWorkbenchWindow());
//                }
//            };
//            if (null == Display.getCurrent()) {
//                // Getting the active workbench window through UI thread
//                workbench.getDisplay().syncExec(getActiveWorkbenchWindowRunnable);
//            } else {
//                // Already in the UI thread.
//                getActiveWorkbenchWindowRunnable.run();
//            }
//            return getActiveWorkbenchWindowRunnable.getResult();
//        }
//        return null;
//    }
//
//    /**
//     * Get the active page.
//     * 
//     * @return the active page or <code>null</code>
//     */
//    public static IWorkbenchPage getActivePage() {
//        final IWorkbenchWindow window = EclipseUIUtil.getActiveWindow();
//        if (window != null) {
//            return window.getActivePage();
//        }
//        return null;
//    }
//
//    /**
//     * Get the active editor.
//     * 
//     * @return the active editor or <code>null</code>
//     */
//    public static IEditorPart getActiveEditor() {
//        final IWorkbenchPage page = EclipseUIUtil.getActivePage();
//        if (page != null) {
//            return page.getActiveEditor();
//        }
//        return null;
//    }
//
//    /**
//     * Shows the view identified by the given view id in this page and gives it
//     * focus. If there is a view identified by the given view id (and with no
//     * secondary id) already open in this page, it is given focus.
//     * 
//     * @param viewId
//     *            the id of the view extension to use
//     * @return the shown view
//     */
//    public static IViewPart showView(final String viewId) {
//        final IWorkbenchPage page = EclipseUIUtil.getActivePage();
//        if (page != null) {
//            try {
//                return page.showView(viewId);
//            } catch (final PartInitException e) {
//               // SiriusTransPlugin.getPlugin().error(MessageFormat.format(Messages.EclipseUIUtil_showView_error, viewId), e);
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Hides the view identified by the given view id in this page.
//     * 
//     * @param viewId
//     *            the id of the view extension to use
//     */
//    public static void hideView(final String viewId) {
//        final IWorkbenchPage page = EclipseUIUtil.getActivePage();
//        if (page != null) {
//            IViewPart view = page.findView(viewId);
//            if (view != null) {
//                page.hideView(view);
//            }
//        }
//    }
//
//    /**
//     * Returns the view in the workbench's active window's active page with the
//     * specified id.
//     * 
//     * @param viewId
//     *            the id of the view extension to use
//     * @return the view, or <code>null</code> if none is found
//     */
//    public static IViewPart getView(final String viewId) {
//
//        final IWorkbenchPage page = EclipseUIUtil.getActivePage();
//        if (page != null) {
//            return page.findView(viewId);
//        }
//        return null;
//    }
//
//    /**
//     * Get the current Eclipse perspective descriptor.
//     * 
//     * @return the current perspective descriptor, null if it can not be found.
//     */
//    public static IPerspectiveDescriptor getCurrentPerspectiveDescriptor() {
//
//        IPerspectiveDescriptor currentPerspectiveDescriptor = null;
//
//        IWorkbenchWindow window = EclipseUIUtil.getActiveWindow();
//        if (window != null) {
//            currentPerspectiveDescriptor = EclipseUIUtil.getPerspectiveDescriptor(window);
//        }
//
//        if (currentPerspectiveDescriptor == null) {
//            final IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
//            for (IWorkbenchWindow window2 : windows) {
//                window = window2;
//                if (window != null) {
//                    currentPerspectiveDescriptor = EclipseUIUtil.getPerspectiveDescriptor(window);
//                    if (currentPerspectiveDescriptor != null) {
//                        break;
//                    }
//                }
//            }
//        }
//        return currentPerspectiveDescriptor;
//    }
//
//    private static IPerspectiveDescriptor getPerspectiveDescriptor(final IWorkbenchWindow window) {
//        IPerspectiveDescriptor currentPerspectiveDescriptor = null;
//        final IWorkbenchPage page = window.getActivePage();
//        if (page != null) {
//            currentPerspectiveDescriptor = page.getPerspective();
//        }
//        return currentPerspectiveDescriptor;
//    }
//
//    
//
//    /**
//     * Add a selection listener to the site for the workbench part. Looks for a
//     * {@link ISelectionService} by calling
//     * {@link org.eclipse.ui.services.IServiceLocator#getService} on the site.
//     * 
//     * @param part
//     *            the workbench part
//     * @param listener
//     *            the listener to add
//     */
//    public static void addSelectionListener(IWorkbenchPart part, ISelectionListener listener) {
//        IWorkbenchPartSite site = part.getSite();
//        if (site != null) {
//            ISelectionService selectionService = site.getService(ISelectionService.class);
//            if (selectionService != null) {
//                selectionService.addSelectionListener(listener);
//            }
//        }
//    }
//
//    /**
//     * Remove a selection listener from the site for the workbench part. Looks
//     * for a {@link ISelectionService} by calling
//     * {@link org.eclipse.ui.services.IServiceLocator#getService} on the site.
//     * 
//     * @param part
//     *            the workbench part
//     * 
//     * @param listener
//     *            the listener to remove
//     */
//    public static void removeSelectionListener(IWorkbenchPart part, ISelectionListener listener) {
//        IWorkbenchPartSite site = part.getSite();
//        if (site != null) {
//            ISelectionService selectionService = site.getService(ISelectionService.class);
//            if (selectionService != null) {
//                selectionService.removeSelectionListener(listener);
//            }
//        }
//    }
//
//    /**
//     * Post a runnable to be invoked by the user-interface thread at the next
//     * reasonable opportunity.
//     * 
//     * If a workbench is started its Display instance will be used, otherwhise
//     * Display.getDefault() will be used.
//     * 
//     * @param r
//     *            the runnable to execute.
//     */
//    public static void displayAsyncExec(Runnable r) {
//        getCurrentDisplay().asyncExec(r);
//    }
//
//    private static Display getCurrentDisplay() {
//        Display d;
//        if (PlatformUI.isWorkbenchRunning()) {
//            d = PlatformUI.getWorkbench().getDisplay();
//        } else {
//            d = Display.getDefault();
//        }
//        return d;
//    }
//
//    /**
//     * Post a runnable to be invoked by the user-interface thread at the next
//     * reasonable opportunity. The thread which calls this method is suspended
//     * until the runnable completes.
//     * 
//     * If a workbench is started its Display instance will be used, otherwhise
//     * Display.getDefault() will be used.
//     * 
//     * @param r
//     *            the runnable to execute.
//     */
//    public static void displaySyncExec(Runnable r) {
//        getCurrentDisplay().syncExec(r);
//    }
//
//    /**
//     * Process any event or runnables waiting in the user-interface queue.
//     */
//    public static void synchronizeWithUIThread() {
//        Display d = getCurrentDisplay();
//        while (d.readAndDispatch()) {
//            /*
//             * We wait for the UI thread to process all remaining events.
//             */
//        }
//    }

}