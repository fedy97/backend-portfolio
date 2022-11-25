package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.education.create_education.CreateEducationCommandRequest;
import com.fedy97.springbootserver.commands.education.create_education.CreateEducationCommandResponse;
import com.fedy97.springbootserver.commands.education.delete_education.DeleteEducationCommandRequest;
import com.fedy97.springbootserver.commands.education.get_educations.GetEducationsCommandRequest;
import com.fedy97.springbootserver.commands.education.get_educations.GetEducationsCommandResponse;
import com.fedy97.springbootserver.commands.education.patch_education.PatchEducationCommandRequest;
import com.fedy97.springbootserver.commands.education.patch_education.PatchEducationCommandResponse;
import com.fedy97.springbootserver.payload.request.EducationRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import com.fedy97.springbootserver.services.interfaces.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducationService implements IEducationService {

    @Autowired
    private SpringCommandDispatcher commandDispatcher;
    @Override
    public List<EducationResponse> getEducations(VoidRequest voidRequest) {
        GetEducationsCommandResponse responseCommand = commandDispatcher.dispatch(new GetEducationsCommandRequest(voidRequest));
        return responseCommand.getEducationsList();
    }

    @Override
    public EducationResponse createEducation(EducationRequest educationRequest) {
        CreateEducationCommandResponse response = commandDispatcher.dispatch(new CreateEducationCommandRequest(educationRequest));
        return response.getEducationResponse();
    }

    @Override
    public void deleteEducation(String id) {
        commandDispatcher.dispatch(new DeleteEducationCommandRequest(id));
    }

    @Override
    public EducationResponse patchEducation(String id, EducationRequest educationRequest) {
        PatchEducationCommandResponse response = commandDispatcher.dispatch(new PatchEducationCommandRequest(educationRequest, id));
        return response.getEducationResponse();
    }

}
