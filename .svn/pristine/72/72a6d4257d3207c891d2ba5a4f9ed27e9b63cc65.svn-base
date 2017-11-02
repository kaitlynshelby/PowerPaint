// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

/**
 * A small, square icon which displays the color a drawing panel is set to use.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class ColorPreviewIcon implements Icon {

    /** The height of the icon. */
    private static final int HEIGHT = 16;

    /** The width of the icon. */
    private static final int WIDTH = 16;

    /** The color of the icon. */
    private Color myColor;

    /** 
     * Constructs a new color preview icon with a given color.
     * 
     * @param theColor the color to paint the icon.
     */
    public ColorPreviewIcon(final Color theColor) {
        myColor = theColor;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    /**
     * Draws and fills a rectangle of a default height and width with the given color. 
     */
    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphics,
                          final int theX, final int theY) {

        final Graphics2D g2d = (Graphics2D) theGraphics;
        final Rectangle2D.Double box = new Rectangle2D.Double(theX, theY, WIDTH, HEIGHT);
        g2d.draw(box);
        g2d.setColor(myColor);
        g2d.fill(box);

    }

    /**
     * Sets the color of the icon.
     * 
     * @param theColor the color to paint the icon.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;

    }

}
