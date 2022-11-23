package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.experience.create_experience.CreateExperienceCommandRequest;
import com.fedy97.springbootserver.commands.experience.create_experience.CreateExperienceCommandResponse;
import com.fedy97.springbootserver.commands.experience.delete_experience.DeleteExperienceCommandRequest;
import com.fedy97.springbootserver.commands.experience.get_experiences.GetExperiencesCommandRequest;
import com.fedy97.springbootserver.commands.experience.get_experiences.GetExperiencesCommandResponse;
import com.fedy97.springbootserver.commands.experience.patch_experience.PatchExperienceCommandRequest;
import com.fedy97.springbootserver.commands.experience.patch_experience.PatchExperienceCommandResponse;
import com.fedy97.springbootserver.payload.request.NewExperienceRequest;
import com.fedy97.springbootserver.payload.request.PatchExperienceRequest;
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
    public ExperienceResponse createExperience(NewExperienceRequest experienceRequest) {
        CreateExperienceCommandResponse response = commandDispatcher.dispatch(new CreateExperienceCommandRequest(experienceRequest));
        return response.getExperienceResponse();
    }

    @Override
    public void deleteExperience(String id) {
        commandDispatcher.dispatch(new DeleteExperienceCommandRequest(id));
    }

    @Override
    public ExperienceResponse patchEntity(String id, PatchExperienceRequest experienceRequest) {
        PatchExperienceCommandResponse response = commandDispatcher.dispatch(new PatchExperienceCommandRequest(experienceRequest, id));
        return response.getExperienceResponse();
    }

}
