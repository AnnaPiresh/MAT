package com.qamadness.Story.sales;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;
import com.qamadness.steps.backendSteps.customersSteps.AddNewCustomerSteps;
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
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import sun.management.counter.StringCounter;

import java.awt.*;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/sales/CreateAnOrderData.csv")
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
    private String productTypeSimple;
    private String productDescription;
    private String productShortDescription;
    private String productSKU;
    private String productStatus;
    private String productVisibility;
    private String productName;
    private String productPrice;
    private String taxClass;
    private String productWeight;
    private String stockStatus;
    private String stockEnabled;
    private String userPassword;
    private String option;
    private String groupValue;
    private String action;
    private String country;


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

    @Steps
    ManageProductsPageSteps manageProductsPageSteps;

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    @Steps
    AddNewCustomerSteps addNewCustomerSteps;

    /*Precondition:
    1. Login to admin panel
    2. Create a simple product
    3. Create a user for tests
     */

    int i = 0;

    @Before
    public void openPage () {
        i = i+1;
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
            //create a new customer
            //create a new customer
            mainMenuSteps.open_Manage_Customers_Page();
            manageCustomersSteps.check_That_Manage_Customers_Page_Is_Opened();
            manageCustomersSteps.clickAddNewCustomerBtn();
            addNewCustomerSteps.select_Associate_To_Website_Option(option);
            addNewCustomerSteps.select_Group(groupValue);
            addNewCustomerSteps.enter_First_Name(firstName);
            addNewCustomerSteps.enter_Last_Name(lastName);
            addNewCustomerSteps.enter_Email(emailExisting);
            addNewCustomerSteps.enter_Password(userPassword);
            addNewCustomerSteps.switch_to_addresses_tab();
            addNewCustomerSteps.click_add_new_address_button();
            addNewCustomerSteps.select_billing_address_as_default();
            addNewCustomerSteps.select_shipping_address_as_default();
            addNewCustomerSteps.enter_street_address(street);
            addNewCustomerSteps.enter_city_address(city);
            addNewCustomerSteps.select_country(country);
            addNewCustomerSteps.select_state(region);
            addNewCustomerSteps.enter_zipcode(zipcode);
            addNewCustomerSteps.enter_telephone(telephone);
            addNewCustomerSteps.click_Save_Customer_Button();
            //create a new product
            mainMenuSteps.openManageProductsPage();
            manageProductsPageSteps.addProduct();
            createNewProductPageSteps.selectProductType(productTypeSimple);
            createNewProductPageSteps.continueButton();
            createNewProductPageSteps.enterName(productName + 1);
            createNewProductPageSteps.enterProductDescription(productDescription);
            createNewProductPageSteps.enterShortDescription(productShortDescription);
            createNewProductPageSteps.enterSKU(productSKU + 1);
            createNewProductPageSteps.enterWeight(productWeight);
            createNewProductPageSteps.selectStatus(productStatus);
            createNewProductPageSteps.selectVisibility(productVisibility);
            createNewProductPageSteps.selectPricesTab();
            createNewProductPageSteps.enterProductPrice(productPrice);
            createNewProductPageSteps.selectTaxClass(taxClass);
            createNewProductPageSteps.selectWebsitesTab();
            createNewProductPageSteps.selectMainWebsite();
            createNewProductPageSteps.selectCategoriesTab();
            createNewProductPageSteps.selectFirstCategory();
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.untick_use_config_settings_checkbox();
            createNewProductPageSteps.change_manage_stock_settings(stockEnabled);
            createNewProductPageSteps.saveProduct();
            manageProductsPageSteps.check_success_message();
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
        createAnOrderSteps.add_products_to_cart(productSKU);
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
        createAnOrderSteps.add_products_to_cart(productSKU);
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
        //delete a created customer
        mainMenuSteps.open_Manage_Customers_Page();
        manageCustomersSteps.search_Customer_By_Email(emailNew);
        manageCustomersSteps.check_Search_Result(emailNew);
        manageCustomersSteps.open_First_Customer_Profile();
        customerInformationSteps.click_Delete_Customer_Button();
        createAnOrderSteps.check_success_message(customerMessage);
    }

    /*Postcondition:
    1. Remove a created user
    2. Remove a created product
     */

    @After
    public void test_data_deletion() throws AWTException {
        if (i == 2) {
            loginPageSteps.openPage();
            System.out.println("Time to delete test data");
            mainMenuSteps.open_Manage_Customers_Page();
            manageCustomersSteps.search_Customer_By_Email(emailExisting);
            manageCustomersSteps.open_First_Customer_Profile();
            customerInformationSteps.click_Delete_Customer_Button();
            mainMenuSteps.openManageProductsPage();
            manageProductsPageSteps.searchBySku(productSKU);
            manageProductsPageSteps.searchButton();
            manageProductsPageSteps.select_all_products();
            manageProductsPageSteps.selectAction(action);
            manageProductsPageSteps.submitActionn();
            manageProductsPageSteps.deletionApproveAlert();
        }
    }

}
