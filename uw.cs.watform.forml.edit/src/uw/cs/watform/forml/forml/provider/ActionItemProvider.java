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

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.FormlFactory;
import uw.cs.watform.forml.forml.FormlPackage;

/**
 * This is the item provider adapter for a {@link uw.cs.watform.forml.forml.Action} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionItemProvider 
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
	public ActionItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addOutPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Action_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Action_type_feature", "_UI_Action_type"),
				 FormlPackage.Literals.ACTION__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Out feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Action_out_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Action_out_feature", "_UI_Action_type"),
				 FormlPackage.Literals.ACTION__OUT,
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
			childrenFeatures.add(FormlPackage.Literals.ACTION__LIST);
			childrenFeatures.add(FormlPackage.Literals.ACTION__MINEXPR);
			childrenFeatures.add(FormlPackage.Literals.ACTION__LVALUE);
			childrenFeatures.add(FormlPackage.Literals.ACTION__RVALUE);
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
	 * This returns Action.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Action"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Action_type");
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

		switch (notification.getFeatureID(Action.class)) {
			case FormlPackage.ACTION__LIST:
			case FormlPackage.ACTION__MINEXPR:
			case FormlPackage.ACTION__LVALUE:
			case FormlPackage.ACTION__RVALUE:
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
				(FormlPackage.Literals.ACTION__LIST,
				 FormlFactory.eINSTANCE.createAssignList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__MINEXPR,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createWorldModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAttributeType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createMultiplicity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createCardinality()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createInputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createOutputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createRefMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createBehaviourModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createFeatureModule()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createStateMachine()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createInitState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createPriority()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createTransList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createGuard()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createOverride()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createWCE()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createWCAList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createWCA()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAssignList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAssign()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createMacro()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createnotPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createandPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createimpPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createorPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createbasePred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createboolExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createpredExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createpredExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createpredExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createsetExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createsetExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createsetExprBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createintExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createmultExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createintBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createatomic()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createunspecified()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createFragmentType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createStateContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createRegionContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createStateMachineContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createTranFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createWCAFragmentList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createWCAFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createCompDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__LVALUE,
				 FormlFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createWorldModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createExprRef()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createConcept()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createRoleable()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createRelationship()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAttributeType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createIntType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createBoolType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createReferenceType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createMultiplicity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createCardinality()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createInputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createOutputList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createRefMessage()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createBehaviourModel()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createFeatureModule()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createStateMachine()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createInitState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createComponent()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createPriority()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createTransList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createGuard()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createTrigger()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createOverride()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createWCE()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createWCAList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createWCA()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAssignList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAssign()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createMacro()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createnotPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createandPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createimpPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createorPred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createbasePred()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createboolExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createpredExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createpredExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createpredExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createsetExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createsetExpr2()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createsetExpr3()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createsetExprBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createintExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createmultExpr()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createintBase()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createatomic()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createunspecified()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createFragmentType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createStateContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createRegionContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createStateMachineContext()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createTranFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createWCAFragmentList()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createWCAFragment()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createEntity()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createUndefinedType()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAggregation()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createComposition()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createCompDecl()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createSPL()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createXORNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createAndNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createOrNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createFeatureNode()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createEnumConst()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createState()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createRegion()));

		newChildDescriptors.add
			(createChildParameter
				(FormlPackage.Literals.ACTION__RVALUE,
				 FormlFactory.eINSTANCE.createVariable()));
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
			childFeature == FormlPackage.Literals.ACTION__LIST ||
			childFeature == FormlPackage.Literals.ACTION__LVALUE ||
			childFeature == FormlPackage.Literals.ACTION__RVALUE ||
			childFeature == FormlPackage.Literals.ACTION__MINEXPR;

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
