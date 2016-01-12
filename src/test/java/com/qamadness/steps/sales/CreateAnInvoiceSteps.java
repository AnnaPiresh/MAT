package com.qamadness.steps.sales;


import com.qamadness.pages.sales.CreateAnInvoice;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateAnInvoiceSteps extends ScenarioSteps{
    CreateAnInvoice createAnInvoice;

    @Step
    public void create_an_invoice_for_order(){
        createAnInvoice.createAnInvoiceForOrder();
    }

}
