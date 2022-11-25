package com.fedy97.springbootserver.commands.personal.create_personal;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.errors.PersonalAlreadyExistsException;
import com.fedy97.springbootserver.models.Personal;
import com.fedy97.springbootserver.payload.request.PersonalRequest;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import com.fedy97.springbootserver.repositories.PersonalRepository;
import com.fedy97.springbootserver.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonalCommandExecutor implements CommandExecutor<CreatePersonalCommandRequest, CreatePersonalCommandResponse> {

    @Autowired
    PersonalRepository personalRepository;

    @Override
    public CreatePersonalCommandResponse execute(CreatePersonalCommandRequest command) {
        PersonalResponse entity = createPersonal(command.getPersonalRequest());
        return new CreatePersonalCommandResponse(entity);
    }

    private PersonalResponse createPersonal(PersonalRequest personalRequest) {
        if (personalRepository.count() != 0)
            throw new PersonalAlreadyExistsException();
        Personal personal = Utils.convertDtoToEntity(personalRequest, Personal.class);
        personal = personalRepository.save(personal);
        return Utils.convertEntityToDto(personal, PersonalResponse.class);
    }

}
