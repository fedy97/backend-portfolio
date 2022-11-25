package com.fedy97.springbootserver.commands.experience.patch_experience;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import com.fedy97.springbootserver.utils.Utils;
import com.fedy97.springbootserver.errors.ExperienceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PatchExperienceCommandExecutor implements CommandExecutor<PatchExperienceCommandRequest, PatchExperienceCommandResponse> {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public PatchExperienceCommandResponse execute(PatchExperienceCommandRequest command) {
        ExperienceResponse entity = patchExperience(command.getId(), command.getExperienceRequest());
        return new PatchExperienceCommandResponse(entity);
    }

    private ExperienceResponse patchExperience(String id, ExperienceRequest experienceRequest) {
        Experience experience = experienceRepository.findById(id).orElseThrow(ExperienceNotFoundException::new);
        Optional.ofNullable(experienceRequest.getCompany()).ifPresent(experience::setCompany);
        Optional.ofNullable(experienceRequest.getRole()).ifPresent(experience::setRole);
        Optional.ofNullable(experienceRequest.getLink()).ifPresent(experience::setLink);
        Optional.ofNullable(experienceRequest.getDescription()).ifPresent(experience::setDescription);
        Optional.ofNullable(experienceRequest.getSkills()).ifPresent(experience::setSkills);
        Optional.ofNullable(experienceRequest.getEndYear()).ifPresent(experience::setEndYear);
        Optional.ofNullable(experienceRequest.getStartYear()).ifPresent(experience::setStartYear);
        experience = experienceRepository.save(experience);
        return Utils.convertEntityToDto(experience, ExperienceResponse.class);
    }


}
