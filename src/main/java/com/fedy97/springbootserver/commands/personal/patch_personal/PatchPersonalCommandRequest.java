package com.fedy97.springbootserver.commands.personal.patch_personal;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.PersonalRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchPersonalCommandRequest extends Command<PatchPersonalCommandResponse> {
    private final PersonalRequest personalRequest;
}
