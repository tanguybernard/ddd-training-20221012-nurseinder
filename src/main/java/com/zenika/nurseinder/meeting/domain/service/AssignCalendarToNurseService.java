package com.zenika.nurseinder.meeting.domain.service;

import com.zenika.nurseinder.meeting.domain.Calendar;
import com.zenika.nurseinder.meeting.domain.Nurse;
import com.zenika.nurseinder.meeting.domain.Period;
import com.zenika.nurseinder.meeting.domain.exception.CalendarException;
import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AssignCalendarToNurseService {

  public Calendar createCalendar(Date beginDate, Date endDate, List<Period> periods) {
    return Calendar.builder()
        .id(new CalendarId("123"))
        .beginDate(beginDate)
        .endDate(endDate)
        .periods(periods)
        .build();
  }

  public void assign(Calendar calendar, Nurse nurse) {
    if (calendar == null || calendar.getId() == null) {
      throw new CalendarException();
    }
    CalendarId calendarId = calendar.getId();
    nurse.setCalendar(calendarId);
  }
}
