package com.zenika.nurseinder.meeting;

import static org.assertj.core.api.Assertions.assertThat;

import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Day;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Period;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Status;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

class CreateCalendarTest {

  @Test
  void checkCalendar_test() {

    java.util.Calendar cld = java.util.Calendar.getInstance();
    Date beginDate = new Date();
    cld.add(java.util.Calendar.DAY_OF_MONTH, 2);
    Date endDate = cld.getTime();

        Calendar calendar = Calendar.builder()
        .id(new CalendarId("123"))
        .beginDate(beginDate)
        .endDate(endDate)
        .periods(List.of(Period.builder()
                .beginDate(beginDate)
                .endDate(endDate)
                .days(List.of(Day.builder()
                        .type("mon-super-type")
                        .date(new Date())
                    .build()))
                .status(Status.AVAILABLE)
            .build()))
        .build();

    assertThat(calendar.checkCalendar()).isTrue();

  }
}
