package uw.cs.watform.forml.services.GUI.SeachEverything;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import uw.cs.watform.forml.services.utilities.ModelUtils;
import org.eclipse.wb.swt.SWTResourceManager;

public class CustomCompositeSearchForEveryThing extends Composite {

	CustomSearchBarForEveryThing searchBar;
	private EObject any;
	private Composite txtTransitionComposite;
	Composite parentComposite;

	public CustomCompositeSearchForEveryThing(Composite parent, int style, EObject anyElement) {
		super(parent, style);
		this.any = anyElement;
		ConstructDesign();
	}

	private void ConstructDesign() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		parentComposite = new Composite(this, SWT.BORDER);
		GridLayout gl_parentComposite = new GridLayout(1, false);
		gl_parentComposite.marginHeight = 2;
		gl_parentComposite.marginWidth = 2;
		gl_parentComposite.verticalSpacing = 2;
		gl_parentComposite.horizontalSpacing = 2;
		parentComposite.setLayout(gl_parentComposite);
		searchBar = new CustomSearchBarForEveryThing(parentComposite, SWT.None, any, this);
		searchBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		txtTransitionComposite = new Composite(parentComposite, SWT.BORDER);
		txtTransitionComposite.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		txtTransitionComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		txtTransitionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		txtTransitionComposite.setVisible(true);
		// txtTransitionComposite.pack();
//		GridLayout gl_composite = new GridLayout(2, false);
//		gl_composite.verticalSpacing = 4;
//		gl_composite.marginTop = 2;
//		gl_composite.marginBottom = 2;
//		gl_composite.marginHeight = 2;
//		gl_composite.marginWidth = 2;
//		composite.setLayout(gl_composite);
		// shell.open();

	}

	public boolean CreateEditor(EObject element) {
		// Create Editor For the Whole Transition

		if (element != null) {
			for (Control ch : txtTransitionComposite.getChildren()) {
				ch.dispose();
			}

			// Composite composite_TextualEditor = new Composite(txtTransitionComposite,
			// SWT.BORDER);
			// composite_TextualEditor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
			// true, 1, 1));

			XtextEmbeddedEditorForEveryThing eobject_embeddedEditor = new XtextEmbeddedEditorForEveryThing(null,
					ModelUtils.getInjector());
			eobject_embeddedEditor.showEditor(element, null, txtTransitionComposite);
			txtTransitionComposite.layout(true);
			
			return true;
		}
		return false;
	}

//	public void open() {
//
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}
//	}
}
