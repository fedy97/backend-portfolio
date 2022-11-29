package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.skill.create_skill.CreateSkillCommandRequest;
import com.fedy97.springbootserver.commands.skill.create_skill.CreateSkillCommandResponse;
import com.fedy97.springbootserver.commands.skill.delete_skill.DeleteSkillCommandRequest;
import com.fedy97.springbootserver.commands.skill.get_skills.GetSkillsCommandRequest;
import com.fedy97.springbootserver.commands.skill.get_skills.GetSkillsCommandResponse;
import com.fedy97.springbootserver.commands.skill.patch_skill.PatchSkillCommandRequest;
import com.fedy97.springbootserver.commands.skill.patch_skill.PatchSkillCommandResponse;
import com.fedy97.springbootserver.payload.request.SkillRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import com.fedy97.springbootserver.services.interfaces.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillService implements ISkillService {

    @Autowired
    private SpringCommandDispatcher commandDispatcher;
    @Override
    public List<SkillResponse> getSkills(VoidRequest voidRequest) {
        GetSkillsCommandResponse responseCommand = commandDispatcher.dispatch(new GetSkillsCommandRequest(voidRequest));
        return responseCommand.getSkillsList();
    }

    @Override
    public SkillResponse createSkill(SkillRequest skillRequest) {
        CreateSkillCommandResponse response = commandDispatcher.dispatch(new CreateSkillCommandRequest(skillRequest));
        return response.getSkillResponse();
    }

    @Override
    public void deleteSkill(String id) {
        commandDispatcher.dispatch(new DeleteSkillCommandRequest(id));
    }

    @Override
    public SkillResponse patchSkill(String id, SkillRequest skillRequest) {
        PatchSkillCommandResponse response = commandDispatcher.dispatch(new PatchSkillCommandRequest(skillRequest, id));
        return response.getSkillResponse();
    }

}
