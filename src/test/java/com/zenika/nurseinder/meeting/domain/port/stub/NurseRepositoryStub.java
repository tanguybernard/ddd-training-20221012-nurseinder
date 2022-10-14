package com.zenika.nurseinder.meeting.domain.port.stub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.NurseId;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;

public class NurseRepositoryStub implements NurseRepository {

    private final Map<String, Nurse> database = new HashMap<>();

    @Override
    public void save(Nurse nurse) {
        database.put(nurse.getId().value(), nurse);
    }

    @Override
    public Nurse find(NurseId nurseId) throws Exception {
        return database.get(nurseId.value());
    }

    public List<Nurse> findAll() {
        return database.values().stream().toList();
    }

}
