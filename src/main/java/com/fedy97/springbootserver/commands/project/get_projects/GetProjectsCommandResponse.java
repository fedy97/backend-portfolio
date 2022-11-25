package com.fedy97.springbootserver.commands.project.get_projects;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class GetProjectsCommandResponse extends CommandResponse {
    private final List<ProjectResponse> projectsList;
}
