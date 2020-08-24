/**
 */
package uw.cs.watform.forml.forml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Aggregation;
import uw.cs.watform.forml.forml.AndNode;
import uw.cs.watform.forml.forml.Assign;
import uw.cs.watform.forml.forml.AssignList;
import uw.cs.watform.forml.forml.Association;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.BehaviourModel;
import uw.cs.watform.forml.forml.BoolType;
import uw.cs.watform.forml.forml.Cardinality;
import uw.cs.watform.forml.forml.CompDecl;
import uw.cs.watform.forml.forml.Component;
import uw.cs.watform.forml.forml.Composition;
import uw.cs.watform.forml.forml.Concept;
import uw.cs.watform.forml.forml.Constraint;
import uw.cs.watform.forml.forml.Decl;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.EnumConst;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.FeatureNode;
import uw.cs.watform.forml.forml.FormlPackage;
import uw.cs.watform.forml.forml.Fragment;
import uw.cs.watform.forml.forml.FragmentType;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.InitState;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.InputList;
import uw.cs.watform.forml.forml.IntType;
import uw.cs.watform.forml.forml.Macro;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Multiplicity;
import uw.cs.watform.forml.forml.Node;
import uw.cs.watform.forml.forml.OrNode;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.OutputList;
import uw.cs.watform.forml.forml.Predicate;
import uw.cs.watform.forml.forml.Priority;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.Region;
import uw.cs.watform.forml.forml.RegionContext;
import uw.cs.watform.forml.forml.Relationship;
import uw.cs.watform.forml.forml.Role;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.SPL;
import uw.cs.watform.forml.forml.State;
import uw.cs.watform.forml.forml.StateContext;
import uw.cs.watform.forml.forml.StateMachine;
import uw.cs.watform.forml.forml.StateMachineContext;
import uw.cs.watform.forml.forml.StringType;
import uw.cs.watform.forml.forml.TranFragment;
import uw.cs.watform.forml.forml.TransList;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.UndefinedType;
import uw.cs.watform.forml.forml.Variable;
import uw.cs.watform.forml.forml.WCA;
import uw.cs.watform.forml.forml.WCAFragment;
import uw.cs.watform.forml.forml.WCAFragmentList;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.forml.WCE;
import uw.cs.watform.forml.forml.WorldModel;
import uw.cs.watform.forml.forml.XORNode;
import uw.cs.watform.forml.forml.andPred;
import uw.cs.watform.forml.forml.atomic;
import uw.cs.watform.forml.forml.basePred;
import uw.cs.watform.forml.forml.boolExpr;
import uw.cs.watform.forml.forml.impPred;
import uw.cs.watform.forml.forml.intBase;
import uw.cs.watform.forml.forml.intExpr;
import uw.cs.watform.forml.forml.multExpr;
import uw.cs.watform.forml.forml.notPred;
import uw.cs.watform.forml.forml.orPred;
import uw.cs.watform.forml.forml.predExpr;
import uw.cs.watform.forml.forml.predExpr2;
import uw.cs.watform.forml.forml.predExpr3;
import uw.cs.watform.forml.forml.setExpr;
import uw.cs.watform.forml.forml.setExpr2;
import uw.cs.watform.forml.forml.setExpr3;
import uw.cs.watform.forml.forml.setExprBase;
import uw.cs.watform.forml.forml.unspecified;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see uw.cs.watform.forml.forml.FormlPackage
 * @generated
 */
public class FormlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FormlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FormlPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FormlSwitch<Adapter> modelSwitch =
    new FormlSwitch<Adapter>()
    {
      @Override
      public Adapter caseSystem(uw.cs.watform.forml.forml.System object)
      {
        return createSystemAdapter();
      }
      @Override
      public Adapter caseWorldModel(WorldModel object)
      {
        return createWorldModelAdapter();
      }
      @Override
      public Adapter caseConstraint(Constraint object)
      {
        return createConstraintAdapter();
      }
      @Override
      public Adapter caseExprRef(ExprRef object)
      {
        return createExprRefAdapter();
      }
      @Override
      public Adapter caseConcept(Concept object)
      {
        return createConceptAdapter();
      }
      @Override
      public Adapter caseRoleable(Roleable object)
      {
        return createRoleableAdapter();
      }
      @Override
      public Adapter caseRelationship(Relationship object)
      {
        return createRelationshipAdapter();
      }
      @Override
      public Adapter caseAttributeType(AttributeType object)
      {
        return createAttributeTypeAdapter();
      }
      @Override
      public Adapter caseStringType(StringType object)
      {
        return createStringTypeAdapter();
      }
      @Override
      public Adapter caseIntType(IntType object)
      {
        return createIntTypeAdapter();
      }
      @Override
      public Adapter caseBoolType(BoolType object)
      {
        return createBoolTypeAdapter();
      }
      @Override
      public Adapter caseReferenceType(ReferenceType object)
      {
        return createReferenceTypeAdapter();
      }
      @Override
      public Adapter caseMultiplicity(Multiplicity object)
      {
        return createMultiplicityAdapter();
      }
      @Override
      public Adapter caseCardinality(Cardinality object)
      {
        return createCardinalityAdapter();
      }
      @Override
      public Adapter caseRole(Role object)
      {
        return createRoleAdapter();
      }
      @Override
      public Adapter caseDecl(Decl object)
      {
        return createDeclAdapter();
      }
      @Override
      public Adapter caseMessage(Message object)
      {
        return createMessageAdapter();
      }
      @Override
      public Adapter caseInputList(InputList object)
      {
        return createInputListAdapter();
      }
      @Override
      public Adapter caseOutputList(OutputList object)
      {
        return createOutputListAdapter();
      }
      @Override
      public Adapter caseRefMessage(RefMessage object)
      {
        return createRefMessageAdapter();
      }
      @Override
      public Adapter caseNode(Node object)
      {
        return createNodeAdapter();
      }
      @Override
      public Adapter caseBehaviourModel(BehaviourModel object)
      {
        return createBehaviourModelAdapter();
      }
      @Override
      public Adapter caseFeatureModule(FeatureModule object)
      {
        return createFeatureModuleAdapter();
      }
      @Override
      public Adapter caseStateMachine(StateMachine object)
      {
        return createStateMachineAdapter();
      }
      @Override
      public Adapter caseInitState(InitState object)
      {
        return createInitStateAdapter();
      }
      @Override
      public Adapter caseComponent(Component object)
      {
        return createComponentAdapter();
      }
      @Override
      public Adapter caseTransition(Transition object)
      {
        return createTransitionAdapter();
      }
      @Override
      public Adapter casePriority(Priority object)
      {
        return createPriorityAdapter();
      }
      @Override
      public Adapter caseTransList(TransList object)
      {
        return createTransListAdapter();
      }
      @Override
      public Adapter caseGuard(Guard object)
      {
        return createGuardAdapter();
      }
      @Override
      public Adapter caseTrigger(Trigger object)
      {
        return createTriggerAdapter();
      }
      @Override
      public Adapter caseOverride(uw.cs.watform.forml.forml.Override object)
      {
        return createOverrideAdapter();
      }
      @Override
      public Adapter caseWCE(WCE object)
      {
        return createWCEAdapter();
      }
      @Override
      public Adapter caseWCAList(WCAList object)
      {
        return createWCAListAdapter();
      }
      @Override
      public Adapter caseWCA(WCA object)
      {
        return createWCAAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseAssignList(AssignList object)
      {
        return createAssignListAdapter();
      }
      @Override
      public Adapter caseAssign(Assign object)
      {
        return createAssignAdapter();
      }
      @Override
      public Adapter caseMacro(Macro object)
      {
        return createMacroAdapter();
      }
      @Override
      public Adapter casePredicate(Predicate object)
      {
        return createPredicateAdapter();
      }
      @Override
      public Adapter casenotPred(notPred object)
      {
        return createnotPredAdapter();
      }
      @Override
      public Adapter caseandPred(andPred object)
      {
        return createandPredAdapter();
      }
      @Override
      public Adapter caseimpPred(impPred object)
      {
        return createimpPredAdapter();
      }
      @Override
      public Adapter caseorPred(orPred object)
      {
        return createorPredAdapter();
      }
      @Override
      public Adapter casebasePred(basePred object)
      {
        return createbasePredAdapter();
      }
      @Override
      public Adapter caseboolExpr(boolExpr object)
      {
        return createboolExprAdapter();
      }
      @Override
      public Adapter casepredExpr(predExpr object)
      {
        return createpredExprAdapter();
      }
      @Override
      public Adapter casepredExpr2(predExpr2 object)
      {
        return createpredExpr2Adapter();
      }
      @Override
      public Adapter casepredExpr3(predExpr3 object)
      {
        return createpredExpr3Adapter();
      }
      @Override
      public Adapter casesetExpr(setExpr object)
      {
        return createsetExprAdapter();
      }
      @Override
      public Adapter casesetExpr2(setExpr2 object)
      {
        return createsetExpr2Adapter();
      }
      @Override
      public Adapter casesetExpr3(setExpr3 object)
      {
        return createsetExpr3Adapter();
      }
      @Override
      public Adapter casesetExprBase(setExprBase object)
      {
        return createsetExprBaseAdapter();
      }
      @Override
      public Adapter caseintExpr(intExpr object)
      {
        return createintExprAdapter();
      }
      @Override
      public Adapter casemultExpr(multExpr object)
      {
        return createmultExprAdapter();
      }
      @Override
      public Adapter caseintBase(intBase object)
      {
        return createintBaseAdapter();
      }
      @Override
      public Adapter caseatomic(atomic object)
      {
        return createatomicAdapter();
      }
      @Override
      public Adapter caseunspecified(unspecified object)
      {
        return createunspecifiedAdapter();
      }
      @Override
      public Adapter caseFragment(Fragment object)
      {
        return createFragmentAdapter();
      }
      @Override
      public Adapter caseFragmentType(FragmentType object)
      {
        return createFragmentTypeAdapter();
      }
      @Override
      public Adapter caseStateContext(StateContext object)
      {
        return createStateContextAdapter();
      }
      @Override
      public Adapter caseRegionContext(RegionContext object)
      {
        return createRegionContextAdapter();
      }
      @Override
      public Adapter caseStateMachineContext(StateMachineContext object)
      {
        return createStateMachineContextAdapter();
      }
      @Override
      public Adapter caseTranFragment(TranFragment object)
      {
        return createTranFragmentAdapter();
      }
      @Override
      public Adapter caseWCAFragmentList(WCAFragmentList object)
      {
        return createWCAFragmentListAdapter();
      }
      @Override
      public Adapter caseWCAFragment(WCAFragment object)
      {
        return createWCAFragmentAdapter();
      }
      @Override
      public Adapter caseEntity(Entity object)
      {
        return createEntityAdapter();
      }
      @Override
      public Adapter caseAssociation(Association object)
      {
        return createAssociationAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseUndefinedType(UndefinedType object)
      {
        return createUndefinedTypeAdapter();
      }
      @Override
      public Adapter caseAggregation(Aggregation object)
      {
        return createAggregationAdapter();
      }
      @Override
      public Adapter caseComposition(Composition object)
      {
        return createCompositionAdapter();
      }
      @Override
      public Adapter caseCompDecl(CompDecl object)
      {
        return createCompDeclAdapter();
      }
      @Override
      public Adapter caseInput(Input object)
      {
        return createInputAdapter();
      }
      @Override
      public Adapter caseOutput(Output object)
      {
        return createOutputAdapter();
      }
      @Override
      public Adapter caseFeature(Feature object)
      {
        return createFeatureAdapter();
      }
      @Override
      public Adapter caseSPL(SPL object)
      {
        return createSPLAdapter();
      }
      @Override
      public Adapter caseXORNode(XORNode object)
      {
        return createXORNodeAdapter();
      }
      @Override
      public Adapter caseAndNode(AndNode object)
      {
        return createAndNodeAdapter();
      }
      @Override
      public Adapter caseOrNode(OrNode object)
      {
        return createOrNodeAdapter();
      }
      @Override
      public Adapter caseFeatureNode(FeatureNode object)
      {
        return createFeatureNodeAdapter();
      }
      @Override
      public Adapter caseEnumeration(Enumeration object)
      {
        return createEnumerationAdapter();
      }
      @Override
      public Adapter caseEnumConst(EnumConst object)
      {
        return createEnumConstAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseRegion(Region object)
      {
        return createRegionAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.System <em>System</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.System
   * @generated
   */
  public Adapter createSystemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.WorldModel <em>World Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.WorldModel
   * @generated
   */
  public Adapter createWorldModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Constraint
   * @generated
   */
  public Adapter createConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.ExprRef <em>Expr Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.ExprRef
   * @generated
   */
  public Adapter createExprRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Concept <em>Concept</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Concept
   * @generated
   */
  public Adapter createConceptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Roleable <em>Roleable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Roleable
   * @generated
   */
  public Adapter createRoleableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Relationship <em>Relationship</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Relationship
   * @generated
   */
  public Adapter createRelationshipAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.AttributeType <em>Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.AttributeType
   * @generated
   */
  public Adapter createAttributeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.StringType
   * @generated
   */
  public Adapter createStringTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.IntType
   * @generated
   */
  public Adapter createIntTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.BoolType <em>Bool Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.BoolType
   * @generated
   */
  public Adapter createBoolTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.ReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.ReferenceType
   * @generated
   */
  public Adapter createReferenceTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Multiplicity
   * @generated
   */
  public Adapter createMultiplicityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Cardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Cardinality
   * @generated
   */
  public Adapter createCardinalityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Role <em>Role</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Role
   * @generated
   */
  public Adapter createRoleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Decl
   * @generated
   */
  public Adapter createDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Message <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Message
   * @generated
   */
  public Adapter createMessageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.InputList <em>Input List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.InputList
   * @generated
   */
  public Adapter createInputListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.OutputList <em>Output List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.OutputList
   * @generated
   */
  public Adapter createOutputListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.RefMessage <em>Ref Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.RefMessage
   * @generated
   */
  public Adapter createRefMessageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Node
   * @generated
   */
  public Adapter createNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.BehaviourModel <em>Behaviour Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.BehaviourModel
   * @generated
   */
  public Adapter createBehaviourModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.FeatureModule <em>Feature Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.FeatureModule
   * @generated
   */
  public Adapter createFeatureModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.StateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.StateMachine
   * @generated
   */
  public Adapter createStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.InitState <em>Init State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.InitState
   * @generated
   */
  public Adapter createInitStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Component
   * @generated
   */
  public Adapter createComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Transition
   * @generated
   */
  public Adapter createTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Priority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Priority
   * @generated
   */
  public Adapter createPriorityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.TransList <em>Trans List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.TransList
   * @generated
   */
  public Adapter createTransListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Guard
   * @generated
   */
  public Adapter createGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Trigger
   * @generated
   */
  public Adapter createTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Override <em>Override</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Override
   * @generated
   */
  public Adapter createOverrideAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.WCE <em>WCE</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.WCE
   * @generated
   */
  public Adapter createWCEAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.WCAList <em>WCA List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.WCAList
   * @generated
   */
  public Adapter createWCAListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.WCA <em>WCA</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.WCA
   * @generated
   */
  public Adapter createWCAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.AssignList <em>Assign List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.AssignList
   * @generated
   */
  public Adapter createAssignListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Assign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Assign
   * @generated
   */
  public Adapter createAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Macro
   * @generated
   */
  public Adapter createMacroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Predicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Predicate
   * @generated
   */
  public Adapter createPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.notPred <em>not Pred</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.notPred
   * @generated
   */
  public Adapter createnotPredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.andPred <em>and Pred</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.andPred
   * @generated
   */
  public Adapter createandPredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.impPred <em>imp Pred</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.impPred
   * @generated
   */
  public Adapter createimpPredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.orPred <em>or Pred</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.orPred
   * @generated
   */
  public Adapter createorPredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.basePred <em>base Pred</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.basePred
   * @generated
   */
  public Adapter createbasePredAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.boolExpr <em>bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.boolExpr
   * @generated
   */
  public Adapter createboolExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.predExpr <em>pred Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.predExpr
   * @generated
   */
  public Adapter createpredExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.predExpr2 <em>pred Expr2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.predExpr2
   * @generated
   */
  public Adapter createpredExpr2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.predExpr3 <em>pred Expr3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.predExpr3
   * @generated
   */
  public Adapter createpredExpr3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.setExpr <em>set Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.setExpr
   * @generated
   */
  public Adapter createsetExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.setExpr2 <em>set Expr2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.setExpr2
   * @generated
   */
  public Adapter createsetExpr2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.setExpr3 <em>set Expr3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.setExpr3
   * @generated
   */
  public Adapter createsetExpr3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.setExprBase <em>set Expr Base</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.setExprBase
   * @generated
   */
  public Adapter createsetExprBaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.intExpr <em>int Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.intExpr
   * @generated
   */
  public Adapter createintExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.multExpr <em>mult Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.multExpr
   * @generated
   */
  public Adapter createmultExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.intBase <em>int Base</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.intBase
   * @generated
   */
  public Adapter createintBaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.atomic <em>atomic</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.atomic
   * @generated
   */
  public Adapter createatomicAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.unspecified <em>unspecified</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.unspecified
   * @generated
   */
  public Adapter createunspecifiedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Fragment <em>Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Fragment
   * @generated
   */
  public Adapter createFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.FragmentType <em>Fragment Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.FragmentType
   * @generated
   */
  public Adapter createFragmentTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.StateContext <em>State Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.StateContext
   * @generated
   */
  public Adapter createStateContextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.RegionContext <em>Region Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.RegionContext
   * @generated
   */
  public Adapter createRegionContextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.StateMachineContext <em>State Machine Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.StateMachineContext
   * @generated
   */
  public Adapter createStateMachineContextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.TranFragment <em>Tran Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.TranFragment
   * @generated
   */
  public Adapter createTranFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.WCAFragmentList <em>WCA Fragment List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.WCAFragmentList
   * @generated
   */
  public Adapter createWCAFragmentListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.WCAFragment <em>WCA Fragment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.WCAFragment
   * @generated
   */
  public Adapter createWCAFragmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Entity
   * @generated
   */
  public Adapter createEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Association
   * @generated
   */
  public Adapter createAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.UndefinedType <em>Undefined Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.UndefinedType
   * @generated
   */
  public Adapter createUndefinedTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Aggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Aggregation
   * @generated
   */
  public Adapter createAggregationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Composition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Composition
   * @generated
   */
  public Adapter createCompositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.CompDecl <em>Comp Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.CompDecl
   * @generated
   */
  public Adapter createCompDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Input <em>Input</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Input
   * @generated
   */
  public Adapter createInputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Output <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Output
   * @generated
   */
  public Adapter createOutputAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Feature
   * @generated
   */
  public Adapter createFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.SPL <em>SPL</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.SPL
   * @generated
   */
  public Adapter createSPLAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.XORNode <em>XOR Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.XORNode
   * @generated
   */
  public Adapter createXORNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.AndNode <em>And Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.AndNode
   * @generated
   */
  public Adapter createAndNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.OrNode <em>Or Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.OrNode
   * @generated
   */
  public Adapter createOrNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.FeatureNode <em>Feature Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.FeatureNode
   * @generated
   */
  public Adapter createFeatureNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Enumeration
   * @generated
   */
  public Adapter createEnumerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.EnumConst <em>Enum Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.EnumConst
   * @generated
   */
  public Adapter createEnumConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Region <em>Region</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Region
   * @generated
   */
  public Adapter createRegionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link uw.cs.watform.forml.forml.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see uw.cs.watform.forml.forml.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //FormlAdapterFactory
