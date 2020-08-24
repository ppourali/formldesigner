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

import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Association} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssociationItemProvider extends RelationshipItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES);
			childrenFeatures.add(FormlPackage.Literals.ASSOCIATION__SRC_ROLE);
			childrenFeatures.add(FormlPackage.Literals.ASSOCIATION__DES_ROLE);
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
	 * This returns Association.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Association"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Association)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Association_type") :
			getString("_UI_Association_type") + " " + label;
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

		switch (notification.getFeatureID(Association.class)) {
			case FormlPackage.ASSOCIATION__ATTRIBUTES:
			case FormlPackage.ASSOCIATION__SRC_ROLE:
			case FormlPackage.ASSOCIATION__DES_ROLE:
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
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__ATTRIBUTES,
				 FormlFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__SRC_ROLE,
				 FormlFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSOCIATION__DES_ROLE,
				 FormlFactory.eINSTANCE.createRole()));
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
			childFeature == FormlPackage.Literals.ASSOCIATION__SRC_ROLE ||
			childFeature == FormlPackage.Literals.ASSOCIATION__DES_ROLE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
