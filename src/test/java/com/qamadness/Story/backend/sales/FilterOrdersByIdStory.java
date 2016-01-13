package com.qamadness.Story.backend.sales;

import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.sales.FilterOrdersByIdSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.MainMenuSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class FilterOrdersByIdStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    FilterOrdersByIdSteps filterOrdersByIdSteps;

    @Issue("MAT-15")
    @Pending
    @Test
    public void can_user_filter_orders_by_id (){
        String orderID = "302000003";
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        filterOrdersByIdSteps.filter_orders_in_grid(orderID);
        filterOrdersByIdSteps.check_filtered_order_number(orderID);

    }

}
