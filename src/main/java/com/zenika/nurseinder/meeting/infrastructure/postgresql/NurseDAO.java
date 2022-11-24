package com.zenika.nurseinder.meeting.infrastructure.postgresql;

import com.zenika.nurseinder.meeting.infrastructure.models.NurseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseDAO extends JpaRepository<NurseEntity, String> {

}
