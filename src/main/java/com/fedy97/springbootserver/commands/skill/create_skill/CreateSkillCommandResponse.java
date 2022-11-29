package com.fedy97.springbootserver.commands.skill.create_skill;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSkillCommandResponse extends CommandResponse {
    private final SkillResponse skillResponse;
}
