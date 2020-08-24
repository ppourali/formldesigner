package uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.services.utilities.ModelUtils2;

public class CustomCompositeForCrossReferenceView_TreeStyle extends Composite {

	private Composite composite_TreeAndEditorHolder;

	List<EObject> crossReferences = new ArrayList<EObject>();
	private Composite composite_TextualEditor;
	private EObject focusElemenet;
	// private CustomTreeNodeForConsistencyManagement composite_TreeHolder;

	private Composite composite_3;
	private CLabel label;

	private CustomTreeViewerForCrossReferences composite_TreeHolder;

	public CustomCompositeForCrossReferenceView_TreeStyle(Composite parent, int style, EObject elem) {

		super(parent, style);
		Collection<Setting> crossRefs = ModelUtils2.getReferencesBySemanticType(elem);

		generateCrossRefsFromCollection(crossRefs);
		this.focusElemenet = elem;

		constructDesign(parent);

		setRedraw(true);
		this.layout();

	}

	private void generateCrossRefsFromCollection(Collection<Setting> crossRefs) {
		Iterator<Setting> iter = crossRefs.iterator();
//
		while (iter.hasNext()) {
			EObject ref = iter.next().getEObject();
			//
			// Transition parentTransition = ModelUtils.getTypedRootForObject(ref,
			// Transition.class);
//
			// if (parentTransition != null) {
			// if (!alreaddyAdded.contains(parentTransition)) {
			this.crossReferences.add(ref);
			// alreaddyAdded.add(parentTransition);
			// }
			// }
		}

	}

	private void constructDesign(Composite parent) {

		GridLayout gl_shell = new GridLayout(2, false);
		gl_shell.horizontalSpacing = 1;
		setLayout(gl_shell);

		composite_TreeAndEditorHolder = new Composite(this, SWT.NONE);
		composite_TreeAndEditorHolder.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_TreeAndEditorHolder = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_composite_TreeAndEditorHolder.widthHint = 1000;
		composite_TreeAndEditorHolder.setLayoutData(gd_composite_TreeAndEditorHolder);
		// lblInfoText.setSize(20, 20);
		composite_TreeHolder = new CustomTreeViewerForCrossReferences(composite_TreeAndEditorHolder, SWT.BORDER,
				this.focusElemenet);

		composite_TextualEditor = new Composite(composite_TreeAndEditorHolder, SWT.BORDER);

		composite_3 = new Composite(this, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_composite_3.heightHint = 19;
		gd_composite_3.widthHint = 394;
		composite_3.setLayoutData(gd_composite_3);

		label = new CLabel(composite_3, SWT.NONE);
		label.setText("Please use Shift+Enter to save the modifications in the embedder.");
		label.setForeground(SWTResourceManager.getColor(255, 0, 0));

		setTreeHolderControls();
		// this.pack();
	}

	private void setTreeHolderControls() {
		composite_TreeHolder.setContorls(composite_TreeAndEditorHolder, composite_TextualEditor);

	}
}
