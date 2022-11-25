package com.fedy97.springbootserver.commands.education.create_education;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateEducationCommandResponse extends CommandResponse {
    private final EducationResponse educationResponse;
}
