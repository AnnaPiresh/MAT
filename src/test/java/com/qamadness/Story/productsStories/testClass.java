package com.qamadness.Story.productsStories;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.products.ManageProductsPageSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(ThucydidesRunner.class)
public class testClass {

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput();
            loginPageSteps.passInput();
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();}

        else {}

    }

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
    public void addingSimpleProduct () {

        /*loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();*/
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("simple");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterName("Max auto product");
        manageProductsPageSteps.enterProductDescription("Max auto product description");
        manageProductsPageSteps.enterShortDescription("Max auto product short description");
        manageProductsPageSteps.enterSKU("100001");
        manageProductsPageSteps.enterWeight("18");
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
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100001");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        manageProductsPageSteps.clearSKUFilter();
        //loginPageSteps.delay();

    }

    @Test
    public void changingProductAttribute () {

        loginPageSteps.openPage();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        manageProductsPageSteps.selectAttributeSet("4");
        manageProductsPageSteps.selectProductType("simple");
        manageProductsPageSteps.continueButton();
        manageProductsPageSteps.enterProductDescription("Max auto product description");
        manageProductsPageSteps.enterShortDescription("Max auto product short description");
        manageProductsPageSteps.enterSKU("100001");
        manageProductsPageSteps.enterWeight("18");
        manageProductsPageSteps.selectStatus("1");
        manageProductsPageSteps.selectVisibility("4");
        manageProductsPageSteps.enterName("Max auto product");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectPricesTab();
        manageProductsPageSteps.enterProductPrice("21");
        manageProductsPageSteps.selectTaxClass("0");
        manageProductsPageSteps.clearGlobalSearch();
        manageProductsPageSteps.selectWebsitesTab();
        manageProductsPageSteps.selectMainWebsite();
        manageProductsPageSteps.selectCategoriesTab();
        manageProductsPageSteps.selectFirstCategory();
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100001");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("attributes");
        manageProductsPageSteps.submitActionn();
        manageProductsPageSteps.updateProductNameCheckboxClick();
        manageProductsPageSteps.updateProductName("New Max auto product name");
        manageProductsPageSteps.saveProduct();
        manageProductsPageSteps.checkNameUpdated("//*[contains(text(), 'New Max auto product name')]");
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        manageProductsPageSteps.clearSKUFilter();
    }




}
