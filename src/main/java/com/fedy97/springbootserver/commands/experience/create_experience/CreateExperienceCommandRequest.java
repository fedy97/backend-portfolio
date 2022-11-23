package com.fedy97.springbootserver.commands.experience.create_experience;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateExperienceCommandRequest extends Command<CreateExperienceCommandResponse> {
    private final ExperienceRequest experienceRequest;
}
