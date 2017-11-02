// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package model;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import shape.Rectangle;
import view.DrawingPanel;

/**
 * A listener which sets the current shape on a drawing panel to a Rectangle.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 *
 */
public class RectangleListener extends AbstractAction {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 4229258366835102081L;

    /** The panel to change the current shape on. */
    private final DrawingPanel myPanel;

    /**
     * Constructs a RectangleListener with a string to use for the listener's name. Also 
     * implements synchronization of buttons which use this listener.
     * 
     * @param theName the name of the listener (the string to display on a button with this 
     *        attached listener). 
     * @param thePanel the DrawingPanel to change the tool on.
     */
    public RectangleListener(final String theName, final DrawingPanel thePanel) {
        super(theName);
        myPanel = thePanel;

        putValue(Action.SELECTED_KEY, true);
    }

    /**
     * Sets the current shape on the DrawingPanel to a Rectangle.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentShape(new Rectangle());

    }

}
