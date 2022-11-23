package com.fedy97.springbootserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("experiences")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Experience {

    @Id
    private String id;
    private String role;
    private int startYear;
    private int endYear;
    private String company;
    private String link;
    private String description;
    private List<String> skills;

}
