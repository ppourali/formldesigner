package uw.cs.watform.forml.services.GUI.FragmentStateFocusContext;

import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.services.GUI.SWTRendererUtils.ImageViewComposite;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

public class CustomCompositeFeatureModuleSnapShotHolderForFragment extends Composite {

	private ComposedAdapterFactory composedAdapterFactory;
	private FeatureModule relatedFM;
	public ImageViewComposite imageComosite;

	public CustomCompositeFeatureModuleSnapShotHolderForFragment(Composite parent, int style,
			FeatureModule related_FM) {
		super(parent, style);
		this.relatedFM = related_FM;
		ConstructDesign();
	}

	private void ConstructDesign() {
		setLocation(0, 0);
		setSize(900, 500);
		setBackground(SWTResourceManager.getColor(50, 255, 255));
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);

		// Set Layout for component
		setLayout(fillLayout);

		Collection<DRepresentation> fms = RepresentationsUtils
				.getRepresentationsForFeatureModulesSortedbyName(relatedFM);

		Image img = RepresentationsUtils.exportRepresentationForAnyObjectAsSWTImage(relatedFM);

		if (img != null) {
			// setBackgroundImage(img);
			imageComosite = new ImageViewComposite(this, SWT.BORDER, img, relatedFM);
			// imageComosite.imageCanvas.fitCanvas();
		}
		this.redraw();
		this.update();
	}

}
