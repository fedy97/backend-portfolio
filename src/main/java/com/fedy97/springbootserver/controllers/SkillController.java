package com.fedy97.springbootserver.controllers;

import com.fedy97.springbootserver.payload.request.SkillRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.SkillResponse;
import com.fedy97.springbootserver.services.interfaces.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private ISkillService skillService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<SkillResponse>> getAllSkills(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "1000") int size,
                                                                @RequestParam(defaultValue = "skillName,asc") String[] sort
                                                                //@RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(skillService.getSkills(new VoidRequest(size,page,sort, true)));
    }

    @PostMapping("/new")
    public ResponseEntity<SkillResponse> createSkill(@Valid @RequestBody SkillRequest body) {
        return ResponseEntity.ok(skillService.createSkill(body));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkill(@PathVariable String id) {
        skillService.deleteSkill(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<SkillResponse> patchSkill(@PathVariable String id, @RequestBody SkillRequest body) {
        return ResponseEntity.ok(skillService.patchSkill(id, body));
    }
}
