package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.common.base.Optional;

public abstract class CustomEmbeddedEditor extends EmbeddedEditor {

    public CustomEmbeddedEditor(XtextDocument document, XtextSourceViewer viewer, XtextSourceViewerConfiguration configuration, IEditedResourceProvider resourceProvider,
            Runnable afterSetDocumet) {
        super(document, viewer, configuration, resourceProvider, afterSetDocumet);
    }

    public abstract void cleanDisposeListener();

    public abstract Optional<IAction> getAction(String actionId);
}