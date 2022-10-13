package com.zenika.nurseinder.meeting.domain.port.stub;

import java.util.HashMap;
import java.util.Map;

import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;

public class CalendarRepositoryStub implements CalendarRepository {

    private final Map<CalendarId, Calendar> database = new HashMap<>();

    @Override
    public void save(Calendar calendar) {
        database.put(calendar.getId(), calendar);
    }

    @Override
    public Calendar find(CalendarId id) {
        return database.get(id);
    }

}
