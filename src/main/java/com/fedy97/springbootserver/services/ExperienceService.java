package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.base.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.create_experience.CreateExperienceCommandRequest;
import com.fedy97.springbootserver.commands.create_experience.CreateExperienceCommandResponse;
import com.fedy97.springbootserver.commands.get_experiences.GetExperiencesCommandRequest;
import com.fedy97.springbootserver.commands.get_experiences.GetExperiencesCommandResponse;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExperienceService implements IExperienceService {

    @Autowired
    private SpringCommandDispatcher commandDispatcher;
    @Override
    public List<ExperienceResponse> getExperiences(VoidRequest voidRequest) {
        GetExperiencesCommandResponse responseCommand = commandDispatcher.dispatch(new GetExperiencesCommandRequest(voidRequest));
        return responseCommand.getExperiencesList();
    }

    @Override
    public ExperienceResponse createExperience(ExperienceRequest experienceRequest) {
        CreateExperienceCommandResponse response = commandDispatcher.dispatch(new CreateExperienceCommandRequest(experienceRequest));
        return response.getExperienceResponse();
    }

}
