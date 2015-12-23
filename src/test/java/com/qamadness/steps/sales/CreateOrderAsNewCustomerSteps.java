package com.qamadness.steps.sales;

import com.qamadness.pages.sales.CreateOrderAsNewCustomer;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateOrderAsNewCustomerSteps extends ScenarioSteps {
CreateOrderAsNewCustomer createOrderAsNewCustomer;

    @Step
    public void click_create_customer_btn(){
        createOrderAsNewCustomer.clickCreateCustomerBtn();
    }

    @Step
    public void enter_email_to_email_field(){
        createOrderAsNewCustomer.enterEmailToEmailField();
    }

    @Step
    public void enter_billing_address(){
        createOrderAsNewCustomer.enterBillingAddress();
    }

    @Step
    public void click_save_address_checkbox(){
        createOrderAsNewCustomer.saveAddressCheckbox();
    }



}
