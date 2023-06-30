package com.quatrolabs.timetracker.ui.actions;

import com.quatrolabs.timetracker.ui.dialogs.AboutDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutAction implements ActionListener {

    private JFrame frame;

    public AboutAction(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutDialog.displayDialog(frame);
    }

}
