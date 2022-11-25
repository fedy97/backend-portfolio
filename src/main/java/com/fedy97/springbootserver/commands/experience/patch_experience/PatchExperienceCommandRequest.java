package com.fedy97.springbootserver.commands.experience.patch_experience;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchExperienceCommandRequest extends Command<PatchExperienceCommandResponse> {
    private final ExperienceRequest experienceRequest;
    private final String id;
}
