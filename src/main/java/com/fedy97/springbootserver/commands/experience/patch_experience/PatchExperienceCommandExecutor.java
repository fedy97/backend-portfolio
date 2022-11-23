package com.fedy97.springbootserver.commands.experience.patch_experience;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.NewExperienceRequest;
import com.fedy97.springbootserver.payload.request.PatchExperienceRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.repositories.ExperienceRepository;
import com.fedy97.springbootserver.utils.Converter;
import com.fedy97.springbootserver.utils.Utils;
import com.fedy97.springbootserver.utils.errors.ExperienceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private ExperienceResponse patchExperience(String id, PatchExperienceRequest experienceRequest) {
        Experience experience = experienceRepository.findById(id).orElseThrow(ExperienceNotFoundException::new);
        Utils.changeIfPresent(experienceRequest.getCompany(), experience::setCompany);
        Utils.changeIfPresent(experienceRequest.getRole(), experience::setRole);
        Utils.changeIfPresent(experienceRequest.getLink(), experience::setLink);
        Utils.changeIfPresent(experienceRequest.getDescription(), experience::setDescription);
        Utils.changeIfPresent(experienceRequest.getSkills(), experience::setSkills);
        Utils.changeIfPresent(experienceRequest.getEndYear(), experience::setEndYear);
        Utils.changeIfPresent(experienceRequest.getStartYear(), experience::setStartYear);
        experience = experienceRepository.save(experience);
        return Converter.convertEntityToDto(experience, ExperienceResponse.class);
    }


}
