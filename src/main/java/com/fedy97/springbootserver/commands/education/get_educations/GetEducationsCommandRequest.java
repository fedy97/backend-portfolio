package com.fedy97.springbootserver.commands.education.get_educations;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetEducationsCommandRequest extends Command<GetEducationsCommandResponse> {
    private final VoidRequest voidRequest;
}
