package com.qamadness.Story.catalog.category;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps.ManageCategoriesPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.ManageProductsPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by M. Yermolenko on 26.01.2016.
 */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageCategories/CreateSubcategoryData.csv", separator = ';')
public class CreateSubCategoryStory {

    private String login;
    private String password;
    private String name;
    private String activity;
    private String including;
    private String parentCategoryLocator;
    private String desc;
    private String title;
    private String keywords;
    private String metadesc;
    private String displayMode;
    private String cMSBlock;
    private String availableProductListingSortBy;
    private String selectDefaultProductListingSortBy;
    private String priceStep;
    private String isAnchor;
    private String useParentCategorySettings;
    private String applyToProducts;
    private String selectCustomDesign;
    private String activeFrom;
    private String activeTo;
    private String pageLayout;
    private String customLayoutUpdate;
    private String nameWithSpecialCharacters;
    private String parentCategoryName;
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
    private String parentSubcategoryName;
    private String parentSubcategoryLocator;

    int i = 0;

    @Managed(uniqueSession = true)
    public WebDriver webDriver;



    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManageCategoriesPageSteps manageCategoriesPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    @Steps
    ManageProductsPageSteps manageProductsPageSteps;

    /*Preconditions:
    1) Login as admin user
    2) Navigate to Manage Categories Page
    3) Create Parent Category*/

    @Before
    public void openPage () throws InterruptedException{
        i = i + 1;
        loginPageSteps.openPage();
        int size = webDriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        //webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
            mainMenuSteps.openManageCategoriesPage();
            manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
            manageCategoriesPageSteps.selectCategoryActivity(activity);
            manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
            manageCategoriesPageSteps.saveCategory();
            manageCategoriesPageSteps.checkSuccessMessage();
        }

        else {
            mainMenuSteps.openManageCategoriesPage();
            webDriver.navigate().refresh();
        }

    }

    /*Postconditions:
    1) Delete Parent Category*/

    @After
    public void parentCategoryDeletion() throws InterruptedException{
        if (i == 6) {
            webDriver.navigate().refresh();
            mainMenuSteps.openManageCategoriesPage();
            webDriver.navigate().refresh();
            manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
            manageCategoriesPageSteps.deleteCategory();
        }
    }

    @Issue("MAT-80")
    @Pending
    @Test
    public void createSubcategoryWithRequiredFields () throws InterruptedException{
        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryNameField();
        manageCategoriesPageSteps.enterCategoryName(name);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();
    }

    @Issue("MAT-81")
    @Pending
    @Test
    public void createSubcategoryWithAllFields () throws InterruptedException{
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

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryNameField();
        manageCategoriesPageSteps.enterCategoryName(name);
        manageCategoriesPageSteps.enterCategoryDescription(desc);
        manageCategoriesPageSteps.enterPageTitle(title);
        manageCategoriesPageSteps.enterMetaKeywords(keywords);
        manageCategoriesPageSteps.entermetaDescription(metadesc);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.selectDisplaySettingsTab();
        manageCategoriesPageSteps.selectDisplayMode(displayMode);
        manageCategoriesPageSteps.selectCMSBlock(cMSBlock);
        manageCategoriesPageSteps.clickUseAllAvailableAttributesCheckbox();
        manageCategoriesPageSteps.selectAvailableProductListingSortBy(availableProductListingSortBy);
        manageCategoriesPageSteps.clickUseConfigSettingCheckbox();
        manageCategoriesPageSteps.selectDefaultProductListingSortBy(selectDefaultProductListingSortBy);
        manageCategoriesPageSteps.clickPriceStepUseConfigSettingCheckbox();
        manageCategoriesPageSteps.enterLayeredNavigationPriceStep(priceStep);
        manageCategoriesPageSteps.selectIsAnchor(isAnchor);
        manageCategoriesPageSteps.selectCustomDesignTab();
        manageCategoriesPageSteps.selectUseParentCategorySettings(useParentCategorySettings);
        manageCategoriesPageSteps.selectApplyToProducts(applyToProducts);
        manageCategoriesPageSteps.selectCustomDesign(selectCustomDesign);
        manageCategoriesPageSteps.selectActiveFrom(activeFrom);
        manageCategoriesPageSteps.selectActiveTo(activeTo);
        manageCategoriesPageSteps.selectPageLayout(pageLayout);
        manageCategoriesPageSteps.enterCustomLayoutUpdate(customLayoutUpdate);
        manageCategoriesPageSteps.selectCategoryProductsTab();
        manageCategoriesPageSteps.selectSomeCategoryProducts();
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();

        mainMenuSteps.openManageProductsPage();
        manageProductsPageSteps.searchBySku(productSKU);
        manageProductsPageSteps.searchButton();
        manageProductsPageSteps.checkProduct();
        manageProductsPageSteps.selectAction(selectAction);
        manageProductsPageSteps.submitAction();
        manageProductsPageSteps.deletionApproveAlert();
    }

    @Issue("MAT-82")
    @Pending
    @Test
    public void createSubcategoryWithRequiredFieldsEmpty () throws InterruptedException{
        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryName();
        manageCategoriesPageSteps.clearCategoryNameField();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkNameIsNotAdded();
    }

    @Issue("MAT-83")
    @Pending
    @Test
    public void createSubcategoryWithSpecialCharacters () throws InterruptedException{
        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryName();
        manageCategoriesPageSteps.enterCategoryName(nameWithSpecialCharacters);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();
    }

    @Issue("MAT-84")
    @Pending
    @Test
    public void createSubcategoryWithLongName () throws InterruptedException{
        String longName = new String(new char[52]).replace("\0", "Test ");
        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryName();
        manageCategoriesPageSteps.enterCategoryName(longName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();
    }

    @Issue("MAT-85")
    @Pending
    @Test
    public void createNestedSubcategoryWithRequiredFields () throws InterruptedException{
        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryNameField();
        manageCategoriesPageSteps.enterCategoryName(parentSubcategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentSubcategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryNameField();
        manageCategoriesPageSteps.enterCategoryName(name);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentSubcategoryLocator);
        manageCategoriesPageSteps.deleteCategory();

    }



}