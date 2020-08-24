package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

import uw.cs.watform.forml.services.utilities.ModelUtils;

public class CustomEmbeddedEditorResourceProvider implements IEditedResourceProvider {

	public static final String SYNTHETIC_SCHEME = "synthetic";
	XtextResource xtextResouce = null;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private FileExtensionProvider ext;

	@Override
	public XtextResource createResource() {
		ResourceSet resourceSet = resourceSetProvider.get(null);
		URI uri = URI.createURI("platform:/resource/FormlTest/model.forml");
		XtextResource result = (XtextResource) resourceSet.createResource(uri);
		resourceSet.getResources().add(result);
		return result;
	}

	public XtextResource createResource(EObject element) {
		ResourceSet resourceSet = resourceSetProvider.get(null);

		Resource originalResource = element.eResource();

		EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));

		try {
			xtextResouce = createVirtualXtextResource(originalResource.getURI(), semanticElement);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resourceSet.getResources().add(xtextResouce);
		return xtextResouce;

	}

	public EObject getObject(EObject element) {
		// ResourceSet resourceSet = resourceSetProvider.get(null);
		System.out.println(ModelUtils.getTextForModelObjects(element).trim());
		return this.xtextResouce.getEObject(element.eResource().getURI().toString());

	}

	protected XtextResource createVirtualXtextResource(URI uri, EObject semanticElement) throws IOException {
		IResourceFactory resourceFactory = ModelUtils.getInjector().getInstance(IResourceFactory.class);
		// TODO use the synthetic scheme.
		XtextResourceSet rs = ModelUtils.getInjector().getInstance(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		// Create virtual resource
		XtextResource xtextVirtualResource = (XtextResource) resourceFactory
				.createResource(URI.createURI(uri.toString()));
		rs.getResources().add(xtextVirtualResource);

		// Populate virtual resource with the given semantic element to edit
		xtextVirtualResource.getContents().add(semanticElement);

		// Save and reparse in order to initialize virtual Xtext resource
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		xtextVirtualResource.save(out, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		xtextVirtualResource.reparse(new String(out.toByteArray()));

		return xtextVirtualResource;
	}
}