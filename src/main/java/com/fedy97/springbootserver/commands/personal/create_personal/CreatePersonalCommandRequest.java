package com.fedy97.springbootserver.commands.personal.create_personal;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.PersonalRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePersonalCommandRequest extends Command<CreatePersonalCommandResponse> {
    private final PersonalRequest personalRequest;
}
