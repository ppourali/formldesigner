/**
 */
package uw.cs.watform.forml.forml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Enumeration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EnumerationItemProvider extends ConceptItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(FormlPackage.Literals.ENUMERATION__CONSTANT);
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
	 * This returns Enumeration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Enumeration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Enumeration)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Enumeration_type") :
			getString("_UI_Enumeration_type") + " " + label;
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

		switch (notification.getFeatureID(Enumeration.class)) {
			case FormlPackage.ENUMERATION__CONSTANT:
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
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ENUMERATION__CONSTANT,
				 FormlFactory.eINSTANCE.createVariable()));
	}

}
