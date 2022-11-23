package com.fedy97.springbootserver.commands.experience.delete_experience;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteExperienceCommandRequest extends Command<CommandVoidResponse> {
    private final String id;
}
