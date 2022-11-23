package com.fedy97.springbootserver.commands.create_experience;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import com.fedy97.springbootserver.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateExperienceCommandExecutor implements CommandExecutor<CreateExperienceCommandRequest, CreateExperienceCommandResponse> {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public CreateExperienceCommandResponse execute(CreateExperienceCommandRequest command) {
        ExperienceResponse entity = createExperience(command.getExperienceRequest());
        return new CreateExperienceCommandResponse(entity);
    }

    private ExperienceResponse createExperience(ExperienceRequest experienceRequest) {
        Experience experience = Converter.convertDtoToEntity(experienceRequest, Experience.class);
        experience = experienceRepository.save(experience);
        return Converter.convertEntityToDto(experience, ExperienceResponse.class);
    }

}
