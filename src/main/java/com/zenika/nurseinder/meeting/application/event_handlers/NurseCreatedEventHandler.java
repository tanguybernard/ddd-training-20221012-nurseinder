package com.zenika.nurseinder.meeting.application.event_handlers;

import com.zenika.nurseinder.meeting.domain.events.NurseCreatedEvent;
import com.zenika.nurseinder.shared_kernel.domain_event.EventHandler;

public class NurseCreatedEventHandler implements EventHandler<NurseCreatedEvent> {
    @Override
    public void handle(NurseCreatedEvent evt) {
        //TODO
        //use repository to persist , make some action...

    }
}
