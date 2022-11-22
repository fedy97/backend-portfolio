package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.models.Experience;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;

import java.util.List;


public interface IExperienceService {
    List<ExperienceResponse> getExperiences(VoidRequest voidRequest);

    ExperienceResponse createExperience(Experience experienceRequest);

}
