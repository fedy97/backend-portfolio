package com.fedy97.springbootserver.payload.response;

import com.fedy97.springbootserver.models.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ExperienceResponse {
    private String id;
    private String role;
    private int startYear;
    private int endYear;
    private String company;
    private String link;
    private String description;
    private List<String> skills;
}
