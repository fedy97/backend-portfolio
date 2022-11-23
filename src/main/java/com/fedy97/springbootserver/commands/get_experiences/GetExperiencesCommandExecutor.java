package com.fedy97.springbootserver.commands.get_experiences;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import com.fedy97.springbootserver.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Page<Experience> experiences;
        Pageable pageable;
        if (voidRequest.getSort()[1] != null && voidRequest.getSort()[1].equals("asc"))
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize(),
                    Sort.by(voidRequest.getSort()[0]).ascending());
        else
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize(),
                    Sort.by(voidRequest.getSort()[0]).descending());
        experiences = experienceRepository.findAll(pageable);
        return experiences.stream().map(experience -> Converter.convertEntityToDto(experience, ExperienceResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetExperiencesCommandResponse execute(GetExperiencesCommandRequest command) {
        List<ExperienceResponse> entityList = getExperiences(command.getVoidRequest());
        return new GetExperiencesCommandResponse(entityList);
    }

}
