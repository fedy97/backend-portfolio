package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.payload.request.PagebleRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;

import java.util.List;


public interface IExperiencesService {
    List<ExperienceResponse> getExperiences(VoidRequest voidRequest);

}
