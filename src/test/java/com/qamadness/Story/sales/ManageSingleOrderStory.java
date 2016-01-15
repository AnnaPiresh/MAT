package com.qamadness.Story.sales;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.salesSteps.CreateAnOrderSteps;
import com.qamadness.steps.backendSteps.salesSteps.ManageSingleOrderSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageSingleOrderStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    CreateAnOrderSteps createAnOrderSteps;

    @Steps
    ManageSingleOrderSteps manageSingleOrderSteps;

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput();
            loginPageSteps.passInput();
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
        } else {}
        mainMenuSteps.open_Orders_Page();
    }

    @Issue("MAT-26")
    @Pending
    @Test
    public void create_an_invoice_for_an_order(){
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.create_an_invoice_for_order();
        manageSingleOrderSteps.check_success_message("The invoice has been created.");
    }

    @Issue("MAT-29")
    @Pending
    @Test
    public void create_a_shipment_for_order(){
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.create_shipment_for_order();
        manageSingleOrderSteps.check_success_message("The shipment has been created.");
    }

    @Issue("MAT-30")
    @Pending
    @Test
    public void can_user_create_a_full_refund_credit_memo() {
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.create_an_invoice_for_order();
        manageSingleOrderSteps.create_shipment_for_order();
        manageSingleOrderSteps.start_creating_credit_memo();
        manageSingleOrderSteps.submit_credit_memo();
        manageSingleOrderSteps.check_success_message("The credit memo has been created.");
    }

    @Issue("MAT-31")
    @Pending
    @Test
    public void can_user_create_partial_refund_credit_memo(){
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.create_an_invoice_for_order();
        manageSingleOrderSteps.create_shipment_for_order();
        manageSingleOrderSteps.start_creating_credit_memo();
        manageSingleOrderSteps.remove_refund_for_shipment();
        manageSingleOrderSteps.submit_credit_memo();
        manageSingleOrderSteps.check_success_message("The credit memo has been created.");
        manageSingleOrderSteps.check_more_credit_memos_can_be_created();
    }

    @Issue("MAT-32")
    @Pending
    @Test
    public void can_user_reorder_from_admin(){
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.click_reorder_btn();
        manageSingleOrderSteps.check_correct_product_reordered();
        manageSingleOrderSteps.check_shipment_method_is_selected();
        manageSingleOrderSteps.check_payment_method_is_selected();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.check_success_message("The order has been created.");
    }

    @Issue("MAT-33")
    @Pending
    @Test
    public void resend_an_email_to_a_customer(){
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        manageSingleOrderSteps.click_send_email_bth();
        manageSingleOrderSteps.check_success_message("The order email has been sent.");
    }
}
