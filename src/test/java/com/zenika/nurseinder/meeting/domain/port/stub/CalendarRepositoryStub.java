package com.zenika.nurseinder.meeting.domain.port.stub;

import java.util.HashMap;
import java.util.Map;

import com.zenika.nurseinder.meeting.domain.Calendar;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;

public class CalendarRepositoryStub implements CalendarRepository {

    private final Map<CalendarId, Calendar> database = new HashMap<>();

    @Override
    public Calendar save(Calendar calendar) {
        database.put(calendar.getId(), calendar);
        return calendar;
    }

    @Override
    public Calendar find(CalendarId id) {
        return database.get(id);
    }

}
