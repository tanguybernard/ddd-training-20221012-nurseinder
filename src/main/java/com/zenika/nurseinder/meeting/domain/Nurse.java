package com.zenika.nurseinder.meeting.domain;

import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;
import com.zenika.nurseinder.shared_kernel.Entity;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nurse extends Entity {

    private String name;
    private OrdinalId ordinalId;
    private String email;
    private MedicalOffice address;
    private int km;
    private List<String> courses;
    private int sales;
    private CalendarId calendar;

    public Nurse(NurseId id, String name, OrdinalId ordinalId, String email, MedicalOffice address, int km, List<String> courses, int sales, CalendarId calendar) {
        super(id);
        this.name = name;

        this.ordinalId = ordinalId;
        this.email = email;
        this.address = address;
        this.km = km;
        this.courses = courses;
        this.sales = sales;
        this.calendar = calendar;
    }

    public static Nurse create(NurseId id, String name, OrdinalId ordinalId, String email, MedicalOffice address, int km, List<String> courses, int sales, CalendarId calendar){
        return new  Nurse(id, name, ordinalId, email, address, km, courses, sales, calendar);
    }
}
