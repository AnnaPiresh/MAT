package com.qamadness.Story.catalog.productsStories;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(ThucydidesRunner.class)
public class BundleProductStory {

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

    @Pending
    @Test
    public void addingBundleProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput(); 
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet("4");
        createNewProductPageSteps.selectProductType("bundle");
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterProductDescription("Max auto bundle product description");
        createNewProductPageSteps.enterShortDescription("Max auto bundle product short description");
        createNewProductPageSteps.selectProductSKUType("1");
        createNewProductPageSteps.enterSKU("1000002");
        createNewProductPageSteps.selectProductWeightType("1");
        createNewProductPageSteps.enterWeight("50");
        createNewProductPageSteps.selectStatus("1");
        createNewProductPageSteps.selectVisibility("4");
        createNewProductPageSteps.enterName("Max auto bundle product");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.selectPriceType("1");
        createNewProductPageSteps.enterProductPrice("37");
        createNewProductPageSteps.selectTaxClass("0");
        createNewProductPageSteps.selectPriceView("0");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.selectBundleTab();
        createNewProductPageSteps.selectShipmentType("0");
        createNewProductPageSteps.addNewOption();
        createNewProductPageSteps.enterDeafultTitle("Auto title");
        createNewProductPageSteps.addSelection();
        createNewProductPageSteps.resetFilter();
        createNewProductPageSteps.selectProductTwo();
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectProductThree();
        createNewProductPageSteps.saveProduct();
        //createNewProductPageSteps.clearGlobalSearch();
        manageProductsPageSteps.searchBySku("1000002");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();




        //loginPageSteps.delay();

    }
}
