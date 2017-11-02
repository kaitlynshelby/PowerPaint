// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package shape;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Float;

/**
 * A Pencil of type PaintShape.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class Pencil extends AbstractPaintShape {

    /**
     * Constructs a pencil with a new GeneralPath.
     */
    public Pencil() {
        super();
        // Should be one new path for each instantiation of pencil. This path will be updated
        // in getBasicShape().
        myBasicShape = new GeneralPath(Path2D.WIND_EVEN_ODD);
    }

    @Override
    public PaintShape createNew() {
        return new Pencil();
    }

    /**
     * Appends a line to the path created during instantiation.
     */
    @Override
    public Shape getBasicShape() {
        ((Float) myBasicShape).moveTo(myStartPoint.getX(), myStartPoint.getY());
        ((Float) myBasicShape).lineTo(myEndPoint.getX(), myEndPoint.getY());
        // To add a new line after this line, start point must be reset to the end of the last
        // drawn line.
        setStartPoint(myEndPoint);

        return myBasicShape;
    }
}
