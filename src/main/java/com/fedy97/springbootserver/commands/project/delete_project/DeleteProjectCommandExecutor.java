package com.fedy97.springbootserver.commands.project.delete_project;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import com.fedy97.springbootserver.errors.ProjectNotFoundException;
import com.fedy97.springbootserver.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProjectCommandExecutor implements CommandExecutor<DeleteProjectCommandRequest, CommandVoidResponse> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public CommandVoidResponse execute(DeleteProjectCommandRequest command) {
        deleteProject(command.getId());
        return new CommandVoidResponse();
    }

    private void deleteProject(String id) {
        if (projectRepository.existsById(id))
            projectRepository.deleteById(id);
        else
            throw new ProjectNotFoundException();
    }

}
