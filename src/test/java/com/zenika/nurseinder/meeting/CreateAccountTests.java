package com.zenika.nurseinder.meeting;

import com.zenika.nurseinder.meeting.domain.nurse_aggregate.MedicalOffice;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.NurseId;
import com.zenika.nurseinder.meeting.domain.nurse_aggregate.OrdinalId;
import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;


public class CreateAccountTests {

    @Test
     void createNurseAccount(){

        NurseId id = new NurseId("abc");
        String name = "Paul";
        OrdinalId oid = new OrdinalId("1234");

        Nurse nurse = Nurse.create(id, name, oid, "mail", new MedicalOffice("medicalOffice"), 10, Collections.emptyList(), 123000, new CalendarId("calendar-id-1"));

        Assertions.assertThat(nurse.getId().equals(new NurseId("abc"))).isTrue();

    }

}
