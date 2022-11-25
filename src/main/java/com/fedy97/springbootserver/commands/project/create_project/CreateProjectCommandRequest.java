package com.fedy97.springbootserver.commands.project.create_project;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProjectCommandRequest extends Command<CreateProjectCommandResponse> {
    private final ProjectRequest projectRequest;
}
