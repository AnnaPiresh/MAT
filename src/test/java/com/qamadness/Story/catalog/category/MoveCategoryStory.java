package com.qamadness.Story.catalog.category;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps.ManageCategoriesPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.systemSteps.ManageStoresSteps;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by M. Yermolenko on 03.02.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageCategories/MoveCategoryData.csv", separator = ';')
public class MoveCategoryStory {

    private String login;
    private String password;
    private String name;
    private String activity;
    private String including;
    private String parentCategoryLocator;
    private String parentCategoryName;
    private String secondCategoryName;
    private String secondCategoryLocator;

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
    public void preconditions () {
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

    @Issue("MAT-91")
    @Pending
    @Test
    public void moveRootCategoryToRootCategory () {

        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(parentCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(secondCategoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.moveCategory(secondCategoryLocator, parentCategoryLocator);
        webDriver.navigate().refresh();
        manageCategoriesPageSteps.selectCategoryByName(parentCategoryLocator);
        manageCategoriesPageSteps.deleteCategory();

    }
}
