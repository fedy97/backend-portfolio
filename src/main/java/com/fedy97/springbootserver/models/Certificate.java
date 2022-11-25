package com.fedy97.springbootserver.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("certificates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Certificate {

    @Id
    private String id;
    private String title;
    private String link;
    private int year;
    private String grade;

}
