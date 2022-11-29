package com.fedy97.springbootserver.commands.skill.delete_skill;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteSkillCommandRequest extends Command<CommandVoidResponse> {
    private final String id;
}
