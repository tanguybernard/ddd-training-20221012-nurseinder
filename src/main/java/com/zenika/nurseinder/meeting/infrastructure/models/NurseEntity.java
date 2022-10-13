package com.zenika.nurseinder.meeting.infrastructure.models;


import java.util.List;

import javax.persistence.*;

@Entity
public class NurseEntity {

    @Id
    public String id;

    @Column
    public String name;
    @Column
    public String ordinalId;
    @Column
    public String email;

    @Column
    public String address;

    @Column
    public int km;

    @Transient
    public List<String> courses;

    @Column
    public int sales;

    @Column
    private String  calendar;


}
