package com.qamadness.Story.productsStories;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
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
public class ConfigurableProductStory {

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

    @Pending@Test
    public void addingConfigurableProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("configurable");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.selectConfigurableAttribute();
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterName("Max configurable auto product");
        manageProductsPageSteps.enterProductDescription("Max auto configurable product description");
        manageProductsPageSteps.enterShortDescription("Max auto configurable product short description");
        manageProductsPageSteps.enterSKU("100005");
        manageProductsPageSteps.selectStatus("1");
        manageProductsPageSteps.selectVisibility("4");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.enterProductPrice("21");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectWebsitesTab();
        manageProductsPageSteps.selectMainWebsite();
        manageProductsPageSteps.selectCategoriesTab();
        manageProductsPageSteps.selectFirstCategory();
        manageProductsPageSteps.selectAssociatedProductsConfigurableTab();
        manageProductsPageSteps.checkFirstConfigurableAssociatedProduct();
        manageProductsPageSteps.checkSecondConfigurableAssociatedProduct();
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100005");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        //loginPageSteps.delay();

    }
}
