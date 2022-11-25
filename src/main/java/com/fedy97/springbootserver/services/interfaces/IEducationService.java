package com.fedy97.springbootserver.services.interfaces;


import com.fedy97.springbootserver.payload.request.EducationRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.EducationResponse;

import java.util.List;


public interface IEducationService {
    List<EducationResponse> getEducations(VoidRequest voidRequest);

    EducationResponse createEducation(EducationRequest educationRequest);

    void deleteEducation(String id);

    EducationResponse patchEducation(String id, EducationRequest body);

}
