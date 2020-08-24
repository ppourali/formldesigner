package uw.cs.watform.forml.services.GUI.SWTRendererUtils;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FPC_SingletonData;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.RepresentationsUtils;

import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.RowLayout;

public class ImageViewComposite extends Composite {
	public SWTImageCanvas imageCanvas;
	private Image sourceImage;
	private FeatureModule relatedFeatureModule;

	public ImageViewComposite(Composite parent, int border, Image srcimage, FeatureModule relatedFM) {
		super(parent, SWT.BORDER);
		this.sourceImage = srcimage;
		// setLocation(0, 0);
		// setSize(292,200);
		createPartControl(this);
		this.relatedFeatureModule = relatedFM;

		ConstructDesign();
		// TODO Auto-generated constructor stub
	}

	private void ConstructDesign() {

	}

	/**
	 * Create the GUI.
	 * 
	 * @param frame The Composite handle of parent
	 */
	public void createPartControl(Composite frame) {
		// String path = "D:/image.jpg";

		Image image = this.sourceImage;
		setLayout(new GridLayout(1, false));
		// setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		// setLayout(new FillLayout(SWT.HORIZONTAL));

		// setLayout(new GridLayout(1, false));

		Composite compositeToolbars = new Composite(this, SWT.NONE);
		compositeToolbars.setLayout(new RowLayout(SWT.HORIZONTAL));
		GridData gd_compositeToolbars = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_compositeToolbars.heightHint = 24;
		compositeToolbars.setLayoutData(gd_compositeToolbars);

		Button btnZoomout = new Button(compositeToolbars, SWT.NONE);
		btnZoomout.setToolTipText("Zoom Out");
		btnZoomout.setImage(ResourceManager.getPluginImage("uw.cs.watform.forml.odesign",
				"GUI/uw/cs/watform/forml/services/GUI/res/imageViewer/ZoomOut16.gif"));
		btnZoomout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				imageCanvas.zoomOut();
			}
		});

		Button btnZoomIn = new Button(compositeToolbars, SWT.NONE);
		btnZoomIn.setImage(ResourceManager.getPluginImage("uw.cs.watform.forml.odesign",
				"GUI/uw/cs/watform/forml/services/GUI/res/imageViewer/ZoomIn16.gif"));
		btnZoomIn.setToolTipText("Zoom In");
		btnZoomIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				imageCanvas.zoomIn();

			}
		});

		Button btnFit = new Button(compositeToolbars, SWT.NONE);
		btnFit.setToolTipText("Fit Size");
		btnFit.setImage(ResourceManager.getPluginImage("uw.cs.watform.forml.odesign",
				"GUI/uw/cs/watform/forml/services/GUI/res/imageViewer/Fit16.gif"));
		btnFit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				imageCanvas.fitCanvas();
			}
		});

		Button btnOriginalsize = new Button(compositeToolbars, SWT.NONE);
		btnOriginalsize.setImage(ResourceManager.getPluginImage("uw.cs.watform.forml.odesign",
				"GUI/uw/cs/watform/forml/services/GUI/res/imageViewer/Original16.gif"));
		btnOriginalsize.setToolTipText("Original Size");
		btnOriginalsize.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				imageCanvas.showOriginal();
			}

		});

		Button btnOpenOriginalFeatureModule = new Button(compositeToolbars, SWT.NONE);

		btnOpenOriginalFeatureModule.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openFeatureModule();
			}

		});
		btnOpenOriginalFeatureModule.setToolTipText("Open Original Feature Module");
		btnOpenOriginalFeatureModule.setImage(ResourceManager.getPluginImage("uw.cs.watform.forml.odesign",
				"GUI/uw/cs/watform/forml/services/GUI/res/imageViewer/Open16.gif"));

		imageCanvas = new SWTImageCanvas(frame, image);
		imageCanvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}

	private void openFeatureModule() {
		try {
			Shell shell = FPC_SingletonData.getShell().getShell();

			RepresentationsUtils.openRepresentationInAParentShell(shell, this.relatedFeatureModule, 0, 0);
		} catch (Exception e) {
			RepresentationsUtils.openRepresentationForAnyObject(relatedFeatureModule);
		}
	}

	/**
	 * Called when we must grab focus.
	 * 
	 * @return
	 * 
	 * @see org.eclipse.ui.part.ViewPart#setFocus
	 */
	public boolean setFocus() {
		return imageCanvas.setFocus();
	}

	/**
	 * Called when the View is to be disposed
	 */
	public void dispose() {
		imageCanvas.dispose();
		super.dispose();
	}

}