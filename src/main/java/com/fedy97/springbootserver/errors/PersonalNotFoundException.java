package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public class PersonalNotFoundException extends CustomizedError {

    public PersonalNotFoundException() {
        super("Personal not found, create a new one", HttpStatus.BAD_REQUEST);
    }
}
