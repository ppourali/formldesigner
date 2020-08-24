/*
 * generated by Xtext
 */
package uw.cs.watform.forml.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import uw.cs.watform.forml.services.FormlGrammarAccess;

@SuppressWarnings("all")
public class FormlSyntacticSequencer extends AbstractSyntacticSequencer {

	protected FormlGrammarAccess grammarAccess;
	protected AbstractElementAlias match_BoolType_IntType_StringType_BooleanKeyword_1_or_IntegerKeyword_1_or_StringKeyword_1;
	protected AbstractElementAlias match_Entity_AbstractKeyword_1_q;
	protected AbstractElementAlias match_Entity___LeftCurlyBracketKeyword_6_0_RightCurlyBracketKeyword_6_3__q;
	protected AbstractElementAlias match_FeatureNode___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q;
	protected AbstractElementAlias match_Feature___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q;
	protected AbstractElementAlias match_Guard_LeftSquareBracketRightSquareBracketKeyword_1_1_or___LeftSquareBracketKeyword_1_0_0_RightSquareBracketKeyword_1_0_2__;
	protected AbstractElementAlias match_Input_ToKeyword_6_0_q;
	protected AbstractElementAlias match_Output_FromKeyword_6_0_q;
	protected AbstractElementAlias match_TranFragment_SolidusKeyword_6_0_q;
	protected AbstractElementAlias match_atomic_PreKeyword_1_1_q;
	protected AbstractElementAlias match_atomic_PreKeyword_2_2_q;
	protected AbstractElementAlias match_unspecified_PreKeyword_2_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (FormlGrammarAccess) access;
		match_BoolType_IntType_StringType_BooleanKeyword_1_or_IntegerKeyword_1_or_StringKeyword_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getBoolTypeAccess().getBooleanKeyword_1()), new TokenAlias(false, false, grammarAccess.getIntTypeAccess().getIntegerKeyword_1()), new TokenAlias(false, false, grammarAccess.getStringTypeAccess().getStringKeyword_1()));
		match_Entity_AbstractKeyword_1_q = new TokenAlias(false, true, grammarAccess.getEntityAccess().getAbstractKeyword_1());
		match_Entity___LeftCurlyBracketKeyword_6_0_RightCurlyBracketKeyword_6_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_6_3()));
		match_FeatureNode___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFeatureNodeAccess().getLeftCurlyBracketKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getFeatureNodeAccess().getRightCurlyBracketKeyword_4_2()));
		match_Feature___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_3_2()));
		match_Guard_LeftSquareBracketRightSquareBracketKeyword_1_1_or___LeftSquareBracketKeyword_1_0_0_RightSquareBracketKeyword_1_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getGuardAccess().getLeftSquareBracketKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getGuardAccess().getRightSquareBracketKeyword_1_0_2())), new TokenAlias(false, false, grammarAccess.getGuardAccess().getLeftSquareBracketRightSquareBracketKeyword_1_1()));
		match_Input_ToKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getInputAccess().getToKeyword_6_0());
		match_Output_FromKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getOutputAccess().getFromKeyword_6_0());
		match_TranFragment_SolidusKeyword_6_0_q = new TokenAlias(false, true, grammarAccess.getTranFragmentAccess().getSolidusKeyword_6_0());
		match_atomic_PreKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getAtomicAccess().getPreKeyword_1_1());
		match_atomic_PreKeyword_2_2_q = new TokenAlias(false, true, grammarAccess.getAtomicAccess().getPreKeyword_2_2());
		match_unspecified_PreKeyword_2_q = new TokenAlias(false, true, grammarAccess.getUnspecifiedAccess().getPreKeyword_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_BoolType_IntType_StringType_BooleanKeyword_1_or_IntegerKeyword_1_or_StringKeyword_1.equals(syntax))
				emit_BoolType_IntType_StringType_BooleanKeyword_1_or_IntegerKeyword_1_or_StringKeyword_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Entity_AbstractKeyword_1_q.equals(syntax))
				emit_Entity_AbstractKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Entity___LeftCurlyBracketKeyword_6_0_RightCurlyBracketKeyword_6_3__q.equals(syntax))
				emit_Entity___LeftCurlyBracketKeyword_6_0_RightCurlyBracketKeyword_6_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_FeatureNode___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q.equals(syntax))
				emit_FeatureNode___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Feature___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q.equals(syntax))
				emit_Feature___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Guard_LeftSquareBracketRightSquareBracketKeyword_1_1_or___LeftSquareBracketKeyword_1_0_0_RightSquareBracketKeyword_1_0_2__.equals(syntax))
				emit_Guard_LeftSquareBracketRightSquareBracketKeyword_1_1_or___LeftSquareBracketKeyword_1_0_0_RightSquareBracketKeyword_1_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Input_ToKeyword_6_0_q.equals(syntax))
				emit_Input_ToKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Output_FromKeyword_6_0_q.equals(syntax))
				emit_Output_FromKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TranFragment_SolidusKeyword_6_0_q.equals(syntax))
				emit_TranFragment_SolidusKeyword_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_atomic_PreKeyword_1_1_q.equals(syntax))
				emit_atomic_PreKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_atomic_PreKeyword_2_2_q.equals(syntax))
				emit_atomic_PreKeyword_2_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_unspecified_PreKeyword_2_q.equals(syntax))
				emit_unspecified_PreKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'String' | 'Integer' | 'Boolean'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_BoolType_IntType_StringType_BooleanKeyword_1_or_IntegerKeyword_1_or_StringKeyword_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'abstract'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'entity' name=ID
	 *     (rule start) (ambiguity) ctrl?='ctrl'
	 */
	protected void emit_Entity_AbstractKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 *     superType=[Entity|ID] (ambiguity) (rule end)
	 */
	protected void emit_Entity___LeftCurlyBracketKeyword_6_0_RightCurlyBracketKeyword_6_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     feature=[Feature|ID] (ambiguity) (rule end)
	 *     multiplicity=Multiplicity ']' (ambiguity) (rule end)
	 */
	protected void emit_FeatureNode___LeftCurlyBracketKeyword_4_0_RightCurlyBracketKeyword_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) (rule end)
	 */
	protected void emit_Feature___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('[' ']') | '[]'
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 */
	protected void emit_Guard_LeftSquareBracketRightSquareBracketKeyword_1_1_or___LeftSquareBracketKeyword_1_0_0_RightSquareBracketKeyword_1_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'to'?
	 *
	 * This ambiguous syntax occurs at:
	 *     attributes+=Attribute (ambiguity) '}' (rule end)
	 *     name=ID '{' (ambiguity) '}' (rule end)
	 *     type=AttributeType (ambiguity) '}' (rule end)
	 */
	protected void emit_Input_ToKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'from'?
	 *
	 * This ambiguous syntax occurs at:
	 *     attributes+=Attribute (ambiguity) '}' (rule end)
	 *     name=ID '{' (ambiguity) '}' (rule end)
	 *     type=AttributeType (ambiguity) '}' (rule end)
	 */
	protected void emit_Output_FromKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '/'?
	 *
	 * This ambiguous syntax occurs at:
	 *     fragType=Guard (ambiguity) '}' (rule end)
	 */
	protected void emit_TranFragment_SolidusKeyword_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '@pre'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ref=[ExprRef|QualifiedName] (ambiguity) (rule end)
	 */
	protected void emit_atomic_PreKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '@pre'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refs=[ExprRef|QualifiedName] 's' (ambiguity) (rule end)
	 */
	protected void emit_atomic_PreKeyword_2_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '@pre'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ref=[ExprRef|ID] '()' (ambiguity) (rule end)
	 */
	protected void emit_unspecified_PreKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}