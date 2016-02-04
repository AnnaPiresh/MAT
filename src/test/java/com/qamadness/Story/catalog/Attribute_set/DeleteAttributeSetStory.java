package com.qamadness.Story.catalog.Attribute_set;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributeSetsSteps.CreateAttributeSetSteps;
import com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributeSetsSteps.ManageAttributeSetsSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anna Piresh on 25.01.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value = "src/test/resources/catalog/Attributes/ManageAttributeSets/DeleteAttributeSetData.csv")
public class DeleteAttributeSetStory {

    private String login;
    private String password;
    private String setName;
    private String createSuccessMessage;
    private String deleteSuccessMessage;
    private String defaultSetName;
    private String attributeSet;
    private String productType;
    private String productDescription;
    private String productShortDescription;
    private String productSKU;
    private String productStatus;
    private String productVisibility;
    private String productName;
    private String productPrice;
    private String taxClass;
    private String selectAction;
    private String productWeight;
    private String productSuccessMessage;
    private String productDeleteSuccessMessage;
    private String searchMessage;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    CreateAttributeSetSteps createAttributeSetSteps;

    @Steps
    ManageAttributeSetsSteps manageAttributeSetsSteps;

    @Steps
    ManageProductsPageSteps manageProductsPageSteps;

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    /*Precondition:
    1. Login to admin panel
     */

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
        mainMenuSteps.open_Manage_Attribute_Sets_page();
    }

    @Issue("MAT-74")
    @Pending
    @Test
    public void delete_attribute_set_without_related_products(){
        //create a new attribute set
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(setName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(createSuccessMessage);
        //delete created attribute set
        createAttributeSetSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteSuccessMessage);
    }

    @Issue("MAT-75")
    @Pending
    @Test
    public void delete_attribute_set_with_related_products(){
        //create a new attribute set
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(setName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(createSuccessMessage);
        //create a product based on this attribute set
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.select_attribute_set_by_name(setName);
        createNewProductPageSteps.selectProductType(productType);
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterName(productName);
        createNewProductPageSteps.enterProductDescription(productDescription);
        createNewProductPageSteps.enterShortDescription(productShortDescription);
        createNewProductPageSteps.enterSKU(productSKU);
        createNewProductPageSteps.enterWeight(productWeight);
        createNewProductPageSteps.selectStatus(productStatus);
        createNewProductPageSteps.selectVisibility(productVisibility);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.enterProductPrice(productPrice);
        createNewProductPageSteps.selectTaxClass(taxClass);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.saveProduct();
        createAttributeSetSteps.check_success_message(productSuccessMessage);
        //delete a created attribute set
        mainMenuSteps.open_Manage_Attribute_Sets_page();
        manageAttributeSetsSteps.search_for_attribute_set(setName);
        manageAttributeSetsSteps.select_attribute_set_found();
        createAttributeSetSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteSuccessMessage);
        //check that created product is also deleted
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.searchBySku(productSKU);
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.check_no_products_are_found(searchMessage);
    }

    @Issue("MAT-76")
    @Pending
    @Test
    public void delete_default_attribute_set(){
        manageAttributeSetsSteps.search_for_attribute_set(defaultSetName);
        manageAttributeSetsSteps.select_attribute_set_found();
        createAttributeSetSteps.check_delete_button_is_not_present();
    }
}

