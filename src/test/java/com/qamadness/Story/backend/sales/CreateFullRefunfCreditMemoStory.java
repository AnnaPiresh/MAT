package com.qamadness.Story.backend.sales;

import com.qamadness.steps.backend.*;
import com.qamadness.steps.backend.sales.CreateAnInvoiceSteps;
import com.qamadness.steps.backend.sales.CreateFullRefundCreditMemoSteps;
import com.qamadness.steps.backend.sales.CreateShipmentSteps;
import com.qamadness.steps.backend.sales.PlaceOrderAsExistingCustomerSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class CreateFullRefunfCreditMemoStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    LogoutFromAdminSteps logoutFromAdminSteps;

    @Steps
    PlaceOrderAsExistingCustomerSteps placeOrderAsExistingCustomerSteps;

    @Steps
    CreateAnInvoiceSteps createAnInvoiceSteps;

    @Steps
    CreateShipmentSteps createShipmentSteps;

    @Steps
    CreateFullRefundCreditMemoSteps createFullRefundCreditMemoSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Issue("MAT-30")
    @Pending
    @Test
    public void can_user_create_a_full_refund_credit_memo(){
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
        createFullRefundCreditMemoSteps.start_creating_credit_memo();
        createFullRefundCreditMemoSteps.submit_credit_memo();
        successMessagesSteps.check_success_message("The credit memo has been created.");
        logoutFromAdminSteps.logout_from_admin();

    }


}
