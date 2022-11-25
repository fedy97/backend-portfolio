package com.fedy97.springbootserver.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import com.fedy97.springbootserver.utils.validation_groups.PatchGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


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
    @Email(groups = {NewGroup.class, PatchGroup.class})
    private String email;
    @Pattern(groups = {NewGroup.class, PatchGroup.class}, regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String phoneNumber;
    @Pattern(groups = {NewGroup.class, PatchGroup.class}, regexp = "^(http(s):\\/\\/.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)$")
    private String githubLink;
    @Pattern(groups = {NewGroup.class, PatchGroup.class}, regexp = "^(http(s):\\/\\/.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)$")
    private String linkedinLink;
    @Pattern(groups = {NewGroup.class, PatchGroup.class}, regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")
    private String birth;
    @Pattern(groups = {NewGroup.class, PatchGroup.class}, regexp = "^(http(s):\\/\\/.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)$")
    private String resumeLink;
    private String location;
    private String photo;
}
