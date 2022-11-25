package com.fedy97.springbootserver.commands.project.delete_project;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteProjectCommandRequest extends Command<CommandVoidResponse> {
    private final String id;
}
