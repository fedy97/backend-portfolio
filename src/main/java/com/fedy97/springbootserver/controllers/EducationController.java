package com.fedy97.springbootserver.controllers;

import com.fedy97.springbootserver.payload.request.EducationRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.EducationResponse;
import com.fedy97.springbootserver.services.interfaces.IEducationService;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import com.fedy97.springbootserver.utils.validation_groups.PatchGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private IEducationService educationService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<EducationResponse>> getAllEducations(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "1000") int size,
                                                                @RequestParam(defaultValue = "startYear,desc") String[] sort
                                                                //@RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(educationService.getEducations(new VoidRequest(size,page,sort, true)));
    }

    @PostMapping("/new")
    public ResponseEntity<EducationResponse> createEducation(@Validated(NewGroup.class) @RequestBody EducationRequest body) {
        return ResponseEntity.ok(educationService.createEducation(body));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEducation(@PathVariable String id) {
        educationService.deleteEducation(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<EducationResponse> patchEducation(@PathVariable String id, @Validated(PatchGroup.class) @RequestBody EducationRequest body) {
        return ResponseEntity.ok(educationService.patchEducation(id, body));
    }
}
