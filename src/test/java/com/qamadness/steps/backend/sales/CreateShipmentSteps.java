package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.CreateShipment;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateShipmentSteps extends ScenarioSteps{
    CreateShipment createShipment;

    @Step
    public void create_shipment_for_order(){
        createShipment.createShipmentForOrder();
    }

}
