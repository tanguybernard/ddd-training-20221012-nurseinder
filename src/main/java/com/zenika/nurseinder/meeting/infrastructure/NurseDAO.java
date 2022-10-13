package com.zenika.nurseinder.meeting.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenika.nurseinder.meeting.domain.Nurse;

@Repository
public interface NurseDAO extends JpaRepository<Nurse, String> {

}
