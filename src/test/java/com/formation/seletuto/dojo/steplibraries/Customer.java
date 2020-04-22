package com.formation.seletuto.dojo.steplibraries;

import com.formation.seletuto.dojo.CoffeeOrdersClient;
import com.formation.seletuto.dojo.OrderReceipt;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class Customer extends ScenarioActor {

    private long customerId;

    // The same instance is used no matter what step definition class it is called from
    @Steps(shared = true)
    CoffeeOrdersClient coffeeOrdersClient;

    public void hasACustomerIdOf(long customerId){
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    @Step("#actor places an order for {0} {1}")
    public OrderReceipt placesAnOrderFor(int quantity, String product){
        return coffeeOrdersClient.placeOrder(customerId, quantity, product);
    }
}
