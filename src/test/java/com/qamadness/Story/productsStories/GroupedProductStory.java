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
public class GroupedProductStory {

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

    @Pending
    @Test
    public void addingGroupedProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("grouped");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterName("Max auto grouped product");
        manageProductsPageSteps.enterProductDescription("Max auto grouped product description");
        manageProductsPageSteps.enterShortDescription("Max auto grouped product short description");
        manageProductsPageSteps.enterSKU("100006");
        manageProductsPageSteps.selectStatus("1");
        manageProductsPageSteps.selectVisibility("4");
        manageProductsPageSteps.clearGlobalSearch();
        /*manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.enterProductPrice("0.17");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.clearGlobalSearch();*/
        manageProductsPageSteps.selectWebsitesTab();
        manageProductsPageSteps.selectMainWebsite();
        manageProductsPageSteps.selectCategoriesTab();
        manageProductsPageSteps.selectFirstCategory();
        manageProductsPageSteps.selectAssociatedProductsTabGrouped();
        manageProductsPageSteps.checkFirstGroupAssociatedProduct();
        manageProductsPageSteps.checkSecondGroupAssociatedProduct();
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100006");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        //loginPageSteps.delay();

    }
}
