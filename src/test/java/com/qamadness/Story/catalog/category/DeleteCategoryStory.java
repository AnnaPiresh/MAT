package com.qamadness.Story.catalog.category;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps.ManageCategoriesPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.systemSteps.ManageStoresSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by M. Yermolenko on 02.02.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageCategories/DeleteCategoryData.csv", separator = ';')
public class DeleteCategoryStory {

    private String login;
    private String password;
    private String name;
    private String activity;
    private String including;
    private String parentCategoryLocator;
    private String parentCategoryName;
    private String parentSubcategoryName;
    private String parentSubcategoryLocator;

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

    @Steps
    ManageStoresSteps manageStoresSteps;

    /*Precondition:
    1) Login as admin user
    2) Navigate to Manage Categories Page
     */

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webDriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
            mainMenuSteps.openManageCategoriesPage();
            webDriver.navigate().refresh();}

        else {
            mainMenuSteps.openManageCategoriesPage();
            webDriver.navigate().refresh();
        }

    }

    @Issue("MAT-86")
    @Pending
    @Test
    public void deleteRootCategoryWithRequiredFields () {

        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.checkCategoryDeleted();
    }

    @Issue("MAT-87")
    @Pending
    @Test
    public void deleteSubcategoryWithRequiredFields () {

        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();


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
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.checkCategoryDeleted();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.deleteCategory();
    }

    @Issue("MAT-88")
    @Pending
    @Test
    public void deleteCategoryThatAssignedToStore () {
        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();

        mainMenuSteps.openManageStoresPage();
        manageStoresSteps.clickStoreName();
        manageStoresSteps.selectStoreRootCategory(parentCategoryName);
        manageStoresSteps.clickSaveStoreButton();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.checkDeleteButtonAbsent();

        mainMenuSteps.openManageStoresPage();
        manageStoresSteps.clickStoreName();
        manageStoresSteps.selectStoreRootCategory("Max test assigned category");
        manageStoresSteps.clickSaveStoreButton();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.deleteCategory();
    }

    @Issue("MAT-89")
    @Pending
    @Test
    public void deleteRootCategoryWithSubcategory () {

        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();


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

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.deleteCategory();
        manageCategoriesPageSteps.checkCategoryDeleted();
    }

    @Issue("MAT-90")
    @Pending
    @Test
    public void deleteRootCategoryWithSubcategoryHavingProducts () {

        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        manageCategoriesPageSteps.clearCategoryNameField();
        manageCategoriesPageSteps.enterCategoryName(name);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.selectCategoryProductsTab();
        manageCategoriesPageSteps.selectSomeCategoryProducts();
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();

        mainMenuSteps.openManageCategoriesPage();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.deleteCategory();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.checkCategoryDeleted();
    }
}
