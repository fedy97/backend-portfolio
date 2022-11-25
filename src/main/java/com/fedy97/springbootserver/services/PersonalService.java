package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.personal.create_personal.CreatePersonalCommandRequest;
import com.fedy97.springbootserver.commands.personal.create_personal.CreatePersonalCommandResponse;
import com.fedy97.springbootserver.commands.personal.get_personal.GetPersonalCommandRequest;
import com.fedy97.springbootserver.commands.personal.get_personal.GetPersonalCommandResponse;
import com.fedy97.springbootserver.commands.personal.patch_personal.PatchPersonalCommandRequest;
import com.fedy97.springbootserver.commands.personal.patch_personal.PatchPersonalCommandResponse;
import com.fedy97.springbootserver.payload.request.PersonalRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import com.fedy97.springbootserver.services.interfaces.IPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalService implements IPersonalService {

    @Autowired
    private SpringCommandDispatcher commandDispatcher;
    @Override
    public PersonalResponse getPersonal(VoidRequest voidRequest) {
        GetPersonalCommandResponse responseCommand = commandDispatcher.dispatch(new GetPersonalCommandRequest(voidRequest));
        return responseCommand.getPersonalList();
    }

    @Override
    public PersonalResponse createPersonal(PersonalRequest personalRequest) {
        CreatePersonalCommandResponse response = commandDispatcher.dispatch(new CreatePersonalCommandRequest(personalRequest));
        return response.getPersonalResponse();
    }
    @Override
    public PersonalResponse patchPersonal(PersonalRequest personalRequest) {
        PatchPersonalCommandResponse response = commandDispatcher.dispatch(new PatchPersonalCommandRequest(personalRequest));
        return response.getPersonalResponse();
    }

}
