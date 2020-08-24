package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;

public class EmbeddedXtextResource extends LazyLinkingResource {

	private Resource parentResource = null;

	public Resource getParentResource() {
		return parentResource;
	}

	public void setParentResource(Resource parentResource) {
		this.parentResource = parentResource;
	}

	public EmbeddedXtextResource() {
		super();
	}

}
