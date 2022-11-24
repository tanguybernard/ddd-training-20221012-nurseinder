package com.zenika.nurseinder.meeting.application;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import com.zenika.nurseinder.meeting.application.dto.CreateNurseDTO;
import com.zenika.nurseinder.meeting.application.mapper.NurseMapper;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.port.EventBus;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;
import com.zenika.nurseinder.meeting.domain.service.AssignCalendarToNurseService;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import com.zenika.nurseinder.meeting.infrastructure.bus.RabbitEventBus;

public class CreateNurse {

    private final NurseMapper nurseMapper;

    private final NurseRepository nurseRepository;

    private final CalendarRepository calendarRepository;

    private final AssignCalendarToNurseService assignCalendarToNurseService;

    public CreateNurse(
            EventBus eventBus,
            NurseMapper nurseMapper,
            CalendarRepository calendarRepository,
            NurseRepository nurseRepository,
            AssignCalendarToNurseService assignCalendarToNurseService) {
        this.nurseMapper = nurseMapper;
        this.calendarRepository = calendarRepository;
        this.nurseRepository = nurseRepository;
        this.assignCalendarToNurseService = assignCalendarToNurseService;
    }

    public Nurse create(CreateNurseDTO createNurseDto) {
        var cld = java.util.Calendar.getInstance();
        Date beginDate = new Date();
        cld.add(java.util.Calendar.DAY_OF_MONTH, 2);
        Date endDate = cld.getTime();

        return create(createNurseDto,
                Calendar.builder()
                        .id(new CalendarId(UUID.randomUUID().toString()))
                        .beginDate(beginDate)
                        .endDate(endDate)
                        .periods(Collections.emptyList())
                        .build());
    }

    public Nurse create(CreateNurseDTO createNurseDto, Calendar calendar) {
        var nurse = nurseMapper.from(createNurseDto);
        nurse = assignCalendarToNurseService.assign(calendar, nurse);//nurse completely created with setCalendar => raise domain event(see inside Nurse)



        //TODO Decide Strategy Placement
        //nurse.pullDomainEvents()
        //this.eventDispatcherDomain.emit(new DomainEvent)

        calendarRepository.save(calendar);
        nurseRepository.save(nurse);

        //this.eventBus.emit(new IntegrationEvent())

        return nurse;

    }
}
