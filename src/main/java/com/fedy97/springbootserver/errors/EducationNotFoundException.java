package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public class EducationNotFoundException extends CustomizedError {

    public EducationNotFoundException() {
        super("Education not found", HttpStatus.BAD_REQUEST);
    }
}
