package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.PlaceOrderAsExistingCustomer;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PlaceOrderAsExistingCustomerSteps extends ScenarioSteps{
PlaceOrderAsExistingCustomer placeOrderAsExistingCustomer;

    @Step
    public void click_create_order_btn(){placeOrderAsExistingCustomer.clickCreateOrderBtn();}

    @Step
    public void select_customer(String email){placeOrderAsExistingCustomer.selectCustomer(email);}

    @Step
    public void select_engish_storeview(){placeOrderAsExistingCustomer.selectStoreview();}

    @Step
    public void add_products_to_cart(String SKU){placeOrderAsExistingCustomer.addProductstoCart(SKU);}

    @Step
    public void select_payment_shipment(){placeOrderAsExistingCustomer.selectPaymentShipment();}

    @Step
    public void click_submit_btn(){placeOrderAsExistingCustomer.clickSubmit();}

}
