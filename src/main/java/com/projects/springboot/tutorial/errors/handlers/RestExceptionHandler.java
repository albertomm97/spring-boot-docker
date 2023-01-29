package com.projects.springboot.tutorial.errors.handlers;

import com.projects.springboot.tutorial.errors.AppError;
import com.projects.springboot.tutorial.errors.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppError> genericExceptionHandler(Exception exception, WebRequest request) {

        return resolveError(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppError> resourceNotFoundExceptionHandler(ResourceNotFoundException exception,
                                                                 WebRequest request) {
        return resolveError(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<AppError> resourceNotFoundExceptionHandler(ConstraintViolationException exception,
                                                                     WebRequest request) {

        AppError error = new AppError(HttpStatus.BAD_REQUEST, exception);
        error.setMessage("Validation Error");
        error.addValidationErrors(exception.getConstraintViolations());

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    private ResponseEntity<AppError> resolveError(HttpStatus status, Exception exception) {
        AppError error = new AppError(status, exception, exception.getMessage());
        return ResponseEntity.status(error.getStatus()).body(error);
    }

}


