package com.fedy97.springbootserver.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationRequest {
    @NotNull(groups = {NewGroup.class})
    private String location;
    @NotNull(groups = {NewGroup.class})
    private String title;
    @NotNull(groups = {NewGroup.class})
    private Integer startYear;
    private Integer endYear;
    private String grade;
    private String link;
}
