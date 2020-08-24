package uw.cs.watform.forml.services.general;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;

/**
 * All the services related to opening xtext file, then select and reveal an
 * object in it.
 * 
 * 
 * @author ppourali
 */
public class JS_OpenFormlDocument {

	public EObject openTextEditor(EObject any) {
		if (any != null && any.eResource() instanceof XtextResource && any.eResource().getURI() != null) {

			String fileURI = any.eResource().getURI().toPlatformString(true);
			IFile workspaceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileURI));
			if (workspaceFile != null) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				try {
					IEditorPart openEditor = IDE.openEditor(page, workspaceFile, "uw.cs.watform.forml.Forml", true);

					if (openEditor instanceof AbstractTextEditor) {

						ICompositeNode node = NodeModelUtils.findActualNodeFor(any);
						if (node != null) {
							if (any instanceof uw.cs.watform.forml.forml.System) {
								((AbstractTextEditor) openEditor).selectAndReveal(0, 0);
							} else {
								int offset = node.getOffset();
								int length = node.getTotalEndOffset() - offset;
								((AbstractTextEditor) openEditor).selectAndReveal(offset, length);
							}
						}
					}

				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}

		return any;
	}
}
