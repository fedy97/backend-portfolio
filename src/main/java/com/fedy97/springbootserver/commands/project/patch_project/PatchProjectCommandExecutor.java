package com.fedy97.springbootserver.commands.project.patch_project;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.errors.ProjectNotFoundException;
import com.fedy97.springbootserver.models.Project;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import com.fedy97.springbootserver.repositories.ProjectRepository;
import com.fedy97.springbootserver.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PatchProjectCommandExecutor implements CommandExecutor<PatchProjectCommandRequest, PatchProjectCommandResponse> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public PatchProjectCommandResponse execute(PatchProjectCommandRequest command) {
        ProjectResponse entity = patchProject(command.getId(), command.getProjectRequest());
        return new PatchProjectCommandResponse(entity);
    }

    private ProjectResponse patchProject(String id, ProjectRequest projectRequest) {
        Project project = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
        Optional.ofNullable(projectRequest.getTitle()).ifPresent(project::setTitle);
        Optional.ofNullable(projectRequest.getStack()).ifPresent(project::setStack);
        Optional.ofNullable(projectRequest.getLink()).ifPresent(project::setLink);
        Optional.ofNullable(projectRequest.getDescription()).ifPresent(project::setDescription);
        project = projectRepository.save(project);
        return Utils.convertEntityToDto(project, ProjectResponse.class);
    }


}
