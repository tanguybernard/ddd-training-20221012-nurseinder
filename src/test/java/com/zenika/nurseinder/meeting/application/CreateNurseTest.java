package com.zenika.nurseinder.meeting.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;
import java.util.List;

import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;
import org.junit.jupiter.api.Test;

import com.zenika.nurseinder.meeting.application.dto.CreateNurseDTO;
import com.zenika.nurseinder.meeting.application.mapper.NurseMapper;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.Calendar;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.exception.CalendarException;
import com.zenika.nurseinder.meeting.domain.port.CalendarRepository;
import com.zenika.nurseinder.meeting.domain.port.NurseRepository;
import com.zenika.nurseinder.meeting.domain.port.stub.CalendarRepositoryStub;
import com.zenika.nurseinder.meeting.domain.port.stub.NurseRepositoryStub;
import com.zenika.nurseinder.meeting.domain.service.AssignCalendarToNurseService;

public class CreateNurseTest {

    private NurseMapper nurseMapper = new NurseMapper();

    private NurseRepository nurseRepository = new NurseRepositoryStub();

    private CalendarRepository calendarRepository = new CalendarRepositoryStub();

    private AssignCalendarToNurseService assignCalendarToNurseService = new AssignCalendarToNurseService();

    private CreateNurse createNurse = new CreateNurse(nurseMapper, calendarRepository, nurseRepository,
            assignCalendarToNurseService);

    @Test
    public void create_ShouldAssignCalendarToNurse() throws Exception {
        Nurse nurseCreated = createNurse.create(new CreateNurseDTO("toto", "ordinalId", "toto@mail.com", null, 0, List.of("mon super cours"), 0));

        System.out.println(nurseCreated);
        Nurse nurse = nurseRepository.find(nurseCreated.getId());

        assertThat(nurse).isNotNull();

        CalendarId calendarId = nurse.getCalendar();

        assertThat(calendarRepository.find(calendarId)).isNotNull();
    }

    @Test
    public void create_ShouldFailWithCalendarExceptionIfCalendarIsInvalid() {
        assertThrows(CalendarException.class, () -> {
            createNurse.create(new CreateNurseDTO("toto", "ordinalId", "toto@mail.com", null, 0, List.of("mon super cours"), 0),
                    Calendar.builder().beginDate(new Date()).build());
        });
    }
}
