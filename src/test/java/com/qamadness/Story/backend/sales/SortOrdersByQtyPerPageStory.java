package com.qamadness.Story.backend.sales;

import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.MainMenuSteps;
import com.qamadness.steps.backend.sales.SortOrdersByQtyPerPageSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class SortOrdersByQtyPerPageStory {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    SortOrdersByQtyPerPageSteps sortOrdersByQtyPerPageSteps;

    @Issue("MAT-12")
    @Pending
    @Test
    public void check_that_user_can_change_qty_of_orders_displayed_per_page(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        sortOrdersByQtyPerPageSteps.can_user_change_qty_of_orders("50");
        sortOrdersByQtyPerPageSteps.check_new_qty_of_orders();

    }


}
