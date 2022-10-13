package com.zenika.nurseinder.meeting.application;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import com.zenika.nurseinder.meeting.application.dto.CreateNurseDTO;
import com.zenika.nurseinder.meeting.application.mapper.NurseMapper;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;
import com.zenika.nurseinder.meeting.domain.service.AssignCalendarToNurseService;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;

public class CreateNurse {

    private final NurseMapper nurseMapper;

    private final NurseRepository nurseRepository;

    private final CalendarRepository calendarRepository;

    private final AssignCalendarToNurseService assignCalendarToNurseService;

    public CreateNurse(
            NurseMapper nurseMapper,
            CalendarRepository calendarRepository,
            NurseRepository nurseRepository,
            AssignCalendarToNurseService assignCalendarToNurseService) {
        this.nurseMapper = nurseMapper;
        this.calendarRepository = calendarRepository;
        this.nurseRepository = nurseRepository;
        this.assignCalendarToNurseService = assignCalendarToNurseService;
    }

    public void create(CreateNurseDTO createNurseDto) {
        System.out.println("Creation USE CASE");
        var cld = java.util.Calendar.getInstance();
        Date beginDate = new Date();
        cld.add(java.util.Calendar.DAY_OF_MONTH, 2);
        Date endDate = cld.getTime();

        create(createNurseDto,
                Calendar.builder()
                        .id(new CalendarId(UUID.randomUUID().toString()))
                        .beginDate(beginDate)
                        .endDate(endDate)
                        .periods(Collections.emptyList())
                        .build());
    }

    public void create(CreateNurseDTO createNurseDto, Calendar calendar) {
        var nurse = nurseMapper.from(createNurseDto);
        assignCalendarToNurseService.assign(calendar, nurse);//nurse completely created with setCalendar => raise domain event(see inside Nurse)

        calendarRepository.save(calendar);
        nurseRepository.save(nurse);

    }
}
