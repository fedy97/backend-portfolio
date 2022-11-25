package com.fedy97.springbootserver.services.interfaces;


import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;

import java.util.List;


public interface IExperienceService {
    List<ExperienceResponse> getExperiences(VoidRequest voidRequest);

    ExperienceResponse createExperience(ExperienceRequest experienceRequest);

    void deleteExperience(String id);

    ExperienceResponse patchExperience(String id, ExperienceRequest body);

}
