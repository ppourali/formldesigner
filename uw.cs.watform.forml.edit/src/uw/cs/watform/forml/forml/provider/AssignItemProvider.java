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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import uw.cs.watform.forml.forml.Assign;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Assign} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssignItemProvider 
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
	public AssignItemProvider(AdapterFactory adapterFactory) {
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

			addRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Assign_ref_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Assign_ref_feature", "_UI_Assign_type"),
				 FormlPackage.Literals.ASSIGN__REF,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(FormlPackage.Literals.ASSIGN__SEXPR);
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
	 * This returns Assign.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Assign"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Assign_type");
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

		switch (notification.getFeatureID(Assign.class)) {
			case FormlPackage.ASSIGN__SEXPR:
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
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createWorldModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAttributeType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createMultiplicity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createCardinality()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createInputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createOutputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createRefMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createBehaviourModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createFeatureModule()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createStateMachine()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createInitState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createPriority()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createTransList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createGuard()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createOverride()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createWCE()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createWCAList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createWCA()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAssignList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAssign()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createMacro()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createnotPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createandPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createimpPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createorPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createbasePred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createboolExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createpredExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createpredExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createpredExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createsetExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createsetExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createsetExprBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createintExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createmultExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createintBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createatomic()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createunspecified()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createFragmentType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createStateContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createRegionContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createStateMachineContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createTranFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createWCAFragmentList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createWCAFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createCompDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
				 FormlFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ASSIGN__SEXPR,
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
