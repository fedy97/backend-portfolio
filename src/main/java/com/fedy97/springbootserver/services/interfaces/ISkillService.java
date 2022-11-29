package com.fedy97.springbootserver.services.interfaces;


import com.fedy97.springbootserver.payload.request.SkillRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.SkillResponse;

import java.util.List;


public interface ISkillService {
    List<SkillResponse> getSkills(VoidRequest voidRequest);

    SkillResponse createSkill(SkillRequest skillRequest);

    void deleteSkill(String id);

    SkillResponse patchSkill(String id, SkillRequest body);

}
