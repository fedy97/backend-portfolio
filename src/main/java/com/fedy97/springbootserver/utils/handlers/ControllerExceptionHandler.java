package com.fedy97.springbootserver.utils.handlers;


import com.fedy97.springbootserver.payload.response.ErrorResponse;
import com.fedy97.springbootserver.errors.CustomizedError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
// with ControllerAdvice we need to return ResponseEntity, with RestControllerAdvice the http json will be automatically created
// but there is no way to change the HttpStatus, so we use ControllerAdvice.
public class ControllerExceptionHandler {

    /**
     * go here for request error validation
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidHandler(MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.getMessage(),
                request.getDescription(true)), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * all my customized exceptions in errors package will be thrown here
     */
    @ExceptionHandler(CustomizedError.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> customizedExceptionHandler(CustomizedError ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                ex.code().value(),
                ex.getMessage(),
                request.getDescription(true)), HttpStatus.valueOf(ex.code().value()));
    }

    /**
     * if no other exceptions are thrown, throw this
     * @param ex not caught before
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(true)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
