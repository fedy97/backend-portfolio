package com.fedy97.springbootserver.commands.get_experiences;

import com.fedy97.springbootserver.commands.base.CommandResponse;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class GetExperiencesCommandResponse extends CommandResponse {
    private final List<ExperienceResponse> experiencesList;
}
