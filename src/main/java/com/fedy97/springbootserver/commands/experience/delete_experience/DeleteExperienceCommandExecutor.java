package com.fedy97.springbootserver.commands.experience.delete_experience;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import com.fedy97.springbootserver.utils.errors.ExperienceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteExperienceCommandExecutor implements CommandExecutor<DeleteExperienceCommandRequest, CommandVoidResponse> {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public CommandVoidResponse execute(DeleteExperienceCommandRequest command) {
        deleteExperience(command.getId());
        return new CommandVoidResponse();
    }

    private void deleteExperience(String id) {
        if (experienceRepository.existsById(id))
            experienceRepository.deleteById(id);
        else
            throw new ExperienceNotFoundException();
    }

}
