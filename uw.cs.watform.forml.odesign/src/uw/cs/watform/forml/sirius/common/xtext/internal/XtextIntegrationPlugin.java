/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package uw.cs.watform.forml.sirius.common.xtext.internal;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * Plug-in class for <em>org.eclipse.sirius.common.xtext</em>.
 */
public class XtextIntegrationPlugin extends EMFPlugin {

    /**
     * Keep track of the singleton.
     */
    public static final XtextIntegrationPlugin INSTANCE = new XtextIntegrationPlugin();

    /**
     * Keep track of the singleton.
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     */
    public XtextIntegrationPlugin() {
        super(new ResourceLocator[0]);
    }

    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * 
     * @return the singleton instance.
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     */
    public static class Implementation extends EclipsePlugin {
        /**
         * Creates an instance.
         */
        public Implementation() {
            plugin = this;
        }
    }

}