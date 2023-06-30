package com.quatrolabs.timetracker.ui;

import com.quatrolabs.timetracker.ActionListener;
import com.quatrolabs.timetracker.Actions;
import com.quatrolabs.timetracker.SharedState;
import com.quatrolabs.timetracker.models.TimeEntry;

import javax.swing.*;

public class TimeTrackerUI extends JFrame implements ActionListener {

    private final TimeTrackerTable table;

    public TimeTrackerUI() {
        super("Time Tracker");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.table = new TimeTrackerTable();
        JScrollPane scrollPane = new JScrollPane(this.table);
        TimeTrackerPanel contentPanel = new TimeTrackerPanel();
        contentPanel.add(scrollPane);
        contentPanel.setOpaque(true);

        setJMenuBar(new TimeTrackerMenu(this));
        setContentPane(contentPanel);
    }

    @Override
    public void handleAction(Actions action, Object data) {
        switch (action) {
            case BOOTSTRAP_ACTION:
                table.updateData(SharedState.getInstance().getEntries());
                break;
            case ADD_ENTRY_ACTION:
                if (data != null) {
                    TimeEntry entry = (TimeEntry) data;
                    SharedState.getInstance().getEntries().addEntry(entry);
                    table.updateData(SharedState.getInstance().getEntries());
                }
                break;
            case REMOVE_ENTRIES_ACTION:
                table.clearData();
                break;
            case SHUTDOWN_ACTION:
                this.dispose();
                System.exit(0);
                break;
            default:
                System.out.println("Unknown or unhandled dispatched action");
                break;
        }
    }

    public void displayGUI() {
        this.pack();
        this.setVisible(true);
    }

}
