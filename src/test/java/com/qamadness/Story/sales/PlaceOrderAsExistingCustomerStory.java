package com.qamadness.Story.sales;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
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
    public class PlaceOrderAsExistingCustomerStory {

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
    SuccessMessagesSteps successMessagesSteps;

    @Issue("MAT-6")
    @Pending
    @Test
    public void place_order_for_existing_customer_from_admin(){
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
    successMessagesSteps.check_success_message("The order has been created.");
}

}
