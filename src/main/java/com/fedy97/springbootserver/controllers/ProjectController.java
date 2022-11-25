package com.fedy97.springbootserver.controllers;

import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.request.ProjectRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ProjectResponse;
import com.fedy97.springbootserver.services.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<ProjectResponse>> getAllProjects(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "1000") int size,
                                                                @RequestParam(defaultValue = "startYear,desc") String[] sort
                                                                //@RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(projectService.getProjects(new VoidRequest(size,page,sort)));
    }

    @PostMapping("/new")
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectRequest body) {
        return ResponseEntity.ok(projectService.createProject(body));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ProjectResponse> patchProject(@PathVariable String id, @RequestBody ProjectRequest body) {
        return ResponseEntity.ok(projectService.patchProject(id, body));
    }
}
