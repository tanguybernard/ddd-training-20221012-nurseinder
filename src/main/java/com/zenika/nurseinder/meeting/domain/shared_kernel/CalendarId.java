package com.zenika.nurseinder.meeting.domain.shared_kernel;

import lombok.Data;

@Data
public class CalendarId {

    private final String id;

    public CalendarId(String s) {
        this.id = s;
    }
}
