// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.EllipseListener;
import model.LineListener;
import model.PencilListener;
import model.RectangleListener;

/**
 * The PowerPaint GUI.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class PowerPaintGUI extends JFrame {

    /** The icon for this JFrame. */
    private static final ImageIcon ICON = new ImageIcon("paint-brush-icon.png");

    /** A generated serial number. */
    private static final long serialVersionUID = -6432464878129969525L;

    /** A DrawingPanel to use with this program. */
    private final DrawingPanel myPanel;

    /** A collection of tool actions that this program will use. */
    private final List<AbstractAction> myToolActions;

    /** Constructs the GUI. */
    public PowerPaintGUI() {
        super("PowerPaint");
        
        setIconImage(ICON.getImage());
        
        myPanel = new DrawingPanel();
        myToolActions = new ArrayList<>();
        
        setupToolActions();
        addComponents();
        setLookAndFeel();

        pack();
    }

    /**
     * Helper method to the constructor which adds all the tool listeners this program will 
     * need to a collection.
     */
    private void setupToolActions() {
        myToolActions.add(new PencilListener("Pencil", myPanel));
        myToolActions.add(new LineListener("Line", myPanel));
        myToolActions.add(new RectangleListener("Rectangle", myPanel));
        myToolActions.add(new EllipseListener("Ellipse", myPanel));

    }
    
    /**
     * Helper method to the constructor which adds the main components (MenuBar, ToolBar, and 
     * DrawingPanel) to the JFrame.
     */
    private void addComponents() {
        final JToolBar toolbar = new ToolBar(myToolActions);
        final JMenuBar menuBar = new MenuBar(this, myPanel, myToolActions);
        
        add(toolbar, BorderLayout.SOUTH);
        setJMenuBar(menuBar);
        add(myPanel, BorderLayout.CENTER);
    }

    /**
     * Sets the look and feel for this GUI.
     */
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

}
