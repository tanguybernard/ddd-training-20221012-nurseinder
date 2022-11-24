package com.zenika.nurseinder.meeting.domain.port;

import com.zenika.nurseinder.shared_kernel.infrastructure.IntegrationEvent;

public interface EventBus {

    void emit(IntegrationEvent event);

}
