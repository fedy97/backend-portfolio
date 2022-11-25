package com.fedy97.springbootserver.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalRequest {
    @NotNull(groups = {NewGroup.class})
    private String firstName;
    @NotNull(groups = {NewGroup.class})
    private String lastName;
    @NotNull(groups = {NewGroup.class})
    private String jobTitle;
    @NotNull(groups = {NewGroup.class})
    private String email;
    private String phoneNumber;
    private String githubLink;
    private String linkedinLink;
    private String resumeLink;
    private String location;
    private String photo;
}
