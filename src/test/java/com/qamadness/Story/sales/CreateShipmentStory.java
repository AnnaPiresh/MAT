package com.qamadness.Story.sales;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
import com.qamadness.steps.sales.CreateAnInvoiceSteps;
import com.qamadness.steps.sales.CreateShipmentSteps;
import com.qamadness.steps.sales.PlaceOrderAsExistingCustomerSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class CreateShipmentStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    PlaceOrderAsExistingCustomerSteps placeOrderAsExistingCustomerSteps;

    @Steps
    CreateAnInvoiceSteps createAnInvoiceSteps;

    @Steps
    CreateShipmentSteps createShipmentSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Issue("MAT-29")
    @Pending
    @Test
    public void create_a_shipment_for_order(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        placeOrderAsExistingCustomerSteps.click_create_order_btn();
        placeOrderAsExistingCustomerSteps.select_customer("testersunny377@gmail.com");
        placeOrderAsExistingCustomerSteps.select_engish_storeview();
        placeOrderAsExistingCustomerSteps.add_products_to_cart("1051");
        placeOrderAsExistingCustomerSteps.select_payment_shipment();
        placeOrderAsExistingCustomerSteps.click_submit_btn();
        createAnInvoiceSteps.create_an_invoice_for_order();
        createShipmentSteps.create_shipment_for_order();
        successMessagesSteps.check_success_message("The shipment has been created.");


    }


}
