package uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.services.GUI.FeatureNodeFocusContext.NewElementCreation.NewElementsCreationHelperClass;
import uw.cs.watform.forml.services.utilities.AssociationUtils;

public class CustomListForClasses extends Composite {

	private Table list;
	private Image aggregationImage = SWTResourceManager.getImage(FrmFPC_FeatureNode.class,
			"/uw/cs/watform/forml/services/GUI/res/icon_Aggregation.png");
	private Image compositionImage = SWTResourceManager.getImage(FrmFPC_FeatureNode.class,
			"/uw/cs/watform/forml/services/GUI/res/icon_Composition.png");
	private Image associationImage = SWTResourceManager.getImage(FrmFPC_FeatureNode.class,
			"/uw/cs/watform/forml/services/GUI/res/icon_Association.png");
	private Image generalizationImage = SWTResourceManager.getImage(FrmFPC_FeatureNode.class,
			"/uw/cs/watform/forml/services/GUI/res/icon_Generalization.png");

	public CustomListForClasses(Composite parent, int style, int heightHint) {
		super(parent, style);

		ConstructDesign(style, heightHint);
	}

	private void ConstructDesign(int style, int heightHint) {

		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_composite_1.heightHint = heightHint;
		setLayoutData(gd_composite_1);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		list = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		list.setHeaderVisible(false);
		list.setLinesVisible(false);

	}

	private void setRelationImage(TableItem item, Roleable relatedElement, Roleable self) {
		if (AssociationUtils.hasGeneralizationType(relatedElement, self)) {

			item.setImage(generalizationImage);
		} else if (AssociationUtils.hasAssociationType(relatedElement, self)) {

			item.setImage(associationImage);
		} else if (AssociationUtils.hasCompositionType(relatedElement, self)) {

			item.setImage(compositionImage);
		} else if (AssociationUtils.hasAggregationType(relatedElement, self)) {

			item.setImage(aggregationImage);
		}
	}

	private int getHeightHint(int heightHint) {
		int min = 50;
		if (heightHint < min)
			return min;
		else {

		}
		return min;
	}

	public void add(String name, Roleable relatedElement, Roleable self) {
		TableItem item = new TableItem(this.getList(), SWT.NONE);
		item.setText(name);
		if (relatedElement != null && self != null) {
			setRelationImage(item, relatedElement, self);
			setRightClick(relatedElement, self);
			this.list.setData(name, relatedElement);
		}
	}

	private void setRightClick(Roleable relatedElement, Roleable self) {
		Menu popupMenu = new Menu(this.list);

		MenuItem associationTypeItem = new MenuItem(popupMenu, SWT.NONE);
		associationTypeItem.setText("Association");
		associationTypeItem.setData(self);
		associationTypeItem.addSelectionListener(menuItemListener(associationTypeItem, this.list, this));
		associationTypeItem.setImage(associationImage);

		MenuItem compositionTypeItem = new MenuItem(popupMenu, SWT.NONE);
		compositionTypeItem.setText("Composition");
		compositionTypeItem.setData(self);
		compositionTypeItem.addSelectionListener(menuItemListener(compositionTypeItem, this.list, this));
		compositionTypeItem.setImage(compositionImage);

		MenuItem aggregationTypeItem = new MenuItem(popupMenu, SWT.NONE);
		aggregationTypeItem.setText("Aggregation");
		aggregationTypeItem.setData(self);
		aggregationTypeItem.addSelectionListener(menuItemListener(aggregationTypeItem, this.list, this));
		aggregationTypeItem.setImage(aggregationImage);

		MenuItem generalizatonTypeItem = new MenuItem(popupMenu, SWT.NONE);
		generalizatonTypeItem.setText("Generalization");
		generalizatonTypeItem.setData(self);
		generalizatonTypeItem.addSelectionListener(menuItemListener(generalizatonTypeItem, this.list, this));
		generalizatonTypeItem.setImage(generalizationImage);

		this.list.setMenu(popupMenu);

	}

	private static SelectionListener menuItemListener(MenuItem menuItem, Table list,
			CustomListForClasses releventLeftSideList) {
		// TODO Auto-generated method stub
		return new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (list.getSelectionCount() > 0) {
					String itemName = list.getSelection()[0].getText();

					Object associatiedClass = list.getData(itemName);
					Object sourceSelfClass = menuItem.getData();

					if (sourceSelfClass instanceof Roleable && associatiedClass instanceof Roleable) {
						NewElementsCreationHelperClass.ChangeAssociationType((Roleable) associatiedClass,
								releventLeftSideList, itemName);

					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	public void deselectAll() {
		this.getList().deselectAll();

	}

	public List<String> getItems() {

		List<String> items = new ArrayList<String>();
		for (TableItem ti : this.getList().getItems()) {
			items.add(ti.getText());
		}

		return items;
	}

	public void setSelection(String[] selectionTexts) {
		List<TableItem> selectionitems = new ArrayList<TableItem>();

		for (String s : selectionTexts) {
			for (TableItem ti : this.getList().getItems()) {
				if (ti.getText().equalsIgnoreCase(s)) {
					selectionitems.add(ti);
				}
			}

		}

		TableItem[] itemsArr = new TableItem[selectionitems.size()];
		itemsArr = selectionitems.toArray(itemsArr);

		this.getList().setSelection(itemsArr);
	}

	public int getSelectionIndex() {
		return this.getList().getSelectionIndex();
	}

	public void setSelection(int selection) {
		this.getList().setSelection(selection);

	}

	public void select(int index) {
		this.getList().select(index);

	}

	public int getItemCount() {
		// TODO Auto-generated method stub
		return this.getList().getItemCount();
	}

	public String[] getSelection() {
		// TODO Auto-generated method stub
		TableItem[] selectionitems = this.getList().getSelection();
		List<String> itemsString = new ArrayList<String>();
		for (TableItem selItem : selectionitems) {
			itemsString.add(selItem.getText());
		}
		String[] itemsArr = new String[itemsString.size()];
		itemsArr = itemsString.toArray(itemsArr);

		return itemsArr;
	}

	public void addSelectionListener(SelectionListener listSelectionListener) {
		this.getList().addSelectionListener(listSelectionListener);
	}

	public Table getList() {
//		if (this.list == null)
//			ConstructDesign();
		return list;
	}

	public void setList(Table list) {
		this.list = list;
	}

	public int getSelectionCount() {
		return this.list.getSelectionCount();
	}

	public void removeAll() {
		this.getList().removeAll();

	}

}
