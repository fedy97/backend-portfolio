package com.fedy97.springbootserver.commands.education.get_educations;


import com.fedy97.springbootserver.commands.base.CommandExecutor;
import com.fedy97.springbootserver.models.Education;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import com.fedy97.springbootserver.repositories.EducationRepository;
import com.fedy97.springbootserver.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetEducationsCommandExecutor implements CommandExecutor<GetEducationsCommandRequest, GetEducationsCommandResponse> {

    @Autowired
    EducationRepository educationRepository;

    private List<EducationResponse> getEducations(VoidRequest voidRequest) {
        Page<Education> educations;
        Pageable pageable;
        if (voidRequest.isDoSort() && voidRequest.getSort()[1] != null && voidRequest.getSort()[1].equals("asc"))
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize(),
                    Sort.by(voidRequest.getSort()[0]).ascending());
        else if (voidRequest.isDoSort())
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize(),
                    Sort.by(voidRequest.getSort()[0]).descending());
        else {
            pageable = PageRequest.of(voidRequest.getPage(), voidRequest.getSize());
        }
        educations = educationRepository.findAll(pageable);
        return educations.stream().map(education -> Utils.convertEntityToDto(education, EducationResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetEducationsCommandResponse execute(GetEducationsCommandRequest command) {
        List<EducationResponse> entityList = getEducations(command.getVoidRequest());
        return new GetEducationsCommandResponse(entityList);
    }

}
