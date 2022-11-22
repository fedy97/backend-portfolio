package com.fedy97.springbootserver.commands.get_experiences;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetExperiencesCommandExecutor implements CommandExecutor<GetExperiencesCommandRequest, GetExperiencesCommandResponse> {

    @Autowired
    ExperienceRepository experienceRepository;

    private List<ExperienceResponse> getExperiences(VoidRequest voidRequest) {
        List<Experience> experiences;
        // todo use the void request for the page and sort
        experiences = experienceRepository.findAll();
        return experiences.stream().map(ExperienceResponse::fromExperienceEntity).collect(Collectors.toList());
    }

    @Override
    public GetExperiencesCommandResponse execute(GetExperiencesCommandRequest command) {
        List<ExperienceResponse> entityList = getExperiences(command.getVoidRequest());
        return new GetExperiencesCommandResponse(entityList);
    }

}
