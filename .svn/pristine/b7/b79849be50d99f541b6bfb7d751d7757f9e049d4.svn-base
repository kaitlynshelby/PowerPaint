// TCSS 305 - Spring 2016
// Assignment 5 - PowerPaint

package view;

import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * A JToolBar to use with the PowerPaintGUI.
 * 
 * @author Kaitlyn Kinerk
 * @version 1.0
 *
 */
public class ToolBar extends JToolBar {

    /** A generated serial number. */
    private static final long serialVersionUID = 304052708691137548L;

    /** A collection of tool actions to use with the tool selection menu. */
    private final List<AbstractAction> myToolActions;

    /**
     * Constructs a tool bar with all buttons and default settings.
     * 
     * @param theToolActions the action listeners to use with this tool bar.
     */
    public ToolBar(final List<AbstractAction> theToolActions) {
        super();
        myToolActions = theToolActions;

        setupButtons();

    }
    
    /**
     * Helper method which creates all necessary, fully-functioning tool bar buttons and adds 
     * them to the tool bar.
     */
    private void setupButtons() {
        final ButtonGroup btngrp = new ButtonGroup();

        for (final AbstractAction actn : myToolActions) {
            final JToggleButton btn = new JToggleButton(actn);
            btn.addActionListener(actn);
            btngrp.add(btn);
            add(btn);
        }

        btngrp.clearSelection();
        btngrp.getElements().nextElement().setSelected(true);

    }
}
