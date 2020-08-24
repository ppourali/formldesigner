/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package uw.cs.watform.forml.base.xtext.utils.jface.fieldassist;

/**
 * This interface is used to listen to additional notifications from a
 * {@link CompletionProposalAdapter}.
 * 
 * @author patrick.koenemann@itemis.de
 *
 */
public interface ICompletionProposalListener {
	/**
	 * A completion proposal popup has been opened.
	 * 
	 * @param adapter
	 *            the CompletionProposalAdapter which is adapting content proposal
	 *            behavior to a control
	 */
	public void proposalPopupOpened(CompletionProposalAdapter adapter);

	/**
	 * A completion proposal popup has been closed.
	 * 
	 * @param adapter
	 *            the CompletionProposalAdapter which is adapting content proposal
	 *            behavior to a control
	 */
	public void proposalPopupClosed(CompletionProposalAdapter adapter);
}