package com.zenika.nurseinder.meeting.infrastructure.adapter;

import java.util.List;

import com.zenika.nurseinder.meeting.domain.Nurse;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;
import com.zenika.nurseinder.meeting.infrastructure.NurseDAO;

public class NurseRepositoryImpl implements NurseRepository {

    private final NurseDAO nurseDao;

    public NurseRepositoryImpl(NurseDAO nurseDao) {
        this.nurseDao = nurseDao;
    }

    @Override
    public Nurse save(Nurse nurse) {
        return nurseDao.save(nurse);
    }

    @Override
    public List<Nurse> findAll() {
        return nurseDao.findAll();
    }

}
