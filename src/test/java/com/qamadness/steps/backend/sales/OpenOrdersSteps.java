package com.qamadness.steps.backend.sales;

import com.qamadness.pages.backend.sales.OpenOrders;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class OpenOrdersSteps extends ScenarioSteps {
    OpenOrders openOrders;

    @Step
    public void orders_Open() {
        openOrders.open_orders();
    }
}

