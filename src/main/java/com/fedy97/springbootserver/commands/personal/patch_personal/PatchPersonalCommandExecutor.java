package com.fedy97.springbootserver.commands.personal.patch_personal;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.errors.PersonalNotFoundException;
import com.fedy97.springbootserver.models.Personal;
import com.fedy97.springbootserver.payload.request.PersonalRequest;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import com.fedy97.springbootserver.repositories.PersonalRepository;
import com.fedy97.springbootserver.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatchPersonalCommandExecutor implements CommandExecutor<PatchPersonalCommandRequest, PatchPersonalCommandResponse> {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public PatchPersonalCommandResponse execute(PatchPersonalCommandRequest command) {
        PersonalResponse entity = patchPersonal(command.getPersonalRequest());
        return new PatchPersonalCommandResponse(entity);
    }

    private PersonalResponse patchPersonal(PersonalRequest personalRequest) {
        List<Personal> personals = personalRepository.findAll();
        if (personals.isEmpty())
            throw new PersonalNotFoundException();
        Personal personal = personals.get(0);
        Optional.ofNullable(personalRequest.getLocation()).ifPresent(personal::setLocation);
        Optional.ofNullable(personalRequest.getFirstName()).ifPresent(personal::setFirstName);
        Optional.ofNullable(personalRequest.getLastName()).ifPresent(personal::setLastName);
        Optional.ofNullable(personalRequest.getLinkedinLink()).ifPresent(personal::setLinkedinLink);
        Optional.ofNullable(personalRequest.getGithubLink()).ifPresent(personal::setGithubLink);
        Optional.ofNullable(personalRequest.getEmail()).ifPresent(personal::setEmail);
        Optional.ofNullable(personalRequest.getPhoto()).ifPresent(personal::setPhoto);
        Optional.ofNullable(personalRequest.getResumeLink()).ifPresent(personal::setResumeLink);
        Optional.ofNullable(personalRequest.getPhoneNumber()).ifPresent(personal::setPhoneNumber);
        Optional.ofNullable(personalRequest.getJobTitle()).ifPresent(personal::setJobTitle);
        Optional.ofNullable(personalRequest.getBirth()).ifPresent(personal::setBirth);
        Optional.ofNullable(personalRequest.getAbout()).ifPresent(personal::setAbout);
        personal = personalRepository.save(personal);
        return Utils.convertEntityToDto(personal, PersonalResponse.class);
    }


}
