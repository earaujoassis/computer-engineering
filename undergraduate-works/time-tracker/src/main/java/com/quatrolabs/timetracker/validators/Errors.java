package com.quatrolabs.timetracker.validators;

import java.util.HashMap;

public class Errors {

    private HashMap<String, String> errorForFields;

    public Errors() {
        this.errorForFields = new HashMap<String, String>();
    }

    public void addError(String field, String message) {
        this.errorForFields.put(field, message);
    }

    public boolean isEmpty() {
        return this.errorForFields.isEmpty();
    }

    public String errorMessage() {
        StringBuilder builder = new StringBuilder();

        for (String k : this.errorForFields.keySet()) {
            builder.append(this.errorForFields.get(k));
            builder.append("\n");
        }

        return builder.toString();
    }

}
