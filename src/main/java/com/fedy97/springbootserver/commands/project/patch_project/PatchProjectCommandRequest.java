package com.fedy97.springbootserver.commands.project.patch_project;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchProjectCommandRequest extends Command<PatchProjectCommandResponse> {
    private final ProjectRequest projectRequest;
    private final String id;
}
