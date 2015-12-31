package com.qamadness.Story.sales;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.sales.PlaceOrderAsExistingCustomerSteps;
import com.qamadness.steps.sales.ResendEmailToCustomerSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class ResendEmailToCustomerStory {

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
    ResendEmailToCustomerSteps resendEmailToCustomerSteps;

    @Issue("MAT-33")
    @Pending@Test
    public void resend_an_email_to_a_customer(){
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
        resendEmailToCustomerSteps.click_send_email_bth();
        resendEmailToCustomerSteps.check_success_message_present();
    }
}
