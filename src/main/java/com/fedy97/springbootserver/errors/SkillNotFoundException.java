package com.fedy97.springbootserver.errors;

import org.springframework.http.HttpStatus;

public class SkillNotFoundException extends CustomizedError {

    public SkillNotFoundException() {
        super("Skill not found", HttpStatus.BAD_REQUEST);
    }
}
