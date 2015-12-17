package com.qamadness.steps;

import com.qamadness.pages.OpenOrders;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class OpenOrdersSteps extends ScenarioSteps {
    OpenOrders openOrders;

    @Step
    public void orders_Open() {
        openOrders.open_orders();
    }
}

