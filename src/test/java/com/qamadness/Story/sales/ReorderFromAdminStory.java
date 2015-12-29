package com.qamadness.Story.sales;


import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.sales.PlaceOrderAsExistingCustomerSteps;
import com.qamadness.steps.sales.ReorderFromAdminSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class ReorderFromAdminStory {

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
    ReorderFromAdminSteps reorderFromAdminSteps;

    @Issue("MAT-32")
    @Test
    public void can_user_reorder_from_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        placeOrderAsExistingCustomerSteps.click_create_order_btn();
        placeOrderAsExistingCustomerSteps.select_first_customer();
        placeOrderAsExistingCustomerSteps.select_engish_storeview();
        placeOrderAsExistingCustomerSteps.add_products_to_cart();
        placeOrderAsExistingCustomerSteps.select_payment_shipment();
        placeOrderAsExistingCustomerSteps.click_submit_btn();
        reorderFromAdminSteps.click_reorder_btn();
        reorderFromAdminSteps.check_correct_product_reordered();
        reorderFromAdminSteps.check_shipment_method_is_selected();
        reorderFromAdminSteps.check_payment_method_is_selected();
        placeOrderAsExistingCustomerSteps.click_submit_btn();
        placeOrderAsExistingCustomerSteps.check_That_Success_Message_Is_Displayed();
    }

}
