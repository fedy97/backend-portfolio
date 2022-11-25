package com.fedy97.springbootserver.commands.education.delete_education;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.commands.base.CommandVoidResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteEducationCommandRequest extends Command<CommandVoidResponse> {
    private final String id;
}
