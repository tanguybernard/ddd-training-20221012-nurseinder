package com.zenika.nurseinder.meeting.domain.events;

import com.zenika.nurseinder.shared_kernel.domain_event.DomainEvent;

import java.util.Date;

public class NurseCreatedEvent implements DomainEvent {


    public NurseCreatedEvent(String aggregateId, Date occurredOn){

    }

    public String eventName = "nurse.created";

}
