/*
 * generated by Xtext
 */
package uw.cs.watform.forml;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class FormlStandaloneSetup extends FormlStandaloneSetupGenerated{

	public static void doSetup() {
		new FormlStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

