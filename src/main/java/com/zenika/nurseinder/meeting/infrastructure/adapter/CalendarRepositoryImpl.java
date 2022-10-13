package com.zenika.nurseinder.meeting.infrastructure.adapter;

import java.util.Date;
import java.util.NoSuchElementException;

import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import com.zenika.nurseinder.meeting.infrastructure.CalendarDAO;
import com.zenika.nurseinder.meeting.infrastructure.models.CalendarEntity;

public class CalendarRepositoryImpl implements CalendarRepository {

    private final CalendarDAO calendarDao;

    public CalendarRepositoryImpl(CalendarDAO calendarDao) {
        this.calendarDao = calendarDao;
    }

    @Override
    public void save(Calendar calendar) {

        System.out.println(calendar.id.id);
        CalendarEntity c = new CalendarEntity();
        c.setId(calendar.id.id);

        CalendarEntity e = this.calendarDao.save(c);
        System.out.println("CALENDAR ENTITY");
        System.out.println(e.id);
    }

    @Override
    public Calendar find(CalendarId id) {
        CalendarEntity c = calendarDao.findById(id.getId()).orElseThrow(() -> new NoSuchElementException("No Calendar with id " + id));
        //TODO DO A REAL MAPPING
        return Calendar.builder().beginDate(new Date()).build();
    }
}
