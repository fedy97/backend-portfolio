package com.fedy97.springbootserver.commands.skill.delete_skill;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import com.fedy97.springbootserver.errors.SkillNotFoundException;
import com.fedy97.springbootserver.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSkillCommandExecutor implements CommandExecutor<DeleteSkillCommandRequest, CommandVoidResponse> {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public CommandVoidResponse execute(DeleteSkillCommandRequest command) {
        deleteSkill(command.getId());
        return new CommandVoidResponse();
    }

    private void deleteSkill(String id) {
        if (skillRepository.existsById(id))
            skillRepository.deleteById(id);
        else
            throw new SkillNotFoundException();
    }

}
