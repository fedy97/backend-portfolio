package com.fedy97.springbootserver.commands.skill.create_skill;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Skill;
import com.fedy97.springbootserver.payload.request.SkillRequest;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import com.fedy97.springbootserver.repositories.SkillRepository;
import com.fedy97.springbootserver.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSkillCommandExecutor implements CommandExecutor<CreateSkillCommandRequest, CreateSkillCommandResponse> {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public CreateSkillCommandResponse execute(CreateSkillCommandRequest command) {
        SkillResponse entity = createSkill(command.getSkillRequest());
        return new CreateSkillCommandResponse(entity);
    }

    private SkillResponse createSkill(SkillRequest skillRequest) {
        Skill skill = Utils.convertDtoToEntity(skillRequest, Skill.class);
        skill = skillRepository.save(skill);
        return Utils.convertEntityToDto(skill, SkillResponse.class);
    }

}
