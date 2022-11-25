package com.fedy97.springbootserver.commands.personal.get_personal;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetPersonalCommandRequest extends Command<GetPersonalCommandResponse> {
    private final VoidRequest voidRequest;
}
