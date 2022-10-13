package com.zenika.nurseinder.meeting.domain.port;

import org.springframework.stereotype.Service;

import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;

@Service
public interface CalendarRepository {

    void save(Calendar calendar);

    Calendar find(CalendarId id);
}
