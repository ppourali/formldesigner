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

import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * All the services related to Constraints in WorldModel and FeatureModules.
 * 
 * 
 * @author ppourali
 */
public class JS_ConstraintServices {

	/**
	 *  
	 * @param constraint
	 * Model object to be returned as text.
	 * 
	 * @return 
	 * Constraint text in the XText file.
	 */
	public String getConstraintsText(EObject constraint) {
		return ModelUtils.getTextForModelObjects(constraint);
	}
}
