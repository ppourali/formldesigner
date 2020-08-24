package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorActions;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorActions.Factory;

public class CustomEmbeddedEditorActionsFactory extends Factory {

    @Override
    protected EmbeddedEditorActions createActions(ISourceViewer viewer) {
        return new CustomEmbeddedEditorActions(viewer, workbench);
    }
}
