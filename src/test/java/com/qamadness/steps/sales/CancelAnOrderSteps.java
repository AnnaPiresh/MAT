package com.qamadness.steps.sales;


import com.qamadness.pages.sales.CancelAnOrder;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CancelAnOrderSteps extends ScenarioSteps{
    CancelAnOrder cancelAnOrder;

    @Step
    public void see_orders_in_pending_status(String status){
        cancelAnOrder.seeOrdersInPendingStatus(status);
    }

    @Step
    public void cancel_selected_order(String action){
        cancelAnOrder.cancelSelectedOrder(action);
    }


}
