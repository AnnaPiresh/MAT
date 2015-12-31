package com.qamadness.Story.sales;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.LogoutFromAdminSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.sales.*;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class CreatePartialRefundCreditMemoStory {

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
    CreatePartialRefundCreditMemoSteps createPartialRefundCreditMemoSteps;

    @Issue("MAT-31")
    @Pending@Test
    public void can_user_create_partial_refund_credit_memo(){
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
        createPartialRefundCreditMemoSteps.remove_refund_for_shipment();
        createFullRefundCreditMemoSteps.submit_credit_memo();
        createFullRefundCreditMemoSteps.check_credit_memo_is_created();
        createPartialRefundCreditMemoSteps.check_more_credit_memos_can_be_created();
        logoutFromAdminSteps.logout_from_admin();
    }


}
