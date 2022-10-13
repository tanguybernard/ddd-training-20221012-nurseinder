package com.zenika.nurseinder.meeting.domain;

import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Calendar {

  private CalendarId id;

  private Date beginDate;

  private Date endDate;

  private List<Period> periods;

  public boolean checkCalendar() {
    if (endDate!= null && beginDate != null && beginDate.before(endDate)) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  public void addPeriod(Period period) {

  }
}
