package com.fedy97.springbootserver.payload.request;

import lombok.Data;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class PatchExperienceRequest {
    private JsonNullable<String> role;
    private JsonNullable<Integer> startYear;
    private JsonNullable<Integer> endYear;
    private JsonNullable<String> company;
    private JsonNullable<String> link;
    private JsonNullable<String> description;
    private JsonNullable<List<String>> skills;
}
