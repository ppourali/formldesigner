package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import java.io.IOException;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.merge.BatchMerger;
import org.eclipse.emf.compare.merge.IBatchMerger;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

import com.google.inject.Injector;

import uw.cs.watform.forml.extensions.PropertiesViewHelper;
import uw.cs.watform.forml.forml.Action;
import uw.cs.watform.forml.viewpoint.xtext.support.Activator;

public class AbstractEditorHelper {

	public EmbeddedEditor editor;
	public EmbeddedEditorModelAccess partialEditorModelAccess;
	public Resource originalResource;
	public XtextResource xTextResource;
	// public CLabel lblUserShiftEnter;
	// public CLabel lblSavedOrStillErroneous;
	public Injector injector;
	public int editorheight = 35;

	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {
		String[] parts = new String[3];

		try {
			String allText = rootNode.getText();

			ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

			String prefix = allText.substring(0, elementNode.getOffset() - 1);
			String editablePart = allText.substring(elementNode.getOffset(), elementNode.getEndOffset());

			String suffix = allText.substring(elementNode.getEndOffset());

			parts[0] = prefix;
			parts[1] = editablePart;
			parts[2] = suffix;
		} catch (Exception e) {
			parts[0] = "";
			parts[1] = "[]";
			parts[2] = "";
		}
		return parts;
	}

	public void addKeyVerifyListener() {
		final StyledText xtextTextWidget = editor.getViewer().getTextWidget();
		xtextTextWidget.addVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent e) {
				int keyCode = e.keyCode;
				// if ((e.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode
				// == SWT.CR))) {
				if ((e.stateMask & SWT.SHIFT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					e.doit = false;
					saveEditor(true);
				}
				// if (keyCode == SWT.ESC) {
				if ((e.stateMask & SWT.SHIFT) != 0 && keyCode == SWT.ESC) {
					e.doit = false;
					saveEditor(false);
				}

			}
		});
	}

	

	/**
	 * Close this editor.
	 * 
	 * @param isReconcile
	 */
	public void saveEditor(boolean isReconcile) {
		if (partialEditorModelAccess != null) {
			if (isReconcile) {
				try {
					updateXtextResource();
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}

		}
	}

	protected void updateXtextResource() throws IOException, BadLocationException {
		String newText = partialEditorModelAccess.getSerializedModel();
		xTextResource.reparse(newText);
		EcoreUtil.resolveAll(xTextResource);
		final IParseResult parseResult = xTextResource.getParseResult();
		if (!parseResult.hasSyntaxErrors() && !hasDanglingRefs(xTextResource)) {
			if (reconcile(originalResource, xTextResource)) {
				PropertiesViewHelper.setStatusLabel(true, Action.class);
			} else {
				PropertiesViewHelper.setStatusLabel(false, Action.class);
			}
		} else {
			PropertiesViewHelper.setStatusLabel(false, Action.class);
		}
	}

	private boolean hasDanglingRefs(XtextResource xtextResource2) {
		return EcoreUtil.UnresolvedProxyCrossReferencer.find(xtextResource2).size() > 0;
	}

	private boolean reconcile(Resource resourceInSirius, XtextResource resourceInEmbeddedEditor) {
		try {

			IComparisonScope scope = new DefaultComparisonScope(resourceInSirius, resourceInEmbeddedEditor, null);
			final Comparison comparison = EMFCompare.builder().build().compare(scope);

			IMerger.Registry mergerRegistry = EMFCompareRCPPlugin.getDefault().getMergerRegistry();
			final IBatchMerger merger = new BatchMerger(mergerRegistry);

			// IXtextDocument xTextDoc = editor.getDocument();
			//
			// xTextDoc.modify(new IUnitOfWork.Void<XtextResource>() {
			//
			// @Override
			// public void process(XtextResource state) throws Exception {
			// merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());
			// System.out.println("wnet");
			// }
			// });

			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(originalResource);
			editingDomain.getCommandStack()
					.execute(new RecordingCommand(editingDomain, "update resource after direct text edit") {

						@Override
						protected void doExecute() {

							merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());

							// resourceInSirius.getContents().set(0,
							// EcoreUtil.copy(resourceInEmbeddedEditor.getContents().get(0)));

							// merger.copyAllRightToLeft(comparison.getDifferences(), new BasicMonitor());

						}
					});

			// resourceInSirius.save(SaveOptions.defaultOptions().toOptionsMap());

		} catch (Exception e) {
			Activator.logError(e);
			return false;
		}

		return true;
	}

}
