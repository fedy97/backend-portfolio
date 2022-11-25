package com.fedy97.springbootserver.commands.personal.get_personal;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Personal;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import com.fedy97.springbootserver.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.fedy97.springbootserver.utils.Utils.convertEntityToDto;

@Service
public class GetPersonalCommandExecutor implements CommandExecutor<GetPersonalCommandRequest, GetPersonalCommandResponse> {

    @Autowired
    PersonalRepository personalRepository;

    private PersonalResponse getPersonal() {
        Personal personal;
        personal = personalRepository.findAll().get(0);
        return convertEntityToDto(personal, PersonalResponse.class);
    }

    @Override
    public GetPersonalCommandResponse execute(GetPersonalCommandRequest command) {
        PersonalResponse entityList = getPersonal();
        return new GetPersonalCommandResponse(entityList);
    }

}
