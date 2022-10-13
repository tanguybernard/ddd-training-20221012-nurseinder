package com.zenika.nurseinder.meeting.domain.calendar_aggregate;

import lombok.Data;

@Data
public class CalendarId {

    public final String id;

    public CalendarId(String s) {
        this.id = s;
    }
}
