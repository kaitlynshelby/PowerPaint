// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

/**
 * An interface that defines methods for an object which stores a Shape, draw and fill colors,
 * start and end points, and whether or not the Shape is filled. 
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public interface PaintShape {
    
    /** 
     * Sets the draw color.
     * 
     * @param theColor the color to draw this PaintShape with.
     */
    void setDrawColor(Color theColor);

    /**
     * Sets the fill color.
     * 
     * @param theColor the color to fill this PaintShape with.
     */
    void setFillColor(Color theColor);

    /**
     * Sets the brush thickness. 
     * 
     * @param theWidth the thickness to set the brush to.
     */
    void setBrushWidth(float theWidth);

    /**
     * Sets whether or not this PaintShape is filled.
     * 
     * @param theFillState whether or not to fill this PaintShape.
     */
    void setFillState(boolean theFillState);

    /**
     * Sets the point to start drawing from.
     * 
     * @param thePoint the point to start drawing from.
     */
    void setStartPoint(Point thePoint);

    /**
     * Sets the ending point to draw to.
     * 
     * @param thePoint the ending point to draw to.
     */
    void setEndPoint(Point thePoint);

    /**
     * Returns this PaintShape's basic Shape.
     * 
     * @return a Shape object.
     */
    Shape getBasicShape();

    /**
     * Returns the brush thickness.
     * 
     * @return a float representing the brush thickness to draw with.
     */
    float getBrushWidth();

    /**
     * Returns whether or not this PaintShape is filled.
     * 
     * @return true or false depending on whether or not this PaintShape is filled.
     */
    boolean isFilled();

    /**
     * Returns the fill color.
     * 
     * @return a color to fill this PaintShape with.
     */
    Color getFillColor();
    
    /**
     * Returns the draw color.
     * 
     * @return a color to draw this PaintShape with.
     */
    Color getDrawColor();

    /**
     * Returns a new instance of the current PaintShape.
     * 
     * @return a new instance of the current PaintShape being worked with.
     */
    PaintShape createNew();
}
