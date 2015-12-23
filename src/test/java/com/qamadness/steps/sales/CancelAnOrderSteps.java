package com.qamadness.steps.sales;


import com.qamadness.pages.sales.CancelAnOrder;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CancelAnOrderSteps extends ScenarioSteps{
    CancelAnOrder cancelAnOrder;

    @Step
    public void see_orders_in_pending_status(){
        cancelAnOrder.seeOrdersInPendingStatus();
    }

    @Step
    public void cancel_selected_order(){
        cancelAnOrder.cancelSelectedOrder();
    }

    @Step
    public void check_cancellation_success(){
        cancelAnOrder.checkCancellationSuccess();
    }


}
