package com.fedy97.springbootserver.payload.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class ProjectResponse {
    private String id;
    private String title;
    private String description;
    private List<String> stack;
    private String link;
}
