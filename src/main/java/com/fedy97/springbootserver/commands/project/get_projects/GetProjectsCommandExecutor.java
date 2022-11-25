package com.fedy97.springbootserver.commands.project.get_projects;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Project;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import com.fedy97.springbootserver.repositories.ProjectRepository;
import com.fedy97.springbootserver.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetProjectsCommandExecutor implements CommandExecutor<GetProjectsCommandRequest, GetProjectsCommandResponse> {

    @Autowired
    ProjectRepository projectRepository;

    private List<ProjectResponse> getProjects(VoidRequest voidRequest) {
        Page<Project> projects;
        Pageable pageable;
        if (voidRequest.isDoSort() && voidRequest.getSort()[1] != null && voidRequest.getSort()[1].equals("asc"))
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize(),
                    Sort.by(voidRequest.getSort()[0]).ascending());
        else if (voidRequest.isDoSort())
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize(),
                    Sort.by(voidRequest.getSort()[0]).descending());
        else {
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize());
        }
        projects = projectRepository.findAll(pageable);
        return projects.stream().map(project -> Utils.convertEntityToDto(project, ProjectResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetProjectsCommandResponse execute(GetProjectsCommandRequest command) {
        List<ProjectResponse> entityList = getProjects(command.getVoidRequest());
        return new GetProjectsCommandResponse(entityList);
    }

}
