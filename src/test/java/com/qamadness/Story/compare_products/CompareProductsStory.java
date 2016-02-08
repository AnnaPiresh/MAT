package com.qamadness.Story.compare_products;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;
import com.qamadness.steps.backendSteps.customersSteps.AddNewCustomerSteps;
import com.qamadness.steps.backendSteps.customersSteps.CustomerInformationSteps;
import com.qamadness.steps.backendSteps.customersSteps.ManageCustomersSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.frontendSteps.advancedSearchPageSteps.AdvancedSearchPageSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import com.qamadness.steps.frontendSteps.productDetailsPageSteps.ProductDetailsPageSteps;
import com.qamadness.steps.frontendSteps.productOverviewPageSteps.SearchResultsSteps;
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
import java.util.concurrent.TimeUnit;

/**
 * Created by Vladislav.E on 08.02.2016.
 */
@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/compare_product/CompareProduct.csv")
public class CompareProductsStory {

    private String login;
    private String password;
    private String option;
    private String groupValue;
    private String firstName;
    private String lastName;
    private String email;
    private String userPassword;
    private String productTypeSimple;
    private String productName;
    private String productDescription;
    private String productShortDescription;
    private String productSKU;
    private String productWeight;
    private String productStatus;
    private String productVisibility;
    private String productPrice;
    private String taxClass;
    private String stockEnabled;
    private String action;


    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

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
    ProductDetailsPageSteps productDetailsPageSteps;

    @Steps
    SearchResultsSteps searchResultsSteps;

    @Steps
    AdvancedSearchPageSteps advancedSearchPageSteps;

    @Before
    public void openPage() {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        //create first simple product
        loginPageSteps.navigate_to_dashboard();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectProductType(productTypeSimple);
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterName(productName );
        createNewProductPageSteps.enterProductDescription(productDescription);
        createNewProductPageSteps.enterShortDescription(productShortDescription);
        createNewProductPageSteps.enterSKU(productSKU );
        createNewProductPageSteps.enterWeight(productWeight);
        createNewProductPageSteps.selectStatus(productStatus);
        createNewProductPageSteps.selectVisibility(productVisibility);
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
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.check_success_message();

    }

    @Issue("MAT-201")
    //@Pending
    @Test
    public void Adds_a_product_to_Compare_from_Product_Details_page() {
        homePageSteps.open_Home_Page();
        homePageSteps.search_for_product(productName);
        searchResultsSteps.select_product_from_search_results(productName);
        productDetailsPageSteps.click_add_to_compare_btn();
        productDetailsPageSteps.check_Success_Compare_Msg(productName);
        homePageSteps.open_Home_Page();
        homePageSteps.click_Footer_Advanced_Search_Link();
        advancedSearchPageSteps.check_Compared_Product(productName);
        advancedSearchPageSteps.clear_compare_block();
    }

    @After
    public void delete_test_data() throws AWTException {
        loginPageSteps.openPage();
        System.out.println("Time to delete test data");
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.searchBySku(productSKU);
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.select_all_products();
        manageProductsPageSteps.selectAction(action);
        manageProductsPageSteps.submitActionn();
        manageProductsPageSteps.deletionApproveAlert();
    }
}
