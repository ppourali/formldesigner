package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorActions;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory.Builder;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class CustomEmbeddedEditorBuilder extends Builder {

    private static final String FG_COLOR_KEY = AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR;
    private static final String BG_COLOR_KEY = AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND;
    private static final String USE_DEFAULT_BG_KEY = AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT;

    @Inject(optional = true)
    private AnnotationPainter.IDrawingStrategy projectionAnnotationDrawingStrategy;

    @Inject
    private CustomEmbeddedEditorFoldingStructureProvider foldingStructureProvider;
    private IAnnotationAccess fAnnotationAccess;

    protected IAnnotationAccess createAnnotationAccess() {
        return new DefaultMarkerAnnotationAccess() {

            @Override
            public int getLayer(Annotation annotation) {
                if (annotation.isMarkedDeleted()) {
                    return IAnnotationAccessExtension.DEFAULT_LAYER;
                }
                return super.getLayer(annotation);
            }
        };
    }

    protected IAnnotationAccess getAnnotationAccess() {
        if (fAnnotationAccess == null) {
            fAnnotationAccess = createAnnotationAccess();
        }
        return fAnnotationAccess;
    }

    @Override
    protected ISharedTextColors getSharedColors() {
        return EditorsPlugin.getDefault().getSharedTextColors();
    }

    protected ProjectionSupport installProjectionSupport(EmbeddedEditor e, ProjectionViewer projectionViewer) {
        ProjectionSupport projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
        projectionSupport.setAnnotationPainterDrawingStrategy(projectionAnnotationDrawingStrategy);
        projectionSupport.install();
        return projectionSupport;
    }

    @Override
    public EmbeddedEditor withParent(final Composite parent) {
        if (editorBuild) {
            throw new IllegalStateException();
        }
        editorBuild = true;
        // /*fProjectionSupport =*/installProjectionSupport(this.fSourceViewer);
        final CompositeRuler annotationRuler;
        if (annotationTypes != null && annotationTypes.length != 0) {
            annotationRuler = new CompositeRuler();
        } else {
            annotationRuler = null;
        }
        final XtextSourceViewer viewer = this.sourceViewerFactory.createSourceViewer(parent, annotationRuler, null, // overviewRuler
                false, // showAnnotationOverview
                SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        final XtextSourceViewerConfiguration viewerConfiguration = this.sourceViewerConfigurationProvider.get();
        viewer.configure(viewerConfiguration);

        // Configuring default font
        StyledText textWidget = viewer.getTextWidget();
        textWidget.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));

        // squiggles for markers and other decorations
        final SourceViewerDecorationSupport viewerDecorationSupport = new SourceViewerDecorationSupport(viewer, null, // overviewRuler
                getAnnotationAccess(), getSharedColors());

        MarkerAnnotationPreferences annotationPreferences = new MarkerAnnotationPreferences();
        Iterator<AnnotationPreference> e = Iterators.filter(annotationPreferences.getAnnotationPreferences().iterator(), AnnotationPreference.class);
        while (e.hasNext()) {
            viewerDecorationSupport.setAnnotationPreference(e.next());
        }
        if (characterPairMatcher != null) {
            viewerDecorationSupport.setCharacterPairMatcher(characterPairMatcher);
            viewerDecorationSupport.setMatchingCharacterPainterPreferenceKeys(BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY, BracketMatchingPreferencesInitializer.COLOR_KEY);
        }
        viewerDecorationSupport.install(this.preferenceStoreAccess.getPreferenceStore());

        final XtextDocument document = this.documentProvider.get();
        IDocumentPartitioner partitioner = this.documentPartitionerProvider.get();
        partitioner.connect(document);
        document.setDocumentPartitioner(partitioner);

        final EmbeddedEditorActions actions = initializeActions(viewer);
        parent.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                viewerDecorationSupport.dispose();
                highlightingHelper.uninstall();
            }
        });

        viewer.setEditable(!Boolean.TRUE.equals(readonly));
        viewer.getContentAssistantFacade().addCompletionListener(new ICompletionListener() {

            private Button defaultButton;

            @Override
            public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
            }

            @Override
            public void assistSessionStarted(ContentAssistEvent event) {
                defaultButton = parent.getShell().getDefaultButton();
                parent.getShell().setDefaultButton(null);
            }

            @Override
            public void assistSessionEnded(ContentAssistEvent event) {
                parent.getShell().setDefaultButton(defaultButton);
                defaultButton = null;
            }
        });
        final ValidationJob job = new ValidationJob(this.resourceValidator, document, new IValidationIssueProcessor() {

            private AnnotationIssueProcessor annotationIssueProcessor;

            @Override
            public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
                IValidationIssueProcessor issueProcessor = CustomEmbeddedEditorBuilder.this.issueProcessor;
                if (issueProcessor != null) {
                    issueProcessor.processIssues(issues, monitor);
                }
                IAnnotationModel annotationModel = viewer.getAnnotationModel();
                if (annotationModel != null) {
                    if (this.annotationIssueProcessor == null) {
                        this.annotationIssueProcessor = new AnnotationIssueProcessor(document, annotationModel, new IssueResolutionProvider() {

                            @Override
                            public boolean hasResolutionFor(String issueCode) {
                                return issueResolutionProvider.hasResolutionFor(issueCode);
                            }

                            @Override
                            public List<IssueResolution> getResolutions(Issue issue) {
                                List<IssueResolution> resolutions = issueResolutionProvider.getResolutions(issue);
                                List<IssueResolution> result = Lists.transform(resolutions, new Function<IssueResolution, IssueResolution>() {

                                    @Override
                                    public IssueResolution apply(final IssueResolution input) {
                                        IssueResolution result = new IssueResolution(input.getLabel(), input.getDescription(), input.getImage(), new IModificationContext() {
											
								

                                            @Override
                                            public IXtextDocument getXtextDocument(URI uri) {
                                                if (uri.trimFragment().equals(document.getResourceURI())) {
                                                    return document;
                                                }
                                                return input.getModificationContext().getXtextDocument(uri);
                                            }

                                            @Override
                                            public IXtextDocument getXtextDocument() {
                                                IModificationContext original = input.getModificationContext();
                                                if (original instanceof IssueModificationContext) {
                                                    URI uri = ((IssueModificationContext) original).getIssue().getUriToProblem();
                                                    return getXtextDocument(uri);
                                                }
                                                return original.getXtextDocument();
                                            }
                                        }, input.getModification());
                                        return result;
                                    }
                                });
                                return result;
                            }

                        });
                    }
                    if (this.annotationIssueProcessor != null) {
                        this.annotationIssueProcessor.processIssues(issues, monitor);
                    }
                }
            }
        }, CheckMode.FAST_ONLY);
        document.setValidationJob(job);

        final EmbeddedEditor result = new CustomEmbeddedEditor(document, viewer, viewerConfiguration, resourceProvider, new Runnable() {

            @Override
            public void run() {
                afterCreatePartialEditor(viewer, document, annotationRuler, actions);
                highlightingHelper.install(viewerConfiguration, viewer);

                // Adding line number
                LineNumberRulerColumn lineNumberColumn = new LineNumberRulerColumn();
                updateForegroundColor(preferenceStoreAccess.getPreferenceStore(), lineNumberColumn);
                updateBackgroundColor(preferenceStoreAccess.getPreferenceStore(), lineNumberColumn);
                annotationRuler.addDecorator(2, lineNumberColumn);

                // Changing color background for error/information marker
                Iterator decoratorIterator = annotationRuler.getDecoratorIterator();
                while (decoratorIterator.hasNext()) {
                    Object next = decoratorIterator.next();
                    if (next instanceof AnnotationRulerColumn) {
                        AnnotationRulerColumn annotationRulerColumn = (AnnotationRulerColumn) next;
                        annotationRulerColumn.getControl().setBackground(getSharedColors().getColor(new RGB(236, 237, 236)));

                    }
                }

                viewer.doOperation(ProjectionViewer.TOGGLE);
                job.schedule();
            }
        }) {

            @Override
            public Optional<IAction> getAction(String actionId) {
                if (actions instanceof CustomEmbeddedEditorActions) {
                    return Optional.fromNullable(((CustomEmbeddedEditorActions) actions).getAction(ITextEditorActionConstants.FIND));
                }
                return Optional.absent();
            }

            @Override
            public void cleanDisposeListener() {
                if (actions instanceof CustomEmbeddedEditorActions) {
                    ((CustomEmbeddedEditorActions) actions).cleanDisposeListener();
                }
            }
        };

        Control control = viewer.getControl();
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        control.setLayoutData(data);

        installProjectionSupport(result, viewer);
        foldingStructureProvider.install(result, viewer);

        return result;
    }

    private void updateForegroundColor(IPreferenceStore store, IVerticalRulerColumn column) {
        RGB rgb = getColorFromStore(store, FG_COLOR_KEY);
        if (rgb == null) {
            rgb = new RGB(0, 0, 0);
        }
        ISharedTextColors sharedColors = getSharedColors();
        if (column instanceof LineNumberRulerColumn) {
            ((LineNumberRulerColumn) column).setForeground(sharedColors.getColor(rgb));
        }
    }

    private void updateBackgroundColor(IPreferenceStore store, IVerticalRulerColumn column) {
        // background color: same as editor, or system default
        RGB rgb;
        if (store.getBoolean(USE_DEFAULT_BG_KEY)) {
            rgb = null;
        } else {
            rgb = getColorFromStore(store, BG_COLOR_KEY);
        }
        ISharedTextColors sharedColors = getSharedColors();
        if (column instanceof LineNumberRulerColumn) {
            ((LineNumberRulerColumn) column).setBackground(sharedColors.getColor(rgb));
        }
    }

    private static RGB getColorFromStore(IPreferenceStore store, String key) {
        RGB rgb = null;
        if (store.contains(key)) {
            if (store.isDefault(key)) {
                rgb = PreferenceConverter.getDefaultColor(store, key);
            } else {
                rgb = PreferenceConverter.getColor(store, key);
            }
        }
        return rgb;
    }
}
