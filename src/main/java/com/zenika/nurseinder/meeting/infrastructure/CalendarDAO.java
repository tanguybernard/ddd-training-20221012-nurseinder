package com.zenika.nurseinder.meeting.infrastructure;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zenika.nurseinder.meeting.domain.Calendar;

@Repository
public interface CalendarDAO extends CrudRepository<Calendar, String> {

    Optional<Calendar> findByBeginDate(Date beginDate);

}
