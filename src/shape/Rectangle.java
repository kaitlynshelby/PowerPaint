// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package shape;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * A Rectangle of type PaintShape.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class Rectangle extends AbstractPaintShape {

    @Override
    public PaintShape createNew() {
        return new Rectangle();
    }

    @Override
    public Shape getBasicShape() {
        // Draws an rectangle starting from the standard upper-left corner
        // starting point.
        myBasicShape = new Rectangle2D.Double(myStartPoint.getX(), myStartPoint.getY(),
                                              getWidth(), getHeight());

        // Draws an rectangle starting from the lower-right corner.
        if (myEndPoint.getX() < myStartPoint.getX()
            && myEndPoint.getY() < myStartPoint.getY()) {
            myBasicShape = new Rectangle2D.Double(myEndPoint.getX(), myEndPoint.getY(),
                                                  getWidth(), getHeight());
            // Draws an rectangle starting from the upper-right corner.
        } else if (myEndPoint.getX() < myStartPoint.getX()) {
            myBasicShape = new Rectangle2D.Double(myEndPoint.getX(), myStartPoint.getY(),
                                                  getWidth(), getHeight());
            // Draws an rectangle starting from the lower-left corner.
        } else if (myEndPoint.getY() < myStartPoint.getY()) {
            myBasicShape = new Rectangle2D.Double(myStartPoint.getX(), myEndPoint.getY(),
                                                  getWidth(), getHeight());
        } else {
            // Draws an rectangle starting from the standard upper-left corner
            // starting point.
            myBasicShape = new Rectangle2D.Double(myStartPoint.getX(), myStartPoint.getY(),
                                                  getWidth(), getHeight());
        }

        return myBasicShape;
    }

    /**
     * Calculates the width of a drawn rectangle.
     * 
     * @return the width of the rectangle.
     */
    private double getWidth() {

        return Math.abs(myEndPoint.getX() - myStartPoint.getX());
    }

    /**
     * Calculates the height of a drawn rectangle.
     * 
     * @return the height of the rectangle.
     */
    private double getHeight() {
        return Math.abs(myEndPoint.getY() - myStartPoint.getY());
    }
}
