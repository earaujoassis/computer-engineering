package com.quatrolabs.timetracker.ui.actions;

import com.quatrolabs.timetracker.Actions;
import com.quatrolabs.timetracker.SharedState;
import com.quatrolabs.timetracker.ui.TimeTrackerUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitApplicationAction implements ActionListener {

    private JFrame frame;

    public ExitApplicationAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TimeTrackerUI ui = (TimeTrackerUI) frame;
        SharedState.getInstance().dispatchAction(Actions.SHUTDOWN_ACTION, null);
    }

}
