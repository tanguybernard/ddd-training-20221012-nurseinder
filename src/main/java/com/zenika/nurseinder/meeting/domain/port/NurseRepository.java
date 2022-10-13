package com.zenika.nurseinder.meeting.domain.port;

import com.zenika.nurseinder.meeting.domain.nurse_aggregate.NurseId;
import org.springframework.stereotype.Service;

import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;

@Service
public interface NurseRepository {

    void save(Nurse nurse);

    Nurse find(NurseId nurseId) throws Exception;

}
