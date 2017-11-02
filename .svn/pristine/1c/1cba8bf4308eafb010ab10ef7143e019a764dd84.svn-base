// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package view;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ColorPreviewIcon;

/**
 * A JMenuBar to use with the PowerPaintGUI.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 */
public class MenuBar extends JMenuBar implements PropertyChangeListener {

    /** A generated serial number. */
    private static final long serialVersionUID = -111659266189879540L;

    /** The major tick spacing for the brush size selector. */
    private static final int SLIDER_MAJOR_TICK_SPACING = 5;

    /** The minor tick spacing for the brush size selector. */
    private static final int SLIDER_MINOR_TICK_SPACING = 1;
    
    /** A string to use as the frame title for a color chooser. */
    private static final String COLOR_CHOOSER_TITLE_STRING = "Select a color";

    /** The frame containing this menu bar. */
    private final JFrame myFrame;

    /** The DrawingPanel this menu communicates with. */
    private final DrawingPanel myPanel;

    /** A collection of listeners to use with the tool selection menu. */
    private final List<AbstractAction> myToolActions;

    /** This menu bar's clear button. */
    private JMenuItem myClearButton;

    /**
     * Constructs a PowerPaint menu bar.
     * 
     * @param theFrame the parent frame for this menu bar.
     * @param thePanel the drawing panel this menu bar will communicate with.
     * @param theToolActions the collection of tool actions to use with this menu bar.
     */
    public MenuBar(final JFrame theFrame, final DrawingPanel thePanel,
                   final List<AbstractAction> theToolActions) {
        super();

        myFrame = theFrame;
        myPanel = thePanel;

        myPanel.addPropertyChangeListener(this);

        myToolActions = theToolActions;

        add(createFileMenu());
        add(createOptionMenu());
        add(createToolMenu());
        add(createHelpMenu());
    }

    /**
     * Creates the File menu.
     * 
     * @return the completed file menu.
     */
    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // create clear button
        myClearButton = new JMenuItem("Clear");
        myClearButton.setMnemonic(KeyEvent.VK_C);
        myClearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.getPreviousShapes().clear();
                myPanel.repaint();
                myClearButton.setEnabled(false);
            }
        });

        // create quit button
        final JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            }

        });
        quit.setMnemonic(KeyEvent.VK_Q);

        fileMenu.add(myClearButton);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        return fileMenu;

    }

    /**
     * Creates the Option Menu.
     * 
     * @return the completed Option menu.
     */
    private JMenu createOptionMenu() {
        final JMenu optionMenu = new JMenu("Options");
        optionMenu.setMnemonic(KeyEvent.VK_O);

        optionMenu.add(createBrushWidthSubmenu());

        final JMenuItem draw = new JMenuItem("Draw Color...");
        draw.setMnemonic(KeyEvent.VK_D);
        final ActionListener drawListener = new DrawColorChange(draw);
        draw.addActionListener(drawListener);

        final JMenuItem fill = new JMenuItem("Fill Color...");
        fill.setMnemonic(KeyEvent.VK_F);
        final ActionListener fillListener = new FillColorChange(fill);
        fill.addActionListener(fillListener);

        final JCheckBoxMenuItem checkFill = new JCheckBoxMenuItem("Fill");
        checkFill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
        checkFill.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(final ItemEvent theEvent) {
                if (theEvent.getStateChange() == ItemEvent.SELECTED) {
                    myPanel.setFillState(true);
                } else {
                    myPanel.setFillState(false);
                }
            }

        });

        optionMenu.addSeparator();
        optionMenu.add(draw);
        optionMenu.add(fill);
        optionMenu.addSeparator();
        optionMenu.add(checkFill);

        return optionMenu;

    }

    /**
     * Creates a sub-menu with a slider to select brush width.
     * 
     * @return the brush width sub-menu.
     */
    private JMenu createBrushWidthSubmenu() {
        final JMenu menu = new JMenu("Thickness");

        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 1);
        slider.setMajorTickSpacing(SLIDER_MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(SLIDER_MINOR_TICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                myPanel.setBrushWidth(slider.getValue());
                myPanel.setDrawingEnabled(!(slider.getValue() == 0));
            }
        });

        menu.add(slider);
        menu.setMnemonic(KeyEvent.VK_T);

        return menu;
    }

    /**
     * Creates a completed Tool menu.
     * 
     * @return the completed Tool menu.
     */
    private JMenu createToolMenu() {
        final JMenu toolMenu = new JMenu("Tools");
        toolMenu.setMnemonic(KeyEvent.VK_T);

        final ButtonGroup btngrp = new ButtonGroup();

        for (final AbstractAction actn : myToolActions) {
            final JRadioButtonMenuItem btn = new JRadioButtonMenuItem(actn);
            btn.addActionListener(actn);
            btngrp.add(btn);
            toolMenu.add(btn);
        }

        btngrp.clearSelection();
        btngrp.getElements().nextElement().setSelected(true);

        return toolMenu;
    }

    /**
     * Creates a completed Help Menu.
     * 
     * @return the completed Help menu.
     */
    private JMenu createHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);

        final JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(myFrame,
                                              "TCSS 305 PowerPaint\nSpring 2016"
                                                       + "\nKaitlyn Kinerk",
                                              "About", JOptionPane.PLAIN_MESSAGE,
                                              new ImageIcon("paint-brush-icon.png"));
            }
        });

        helpMenu.add(about);

        return helpMenu;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("clear button enable/disable".equals(theEvent.getPropertyName())) {
            myClearButton.setEnabled(!myPanel.getPreviousShapes().isEmpty());
        }
    }

    /**
     * A listener class which changes the draw color on a drawing panel and simultaneously 
     * updates the color preview icon to display the new draw color.
     * 
     * @author Kaitlyn Kinerk
     * @version 1.0
     */
    private class DrawColorChange implements ActionListener {

        /** The icon this listener will update. */
        private final ColorPreviewIcon myIcon;

        /** The draw color to use on the drawing panel. */
        private Color myColor;

        /** Constructs this listener with its attached icon and the panel's initial 
         *  draw color. 
         *  
         *  @param theMenuItem the menu item this listener will attach an icon to.
         */
        DrawColorChange(final JMenuItem theMenuItem) {

            myColor = DrawingPanel.INITIAL_DRAW_UW_PURPLE;
            myIcon = new ColorPreviewIcon(myColor);

            theMenuItem.setIcon(myIcon);
        }

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            myColor = JColorChooser.showDialog(null, COLOR_CHOOSER_TITLE_STRING, myColor);
            myIcon.setColor(myColor);
            myPanel.setDrawColor(myColor);

        }
    }

    /**
     * A listener class which changes the draw color on a drawing panel and simultaneously 
     * updates the color preview icon to display the new fill color.
     * 
     * @author Kaitlyn Kinerk
     * @version 1.0
     */
    private class FillColorChange implements ActionListener {

        /** The icon this listener will update. */
        private final ColorPreviewIcon myIcon;

        /** The draw color to use on the drawing panel. */
        private Color myColor;

        /**
         * Constructs this listener with its attached icon and the panel's initial 
         * draw color. 
         *  
         *  @param theMenuItem the menu item this listener will attach an icon to.
         */
        FillColorChange(final JMenuItem theMenuItem) {

            myColor = DrawingPanel.INITIAL_FILL_UW_GOLD;
            myIcon = new ColorPreviewIcon(myColor);
            theMenuItem.setIcon(myIcon);
        }

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            myColor = JColorChooser.showDialog(null, COLOR_CHOOSER_TITLE_STRING, myColor);
            myIcon.setColor(myColor);
            myPanel.setFillColor(myColor);

        }
    }
}
