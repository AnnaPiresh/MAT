package com.qamadness.Story.catalog.category;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps.ManageCategoriesPageSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageProductsSteps.CreateNewProductPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by M. Yermolenko on 19.01.2016.
 */


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

    @Pending
    @Test
    public void createRootCategoryWithRequiredFields () {


        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageCategoriesPage();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(categoryName);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();


    }

    @Test
    public void createRootCategoryWithAllFields () {


        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.openManageCategoriesPage();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(categoryName);
        manageCategoriesPageSteps.enterCategoryDescription(desc);
        manageCategoriesPageSteps.enterPageTitle(title);
        manageCategoriesPageSteps.enterMetaKeywords(keywords);
        manageCategoriesPageSteps.entermetaDescription(metadesc);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.selectDisplaySettingsTab();
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();


    }
}
