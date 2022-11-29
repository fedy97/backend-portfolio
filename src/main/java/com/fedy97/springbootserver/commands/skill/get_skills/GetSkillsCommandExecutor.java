package com.fedy97.springbootserver.commands.skill.get_skills;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Skill;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import com.fedy97.springbootserver.repositories.SkillRepository;
import com.fedy97.springbootserver.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetSkillsCommandExecutor implements CommandExecutor<GetSkillsCommandRequest, GetSkillsCommandResponse> {

    @Autowired
    SkillRepository skillRepository;

    private List<SkillResponse> getSkills(VoidRequest voidRequest) {
        Page<Skill> skills;
        skills = skillRepository.findAll(voidRequest.getPageable());
        return skills.stream().map(skill -> Utils.convertEntityToDto(skill, SkillResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetSkillsCommandResponse execute(GetSkillsCommandRequest command) {
        List<SkillResponse> entityList = getSkills(command.getVoidRequest());
        return new GetSkillsCommandResponse(entityList);
    }

}
