package com.zenika.nurseinder.meeting;

import com.zenika.nurseinder.meeting.domain.MedicalOffice;
import com.zenika.nurseinder.meeting.domain.Nurse;
import com.zenika.nurseinder.meeting.domain.NurseId;
import com.zenika.nurseinder.meeting.domain.OrdinalId;
import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import static org.assertj.core.api.Assertions.*;


public class CreateAccountTests {

    @Test
     void createNurseAccount(){

        NurseId id = new NurseId("abc");
        String name = "Paul";
        OrdinalId oid = new OrdinalId("1234");

        Nurse nurse = Nurse.create(id, name, oid, "mail", new MedicalOffice("medicalOffice"), 10, Collections.emptyList(), 123000, new CalendarId("calendar-id-1"));

        Assertions.assertThat(nurse.id.equals(new NurseId("abc"))).isTrue();

    }

}
