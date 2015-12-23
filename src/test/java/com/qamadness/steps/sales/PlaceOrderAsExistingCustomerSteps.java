package com.qamadness.steps.sales;


import com.qamadness.pages.sales.PlaceOrderAsExistingCustomer;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PlaceOrderAsExistingCustomerSteps extends ScenarioSteps{
PlaceOrderAsExistingCustomer placeOrderAsExistingCustomer;

    @Step
    public void click_create_order_btn(){placeOrderAsExistingCustomer.clickCreateOrderBtn();}

    @Step
    public void select_first_customer(){placeOrderAsExistingCustomer.selectCustomer();}

    @Step
    public void select_engish_storeview(){placeOrderAsExistingCustomer.selectStoreview();}

    @Step
    public void add_products_to_cart(){placeOrderAsExistingCustomer.addProductstoCart();}

    @Step
    public void select_payment_shipment(){placeOrderAsExistingCustomer.selectPaymentShipment();}

    @Step
    public void click_submit_btn(){placeOrderAsExistingCustomer.clickSubmit();}

   @Step
   public void check_That_Success_Message_Is_Displayed (){
      placeOrderAsExistingCustomer.checkSuccessMsg();
  }

}
