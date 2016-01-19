package com.qamadness.Story.catalog.productsStories;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageProducts/SimpleProductData.csv")
public class SimpleProductStory {

    private String login;
    private String password;
    private String attributeSet;
    private String productType;
    private String productDescription;
    private String productShortDescription;
    private String productSKU;
    private String productStatus;
    private String productVisibility;
    private String productName;
    private String productPrice;
    private String taxClass;
    private String selectAction;
    private String productWeight;

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
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet(attributeSet);
        createNewProductPageSteps.selectProductType(productType);
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterName(productName);
        createNewProductPageSteps.enterProductDescription(productDescription);
        createNewProductPageSteps.enterShortDescription(productShortDescription);
        createNewProductPageSteps.enterSKU(productSKU);
        createNewProductPageSteps.enterWeight(productWeight);
        createNewProductPageSteps.selectStatus(productStatus);
        createNewProductPageSteps.selectVisibility(productVisibility);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.enterProductPrice(productPrice);
        createNewProductPageSteps.selectTaxClass(taxClass);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku(productSKU);
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction(selectAction);
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
        //loginPageSteps.delay();

    }
}
