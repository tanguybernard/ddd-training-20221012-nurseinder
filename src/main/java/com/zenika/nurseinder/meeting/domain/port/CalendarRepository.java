package com.zenika.nurseinder.meeting.domain.port;

import org.springframework.stereotype.Service;

import com.zenika.nurseinder.meeting.domain.Calendar;
import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;

@Service
public interface CalendarRepository {

    Calendar save(Calendar calendar);

    Calendar find(CalendarId id);
}
