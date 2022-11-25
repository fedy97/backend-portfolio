package com.fedy97.springbootserver.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class EducationResponse {
    private String id;
    private String title;
    private String location;
    private String link;
    private int startYear;
    private int endYear;
    private String grade;
}
