package com.zenika.nurseinder.meeting.api.nurse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zenika.nurseinder.meeting.application.CreateNurse;
import com.zenika.nurseinder.meeting.application.dto.CreateNurseDTO;

@RestController
@RequestMapping("/nurses")
public class CreateNurseRessource {

    private final CreateNurse createNurse;

    public CreateNurseRessource(CreateNurse createNurse) {
        this.createNurse = createNurse;
    }

    @PostMapping
    public ResponseEntity<Void> createNurse(@RequestBody CreateNurseDTO createNurseDto) {
        createNurse.create(createNurseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
