package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.project.create_project.CreateProjectCommandRequest;
import com.fedy97.springbootserver.commands.project.create_project.CreateProjectCommandResponse;
import com.fedy97.springbootserver.commands.project.delete_project.DeleteProjectCommandRequest;
import com.fedy97.springbootserver.commands.project.get_projects.GetProjectsCommandRequest;
import com.fedy97.springbootserver.commands.project.get_projects.GetProjectsCommandResponse;
import com.fedy97.springbootserver.commands.project.patch_project.PatchProjectCommandRequest;
import com.fedy97.springbootserver.commands.project.patch_project.PatchProjectCommandResponse;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import com.fedy97.springbootserver.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService implements IProjectService {

    @Autowired
    private SpringCommandDispatcher commandDispatcher;
    @Override
    public List<ProjectResponse> getProjects(VoidRequest voidRequest) {
        GetProjectsCommandResponse responseCommand = commandDispatcher.dispatch(new GetProjectsCommandRequest(voidRequest));
        return responseCommand.getProjectsList();
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        CreateProjectCommandResponse response = commandDispatcher.dispatch(new CreateProjectCommandRequest(projectRequest));
        return response.getProjectResponse();
    }

    @Override
    public void deleteProject(String id) {
        commandDispatcher.dispatch(new DeleteProjectCommandRequest(id));
    }

    @Override
    public ProjectResponse patchProject(String id, ProjectRequest projectRequest) {
        PatchProjectCommandResponse response = commandDispatcher.dispatch(new PatchProjectCommandRequest(projectRequest, id));
        return response.getProjectResponse();
    }

}
