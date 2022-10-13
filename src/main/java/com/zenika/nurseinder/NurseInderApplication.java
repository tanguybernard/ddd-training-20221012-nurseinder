package com.zenika.nurseinder;

import com.zenika.nurseinder.meeting.application.event_handlers.NurseCreatedEventHandler;
import com.zenika.nurseinder.shared_kernel.domain_event.DomainEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NurseInderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(NurseInderApplication.class, args);


        //TODO move registration of Handler for domain event
        //DomainEventPublisher.register(new NurseCreatedEventHandler(), NurseCreatedEventHandler.class.getName());

    }





}
