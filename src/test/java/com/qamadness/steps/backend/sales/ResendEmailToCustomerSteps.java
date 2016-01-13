package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.ResendEmailToCustomer;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ResendEmailToCustomerSteps extends ScenarioSteps{
    ResendEmailToCustomer resendEmailToCustomer;

    @Step
    public void click_send_email_bth(){
        resendEmailToCustomer.clickSendEmailBtn();
    }

}
