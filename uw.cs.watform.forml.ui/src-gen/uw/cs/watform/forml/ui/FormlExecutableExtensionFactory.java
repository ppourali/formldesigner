/*
 * generated by Xtext
 */
package uw.cs.watform.forml.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import uw.cs.watform.forml.ui.internal.FormlActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class FormlExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FormlActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return FormlActivator.getInstance().getInjector(FormlActivator.UW_CS_WATFORM_FORML_FORML);
	}
	
}
