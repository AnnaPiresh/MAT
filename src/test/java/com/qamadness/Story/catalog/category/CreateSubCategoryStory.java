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
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by M. Yermolenko on 26.01.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/catalog/ManageCategories/CreateSubcategoryData.csv", separator = ';')
public class CreateSubCategoryStory {

    private String login;
    private String password;
    private String name;
    private String activity;
    private String including;
    private String rootCategoryName;

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

    //@Pending
    @Test
    public void createRootCategoryWithRequiredFields () {
        mainMenuSteps.openManageCategoriesPage();
        manageCategoriesPageSteps.selectCategoryByName(rootCategoryName);
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.selectGeneralTab();
        createNewProductPageSteps.clearGlobalSearch();
        manageCategoriesPageSteps.enterCategoryName(name);
        manageCategoriesPageSteps.selectCategoryActivity(activity);
        manageCategoriesPageSteps.selectIncludingInNavigationMenu(including);
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        manageCategoriesPageSteps.deleteCategory();
    }


}