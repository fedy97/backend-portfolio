package com.fedy97.springbootserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("skills")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Skill {

    @Id
    private String id;
    private String skillName;

}
