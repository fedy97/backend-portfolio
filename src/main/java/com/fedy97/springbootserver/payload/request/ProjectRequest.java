package com.fedy97.springbootserver.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectRequest {
    @NotNull(groups = {NewGroup.class})
    private String title;
    private String link;
    @NotNull(groups = {NewGroup.class})
    private String description;
    @NotNull(groups = {NewGroup.class})
    private List<String> stack;
}
