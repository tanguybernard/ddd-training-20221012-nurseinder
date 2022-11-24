package com.zenika.nurseinder.meeting.infrastructure.bus;

import com.zenika.nurseinder.meeting.domain.port.EventBus;
import com.zenika.nurseinder.shared_kernel.infrastructure.IntegrationEvent;

public class RabbitEventBus implements EventBus {

    //inject service RabbitMq

    public void emit(IntegrationEvent event) {
        // rabbitmq send message to channel

    }

}
