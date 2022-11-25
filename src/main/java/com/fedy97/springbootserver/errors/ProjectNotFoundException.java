package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public class ProjectNotFoundException extends CustomizedError {

    public ProjectNotFoundException() {
        super("Project not found", HttpStatus.BAD_REQUEST);
    }
}
