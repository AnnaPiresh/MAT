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
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(ThucydidesRunner.class)
@UseTestDataFrom(value="src/test/resources/testClassData.csv")
public class testClass {

    private String login;
    private String password;

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
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

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    @Pending
    @Test
    public void addingSimpleProduct () {

        /*loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();*/
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet("4");
        createNewProductPageSteps.selectProductType("simple");
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterName("Max auto product");
        createNewProductPageSteps.enterProductDescription("Max auto product description");
        createNewProductPageSteps.enterShortDescription("Max auto product short description");
        createNewProductPageSteps.enterSKU("100001");
        createNewProductPageSteps.enterWeight("18");
        createNewProductPageSteps.selectStatus("1");
        createNewProductPageSteps.selectVisibility("4");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.enterProductPrice("21");
        createNewProductPageSteps.selectTaxClass("0");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.saveProduct();
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
        createNewProductPageSteps.selectAttributeSet("4");
        createNewProductPageSteps.selectProductType("simple");
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterProductDescription("Max auto product description");
        createNewProductPageSteps.enterShortDescription("Max auto product short description");
        createNewProductPageSteps.enterSKU("100001");
        createNewProductPageSteps.enterWeight("18");
        createNewProductPageSteps.selectStatus("1");
        createNewProductPageSteps.selectVisibility("4");
        createNewProductPageSteps.enterName("Max auto product");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.enterProductPrice("21");
        createNewProductPageSteps.selectTaxClass("0");
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku("100001");
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction("attributes");
        manageProductsPageSteps.submitActionn();
        manageProductsPageSteps.updateProductNameCheckboxClick();
        createNewProductPageSteps.enterName("New Max auto product name");
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.checkNameUpdated("//*[contains(text(), 'New Max auto product name')]");
        manageProductsPageSteps.selectAction("delete");
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        manageProductsPageSteps.clearSKUFilter();
    }




}
