package uw.cs.watform.forml.services.GUI.FeatureModuleFocusContextViewer;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.FrmFPC_FeatureNode;
import uw.cs.watform.forml.services.GUI.GeneralFocusContextViewer.CreateElementForRoleable;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.CommonSpaceForContextualUI;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.EmbeddedEditorGenerator;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.CreateElementDialog;
import uw.cs.watform.forml.services.general.JS_FeatureClassServices;
import uw.cs.watform.forml.services.general.JS_MessageServices;
import uw.cs.watform.forml.services.utilities.ModelUtils2;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.wb.swt.SWTResourceManager;

public class CustomCompositeClassPropertiesViewer extends Composite {

	private Roleable currentRoleable;
	private Text txtClassName;
	Composite compositeProperites;
	private EObject elementUnderSearch;

	public CustomCompositeClassPropertiesViewer(Composite parent, int style, Roleable roleable,
			EObject searchedElement) {
		super(parent, style);
		this.elementUnderSearch = searchedElement;
		this.currentRoleable = roleable;

		ConstructDesing();

	}

	private void ConstructDesing() {

		setLayout(new GridLayout(1, false));

		txtClassName = new Text(this, SWT.BORDER);
		txtClassName.setEditable(false);
		txtClassName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtClassName.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		txtClassName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));

		compositeProperites = new Composite(this, SWT.NONE);
		GridData gd=new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd.widthHint=150;
		compositeProperites.setLayoutData(gd);
		
		populateClassProperties();

	}

	public void populateClassProperties(Roleable roleable, EObject searchElem) {
		this.elementUnderSearch = searchElem;
		this.currentRoleable = roleable;
		reset();
		populateClassProperties();
	}

	public void reset() {
		for (Control c : this.compositeProperites.getChildren()) {
			c.dispose();
		}

	}

	private Composite createCompositeInsideExpandItem(ExpandBar expandBar, ExpandItem xpndItem) {
		Composite xpndCompos = new Composite(expandBar, SWT.NONE);

		GridLayout gl_composite = new GridLayout(1, true);

		gl_composite.verticalSpacing = 1;
		gl_composite.numColumns = 1;
		xpndCompos.setLayout(gl_composite);

		xpndItem.setControl(xpndCompos);

		return xpndCompos;
	}

	private ExpandItem createXpndItemInsideExpandBar(ExpandBar expandBar, String text) {
		ExpandItem xpndItem = new ExpandItem(expandBar, SWT.NONE);
		xpndItem.setExpanded(true);
		xpndItem.setText(text);
		return xpndItem;
	}

	private void populateClassProperties() {
		compositeProperites.setLayout(new GridLayout(1, false));

		ExpandBar Attr_expandBar = new ExpandBar(compositeProperites, SWT.TOP | SWT.HORIZONTAL | SWT.V_SCROLL);
		Attr_expandBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		ExpandItem xpndtmAttributes = createXpndItemInsideExpandBar(Attr_expandBar, "Attributes");
		Composite xpndAttCompos = createCompositeInsideExpandItem(Attr_expandBar, xpndtmAttributes);

		generateCreateButton(this.currentRoleable, xpndtmAttributes, xpndAttCompos, Attribute.class);

		if (this.currentRoleable.getAttributes().size() > 0) {
			createObjectLabelsForAttsInpsOuts(xpndtmAttributes, xpndAttCompos, this.currentRoleable.getAttributes(),
					Attribute.class);
		}

		Attr_expandBar.pack();
		Attr_expandBar.layout(true, true);
		Attr_expandBar.redraw();

		if (this.currentRoleable instanceof Feature) {

			ExpandBar InMsg_expandBar = new ExpandBar(compositeProperites, SWT.TOP | SWT.V_SCROLL);
			InMsg_expandBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

			ExpandItem xpndtmInputmessages = createXpndItemInsideExpandBar(InMsg_expandBar, "Input Messages");
			Composite xpndInCompos = createCompositeInsideExpandItem(InMsg_expandBar, xpndtmInputmessages);

			generateCreateButton(this.currentRoleable, xpndtmInputmessages, xpndInCompos, Input.class);

			if (((Feature) this.currentRoleable).getInputlist() != null
					&& ((Feature) this.currentRoleable).getInputlist().getInputs().size() > 0) {
				createObjectLabelsForAttsInpsOuts(xpndtmInputmessages, xpndInCompos,
						((Feature) this.currentRoleable).getInputlist().getInputs(), Input.class);
			}

			ExpandBar OutMsg_expandBar = new ExpandBar(compositeProperites, SWT.TOP | SWT.V_SCROLL);
			OutMsg_expandBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

			ExpandItem xpndtmOutputMessages = createXpndItemInsideExpandBar(OutMsg_expandBar, "Output Messages");
			Composite xpndOutCompos = createCompositeInsideExpandItem(OutMsg_expandBar, xpndtmOutputMessages);

			generateCreateButton(this.currentRoleable, xpndtmOutputMessages, xpndOutCompos, Output.class);

			if (((Feature) this.currentRoleable).getOutputlist() != null
					&& ((Feature) this.currentRoleable).getOutputlist().getOutputs().size() > 0) {
				createObjectLabelsForAttsInpsOuts(xpndtmOutputMessages, xpndOutCompos,
						((Feature) this.currentRoleable).getOutputlist().getOutputs(), Output.class);
			}

			xpndInCompos.layout(true, true);
			xpndInCompos.redraw();

			xpndOutCompos.layout(true, true);
			xpndOutCompos.redraw();

		}

		else if (this.currentRoleable instanceof Entity) {
			// composite_FunctionViewer.setVisible(true);
			// composite_FunctionViewer.setLayoutData(new RowData(170, SWT.DEFAULT));

			ExpandBar function_expandBar = new ExpandBar(compositeProperites, SWT.TOP | SWT.V_SCROLL);
			function_expandBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));

			ExpandItem xpndtmFunctionmessages = createXpndItemInsideExpandBar(function_expandBar, "Functions");
			Composite xpndFuncCompos = createCompositeInsideExpandItem(function_expandBar, xpndtmFunctionmessages);

			generateCreateButton(this.currentRoleable, xpndtmFunctionmessages, xpndFuncCompos, Function.class);

			if (((Entity) this.currentRoleable).getFunctions() != null
					&& ((Entity) this.currentRoleable).getFunctions().size() > 0) {
				createObjectLabelsForAttsInpsOuts(xpndtmFunctionmessages, xpndFuncCompos,
						((Entity) this.currentRoleable).getFunctions(), Function.class);
			}

			xpndFuncCompos.layout(true, true);
			xpndFuncCompos.redraw();
		}
		// this.pack();

		txtClassName.setText(this.currentRoleable.getName());
		this.elementUnderSearch = null;
		// Attr_expandBar.pack();

		this.layout(true, true);
		setRedraw(true);
		this.pack();
	}

	private void generateCreateButton(Roleable parentRoleable, ExpandItem xpndItem, Composite parentCompos,
			Class type) {

		String buttonText = "";
		if (type.equals(Attribute.class)) {
			buttonText = "New Attribute";
		} else if (type.equals(Input.class)) {
			buttonText = "New Input Msg";
		} else if (type.equals(Output.class)) {
			buttonText = "New Output Msg";
		} else if (type.equals(Function.class)) {
			buttonText = "New Function";
		} else {
			return;
		}

		Button btnNew = new Button(parentCompos, SWT.LEFT);
		btnNew.setAlignment(SWT.LEFT);
		GridData gd_btnNew = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_btnNew.heightHint = 22;
		btnNew.setLayoutData(gd_btnNew);
		btnNew.setImage(SWTResourceManager.getImage(FrmFPC_FeatureNode.class,
				"/uw/cs/watform/forml/services/GUI/res/icon_addButton16.png"));
		btnNew.setText(buttonText);
		btnNew.setEnabled(true);
		btnNew.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (type.equals(Attribute.class)) {
					ShowCreateDialog("Attribute");
				} else if (type.equals(Input.class)) {
					ShowCreateDialog("Input Message");
				} else if (type.equals(Output.class)) {
					ShowCreateDialog("Output Message");
				} else if (type.equals(Function.class)) {
					ShowCreateDialog("Function");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		xpndItem.setControl(parentCompos);
		xpndItem.setHeight(parentCompos.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		xpndItem.setExpanded(true);

	}

	protected void ShowCreateDialog(String type) {
		CreateElementForRoleable createDialog = new CreateElementForRoleable(this.getShell(), this.currentRoleable);
		boolean sucessfulCreation = createDialog.open("new" + type, type);
		if (sucessfulCreation) {
			reset();
			populateClassProperties(this.currentRoleable, this.elementUnderSearch);
		}
	}

	private <T extends EObject> void createObjectLabelsForAttsInpsOuts(ExpandItem xpndItem, Composite parentComposite,
			EList<T> items, Class type) {

		// createNewButton(parentComposite, type);
		if (items.size() > 0) {

			org.eclipse.swt.widgets.List lst = new org.eclipse.swt.widgets.List(parentComposite,
					SWT.FILL | SWT.V_SCROLL);
			// lst.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

			for (T el : items) {
				String itemText = "";
				if (el instanceof RefMessage) {
					itemText = JS_MessageServices.PopulateMessageSignature(el);
				} else if (el instanceof Function) {
					itemText = JS_FeatureClassServices.PopulateFunctionLabel(el);
				} else if (el instanceof Attribute) {
					itemText = ((Attribute) el).getName();
					if (((Attribute) el).getType() != null) {
						String attType = ModelUtils2.convertAttributeTypeToString(((Attribute) el).getType());
						itemText += " : " + attType.trim();
					}
				}

				lst.add(itemText);
				lst.setData(itemText, el);

				if (el.equals(elementUnderSearch)) {
					int foundIndex = lst.getItemCount() - 1;
					lst.select(foundIndex);
				}

			}
			// lst.addSelectionListener(modelElementSelectionListener());

			lst.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					lst.deselectAll();

				}

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub

				}
			});

			// DNDOperationsForListItems.setDragSource(lst);
			// MenuTypeHelper.AssignRightClickMenu(lst, releventLeftSideList,
			// this.selectedRoleable, this);

		}

		xpndItem.setControl(parentComposite);
		xpndItem.setHeight(parentComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		xpndItem.setExpanded(true);
		parentComposite.pack();
		parentComposite.layout();
		parentComposite.redraw();
		// xpndItem.setControl(parentComposite);
		// xpndItem.setHeight(parentComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		// xpndItem.setExpanded(true);

	}
}
