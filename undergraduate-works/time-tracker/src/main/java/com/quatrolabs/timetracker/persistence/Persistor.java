package com.quatrolabs.timetracker.persistence;

import com.quatrolabs.timetracker.ActionListener;
import com.quatrolabs.timetracker.Actions;
import com.quatrolabs.timetracker.SharedState;
import com.quatrolabs.timetracker.models.TimeEntry;

public class Persistor implements ActionListener {

    private TimeEntryRepository repository;

    public Persistor() {
        this.repository = new TimeEntryRepository();
        this.repository.connect();
        this.repository.assertSchema();
    }

    @Override
    public void handleAction(Actions action, Object data) {
        switch (action) {
            case BOOTSTRAP_ACTION:
                SharedState.getInstance().setEntries(this.repository.loadEntries());
                break;
            case ADD_ENTRY_ACTION:
                if (data != null) {
                    this.repository.addEntry((TimeEntry) data);
                }
                break;
            case REMOVE_ENTRIES_ACTION:
                this.repository.rebuildSchema();
                break;
            case SHUTDOWN_ACTION:
                this.repository.close();
                break;
            default:
                System.out.println("Unknown or unhandled dispatched action");
                break;
        }
    }

}
