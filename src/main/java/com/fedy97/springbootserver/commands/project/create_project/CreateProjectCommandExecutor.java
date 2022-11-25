package com.fedy97.springbootserver.commands.project.create_project;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Project;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import com.fedy97.springbootserver.repositories.ProjectRepository;
import com.fedy97.springbootserver.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectCommandExecutor implements CommandExecutor<CreateProjectCommandRequest, CreateProjectCommandResponse> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public CreateProjectCommandResponse execute(CreateProjectCommandRequest command) {
        ProjectResponse entity = createProject(command.getProjectRequest());
        return new CreateProjectCommandResponse(entity);
    }

    private ProjectResponse createProject(ProjectRequest projectRequest) {
        Project project = Utils.convertDtoToEntity(projectRequest, Project.class);
        project = projectRepository.save(project);
        return Utils.convertEntityToDto(project, ProjectResponse.class);
    }

}
