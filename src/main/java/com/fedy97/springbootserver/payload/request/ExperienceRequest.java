package com.fedy97.springbootserver.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExperienceRequest {
    @NotNull(groups = {NewGroup.class})
    private String role;
    @NotNull(groups = {NewGroup.class})
    private Integer startYear;
    private Integer endYear;
    @NotNull(groups = {NewGroup.class})
    private String company;
    private String link;
    private String description;
    private List<String> skills;
}
