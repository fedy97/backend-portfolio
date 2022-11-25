package com.fedy97.springbootserver.commands.education.patch_education;

import com.fedy97.springbootserver.commands.base.Command;
import com.fedy97.springbootserver.payload.request.EducationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchEducationCommandRequest extends Command<PatchEducationCommandResponse> {
    private final EducationRequest educationRequest;
    private final String id;
}
