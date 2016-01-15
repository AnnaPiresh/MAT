package com.qamadness.Story.catalog.productsStories;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(ThucydidesRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/BundleProductData.csv")
public class BundleProductStory {

    private String login;
    private String password;
    private String attributeSet;
    private String productType;
    private String productDescription;
    private String productShortDescription;
    private String productSKUType;
    private String productSKU;
    private String productWeightType;
    private String productWeight;
    private String productStatus;
    private String productVisibility;
    private String productName;
    private String priceType;
    private String productPrice;
    private String taxClass;
    private String priceView;
    private String shipmentType;
    private String defaultTitle;
    private String selectAction;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    ManageProductsPageSteps manageProductsPageSteps;

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    @Test
    public void addingBundleProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet(attributeSet);
        createNewProductPageSteps.selectProductType(productType);
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterProductDescription(productDescription);
        createNewProductPageSteps.enterShortDescription(productShortDescription);
        createNewProductPageSteps.selectProductSKUType(productSKUType);
        createNewProductPageSteps.enterSKU(productSKU);
        createNewProductPageSteps.selectProductWeightType(productWeightType);
        createNewProductPageSteps.enterWeight(productWeight);
        createNewProductPageSteps.selectStatus(productStatus);
        createNewProductPageSteps.selectVisibility(productVisibility);
        createNewProductPageSteps.enterName(productName);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.selectPriceType(priceType);
        createNewProductPageSteps.enterProductPrice(productPrice);
        createNewProductPageSteps.selectTaxClass(taxClass);
        createNewProductPageSteps.selectPriceView(priceView);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.selectBundleTab();
        createNewProductPageSteps.selectShipmentType(shipmentType);
        createNewProductPageSteps.addNewOption();
        createNewProductPageSteps.enterDeafultTitle(defaultTitle);
        createNewProductPageSteps.addSelection();
        createNewProductPageSteps.resetFilter();
        createNewProductPageSteps.selectProductTwo();
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectProductThree();
        createNewProductPageSteps.saveProduct();
        //createNewProductPageSteps.clearGlobalSearch();
        manageProductsPageSteps.searchBySku(productSKU);
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction(selectAction);
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();




        //loginPageSteps.delay();

    }
}
