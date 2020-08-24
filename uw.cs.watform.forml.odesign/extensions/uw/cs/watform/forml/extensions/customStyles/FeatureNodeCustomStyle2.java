package uw.cs.watform.forml.extensions.customStyles;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.sirius.diagram.ui.edit.api.part.IStyleEditPart;

public class FeatureNodeCustomStyle2 extends org.eclipse.sirius.diagram.ui.edit.api.part.AbstractNotSelectableShapeNodeEditPart implements IStyleEditPart {


   
    public FeatureNodeCustomStyle2(View view) {
        super(view);
    }

    public DragTracker getDragTracker(Request request) {
        return getParent().getDragTracker(request);
    }

//    protected NodeFigure createNodeFigure() {
//    	return super.crea
//    }

//    private NodeFigure createNodePlate() {
//    	return super.create
//    }

    /**
     * Create the instance role figure.
     *
     * @return the created figure.
     */
//    protected ImageFigure createNodeShape() {
//      view.c
//    }

    /**
     * Return the instance role figure.
     *
     * @return the instance role figure.
     */
//    public ImageFigure getPrimaryShape() {
//        //return super.primaryShape;
//    }

    /**
     * Default implementation treats passed figure as content pane. Respects
     * layout one may have set for generated figure.
     *
     * @param nodeShape
     *            instance of generated figure class
     * @return the figure
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        return nodeShape; // use nodeShape itself as contentPane
    }

   // public IFigure getContentPane() {
       // if (contentPane != null) {
           // return contentPane;
       // }//
      //  return super.getContentPane();
   // }

//    protected void refreshVisuals() {
////        CustomStyle customStyle = (CustomStyle) this.resolveSemanticElement();
////        if (customStyle.eContainer() instanceof DNode) {
////            this.getPrimaryShape().setImage(SiriusPlugin.getDefault().getBundledImage(((DNode) customStyle.eContainer()).getName()));
////        }
//    
//    	WorkspaceImage customStyle = (WorkspaceImage) (this.resolveSemanticElement());
//        if (customStyle.eContainer() instanceof DNode) {
//        	
//        	ImageDescriptor myImage = ImageDescriptor.createFromURL(
//        			FileLocator.find(Activator.getDefault().getBundle(),
//        			new Path("images/Icons/FeatureNode.png"),null));
//        	
//        	
//			this.getPrimaryShape().setImage(myImage.createImage());//.setBackgroundColor(featureNodeColor);//.setImage((Image) SiriusPlugin.getDefault().getImage("/com.uwaterloo.cs.forml.odesign/images/Icons/andFeatureNode.png"));
//			createDefaultEditPolicies();
//        }
//    }

    protected void createDefaultEditPolicies() {

    	//installEditPolicy(EnlargeContainerEditPolicy.ROLE, new
			//	  EnlargeContainerEditPolicy());
    }

	@Override
	protected NodeFigure createNodeFigure() {
		// TODO Auto-generated method stub
		return super.getNodeFigure();
	}

}