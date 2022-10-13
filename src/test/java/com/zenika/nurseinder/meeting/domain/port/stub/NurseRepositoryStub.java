package com.zenika.nurseinder.meeting.domain.port.stub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zenika.nurseinder.meeting.domain.Nurse;
import com.zenika.nurseinder.meeting.domain.NurseId;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;

public class NurseRepositoryStub implements NurseRepository {

    private final Map<NurseId, Nurse> database = new HashMap<>();

    @Override
    public Nurse save(Nurse nurse) {
        database.put(nurse.getId(), nurse);
        return nurse;
    }

    @Override
    public List<Nurse> findAll() {
        return database.values().stream().toList();
    }

}
