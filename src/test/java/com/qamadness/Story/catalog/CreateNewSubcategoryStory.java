package com.qamadness.Story.catalog;

/**
 * Created by M. Yermolneko on 13.01.2016.
 */

import com.qamadness.pages.catalog.ManageCategoriesPage;
import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.catalog.ManageCategoriesPageSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import com.qamadness.steps.products.ManageProductsPageSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(ThucydidesRunner.class)
public class CreateNewSubcategoryStory {

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
    ManageCategoriesPageSteps manageCategoriesPageSteps;

    @Test
    public void creatingNewSubcategory (){
        /*loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();*/
        mainMenuSteps.openManageCategoriesPage();
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.enterCategoryName("Max auto category name");
        manageCategoriesPageSteps.selectCategoryActivity("1");
        manageCategoriesPageSteps.selectIncludingInNavigationMenu("1");
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkCategorySaved();

    }
}
