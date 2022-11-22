package com.fedy97.springbootserver.payload.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class SerializableResponse {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    SerializableResponse() {

    }

    protected String writeJson() throws JsonProcessingException {
        return objectMapper.writeValueAsString(this);
    }

}
