package com.zenika.nurseinder.configuration;

import com.zenika.nurseinder.meeting.application.CreateNurse;
import com.zenika.nurseinder.meeting.application.mapper.NurseMapper;
import com.zenika.nurseinder.meeting.domain.service.AssignCalendarToNurseService;
import com.zenika.nurseinder.meeting.infrastructure.CalendarDAO;
import com.zenika.nurseinder.meeting.infrastructure.NurseDAO;
import com.zenika.nurseinder.meeting.infrastructure.adapter.CalendarRepositoryImpl;
import com.zenika.nurseinder.meeting.infrastructure.adapter.NurseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration

public class DIConfiguration {


    @Bean
    public CreateNurse createNurse(CalendarDAO calendarDAO, NurseDAO nurseDAO){
        return new CreateNurse(
                new NurseMapper(),
                new CalendarRepositoryImpl(calendarDAO),
                new NurseRepositoryImpl(nurseDAO),
                new AssignCalendarToNurseService()
        );
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}