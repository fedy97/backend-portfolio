package com.fedy97.springbootserver.commands.skill.get_skills;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class GetSkillsCommandResponse extends CommandResponse {
    private final List<SkillResponse> skillsList;
}
