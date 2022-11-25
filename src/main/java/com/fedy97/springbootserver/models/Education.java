package com.fedy97.springbootserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("education")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Education {

    @Id
    private String id;
    private String title;
    private String location;
    private String link;
    private int startYear;
    private int endYear;
    private String grade;

}
