package com.qamadness.Story;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SortingAndFilteringOfOrdersSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class SortingAndFilteringOfOrdersStory {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    SortingAndFilteringOfOrdersSteps sortingAndFilteringOfOrdersSteps;

    @Issue("MAT-12")
    @Test
    public void check_that_user_can_change_qty_of_orders_displayed_per_page(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        sortingAndFilteringOfOrdersSteps.can_user_change_qty_of_orders();
        sortingAndFilteringOfOrdersSteps.check_new_qty_of_orders();

    }


}
