package com.fedy97.springbootserver.commands.education.create_education;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.EducationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateEducationCommandRequest extends Command<CreateEducationCommandResponse> {
    private final EducationRequest educationRequest;
}
