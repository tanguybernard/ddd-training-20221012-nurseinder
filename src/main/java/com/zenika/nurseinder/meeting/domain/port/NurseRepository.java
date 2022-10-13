package com.zenika.nurseinder.meeting.domain.port;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zenika.nurseinder.meeting.domain.Nurse;

@Service
public interface NurseRepository {

    Nurse save(Nurse nurse);

    List<Nurse> findAll();
}
