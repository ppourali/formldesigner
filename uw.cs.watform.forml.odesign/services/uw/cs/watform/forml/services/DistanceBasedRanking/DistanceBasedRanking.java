package uw.cs.watform.forml.services.DistanceBasedRanking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.AttributeType;
import uw.cs.watform.forml.forml.BoolType;
import uw.cs.watform.forml.forml.EnumConst;
import uw.cs.watform.forml.forml.Enumeration;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.FeatureModule;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Input;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Output;
import uw.cs.watform.forml.forml.ReferenceType;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.atomic;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.services.utilities.ModelUtils2;
import uw.cs.watform.forml.ui.contentassist.FormlProposalProvider;

public class DistanceBasedRanking {

	// True or False or other constants
	private static final int prio_CatA_baseConstants = 2000;

	// self class attributes and functions
	private static final int prio_CatB_base = 1500;

	private static final int prio_baseAtts = 0;
	private static final int prio_baseFunctions = 1;

	private static FormlProposalProvider formlProposalProvider;

	public static void Rank(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, FormlProposalProvider formlPropProv) {

		formlProposalProvider = formlPropProv;

		Roleable self = EcoreUtil2.getContainerOfType(context.getCurrentModel(), FeatureModule.class).getFeatureref();

		CrossReference crossReference = ((CrossReference) assignment.getTerminal());
		ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
		if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
			EReference ref;
			if (containingParserRule.isWildcard()) {
// TODO we need better ctrl flow analysis here
// The cross reference may come from another parser rule then the current model
				ref = GrammarUtil.getReference(crossReference, context.getCurrentModel().eClass());
			} else {
				ref = GrammarUtil.getReference(crossReference);
			}
			if (ref != null) {
				Predicate<IEObjectDescription> filter = Predicates.<IEObjectDescription>alwaysTrue();
				String ruleName = null;
				if (crossReference.getTerminal() instanceof RuleCall) {
					ruleName = ((RuleCall) crossReference.getTerminal()).getRule().getName();
				}
				com.google.common.base.Function<IEObjectDescription, ICompletionProposal> proposalFactory = formlProposalProvider
						.getProposalFactory(ruleName, context);
				if (model != null) {
					IScope scope = formlProposalProvider.getScopeProvider().getScope(model, ref);

					com.google.common.base.Function<IEObjectDescription, ICompletionProposal> wrappedFactory = getWrappedFactory(
							model, ref, proposalFactory);
					Iterable<IEObjectDescription> candidates = queryScope(scope, model, ref, filter);
					for (IEObjectDescription candidate : candidates) {
						if (!acceptor.canAcceptMoreProposals())
							return;
						if (filter.apply(candidate)) {

							ICompletionProposal conpro = wrappedFactory.apply(candidate);

							if (conpro instanceof ConfigurableCompletionProposal) {
								if (candidate.getEObjectOrProxy() instanceof Message) {

									int distance = getDistance(candidate.getEObjectOrProxy(), self);

									int prio = distance - prio_baseFunctions;
									((ConfigurableCompletionProposal) conpro).setPriority(prio);

								} else if (candidate
										.getEObjectOrProxy() instanceof uw.cs.watform.forml.forml.Function) {

									int distance = getDistance(candidate.getEObjectOrProxy(), self);

									int prio = distance - prio_baseFunctions;
									((ConfigurableCompletionProposal) conpro).setPriority(prio);

								} else if (candidate.getEObjectOrProxy() instanceof Attribute) {

									int distance = getDistance(candidate.getEObjectOrProxy(), self);
									int prio = distance - prio_baseAtts;
									((ConfigurableCompletionProposal) conpro).setPriority(prio);

								} else if (candidate.getEObjectOrProxy() instanceof EnumConst) {
									int prioIfCorrectEnum = 0;
									EnumConst enumconst = (EnumConst) candidate.getEObjectOrProxy();
									AttributeType LHSType = getOtherSideTypeOfAGuard(context, acceptor);
									if (LHSType != null) {
										if (LHSType instanceof ReferenceType) {
											if ((ReferenceType.class.cast(LHSType)).getRef() instanceof Enumeration) {
												Enumeration enumClass = (Enumeration) ReferenceType.class.cast(LHSType)
														.getRef();
												if (enumClass != null
														&& enumClass == ModelUtils2.getEnumClass(enumconst)) {
													prioIfCorrectEnum = prio_CatA_baseConstants;
												}
											}
										}

									}

									int prio = prioIfCorrectEnum;
									((ConfigurableCompletionProposal) conpro).setPriority(prio);
								}

// System.out.println(
// conpro + " " + ((ConfigurableCompletionProposal) conpro).getPriority());
							}
// System.out.println(
// candidate.getEObjectOrProxy() + " " + ((ConfigurableCompletionProposal)
// conpro).getPriority());
							acceptor.accept(conpro);
						}
					}

				}

			}
		}

	}

	private static int getDistance(EObject eObjectOrProxy, Roleable self) {
		if (eObjectOrProxy.eContainer() instanceof Roleable) {
			Roleable r = (Roleable) eObjectOrProxy.eContainer();
			return findDistanceToSelf(self, r);
		}
		return 0;
	}

	private static int findDistanceToSelf(Roleable self, Roleable r) {
		if (self.equals(r))
			return prio_CatB_base - 0;
		else
			return ClassDiagramRelationsMap.getMinDistance(r, self);
	}

	private static com.google.common.base.Function<IEObjectDescription, ICompletionProposal> getWrappedFactory(
			EObject model, EReference reference,
			com.google.common.base.Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		return proposalFactory;
	}

	private static Iterable<IEObjectDescription> queryScope(IScope scope, EObject model, EReference reference,
			Predicate<IEObjectDescription> filter) {
		return scope.getAllElements();
	}

	public static int completeTrueOrFalseKeywords(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		uw.cs.watform.forml.forml.Guard guard = ModelUtils.getTypedRootForObject(contentAssistContext.getCurrentModel(),
				uw.cs.watform.forml.forml.Guard.class);

		if (guard != null) {
			List<atomic> atomicRef = ModelUtils.getObjectsByTypeInAnObjectElement(guard, atomic.class);
			if (atomicRef != null && !atomicRef.isEmpty()) {
				atomic atom = atomicRef.get(0);
				AttributeType otherSideType = null;
				otherSideType = getTypeOf(atom.getRef());
				if (otherSideType instanceof BoolType)
					return prio_CatA_baseConstants;

			}
		}

		return -1;

	}

	public static AttributeType getOtherSideTypeOfAGuard(ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		EObject parentHolder=null;
		if (contentAssistContext.getCurrentModel() instanceof Action) {
			parentHolder = ModelUtils.getTypedRootForObject(contentAssistContext.getCurrentModel(), Action.class);
		}
		else {
			parentHolder=ModelUtils.getTypedRootForObject(contentAssistContext.getCurrentModel(),
					uw.cs.watform.forml.forml.Guard.class);
		}
//		uw.cs.watform.forml.forml.Guard guard = ModelUtils.getTypedRootForObject(contentAssistContext.getCurrentModel(),
//				uw.cs.watform.forml.forml.Guard.class);

		if (parentHolder != null) {
			List<atomic> atomicRef = ModelUtils.getObjectsByTypeInAnObjectElement(parentHolder, atomic.class);
			if (atomicRef != null && !atomicRef.isEmpty()) {
				atomic atom = atomicRef.get(0);
				AttributeType otherSideType = null;
				otherSideType = getTypeOf(atom.getRef());
				if (otherSideType != null)
					return otherSideType;

			}
		}
		return null;
	}

	private static AttributeType getTypeOf(ExprRef ref) {
		if (ref instanceof Input) {
			return Input.class.cast(ref).getType();
		} else if (ref instanceof Output) {
			return Output.class.cast(ref).getType();
		} else if (ref instanceof Attribute) {
			return Attribute.class.cast(ref).getType();
		} else if (ref instanceof Function) {
			return Function.class.cast(ref).getType();
		}
		return null;
	}

}
