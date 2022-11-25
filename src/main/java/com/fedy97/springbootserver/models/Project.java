package com.fedy97.springbootserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("projects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Project {

    @Id
    private String id;
    private String title;
    private String description;
    private List<String> stack;
    private String link;

}
