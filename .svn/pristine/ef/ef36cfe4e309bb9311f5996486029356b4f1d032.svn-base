// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;

import view.DrawingPanel;

/**
 * An AbstractPaintShape which stores draw and fill colors, start and end points, and whether
 * or not the PaintShape is filled.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public abstract class AbstractPaintShape implements PaintShape {

    /** A point outside of the GUI frame to use for initialization of a PaintShape. */
    private static final Point NO_POINT = new Point(-50, -50);

    /** A null Shape to use as a placeholder until an actual shape can be defined. */
    private static final Shape NO_SHAPE = null;

    /** This PaintShape's underlying Shape. */
    protected Shape myBasicShape;
    
    /** The current draw color. */
    protected Color myDrawColor;
    
    /** The current fill color. */
    protected Color myFillColor;
    
    /** The current brush width. */
    protected float myBrushWidth;
    
    /** The current fill state. */
    protected boolean myFillState;
    
    /** The starting point to draw from. */
    protected Point myStartPoint;
    
    /** The ending point to draw to. */
    protected Point myEndPoint;

    /** 
     * Constructs an AbstractPaintShape by initializing all fields with their default 
     * values. 
     */
    public AbstractPaintShape() {
        myBasicShape = NO_SHAPE;
        // Draw color, fill color and brush width will be determined by the DrawingPanel's 
        // initial settings.
        myDrawColor = DrawingPanel.INITIAL_DRAW_UW_PURPLE;
        myFillColor = DrawingPanel.INITIAL_FILL_UW_GOLD;
        myBrushWidth = DrawingPanel.INITIAL_BRUSH_WIDTH;
        myFillState = false;
        myStartPoint = NO_POINT;
        myEndPoint = NO_POINT;

    }

    @Override
    public void setDrawColor(final Color theColor) {
        myDrawColor = theColor;
    }

    @Override
    public void setFillColor(final Color theColor) {
        myFillColor = theColor;
    }

    @Override
    public void setBrushWidth(final float theWidth) {
        myBrushWidth = theWidth;
    }

    @Override
    public void setFillState(final boolean theFillState) {
        myFillState = theFillState;
    }

    @Override
    public void setStartPoint(final Point thePoint) {
        myStartPoint = thePoint;
    }
    
    @Override
    public void setEndPoint(final Point thePoint) {
        myEndPoint = thePoint;
    }

    @Override
    public float getBrushWidth() {
        return myBrushWidth;
    }

    @Override
    public boolean isFilled() {
        return myFillState;
    }

    @Override
    public Color getFillColor() {
        return myFillColor;
    }

    @Override
    public Color getDrawColor() {
        return myDrawColor;
    }
}
