package com.zenika.nurseinder.meeting.infrastructure.models;
import javax.persistence.*;

@Entity
public class CalendarEntity {

    public void setId(String id){
        this.id = id;
    }

    @Id
    public String id;


}
