package com.qamadness.Story;


import com.qamadness.steps.*;
import com.qamadness.steps.CreateOrderAsNewCustomerSteps;
import com.qamadness.steps.PlaceOrderAsExistingCustomerSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class CreateOrderAsNewCustomerStory {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    PlaceOrderAsExistingCustomerSteps placeOrderAsExistingCustomerSteps;

    @Steps
    CreateOrderAsNewCustomerSteps createOrderAsNewCustomerSteps;

    @Issue("MAT-11")
    @Pending@Test
    public void place_an_order_for_a_new_customer_from_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        placeOrderAsExistingCustomerSteps.click_create_order_btn();
        createOrderAsNewCustomerSteps.click_create_customer_btn();
        placeOrderAsExistingCustomerSteps.select_engish_storeview();
        placeOrderAsExistingCustomerSteps.add_products_to_cart();
        createOrderAsNewCustomerSteps.enter_email_to_email_field();
        createOrderAsNewCustomerSteps.enter_billing_address();
        createOrderAsNewCustomerSteps.click_save_address_checkbox();
        placeOrderAsExistingCustomerSteps.select_payment_shipment();
        placeOrderAsExistingCustomerSteps.click_submit_btn();
        //placeOrderAsExistingCustomerSteps.check_That_Success_Message_Is_Displayed();
    }



}
