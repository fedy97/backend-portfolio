package com.fedy97.springbootserver.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SkillRequest {
    @NotNull(groups = {NewGroup.class})
    private String skillName;
}
