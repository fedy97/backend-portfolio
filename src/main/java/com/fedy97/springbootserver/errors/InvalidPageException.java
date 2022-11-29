package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public class InvalidPageException extends CustomizedError {

    public InvalidPageException() {
        super("Parameters provided for pagination are not correct", HttpStatus.BAD_REQUEST);
    }
}
