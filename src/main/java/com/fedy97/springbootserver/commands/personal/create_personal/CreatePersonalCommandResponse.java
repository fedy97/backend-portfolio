package com.fedy97.springbootserver.commands.personal.create_personal;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePersonalCommandResponse extends CommandResponse {
    private final PersonalResponse personalResponse;
}
