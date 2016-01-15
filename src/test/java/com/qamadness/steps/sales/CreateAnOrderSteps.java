package com.qamadness.steps.sales;

import com.qamadness.pages.sales.CreateAnOrder;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class CreateAnOrderSteps extends ScenarioSteps {

    CreateAnOrder createAnOrder;

    @Step
    public void click_create_order_btn(){createAnOrder.clickCreateOrderBtn();}

    @Step
    public void select_customer(String email){createAnOrder.selectCustomer(email);}

    @Step
    public void select_engish_storeview(){createAnOrder.selectStoreview();}

    @Step
    public void add_products_to_cart(String SKU){createAnOrder.addProductstoCart(SKU);}

    @Step
    public void select_payment_shipment(){createAnOrder.selectPaymentShipment();}

    @Step
    public void click_submit_btn(){createAnOrder.clickSubmit();}

    @Step
    public void click_create_customer_btn(){
        createAnOrder.clickCreateCustomerBtn();
    }

    @Step
    public void enter_email_to_email_field(String email){
        createAnOrder.enterEmailToEmailField(email);
    }

    @Step
    public void enter_first_name(String firstName){
        createAnOrder.enterFirstName(firstName);
    }

    @Step
    public void enter_last_name(String lastname) { createAnOrder.enterLastName(lastname); }

    @Step
    public void enter_street(String street) { createAnOrder.enterStreet(street);}

    @Step
    public void enter_city(String city){ createAnOrder.enterCity(city);}

    @Step
    public void select_region(String region){ createAnOrder.selectRegion(region);}

    @Step
    public void enter_zipcode(String zipcode){ createAnOrder.enterZipcode(zipcode);}

    @Step
    public void enter_telephone(String telephone){ createAnOrder.enterTelephone(telephone);}

    @Step
    public void click_save_address_checkbox(){ createAnOrder.saveAddressCheckbox(); }

    @Step
    public void check_success_message(String message) {createAnOrder.checkSuccessMsg(message);}

}


