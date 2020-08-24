/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package uw.cs.watform.forml.sirius.common.xtext.internal;

import java.util.Collection;
import java.util.Map;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.SavingPolicy;
import org.eclipse.xtext.resource.SaveOptions;

import com.google.common.collect.Maps;

/**
 * A saving policy dedicated to Xtext aware sessions. It actually work around
 * the bug #432795 by always adding options to ignore the concrete syntax
 * validation of Xtext while saving.
 * 
 * This policy only add the option and delegate the actual work to another one
 * passed as a constructor argument.
 * 
 * @author cbrun
 * 
 */
public class XtextSavingPolicy implements SavingPolicy {

    private final SavingPolicy delegate;

    /**
     * Create the saving policy.
     * 
     * @param delegate
     *            the delegate which is going to be called for the save
     *            operations, but with Xtext specific options.
     */
    public XtextSavingPolicy(SavingPolicy delegate) {
        this.delegate = delegate;
        
    }

    @Override
    public Collection<Resource> save(Iterable<Resource> resourcesToSave, Map<?, ?> options, IProgressMonitor monitor) {
        Map<Object, Object> newOptions = Maps.newHashMap();
        if (options != null) {
            newOptions.putAll(options);
        }
       // newOptions.putAll(SaveOptions.newBuilder().noValidation().getOptions().toOptionsMap());
        
     // added format option to make sure the XtextResource is formatted during the save.
        newOptions.putAll(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
        return delegate.save(resourcesToSave, newOptions, monitor);
    }

}