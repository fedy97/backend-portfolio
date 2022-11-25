package com.fedy97.springbootserver.commands.personal.patch_personal;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchPersonalCommandResponse extends CommandResponse {
    private final PersonalResponse personalResponse;
}
