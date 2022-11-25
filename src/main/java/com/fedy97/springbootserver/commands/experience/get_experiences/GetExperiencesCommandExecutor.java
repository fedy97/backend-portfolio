package com.fedy97.springbootserver.commands.experience.get_experiences;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import com.fedy97.springbootserver.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetExperiencesCommandExecutor implements CommandExecutor<GetExperiencesCommandRequest, GetExperiencesCommandResponse> {

    @Autowired
    ExperienceRepository experienceRepository;

    private List<ExperienceResponse> getExperiences(VoidRequest voidRequest) {
        Page<Experience> experiences;
        experiences = experienceRepository.findAll(voidRequest.getPageable());
        return experiences.stream().map(experience -> Utils.convertEntityToDto(experience, ExperienceResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetExperiencesCommandResponse execute(GetExperiencesCommandRequest command) {
        List<ExperienceResponse> entityList = getExperiences(command.getVoidRequest());
        return new GetExperiencesCommandResponse(entityList);
    }

}
