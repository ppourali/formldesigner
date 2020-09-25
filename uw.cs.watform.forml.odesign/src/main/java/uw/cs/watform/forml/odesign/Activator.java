package uw.cs.watform.forml.odesign;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.ui.tools.internal.views.common.navigator.SiriusCommonLabelProvider;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import uw.cs.watform.forml.services.handlers.DiagramHandler;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "uw.cs.watform.forml.odesign";

	// The shared instance
	private static Activator plugin;

	private static Set<Viewpoint> viewpoints;

	/**
	 * Label provider.
	 */
	private ICommonLabelProvider labelProvider = null;

	/**
	 * The constructor
	 */
	public Activator() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		viewpoints = new HashSet<Viewpoint>();
		viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/forml.odesign"));

		setDiagramHandler();
	}

	/**
	 * Sets KeyHandler and ResourceSetListener to the diagrams.
	 */
	private void setDiagramHandler() {
		DiagramHandler handler = new DiagramHandler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (viewpoints != null) {
			for (final Viewpoint viewpoint : viewpoints) {
				ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
			}
			viewpoints.clear();
			viewpoints = null;
		}
		super.stop(context);
		
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the label provider to use for displaying locked elements.
	 *
	 * @return the label provider to use for displaying locked elements.
	 */
	public ICommonLabelProvider getLabelProvider() {
		if (labelProvider == null) {
			labelProvider = new SiriusCommonLabelProvider();
		}
		return labelProvider;
	}

	// private ICommonLabelProvider labelProvider = null;
	//
	// /**
	// * Returns the label provider to use for displaying locked elements.
	// *
	// * @return the label provider to use for displaying locked elements.
	// */
	// public ICommonLabelProvider getLabelProvider() {
	// if (labelProvider == null) {
	// labelProvider = new SiriusCommonLabelProvider();
	// }
	// return labelProvider;
	// }
}
