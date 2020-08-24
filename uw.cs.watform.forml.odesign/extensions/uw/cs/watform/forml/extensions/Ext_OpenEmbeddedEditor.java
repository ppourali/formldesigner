package uw.cs.watform.forml.extensions;

import com.google.inject.Injector;

import uw.cs.watform.forml.ui.internal.FormlActivator;
import uw.cs.watform.forml.viewpoint.xtext.support.action.OpenXtextEmbeddedEditor;

/**
 * This is a complete copy of the example taken from the Sirius-Xtext
 * integration example on Git.
 * 
 * @see https://github.com/ObeoNetwork/Xtext-Sirius-integration 
 * 
 * @author ppourali, originally: cedric.brun@obeo.fr
 * 
 */
public class Ext_OpenEmbeddedEditor extends OpenXtextEmbeddedEditor {

	@Override
	protected Injector getInjector() {

		return FormlActivator.getInstance().getInjector("uw.cs.watform.forml.Forml");
	}

}
