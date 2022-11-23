package com.fedy97.springbootserver.commands.experience.patch_experience;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.PatchExperienceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchExperienceCommandRequest extends Command<PatchExperienceCommandResponse> {
    private final PatchExperienceRequest experienceRequest;
    private final String id;
}
