package com.fedy97.springbootserver.commands.skill.patch_skill;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.SkillRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchSkillCommandRequest extends Command<PatchSkillCommandResponse> {
    private final SkillRequest skillRequest;
    private final String id;
}
