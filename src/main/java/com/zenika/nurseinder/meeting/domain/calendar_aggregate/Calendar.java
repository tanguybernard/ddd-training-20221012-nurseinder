package com.zenika.nurseinder.meeting.domain.calendar_aggregate;

import java.util.Date;
import java.util.List;

import com.zenika.nurseinder.shared_kernel.Entity;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Calendar extends Entity<CalendarId> {

    public CalendarId id;

    private Date beginDate;

    private Date endDate;

    private List<Period> periods;

    public boolean checkCalendar() {
        if (endDate != null && beginDate != null && beginDate.before(endDate)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public void addPeriod(Period period) {

    }
}
