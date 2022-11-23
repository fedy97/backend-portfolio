package com.fedy97.springbootserver.commands.create_experience;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateExperienceCommandRequest extends Command<CreateExperienceCommandResponse> {
    private final ExperienceRequest experienceRequest;
}
