package com.fedy97.springbootserver.commands.education.get_educations;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class GetEducationsCommandResponse extends CommandResponse {
    private final List<EducationResponse> educationsList;
}
