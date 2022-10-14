package com.zenika.nurseinder.bdd.stepdefs;

import com.zenika.nurseinder.bdd.ResponseResults;
import com.zenika.nurseinder.bdd.SpringIntegrationTest;
import com.zenika.nurseinder.meeting.presentation.NurseController;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//Not the real use case
public class NurseStepTest extends SpringIntegrationTest {

    @Autowired
    NurseController controller;

    @Given("user wants to create an nurse account with the following attributes")
    public void i_have_hungry_snake(DataTable table) throws IOException {

        List<Map<String, String>> signUpForms = table.asMaps(String.class, String.class);
        String id = signUpForms.get(0).get("id");
        String name = signUpForms.get(0).get("name");
        System.out.println(name);
    }

    @When("^user saves the Nurse account$")
    public void when_i_feed_my_snake() throws IOException {

        this.executeGet("http://localhost:8080/nurses/poke");
    }

    @Then("^the save 'IS SUCCESSFUL'$")
    public void receive_snek_snek() throws IOException {
        assertThat(latestResponse).isNotNull();
        assertThat(latestResponse.getTheResponse().getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
