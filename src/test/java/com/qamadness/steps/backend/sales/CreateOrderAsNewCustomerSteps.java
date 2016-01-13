package com.qamadness.steps.backend.sales;

import com.qamadness.pages.backend.sales.CreateOrderAsNewCustomer;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CreateOrderAsNewCustomerSteps extends ScenarioSteps {
CreateOrderAsNewCustomer createOrderAsNewCustomer;

    @Step
    public void click_create_customer_btn(){
        createOrderAsNewCustomer.clickCreateCustomerBtn();
    }

    @Step
    public void enter_email_to_email_field(String email){
        createOrderAsNewCustomer.enterEmailToEmailField(email);
    }

    @Step
    public void enter_first_name(String firstName){
        createOrderAsNewCustomer.enterFirstName(firstName);
    }

    @Step
    public void enter_last_name(String lastname) { createOrderAsNewCustomer.enterLastName(lastname); }

    @Step
    public void enter_street(String street) { createOrderAsNewCustomer.enterStreet(street);}

    @Step
    public void enter_city(String city){ createOrderAsNewCustomer.enterCity(city);}

    @Step
    public void select_region(String region){ createOrderAsNewCustomer.selectRegion(region);}

    @Step
    public void enter_zipcode(String zipcode){ createOrderAsNewCustomer.enterZipcode(zipcode);}

    @Step
    public void enter_telephone(String telephone){ createOrderAsNewCustomer.enterTelephone(telephone);}

    @Step
    public void click_save_address_checkbox(){
        createOrderAsNewCustomer.saveAddressCheckbox();
    }



}
