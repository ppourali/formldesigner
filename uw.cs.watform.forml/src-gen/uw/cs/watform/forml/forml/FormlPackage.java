/**
 */
package uw.cs.watform.forml.forml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see uw.cs.watform.forml.forml.FormlFactory
 * @model kind="package"
 * @generated
 */
public interface FormlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "forml";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.cs.uw/watform/forml/Forml";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "forml";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FormlPackage eINSTANCE = uw.cs.watform.forml.forml.impl.FormlPackageImpl.init();

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.SystemImpl <em>System</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.SystemImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getSystem()
   * @generated
   */
  int SYSTEM = 0;

  /**
   * The feature id for the '<em><b>Worldmodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM__WORLDMODEL = 0;

  /**
   * The feature id for the '<em><b>Behaviourmodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM__BEHAVIOURMODEL = 1;

  /**
   * The number of structural features of the '<em>System</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.WorldModelImpl <em>World Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.WorldModelImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWorldModel()
   * @generated
   */
  int WORLD_MODEL = 1;

  /**
   * The feature id for the '<em><b>Concepts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORLD_MODEL__CONCEPTS = 0;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORLD_MODEL__CONSTRAINTS = 1;

  /**
   * The number of structural features of the '<em>World Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORLD_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.ConstraintImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 2;

  /**
   * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__PREDICATES = 0;

  /**
   * The feature id for the '<em><b>Macro</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__MACRO = 1;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.ExprRefImpl <em>Expr Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.ExprRefImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getExprRef()
   * @generated
   */
  int EXPR_REF = 3;

  /**
   * The number of structural features of the '<em>Expr Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.ConceptImpl <em>Concept</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.ConceptImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getConcept()
   * @generated
   */
  int CONCEPT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCEPT__NAME = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Concept</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCEPT_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.RoleableImpl <em>Roleable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.RoleableImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRoleable()
   * @generated
   */
  int ROLEABLE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLEABLE__NAME = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLEABLE__ATTRIBUTES = EXPR_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Roleable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLEABLE_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.RelationshipImpl <em>Relationship</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.RelationshipImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRelationship()
   * @generated
   */
  int RELATIONSHIP = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP__NAME = CONCEPT__NAME;

  /**
   * The feature id for the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP__CTRL = CONCEPT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Relationship</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AttributeTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAttributeType()
   * @generated
   */
  int ATTRIBUTE_TYPE = 7;

  /**
   * The number of structural features of the '<em>Attribute Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.StringTypeImpl <em>String Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.StringTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStringType()
   * @generated
   */
  int STRING_TYPE = 8;

  /**
   * The number of structural features of the '<em>String Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.IntTypeImpl <em>Int Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.IntTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getIntType()
   * @generated
   */
  int INT_TYPE = 9;

  /**
   * The number of structural features of the '<em>Int Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.BoolTypeImpl <em>Bool Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.BoolTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getBoolType()
   * @generated
   */
  int BOOL_TYPE = 10;

  /**
   * The number of structural features of the '<em>Bool Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.ReferenceTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getReferenceType()
   * @generated
   */
  int REFERENCE_TYPE = 11;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE__REF = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.MultiplicityImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getMultiplicity()
   * @generated
   */
  int MULTIPLICITY = 12;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__VALUE = 0;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__MANY = 1;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__CARDINALITY = 2;

  /**
   * The number of structural features of the '<em>Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.CardinalityImpl <em>Cardinality</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.CardinalityImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getCardinality()
   * @generated
   */
  int CARDINALITY = 13;

  /**
   * The feature id for the '<em><b>Lower</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY__LOWER = 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY__UPPER = 1;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY__MANY = 2;

  /**
   * The number of structural features of the '<em>Cardinality</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.RoleImpl <em>Role</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.RoleImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRole()
   * @generated
   */
  int ROLE = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE__MULTIPLICITY = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE__TYPE = 2;

  /**
   * The number of structural features of the '<em>Role</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.DeclImpl <em>Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.DeclImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getDecl()
   * @generated
   */
  int DECL = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL__MULTIPLICITY = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL__TYPE = 2;

  /**
   * The number of structural features of the '<em>Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.MessageImpl <em>Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.MessageImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getMessage()
   * @generated
   */
  int MESSAGE = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__NAME = CONCEPT__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__TYPE = CONCEPT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE__ATTRIBUTES = CONCEPT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.InputListImpl <em>Input List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.InputListImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getInputList()
   * @generated
   */
  int INPUT_LIST = 17;

  /**
   * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_LIST__INPUTS = 0;

  /**
   * The number of structural features of the '<em>Input List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.OutputListImpl <em>Output List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.OutputListImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOutputList()
   * @generated
   */
  int OUTPUT_LIST = 18;

  /**
   * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_LIST__OUTPUTS = 0;

  /**
   * The number of structural features of the '<em>Output List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.RefMessageImpl <em>Ref Message</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.RefMessageImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRefMessage()
   * @generated
   */
  int REF_MESSAGE = 19;

  /**
   * The feature id for the '<em><b>Ref Msg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_MESSAGE__REF_MSG = 0;

  /**
   * The number of structural features of the '<em>Ref Message</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_MESSAGE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.NodeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getNode()
   * @generated
   */
  int NODE = 20;

  /**
   * The feature id for the '<em><b>Feature Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__FEATURE_NODES = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.BehaviourModelImpl <em>Behaviour Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.BehaviourModelImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getBehaviourModel()
   * @generated
   */
  int BEHAVIOUR_MODEL = 21;

  /**
   * The feature id for the '<em><b>Featuremodules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOUR_MODEL__FEATUREMODULES = 0;

  /**
   * The number of structural features of the '<em>Behaviour Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOUR_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.FeatureModuleImpl <em>Feature Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.FeatureModuleImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFeatureModule()
   * @generated
   */
  int FEATURE_MODULE = 22;

  /**
   * The feature id for the '<em><b>Featureref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODULE__FEATUREREF = 0;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODULE__CONSTRAINTS = 1;

  /**
   * The feature id for the '<em><b>Statemachine</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODULE__STATEMACHINE = 2;

  /**
   * The feature id for the '<em><b>Fragments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODULE__FRAGMENTS = 3;

  /**
   * The number of structural features of the '<em>Feature Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODULE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.StateMachineImpl <em>State Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.StateMachineImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStateMachine()
   * @generated
   */
  int STATE_MACHINE = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__NAME = 0;

  /**
   * The feature id for the '<em><b>Regions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__REGIONS = 1;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__TRANSITIONS = 2;

  /**
   * The number of structural features of the '<em>State Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.InitStateImpl <em>Init State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.InitStateImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getInitState()
   * @generated
   */
  int INIT_STATE = 24;

  /**
   * The feature id for the '<em><b>Stateref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_STATE__STATEREF = 0;

  /**
   * The number of structural features of the '<em>Init State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_STATE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.ComponentImpl <em>Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.ComponentImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getComponent()
   * @generated
   */
  int COMPONENT = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.TransitionImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__PRIORITY = 1;

  /**
   * The feature id for the '<em><b>Src</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__SRC = 2;

  /**
   * The feature id for the '<em><b>Dst</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__DST = 3;

  /**
   * The feature id for the '<em><b>Trig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__TRIG = 4;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__GUARD = 5;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__LIST = 6;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.PriorityImpl <em>Priority</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.PriorityImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getPriority()
   * @generated
   */
  int PRIORITY = 27;

  /**
   * The feature id for the '<em><b>Translist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY__TRANSLIST = 0;

  /**
   * The number of structural features of the '<em>Priority</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIORITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.TransListImpl <em>Trans List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.TransListImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTransList()
   * @generated
   */
  int TRANS_LIST = 28;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANS_LIST__TRANSITIONS = 0;

  /**
   * The number of structural features of the '<em>Trans List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANS_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.GuardImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 29;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__PREDICATE = 0;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.TriggerImpl <em>Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.TriggerImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTrigger()
   * @generated
   */
  int TRIGGER = 30;

  /**
   * The feature id for the '<em><b>Override</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__OVERRIDE = 0;

  /**
   * The feature id for the '<em><b>Wce</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__WCE = 1;

  /**
   * The number of structural features of the '<em>Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.OverrideImpl <em>Override</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.OverrideImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOverride()
   * @generated
   */
  int OVERRIDE = 31;

  /**
   * The feature id for the '<em><b>Transition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDE__TRANSITION = 0;

  /**
   * The number of structural features of the '<em>Override</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OVERRIDE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.WCEImpl <em>WCE</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.WCEImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCE()
   * @generated
   */
  int WCE = 32;

  /**
   * The feature id for the '<em><b>Addobj</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCE__ADDOBJ = 0;

  /**
   * The feature id for the '<em><b>Attr</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCE__ATTR = 1;

  /**
   * The feature id for the '<em><b>Remobj</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCE__REMOBJ = 2;

  /**
   * The number of structural features of the '<em>WCE</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.WCAListImpl <em>WCA List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.WCAListImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCAList()
   * @generated
   */
  int WCA_LIST = 33;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_LIST__ACTIONS = 0;

  /**
   * The number of structural features of the '<em>WCA List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.WCAImpl <em>WCA</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.WCAImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCA()
   * @generated
   */
  int WCA = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA__NAME = 0;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA__ACTION = 1;

  /**
   * The number of structural features of the '<em>WCA</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.ActionImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAction()
   * @generated
   */
  int ACTION = 35;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Out</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__OUT = 1;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__LIST = 2;

  /**
   * The feature id for the '<em><b>Minexpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__MINEXPR = 3;

  /**
   * The feature id for the '<em><b>Lvalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__LVALUE = 4;

  /**
   * The feature id for the '<em><b>Rvalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__RVALUE = 5;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AssignListImpl <em>Assign List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AssignListImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAssignList()
   * @generated
   */
  int ASSIGN_LIST = 36;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_LIST__LIST = 0;

  /**
   * The number of structural features of the '<em>Assign List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AssignImpl <em>Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AssignImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAssign()
   * @generated
   */
  int ASSIGN = 37;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN__REF = 0;

  /**
   * The feature id for the '<em><b>Sexpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN__SEXPR = 1;

  /**
   * The number of structural features of the '<em>Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGN_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.MacroImpl <em>Macro</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.MacroImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getMacro()
   * @generated
   */
  int MACRO = 38;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__NAME = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO__EXPR = 1;

  /**
   * The number of structural features of the '<em>Macro</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.PredicateImpl <em>Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.PredicateImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getPredicate()
   * @generated
   */
  int PREDICATE = 39;

  /**
   * The feature id for the '<em><b>Logicop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE__LOGICOP = 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE__VAR = 1;

  /**
   * The feature id for the '<em><b>Sexpr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE__SEXPR = 2;

  /**
   * The feature id for the '<em><b>Quant Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE__QUANT_PRED = 3;

  /**
   * The number of structural features of the '<em>Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.notPredImpl <em>not Pred</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.notPredImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getnotPred()
   * @generated
   */
  int NOT_PRED = 40;

  /**
   * The feature id for the '<em><b>Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_PRED__PRED = 0;

  /**
   * The number of structural features of the '<em>not Pred</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_PRED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.andPredImpl <em>and Pred</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.andPredImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getandPred()
   * @generated
   */
  int AND_PRED = 41;

  /**
   * The feature id for the '<em><b>Preds</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_PRED__PREDS = 0;

  /**
   * The number of structural features of the '<em>and Pred</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_PRED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.impPredImpl <em>imp Pred</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.impPredImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getimpPred()
   * @generated
   */
  int IMP_PRED = 42;

  /**
   * The feature id for the '<em><b>Preds</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMP_PRED__PREDS = 0;

  /**
   * The feature id for the '<em><b>Logicop</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMP_PRED__LOGICOP = 1;

  /**
   * The number of structural features of the '<em>imp Pred</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMP_PRED_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.orPredImpl <em>or Pred</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.orPredImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getorPred()
   * @generated
   */
  int OR_PRED = 43;

  /**
   * The feature id for the '<em><b>Preds</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_PRED__PREDS = 0;

  /**
   * The number of structural features of the '<em>or Pred</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_PRED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.basePredImpl <em>base Pred</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.basePredImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getbasePred()
   * @generated
   */
  int BASE_PRED = 44;

  /**
   * The feature id for the '<em><b>Logicop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__LOGICOP = 0;

  /**
   * The feature id for the '<em><b>Cardpred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__CARDPRED = 1;

  /**
   * The feature id for the '<em><b>Setlhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__SETLHS = 2;

  /**
   * The feature id for the '<em><b>Setrhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__SETRHS = 3;

  /**
   * The feature id for the '<em><b>Boolrhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__BOOLRHS = 4;

  /**
   * The feature id for the '<em><b>Intlhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__INTLHS = 5;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__OP = 6;

  /**
   * The feature id for the '<em><b>Intrhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__INTRHS = 7;

  /**
   * The feature id for the '<em><b>Paren Pred</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED__PAREN_PRED = 8;

  /**
   * The number of structural features of the '<em>base Pred</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_PRED_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.boolExprImpl <em>bool Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.boolExprImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getboolExpr()
   * @generated
   */
  int BOOL_EXPR = 45;

  /**
   * The feature id for the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__IS_TRUE = 0;

  /**
   * The feature id for the '<em><b>Is False</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__IS_FALSE = 1;

  /**
   * The number of structural features of the '<em>bool Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.predExprImpl <em>pred Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.predExprImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getpredExpr()
   * @generated
   */
  int PRED_EXPR = 46;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR__EXPR = 0;

  /**
   * The number of structural features of the '<em>pred Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.predExpr2Impl <em>pred Expr2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.predExpr2Impl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getpredExpr2()
   * @generated
   */
  int PRED_EXPR2 = 47;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR2__EXPR = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR2__OP = 1;

  /**
   * The number of structural features of the '<em>pred Expr2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR2_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.predExpr3Impl <em>pred Expr3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.predExpr3Impl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getpredExpr3()
   * @generated
   */
  int PRED_EXPR3 = 48;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR3__BASE = 0;

  /**
   * The number of structural features of the '<em>pred Expr3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRED_EXPR3_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.setExprImpl <em>set Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.setExprImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExpr()
   * @generated
   */
  int SET_EXPR = 49;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR__EXPR = 0;

  /**
   * The number of structural features of the '<em>set Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.setExpr2Impl <em>set Expr2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.setExpr2Impl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExpr2()
   * @generated
   */
  int SET_EXPR2 = 50;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR2__EXPR = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR2__OP = 1;

  /**
   * The number of structural features of the '<em>set Expr2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR2_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.setExpr3Impl <em>set Expr3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.setExpr3Impl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExpr3()
   * @generated
   */
  int SET_EXPR3 = 51;

  /**
   * The feature id for the '<em><b>Paren</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR3__PAREN = 0;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR3__BASE = 1;

  /**
   * The number of structural features of the '<em>set Expr3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR3_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.setExprBaseImpl <em>set Expr Base</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.setExprBaseImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExprBase()
   * @generated
   */
  int SET_EXPR_BASE = 52;

  /**
   * The feature id for the '<em><b>Atom</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR_BASE__ATOM = 0;

  /**
   * The feature id for the '<em><b>Unspec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR_BASE__UNSPEC = 1;

  /**
   * The number of structural features of the '<em>set Expr Base</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR_BASE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.intExprImpl <em>int Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.intExprImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getintExpr()
   * @generated
   */
  int INT_EXPR = 53;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>int Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.multExprImpl <em>mult Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.multExprImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getmultExpr()
   * @generated
   */
  int MULT_EXPR = 54;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR__LHS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR__OP = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR__RHS = 2;

  /**
   * The number of structural features of the '<em>mult Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULT_EXPR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.intBaseImpl <em>int Base</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.intBaseImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getintBase()
   * @generated
   */
  int INT_BASE = 55;

  /**
   * The feature id for the '<em><b>Atom</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_BASE__ATOM = 0;

  /**
   * The feature id for the '<em><b>Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_BASE__NUM = 1;

  /**
   * The number of structural features of the '<em>int Base</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_BASE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.atomicImpl <em>atomic</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.atomicImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getatomic()
   * @generated
   */
  int ATOMIC = 56;

  /**
   * The feature id for the '<em><b>None</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC__NONE = 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC__REF = 1;

  /**
   * The feature id for the '<em><b>Refs</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC__REFS = 2;

  /**
   * The number of structural features of the '<em>atomic</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.unspecifiedImpl <em>unspecified</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.unspecifiedImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getunspecified()
   * @generated
   */
  int UNSPECIFIED = 57;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSPECIFIED__REF = 0;

  /**
   * The number of structural features of the '<em>unspecified</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNSPECIFIED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.FragmentImpl <em>Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.FragmentImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFragment()
   * @generated
   */
  int FRAGMENT = 58;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Fragment Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT__FRAGMENT_TYPE = 1;

  /**
   * The number of structural features of the '<em>Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl <em>Fragment Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.FragmentTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFragmentType()
   * @generated
   */
  int FRAGMENT_TYPE = 59;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_TYPE__STATE = 0;

  /**
   * The feature id for the '<em><b>Region</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_TYPE__REGION = 1;

  /**
   * The feature id for the '<em><b>Frag</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_TYPE__FRAG = 2;

  /**
   * The feature id for the '<em><b>Statemachine</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_TYPE__STATEMACHINE = 3;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_TYPE__TRANSITIONS = 4;

  /**
   * The number of structural features of the '<em>Fragment Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FRAGMENT_TYPE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.StateContextImpl <em>State Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.StateContextImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStateContext()
   * @generated
   */
  int STATE_CONTEXT = 60;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_CONTEXT__REF = 0;

  /**
   * The feature id for the '<em><b>Regions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_CONTEXT__REGIONS = 1;

  /**
   * The number of structural features of the '<em>State Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_CONTEXT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.RegionContextImpl <em>Region Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.RegionContextImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRegionContext()
   * @generated
   */
  int REGION_CONTEXT = 61;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION_CONTEXT__REF = 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION_CONTEXT__STATES = 1;

  /**
   * The number of structural features of the '<em>Region Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION_CONTEXT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.StateMachineContextImpl <em>State Machine Context</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.StateMachineContextImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStateMachineContext()
   * @generated
   */
  int STATE_MACHINE_CONTEXT = 62;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_CONTEXT__REF = 0;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_CONTEXT__STATE = 1;

  /**
   * The number of structural features of the '<em>State Machine Context</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_CONTEXT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl <em>Tran Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.TranFragmentImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTranFragment()
   * @generated
   */
  int TRAN_FRAGMENT = 63;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRAN_FRAGMENT__REF = 0;

  /**
   * The feature id for the '<em><b>Trig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRAN_FRAGMENT__TRIG = 1;

  /**
   * The feature id for the '<em><b>Frag Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRAN_FRAGMENT__FRAG_TYPE = 2;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRAN_FRAGMENT__LIST = 3;

  /**
   * The feature id for the '<em><b>Frag List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRAN_FRAGMENT__FRAG_LIST = 4;

  /**
   * The number of structural features of the '<em>Tran Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRAN_FRAGMENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.WCAFragmentListImpl <em>WCA Fragment List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.WCAFragmentListImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCAFragmentList()
   * @generated
   */
  int WCA_FRAGMENT_LIST = 64;

  /**
   * The feature id for the '<em><b>Frag</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_FRAGMENT_LIST__FRAG = 0;

  /**
   * The number of structural features of the '<em>WCA Fragment List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_FRAGMENT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.WCAFragmentImpl <em>WCA Fragment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.WCAFragmentImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCAFragment()
   * @generated
   */
  int WCA_FRAGMENT = 65;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_FRAGMENT__REF = 0;

  /**
   * The feature id for the '<em><b>Frag Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_FRAGMENT__FRAG_TYPE = 1;

  /**
   * The number of structural features of the '<em>WCA Fragment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WCA_FRAGMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.EntityImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 66;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = ROLEABLE__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__ATTRIBUTES = ROLEABLE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__CTRL = ROLEABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__SUPER_TYPE = ROLEABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__FUNCTIONS = ROLEABLE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = ROLEABLE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AssociationImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAssociation()
   * @generated
   */
  int ASSOCIATION = 67;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__NAME = RELATIONSHIP__NAME;

  /**
   * The feature id for the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__CTRL = RELATIONSHIP__CTRL;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__ATTRIBUTES = RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Src Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__SRC_ROLE = RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Des Role</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__DES_ROLE = RELATIONSHIP_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AttributeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 68;

  /**
   * The feature id for the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__CTRL = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = EXPR_REF_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__MULTIPLICITY = EXPR_REF_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = EXPR_REF_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.FunctionImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 69;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__TYPE = EXPR_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.UndefinedTypeImpl <em>Undefined Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.UndefinedTypeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getUndefinedType()
   * @generated
   */
  int UNDEFINED_TYPE = 70;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEFINED_TYPE__NAME = CONCEPT__NAME;

  /**
   * The number of structural features of the '<em>Undefined Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNDEFINED_TYPE_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AggregationImpl <em>Aggregation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AggregationImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAggregation()
   * @generated
   */
  int AGGREGATION = 71;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION__NAME = RELATIONSHIP__NAME;

  /**
   * The feature id for the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION__CTRL = RELATIONSHIP__CTRL;

  /**
   * The feature id for the '<em><b>Whole</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION__WHOLE = RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION__PART = RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Aggregation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.CompositionImpl <em>Composition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.CompositionImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getComposition()
   * @generated
   */
  int COMPOSITION = 72;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__NAME = RELATIONSHIP__NAME;

  /**
   * The feature id for the '<em><b>Ctrl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__CTRL = RELATIONSHIP__CTRL;

  /**
   * The feature id for the '<em><b>Whole</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__WHOLE = RELATIONSHIP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Part</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION__PART = RELATIONSHIP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Composition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITION_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.CompDeclImpl <em>Comp Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.CompDeclImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getCompDecl()
   * @generated
   */
  int COMP_DECL = 73;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMP_DECL__NAME = DECL__NAME;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMP_DECL__MULTIPLICITY = DECL__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMP_DECL__TYPE = DECL__TYPE;

  /**
   * The number of structural features of the '<em>Comp Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMP_DECL_FEATURE_COUNT = DECL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.InputImpl <em>Input</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.InputImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getInput()
   * @generated
   */
  int INPUT = 74;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT__NAME = MESSAGE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT__TYPE = MESSAGE__TYPE;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT__ATTRIBUTES = MESSAGE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Tos</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT__TOS = MESSAGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Input</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.OutputImpl <em>Output</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.OutputImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOutput()
   * @generated
   */
  int OUTPUT = 75;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT__NAME = MESSAGE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT__TYPE = MESSAGE__TYPE;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT__ATTRIBUTES = MESSAGE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Froms</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT__FROMS = MESSAGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Output</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.FeatureImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 76;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = ROLEABLE__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__ATTRIBUTES = ROLEABLE__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Inputlist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__INPUTLIST = ROLEABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outputlist</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__OUTPUTLIST = ROLEABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = ROLEABLE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.SPLImpl <em>SPL</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.SPLImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getSPL()
   * @generated
   */
  int SPL = 77;

  /**
   * The feature id for the '<em><b>Feature Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPL__FEATURE_NODES = NODE__FEATURE_NODES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPL__NAME = NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Xors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPL__XORS = NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPL__ANDS = NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Ors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPL__ORS = NODE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>SPL</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPL_FEATURE_COUNT = NODE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.XORNodeImpl <em>XOR Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.XORNodeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getXORNode()
   * @generated
   */
  int XOR_NODE = 78;

  /**
   * The feature id for the '<em><b>Feature Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_NODE__FEATURE_NODES = NODE__FEATURE_NODES;

  /**
   * The number of structural features of the '<em>XOR Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.AndNodeImpl <em>And Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.AndNodeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAndNode()
   * @generated
   */
  int AND_NODE = 79;

  /**
   * The feature id for the '<em><b>Feature Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_NODE__FEATURE_NODES = NODE__FEATURE_NODES;

  /**
   * The number of structural features of the '<em>And Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.OrNodeImpl <em>Or Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.OrNodeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOrNode()
   * @generated
   */
  int OR_NODE = 80;

  /**
   * The feature id for the '<em><b>Feature Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_NODE__FEATURE_NODES = NODE__FEATURE_NODES;

  /**
   * The number of structural features of the '<em>Or Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl <em>Feature Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.FeatureNodeImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFeatureNode()
   * @generated
   */
  int FEATURE_NODE = 81;

  /**
   * The feature id for the '<em><b>Feature Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE__FEATURE_NODES = NODE__FEATURE_NODES;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE__FEATURE = NODE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE__MULTIPLICITY = NODE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Xors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE__XORS = NODE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Ands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE__ANDS = NODE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Ors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE__ORS = NODE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Feature Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.EnumerationImpl <em>Enumeration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.EnumerationImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getEnumeration()
   * @generated
   */
  int ENUMERATION = 82;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__NAME = CONCEPT__NAME;

  /**
   * The feature id for the '<em><b>Constant</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION__CONSTANT = CONCEPT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enumeration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_FEATURE_COUNT = CONCEPT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.EnumConstImpl <em>Enum Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.EnumConstImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getEnumConst()
   * @generated
   */
  int ENUM_CONST = 83;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONST__NAME = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_CONST_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.StateImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getState()
   * @generated
   */
  int STATE = 84;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__NAME = COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Regions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__REGIONS = COMPONENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.RegionImpl <em>Region</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.RegionImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRegion()
   * @generated
   */
  int REGION = 85;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION__NAME = COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION__INIT = COMPONENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION__STATES = COMPONENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Region</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGION_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link uw.cs.watform.forml.forml.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see uw.cs.watform.forml.forml.impl.VariableImpl
   * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 86;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = EXPR_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = EXPR_REF_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.System <em>System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System</em>'.
   * @see uw.cs.watform.forml.forml.System
   * @generated
   */
  EClass getSystem();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.System#getWorldmodel <em>Worldmodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Worldmodel</em>'.
   * @see uw.cs.watform.forml.forml.System#getWorldmodel()
   * @see #getSystem()
   * @generated
   */
  EReference getSystem_Worldmodel();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.System#getBehaviourmodel <em>Behaviourmodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Behaviourmodel</em>'.
   * @see uw.cs.watform.forml.forml.System#getBehaviourmodel()
   * @see #getSystem()
   * @generated
   */
  EReference getSystem_Behaviourmodel();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.WorldModel <em>World Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>World Model</em>'.
   * @see uw.cs.watform.forml.forml.WorldModel
   * @generated
   */
  EClass getWorldModel();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.WorldModel#getConcepts <em>Concepts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Concepts</em>'.
   * @see uw.cs.watform.forml.forml.WorldModel#getConcepts()
   * @see #getWorldModel()
   * @generated
   */
  EReference getWorldModel_Concepts();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.WorldModel#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraints</em>'.
   * @see uw.cs.watform.forml.forml.WorldModel#getConstraints()
   * @see #getWorldModel()
   * @generated
   */
  EReference getWorldModel_Constraints();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see uw.cs.watform.forml.forml.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Constraint#getPredicates <em>Predicates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Predicates</em>'.
   * @see uw.cs.watform.forml.forml.Constraint#getPredicates()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Predicates();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Constraint#getMacro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Macro</em>'.
   * @see uw.cs.watform.forml.forml.Constraint#getMacro()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Macro();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.ExprRef <em>Expr Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Ref</em>'.
   * @see uw.cs.watform.forml.forml.ExprRef
   * @generated
   */
  EClass getExprRef();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Concept <em>Concept</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concept</em>'.
   * @see uw.cs.watform.forml.forml.Concept
   * @generated
   */
  EClass getConcept();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Concept#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Concept#getName()
   * @see #getConcept()
   * @generated
   */
  EAttribute getConcept_Name();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Roleable <em>Roleable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Roleable</em>'.
   * @see uw.cs.watform.forml.forml.Roleable
   * @generated
   */
  EClass getRoleable();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Roleable#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see uw.cs.watform.forml.forml.Roleable#getAttributes()
   * @see #getRoleable()
   * @generated
   */
  EReference getRoleable_Attributes();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Relationship <em>Relationship</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship</em>'.
   * @see uw.cs.watform.forml.forml.Relationship
   * @generated
   */
  EClass getRelationship();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Relationship#isCtrl <em>Ctrl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ctrl</em>'.
   * @see uw.cs.watform.forml.forml.Relationship#isCtrl()
   * @see #getRelationship()
   * @generated
   */
  EAttribute getRelationship_Ctrl();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.AttributeType <em>Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Type</em>'.
   * @see uw.cs.watform.forml.forml.AttributeType
   * @generated
   */
  EClass getAttributeType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type</em>'.
   * @see uw.cs.watform.forml.forml.StringType
   * @generated
   */
  EClass getStringType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.IntType <em>Int Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Type</em>'.
   * @see uw.cs.watform.forml.forml.IntType
   * @generated
   */
  EClass getIntType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.BoolType <em>Bool Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Type</em>'.
   * @see uw.cs.watform.forml.forml.BoolType
   * @generated
   */
  EClass getBoolType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.ReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Type</em>'.
   * @see uw.cs.watform.forml.forml.ReferenceType
   * @generated
   */
  EClass getReferenceType();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.ReferenceType#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.ReferenceType#getRef()
   * @see #getReferenceType()
   * @generated
   */
  EReference getReferenceType_Ref();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Multiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity</em>'.
   * @see uw.cs.watform.forml.forml.Multiplicity
   * @generated
   */
  EClass getMultiplicity();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Multiplicity#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see uw.cs.watform.forml.forml.Multiplicity#getValue()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Value();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Multiplicity#getMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see uw.cs.watform.forml.forml.Multiplicity#getMany()
   * @see #getMultiplicity()
   * @generated
   */
  EAttribute getMultiplicity_Many();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Multiplicity#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cardinality</em>'.
   * @see uw.cs.watform.forml.forml.Multiplicity#getCardinality()
   * @see #getMultiplicity()
   * @generated
   */
  EReference getMultiplicity_Cardinality();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Cardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cardinality</em>'.
   * @see uw.cs.watform.forml.forml.Cardinality
   * @generated
   */
  EClass getCardinality();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Cardinality#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower</em>'.
   * @see uw.cs.watform.forml.forml.Cardinality#getLower()
   * @see #getCardinality()
   * @generated
   */
  EAttribute getCardinality_Lower();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Cardinality#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper</em>'.
   * @see uw.cs.watform.forml.forml.Cardinality#getUpper()
   * @see #getCardinality()
   * @generated
   */
  EAttribute getCardinality_Upper();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Cardinality#getMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see uw.cs.watform.forml.forml.Cardinality#getMany()
   * @see #getCardinality()
   * @generated
   */
  EAttribute getCardinality_Many();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Role <em>Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role</em>'.
   * @see uw.cs.watform.forml.forml.Role
   * @generated
   */
  EClass getRole();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Role#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Role#getName()
   * @see #getRole()
   * @generated
   */
  EAttribute getRole_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Role#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see uw.cs.watform.forml.forml.Role#getMultiplicity()
   * @see #getRole()
   * @generated
   */
  EReference getRole_Multiplicity();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Role#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see uw.cs.watform.forml.forml.Role#getType()
   * @see #getRole()
   * @generated
   */
  EReference getRole_Type();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Decl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decl</em>'.
   * @see uw.cs.watform.forml.forml.Decl
   * @generated
   */
  EClass getDecl();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Decl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Decl#getName()
   * @see #getDecl()
   * @generated
   */
  EAttribute getDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Decl#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see uw.cs.watform.forml.forml.Decl#getMultiplicity()
   * @see #getDecl()
   * @generated
   */
  EReference getDecl_Multiplicity();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Decl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see uw.cs.watform.forml.forml.Decl#getType()
   * @see #getDecl()
   * @generated
   */
  EReference getDecl_Type();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Message <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message</em>'.
   * @see uw.cs.watform.forml.forml.Message
   * @generated
   */
  EClass getMessage();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Message#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see uw.cs.watform.forml.forml.Message#getType()
   * @see #getMessage()
   * @generated
   */
  EReference getMessage_Type();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Message#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see uw.cs.watform.forml.forml.Message#getAttributes()
   * @see #getMessage()
   * @generated
   */
  EReference getMessage_Attributes();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.InputList <em>Input List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input List</em>'.
   * @see uw.cs.watform.forml.forml.InputList
   * @generated
   */
  EClass getInputList();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.InputList#getInputs <em>Inputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inputs</em>'.
   * @see uw.cs.watform.forml.forml.InputList#getInputs()
   * @see #getInputList()
   * @generated
   */
  EReference getInputList_Inputs();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.OutputList <em>Output List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output List</em>'.
   * @see uw.cs.watform.forml.forml.OutputList
   * @generated
   */
  EClass getOutputList();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.OutputList#getOutputs <em>Outputs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outputs</em>'.
   * @see uw.cs.watform.forml.forml.OutputList#getOutputs()
   * @see #getOutputList()
   * @generated
   */
  EReference getOutputList_Outputs();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.RefMessage <em>Ref Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Message</em>'.
   * @see uw.cs.watform.forml.forml.RefMessage
   * @generated
   */
  EClass getRefMessage();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.RefMessage#getRefMsg <em>Ref Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref Msg</em>'.
   * @see uw.cs.watform.forml.forml.RefMessage#getRefMsg()
   * @see #getRefMessage()
   * @generated
   */
  EReference getRefMessage_RefMsg();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see uw.cs.watform.forml.forml.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Node#getFeatureNodes <em>Feature Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Feature Nodes</em>'.
   * @see uw.cs.watform.forml.forml.Node#getFeatureNodes()
   * @see #getNode()
   * @generated
   */
  EReference getNode_FeatureNodes();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.BehaviourModel <em>Behaviour Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behaviour Model</em>'.
   * @see uw.cs.watform.forml.forml.BehaviourModel
   * @generated
   */
  EClass getBehaviourModel();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.BehaviourModel#getFeaturemodules <em>Featuremodules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Featuremodules</em>'.
   * @see uw.cs.watform.forml.forml.BehaviourModel#getFeaturemodules()
   * @see #getBehaviourModel()
   * @generated
   */
  EReference getBehaviourModel_Featuremodules();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.FeatureModule <em>Feature Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Module</em>'.
   * @see uw.cs.watform.forml.forml.FeatureModule
   * @generated
   */
  EClass getFeatureModule();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.FeatureModule#getFeatureref <em>Featureref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Featureref</em>'.
   * @see uw.cs.watform.forml.forml.FeatureModule#getFeatureref()
   * @see #getFeatureModule()
   * @generated
   */
  EReference getFeatureModule_Featureref();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.FeatureModule#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraints</em>'.
   * @see uw.cs.watform.forml.forml.FeatureModule#getConstraints()
   * @see #getFeatureModule()
   * @generated
   */
  EReference getFeatureModule_Constraints();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.FeatureModule#getStatemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statemachine</em>'.
   * @see uw.cs.watform.forml.forml.FeatureModule#getStatemachine()
   * @see #getFeatureModule()
   * @generated
   */
  EReference getFeatureModule_Statemachine();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.FeatureModule#getFragments <em>Fragments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fragments</em>'.
   * @see uw.cs.watform.forml.forml.FeatureModule#getFragments()
   * @see #getFeatureModule()
   * @generated
   */
  EReference getFeatureModule_Fragments();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.StateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine</em>'.
   * @see uw.cs.watform.forml.forml.StateMachine
   * @generated
   */
  EClass getStateMachine();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.StateMachine#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.StateMachine#getName()
   * @see #getStateMachine()
   * @generated
   */
  EAttribute getStateMachine_Name();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.StateMachine#getRegions <em>Regions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Regions</em>'.
   * @see uw.cs.watform.forml.forml.StateMachine#getRegions()
   * @see #getStateMachine()
   * @generated
   */
  EReference getStateMachine_Regions();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.StateMachine#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see uw.cs.watform.forml.forml.StateMachine#getTransitions()
   * @see #getStateMachine()
   * @generated
   */
  EReference getStateMachine_Transitions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.InitState <em>Init State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init State</em>'.
   * @see uw.cs.watform.forml.forml.InitState
   * @generated
   */
  EClass getInitState();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.InitState#getStateref <em>Stateref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Stateref</em>'.
   * @see uw.cs.watform.forml.forml.InitState#getStateref()
   * @see #getInitState()
   * @generated
   */
  EReference getInitState_Stateref();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Component <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component</em>'.
   * @see uw.cs.watform.forml.forml.Component
   * @generated
   */
  EClass getComponent();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Component#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Component#getName()
   * @see #getComponent()
   * @generated
   */
  EAttribute getComponent_Name();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see uw.cs.watform.forml.forml.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Transition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Transition#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Priority</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getPriority()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Priority();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Transition#getSrc <em>Src</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Src</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getSrc()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Src();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Transition#getDst <em>Dst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Dst</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getDst()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Dst();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Transition#getTrig <em>Trig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trig</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getTrig()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Trig();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Transition#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getGuard()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_Guard();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Transition#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see uw.cs.watform.forml.forml.Transition#getList()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_List();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Priority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Priority</em>'.
   * @see uw.cs.watform.forml.forml.Priority
   * @generated
   */
  EClass getPriority();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Priority#getTranslist <em>Translist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Translist</em>'.
   * @see uw.cs.watform.forml.forml.Priority#getTranslist()
   * @see #getPriority()
   * @generated
   */
  EReference getPriority_Translist();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.TransList <em>Trans List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trans List</em>'.
   * @see uw.cs.watform.forml.forml.TransList
   * @generated
   */
  EClass getTransList();

  /**
   * Returns the meta object for the reference list '{@link uw.cs.watform.forml.forml.TransList#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Transitions</em>'.
   * @see uw.cs.watform.forml.forml.TransList#getTransitions()
   * @see #getTransList()
   * @generated
   */
  EReference getTransList_Transitions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see uw.cs.watform.forml.forml.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Guard#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see uw.cs.watform.forml.forml.Guard#getPredicate()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Predicate();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger</em>'.
   * @see uw.cs.watform.forml.forml.Trigger
   * @generated
   */
  EClass getTrigger();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Trigger#getOverride <em>Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Override</em>'.
   * @see uw.cs.watform.forml.forml.Trigger#getOverride()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_Override();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Trigger#getWce <em>Wce</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Wce</em>'.
   * @see uw.cs.watform.forml.forml.Trigger#getWce()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_Wce();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Override <em>Override</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Override</em>'.
   * @see uw.cs.watform.forml.forml.Override
   * @generated
   */
  EClass getOverride();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Override#getTransition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Transition</em>'.
   * @see uw.cs.watform.forml.forml.Override#getTransition()
   * @see #getOverride()
   * @generated
   */
  EReference getOverride_Transition();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.WCE <em>WCE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>WCE</em>'.
   * @see uw.cs.watform.forml.forml.WCE
   * @generated
   */
  EClass getWCE();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.WCE#getAddobj <em>Addobj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Addobj</em>'.
   * @see uw.cs.watform.forml.forml.WCE#getAddobj()
   * @see #getWCE()
   * @generated
   */
  EReference getWCE_Addobj();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.WCE#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attr</em>'.
   * @see uw.cs.watform.forml.forml.WCE#getAttr()
   * @see #getWCE()
   * @generated
   */
  EReference getWCE_Attr();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.WCE#getRemobj <em>Remobj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Remobj</em>'.
   * @see uw.cs.watform.forml.forml.WCE#getRemobj()
   * @see #getWCE()
   * @generated
   */
  EReference getWCE_Remobj();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.WCAList <em>WCA List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>WCA List</em>'.
   * @see uw.cs.watform.forml.forml.WCAList
   * @generated
   */
  EClass getWCAList();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.WCAList#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see uw.cs.watform.forml.forml.WCAList#getActions()
   * @see #getWCAList()
   * @generated
   */
  EReference getWCAList_Actions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.WCA <em>WCA</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>WCA</em>'.
   * @see uw.cs.watform.forml.forml.WCA
   * @generated
   */
  EClass getWCA();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.WCA#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.WCA#getName()
   * @see #getWCA()
   * @generated
   */
  EAttribute getWCA_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.WCA#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see uw.cs.watform.forml.forml.WCA#getAction()
   * @see #getWCA()
   * @generated
   */
  EReference getWCA_Action();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see uw.cs.watform.forml.forml.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Action#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see uw.cs.watform.forml.forml.Action#getType()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Type();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Action#getOut <em>Out</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Out</em>'.
   * @see uw.cs.watform.forml.forml.Action#getOut()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Out();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Action#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see uw.cs.watform.forml.forml.Action#getList()
   * @see #getAction()
   * @generated
   */
  EReference getAction_List();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Action#getMinexpr <em>Minexpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Minexpr</em>'.
   * @see uw.cs.watform.forml.forml.Action#getMinexpr()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Minexpr();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Action#getLvalue <em>Lvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lvalue</em>'.
   * @see uw.cs.watform.forml.forml.Action#getLvalue()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Lvalue();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Action#getRvalue <em>Rvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rvalue</em>'.
   * @see uw.cs.watform.forml.forml.Action#getRvalue()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Rvalue();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.AssignList <em>Assign List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign List</em>'.
   * @see uw.cs.watform.forml.forml.AssignList
   * @generated
   */
  EClass getAssignList();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.AssignList#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see uw.cs.watform.forml.forml.AssignList#getList()
   * @see #getAssignList()
   * @generated
   */
  EReference getAssignList_List();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Assign <em>Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assign</em>'.
   * @see uw.cs.watform.forml.forml.Assign
   * @generated
   */
  EClass getAssign();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Assign#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.Assign#getRef()
   * @see #getAssign()
   * @generated
   */
  EReference getAssign_Ref();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Assign#getSexpr <em>Sexpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sexpr</em>'.
   * @see uw.cs.watform.forml.forml.Assign#getSexpr()
   * @see #getAssign()
   * @generated
   */
  EReference getAssign_Sexpr();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Macro <em>Macro</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Macro</em>'.
   * @see uw.cs.watform.forml.forml.Macro
   * @generated
   */
  EClass getMacro();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Macro#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Macro#getName()
   * @see #getMacro()
   * @generated
   */
  EAttribute getMacro_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Macro#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see uw.cs.watform.forml.forml.Macro#getExpr()
   * @see #getMacro()
   * @generated
   */
  EReference getMacro_Expr();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Predicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Predicate</em>'.
   * @see uw.cs.watform.forml.forml.Predicate
   * @generated
   */
  EClass getPredicate();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Predicate#getLogicop <em>Logicop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Logicop</em>'.
   * @see uw.cs.watform.forml.forml.Predicate#getLogicop()
   * @see #getPredicate()
   * @generated
   */
  EAttribute getPredicate_Logicop();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Predicate#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see uw.cs.watform.forml.forml.Predicate#getVar()
   * @see #getPredicate()
   * @generated
   */
  EReference getPredicate_Var();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Predicate#getSexpr <em>Sexpr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sexpr</em>'.
   * @see uw.cs.watform.forml.forml.Predicate#getSexpr()
   * @see #getPredicate()
   * @generated
   */
  EReference getPredicate_Sexpr();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Predicate#getQuantPred <em>Quant Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Quant Pred</em>'.
   * @see uw.cs.watform.forml.forml.Predicate#getQuantPred()
   * @see #getPredicate()
   * @generated
   */
  EReference getPredicate_QuantPred();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.notPred <em>not Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>not Pred</em>'.
   * @see uw.cs.watform.forml.forml.notPred
   * @generated
   */
  EClass getnotPred();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.notPred#getPred <em>Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pred</em>'.
   * @see uw.cs.watform.forml.forml.notPred#getPred()
   * @see #getnotPred()
   * @generated
   */
  EReference getnotPred_Pred();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.andPred <em>and Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>and Pred</em>'.
   * @see uw.cs.watform.forml.forml.andPred
   * @generated
   */
  EClass getandPred();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.andPred#getPreds <em>Preds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Preds</em>'.
   * @see uw.cs.watform.forml.forml.andPred#getPreds()
   * @see #getandPred()
   * @generated
   */
  EReference getandPred_Preds();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.impPred <em>imp Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>imp Pred</em>'.
   * @see uw.cs.watform.forml.forml.impPred
   * @generated
   */
  EClass getimpPred();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.impPred#getPreds <em>Preds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Preds</em>'.
   * @see uw.cs.watform.forml.forml.impPred#getPreds()
   * @see #getimpPred()
   * @generated
   */
  EReference getimpPred_Preds();

  /**
   * Returns the meta object for the attribute list '{@link uw.cs.watform.forml.forml.impPred#getLogicop <em>Logicop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Logicop</em>'.
   * @see uw.cs.watform.forml.forml.impPred#getLogicop()
   * @see #getimpPred()
   * @generated
   */
  EAttribute getimpPred_Logicop();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.orPred <em>or Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>or Pred</em>'.
   * @see uw.cs.watform.forml.forml.orPred
   * @generated
   */
  EClass getorPred();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.orPred#getPreds <em>Preds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Preds</em>'.
   * @see uw.cs.watform.forml.forml.orPred#getPreds()
   * @see #getorPred()
   * @generated
   */
  EReference getorPred_Preds();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.basePred <em>base Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>base Pred</em>'.
   * @see uw.cs.watform.forml.forml.basePred
   * @generated
   */
  EClass getbasePred();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.basePred#getLogicop <em>Logicop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Logicop</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getLogicop()
   * @see #getbasePred()
   * @generated
   */
  EAttribute getbasePred_Logicop();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getCardpred <em>Cardpred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cardpred</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getCardpred()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_Cardpred();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getSetlhs <em>Setlhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Setlhs</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getSetlhs()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_Setlhs();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getSetrhs <em>Setrhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Setrhs</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getSetrhs()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_Setrhs();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getBoolrhs <em>Boolrhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Boolrhs</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getBoolrhs()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_Boolrhs();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getIntlhs <em>Intlhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Intlhs</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getIntlhs()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_Intlhs();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.basePred#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getOp()
   * @see #getbasePred()
   * @generated
   */
  EAttribute getbasePred_Op();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getIntrhs <em>Intrhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Intrhs</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getIntrhs()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_Intrhs();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.basePred#getParenPred <em>Paren Pred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paren Pred</em>'.
   * @see uw.cs.watform.forml.forml.basePred#getParenPred()
   * @see #getbasePred()
   * @generated
   */
  EReference getbasePred_ParenPred();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.boolExpr <em>bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>bool Expr</em>'.
   * @see uw.cs.watform.forml.forml.boolExpr
   * @generated
   */
  EClass getboolExpr();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.boolExpr#getIsTrue <em>Is True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is True</em>'.
   * @see uw.cs.watform.forml.forml.boolExpr#getIsTrue()
   * @see #getboolExpr()
   * @generated
   */
  EAttribute getboolExpr_IsTrue();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.boolExpr#getIsFalse <em>Is False</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is False</em>'.
   * @see uw.cs.watform.forml.forml.boolExpr#getIsFalse()
   * @see #getboolExpr()
   * @generated
   */
  EAttribute getboolExpr_IsFalse();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.predExpr <em>pred Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>pred Expr</em>'.
   * @see uw.cs.watform.forml.forml.predExpr
   * @generated
   */
  EClass getpredExpr();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.predExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see uw.cs.watform.forml.forml.predExpr#getExpr()
   * @see #getpredExpr()
   * @generated
   */
  EReference getpredExpr_Expr();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.predExpr2 <em>pred Expr2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>pred Expr2</em>'.
   * @see uw.cs.watform.forml.forml.predExpr2
   * @generated
   */
  EClass getpredExpr2();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.predExpr2#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see uw.cs.watform.forml.forml.predExpr2#getExpr()
   * @see #getpredExpr2()
   * @generated
   */
  EReference getpredExpr2_Expr();

  /**
   * Returns the meta object for the attribute list '{@link uw.cs.watform.forml.forml.predExpr2#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see uw.cs.watform.forml.forml.predExpr2#getOp()
   * @see #getpredExpr2()
   * @generated
   */
  EAttribute getpredExpr2_Op();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.predExpr3 <em>pred Expr3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>pred Expr3</em>'.
   * @see uw.cs.watform.forml.forml.predExpr3
   * @generated
   */
  EClass getpredExpr3();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.predExpr3#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see uw.cs.watform.forml.forml.predExpr3#getBase()
   * @see #getpredExpr3()
   * @generated
   */
  EReference getpredExpr3_Base();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.setExpr <em>set Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>set Expr</em>'.
   * @see uw.cs.watform.forml.forml.setExpr
   * @generated
   */
  EClass getsetExpr();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.setExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see uw.cs.watform.forml.forml.setExpr#getExpr()
   * @see #getsetExpr()
   * @generated
   */
  EReference getsetExpr_Expr();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.setExpr2 <em>set Expr2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>set Expr2</em>'.
   * @see uw.cs.watform.forml.forml.setExpr2
   * @generated
   */
  EClass getsetExpr2();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.setExpr2#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expr</em>'.
   * @see uw.cs.watform.forml.forml.setExpr2#getExpr()
   * @see #getsetExpr2()
   * @generated
   */
  EReference getsetExpr2_Expr();

  /**
   * Returns the meta object for the attribute list '{@link uw.cs.watform.forml.forml.setExpr2#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see uw.cs.watform.forml.forml.setExpr2#getOp()
   * @see #getsetExpr2()
   * @generated
   */
  EAttribute getsetExpr2_Op();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.setExpr3 <em>set Expr3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>set Expr3</em>'.
   * @see uw.cs.watform.forml.forml.setExpr3
   * @generated
   */
  EClass getsetExpr3();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.setExpr3#getParen <em>Paren</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Paren</em>'.
   * @see uw.cs.watform.forml.forml.setExpr3#getParen()
   * @see #getsetExpr3()
   * @generated
   */
  EReference getsetExpr3_Paren();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.setExpr3#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see uw.cs.watform.forml.forml.setExpr3#getBase()
   * @see #getsetExpr3()
   * @generated
   */
  EReference getsetExpr3_Base();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.setExprBase <em>set Expr Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>set Expr Base</em>'.
   * @see uw.cs.watform.forml.forml.setExprBase
   * @generated
   */
  EClass getsetExprBase();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.setExprBase#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Atom</em>'.
   * @see uw.cs.watform.forml.forml.setExprBase#getAtom()
   * @see #getsetExprBase()
   * @generated
   */
  EReference getsetExprBase_Atom();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.setExprBase#getUnspec <em>Unspec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unspec</em>'.
   * @see uw.cs.watform.forml.forml.setExprBase#getUnspec()
   * @see #getsetExprBase()
   * @generated
   */
  EReference getsetExprBase_Unspec();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.intExpr <em>int Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>int Expr</em>'.
   * @see uw.cs.watform.forml.forml.intExpr
   * @generated
   */
  EClass getintExpr();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.intExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see uw.cs.watform.forml.forml.intExpr#getLhs()
   * @see #getintExpr()
   * @generated
   */
  EReference getintExpr_Lhs();

  /**
   * Returns the meta object for the attribute list '{@link uw.cs.watform.forml.forml.intExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see uw.cs.watform.forml.forml.intExpr#getOp()
   * @see #getintExpr()
   * @generated
   */
  EAttribute getintExpr_Op();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.intExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rhs</em>'.
   * @see uw.cs.watform.forml.forml.intExpr#getRhs()
   * @see #getintExpr()
   * @generated
   */
  EReference getintExpr_Rhs();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.multExpr <em>mult Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>mult Expr</em>'.
   * @see uw.cs.watform.forml.forml.multExpr
   * @generated
   */
  EClass getmultExpr();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.multExpr#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see uw.cs.watform.forml.forml.multExpr#getLhs()
   * @see #getmultExpr()
   * @generated
   */
  EReference getmultExpr_Lhs();

  /**
   * Returns the meta object for the attribute list '{@link uw.cs.watform.forml.forml.multExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Op</em>'.
   * @see uw.cs.watform.forml.forml.multExpr#getOp()
   * @see #getmultExpr()
   * @generated
   */
  EAttribute getmultExpr_Op();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.multExpr#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rhs</em>'.
   * @see uw.cs.watform.forml.forml.multExpr#getRhs()
   * @see #getmultExpr()
   * @generated
   */
  EReference getmultExpr_Rhs();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.intBase <em>int Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>int Base</em>'.
   * @see uw.cs.watform.forml.forml.intBase
   * @generated
   */
  EClass getintBase();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.intBase#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Atom</em>'.
   * @see uw.cs.watform.forml.forml.intBase#getAtom()
   * @see #getintBase()
   * @generated
   */
  EReference getintBase_Atom();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.intBase#getNum <em>Num</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num</em>'.
   * @see uw.cs.watform.forml.forml.intBase#getNum()
   * @see #getintBase()
   * @generated
   */
  EAttribute getintBase_Num();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.atomic <em>atomic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>atomic</em>'.
   * @see uw.cs.watform.forml.forml.atomic
   * @generated
   */
  EClass getatomic();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.atomic#getNone <em>None</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>None</em>'.
   * @see uw.cs.watform.forml.forml.atomic#getNone()
   * @see #getatomic()
   * @generated
   */
  EAttribute getatomic_None();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.atomic#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.atomic#getRef()
   * @see #getatomic()
   * @generated
   */
  EReference getatomic_Ref();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.atomic#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Refs</em>'.
   * @see uw.cs.watform.forml.forml.atomic#getRefs()
   * @see #getatomic()
   * @generated
   */
  EReference getatomic_Refs();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.unspecified <em>unspecified</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>unspecified</em>'.
   * @see uw.cs.watform.forml.forml.unspecified
   * @generated
   */
  EClass getunspecified();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.unspecified#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.unspecified#getRef()
   * @see #getunspecified()
   * @generated
   */
  EReference getunspecified_Ref();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Fragment <em>Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fragment</em>'.
   * @see uw.cs.watform.forml.forml.Fragment
   * @generated
   */
  EClass getFragment();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Fragment#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Fragment#getName()
   * @see #getFragment()
   * @generated
   */
  EAttribute getFragment_Name();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Fragment#getFragmentType <em>Fragment Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fragment Type</em>'.
   * @see uw.cs.watform.forml.forml.Fragment#getFragmentType()
   * @see #getFragment()
   * @generated
   */
  EReference getFragment_FragmentType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.FragmentType <em>Fragment Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fragment Type</em>'.
   * @see uw.cs.watform.forml.forml.FragmentType
   * @generated
   */
  EClass getFragmentType();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.FragmentType#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State</em>'.
   * @see uw.cs.watform.forml.forml.FragmentType#getState()
   * @see #getFragmentType()
   * @generated
   */
  EReference getFragmentType_State();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.FragmentType#getRegion <em>Region</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Region</em>'.
   * @see uw.cs.watform.forml.forml.FragmentType#getRegion()
   * @see #getFragmentType()
   * @generated
   */
  EReference getFragmentType_Region();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.FragmentType#getFrag <em>Frag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Frag</em>'.
   * @see uw.cs.watform.forml.forml.FragmentType#getFrag()
   * @see #getFragmentType()
   * @generated
   */
  EReference getFragmentType_Frag();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.FragmentType#getStatemachine <em>Statemachine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Statemachine</em>'.
   * @see uw.cs.watform.forml.forml.FragmentType#getStatemachine()
   * @see #getFragmentType()
   * @generated
   */
  EReference getFragmentType_Statemachine();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.FragmentType#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see uw.cs.watform.forml.forml.FragmentType#getTransitions()
   * @see #getFragmentType()
   * @generated
   */
  EReference getFragmentType_Transitions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.StateContext <em>State Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Context</em>'.
   * @see uw.cs.watform.forml.forml.StateContext
   * @generated
   */
  EClass getStateContext();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.StateContext#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.StateContext#getRef()
   * @see #getStateContext()
   * @generated
   */
  EReference getStateContext_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.StateContext#getRegions <em>Regions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Regions</em>'.
   * @see uw.cs.watform.forml.forml.StateContext#getRegions()
   * @see #getStateContext()
   * @generated
   */
  EReference getStateContext_Regions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.RegionContext <em>Region Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Region Context</em>'.
   * @see uw.cs.watform.forml.forml.RegionContext
   * @generated
   */
  EClass getRegionContext();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.RegionContext#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.RegionContext#getRef()
   * @see #getRegionContext()
   * @generated
   */
  EReference getRegionContext_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.RegionContext#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see uw.cs.watform.forml.forml.RegionContext#getStates()
   * @see #getRegionContext()
   * @generated
   */
  EReference getRegionContext_States();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.StateMachineContext <em>State Machine Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine Context</em>'.
   * @see uw.cs.watform.forml.forml.StateMachineContext
   * @generated
   */
  EClass getStateMachineContext();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.StateMachineContext#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.StateMachineContext#getRef()
   * @see #getStateMachineContext()
   * @generated
   */
  EReference getStateMachineContext_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.StateMachineContext#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State</em>'.
   * @see uw.cs.watform.forml.forml.StateMachineContext#getState()
   * @see #getStateMachineContext()
   * @generated
   */
  EReference getStateMachineContext_State();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.TranFragment <em>Tran Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tran Fragment</em>'.
   * @see uw.cs.watform.forml.forml.TranFragment
   * @generated
   */
  EClass getTranFragment();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.TranFragment#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.TranFragment#getRef()
   * @see #getTranFragment()
   * @generated
   */
  EReference getTranFragment_Ref();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.TranFragment#getTrig <em>Trig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trig</em>'.
   * @see uw.cs.watform.forml.forml.TranFragment#getTrig()
   * @see #getTranFragment()
   * @generated
   */
  EReference getTranFragment_Trig();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.TranFragment#getFragType <em>Frag Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Frag Type</em>'.
   * @see uw.cs.watform.forml.forml.TranFragment#getFragType()
   * @see #getTranFragment()
   * @generated
   */
  EReference getTranFragment_FragType();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.TranFragment#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see uw.cs.watform.forml.forml.TranFragment#getList()
   * @see #getTranFragment()
   * @generated
   */
  EReference getTranFragment_List();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.TranFragment#getFragList <em>Frag List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Frag List</em>'.
   * @see uw.cs.watform.forml.forml.TranFragment#getFragList()
   * @see #getTranFragment()
   * @generated
   */
  EReference getTranFragment_FragList();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.WCAFragmentList <em>WCA Fragment List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>WCA Fragment List</em>'.
   * @see uw.cs.watform.forml.forml.WCAFragmentList
   * @generated
   */
  EClass getWCAFragmentList();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.WCAFragmentList#getFrag <em>Frag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Frag</em>'.
   * @see uw.cs.watform.forml.forml.WCAFragmentList#getFrag()
   * @see #getWCAFragmentList()
   * @generated
   */
  EReference getWCAFragmentList_Frag();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.WCAFragment <em>WCA Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>WCA Fragment</em>'.
   * @see uw.cs.watform.forml.forml.WCAFragment
   * @generated
   */
  EClass getWCAFragment();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.WCAFragment#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see uw.cs.watform.forml.forml.WCAFragment#getRef()
   * @see #getWCAFragment()
   * @generated
   */
  EReference getWCAFragment_Ref();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.WCAFragment#getFragType <em>Frag Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Frag Type</em>'.
   * @see uw.cs.watform.forml.forml.WCAFragment#getFragType()
   * @see #getWCAFragment()
   * @generated
   */
  EReference getWCAFragment_FragType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see uw.cs.watform.forml.forml.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Entity#isCtrl <em>Ctrl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ctrl</em>'.
   * @see uw.cs.watform.forml.forml.Entity#isCtrl()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Ctrl();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.Entity#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Type</em>'.
   * @see uw.cs.watform.forml.forml.Entity#getSuperType()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_SuperType();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Entity#getFunctions <em>Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Functions</em>'.
   * @see uw.cs.watform.forml.forml.Entity#getFunctions()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Functions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association</em>'.
   * @see uw.cs.watform.forml.forml.Association
   * @generated
   */
  EClass getAssociation();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Association#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see uw.cs.watform.forml.forml.Association#getAttributes()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_Attributes();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Association#getSrcRole <em>Src Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Src Role</em>'.
   * @see uw.cs.watform.forml.forml.Association#getSrcRole()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_SrcRole();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Association#getDesRole <em>Des Role</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Des Role</em>'.
   * @see uw.cs.watform.forml.forml.Association#getDesRole()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_DesRole();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see uw.cs.watform.forml.forml.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Attribute#isCtrl <em>Ctrl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ctrl</em>'.
   * @see uw.cs.watform.forml.forml.Attribute#isCtrl()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Ctrl();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Attribute#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see uw.cs.watform.forml.forml.Attribute#getMultiplicity()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Attribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see uw.cs.watform.forml.forml.Attribute#getType()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Type();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see uw.cs.watform.forml.forml.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Function#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see uw.cs.watform.forml.forml.Function#getType()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Type();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.UndefinedType <em>Undefined Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Undefined Type</em>'.
   * @see uw.cs.watform.forml.forml.UndefinedType
   * @generated
   */
  EClass getUndefinedType();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Aggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregation</em>'.
   * @see uw.cs.watform.forml.forml.Aggregation
   * @generated
   */
  EClass getAggregation();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Aggregation#getWhole <em>Whole</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Whole</em>'.
   * @see uw.cs.watform.forml.forml.Aggregation#getWhole()
   * @see #getAggregation()
   * @generated
   */
  EReference getAggregation_Whole();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Aggregation#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Part</em>'.
   * @see uw.cs.watform.forml.forml.Aggregation#getPart()
   * @see #getAggregation()
   * @generated
   */
  EReference getAggregation_Part();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Composition <em>Composition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composition</em>'.
   * @see uw.cs.watform.forml.forml.Composition
   * @generated
   */
  EClass getComposition();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Composition#getWhole <em>Whole</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Whole</em>'.
   * @see uw.cs.watform.forml.forml.Composition#getWhole()
   * @see #getComposition()
   * @generated
   */
  EReference getComposition_Whole();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Composition#getPart <em>Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Part</em>'.
   * @see uw.cs.watform.forml.forml.Composition#getPart()
   * @see #getComposition()
   * @generated
   */
  EReference getComposition_Part();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.CompDecl <em>Comp Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comp Decl</em>'.
   * @see uw.cs.watform.forml.forml.CompDecl
   * @generated
   */
  EClass getCompDecl();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Input <em>Input</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input</em>'.
   * @see uw.cs.watform.forml.forml.Input
   * @generated
   */
  EClass getInput();

  /**
   * Returns the meta object for the reference list '{@link uw.cs.watform.forml.forml.Input#getTos <em>Tos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Tos</em>'.
   * @see uw.cs.watform.forml.forml.Input#getTos()
   * @see #getInput()
   * @generated
   */
  EReference getInput_Tos();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Output <em>Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output</em>'.
   * @see uw.cs.watform.forml.forml.Output
   * @generated
   */
  EClass getOutput();

  /**
   * Returns the meta object for the reference list '{@link uw.cs.watform.forml.forml.Output#getFroms <em>Froms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Froms</em>'.
   * @see uw.cs.watform.forml.forml.Output#getFroms()
   * @see #getOutput()
   * @generated
   */
  EReference getOutput_Froms();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see uw.cs.watform.forml.forml.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Feature#getInputlist <em>Inputlist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Inputlist</em>'.
   * @see uw.cs.watform.forml.forml.Feature#getInputlist()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Inputlist();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Feature#getOutputlist <em>Outputlist</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Outputlist</em>'.
   * @see uw.cs.watform.forml.forml.Feature#getOutputlist()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Outputlist();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.SPL <em>SPL</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SPL</em>'.
   * @see uw.cs.watform.forml.forml.SPL
   * @generated
   */
  EClass getSPL();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.SPL#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.SPL#getName()
   * @see #getSPL()
   * @generated
   */
  EAttribute getSPL_Name();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.SPL#getXors <em>Xors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Xors</em>'.
   * @see uw.cs.watform.forml.forml.SPL#getXors()
   * @see #getSPL()
   * @generated
   */
  EReference getSPL_Xors();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.SPL#getAnds <em>Ands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ands</em>'.
   * @see uw.cs.watform.forml.forml.SPL#getAnds()
   * @see #getSPL()
   * @generated
   */
  EReference getSPL_Ands();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.SPL#getOrs <em>Ors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ors</em>'.
   * @see uw.cs.watform.forml.forml.SPL#getOrs()
   * @see #getSPL()
   * @generated
   */
  EReference getSPL_Ors();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.XORNode <em>XOR Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XOR Node</em>'.
   * @see uw.cs.watform.forml.forml.XORNode
   * @generated
   */
  EClass getXORNode();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.AndNode <em>And Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Node</em>'.
   * @see uw.cs.watform.forml.forml.AndNode
   * @generated
   */
  EClass getAndNode();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.OrNode <em>Or Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Node</em>'.
   * @see uw.cs.watform.forml.forml.OrNode
   * @generated
   */
  EClass getOrNode();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.FeatureNode <em>Feature Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Node</em>'.
   * @see uw.cs.watform.forml.forml.FeatureNode
   * @generated
   */
  EClass getFeatureNode();

  /**
   * Returns the meta object for the reference '{@link uw.cs.watform.forml.forml.FeatureNode#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see uw.cs.watform.forml.forml.FeatureNode#getFeature()
   * @see #getFeatureNode()
   * @generated
   */
  EReference getFeatureNode_Feature();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.FeatureNode#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see uw.cs.watform.forml.forml.FeatureNode#getMultiplicity()
   * @see #getFeatureNode()
   * @generated
   */
  EReference getFeatureNode_Multiplicity();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.FeatureNode#getXors <em>Xors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Xors</em>'.
   * @see uw.cs.watform.forml.forml.FeatureNode#getXors()
   * @see #getFeatureNode()
   * @generated
   */
  EReference getFeatureNode_Xors();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.FeatureNode#getAnds <em>Ands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ands</em>'.
   * @see uw.cs.watform.forml.forml.FeatureNode#getAnds()
   * @see #getFeatureNode()
   * @generated
   */
  EReference getFeatureNode_Ands();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.FeatureNode#getOrs <em>Ors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ors</em>'.
   * @see uw.cs.watform.forml.forml.FeatureNode#getOrs()
   * @see #getFeatureNode()
   * @generated
   */
  EReference getFeatureNode_Ors();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Enumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration</em>'.
   * @see uw.cs.watform.forml.forml.Enumeration
   * @generated
   */
  EClass getEnumeration();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Enumeration#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constant</em>'.
   * @see uw.cs.watform.forml.forml.Enumeration#getConstant()
   * @see #getEnumeration()
   * @generated
   */
  EReference getEnumeration_Constant();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.EnumConst <em>Enum Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Const</em>'.
   * @see uw.cs.watform.forml.forml.EnumConst
   * @generated
   */
  EClass getEnumConst();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.EnumConst#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.EnumConst#getName()
   * @see #getEnumConst()
   * @generated
   */
  EAttribute getEnumConst_Name();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see uw.cs.watform.forml.forml.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.State#getRegions <em>Regions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Regions</em>'.
   * @see uw.cs.watform.forml.forml.State#getRegions()
   * @see #getState()
   * @generated
   */
  EReference getState_Regions();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Region <em>Region</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Region</em>'.
   * @see uw.cs.watform.forml.forml.Region
   * @generated
   */
  EClass getRegion();

  /**
   * Returns the meta object for the containment reference '{@link uw.cs.watform.forml.forml.Region#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see uw.cs.watform.forml.forml.Region#getInit()
   * @see #getRegion()
   * @generated
   */
  EReference getRegion_Init();

  /**
   * Returns the meta object for the containment reference list '{@link uw.cs.watform.forml.forml.Region#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see uw.cs.watform.forml.forml.Region#getStates()
   * @see #getRegion()
   * @generated
   */
  EReference getRegion_States();

  /**
   * Returns the meta object for class '{@link uw.cs.watform.forml.forml.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see uw.cs.watform.forml.forml.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link uw.cs.watform.forml.forml.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see uw.cs.watform.forml.forml.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FormlFactory getFormlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.SystemImpl <em>System</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.SystemImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getSystem()
     * @generated
     */
    EClass SYSTEM = eINSTANCE.getSystem();

    /**
     * The meta object literal for the '<em><b>Worldmodel</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM__WORLDMODEL = eINSTANCE.getSystem_Worldmodel();

    /**
     * The meta object literal for the '<em><b>Behaviourmodel</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM__BEHAVIOURMODEL = eINSTANCE.getSystem_Behaviourmodel();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.WorldModelImpl <em>World Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.WorldModelImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWorldModel()
     * @generated
     */
    EClass WORLD_MODEL = eINSTANCE.getWorldModel();

    /**
     * The meta object literal for the '<em><b>Concepts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORLD_MODEL__CONCEPTS = eINSTANCE.getWorldModel_Concepts();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORLD_MODEL__CONSTRAINTS = eINSTANCE.getWorldModel_Constraints();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.ConstraintImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Predicates</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__PREDICATES = eINSTANCE.getConstraint_Predicates();

    /**
     * The meta object literal for the '<em><b>Macro</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__MACRO = eINSTANCE.getConstraint_Macro();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.ExprRefImpl <em>Expr Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.ExprRefImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getExprRef()
     * @generated
     */
    EClass EXPR_REF = eINSTANCE.getExprRef();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.ConceptImpl <em>Concept</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.ConceptImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getConcept()
     * @generated
     */
    EClass CONCEPT = eINSTANCE.getConcept();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONCEPT__NAME = eINSTANCE.getConcept_Name();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.RoleableImpl <em>Roleable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.RoleableImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRoleable()
     * @generated
     */
    EClass ROLEABLE = eINSTANCE.getRoleable();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLEABLE__ATTRIBUTES = eINSTANCE.getRoleable_Attributes();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.RelationshipImpl <em>Relationship</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.RelationshipImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRelationship()
     * @generated
     */
    EClass RELATIONSHIP = eINSTANCE.getRelationship();

    /**
     * The meta object literal for the '<em><b>Ctrl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP__CTRL = eINSTANCE.getRelationship_Ctrl();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AttributeTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAttributeType()
     * @generated
     */
    EClass ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.StringTypeImpl <em>String Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.StringTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStringType()
     * @generated
     */
    EClass STRING_TYPE = eINSTANCE.getStringType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.IntTypeImpl <em>Int Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.IntTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getIntType()
     * @generated
     */
    EClass INT_TYPE = eINSTANCE.getIntType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.BoolTypeImpl <em>Bool Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.BoolTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getBoolType()
     * @generated
     */
    EClass BOOL_TYPE = eINSTANCE.getBoolType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.ReferenceTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getReferenceType()
     * @generated
     */
    EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_TYPE__REF = eINSTANCE.getReferenceType_Ref();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.MultiplicityImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getMultiplicity()
     * @generated
     */
    EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__VALUE = eINSTANCE.getMultiplicity_Value();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY__MANY = eINSTANCE.getMultiplicity_Many();

    /**
     * The meta object literal for the '<em><b>Cardinality</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY__CARDINALITY = eINSTANCE.getMultiplicity_Cardinality();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.CardinalityImpl <em>Cardinality</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.CardinalityImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getCardinality()
     * @generated
     */
    EClass CARDINALITY = eINSTANCE.getCardinality();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CARDINALITY__LOWER = eINSTANCE.getCardinality_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CARDINALITY__UPPER = eINSTANCE.getCardinality_Upper();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CARDINALITY__MANY = eINSTANCE.getCardinality_Many();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.RoleImpl <em>Role</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.RoleImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRole()
     * @generated
     */
    EClass ROLE = eINSTANCE.getRole();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE__MULTIPLICITY = eINSTANCE.getRole_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE__TYPE = eINSTANCE.getRole_Type();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.DeclImpl <em>Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.DeclImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getDecl()
     * @generated
     */
    EClass DECL = eINSTANCE.getDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECL__NAME = eINSTANCE.getDecl_Name();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL__MULTIPLICITY = eINSTANCE.getDecl_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECL__TYPE = eINSTANCE.getDecl_Type();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.MessageImpl <em>Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.MessageImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getMessage()
     * @generated
     */
    EClass MESSAGE = eINSTANCE.getMessage();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE__TYPE = eINSTANCE.getMessage_Type();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE__ATTRIBUTES = eINSTANCE.getMessage_Attributes();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.InputListImpl <em>Input List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.InputListImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getInputList()
     * @generated
     */
    EClass INPUT_LIST = eINSTANCE.getInputList();

    /**
     * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_LIST__INPUTS = eINSTANCE.getInputList_Inputs();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.OutputListImpl <em>Output List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.OutputListImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOutputList()
     * @generated
     */
    EClass OUTPUT_LIST = eINSTANCE.getOutputList();

    /**
     * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_LIST__OUTPUTS = eINSTANCE.getOutputList_Outputs();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.RefMessageImpl <em>Ref Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.RefMessageImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRefMessage()
     * @generated
     */
    EClass REF_MESSAGE = eINSTANCE.getRefMessage();

    /**
     * The meta object literal for the '<em><b>Ref Msg</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_MESSAGE__REF_MSG = eINSTANCE.getRefMessage_RefMsg();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.NodeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em><b>Feature Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__FEATURE_NODES = eINSTANCE.getNode_FeatureNodes();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.BehaviourModelImpl <em>Behaviour Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.BehaviourModelImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getBehaviourModel()
     * @generated
     */
    EClass BEHAVIOUR_MODEL = eINSTANCE.getBehaviourModel();

    /**
     * The meta object literal for the '<em><b>Featuremodules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOUR_MODEL__FEATUREMODULES = eINSTANCE.getBehaviourModel_Featuremodules();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.FeatureModuleImpl <em>Feature Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.FeatureModuleImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFeatureModule()
     * @generated
     */
    EClass FEATURE_MODULE = eINSTANCE.getFeatureModule();

    /**
     * The meta object literal for the '<em><b>Featureref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODULE__FEATUREREF = eINSTANCE.getFeatureModule_Featureref();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODULE__CONSTRAINTS = eINSTANCE.getFeatureModule_Constraints();

    /**
     * The meta object literal for the '<em><b>Statemachine</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODULE__STATEMACHINE = eINSTANCE.getFeatureModule_Statemachine();

    /**
     * The meta object literal for the '<em><b>Fragments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODULE__FRAGMENTS = eINSTANCE.getFeatureModule_Fragments();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.StateMachineImpl <em>State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.StateMachineImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStateMachine()
     * @generated
     */
    EClass STATE_MACHINE = eINSTANCE.getStateMachine();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_MACHINE__NAME = eINSTANCE.getStateMachine_Name();

    /**
     * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE__REGIONS = eINSTANCE.getStateMachine_Regions();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE__TRANSITIONS = eINSTANCE.getStateMachine_Transitions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.InitStateImpl <em>Init State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.InitStateImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getInitState()
     * @generated
     */
    EClass INIT_STATE = eINSTANCE.getInitState();

    /**
     * The meta object literal for the '<em><b>Stateref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_STATE__STATEREF = eINSTANCE.getInitState_Stateref();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.ComponentImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getComponent()
     * @generated
     */
    EClass COMPONENT = eINSTANCE.getComponent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.TransitionImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__PRIORITY = eINSTANCE.getTransition_Priority();

    /**
     * The meta object literal for the '<em><b>Src</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__SRC = eINSTANCE.getTransition_Src();

    /**
     * The meta object literal for the '<em><b>Dst</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__DST = eINSTANCE.getTransition_Dst();

    /**
     * The meta object literal for the '<em><b>Trig</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__TRIG = eINSTANCE.getTransition_Trig();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__LIST = eINSTANCE.getTransition_List();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.PriorityImpl <em>Priority</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.PriorityImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getPriority()
     * @generated
     */
    EClass PRIORITY = eINSTANCE.getPriority();

    /**
     * The meta object literal for the '<em><b>Translist</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIORITY__TRANSLIST = eINSTANCE.getPriority_Translist();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.TransListImpl <em>Trans List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.TransListImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTransList()
     * @generated
     */
    EClass TRANS_LIST = eINSTANCE.getTransList();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANS_LIST__TRANSITIONS = eINSTANCE.getTransList_Transitions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.GuardImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__PREDICATE = eINSTANCE.getGuard_Predicate();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.TriggerImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTrigger()
     * @generated
     */
    EClass TRIGGER = eINSTANCE.getTrigger();

    /**
     * The meta object literal for the '<em><b>Override</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__OVERRIDE = eINSTANCE.getTrigger_Override();

    /**
     * The meta object literal for the '<em><b>Wce</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__WCE = eINSTANCE.getTrigger_Wce();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.OverrideImpl <em>Override</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.OverrideImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOverride()
     * @generated
     */
    EClass OVERRIDE = eINSTANCE.getOverride();

    /**
     * The meta object literal for the '<em><b>Transition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OVERRIDE__TRANSITION = eINSTANCE.getOverride_Transition();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.WCEImpl <em>WCE</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.WCEImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCE()
     * @generated
     */
    EClass WCE = eINSTANCE.getWCE();

    /**
     * The meta object literal for the '<em><b>Addobj</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCE__ADDOBJ = eINSTANCE.getWCE_Addobj();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCE__ATTR = eINSTANCE.getWCE_Attr();

    /**
     * The meta object literal for the '<em><b>Remobj</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCE__REMOBJ = eINSTANCE.getWCE_Remobj();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.WCAListImpl <em>WCA List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.WCAListImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCAList()
     * @generated
     */
    EClass WCA_LIST = eINSTANCE.getWCAList();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCA_LIST__ACTIONS = eINSTANCE.getWCAList_Actions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.WCAImpl <em>WCA</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.WCAImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCA()
     * @generated
     */
    EClass WCA = eINSTANCE.getWCA();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WCA__NAME = eINSTANCE.getWCA_Name();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCA__ACTION = eINSTANCE.getWCA_Action();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.ActionImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__TYPE = eINSTANCE.getAction_Type();

    /**
     * The meta object literal for the '<em><b>Out</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__OUT = eINSTANCE.getAction_Out();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__LIST = eINSTANCE.getAction_List();

    /**
     * The meta object literal for the '<em><b>Minexpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__MINEXPR = eINSTANCE.getAction_Minexpr();

    /**
     * The meta object literal for the '<em><b>Lvalue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__LVALUE = eINSTANCE.getAction_Lvalue();

    /**
     * The meta object literal for the '<em><b>Rvalue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__RVALUE = eINSTANCE.getAction_Rvalue();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AssignListImpl <em>Assign List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AssignListImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAssignList()
     * @generated
     */
    EClass ASSIGN_LIST = eINSTANCE.getAssignList();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN_LIST__LIST = eINSTANCE.getAssignList_List();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AssignImpl <em>Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AssignImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAssign()
     * @generated
     */
    EClass ASSIGN = eINSTANCE.getAssign();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN__REF = eINSTANCE.getAssign_Ref();

    /**
     * The meta object literal for the '<em><b>Sexpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGN__SEXPR = eINSTANCE.getAssign_Sexpr();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.MacroImpl <em>Macro</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.MacroImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getMacro()
     * @generated
     */
    EClass MACRO = eINSTANCE.getMacro();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO__NAME = eINSTANCE.getMacro_Name();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO__EXPR = eINSTANCE.getMacro_Expr();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.PredicateImpl <em>Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.PredicateImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getPredicate()
     * @generated
     */
    EClass PREDICATE = eINSTANCE.getPredicate();

    /**
     * The meta object literal for the '<em><b>Logicop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREDICATE__LOGICOP = eINSTANCE.getPredicate_Logicop();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE__VAR = eINSTANCE.getPredicate_Var();

    /**
     * The meta object literal for the '<em><b>Sexpr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE__SEXPR = eINSTANCE.getPredicate_Sexpr();

    /**
     * The meta object literal for the '<em><b>Quant Pred</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE__QUANT_PRED = eINSTANCE.getPredicate_QuantPred();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.notPredImpl <em>not Pred</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.notPredImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getnotPred()
     * @generated
     */
    EClass NOT_PRED = eINSTANCE.getnotPred();

    /**
     * The meta object literal for the '<em><b>Pred</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_PRED__PRED = eINSTANCE.getnotPred_Pred();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.andPredImpl <em>and Pred</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.andPredImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getandPred()
     * @generated
     */
    EClass AND_PRED = eINSTANCE.getandPred();

    /**
     * The meta object literal for the '<em><b>Preds</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_PRED__PREDS = eINSTANCE.getandPred_Preds();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.impPredImpl <em>imp Pred</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.impPredImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getimpPred()
     * @generated
     */
    EClass IMP_PRED = eINSTANCE.getimpPred();

    /**
     * The meta object literal for the '<em><b>Preds</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMP_PRED__PREDS = eINSTANCE.getimpPred_Preds();

    /**
     * The meta object literal for the '<em><b>Logicop</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMP_PRED__LOGICOP = eINSTANCE.getimpPred_Logicop();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.orPredImpl <em>or Pred</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.orPredImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getorPred()
     * @generated
     */
    EClass OR_PRED = eINSTANCE.getorPred();

    /**
     * The meta object literal for the '<em><b>Preds</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_PRED__PREDS = eINSTANCE.getorPred_Preds();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.basePredImpl <em>base Pred</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.basePredImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getbasePred()
     * @generated
     */
    EClass BASE_PRED = eINSTANCE.getbasePred();

    /**
     * The meta object literal for the '<em><b>Logicop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_PRED__LOGICOP = eINSTANCE.getbasePred_Logicop();

    /**
     * The meta object literal for the '<em><b>Cardpred</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__CARDPRED = eINSTANCE.getbasePred_Cardpred();

    /**
     * The meta object literal for the '<em><b>Setlhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__SETLHS = eINSTANCE.getbasePred_Setlhs();

    /**
     * The meta object literal for the '<em><b>Setrhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__SETRHS = eINSTANCE.getbasePred_Setrhs();

    /**
     * The meta object literal for the '<em><b>Boolrhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__BOOLRHS = eINSTANCE.getbasePred_Boolrhs();

    /**
     * The meta object literal for the '<em><b>Intlhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__INTLHS = eINSTANCE.getbasePred_Intlhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_PRED__OP = eINSTANCE.getbasePred_Op();

    /**
     * The meta object literal for the '<em><b>Intrhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__INTRHS = eINSTANCE.getbasePred_Intrhs();

    /**
     * The meta object literal for the '<em><b>Paren Pred</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_PRED__PAREN_PRED = eINSTANCE.getbasePred_ParenPred();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.boolExprImpl <em>bool Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.boolExprImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getboolExpr()
     * @generated
     */
    EClass BOOL_EXPR = eINSTANCE.getboolExpr();

    /**
     * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_EXPR__IS_TRUE = eINSTANCE.getboolExpr_IsTrue();

    /**
     * The meta object literal for the '<em><b>Is False</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_EXPR__IS_FALSE = eINSTANCE.getboolExpr_IsFalse();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.predExprImpl <em>pred Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.predExprImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getpredExpr()
     * @generated
     */
    EClass PRED_EXPR = eINSTANCE.getpredExpr();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRED_EXPR__EXPR = eINSTANCE.getpredExpr_Expr();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.predExpr2Impl <em>pred Expr2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.predExpr2Impl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getpredExpr2()
     * @generated
     */
    EClass PRED_EXPR2 = eINSTANCE.getpredExpr2();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRED_EXPR2__EXPR = eINSTANCE.getpredExpr2_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRED_EXPR2__OP = eINSTANCE.getpredExpr2_Op();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.predExpr3Impl <em>pred Expr3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.predExpr3Impl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getpredExpr3()
     * @generated
     */
    EClass PRED_EXPR3 = eINSTANCE.getpredExpr3();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRED_EXPR3__BASE = eINSTANCE.getpredExpr3_Base();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.setExprImpl <em>set Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.setExprImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExpr()
     * @generated
     */
    EClass SET_EXPR = eINSTANCE.getsetExpr();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR__EXPR = eINSTANCE.getsetExpr_Expr();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.setExpr2Impl <em>set Expr2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.setExpr2Impl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExpr2()
     * @generated
     */
    EClass SET_EXPR2 = eINSTANCE.getsetExpr2();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR2__EXPR = eINSTANCE.getsetExpr2_Expr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SET_EXPR2__OP = eINSTANCE.getsetExpr2_Op();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.setExpr3Impl <em>set Expr3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.setExpr3Impl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExpr3()
     * @generated
     */
    EClass SET_EXPR3 = eINSTANCE.getsetExpr3();

    /**
     * The meta object literal for the '<em><b>Paren</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR3__PAREN = eINSTANCE.getsetExpr3_Paren();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR3__BASE = eINSTANCE.getsetExpr3_Base();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.setExprBaseImpl <em>set Expr Base</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.setExprBaseImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getsetExprBase()
     * @generated
     */
    EClass SET_EXPR_BASE = eINSTANCE.getsetExprBase();

    /**
     * The meta object literal for the '<em><b>Atom</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR_BASE__ATOM = eINSTANCE.getsetExprBase_Atom();

    /**
     * The meta object literal for the '<em><b>Unspec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR_BASE__UNSPEC = eINSTANCE.getsetExprBase_Unspec();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.intExprImpl <em>int Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.intExprImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getintExpr()
     * @generated
     */
    EClass INT_EXPR = eINSTANCE.getintExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_EXPR__LHS = eINSTANCE.getintExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_EXPR__OP = eINSTANCE.getintExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_EXPR__RHS = eINSTANCE.getintExpr_Rhs();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.multExprImpl <em>mult Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.multExprImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getmultExpr()
     * @generated
     */
    EClass MULT_EXPR = eINSTANCE.getmultExpr();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT_EXPR__LHS = eINSTANCE.getmultExpr_Lhs();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULT_EXPR__OP = eINSTANCE.getmultExpr_Op();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULT_EXPR__RHS = eINSTANCE.getmultExpr_Rhs();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.intBaseImpl <em>int Base</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.intBaseImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getintBase()
     * @generated
     */
    EClass INT_BASE = eINSTANCE.getintBase();

    /**
     * The meta object literal for the '<em><b>Atom</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_BASE__ATOM = eINSTANCE.getintBase_Atom();

    /**
     * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_BASE__NUM = eINSTANCE.getintBase_Num();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.atomicImpl <em>atomic</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.atomicImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getatomic()
     * @generated
     */
    EClass ATOMIC = eINSTANCE.getatomic();

    /**
     * The meta object literal for the '<em><b>None</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOMIC__NONE = eINSTANCE.getatomic_None();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC__REF = eINSTANCE.getatomic_Ref();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATOMIC__REFS = eINSTANCE.getatomic_Refs();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.unspecifiedImpl <em>unspecified</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.unspecifiedImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getunspecified()
     * @generated
     */
    EClass UNSPECIFIED = eINSTANCE.getunspecified();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNSPECIFIED__REF = eINSTANCE.getunspecified_Ref();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.FragmentImpl <em>Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.FragmentImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFragment()
     * @generated
     */
    EClass FRAGMENT = eINSTANCE.getFragment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FRAGMENT__NAME = eINSTANCE.getFragment_Name();

    /**
     * The meta object literal for the '<em><b>Fragment Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FRAGMENT__FRAGMENT_TYPE = eINSTANCE.getFragment_FragmentType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.FragmentTypeImpl <em>Fragment Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.FragmentTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFragmentType()
     * @generated
     */
    EClass FRAGMENT_TYPE = eINSTANCE.getFragmentType();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FRAGMENT_TYPE__STATE = eINSTANCE.getFragmentType_State();

    /**
     * The meta object literal for the '<em><b>Region</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FRAGMENT_TYPE__REGION = eINSTANCE.getFragmentType_Region();

    /**
     * The meta object literal for the '<em><b>Frag</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FRAGMENT_TYPE__FRAG = eINSTANCE.getFragmentType_Frag();

    /**
     * The meta object literal for the '<em><b>Statemachine</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FRAGMENT_TYPE__STATEMACHINE = eINSTANCE.getFragmentType_Statemachine();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FRAGMENT_TYPE__TRANSITIONS = eINSTANCE.getFragmentType_Transitions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.StateContextImpl <em>State Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.StateContextImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStateContext()
     * @generated
     */
    EClass STATE_CONTEXT = eINSTANCE.getStateContext();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_CONTEXT__REF = eINSTANCE.getStateContext_Ref();

    /**
     * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_CONTEXT__REGIONS = eINSTANCE.getStateContext_Regions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.RegionContextImpl <em>Region Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.RegionContextImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRegionContext()
     * @generated
     */
    EClass REGION_CONTEXT = eINSTANCE.getRegionContext();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGION_CONTEXT__REF = eINSTANCE.getRegionContext_Ref();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGION_CONTEXT__STATES = eINSTANCE.getRegionContext_States();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.StateMachineContextImpl <em>State Machine Context</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.StateMachineContextImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getStateMachineContext()
     * @generated
     */
    EClass STATE_MACHINE_CONTEXT = eINSTANCE.getStateMachineContext();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE_CONTEXT__REF = eINSTANCE.getStateMachineContext_Ref();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE_CONTEXT__STATE = eINSTANCE.getStateMachineContext_State();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.TranFragmentImpl <em>Tran Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.TranFragmentImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getTranFragment()
     * @generated
     */
    EClass TRAN_FRAGMENT = eINSTANCE.getTranFragment();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRAN_FRAGMENT__REF = eINSTANCE.getTranFragment_Ref();

    /**
     * The meta object literal for the '<em><b>Trig</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRAN_FRAGMENT__TRIG = eINSTANCE.getTranFragment_Trig();

    /**
     * The meta object literal for the '<em><b>Frag Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRAN_FRAGMENT__FRAG_TYPE = eINSTANCE.getTranFragment_FragType();

    /**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRAN_FRAGMENT__LIST = eINSTANCE.getTranFragment_List();

    /**
     * The meta object literal for the '<em><b>Frag List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRAN_FRAGMENT__FRAG_LIST = eINSTANCE.getTranFragment_FragList();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.WCAFragmentListImpl <em>WCA Fragment List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.WCAFragmentListImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCAFragmentList()
     * @generated
     */
    EClass WCA_FRAGMENT_LIST = eINSTANCE.getWCAFragmentList();

    /**
     * The meta object literal for the '<em><b>Frag</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCA_FRAGMENT_LIST__FRAG = eINSTANCE.getWCAFragmentList_Frag();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.WCAFragmentImpl <em>WCA Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.WCAFragmentImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getWCAFragment()
     * @generated
     */
    EClass WCA_FRAGMENT = eINSTANCE.getWCAFragment();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCA_FRAGMENT__REF = eINSTANCE.getWCAFragment_Ref();

    /**
     * The meta object literal for the '<em><b>Frag Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WCA_FRAGMENT__FRAG_TYPE = eINSTANCE.getWCAFragment_FragType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.EntityImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Ctrl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__CTRL = eINSTANCE.getEntity_Ctrl();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__SUPER_TYPE = eINSTANCE.getEntity_SuperType();

    /**
     * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__FUNCTIONS = eINSTANCE.getEntity_Functions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AssociationImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAssociation()
     * @generated
     */
    EClass ASSOCIATION = eINSTANCE.getAssociation();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__ATTRIBUTES = eINSTANCE.getAssociation_Attributes();

    /**
     * The meta object literal for the '<em><b>Src Role</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__SRC_ROLE = eINSTANCE.getAssociation_SrcRole();

    /**
     * The meta object literal for the '<em><b>Des Role</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__DES_ROLE = eINSTANCE.getAssociation_DesRole();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AttributeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Ctrl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__CTRL = eINSTANCE.getAttribute_Ctrl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__MULTIPLICITY = eINSTANCE.getAttribute_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.FunctionImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__TYPE = eINSTANCE.getFunction_Type();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.UndefinedTypeImpl <em>Undefined Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.UndefinedTypeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getUndefinedType()
     * @generated
     */
    EClass UNDEFINED_TYPE = eINSTANCE.getUndefinedType();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AggregationImpl <em>Aggregation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AggregationImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAggregation()
     * @generated
     */
    EClass AGGREGATION = eINSTANCE.getAggregation();

    /**
     * The meta object literal for the '<em><b>Whole</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AGGREGATION__WHOLE = eINSTANCE.getAggregation_Whole();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AGGREGATION__PART = eINSTANCE.getAggregation_Part();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.CompositionImpl <em>Composition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.CompositionImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getComposition()
     * @generated
     */
    EClass COMPOSITION = eINSTANCE.getComposition();

    /**
     * The meta object literal for the '<em><b>Whole</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITION__WHOLE = eINSTANCE.getComposition_Whole();

    /**
     * The meta object literal for the '<em><b>Part</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITION__PART = eINSTANCE.getComposition_Part();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.CompDeclImpl <em>Comp Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.CompDeclImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getCompDecl()
     * @generated
     */
    EClass COMP_DECL = eINSTANCE.getCompDecl();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.InputImpl <em>Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.InputImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getInput()
     * @generated
     */
    EClass INPUT = eINSTANCE.getInput();

    /**
     * The meta object literal for the '<em><b>Tos</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT__TOS = eINSTANCE.getInput_Tos();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.OutputImpl <em>Output</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.OutputImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOutput()
     * @generated
     */
    EClass OUTPUT = eINSTANCE.getOutput();

    /**
     * The meta object literal for the '<em><b>Froms</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT__FROMS = eINSTANCE.getOutput_Froms();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.FeatureImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Inputlist</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__INPUTLIST = eINSTANCE.getFeature_Inputlist();

    /**
     * The meta object literal for the '<em><b>Outputlist</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__OUTPUTLIST = eINSTANCE.getFeature_Outputlist();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.SPLImpl <em>SPL</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.SPLImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getSPL()
     * @generated
     */
    EClass SPL = eINSTANCE.getSPL();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPL__NAME = eINSTANCE.getSPL_Name();

    /**
     * The meta object literal for the '<em><b>Xors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPL__XORS = eINSTANCE.getSPL_Xors();

    /**
     * The meta object literal for the '<em><b>Ands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPL__ANDS = eINSTANCE.getSPL_Ands();

    /**
     * The meta object literal for the '<em><b>Ors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPL__ORS = eINSTANCE.getSPL_Ors();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.XORNodeImpl <em>XOR Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.XORNodeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getXORNode()
     * @generated
     */
    EClass XOR_NODE = eINSTANCE.getXORNode();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.AndNodeImpl <em>And Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.AndNodeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getAndNode()
     * @generated
     */
    EClass AND_NODE = eINSTANCE.getAndNode();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.OrNodeImpl <em>Or Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.OrNodeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getOrNode()
     * @generated
     */
    EClass OR_NODE = eINSTANCE.getOrNode();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.FeatureNodeImpl <em>Feature Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.FeatureNodeImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getFeatureNode()
     * @generated
     */
    EClass FEATURE_NODE = eINSTANCE.getFeatureNode();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_NODE__FEATURE = eINSTANCE.getFeatureNode_Feature();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_NODE__MULTIPLICITY = eINSTANCE.getFeatureNode_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Xors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_NODE__XORS = eINSTANCE.getFeatureNode_Xors();

    /**
     * The meta object literal for the '<em><b>Ands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_NODE__ANDS = eINSTANCE.getFeatureNode_Ands();

    /**
     * The meta object literal for the '<em><b>Ors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_NODE__ORS = eINSTANCE.getFeatureNode_Ors();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.EnumerationImpl <em>Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.EnumerationImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getEnumeration()
     * @generated
     */
    EClass ENUMERATION = eINSTANCE.getEnumeration();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATION__CONSTANT = eINSTANCE.getEnumeration_Constant();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.EnumConstImpl <em>Enum Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.EnumConstImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getEnumConst()
     * @generated
     */
    EClass ENUM_CONST = eINSTANCE.getEnumConst();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_CONST__NAME = eINSTANCE.getEnumConst_Name();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.StateImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Regions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__REGIONS = eINSTANCE.getState_Regions();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.RegionImpl <em>Region</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.RegionImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getRegion()
     * @generated
     */
    EClass REGION = eINSTANCE.getRegion();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGION__INIT = eINSTANCE.getRegion_Init();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGION__STATES = eINSTANCE.getRegion_States();

    /**
     * The meta object literal for the '{@link uw.cs.watform.forml.forml.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see uw.cs.watform.forml.forml.impl.VariableImpl
     * @see uw.cs.watform.forml.forml.impl.FormlPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

  }

} //FormlPackage
