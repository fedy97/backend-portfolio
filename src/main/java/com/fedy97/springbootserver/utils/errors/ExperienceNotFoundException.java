package com.fedy97.springbootserver.utils.errors;

import org.springframework.http.HttpStatus;

public class ExperienceNotFoundException extends CustomizedError {

    public ExperienceNotFoundException() {
        super("Experience not found", HttpStatus.BAD_REQUEST);
    }
}
