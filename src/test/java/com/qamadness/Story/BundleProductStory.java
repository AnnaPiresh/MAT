package com.qamadness.Story;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.products.ManageProductsPageSteps;

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

    @Test
    public void addingBundleProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProducts();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("bundle");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterProductDescription("Max auto bundle product description");
        manageProductsPageSteps.enterShortDescription("Max auto bundle product short description");
        manageProductsPageSteps.selectProductSKUType("1");
        manageProductsPageSteps.enterSKU("12");
        manageProductsPageSteps.selectProductWeightType("1");
        manageProductsPageSteps.enterWeight("50");
        manageProductsPageSteps.selectStatus("1");
        manageProductsPageSteps.selectVisibility("4");
        manageProductsPageSteps.enterName("Max auto bundle product");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.selectPriceType("1");
        manageProductsPageSteps.enterProductPrice("37");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.selectPriceView("0");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectWebsitesTab();
        manageProductsPageSteps.selectMainWebsite();
        manageProductsPageSteps.selectCategoriesTab();
        //manageProductsPageSteps.selectFirstCategory();
        //manageProductsPageSteps.selectCategory();
        manageProductsPageSteps.selectBundleTab();
        manageProductsPageSteps.selectShipmentType("0");
        manageProductsPageSteps.addNewOption();
        manageProductsPageSteps.enterDeafultTitle("Auto title");
        manageProductsPageSteps.addSelection();
        manageProductsPageSteps.resetFilter();
        manageProductsPageSteps.selectProductTwo();
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectProductThree();
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.searchBySku("12");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();




        loginPageSteps.delay();

    }
}
