package com.fedy97.springbootserver.services;


import com.fedy97.springbootserver.payload.request.NewExperienceRequest;
import com.fedy97.springbootserver.payload.request.PatchExperienceRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;

import java.util.List;


public interface IExperienceService {
    List<ExperienceResponse> getExperiences(VoidRequest voidRequest);

    ExperienceResponse createExperience(NewExperienceRequest experienceRequest);

    void deleteExperience(String id);

    ExperienceResponse patchExperience(String id, PatchExperienceRequest body);

}
