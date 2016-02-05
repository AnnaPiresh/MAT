package com.qamadness.Story.checkout_multiple_addresses;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;
import com.qamadness.steps.backendSteps.customersSteps.AddNewCustomerSteps;
import com.qamadness.steps.backendSteps.customersSteps.CustomerInformationSteps;
import com.qamadness.steps.backendSteps.customersSteps.ManageCustomersSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.frontendSteps.checkout.SuccessPageSteps;
import com.qamadness.steps.frontendSteps.checkout.checkoutMultipleAddressesSteps.CheckoutMultipleAddressesSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import com.qamadness.steps.frontendSteps.productDetailsPageSteps.ProductDetailsPageSteps;
import com.qamadness.steps.frontendSteps.productOverviewPageSteps.SearchResultsSteps;
import com.qamadness.steps.frontendSteps.registrationSteps.FrontendLoginSteps;
import com.qamadness.steps.frontendSteps.shoppingCartSteps.ShoppingCartSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.awt.*;

/**
 * Created by Anna Piresh on 03.02.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value = "src/test/resources/checkout_multiple_addresses/CheckoutMultipleAddressesData.csv")
public class ExistingDifferentProductTypesStory {

    private String login;
    private String password;
    private String option;
    private String groupValue;
    private String firstName;
    private String lastName;
    private String email;
    private String userPassword;
    private String productTypeSimple;
    private String productTypeGrouped;
    private String productTypeBundle;
    private String productDescription;
    private String productShortDescription;
    private String productSKU;
    private String productStatus;
    private String productVisibility;
    private String productNotVisibility;
    private String productName;
    private String productPrice;
    private String taxClass;
    private String productWeight;
    private String emptyCartMessage;
    private String stockStatus;
    private String stockEnabled;
    private String searchterm;
    private String telephone1;
    private String streetAddress1;
    private String city1;
    private String state1;
    private String zipcode1;
    private String country1;
    private String telephone2;
    private String streetAddress2;
    private String city2;
    private String state2;
    private String zipcode2;
    private String country2;
    private String action;
    private String productSKUType;
    private String productWeightType;
    private String priceType;
    private String priceView;
    private String shipmentType;
    private String inputType;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    AddNewCustomerSteps addNewCustomerSteps;

    @Steps
    ManageCustomersSteps manageCustomersSteps;

    @Steps
    CustomerInformationSteps customerInformationSteps;

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    @Steps
    ManageProductsPageSteps manageProductsPageSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    FrontendLoginSteps frontendLoginSteps;

    @Steps
    SearchResultsSteps searchResultsSteps;

    @Steps
    ProductDetailsPageSteps productDetailsPageSteps;

    @Steps
    ShoppingCartSteps shoppingCartSteps;

    @Steps
    CheckoutMultipleAddressesSteps checkoutMultipleAddressesSteps;

    @Steps
    SuccessPageSteps successPageSteps;

    /*Precondition:
    1. Login as admin user
    2. Register a new customer
    3. Create simple products
    4. Create grouped, configurable, bundle, downloadable products
    5. Create a product with custom options
    6. Navigate to front end
    7. Clear shopping cart
     */

    int i = 0;

   @Before
    public void openPage() {
        i = i + 1;
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
            //create a new customer
            mainMenuSteps.open_Manage_Customers_Page();
            manageCustomersSteps.check_That_Manage_Customers_Page_Is_Opened();
            manageCustomersSteps.clickAddNewCustomerBtn();
            addNewCustomerSteps.select_Associate_To_Website_Option(option);
            addNewCustomerSteps.select_Group(groupValue);
            addNewCustomerSteps.enter_First_Name(firstName);
            addNewCustomerSteps.enter_Last_Name(lastName);
            addNewCustomerSteps.enter_Email(email);
            addNewCustomerSteps.enter_Password(userPassword);
            addNewCustomerSteps.click_Save_Customer_Button();
            //create two simple products with "Not visible individually" visibility
            //create first simple product
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
            createNewProductPageSteps.selectVisibility(productNotVisibility);
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
            //create second simple product
            manageProductsPageSteps.addProduct();
            createNewProductPageSteps.selectProductType(productTypeSimple);
            createNewProductPageSteps.continueButton();
            createNewProductPageSteps.enterName(productName + 2);
            createNewProductPageSteps.enterProductDescription(productDescription);
            createNewProductPageSteps.enterShortDescription(productShortDescription);
            createNewProductPageSteps.enterSKU(productSKU + 2);
            createNewProductPageSteps.enterWeight(productWeight);
            createNewProductPageSteps.selectStatus(productStatus);
            createNewProductPageSteps.selectVisibility(productNotVisibility);
            createNewProductPageSteps.selectPricesTab();
            createNewProductPageSteps.enterProductPrice(productPrice);
            createNewProductPageSteps.selectTaxClass(taxClass);
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.untick_use_config_settings_checkbox();
            createNewProductPageSteps.change_manage_stock_settings(stockEnabled);
            createNewProductPageSteps.selectWebsitesTab();
            createNewProductPageSteps.selectMainWebsite();
            createNewProductPageSteps.selectCategoriesTab();
            createNewProductPageSteps.selectFirstCategory();
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.saveProduct();
            manageProductsPageSteps.check_success_message();
            //create a grouped product
            manageProductsPageSteps.addProduct();
            createNewProductPageSteps.selectProductType(productTypeGrouped);
            createNewProductPageSteps.continueButton();
            createNewProductPageSteps.enterName(productName + " grouped");
            createNewProductPageSteps.enterProductDescription(productDescription);
            createNewProductPageSteps.enterShortDescription(productShortDescription);
            createNewProductPageSteps.enterSKU(productSKU +"-grouped");
            createNewProductPageSteps.selectStatus(productStatus);
            createNewProductPageSteps.selectVisibility(productVisibility);
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.select_stock_availability(stockStatus);
            createNewProductPageSteps.selectWebsitesTab();
            createNewProductPageSteps.selectMainWebsite();
            createNewProductPageSteps.selectCategoriesTab();
            createNewProductPageSteps.selectFirstCategory();
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.selectAssociatedProductsTabGrouped();
            createNewProductPageSteps.search_associated_products_by_sku(productSKU);
            createNewProductPageSteps.select_all_associated_products();
            createNewProductPageSteps.saveProduct();
            manageProductsPageSteps.check_success_message();
            //create a bundle product
            mainMenuSteps.openManageProductsPage();
            manageProductsPageSteps.addProduct();
            createNewProductPageSteps.selectProductType(productTypeBundle);
            createNewProductPageSteps.continueButton();
            createNewProductPageSteps.enterName(productName + " bundle");
            createNewProductPageSteps.enterProductDescription(productDescription);
            createNewProductPageSteps.enterShortDescription(productShortDescription);
            createNewProductPageSteps.selectProductSKUType(productSKUType);
            createNewProductPageSteps.enterSKU(productSKU +"-bundle");
            createNewProductPageSteps.selectProductWeightType(productWeightType);
            createNewProductPageSteps.enterWeight(productWeight);
            createNewProductPageSteps.selectStatus(productStatus);
            createNewProductPageSteps.selectVisibility(productVisibility);
            createNewProductPageSteps.selectPricesTab();
            createNewProductPageSteps.selectPriceType(priceType);
            createNewProductPageSteps.enterProductPrice(productPrice);
            createNewProductPageSteps.selectTaxClass(taxClass);
            createNewProductPageSteps.selectPriceView(priceView);
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.untick_use_config_settings_checkbox();
            createNewProductPageSteps.change_manage_stock_settings(stockEnabled);
            createNewProductPageSteps.selectWebsitesTab();
            createNewProductPageSteps.selectMainWebsite();
            createNewProductPageSteps.selectCategoriesTab();
            createNewProductPageSteps.selectFirstCategory();
            createNewProductPageSteps.select_inventory_tab();
            createNewProductPageSteps.selectBundleTab();
            createNewProductPageSteps.selectShipmentType(shipmentType);
            createNewProductPageSteps.addNewOption();
            createNewProductPageSteps.enterDeafultTitle("Simple products");
            createNewProductPageSteps.select_input_type_for_bundle_items(inputType);
            createNewProductPageSteps.addSelection();
            createNewProductPageSteps.search_bundle_items_by_sku(productSKU);
            createNewProductPageSteps.selectProductTwo();
            createNewProductPageSteps.selectProductThree();
            createNewProductPageSteps.click_add_selected_products_to_option_button();
            createNewProductPageSteps.saveProduct();
            manageProductsPageSteps.check_success_message();
        } else {}
        homePageSteps.open_Home_Page();
        homePageSteps.open_account_menu_in_header();
        homePageSteps.navigate_to_login_page();
        frontendLoginSteps.enter_customer_email(email);
        frontendLoginSteps.enter_customer_password(userPassword);
        frontendLoginSteps.click_login_button();
        homePageSteps.open_floating_cart();
        if (homePageSteps.check_if_shopping_cart_is_empty(emptyCartMessage) == false) {
            shoppingCartSteps.empty_shopping_cart();
        }
        homePageSteps.open_account_menu_in_header();
        homePageSteps.logout_from_website();
    }

    @Issue("MAT-101")
    @Pending
    @Test
    public void multiple_addresses_checkout_with_grouped_products(){
        String productMessageGrouped = String.format("%s was added to your shopping cart.", productName + " grouped");
        homePageSteps.open_Home_Page();
        homePageSteps.search_for_product(searchterm);
        searchResultsSteps.select_product_from_search_results(productName + " grouped");
        productDetailsPageSteps.enter_qty_of_products("2","2");
        homePageSteps.open_account_menu_in_header();
        homePageSteps.open_account_menu_in_header();
        productDetailsPageSteps.click_add_to_cart_button();
        shoppingCartSteps.check_product_is_added_to_cart(productMessageGrouped);
        //proceed to checkout
        shoppingCartSteps.proceed_to_multiple_addresses_checkout();
        //login
        frontendLoginSteps.enter_customer_email(email);
        frontendLoginSteps.enter_customer_password(userPassword);
        frontendLoginSteps.click_login_button();
        //add default address
        if (checkoutMultipleAddressesSteps.check_if_user_has_a_default_shipping_address() == false) {
            checkoutMultipleAddressesSteps.enter_telephone(telephone1);
            checkoutMultipleAddressesSteps.enter_street_address(streetAddress1);
            checkoutMultipleAddressesSteps.enter_city(city1);
            checkoutMultipleAddressesSteps.select_state(state1);
            checkoutMultipleAddressesSteps.enter_zip_code(zipcode1);
            checkoutMultipleAddressesSteps.select_country(country1);
            checkoutMultipleAddressesSteps.click_save_address_button();
        } else {
            System.out.println("User already has a saved default address");
        }
        //add additional address
        checkoutMultipleAddressesSteps.click_enter_new_address_button();
        checkoutMultipleAddressesSteps.enter_telephone(telephone2);
        checkoutMultipleAddressesSteps.enter_street_address(streetAddress2);
        checkoutMultipleAddressesSteps.enter_city(city2);
        checkoutMultipleAddressesSteps.select_state(state2);
        checkoutMultipleAddressesSteps.enter_zip_code(zipcode2);
        checkoutMultipleAddressesSteps.select_country(country2);
        checkoutMultipleAddressesSteps.click_save_address_button();
        //select different addresses for products
        String fullCustomerAddress2 = firstName + " " + lastName + ", " + streetAddress2 + ", " + city2 + ", " + state2 + " " + zipcode2 + ", " + country2;
        checkoutMultipleAddressesSteps.select_an_address_from_dropdown(productName + 1, fullCustomerAddress2);
        checkoutMultipleAddressesSteps.select_an_address_from_dropdown(productName + 2, fullCustomerAddress2);
        checkoutMultipleAddressesSteps.click_continue_to_shipping_information_button();
        //select different shipping methods for products
        checkoutMultipleAddressesSteps.select_shipping_methods(3, 9);
        checkoutMultipleAddressesSteps.click_continue_to_billing_information_button();
        //select a payment method for orders
        checkoutMultipleAddressesSteps.select_payment_method();
        checkoutMultipleAddressesSteps.click_continue_to_review_your_order_button();
        //place an order from review step
        checkoutMultipleAddressesSteps.click_place_order_button();
        //verify that two orders are created
        successPageSteps.check_order_is_placed_successfully();
        successPageSteps.check_the_qty_of_orders(2);
        homePageSteps.open_Home_Page();
        homePageSteps.open_account_menu_in_header();
        homePageSteps.logout_from_website();
    }

    @Issue("MAT-102")
    @Pending
    @Test
    public void multiple_addresses_checkout_with_bundle_products(){
        String productMessageBundle = String.format("%s was added to your shopping cart.", productName + " bundle");
        //search for test product and add it to cart
        homePageSteps.open_Home_Page();
        homePageSteps.search_for_product(searchterm);
        searchResultsSteps.select_product_from_search_results(productName + " bundle");
        productDetailsPageSteps.select_bundle_item();
        homePageSteps.open_floating_cart();
        homePageSteps.open_floating_cart();
        productDetailsPageSteps.click_add_to_cart_button_bundle();
        shoppingCartSteps.check_product_is_added_to_cart(productMessageBundle);
        //increase product qty to 2
        shoppingCartSteps.change_products_qty("2");
        //proceed to checkout
        shoppingCartSteps.proceed_to_multiple_addresses_checkout();
        //login
        frontendLoginSteps.enter_customer_email(email);
        frontendLoginSteps.enter_customer_password(userPassword);
        frontendLoginSteps.click_login_button();
        //add default address
        if (checkoutMultipleAddressesSteps.check_if_user_has_a_default_shipping_address() == false) {
            checkoutMultipleAddressesSteps.enter_telephone(telephone1);
            checkoutMultipleAddressesSteps.enter_street_address(streetAddress1);
            checkoutMultipleAddressesSteps.enter_city(city1);
            checkoutMultipleAddressesSteps.select_state(state1);
            checkoutMultipleAddressesSteps.enter_zip_code(zipcode1);
            checkoutMultipleAddressesSteps.select_country(country1);
            checkoutMultipleAddressesSteps.click_save_address_button();
        } else {
            System.out.println("User already has a saved default address");
        }
        //add additional address
        checkoutMultipleAddressesSteps.click_enter_new_address_button();
        checkoutMultipleAddressesSteps.enter_telephone(telephone2);
        checkoutMultipleAddressesSteps.enter_street_address(streetAddress2);
        checkoutMultipleAddressesSteps.enter_city(city2);
        checkoutMultipleAddressesSteps.select_state(state2);
        checkoutMultipleAddressesSteps.enter_zip_code(zipcode2);
        checkoutMultipleAddressesSteps.select_country(country2);
        checkoutMultipleAddressesSteps.click_save_address_button();
        //select different addresses for products
        String fullCustomerAddressBundle = firstName + " " + lastName + ", " + streetAddress2 + ", " + city2 + ", " + state2 + " " + zipcode2 + ", " + country2;
        checkoutMultipleAddressesSteps.select_an_address_from_dropdown(productName + " bundle", fullCustomerAddressBundle);
        checkoutMultipleAddressesSteps.click_continue_to_shipping_information_button();
        //select different shipping methods for products
        checkoutMultipleAddressesSteps.select_shipping_methods(3, 9);
        checkoutMultipleAddressesSteps.click_continue_to_billing_information_button();
        //select a payment method for orders
        checkoutMultipleAddressesSteps.select_payment_method();
        checkoutMultipleAddressesSteps.click_continue_to_review_your_order_button();
        //place an order from review step
        checkoutMultipleAddressesSteps.click_place_order_button();
        //verify that two orders are created
        successPageSteps.check_order_is_placed_successfully();
        successPageSteps.check_the_qty_of_orders(2);
        homePageSteps.open_Home_Page();
        homePageSteps.open_account_menu_in_header();
        homePageSteps.logout_from_website();
    }

    /*Actions after completing the tests in story:
    1. Navigate to admin panel
    2. Delete a created user
    3. Delete all created products
     */

    @After
    public void test_data_deletion() throws AWTException {
        if (i == 2) {
            loginPageSteps.openPage();
            System.out.println("Time to delete test data");
            mainMenuSteps.open_Manage_Customers_Page();
            manageCustomersSteps.search_Customer_By_Email(email);
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