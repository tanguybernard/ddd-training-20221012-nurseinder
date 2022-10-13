package com.zenika.nurseinder.meeting.domain.nurse_aggregate;

import javax.persistence.Embeddable;

@Embeddable
public class MedicalOffice {

    private final String medicalOffice;

    public MedicalOffice(String medicalOffice) {
        this.medicalOffice = medicalOffice;
    }
}
