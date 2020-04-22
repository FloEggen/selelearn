package com.formation.seletuto.dojo;

import com.formation.seletuto.dojo.steplibraries.Barrista;
import com.formation.seletuto.dojo.steplibraries.Customer;
import com.formation.seletuto.dojo.steplibraries.UserRegistrationClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderACoffeeStepDefinitions {

    @Steps
    UserRegistrationClient userRegistrations;

    @Steps
    Customer cathy;

    @Steps
    Barrista barry;

    @Given("Cathy has a Caffeinate-Me account")
    public void userHasACaffeinateMeAccount(){
        userRegistrations.registerUser(cathy);
    }

    OrderReceipt orderReceipt;
    @When("^s?he orders a (.*)$")
    public void sheOrdersALargeCappuccino(String order){
        orderReceipt = cathy.placesAnOrderFor(1, order);
    }

    @Then("^Barry should receive the order$")
    public void barryShouldReceiveTheOrder(){
        assertThat(barry.pendingOrders()).contains(Order.matching(orderReceipt));
    }


}
