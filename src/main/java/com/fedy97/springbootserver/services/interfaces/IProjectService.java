package com.fedy97.springbootserver.services.interfaces;


import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ProjectResponse;

import java.util.List;


public interface IProjectService {
    List<ProjectResponse> getProjects(VoidRequest voidRequest);

    ProjectResponse createProject(ProjectRequest experienceRequest);

    void deleteProject(String id);

    ProjectResponse patchProject(String id, ProjectRequest body);

}
