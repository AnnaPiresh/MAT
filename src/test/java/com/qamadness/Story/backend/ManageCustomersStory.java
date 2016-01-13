package com.qamadness.Story.backend;

import com.qamadness.steps.backend.DashboardSteps;
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

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value="src/test/resources/LessThan5000.csv")
@RunWith(ThucydidesRunner.class)
public class ManageCustomersStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Issue("MAT-17")
    @Pending@Test
    public void check_that_admin_can_create_new_customer (){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Customers_Page();




    }
}
