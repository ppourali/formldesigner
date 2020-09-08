package uw.cs.watform.forml.services.virtualresource;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

import uw.cs.watform.forml.services.utilities.ModelUtils;

public class CustomVirtualResource {

	private XtextEmbeddedEditorOperationsOnly xtextEditor;

	public CustomVirtualResource(EObject element) {

		try {
			// Create Editor For the element
			setXtextEditor(new XtextEmbeddedEditorOperationsOnly(ModelUtils.getInjector())); //

			getXtextEditor().createEditor(element);
			EmbeddedEditorModelAccess partialEditorModelAccess_Event = getXtextEditor().partialEditorModelAccess;

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		try {
			String allText = rootNode.getText();

			ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

			String prefix = allText.substring(0, elementNode.getOffset() - 1);
			String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

			String suffix = allText.substring(elementNode.getEndOffset());

			parts[0] = prefix;
			parts[1] = editablePart;
			parts[2] = suffix;
		} catch (Exception e) {
			parts[0] = "";
			parts[1] = "[]";
			parts[2] = "";
		}
		return parts;
	}

	public void revertBack() {
		getXtextEditor().updateResource(true);
	}

	public XtextEmbeddedEditorOperationsOnly getXtextEditor() {
		return xtextEditor;
	}

	public void setXtextEditor(XtextEmbeddedEditorOperationsOnly xtextEditor) {
		this.xtextEditor = xtextEditor;
	}

}
