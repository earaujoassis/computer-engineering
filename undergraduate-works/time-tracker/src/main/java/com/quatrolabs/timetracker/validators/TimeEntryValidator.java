package com.quatrolabs.timetracker.validators;

import com.quatrolabs.timetracker.models.TimeEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeEntryValidator extends BaseValidator {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private TimeEntry entry;
    private Errors errors;

    public TimeEntryValidator(TimeEntry entry) {
        this.errors = new Errors();
        this.entry = entry;
    }

    @Override
    public boolean isValid() {
        isValidDatetimeEntries();
        if (this.errors.isEmpty()) {
            isValidDatetimeRange();
        }
        isValidDescription();

        return this.errors.isEmpty();
    }

    @Override
    public Errors getErrors() {
        return this.errors;
    }

    protected void isValidDatetimeEntries() {
        Date datetimeStart, datetimeEnd;
        try {
            datetimeStart = dateFormat.parse(entry.getStartDatetime());
        } catch (ParseException e) {
            this.errors.addError("startDatetime", "Data e hora de início inválida.");
        }

        try {
            datetimeEnd = dateFormat.parse(entry.getEndDatetime());
        } catch (ParseException e) {
            this.errors.addError("startDatetime", "Data e hora de término inválida.");
        }
    }

    protected void isValidDatetimeRange() {
        Date datetimeStart, datetimeEnd;

        try {
            datetimeStart = dateFormat.parse(entry.getStartDatetime());
            datetimeEnd = dateFormat.parse(entry.getEndDatetime());
        } catch (ParseException e) {
            return;
        }

        if (datetimeStart.compareTo(datetimeEnd) >= 0) {
            this.errors.addError("dateComparison", "Data e hora de início deve preceder a data e hora de término.");
        }
    }

    protected void isValidDescription() {
        if (entry.getDescription().length() > 100 || entry.getDescription().length() == 0) {
            this.errors.addError("description", "Descrição deve ter até 100 caracteres.");
        }
    }

}
