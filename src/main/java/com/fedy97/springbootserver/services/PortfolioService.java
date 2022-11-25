package com.fedy97.springbootserver.services;

import com.fedy97.springbootserver.commands.SpringCommandDispatcher;
import com.fedy97.springbootserver.commands.education.get_educations.GetEducationsCommandRequest;
import com.fedy97.springbootserver.commands.education.get_educations.GetEducationsCommandResponse;
import com.fedy97.springbootserver.commands.experience.get_experiences.GetExperiencesCommandRequest;
import com.fedy97.springbootserver.commands.experience.get_experiences.GetExperiencesCommandResponse;
import com.fedy97.springbootserver.commands.personal.get_personal.GetPersonalCommandRequest;
import com.fedy97.springbootserver.commands.personal.get_personal.GetPersonalCommandResponse;
import com.fedy97.springbootserver.commands.project.get_projects.GetProjectsCommandRequest;
import com.fedy97.springbootserver.commands.project.get_projects.GetProjectsCommandResponse;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.PortfolioResponse;
import com.fedy97.springbootserver.services.interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PortfolioService implements IPortfolioService {

    @Autowired
    private SpringCommandDispatcher commandDispatcher;
    @Override
    public PortfolioResponse getPortfolio(VoidRequest voidRequest) {
        try {
            PortfolioResponse portfolioResponse = new PortfolioResponse();
            GetPersonalCommandResponse personalCommandResponse = commandDispatcher.dispatch(new GetPersonalCommandRequest(voidRequest));
            GetExperiencesCommandResponse experiencesCommandResponse = commandDispatcher.dispatch(new GetExperiencesCommandRequest(voidRequest));
            GetEducationsCommandResponse educationsCommandResponse = commandDispatcher.dispatch(new GetEducationsCommandRequest(voidRequest));
            GetProjectsCommandResponse projectsCommandResponse = commandDispatcher.dispatch(new GetProjectsCommandRequest(voidRequest));
            portfolioResponse.setEducationResponses(educationsCommandResponse.getEducationsList());
            portfolioResponse.setPersonalResponse(personalCommandResponse.getPersonalList());
            portfolioResponse.setExperienceResponses(experiencesCommandResponse.getExperiencesList());
            portfolioResponse.setProjectResponses(projectsCommandResponse.getProjectsList());
            return portfolioResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
