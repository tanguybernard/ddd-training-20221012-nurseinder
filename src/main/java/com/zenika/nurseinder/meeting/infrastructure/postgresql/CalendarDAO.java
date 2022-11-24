package com.zenika.nurseinder.meeting.infrastructure.postgresql;

import com.zenika.nurseinder.meeting.infrastructure.models.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarDAO extends JpaRepository<CalendarEntity, String> {
}
