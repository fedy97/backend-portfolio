package com.fedy97.springbootserver.commands.experience.patch_experience;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchExperienceCommandResponse extends CommandResponse {
    private final ExperienceResponse experienceResponse;
}
