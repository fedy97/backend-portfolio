package com.fedy97.springbootserver.commands.project.get_projects;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.commands.project.get_projects.GetProjectsCommandResponse;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetProjectsCommandRequest extends Command<GetProjectsCommandResponse> {
    private final VoidRequest voidRequest;
}
