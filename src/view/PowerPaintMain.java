// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Driver class for PowerPaint.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public final class PowerPaintMain {

    /** Private constructor to inhibit instantiation. */
    private PowerPaintMain() {

    }

    /**
     * Main method.
     *  
     * @param theArgs command line arguments; ignored.
     */
    public static void main(final String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final PowerPaintGUI powerPaintGUI = new PowerPaintGUI();
                powerPaintGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                powerPaintGUI.setLocationRelativeTo(null);
                powerPaintGUI.setVisible(true);
            }
        });
    }

}
