package com.fedy97.springbootserver.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class ExperienceRequest {
    @NotNull
    private String role;
    @NotNull
    private int startYear;
    private int endYear;
    @NotNull
    private String company;
    private String link;
    @NotNull
    private String description;
    private List<String> skills;

}
