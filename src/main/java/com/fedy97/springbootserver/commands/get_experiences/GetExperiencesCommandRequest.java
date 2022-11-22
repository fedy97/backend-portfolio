package com.fedy97.springbootserver.commands.get_experiences;

import com.fedy97.springbootserver.commands.base.Command;

import com.fedy97.springbootserver.payload.request.VoidRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class GetExperiencesCommandRequest extends Command<GetExperiencesCommandResponse> {
    private final VoidRequest voidRequest;
}
