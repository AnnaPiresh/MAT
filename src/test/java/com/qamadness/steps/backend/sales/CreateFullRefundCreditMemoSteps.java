package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.CreateFullRefundCreditMemo;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateFullRefundCreditMemoSteps extends ScenarioSteps{
    CreateFullRefundCreditMemo createFullRefundCreditMemo;

    @Step
    public void start_creating_credit_memo(){
        createFullRefundCreditMemo.startCreatingCreditMemo();
    }

    @Step
    public void submit_credit_memo(){
        createFullRefundCreditMemo.submitCreditMemo();
    }

}
