package com.fedy97.springbootserver.utils.handlers;


import com.fedy97.springbootserver.payload.response.ErrorResponse;
import com.fedy97.springbootserver.utils.errors.CustomizedError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice // with ControllerAdvice we need to return ResponseEntity, with this the http json will be automatically created
public class ControllerExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ErrorResponse unauthorizedExceptionHandler(AccessDeniedException ex, WebRequest request) {
        return new ErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ErrorResponse badCredentialsExceptionHandler(BadCredentialsException ex, WebRequest request) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorResponse userNotFoundExceptionHandler(UsernameNotFoundException ex, WebRequest request) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    /**
     * go here for request error validation
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse methodArgumentNotValidHandler(MethodArgumentNotValidException ex, WebRequest request) {
        return new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    /**
     * all my customized exceptions in errors package will be thrown here
     */
    @ExceptionHandler(CustomizedError.class)
    public ErrorResponse customizedExceptionHandler(CustomizedError ex, WebRequest request) {
        return new ErrorResponse(
                ex.code().value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }

    /**
     * if not other exceptions are thrown, throw this
     * @param ex not caught before
     */
    @ExceptionHandler(Exception.class)
    public ErrorResponse globalExceptionHandler(Exception ex, WebRequest request) {
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
    }
}
