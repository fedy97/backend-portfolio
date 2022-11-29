package com.fedy97.springbootserver.commands.skill.get_skills;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetSkillsCommandRequest extends Command<GetSkillsCommandResponse> {
    private final VoidRequest voidRequest;
}
