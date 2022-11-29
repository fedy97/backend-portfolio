package com.fedy97.springbootserver.commands.skill.patch_skill;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.errors.SkillNotFoundException;
import com.fedy97.springbootserver.models.Skill;
import com.fedy97.springbootserver.payload.request.SkillRequest;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import com.fedy97.springbootserver.repositories.SkillRepository;
import com.fedy97.springbootserver.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PatchSkillCommandExecutor implements CommandExecutor<PatchSkillCommandRequest, PatchSkillCommandResponse> {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public PatchSkillCommandResponse execute(PatchSkillCommandRequest command) {
        SkillResponse entity = patchSkill(command.getId(), command.getSkillRequest());
        return new PatchSkillCommandResponse(entity);
    }

    private SkillResponse patchSkill(String id, SkillRequest skillRequest) {
        Skill skill = skillRepository.findById(id).orElseThrow(SkillNotFoundException::new);
        Optional.ofNullable(skillRequest.getSkillName()).ifPresent(skill::setSkillName);
        skill = skillRepository.save(skill);
        return Utils.convertEntityToDto(skill, SkillResponse.class);
    }


}
