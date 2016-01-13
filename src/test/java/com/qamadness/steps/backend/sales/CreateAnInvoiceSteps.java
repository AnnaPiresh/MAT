package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.CreateAnInvoice;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateAnInvoiceSteps extends ScenarioSteps{
    CreateAnInvoice createAnInvoice;

    @Step
    public void create_an_invoice_for_order(){
        createAnInvoice.createAnInvoiceForOrder();
    }

}
