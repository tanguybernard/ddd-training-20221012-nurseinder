package com.zenika.nurseinder.meeting.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Builder
@Data
public class Calendar {

    private CalendarId id;

    private Date beginDate;

    private Date endDate;

    @Transient
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
