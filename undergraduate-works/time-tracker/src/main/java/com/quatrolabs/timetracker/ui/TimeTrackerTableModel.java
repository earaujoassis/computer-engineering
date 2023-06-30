package com.quatrolabs.timetracker.ui;

import javax.swing.table.AbstractTableModel;

public class TimeTrackerTableModel extends AbstractTableModel {

    private static final String[] columnNames = new String[]{
        "Descrição",
        "Início",
        "Fim",
        "Tempo transcorrido"
    };

    private Object[][] data;

    public TimeTrackerTableModel() {
        this.data = emptyData();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        try {
            return data[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void clearData() {
        this.data = emptyData();
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    protected static final Object[][] emptyData() {
        return new Object[][]{{}};
    }

}
