package com.qamadness.steps.sales;


import com.qamadness.pages.sales.CreateShipment;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateShipmentSteps extends ScenarioSteps{
    CreateShipment createShipment;

    @Step
    public void create_shipment_for_order(){
        createShipment.createShipmentForOrder();
    }

    @Step
    public void check_shipment_is_created(){
        createShipment.checkShipmentIsCreated();
    }

}
