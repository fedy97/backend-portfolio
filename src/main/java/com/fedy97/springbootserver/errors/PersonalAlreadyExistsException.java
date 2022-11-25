package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public class PersonalAlreadyExistsException extends CustomizedError {

    public PersonalAlreadyExistsException() {
        super("Personal info already in db, you have to update it, not create a new one", HttpStatus.BAD_REQUEST);
    }
}
