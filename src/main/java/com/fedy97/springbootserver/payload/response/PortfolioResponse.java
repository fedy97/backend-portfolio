package com.fedy97.springbootserver.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioResponse {
    private List<ExperienceResponse> experienceResponses;
    private List<ProjectResponse> projectResponses;
    private PersonalResponse personalResponse;
    private List<EducationResponse> educationResponses;
    private List<SkillResponse> skillResponses;

}
