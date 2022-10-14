package com.zenika.nurseinder.meeting.domain.nurse_aggregate;

import java.util.List;

import com.zenika.nurseinder.meeting.domain.calendar_aggregate.CalendarId;
import com.zenika.nurseinder.shared_kernel.AggregateRoot;

import lombok.Builder;

public class Nurse extends AggregateRoot<NurseId> {

    private NurseId id;
    private String name;
    private OrdinalId ordinalId;
    private String email;

    private MedicalOffice address;

    private int km;
    private List<String> courses;

    private int sales;

    private CalendarId calendar;

    @Builder
    public Nurse(
            NurseId id,
            String name,
            OrdinalId ordinalId,
            String email,
            MedicalOffice address,
            int km,
            List<String> courses,
            int sales,
            CalendarId calendar) {
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
    public static Nurse create(
            NurseId id,
            String name,
            OrdinalId ordinalId,
            String email,
            MedicalOffice address,
            int km,
            List<String> courses,
            int sales,
            CalendarId calendar) {
        return new Nurse(id, name, ordinalId, email, address, km, courses, sales, calendar);
    }

    public void setCalendar(CalendarId calendarId) {

        this.calendar = calendarId;
        //this.record(new NurseCreatedEvent(this.id.value(), new Date()));

    }

    public CalendarId getCalendar() {
        return calendar;
    }
}
