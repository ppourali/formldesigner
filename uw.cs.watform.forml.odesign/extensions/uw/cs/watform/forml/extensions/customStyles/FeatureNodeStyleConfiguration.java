package uw.cs.watform.forml.extensions.customStyles;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.ResizeKind;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.BorderItemLocatorProvider;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.DefaultBorderItemLocatorProvider;
import org.eclipse.sirius.diagram.ui.tools.api.graphical.edit.styles.StyleConfiguration;
import org.eclipse.sirius.ext.gmf.runtime.gef.ui.figures.SiriusWrapLabel;
import org.eclipse.sirius.ext.gmf.runtime.gef.ui.figures.util.AnchorProvider;
import org.eclipse.swt.graphics.Image;

public class FeatureNodeStyleConfiguration implements StyleConfiguration {

	@Override
	public void adaptNodeLabel(DNode node, SiriusWrapLabel nodeLabel) {
		if (nodeLabel.getParent() != null) {
			Rectangle constraint = nodeLabel.getParent().getBounds().getCopy();

			Insets borderDimension = this.getBorderDimension(node);
			constraint.height -= (borderDimension.top + borderDimension.bottom);
			constraint.width -= (borderDimension.left + borderDimension.right);
			constraint.x += borderDimension.left;
			constraint.y += borderDimension.top;

			nodeLabel.setBounds(constraint);
			nodeLabel.getParent().setConstraint(nodeLabel, constraint);
		}
	}

	@Override
	public BorderItemLocatorProvider getBorderItemLocatorProvider() {
		return DefaultBorderItemLocatorProvider.getInstance();
	}

	@Override
	public IBorderItemLocator getNameBorderItemLocator(DNode node, IFigure mainFigure) {
		
		BorderItemLocator locator = new BorderItemLocator(mainFigure, PositionConstants.WEST);
		locator.setBorderItemOffset(new Dimension(1, 1));
		return locator;
	}

	@Override
	public int adaptViewNodeSizeWithLabel(DNode viewNode, SiriusWrapLabel nodeLabel, int nodeWidth) {
		if (viewNode.getResizeKind() != ResizeKind.NONE_LITERAL) {

		}
		return nodeWidth;
	}

	@Override
	public AnchorProvider getAnchorProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getLabelIcon(DDiagramElement vpElement, IGraphicalEditPart editPart) {
//		EObject target = vpElement;
//        if (vpElement instanceof DSemanticDecorator) {
//            target = ((DSemanticDecorator) vpElement).getTarget();
//        }
//        if (isShowIcon(vpElement)) {
//            if (target != null) {
//                IItemLabelProvider labelProvider = (IItemLabelProvider) SiriusDiagramEditorPlugin.getInstance()
//                		.getItemProvidersAdapterFactory().adapt(target, IItemLabelProvider.class);
//                if (labelProvider != null) {
//                    ImageDescriptor descriptor = ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(target));
//                    if (descriptor == null) {
//                        descriptor = ImageDescriptor.getMissingImageDescriptor();
//                    }
//                    return SiriusDiagramEditorPlugin.getInstance().getImage(descriptor);
//                }
//            }
//        }
        return null;
	}

	@Override
	public Dimension fitToText(DNode node, SiriusWrapLabel nodeLabel, DefaultSizeNodeFigure defaultSizeNodeFigure) {
		 if (nodeLabel.getFont() != null) {
	            String text = node.getName();

	            int charHeight = FigureUtilities.getStringExtents("ABCDEF", nodeLabel.getFont()).height + 5;
	            int charWidth = FigureUtilities.getTextWidth("ABCDEFGHIJKLMNOPQRSTUVWXYZ", nodeLabel.getFont()) / 26;

	            double ratio = charHeight / charWidth;

	            int nbLines = (int) (Math.sqrt(text.length()) / ratio) + 1;
	            int nbCols = (int) (Math.sqrt(text.length()) * ratio) + 1;

	            int longestWord = this.getTheLongestWord(text.split("\\s"));
	            nbCols = Math.max(nbCols, longestWord);

	            int hHeight = nbLines * charHeight;
	            int hWidth = nbCols * charWidth;

	            Dimension size = nodeLabel.getPreferredSize(hWidth + nodeLabel.getIconBounds().width +
	            		nodeLabel.getIconTextGap(), hHeight).getCopy();

	            size.width += 20;
	            size.height += 30;

	            Insets borderDimension = this.getBorderDimension(node);
	            size.width += (borderDimension.left + borderDimension.right);
	            size.height += (borderDimension.top + borderDimension.bottom);

	            //
	            // Square ?
	            if (node.getHeight().intValue() == node.getWidth().intValue()) {
	                // size.width = Math.max(size.height, size.width);
	                // size.height = Math.max(size.height, size.width);
	            }

	            return size;
	        }
	        return defaultSizeNodeFigure.getBounds().getSize().getCopy();
	}

	private int getTheLongestWord(String[] strings) {
		int max = -1;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() > max) {
				max = strings[i].length();
			}
		}
		return max;
	}

	/**
	 * Return the dimension of the border.
	 *
	 * @param nodeth
	 *            view node.
	 * @return the dimension of the border.
	 */
	public Insets getBorderDimension(DNode node) {
		return new Insets(0, 0, 0, 0);
	}

}
