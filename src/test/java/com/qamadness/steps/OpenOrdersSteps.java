package com.qamadness.steps;

import com.qamadness.pages.OpenOrders;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class OpenOrdersSteps extends ScenarioSteps {
    OpenOrders openOrders;

    @Step
    public void openPage() {
        openOrders.openPage();
    }

    @Step
    public void loginInput() {
        openOrders.loginInput();
    }

    @Step
    public void ordersOpen() {
        openOrders.ordersSee();
    }
}

