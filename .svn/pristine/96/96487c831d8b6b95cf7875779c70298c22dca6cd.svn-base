// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package shape;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * A Line of type PaintShape.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class Line extends AbstractPaintShape {

    @Override
    public PaintShape createNew() {
        return new Line();
    }

    @Override
    public Shape getBasicShape() {
        myBasicShape = new Line2D.Double(myStartPoint, myEndPoint);
        return myBasicShape;
    }
}
