package com.qamadness.Story.admin_user;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.LogoutFromAdminSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 1/21/16.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/admin_user/LoginToAdminData.csv")
public class LoginToAdminStory {

    //Data in CSV file:

    private String validUserName;
    private String validPassword;
    private String invalidUserName;
    private String invalidPassword;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    LogoutFromAdminSteps logoutFromAdminSteps;

    //Precondition: Open admin login page

    @Before
    public void preconditionNavigateAndCreateAdminUser (){
        //Clear cookies and open admin login page
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
    }

    //Test case "Login to admin as valid user"

    @Issue("MAT-57")
    @Test
    public void loginToAdminWithValidCredentials (){
        loginPageSteps.loginInput(validUserName);
        loginPageSteps.passInput(validPassword);
        loginPageSteps.loginButton();
        //verifications:
        dashboardSteps.verify_That_Current_Page_Is_Dashboard();
        dashboardSteps.closePopup();
        logoutFromAdminSteps.logout_from_admin();
    }
}
