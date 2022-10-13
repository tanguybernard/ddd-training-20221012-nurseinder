package com.zenika.nurseinder.meeting.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zenika.nurseinder.meeting.domain.shared_kernel.CalendarId;
import com.zenika.nurseinder.shared_kernel.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Table
@Getter
@Setter
public class Nurse extends Entity<String> {

    private String name;
    private OrdinalId ordinalId;
    private String email;

    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "medicalOffice", column = @Column(name = "address")) })
    private MedicalOffice address;

    private int km;
    @Transient
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

    public NurseId getId() {
        return (NurseId) id;
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
}
