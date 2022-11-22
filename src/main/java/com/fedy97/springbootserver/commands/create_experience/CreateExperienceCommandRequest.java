package com.fedy97.springbootserver.commands.create_experience;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.models.Experience;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateExperienceCommandRequest extends Command<CreateExperienceCommandResponse> {
    private final Experience experienceRequest;
}
