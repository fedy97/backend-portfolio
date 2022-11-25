package com.fedy97.springbootserver.controllers;

import com.fedy97.springbootserver.payload.request.PersonalRequest;
import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.PersonalResponse;
import com.fedy97.springbootserver.services.interfaces.IPersonalService;
import com.fedy97.springbootserver.utils.validation_groups.NewGroup;
import com.fedy97.springbootserver.utils.validation_groups.PatchGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/personal")
public class PersonalController {

    @Autowired
    private IPersonalService personalService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<PersonalResponse> getPersonal(
            //@RequestParam(required = false) String email
    ) {
        return ResponseEntity.ok(personalService.getPersonal(new VoidRequest()));
    }

    @PostMapping("/new")
    public ResponseEntity<PersonalResponse> createPersonal(@Validated(NewGroup.class) @RequestBody PersonalRequest body) {
        return ResponseEntity.ok(personalService.createPersonal(body));
    }

    @PatchMapping("/update")
    public ResponseEntity<PersonalResponse> patchPersonal(@Validated(PatchGroup.class) @RequestBody PersonalRequest body) {
        return ResponseEntity.ok(personalService.patchPersonal(body));
    }
}
