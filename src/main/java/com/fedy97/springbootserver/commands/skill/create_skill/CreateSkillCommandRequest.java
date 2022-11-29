package com.fedy97.springbootserver.commands.skill.create_skill;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.SkillRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSkillCommandRequest extends Command<CreateSkillCommandResponse> {
    private final SkillRequest skillRequest;
}
