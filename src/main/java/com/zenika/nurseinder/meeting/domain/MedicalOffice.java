package com.zenika.nurseinder.meeting.domain;

import javax.persistence.Embeddable;

@Embeddable
public class MedicalOffice {

    private final String medicalOffice;

    public MedicalOffice(String medicalOffice) {
        this.medicalOffice = medicalOffice;
    }
}
