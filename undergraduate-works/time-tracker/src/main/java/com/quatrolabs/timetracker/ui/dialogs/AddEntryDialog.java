package com.quatrolabs.timetracker.ui.dialogs;

import com.quatrolabs.timetracker.models.TimeEntry;
import com.quatrolabs.timetracker.validators.TimeEntryValidator;

import javax.swing.*;

public class AddEntryDialog {

    public static TimeEntry displayDialog(JFrame frame) {
        final String title = "Adicionar entrada no time tracker";

        String description, startDatetime, endDatetime;
        TimeEntry entry;
        TimeEntryValidator validator;
        int messageType;

        messageType = JOptionPane.PLAIN_MESSAGE;
        do {
            description = (String) JOptionPane.showInputDialog(
                    frame,"Descrição da tarefa: ", title, messageType);
            if (description == null) {
                return null;
            }
            messageType = JOptionPane.ERROR_MESSAGE;
        } while(description.length() == 0);

        messageType = JOptionPane.PLAIN_MESSAGE;
        do {
            startDatetime = (String) JOptionPane.showInputDialog(
                    frame,"Data e hora de início:\n(Formato: YYYY-MM-DD HH:MM)", title, messageType);
            if (startDatetime == null) {
                return null;
            }
            messageType = JOptionPane.ERROR_MESSAGE;
        } while(startDatetime.length() != 16);

        messageType = JOptionPane.PLAIN_MESSAGE;
        do {
            endDatetime = (String) JOptionPane.showInputDialog(
                    frame,"Data e hora de término:\n(Formato: YYYY-MM-DD HH:MM)", title, messageType);
            if (endDatetime == null) {
                return null;
            }
            messageType = JOptionPane.ERROR_MESSAGE;
        } while(endDatetime.length() != 16);

        entry = new TimeEntry(description, startDatetime, endDatetime);
        validator = new TimeEntryValidator(entry);

        if (validator.isValid()) {
            return entry;
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Entrada inválida; erros encontrados:\n" + validator.getErrors().errorMessage(),
                    title,
                    JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

}
