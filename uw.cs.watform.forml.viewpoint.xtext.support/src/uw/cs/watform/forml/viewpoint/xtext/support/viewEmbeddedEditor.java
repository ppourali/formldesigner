package uw.cs.watform.forml.viewpoint.xtext.support;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class viewEmbeddedEditor extends ViewPart {

	public XtextResource xtextResource;
	public Injector xtextInjector;
	public String prefix;
	public String editablePart;
	public String suffix;


	@Override
	public void createPartControl(Composite parent) {
		Composite top=new Composite(parent, SWT.BORDER);

		try{
			CustomEmbeddedEditorFactory factory = xtextInjector.getInstance(CustomEmbeddedEditorFactory.class);
			EmbeddedEditor editor = factory.newEditor(new IEditedResourceProvider() {

				@Override
				public XtextResource createResource() {
					return xtextResource;
				}
			}).showErrorAndWarningAnnotations().withParent(top); 
			EmbeddedEditorModelAccess model = editor.createPartialEditor(prefix,
					editablePart, suffix, true);

			
			//editor.getViewer().getControl().setLayoutData(new GridData());
		}
		catch(Exception e)
		{

		}

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
