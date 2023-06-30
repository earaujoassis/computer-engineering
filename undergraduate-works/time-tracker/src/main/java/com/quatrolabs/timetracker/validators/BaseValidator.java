package com.quatrolabs.timetracker.validators;

public abstract class BaseValidator {

    public abstract boolean isValid();

    public abstract Errors getErrors();

}
