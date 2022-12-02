package com.fedy97.springbootserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document("personal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Personal {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String about;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private String githubLink;
    private String linkedinLink;
    private String resumeLink;
    private String location;
    private String birth;
    private String photo;

}
