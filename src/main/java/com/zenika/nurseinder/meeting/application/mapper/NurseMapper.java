package com.zenika.nurseinder.meeting.application.mapper;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zenika.nurseinder.meeting.application.dto.CreateNurseDTO;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.NurseId;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.OrdinalId;

@Service
public class NurseMapper {

    public Nurse from(CreateNurseDTO createNurseDto) {
        return Nurse.builder()
                .id(new NurseId(UUID.randomUUID().toString()))
                .name(createNurseDto.name())
                .ordinalId(new OrdinalId(createNurseDto.ordinalId()))
                .email(createNurseDto.email())
                .address(createNurseDto.address())
                .km(createNurseDto.km())
                .sales(createNurseDto.sales())
                .courses(createNurseDto.courses())
                .build();
    }
}
