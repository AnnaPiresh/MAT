package com.qamadness.Story.sales;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.customersSteps.CustomerInformationSteps;
import com.qamadness.steps.backendSteps.customersSteps.ManageCustomersSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.salesSteps.CreateAnOrderSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
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

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/CreateAnOrderData.csv")
public class CreateAnOrderStory {

    private String login;
    private String password;

    private String emailExisting;
    private String productID;
    private String emailNew;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String region;
    private String zipcode;
    private String telephone;
    private String orderMessage;
    private String customerMessage;

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
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
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
        createAnOrderSteps.select_customer(emailExisting);
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart(productID);
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        createAnOrderSteps.check_success_message(orderMessage);
    }

    @Issue("MAT-11")
    @Pending
    @Test
    public void place_an_order_for_a_new_customer_from_admin() throws AWTException {
        createAnOrderSteps.click_create_order_btn();
        createAnOrderSteps.click_create_customer_btn();
        createAnOrderSteps.select_engish_storeview();
        createAnOrderSteps.add_products_to_cart(productID);
        createAnOrderSteps.enter_email_to_email_field(emailNew);
        createAnOrderSteps.enter_first_name(firstName);
        createAnOrderSteps.enter_last_name(lastName);
        createAnOrderSteps.enter_street(street);
        createAnOrderSteps.enter_city(city);
        createAnOrderSteps.select_region(region);
        createAnOrderSteps.enter_zipcode(zipcode);
        createAnOrderSteps.enter_telephone(telephone);
        createAnOrderSteps.click_save_address_checkbox();
        createAnOrderSteps.select_payment_shipment();
        createAnOrderSteps.click_submit_btn();
        createAnOrderSteps.check_success_message(orderMessage);
        mainMenuSteps.open_Manage_Customers_Page();
        manageCustomersSteps.search_Customer_By_Email(emailNew);
        manageCustomersSteps.check_Search_Result(emailNew);
        manageCustomersSteps.open_First_Customer_Profile();
        customerInformationSteps.click_Delete_Customer_Button();
        createAnOrderSteps.check_success_message(customerMessage);
    }

}
