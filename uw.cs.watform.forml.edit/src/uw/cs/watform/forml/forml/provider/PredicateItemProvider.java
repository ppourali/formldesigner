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
import uw.cs.watform.forml.forml.Predicate;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Predicate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PredicateItemProvider 
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
	public PredicateItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_Predicate_logicop_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Predicate_logicop_feature", "_UI_Predicate_type"),
				 FormlPackage.Literals.PREDICATE__LOGICOP,
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
			childrenFeatures.add(FormlPackage.Literals.PREDICATE__VAR);
			childrenFeatures.add(FormlPackage.Literals.PREDICATE__SEXPR);
			childrenFeatures.add(FormlPackage.Literals.PREDICATE__QUANT_PRED);
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
	 * This returns Predicate.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Predicate"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Predicate)object).getLogicop();
		return label == null || label.length() == 0 ?
			getString("_UI_Predicate_type") :
			getString("_UI_Predicate_type") + " " + label;
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

		switch (notification.getFeatureID(Predicate.class)) {
			case FormlPackage.PREDICATE__LOGICOP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FormlPackage.PREDICATE__VAR:
			case FormlPackage.PREDICATE__SEXPR:
			case FormlPackage.PREDICATE__QUANT_PRED:
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
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__VAR,
				 FormlFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__SEXPR,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.PREDICATE__QUANT_PRED,
				 FormlFactory.eINSTANCE.createnotPred()));
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
