/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package uw.cs.watform.forml.services.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.System;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.impl.FeatureModuleImpl;
import uw.cs.watform.forml.forml.impl.SystemImpl;
import uw.cs.watform.forml.services.GUI.FrmShellForFragmentDiagramSelect;
import uw.cs.watform.forml.services.internal.MessageDialogs;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

/**
 * A set of services to handle the Dashboard.
 *
 * @author Originally: Melanie Bats
 *         <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a> ,
 *         Modified by ppourali
 */
public class JS_DashboardServices {

	private static final String CLASS_DIAGRAM_Name = RepresentationsUtils.CLASS_DIAGRAM_Name;
	private static final String CLASS_DIAGRAM_Id = RepresentationsUtils.CLASS_DIAGRAM_Id;
	private static final String FRAGMENT_DIAGRAM_Id = RepresentationsUtils.FRAGMENT_DIAGRAM_Id;
	private static final String FeatureModel_DIAGRAM_Id = RepresentationsUtils.FeatureModel_DIAGRAM_Id;
	private static final String FeatureModule_DIAGRAM_Id = RepresentationsUtils.FeatureModule_DIAGRAM_Id;

	/**
	 * ID of the dashboard diagram defined in the odesign.
	 */
	private static final String DASHBOARD_DIAGRAM_DESCRIPTION_ID = RepresentationsUtils.DASHBOARD_DIAGRAM_DESCRIPTION_ID;

	/**
	 * ID the dashboard viewpoint defined in the odesign.
	 */
	public static final String DASHBOARD_VP = "Dashboard"; //$NON-NLS-1$

	/**
	 * Creates a new Class diagram.
	 * 
	 * @param element
	 */
	public void createClassDiagram(EObject element) {

		for (EObject eObj : element.eCrossReferences())
			if (eObj.getClass() == SystemImpl.class) {
				System s = (System) eObj;
				createRepresentation(s.getWorldmodel(), CLASS_DIAGRAM_Name);
				break;
			}
	}

	/**
	 * Create a new representation.
	 *
	 * @param eObject
	 *            Semantic element
	 * @param representationName
	 *            Representation name
	 * @param representationDescription
	 *            Representation description
	 */
	private void createRepresentation(final EObject eObject, final String representationName) {
		final Session session = SessionManager.INSTANCE.getSession(eObject);

		final RepresentationDescription representationDescription = RepresentationsUtils
				.getRepresentationDescription(eObject, session, CLASS_DIAGRAM_Id);

		final DRepresentation representation = DialectManager.INSTANCE.createRepresentation(representationName, eObject,
				representationDescription, session, new NullProgressMonitor());

		RepresentationsUtils.openRepresentation(representation);
	}

	/**
	 * Check if the dashboard representation already exists.
	 *
	 * @param any
	 *            Semantic element
	 * @return True if dashboard does not exist otherwise false.
	 */
	public boolean doesDashboardNotExist(EObject any) {
		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
				if (DASHBOARD_DIAGRAM_DESCRIPTION_ID.equals(diagram.getDescription().getName())) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Check if the dashboard representation already exists.
	 *
	 * @param any
	 *            Semantic element
	 * @return False if dashboard does not exist otherwise True.
	 */
	public boolean doesDashboardExists(EObject any) {
		final Session session = SessionManager.INSTANCE.getSession(any);
		final Collection<DRepresentation> representations = DialectManager.INSTANCE.getAllRepresentations(session);
		for (final DRepresentation representation : representations) {
			if (representation instanceof DSemanticDiagram) {
				final DSemanticDiagram diagram = (DSemanticDiagram) representation;
				if (DASHBOARD_DIAGRAM_DESCRIPTION_ID.equals(diagram.getDescription().getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Delete representation confirmation.
	 *
	 * @param
	 */
	public static boolean isDeleteConfirmed(final DRepresentation representation) {
		if (((DSemanticDecorator) representation).getTarget().getClass() == FeatureModuleImpl.class) {

			int dialogResult = MessageDialogs.ConfirmDeleteRepresentation();

			if (dialogResult == JOptionPane.YES_OPTION) {
				return true;
			} else
				return false;
		}
		return false;
	}

	/**
	 * Delete representation confirmation.
	 *
	 * @param
	 */
	public static Collection<FeatureModule> getAssociatedFragments(EObject t) {

		Collection<FeatureModule> allFragments = new HashSet();

		if (t instanceof State) {
			Collection<Setting> referrers = ModelUtils2.findReferencedObjects(t, ModelUtils2.getBehaviourModel(t));
			if (referrers.size() == 1) {
				Iterator<Setting> it = referrers.iterator();

				if (it.hasNext()) {
					Setting referrer = (Setting) it.next();
					EObject refObject = referrer.getEObject();

					if (refObject instanceof StateContext) {
						FeatureModule fragmentToReturn = ModelUtils.getTypedRootForObject(refObject,
								FeatureModule.class);
						allFragments.add(fragmentToReturn);
						return allFragments;

					}
				}
			} else if (referrers.size() > 1) {

				Iterator<Setting> it = referrers.iterator();

				while (it.hasNext()) {
					Setting referrer = (Setting) it.next();
					EObject refObject = referrer.getEObject();
					if (refObject instanceof StateContext) {
						FeatureModule fragmentToReturn = ModelUtils.getTypedRootForObject(refObject,
								FeatureModule.class);
						allFragments.add(fragmentToReturn);
					}

				}

				final Display display = Display.getDefault();
				FrmShellForFragmentDiagramSelect selectionWiz = new FrmShellForFragmentDiagramSelect(display,
						allFragments);
				selectionWiz.open();

				if (selectionWiz.ConfirmFlag)
					return selectionWiz.FragmentsToReturn;

			}
		}

		return null;
	}

	/**
	 * Finds all features that do not have feature module.
	 */
	public List<EObject> getAllFeaturesWithoutFeatureModule(EObject any) {
		List<Feature> features = ModelUtils.getWorldModelObjectsByType(any, Feature.class);

		List<EObject> return_features = new ArrayList<EObject>();

		for (EObject f : features) {
			FeatureModule fm = ModelUtils.getFeatureModuleForFeature((Feature) f);
			if (fm != null) {
				if (!RepresentationsUtils.objectAlreadyHasRepresentation(fm))
					return_features.add(f);
			} else
				return_features.add(f);
		}
		return return_features;

	}

	/**
	 * Delete an existing representation and the corresponding objects in the
	 * model.
	 *
	 * @param representation
	 *            The representation to delete
	 */
	public boolean deleteRepresentation(final DRepresentation representation) {

		if (((DSemanticDecorator) representation).getTarget() == null) {
			return true;
		}
		if (((DSemanticDecorator) representation).getTarget() != null) {
			if (((DSemanticDecorator) representation).getTarget() instanceof FeatureModule) {
				int dialogResult = MessageDialogs.ConfirmDeleteRepresentation();

				if (dialogResult == 0) {
					// get the behavioural model root
					BehaviourModel behaviorModelRoot = ModelUtils
							.getBehaviourModel(((DSemanticDecorator) representation).getTarget());

					// remove the feature module from behavioural model
					behaviorModelRoot.getFeaturemodules().remove(((DSemanticDecorator) representation).getTarget());

					return true;
				}

			} else if (((DSemanticDecorator) representation).getTarget() instanceof WorldModel) {
				int dialogResult = MessageDialogs.ConfirmEditWMDiagramInsteadOfDelete();
				if (dialogResult == 0) {
					RepresentationsUtils.openRepresentation(representation);
				}
			}
		}
		return false;
	}
	
	private String showDialogue() {
	    Display display = Display.getCurrent();
	    Shell shell = new Shell(display);
	    shell.setSize(0, 0);
	    shell.open();
	    FileDialog dialog = new FileDialog (shell, SWT.SAVE);
	    dialog
	        .setFilterNames(new String[] { "XML Files", "All Files (*.*)" });
	    dialog.setFilterExtensions(new String[] { "*.xml", "*.*" }); // Windows
	                                    // wild
	                                    // cards
	    dialog.setFilterPath("c:\\"); // Windows path
	    dialog.setFileName("xmloutput.xml");
	    dialog.open();
	    String outputURI = dialog.open();//.getFileName();
	    //display.dispose();
	    return outputURI;
	  }
	
	public void exportModelToXMI(EObject element) {
	    // change MyLanguage with your language name
				
		System system = ModelUtils.getSystem(element);
	    // .ext ist the extension of the model file
	    
		
		Injector injector = ModelUtils2.getInjector();
	    XtextResourceSet resourceSet = injector
	            .getInstance(XtextResourceSet.class);
	

	    URI inputURI=system.eResource().getURI();
	    
	    

	    Resource xtextResource = resourceSet.getResource(inputURI, true);

	    EcoreUtil.resolveAll(xtextResource);

	    String outputURI = "file:///" + "D:" + "/xml_output.xmi";//showDialogue();
	    if(outputURI.trim().equals(""))
	    	return ;
	    
		Resource xmiResource = resourceSet
	            .createResource(URI.createURI(outputURI));
	    xmiResource.getContents().add(xtextResource.getContents().get(0));
	    try {
	        xmiResource.save(null);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	

}
