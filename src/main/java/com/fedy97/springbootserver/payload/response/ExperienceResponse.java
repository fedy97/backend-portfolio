package com.fedy97.springbootserver.payload.response;

import com.fedy97.springbootserver.models.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ExperienceResponse extends SerializableResponse {
    private String role;
    private int startYear;
    private int endYear;
    private String company;
    private String link;
    private String description;
    private List<String> skills;

    //public static ExperienceResponse fromExperienceEntity(Experience experience) {
    //    return new ExperienceResponse(
    //            experience.getRole(),
    //            experience.getStartYear(),
    //            experience.getEndYear(),
    //            experience.getCompany(),
    //            experience.getLink(),
    //            experience.getDescription(),
    //            experience.getSkills()
    //    );
    //}
}
