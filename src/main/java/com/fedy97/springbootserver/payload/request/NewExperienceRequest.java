package com.fedy97.springbootserver.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class NewExperienceRequest {
    @NotNull
    private String role;
    @NotNull
    private String startYear;
    private String endYear;
    @NotNull
    private String company;
    private String link;
    @NotNull
    private String description;
    private List<String> skills;

}
