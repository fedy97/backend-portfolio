package com.fedy97.springbootserver.services.interfaces;


import com.fedy97.springbootserver.payload.request.PersonalRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.PersonalResponse;


public interface IPersonalService {
    PersonalResponse getPersonal(VoidRequest voidRequest);

    PersonalResponse createPersonal(PersonalRequest personalRequest);

    PersonalResponse patchPersonal(PersonalRequest body);

}
