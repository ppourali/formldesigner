/**
 */
package uw.cs.watform.forml.forml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.notPred;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.notPred} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class notPredItemProvider 
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
	public notPredItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(FormlPackage.Literals.NOT_PRED__PRED);
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
	 * This returns notPred.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/notPred"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_notPred_type");
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

		switch (notification.getFeatureID(notPred.class)) {
			case FormlPackage.NOT_PRED__PRED:
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
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createWorldModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAttributeType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createMultiplicity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createCardinality()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createInputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createOutputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createRefMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createBehaviourModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createFeatureModule()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createStateMachine()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createInitState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createPriority()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createTransList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createGuard()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createOverride()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createWCE()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createWCAList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createWCA()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAssignList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAssign()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createMacro()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createnotPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createandPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createimpPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createorPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createbasePred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createboolExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createpredExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createpredExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createpredExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createsetExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createsetExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createsetExprBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createintExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createmultExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createintBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createatomic()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createunspecified()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createFragmentType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createStateContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createRegionContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createStateMachineContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createTranFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createWCAFragmentList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createWCAFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createCompDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.NOT_PRED__PRED,
				 FormlFactory.eINSTANCE.createVariable()));
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
