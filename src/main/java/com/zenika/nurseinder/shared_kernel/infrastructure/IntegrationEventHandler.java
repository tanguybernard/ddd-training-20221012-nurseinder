package com.zenika.nurseinder.shared_kernel.infrastructure;

import com.zenika.nurseinder.shared_kernel.domain_event.DomainEvent;

public interface IntegrationEventHandler<Event extends IntegrationEvent> {

    void handle(Event evt);
}
