package com.projects.springboot.tutorial.errors.exceptions;


import com.projects.springboot.tutorial.entities.Department;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidationFieldsException extends Exception {

    private Set<ConstraintViolation<?>> constrainViolations;

    public ValidationFieldsException() {
        super();
    }

    public ValidationFieldsException(String message) {
        super(message);
    }

    public ValidationFieldsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationFieldsException(Throwable cause) {
        super(cause);
    }

    protected ValidationFieldsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


    public Set<ConstraintViolation<?>> getConstrainViolations() {
        return this.constrainViolations;
    }

    public void setConstrainViolations(Set<ConstraintViolation<?>> constraintViolations) {
        this.constrainViolations = constraintViolations;
    }
}
