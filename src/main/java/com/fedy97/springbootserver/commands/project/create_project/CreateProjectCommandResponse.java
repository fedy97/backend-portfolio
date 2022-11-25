package com.fedy97.springbootserver.commands.project.create_project;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProjectCommandResponse extends CommandResponse {
    private final ProjectResponse projectResponse;
}
