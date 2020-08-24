package uw.cs.watform.forml.extensions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.internal.Model;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer.State;
import org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory.StatefulFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;
import com.google.inject.Provider;

import uw.cs.watform.forml.FormlStandaloneSetup;
import uw.cs.watform.forml.extensions.ViewPart_PropertyEditor.TransitionRuleParser;
import uw.cs.watform.forml.formatting.customFormlFormatter;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.parser.antlr.FormlParser;
import uw.cs.watform.forml.services.FormlGrammarAccess;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import uw.cs.watform.forml.ui.contentassist.antlr.PartialFormlContentAssistParser;
import uw.cs.watform.forml.viewpoint.xtext.support.XtextEmbeddedEditorForPropertyEditor;

@SuppressWarnings({ "restriction", "restriction", "restriction" })

public class ViewPart_PropertyEditor extends ViewPart {

	private Composite allControlsContainer;
	public Composite parentComp;

	public Composite transitionComposite;

	@Inject
	EmbeddedEditorFactory embeddedEditorFactory;

	@Inject
	PartialEditingContentAssistContextFactory fac;

	@Inject
	private Provider<StatefulFactory> statefulFactoryProvider;

	public Provider<? extends StatefulFactory> getStatefulFactoryProvider() {
		return statefulFactoryProvider;
	}

	private EmbeddedEditor withParent;

	@Inject
	FormlGrammarAccess ga;

	@Inject
	Provider<XtextResourceSet> rsp;

	public ViewPart_PropertyEditor() {

		fac = new PartialEditingContentAssistContextFactory();
		// fac.setPartialEditingParser((IPartialEditingContentAssistParser) new
		// PartialFormlContentAssistParser());

		rsp = new Provider<XtextResourceSet>() {

			@Override
			public XtextResourceSet get() {
				// TODO Auto-generated method stub
				new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
				Injector injector = new FormlStandaloneSetup().createInjectorAndDoEMFRegistration();
				XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
				resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

				return resourceSet;
			}
		};

		parserProvider = new Provider<ViewPart_PropertyEditor.TransitionRuleParser>() {

			@Override
			public TransitionRuleParser get() {
				TransitionRuleParser tr = new TransitionRuleParser();
				return tr;
			}
		};
	}

	static class TransitionRuleParser extends FormlParser {
		@Override
		protected String getDefaultRuleName() {
			return "Transition";
		}
	}

	@Inject
	Provider<TransitionRuleParser> parserProvider;

	@Override
	public void createPartControl(Composite parent) {

		parentComp = parent;

		allControlsContainer = new Composite(parentComp, SWT.NONE);
		allControlsContainer.setLayout(new GridLayout(1, false));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite_1.heightHint = 120;
		gd_composite_1.widthHint = 500;
		allControlsContainer.setLayoutData(gd_composite_1);

		// transitionComposite = new Composite(parent, SWT.BORDER);

		// for(Control child:parent.getChildren())
		// {
		// child.dispose();
		// child=null;
		// }
		//
		// embeddedEditorFactory =
		// ModelUtils.getInjector().getInstance(EmbeddedEditorFactory.class);
		// IEditedResourceProvider resourceProvider = new
		// IEditedResourceProvider() {
		//
		// @Override
		// public XtextResource createResource() {
		// XtextResourceSet rs = rsp.get();
		// XtextResource xtextResource = (XtextResource)
		// rs.getResource(URI.createURI("platform:/resource/test/my.forml"),
		// true);
		// xtextResource.setParser(parserProvider.get());
		//
		// String
		// semanticElementFragment="//@behaviourmodel/@featuremodules.0/@statemachine.0/@transitions.0";
		// EObject semanticElementInDocument =
		// xtextResource.getEObject(semanticElementFragment);
		//
		// return xtextResource;
		//
		//
		//// new
		// org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		//// Injector injector = new
		// FormlStandaloneSetup().createInjectorAndDoEMFRegistration();
		//// XtextResourceSet resourceSet =
		// injector.getInstance(XtextResourceSet.class);
		//// resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
		// Boolean.TRUE);
		//// XtextResource resource = (XtextResource)
		// resourceSet.getResource(URI.createURI("platform:/resource/DEMO_AutoSoft/autosoft.forml"),
		// true);
		////
		////
		//// return resource;
		// }
		// };
		// withParent =
		// embeddedEditorFactory.newEditor(resourceProvider).showErrorAndWarningAnnotations().withParent(parent);
		// XtextSourceViewer viewer = withParent.getViewer();
		// IContentAssistProcessor contentAssistProcessor =
		// ((XtextSourceViewer)viewer).getContentAssistant().getContentAssistProcessor("__string");
		// if (contentAssistProcessor instanceof Transition) {
		//
		// //fac.initializeFor(ga.getTransitionRule());
		// //((IPartialEditingContentAssistContextFactory)((State)contentAssistProcessor).getContextFactory()).initializeFor(ga.getTransitionRule());
		//
		// }
		//
		//
		//
		// withParent.createPartialEditor();
	}

	// public void in(Transition trans)
	// {
	// for(Control child:parentComp.getChildren())
	// {
	// child.dispose();
	// child=null;
	// }
	//
	// embeddedEditorFactory =
	// ModelUtils.getInjector().getInstance(EmbeddedEditorFactory.class);
	// IEditedResourceProvider resourceProvider = new IEditedResourceProvider()
	// {
	//
	// @Override
	// public XtextResource createResource() {
	// XtextResourceSet rs = rsp.get();
	// XtextResource xtextResource = (XtextResource)
	// rs.getResource(URI.createURI("platform:/resource/test/my.forml"), true);
	// xtextResource.setParser(parserProvider.get());
	//
	// String
	// semanticElementFragment="//@behaviourmodel/@featuremodules.0/@statemachine.0/@transitions.0";
	// EObject semanticElementInDocument =
	// xtextResource.getEObject(semanticElementFragment);
	//
	// return xtextResource;
	//
	//
	//// new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
	//// Injector injector = new
	// FormlStandaloneSetup().createInjectorAndDoEMFRegistration();
	//// XtextResourceSet resourceSet =
	// injector.getInstance(XtextResourceSet.class);
	//// resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
	// Boolean.TRUE);
	//// XtextResource resource = (XtextResource)
	// resourceSet.getResource(URI.createURI("platform:/resource/DEMO_AutoSoft/autosoft.forml"),
	// true);
	////
	////
	//// return resource;
	// }
	// };
	// withParent =
	// embeddedEditorFactory.newEditor(resourceProvider).showErrorAndWarningAnnotations().withParent(parentComp);
	// XtextSourceViewer viewer = withParent.getViewer();
	// IContentAssistProcessor contentAssistProcessor =
	// ((XtextSourceViewer)viewer).getContentAssistant().getContentAssistProcessor("__string");
	// if (contentAssistProcessor instanceof Transition) {
	//
	// //fac.initializeFor(ga.getTransitionRule());
	// //((IPartialEditingContentAssistContextFactory)((State)contentAssistProcessor).getContextFactory()).initializeFor(ga.getTransitionRule());
	//
	// }
	//
	//
	// withParent.createPartialEditor();
	// withParent.getViewer().getControl().pack();
	// withParent.getViewer().getTextWidget().pack();
	// }

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void clearChildren() {
		try {
			if (parentComp != null) {
				for (Control c : this.allControlsContainer.getChildren()) {
					if (c != null) {
						c.dispose();
						c = null;
					}
				}
			}
		} catch (Exception e) {

		}
	}

	public void createTransitionViewer(Transition trans) {

		clearChildren();

		// Create Editor For the Whole Transition
		XtextEmbeddedEditorForPropertyEditor transition_embeddedEditor = new XtextEmbeddedEditorForPropertyEditor(
				ModelUtils.getInjector());

		transitionComposite = new Composite(allControlsContainer, SWT.BORDER);

		transition_embeddedEditor.showEditor(trans, transitionComposite);

		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_2.widthHint = 500;
		gd_composite_2.heightHint = 100;
		transitionComposite.setLayoutData(gd_composite_2);

		CLabel lblNote = new CLabel(allControlsContainer, SWT.NONE);
		GridData gd_lblNote = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblNote.heightHint = 16;
		lblNote.setLayoutData(gd_lblNote);
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNote.setText("Please use Shift+Enter to save the modifications in the embedder.");
		lblNote.pack();

		transitionComposite.pack();
		transitionComposite.setSize(500, 100);

		allControlsContainer.pack();
		allControlsContainer.setSize(520, 140);
	}

	public void createMessageViewer(Message msg) {

		clearChildren();

		// Create Editor For the Whole Transition
		XtextEmbeddedEditorForPropertyEditor transition_embeddedEditor = new XtextEmbeddedEditorForPropertyEditor(
				ModelUtils.getInjector());

		transitionComposite = new Composite(allControlsContainer, SWT.BORDER);

		transition_embeddedEditor.showEditor(msg, transitionComposite);

		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_2.widthHint = 500;
		gd_composite_2.heightHint = 100;
		transitionComposite.setLayoutData(gd_composite_2);

		CLabel lblNote = new CLabel(allControlsContainer, SWT.NONE);
		GridData gd_lblNote = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_lblNote.heightHint = 16;
		lblNote.setLayoutData(gd_lblNote);
		lblNote.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNote.setText("Please use Shift+Enter to save the modifications in the embedder.");
		lblNote.pack();

		transitionComposite.pack();
		transitionComposite.setSize(500, 100);

		allControlsContainer.pack();
		allControlsContainer.setSize(520, 140);

	}

}
