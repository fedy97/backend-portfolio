package com.fedy97.springbootserver.commands.education.patch_education;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.errors.EducationNotFoundException;
import com.fedy97.springbootserver.models.Education;
import com.fedy97.springbootserver.payload.request.EducationRequest;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import com.fedy97.springbootserver.repositories.EducationRepository;
import com.fedy97.springbootserver.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PatchEducationCommandExecutor implements CommandExecutor<PatchEducationCommandRequest, PatchEducationCommandResponse> {

    @Autowired
    EducationRepository educationRepository;

    @Override
    public PatchEducationCommandResponse execute(PatchEducationCommandRequest command) {
        EducationResponse entity = patchEducation(command.getId(), command.getEducationRequest());
        return new PatchEducationCommandResponse(entity);
    }

    private EducationResponse patchEducation(String id, EducationRequest educationRequest) {
        Education education = educationRepository.findById(id).orElseThrow(EducationNotFoundException::new);
        Optional.ofNullable(educationRequest.getLocation()).ifPresent(education::setLocation);
        Optional.ofNullable(educationRequest.getTitle()).ifPresent(education::setTitle);
        Optional.ofNullable(educationRequest.getLink()).ifPresent(education::setLink);
        Optional.ofNullable(educationRequest.getStartYear()).ifPresent(education::setStartYear);
        Optional.ofNullable(educationRequest.getEndYear()).ifPresent(education::setEndYear);
        Optional.ofNullable(educationRequest.getGrade()).ifPresent(education::setGrade);
        education = educationRepository.save(education);
        return Utils.convertEntityToDto(education, EducationResponse.class);
    }


}
