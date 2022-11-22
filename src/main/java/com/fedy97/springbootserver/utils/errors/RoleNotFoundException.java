package com.fedy97.springbootserver.utils.errors;

import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends CustomizedError {

    public RoleNotFoundException() {
        super("Role not found", HttpStatus.BAD_REQUEST);
    }
}
