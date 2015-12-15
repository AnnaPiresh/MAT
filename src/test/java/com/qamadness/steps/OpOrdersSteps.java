package com.qamadness.steps;

import com.qamadness.pages.OpOrders;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class OpOrdersSteps extends ScenarioSteps {
    OpOrders opOrders;

    @Step
    public void openPage() {
        opOrders.openPage();
    }

    @Step
    public void loginInput() {
        opOrders.loginInput();
    }

    @Step
    public void ordersSe() {
        opOrders.ordersSee();
    }
}

