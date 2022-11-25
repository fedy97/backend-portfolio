package com.fedy97.springbootserver.commands.education.create_education;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Education;
import com.fedy97.springbootserver.payload.request.EducationRequest;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import com.fedy97.springbootserver.repositories.EducationRepository;
import com.fedy97.springbootserver.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEducationCommandExecutor implements CommandExecutor<CreateEducationCommandRequest, CreateEducationCommandResponse> {

    @Autowired
    EducationRepository educationRepository;

    @Override
    public CreateEducationCommandResponse execute(CreateEducationCommandRequest command) {
        EducationResponse entity = createEducation(command.getEducationRequest());
        return new CreateEducationCommandResponse(entity);
    }

    private EducationResponse createEducation(EducationRequest educationRequest) {
        Education education = Utils.convertDtoToEntity(educationRequest, Education.class);
        education = educationRepository.save(education);
        return Utils.convertEntityToDto(education, EducationResponse.class);
    }

}
