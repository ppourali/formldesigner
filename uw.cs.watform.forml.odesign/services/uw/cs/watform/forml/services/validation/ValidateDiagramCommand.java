package uw.cs.watform.forml.services.validation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.common.ui.util.WorkbenchPartDescriptor;
import org.eclipse.sirius.diagram.ui.part.ValidateAction;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * A command to launch a validation.
 * 
 * @author mchauvin
 */
public class ValidateDiagramCommand extends AbstractHandler {

    private ValidateAction action;

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart != null) {
            action = new ValidateAction(getDescriptor(workbenchPart));
            action.run();
        }

        return null;
    }

    private IWorkbenchPartDescriptor getDescriptor(final IWorkbenchPart workbenchPart) {
        return new WorkbenchPartDescriptor(workbenchPart.getSite().getId(), workbenchPart.getClass(), workbenchPart.getSite().getPage());
    }

}