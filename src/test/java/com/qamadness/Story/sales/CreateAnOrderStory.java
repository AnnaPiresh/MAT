package com.qamadness.Story.sales;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.customersSteps.CustomerInformationSteps;
import com.qamadness.steps.backendSteps.customersSteps.ManageCustomersSteps;
import com.qamadness.steps.backendSteps.salesSteps.CreateAnOrderSteps;
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

import java.awt.*;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateAnOrderStory {

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
    ManageCustomersSteps manageCustomersSteps;

    @Steps
    CustomerInformationSteps customerInformationSteps;

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

    @Issue("MAT-6")
    @Pending
    @Test
    public void place_order_for_existing_customer_from_admin() {
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.select_customer("testersunny377@gmail.com");
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        createAnOrderSteps.check_success_message("The order has been created.");
    }

    @Issue("MAT-11")
    @Pending
    @Test
    public void place_an_order_for_a_new_customer_from_admin() throws AWTException {
        String email = "testersunny377+1@gmail.com";
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.click_create_customer_btn();
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart("1051");
        createAnOrderSteps.enter_email_to_email_field(email);
        createAnOrderSteps.enter_first_name("Anna");
        createAnOrderSteps.enter_last_name("Tester");
        createAnOrderSteps.enter_street("251 S Olive St");
        createAnOrderSteps.enter_city("Los Angeles");
        createAnOrderSteps.select_region("12");
        createAnOrderSteps.enter_zipcode("90012");
        createAnOrderSteps.enter_telephone("+1 213-617-3300");
        createAnOrderSteps.click_save_address_checkbox();
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        createAnOrderSteps.check_success_message("The order has been created.");
        mainMenuSteps.open_Manage_Customers_Page();
        manageCustomersSteps.search_Customer_By_Email(email);
        manageCustomersSteps.check_Search_Result(email);
        manageCustomersSteps.open_First_Customer_Profile();
        customerInformationSteps.click_Delete_Customer_Button();
        createAnOrderSteps.check_success_message("The customer has been deleted.");
    }

}
