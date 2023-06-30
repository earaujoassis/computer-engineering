package com.quatrolabs.timetracker.ui;

import com.quatrolabs.timetracker.models.TimeEntry;
import com.quatrolabs.timetracker.models.TimeTracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TimeTrackerTable extends JTable {

    public TimeTrackerTable() {
        super(new TimeTrackerTableModel());

        setPreferredScrollableViewportSize(new Dimension(720, 180));
        setFillsViewportHeight(true);
    }

    public void updateData(TimeTracker entries) {
        TimeTrackerTableModel tableModel = (TimeTrackerTableModel) this.getModel();
        tableModel.clearData();

        ArrayList<TimeEntry> list = entries.getList();
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            TimeEntry entry = list.get(i);
            data[i][0] = entry.getDescription();
            data[i][1] = entry.getStartDatetime();
            data[i][2] = entry.getEndDatetime();
            data[i][3] = entry.getElapsedTime();
        }
        tableModel.setData(data);

        this.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    public void clearData() {
        TimeTrackerTableModel tableModel = (TimeTrackerTableModel) this.getModel();
        tableModel.clearData();
        this.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

}
