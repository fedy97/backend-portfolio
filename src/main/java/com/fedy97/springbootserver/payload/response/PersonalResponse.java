package com.fedy97.springbootserver.payload.response;

import lombok.Data;

@Data
public class PersonalResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private String githubLink;
    private String linkedinLink;
    private String resumeLink;
    private String location;
    private String photo;
    private String birth;
}
