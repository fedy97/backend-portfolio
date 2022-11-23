package com.fedy97.springbootserver.services;


import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;

import java.util.List;


public interface IExperienceService {
    List<ExperienceResponse> getExperiences(VoidRequest voidRequest);

    ExperienceResponse createExperience(ExperienceRequest experienceRequest);

}
