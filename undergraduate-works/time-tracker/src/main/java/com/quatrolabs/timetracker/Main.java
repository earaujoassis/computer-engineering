package com.quatrolabs.timetracker;

import com.quatrolabs.timetracker.persistence.Persistor;
import com.quatrolabs.timetracker.ui.TimeTrackerUI;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SharedState applicationState = SharedState.getInstance();
                Persistor persistor = new Persistor();
                TimeTrackerUI gui = new TimeTrackerUI();
                applicationState.registerActionListener(persistor);
                applicationState.registerActionListener(gui);
                applicationState.dispatchAction(Actions.BOOTSTRAP_ACTION, null);
                gui.displayGUI();
            }
        });

    }

}
