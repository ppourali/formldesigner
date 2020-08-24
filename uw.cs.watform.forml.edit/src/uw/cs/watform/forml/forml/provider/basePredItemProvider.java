/**
 */
package uw.cs.watform.forml.forml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.basePred;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.basePred} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class basePredItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public basePredItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLogicopPropertyDescriptor(object);
			addOpPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Logicop feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLogicopPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_basePred_logicop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_basePred_logicop_feature", "_UI_basePred_type"),
				 FormlPackage.Literals.BASE_PRED__LOGICOP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Op feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_basePred_op_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_basePred_op_feature", "_UI_basePred_type"),
				 FormlPackage.Literals.BASE_PRED__OP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__CARDPRED);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__SETLHS);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__SETRHS);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__BOOLRHS);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__INTLHS);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__INTRHS);
			childrenFeatures.add(FormlPackage.Literals.BASE_PRED__PAREN_PRED);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns basePred.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/basePred"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((basePred)object).getLogicop();
		return label == null || label.length() == 0 ?
			getString("_UI_basePred_type") :
			getString("_UI_basePred_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(basePred.class)) {
			case FormlPackage.BASE_PRED__LOGICOP:
			case FormlPackage.BASE_PRED__OP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FormlPackage.BASE_PRED__CARDPRED:
			case FormlPackage.BASE_PRED__SETLHS:
			case FormlPackage.BASE_PRED__SETRHS:
			case FormlPackage.BASE_PRED__BOOLRHS:
			case FormlPackage.BASE_PRED__INTLHS:
			case FormlPackage.BASE_PRED__INTRHS:
			case FormlPackage.BASE_PRED__PAREN_PRED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__CARDPRED,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__SETLHS,
				 FormlFactory.eINSTANCE.createpredExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__SETRHS,
				 FormlFactory.eINSTANCE.createpredExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__BOOLRHS,
				 FormlFactory.eINSTANCE.createboolExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__INTLHS,
				 FormlFactory.eINSTANCE.createintExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__INTRHS,
				 FormlFactory.eINSTANCE.createintExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.BASE_PRED__PAREN_PRED,
				 FormlFactory.eINSTANCE.createPredicate()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == FormlPackage.Literals.BASE_PRED__SETLHS ||
			childFeature == FormlPackage.Literals.BASE_PRED__SETRHS ||
			childFeature == FormlPackage.Literals.BASE_PRED__INTLHS ||
			childFeature == FormlPackage.Literals.BASE_PRED__INTRHS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return FormlEditPlugin.INSTANCE;
	}

}
