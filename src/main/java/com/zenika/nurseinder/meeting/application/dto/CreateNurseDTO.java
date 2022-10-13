package com.zenika.nurseinder.meeting.application.dto;

import java.util.List;

import com.zenika.nurseinder.meeting.domain.MedicalOffice;

public record CreateNurseDTO(String name, String ordinalId, String email, MedicalOffice address, int km, List<String> courses,
        int sales) {

}
