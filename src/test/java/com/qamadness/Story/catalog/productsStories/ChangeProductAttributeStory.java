package com.qamadness.Story.catalog.productsStories;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageProducts/ChangeProductAttributeData.csv", separator=';')
public class ChangeProductAttributeStory {

    private String login;
    private String password;
    private String attributeSet;
    private String productType;
    private String productDescription;
    private String shortDescription;
    private String SKU;
    private String weight;
    private String status;
    private String visibility;
    private String name;
    private String price;
    private String taxClass;
    private String actionAtributes;
    private String newName;
    private String updatedName;
    private String actionDelete;


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

    //@Pending
    @Test
    public void changingProductAttribute () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.addProduct();
        createNewProductPageSteps.selectAttributeSet(attributeSet);
        createNewProductPageSteps.selectProductType(productType);
        createNewProductPageSteps.continueButton();
        createNewProductPageSteps.enterProductDescription(productDescription);
        createNewProductPageSteps.enterShortDescription(shortDescription);
        createNewProductPageSteps.enterSKU(SKU);
        createNewProductPageSteps.enterWeight(weight);
        createNewProductPageSteps.selectStatus(status);
        createNewProductPageSteps.selectVisibility(visibility);
        createNewProductPageSteps.enterName(name);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectPricesTab();
        createNewProductPageSteps.enterProductPrice(price);
        createNewProductPageSteps.selectTaxClass(taxClass);
        createNewProductPageSteps.clearGlobalSearch();
        createNewProductPageSteps.selectWebsitesTab();
        createNewProductPageSteps.selectMainWebsite();
        createNewProductPageSteps.selectCategoriesTab();
        createNewProductPageSteps.selectFirstCategory();
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.searchBySku(SKU);
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction(actionAtributes);
        manageProductsPageSteps.submitActionn();
        manageProductsPageSteps.updateProductNameCheckboxClick();
        createNewProductPageSteps.enterName(newName);
        createNewProductPageSteps.saveProduct();
        manageProductsPageSteps.checkNameUpdated(updatedName);
        manageProductsPageSteps.selectAction(actionDelete);
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
    }
}
