package com.formation.seletuto.dojo.steplibraries;

import com.formation.seletuto.dojo.CoffeeOrdersClient;
import com.formation.seletuto.dojo.Order;
import com.formation.seletuto.dojo.OrderReceipt;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class Barrista extends ScenarioActor {

    // Shared, to be able to use the same as cathy the customer
    @Steps(shared = true)
    CoffeeOrdersClient coffeeOrdersClient;

    @Step("#actor retrieves the list of orders")
    public List<Order> pendingOrders(){
        return coffeeOrdersClient.getOrders();
    }

}
