package com.fedy97.springbootserver.commands.education.delete_education;

import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import com.fedy97.springbootserver.commands.education.delete_education.DeleteEducationCommandRequest;
import com.fedy97.springbootserver.errors.EducationNotFoundException;
import com.fedy97.springbootserver.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEducationCommandExecutor implements CommandExecutor<DeleteEducationCommandRequest, CommandVoidResponse> {

    @Autowired
    EducationRepository educationRepository;

    @Override
    public CommandVoidResponse execute(DeleteEducationCommandRequest command) {
        deleteEducation(command.getId());
        return new CommandVoidResponse();
    }

    private void deleteEducation(String id) {
        if (educationRepository.existsById(id))
            educationRepository.deleteById(id);
        else
            throw new EducationNotFoundException();
    }

}
