package com.zenika.nurseinder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenika.nurseinder.meeting.application.dto.CreateNurseDTO;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(CreateNurseRessource.class)
@SpringBootTest
@AutoConfigureMockMvc
class CreateNurseIntegrationTest {

    //@MockBean
    //private CreateNurse createNurse;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createNurse() throws Exception {
        CreateNurseDTO createNurseDto = new CreateNurseDTO("name", "229349999", "email", null, 0, Collections.emptyList(), 0);

        byte[] contentAsBytes = objectMapper.writeValueAsBytes(createNurseDto);

        MockHttpServletResponse response = mockMvc
                .perform(post("/nurses").content(contentAsBytes)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(201);
    }

}
