package com.qamadness.Story.productsStories;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.products.CreateNewProductPageSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.jetty.util.CachedResource;
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

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    @Test
    public void addingGroupedProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet("4");
        createNewProductPageSteps.selectProductType("grouped");
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterName("Max auto grouped product");
        createNewProductPageSteps.enterProductDescription("Max auto grouped product description");
        createNewProductPageSteps.enterShortDescription("Max auto grouped product short description");
        createNewProductPageSteps.enterSKU("100006");
        createNewProductPageSteps.selectStatus("1");
        createNewProductPageSteps.selectVisibility("4");
        createNewProductPageSteps.clearGlobalSearch();
        /*manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.enterProductPrice("0.17");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.clearGlobalSearch();*/
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.selectAssociatedProductsTabGrouped();
        createNewProductPageSteps.checkFirstGroupAssociatedProduct();
        createNewProductPageSteps.checkSecondGroupAssociatedProduct();
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100006");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        //loginPageSteps.delay();

    }
}
