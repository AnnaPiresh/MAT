package com.qamadness.Story.catalog.productsStories;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
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
@RunWith(ThucydidesRunner.class)
@UseTestDataFrom(value="src/test/resources/VirtualProductData.csv")
public class VirtualProductStory {

    private String login;
    private String password;

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
    public void addingVirtualProduct () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet("4");
        createNewProductPageSteps.selectProductType("virtual");
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterName("Max auto virtual product");
        createNewProductPageSteps.enterProductDescription("Max auto virtual product description");
        createNewProductPageSteps.enterShortDescription("Max auto virtual product short description");
        createNewProductPageSteps.enterSKU("100005");
        createNewProductPageSteps.selectStatus("1");
        createNewProductPageSteps.selectVisibility("4");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.enterProductPrice("35");
        createNewProductPageSteps.selectTaxClass("0");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100005");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        //loginPageSteps.delay();

    }
}
