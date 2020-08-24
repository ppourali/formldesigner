package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.provider.FormlItemProviderAdapterFactory;
import uw.cs.watform.forml.services.GUI.SWTRendererUtils.ImageViewComposite;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

public class CustomCompositeFeatureModuleSnapShotHolder extends Composite {

	private ComposedAdapterFactory composedAdapterFactory;
	private FeatureModule relatedFM;

	public CustomCompositeFeatureModuleSnapShotHolder(Composite parent, int style, FeatureModule related_FM) {
		super(parent, style);
		this.relatedFM=related_FM;
		ConstructDesign();
	}

	private void ConstructDesign() {
		setLocation(0, 410);
		setSize(760, 380);
		setBackground(SWTResourceManager.getColor(50, 255, 255));
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);

		// Set Layout for component
		setLayout(fillLayout);

		// snapshot goes here
		Roleable curr_Feature = FPC_SingletonData.getCurrentRoleable();
		
		Collection<DRepresentation> fms = RepresentationsUtils
				.getRepresentationsForFeatureModulesSortedbyName(relatedFM);

		Image img = RepresentationsUtils.exportRepresentationForAnyObjectAsSWTImage(relatedFM);

		if (img != null) {
			// setBackgroundImage(img);
			ImageViewComposite imageComosite = new ImageViewComposite(this, SWT.BORDER, img,relatedFM);
			//imageComosite.imageCanvas.fitCanvas();
		}
		this.redraw();
		this.update();
	}

}
