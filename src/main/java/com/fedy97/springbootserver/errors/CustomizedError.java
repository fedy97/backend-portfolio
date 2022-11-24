package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public abstract class CustomizedError extends RuntimeException {

    private final HttpStatus code;

    protected CustomizedError(String msg, HttpStatus code) {
        super(msg);
        this.code = code;
    }

    public HttpStatus code() {
        return code;
    }
}
