package com.zenika.nurseinder.meeting.infrastructure.adapter;

import java.util.Collections;
import java.util.Optional;

import com.zenika.nurseinder.meeting.domain.nurse_aggregate.MedicalOffice;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.NurseId;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.OrdinalId;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import com.zenika.nurseinder.meeting.infrastructure.postgresql.NurseDAO;
import com.zenika.nurseinder.meeting.infrastructure.models.NurseEntity;

public class NurseRepositoryImpl implements NurseRepository {

    private final NurseDAO nurseDao;

    public NurseRepositoryImpl(NurseDAO nurseDao) {
        this.nurseDao = nurseDao;
    }

    @Override
    public void save(Nurse nurse) {
        System.out.println("SAVE NURSE");
        NurseEntity e = new NurseEntity();

        e.id = nurse.getId().value();
        nurseDao.save(e);
    }

    @Override
    public Nurse find(NurseId nurseId) throws Exception {

        Optional<NurseEntity> e = nurseDao.findById(nurseId.value());

        if(e.isPresent()){
            return Nurse.create(
                    new NurseId(e.get().id),
                    e.get().name,
                    new OrdinalId((e.get().ordinalId)),
                    e.get().email,
                    new MedicalOffice(e.get().address),
                    0,
                    Collections.emptyList(),
                    0,
                    new CalendarId("stub")
            );
        }
        else{
            throw new Exception("Not Found");
        }



    }

}
