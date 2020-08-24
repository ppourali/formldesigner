/******************************************************************************
 * Copyright (c) 2011 Obeo  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo  - initial API and implementation
 ****************************************************************************/

package uw.cs.watform.forml.viewpoint.xtext.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import javax.swing.JOptionPane;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

import uw.cs.watform.forml.forml.Transition;
import uw.cs.watform.forml.forml.WCAList;

/* largely inspired by "org.eclipse.xtext.gmf.glue" from XText examples */
public class XtextEmbeddedEditorForWCA extends AbstractXtextEmbeddedEditor{


	public XtextEmbeddedEditorForWCA(IGraphicalEditPart editPart,
			Injector xtextInjector) {
		super(editPart, xtextInjector);
	}


	public void showEditor(EObject originalelem, DiagramEditPart diagramEditPart, Composite referenceCompsiteOnShell, int numberOdActions) 
	{
		super.showEditor(originalelem, diagramEditPart, referenceCompsiteOnShell);
		xtextEditorComposite.update();
		//double oldWidth=((Point)xtextEditorComposite.getSize()).x;
		xtextEditorComposite.pack();
		//xtextEditorComposite.setSize(220, numberOdActions*57);

	};

	@Override
	protected String[] findPartsForNode(ICompositeNode rootNode, EObject semanticElementInDocument) {

		String[] parts = new String[3];

		String allText = rootNode.getText();
		ICompositeNode elementNode = NodeModelUtils.findActualNodeFor((semanticElementInDocument));

		String prefix = allText.substring(0, elementNode.getOffset() +1);
		String editablePart = allText.substring(elementNode.getOffset()+1, elementNode.getEndOffset());

		String suffix = allText.substring(elementNode.getEndOffset());

		parts[0] = prefix;
		parts[1] = editablePart;
		parts[2] = suffix;

		//return parts;
		
//		String[] parts = new String[3];
//		
//		String allText = rootNode.getText();
//		ICompositeNode elementNode = NodeModelUtils
//				.findActualNodeFor((semanticElementInDocument));
//
//		int startIndex=allText.lastIndexOf("/", elementNode.getOffset())+1;
//		//int endIndex=elementNode.getEndOffset()-1;
//
//		String prefix = allText.substring(0, startIndex -1);
//		String editablePart = allText.substring(startIndex-1,
//				startIndex-1);
//
//		String suffix =  allText.substring(startIndex);
//
//
//		parts[0] = prefix;
//		parts[1] = editablePart;
//		parts[2] = suffix;

		return parts;
	}


}
