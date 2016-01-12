package com.qamadness.steps.sales;


import com.qamadness.pages.sales.CreatePartialRefundCreditMemo;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreatePartialRefundCreditMemoSteps extends ScenarioSteps{
    CreatePartialRefundCreditMemo createPartialRefundCreditMemo;

    @Step
    public void remove_refund_for_shipment(){
        createPartialRefundCreditMemo.removeRefundForShipment();
    }

    @Step
    public void check_more_credit_memos_can_be_created(){
        createPartialRefundCreditMemo.checkMoreCreditMemosCanBeCreated();
    }




}
