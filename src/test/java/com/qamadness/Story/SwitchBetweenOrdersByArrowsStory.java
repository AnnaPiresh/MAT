package com.qamadness.Story;


import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SwitchBetweenOrdersByArrowsSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



@RunWith(ThucydidesRunner.class)
public class SwitchBetweenOrdersByArrowsStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    SwitchBetweenOrdersByArrowsSteps switchBetweenOrdersByArrowsSteps;

    @Issue("MAT-13")
    @Test
    public void check_that_user_can_navigate_between_orders_using_arrows() {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Orders_Page();
        switchBetweenOrdersByArrowsSteps.switch_to_next_orders_page();
        switchBetweenOrdersByArrowsSteps.switch_to_previous_orders_page();
    }
}