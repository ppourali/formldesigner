package uw.cs.watform.forml.services.GUI.CustomControls;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.services.GUI.InteractiveReferenceViewer.FrmShellForCrossReferenceView_NEWBUTNOTUSED;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForCrossReferences;

public class CustomElementEditorFromCrossReferenceViewer extends SashForm {

	public FormToolkit frmToolkit;
	private FrmShellForCrossReferenceView_NEWBUTNOTUSED shellContainer;
	private Composite composite_RIGHT, composite_TransitionEditor;
	private StyledText txtElementName;
	private Combo comboAction;
	public itemClassData data;
	private XtextEmbeddedEditorForCrossReferences transition_embeddedEditor;

	public CustomElementEditorFromCrossReferenceViewer(Composite parent, int style,
			FrmShellForCrossReferenceView_NEWBUTNOTUSED cntner, FormToolkit frmtkit) {
		super(parent, SWT.VERTICAL);
		this.frmToolkit = frmtkit;
		frmToolkit.setBackground(null);

		setBackground(SWTResourceManager.getColor(255, 228, 196));
		setSashWidth(2);
		this.shellContainer = cntner;

		// setLayoutData(new RowData(551, 100));
		Composite composite_LEFT = new Composite(this, SWT.NONE);
		composite_LEFT.setBackground(SWTResourceManager.getColor(255, 228, 196));
		// frmToolkit.adapt(composite_LEFT);
		// frmToolkit.paintBordersFor(composite_LEFT);
		composite_LEFT.setLayout(new GridLayout(5, false));

		CLabel lblElement = new CLabel(composite_LEFT, SWT.NONE);
		lblElement.setBackground(SWTResourceManager.getColor(255, 228, 196));
		lblElement.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		// frmToolkit.adapt(lblElement);
		// frmToolkit.paintBordersFor(lblElement);
		lblElement.setText("Feature Module");

		txtElementName = new StyledText(composite_LEFT, SWT.SINGLE);
		txtElementName.setBackground(SWTResourceManager.getColor(255, 228, 196));
		txtElementName.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		txtElementName.setEditable(false);
		GridData gd_txtElementName = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtElementName.heightHint = 21;
		gd_txtElementName.widthHint = 126;
		txtElementName.setLayoutData(gd_txtElementName);
		// frmToolkit.adapt(txtElementName);
		// frmToolkit.paintBordersFor(txtElementName);

		CLabel lblAction = new CLabel(composite_LEFT, SWT.NONE);
		lblAction.setBackground(SWTResourceManager.getColor(255, 228, 196));
		GridData gd_lblAction = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblAction.widthHint = 66;
		lblAction.setLayoutData(gd_lblAction);
		lblAction.setAlignment(SWT.RIGHT);
		lblAction.setLeftMargin(30);
		lblAction.setText("Action");
		// frmToolkit.adapt(lblAction);
		// frmToolkit.paintBordersFor(lblAction);

		comboAction = new Combo(composite_LEFT, SWT.NONE);
		GridData gd_comboAction = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_comboAction.widthHint = 104;
		comboAction.setLayoutData(gd_comboAction);
		comboAction.setItems(new String[] { "Edit", "Delete" });
		comboAction.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (comboAction.getText().trim().equalsIgnoreCase("Edit")) {
					setEditable();
				} else if (comboAction.getText().trim().equalsIgnoreCase("Delete")) {
					setDeletable();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// frmToolkit.adapt(comboAction);
		// frmToolkit.paintBordersFor(comboAction);
		comboAction.setBackground(SWTResourceManager.getColor(213, 246, 204));

		Button btnApplyChange = new Button(composite_LEFT, SWT.NONE);
		btnApplyChange.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AcceptChanges();
			}
		});
		btnApplyChange.setImage(SWTResourceManager.getImage(CustomElementEditorFromCrossReferenceViewer.class,
				"/uw/cs/watform/forml/services/GUI/res/window_accept.png"));
		GridData gd_btnApplyChange = new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1);
		gd_btnApplyChange.widthHint = 105;
		btnApplyChange.setLayoutData(gd_btnApplyChange);
		frmtkit.adapt(btnApplyChange, true, true);
		btnApplyChange.setText("Accept");

		composite_RIGHT = new Composite(this, SWT.NONE);
		composite_RIGHT.setLayout(new FillLayout(SWT.HORIZONTAL));

		composite_TransitionEditor = new Composite(composite_RIGHT, SWT.NONE);
		// frmToolkit.adapt(composite_TransitionEditor);
		// frmToolkit.paintBordersFor(composite_TransitionEditor);
		composite_TransitionEditor.setLayout(new FillLayout(SWT.HORIZONTAL));
		setWeights(new int[] { 1, 2 });
		// this.pack();
	}

	public void initialize(Transition parentTransition) {
		data = new itemClassData(parentTransition, true);
		//createTransitionEditor(parentTransition, true);

		FeatureModule fm = ModelUtils.getTypedRootForObject(parentTransition, FeatureModule.class);
		this.txtElementName.setText(fm.getFeatureref().getName());

		comboAction.select(0);
	}

	public boolean AcceptChanges() {
		// if edit
		if (data.edit == true) {

			boolean successfullyAccepted = transition_embeddedEditor.closeEditor(true);

			if (successfullyAccepted) {
				Composite parent = this.getParent();
				this.dispose();
				parent.pack();
			}
			return successfullyAccepted;
		}
		// if delete
		else if (data.edit == false) {
			EcoreUtil.delete(data.transition);
			Composite parent = this.getParent();
			this.dispose();
			parent.pack();
			return true;
		}

		// boolean successfullyAccepted = transition_embeddedEditor.closeEditor(true);

		// return successfullyAccepted;
		return false;
	}

	public void createTransitionEditor(Transition trans, boolean isEdit) {

		// Create Editor For the Whole Transition
		//transition_embeddedEditor = new XtextEmbeddedEditorForCrossReferencesViewer(ModelUtils.getInjector(), isEdit);

		transition_embeddedEditor.shellContainer = shellContainer;

		composite_TransitionEditor.dispose();
		composite_TransitionEditor = new Composite(composite_RIGHT, SWT.NONE);

		transition_embeddedEditor.showEditor(trans, composite_TransitionEditor);
		composite_TransitionEditor.update();
		composite_TransitionEditor.pack();
		composite_TransitionEditor.setSize(composite_RIGHT.getSize());
		composite_RIGHT.pack();
	}

	private void setEditable() {
		comboAction.setBackground(SWTResourceManager.getColor(213, 246, 204));
		transition_embeddedEditor.changeEditorColor(true);
		data.edit = true;
	}

	private void setDeletable() {
		comboAction.setBackground(SWTResourceManager.getColor(253, 198, 198));
		transition_embeddedEditor.changeEditorColor(false);
		data.edit = false;
	}

	public class itemClassData {
		public Transition transition;
		public boolean edit;

		public itemClassData(Transition parentTransition, boolean b) {
			this.transition = parentTransition;
			this.edit = b;
		}
	}
}