package com.zenika.nurseinder.meeting.infrastructure.adapter;

import java.util.NoSuchElementException;

import com.zenika.nurseinder.meeting.domain.Calendar;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;
import com.zenika.nurseinder.meeting.infrastructure.CalendarDAO;

public class CalendarRepositoryImpl implements CalendarRepository {

    private final CalendarDAO calendarDao;

    public CalendarRepositoryImpl(CalendarDAO calendarDao) {
        this.calendarDao = calendarDao;
    }

    @Override
    public Calendar save(Calendar calendar) {
        return calendarDao.save(calendar);
    }

    @Override
    public Calendar find(CalendarId id) {
        return calendarDao.findById(id.getId()).orElseThrow(() -> new NoSuchElementException("No Calendar with id " + id));
    }
}
