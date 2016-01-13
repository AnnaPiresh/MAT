package com.qamadness.Story.productsStories;

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
public class VirtualProductStory {

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
    public void addingVirtualProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProducts();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("virtual");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterName("Max auto virtual product");
        manageProductsPageSteps.enterProductDescription("Max auto virtual product description");
        manageProductsPageSteps.enterShortDescription("Max auto virtual product short description");
        manageProductsPageSteps.enterSKU("100005");
        manageProductsPageSteps.selectStatus("1");
        manageProductsPageSteps.selectVisibility("4");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.enterProductPrice("35");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectWebsitesTab();
        manageProductsPageSteps.selectMainWebsite();
        manageProductsPageSteps.selectCategoriesTab();
        manageProductsPageSteps.selectFirstCategory();
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
