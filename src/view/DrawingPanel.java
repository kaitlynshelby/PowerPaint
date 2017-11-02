// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import shape.PaintShape;
import shape.Pencil;

/**
 * A drawing panel to use with the PowerPaint GUI.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class DrawingPanel extends JPanel {

    /** The initial draw color UW Purple. */
    public static final Color INITIAL_DRAW_UW_PURPLE = new Color(51, 0, 111);

    /** The initial fill color UW Gold. */
    public static final Color INITIAL_FILL_UW_GOLD = new Color(232, 211, 162);

    /** The initial brush width. */
    public static final float INITIAL_BRUSH_WIDTH = 1;
    
    /** The preferred size of this drawing panel. */
    private static final Dimension PREFERRED_SIZE = new Dimension(600, 300);

    /** A generated serialization ID. */
    private static final long serialVersionUID = -1966968065678487493L;

    /** A collection of previously drawn shapes to repaint on this panel. */
    private final List<PaintShape> myPreviousShapes;

    /** The current PaintShape type being drawn. */
    private PaintShape myCurrentShape;

    /** The current draw color. */
    private Color myDrawColor;

    /** The current fill color. */
    private Color myFillColor;

    /** Whether or not the shapes being drawn should be filled. */
    private boolean myFillState;

    /** The current width of the brush. */
    private float myBrushWidth;

    /** Whether or not drawing is currently enabled on the panel. */
    private boolean myDrawingEnabled;

    /**
     * Constructs a DrawingPanel by setting all fields to their default values and calling
     * a method to set up panel preferences and listeners.
     */
    public DrawingPanel() {
        super();
        myPreviousShapes = new ArrayList<>();
        myCurrentShape = new Pencil();
        myDrawColor = INITIAL_DRAW_UW_PURPLE;
        myFillColor = INITIAL_FILL_UW_GOLD;
        myFillState = false;
        myBrushWidth = INITIAL_BRUSH_WIDTH;
        myDrawingEnabled = true;

        setUpPanel();
    }

    /**
     * Helper method to the constructor which sets the panel's preferred size and background 
     * color and then attaches mouse listeners.
     */
    private void setUpPanel() {
        setPreferredSize(PREFERRED_SIZE);
        setBackground(Color.WHITE);

        final MouseInputAdapter listener = new DrawListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {

        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(new Color(0, 0, 0, 2));
        g2d.fill(new Rectangle2D.Double(40, 40, 100, 100));

        // Draw previous shapes
        for (final PaintShape p : myPreviousShapes) {
            if (p.isFilled()) {
                g2d.setPaint(p.getFillColor());
                g2d.fill(p.getBasicShape());
            }
            g2d.setStroke(new BasicStroke(p.getBrushWidth(), BasicStroke.CAP_ROUND,
                                          BasicStroke.JOIN_MITER));
            g2d.setPaint(p.getDrawColor());
            g2d.draw(p.getBasicShape());

        }

        if (myFillState) {
            g2d.setColor(myFillColor);
            g2d.fill(myCurrentShape.getBasicShape());
        }
        g2d.setStroke(new BasicStroke(myBrushWidth, BasicStroke.CAP_ROUND,
                                      BasicStroke.JOIN_MITER));
        g2d.setPaint(myDrawColor);
        g2d.draw(myCurrentShape.getBasicShape());
    }
    
    /**
     * Sets the PaintShape type to use for drawing.
     * 
     * @param theShape the PaintShape type to use for drawing.
     */
    public void setCurrentShape(final PaintShape theShape) {
        myCurrentShape = theShape;
    }

    /**
     * Returns the PaintShape being used for drawing.
     * 
     * @return the PaintShape currently being used for drawing.
     */
    public PaintShape getCurrentShape() {
        return myCurrentShape;
    }

    /**
     * Sets whether or not to fill the current shape being drawn on the panel.
     * 
     * @param theState tells panel whether or not to fill the shape being drawn.
     */
    public void setFillState(final boolean theState) {
        myFillState = theState;

    }

    /**
     * Returns whether or not the shape being drawn is filled.
     * 
     * @return boolean value of whether or not the current shape is filled.
     */
    public boolean isFilled() {
        return myFillState;
    }

    /**
     * Returns a list of previously drawn shapes.
     * 
     * @return the list of previously drawn shapes. 
     */
    public List<PaintShape> getPreviousShapes() {
        // Not a copy because state needs to be changed outside of this class.
        // (ex: list needs to be cleared when the "Clear" menu button is clicked.)
        return myPreviousShapes;
    }

    /**
     * Returns the draw color.
     * 
     * @return the color used for drawing.
     */
    public Color getDrawColor() {
        return myDrawColor;
    }

    /**
     * Sets the draw color.
     * 
     * @param theDrawColor the color to draw with.
     */
    public void setDrawColor(final Color theDrawColor) {
        myDrawColor = theDrawColor;
    }

    /**
     * Returns the fill color.
     * 
     * @return the color used for filling shapes.
     */
    public Color getFillColor() {
        return myFillColor;
    }

    /**
     * Sets the fill color.
     * 
     * @param theFillColor the color to fill drawn shapes with.
     */
    public void setFillColor(final Color theFillColor) {
        myFillColor = theFillColor;
    }

    /**
     * Sets whether or not to enable drawing on this panel.
     * 
     * @param theValue boolean value of whether or not to enable drawing.
     */
    public void setDrawingEnabled(final boolean theValue) {
        myDrawingEnabled = theValue;
    }
    
    /**
     * Sets the width of the brush.
     * 
     * @param theWidth the float value to set the width of the brush to.
     */
    public void setBrushWidth(final float theWidth) {
        myBrushWidth = theWidth;

    }

    /**
     * A mouse listener which determines where to draw shapes on the panel.
     * 
     * @author Kaitlyn Kinerk
     * @version 1.0
     */
    private class DrawListener extends MouseInputAdapter {

        @Override
        public void mouseEntered(final MouseEvent theEvent) {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        }

        @Override
        public void mousePressed(final MouseEvent theEvent) {
            if (myDrawingEnabled) {
                // myCurrentShape only has default values at this point, so set those values
                // to the current settings of this DrawingPanel.
                setUpFields();
                myCurrentShape.setStartPoint(theEvent.getPoint());
                myCurrentShape.setEndPoint(theEvent.getPoint());
                repaint();
            }
        }
        
        /**
         * Helper method to mousePressed which sets the current PaintShape's fields to match 
         * the current settings of this DrawingPanel. 
         */
        private void setUpFields() {
            myCurrentShape.setDrawColor(myDrawColor);
            myCurrentShape.setFillColor(myFillColor);
            myCurrentShape.setFillState(myFillState);
            myCurrentShape.setBrushWidth(myBrushWidth);
        }

        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            if (myDrawingEnabled) {
                myCurrentShape.setEndPoint(theEvent.getPoint());
                repaint();
            }
        }

        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            // Shape is completely drawn, so add to list of previous shapes.
            myPreviousShapes.add(myCurrentShape);
            // Create a new instance of the current PaintShape type to prepare for the next 
            // time the mouse is pressed on the panel.
            myCurrentShape = myCurrentShape.createNew();
            // Check if myPreviousShapes contains any elements; determine if clear button
            // should be enabled or disabled.
            firePropertyChange("clear button enable/disable", null, "");
        }
    }
}
