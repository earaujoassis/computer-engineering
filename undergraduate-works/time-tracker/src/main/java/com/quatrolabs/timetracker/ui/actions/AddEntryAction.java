package com.quatrolabs.timetracker.ui.actions;

import com.quatrolabs.timetracker.Actions;
import com.quatrolabs.timetracker.SharedState;
import com.quatrolabs.timetracker.models.TimeEntry;
import com.quatrolabs.timetracker.ui.TimeTrackerUI;
import com.quatrolabs.timetracker.ui.dialogs.AddEntryDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEntryAction implements ActionListener {

    private final JFrame frame;

    public AddEntryAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TimeEntry entry = AddEntryDialog.displayDialog(frame);
        TimeTrackerUI ui = (TimeTrackerUI) frame;
        SharedState.getInstance().dispatchAction(Actions.ADD_ENTRY_ACTION, entry);
    }

}
