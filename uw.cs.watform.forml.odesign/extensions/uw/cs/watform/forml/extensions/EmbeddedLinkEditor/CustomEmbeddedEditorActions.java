package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.jdt.ui.actions.IJavaEditorActionDefinitionIds;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.commands.ActionHandler;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.FindReplaceAction;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ResourceAction;
import org.eclipse.xtext.ui.editor.embedded.ActionActivationCode;
import org.eclipse.xtext.ui.editor.embedded.ActivationCodeTrigger;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorActions;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorMessages;
import org.eclipse.xtext.ui.editor.embedded.TextViewerOperationAction;
import org.eclipse.core.expressions.Expression;

import com.google.common.collect.Lists;

public class CustomEmbeddedEditorActions extends EmbeddedEditorActions {

    private Shell shell;
    private DisposeListener disposeListener;

    public CustomEmbeddedEditorActions(ISourceViewer viewer, IWorkbench workbench) {
        super(viewer, workbench);
    }

    @Override
    protected void initialize() {
        final java.util.List<IHandlerActivation> handlerActivations = Lists.newArrayListWithExpectedSize(3);
        final IHandlerService handlerService = (IHandlerService) workbench.getAdapter(IHandlerService.class);
        final IContextService contextService = (IContextService) workbench.getAdapter(IContextService.class);
        shell = viewer.getTextWidget().getShell();
        final org.eclipse.ui.ActiveShellExpression expression = new ActiveShellExpression(shell);
        final IContextActivation contextActivation = contextService.activateContext(EMBEDDED_TEXT_EDITOR_SCOPE, expression);

        disposeListener = new ShellDisposeListener();
        shell.addDisposeListener(disposeListener);

        viewer.getTextWidget().addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                handlerService.deactivateHandlers(handlerActivations);
                handlerActivations.clear();
            }

            @Override
            public void focusGained(FocusEvent e) {
                for (final IAction action : allActions.values()) {
                    handlerActivations.add(handlerService.activateHandler(action.getActionDefinitionId(), new ActionHandler(action), expression, true));
                }
            }

        });

        createActions();

        // create context menu
        MenuManager manager = new MenuManager(null, null);
        manager.setRemoveAllWhenShown(true);
        manager.addMenuListener(new IMenuListener() {

            @Override
            public void menuAboutToShow(IMenuManager mgr) {
                fillContextMenu(mgr);
            }
        });

        StyledText text = viewer.getTextWidget();
        Menu menu = manager.createContextMenu(text);
        text.setMenu(menu);

        java.util.List<ActionActivationCode> activationCodes = Lists.newArrayList();
        setActionActivationCode(activationCodes, ITextEditorActionConstants.SHIFT_RIGHT_TAB, '\t', -1, SWT.NONE);
        setActionActivationCode(activationCodes, ITextEditorActionConstants.SHIFT_LEFT, '\t', -1, SWT.SHIFT);
        viewer.getTextWidget().addVerifyKeyListener(new ActivationCodeTrigger(allActions, activationCodes));
    }

    @Override
    protected void createActions() {
        super.createActions();

        ResourceAction action = new FindReplaceAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.FindReplace.", Display.getDefault().getActiveShell(),
                viewer.getFindReplaceTarget());
        action.setHelpContextId(IAbstractTextEditorHelpContextIds.FIND_ACTION);
        action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_FIND_AND_REPLACE);
        setAction(ITextEditorActionConstants.FIND, action);

        // TODO (Define your own bundle
        action = new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Format.", viewer, ISourceViewer.FORMAT); //$NON-NLS-1$
        action.setActionDefinitionId(IJavaEditorActionDefinitionIds.FORMAT);
        setAction("Format", action);
    }

    @Override
    protected void fillContextMenu(IMenuManager menu) {
        menu.add(new GroupMarker(ITextEditorActionConstants.GROUP_UNDO));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, allActions.get(ITextEditorActionConstants.UNDO));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, allActions.get(ITextEditorActionConstants.REDO));

        menu.add(new Separator(ITextEditorActionConstants.GROUP_EDIT));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.CUT));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.COPY));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.PASTE));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.SELECT_ALL));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get("Format"));

        menu.add(new Separator(ITextEditorActionConstants.GROUP_GENERATE));
        menu.appendToGroup(ITextEditorActionConstants.GROUP_GENERATE, allActions.get("ContentAssistProposal")); //$NON-NLS-1$
    }

    public IAction getAction(String actionId) {
        return get(actionId);
    }

    public void cleanDisposeListener() {
        shell.removeDisposeListener(disposeListener);
        shell = null;
    }

    private static final class ShellDisposeListener implements DisposeListener {

        private IHandlerService handlerService;
        private IContextService contextService;

        private IContextActivation contextActivation;
        private java.util.List<IHandlerActivation> handlerActivations;

        @Override
        public void widgetDisposed(DisposeEvent e) {
            handlerService.deactivateHandlers(handlerActivations);
            contextService.deactivateContext(contextActivation);
        }
    }
}
