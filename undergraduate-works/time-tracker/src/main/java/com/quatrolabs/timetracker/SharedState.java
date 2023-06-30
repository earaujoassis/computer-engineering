package com.quatrolabs.timetracker;

import com.quatrolabs.timetracker.models.TimeTracker;

import java.util.ArrayList;

public final class SharedState {

    private static SharedState singletonInstance;

    private TimeTracker entries;
    private ArrayList<ActionListener> actionListeners;

    protected SharedState() {
        this.actionListeners = new ArrayList<ActionListener>();
    }

    public TimeTracker getEntries() {
        return entries;
    }

    public void setEntries(TimeTracker entries) {
        this.entries = entries;
    }

    public void registerActionListener(ActionListener listener) {
        this.actionListeners.add(listener);
    }

    public void dispatchAction(Actions action, Object data) {
        for (ActionListener aL : this.actionListeners) {
            aL.handleAction(action, data);
        }
    }

    public static SharedState getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SharedState();
        }

        return singletonInstance;
    }

}
