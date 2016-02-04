package com.qamadness.Story.catalog.category;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps.ManageCategoriesPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by M. Yermolenko on 19.01.2016.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageCategories/CreateRootCategoryData.csv", separator = ';')
public class CreateRootCategoryStory extends PageObject{

    private String login;
    private String password;
    private String categoryName;
    private String name;
    private String activity;
    private String including;
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

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    ManageCategoriesPageSteps manageCategoriesPageSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    CreateNewProductPageSteps createNewProductPageSteps;

    /*Preconditions:
    1) Login as admin user
    2) Navigate to Manage Categories Page*/

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webDriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();}

        else {}
    }

    @Issue("MAT-77")
    @Pending
    @Test
    public void createRootCategoryWithRequiredFields () {
        
        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(categoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();


    }

    @Issue("MAT-78")
    @Pending
    @Test
        public void createRootCategoryWithAllFields () {

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(categoryName);
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
    }

    @Issue("MAT-79")
    @net.thucydides.core.annotations.Pending
    @Test
    public void createRootCategoryWithRequiredFieldsEmpty () {

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.clearCategoryNameField();
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkNameIsNotAdded();


    }
}
