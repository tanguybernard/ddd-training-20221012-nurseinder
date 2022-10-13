package com.zenika.nurseinder.shared_kernel.domain_event;

public interface EventHandler<Event extends DomainEvent> {

    void handle(Event evt);
}
