package com.zenika.nurseinder.shared_kernel;

import com.zenika.nurseinder.shared_kernel.domain_event.DomainEvent;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class AggregateRoot<Id> extends Entity<Id> {


    public AggregateRoot(Id id) {
        super(id);
        this.id = id;
    }

    private List<DomainEvent> domainEvents = Collections.emptyList();

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> domainEvents = this.domainEvents;
        this.domainEvents = Collections.emptyList();
        return domainEvents;
    }

    protected void record(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }
}