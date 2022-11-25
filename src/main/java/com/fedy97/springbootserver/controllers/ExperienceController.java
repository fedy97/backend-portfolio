package com.fedy97.springbootserver.controllers;

import com.fedy97.springbootserver.payload.request.ExperienceRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.ExperienceResponse;
import com.fedy97.springbootserver.services.interfaces.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/experiences")
public class ExperienceController {

    @Autowired
    private IExperienceService experienceService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<ExperienceResponse>> getAllExperiences(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "1000") int size,
                                                                @RequestParam(defaultValue = "startYear,desc") String[] sort
                                                                //@RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(experienceService.getExperiences(new VoidRequest(size,page,sort, true)));
    }

    @PostMapping("/new")
    public ResponseEntity<ExperienceResponse> createExperience(@Valid @RequestBody ExperienceRequest body) {
        return ResponseEntity.ok(experienceService.createExperience(body));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExperience(@PathVariable String id) {
        experienceService.deleteExperience(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ExperienceResponse> patchExperience(@PathVariable String id, @RequestBody ExperienceRequest body) {
        return ResponseEntity.ok(experienceService.patchExperience(id, body));
    }
}
