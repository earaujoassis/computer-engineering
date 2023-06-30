package com.quatrolabs.timetracker.models;

import java.util.ArrayList;

public class TimeTracker {

    private final ArrayList<TimeEntry> entries;

    public TimeTracker() {
        this.entries = new ArrayList<TimeEntry>();
    }

    public void addEntry(TimeEntry entry) {
        entries.add(0, entry);
    }

    public ArrayList<TimeEntry> getList() {
        return this.entries;
    }

}
