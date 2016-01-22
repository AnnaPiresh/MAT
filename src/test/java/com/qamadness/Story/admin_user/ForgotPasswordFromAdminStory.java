package com.qamadness.Story.admin_user;

import com.qamadness.steps.backendSteps.AdminForgotPasswordPageSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.LogoutFromAdminSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.roles.ManageRolesPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.roles.NewRolePageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.CreateNewUserPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.ManageUsersPageSteps;
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

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 1/22/16.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/admin_user/AdminForgotPasswordData.csv")
public class ForgotPasswordFromAdminStory {

    //Data in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String newAdminRole;
    private String newAdminUserName;
    private String newAdminFirstName;
    private String newAdminLastName;
    private String newAdminEmail;
    private String newAdminPassword;
    private String thisAccountIsActive;
    private String invalidEmail;
    private String newPassword;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManageUsersPageSteps manageUsersPageSteps;

    @Steps
    CreateNewUserPageSteps createNewUserPageSteps;

    @Steps
    LogoutFromAdminSteps logoutFromAdminSteps;

    @Steps
    ManageRolesPageSteps manageRolesPageSteps;

    @Steps
    NewRolePageSteps newRolePageSteps;

    @Steps
    AdminForgotPasswordPageSteps adminForgotPasswordPageSteps;

    /*Precondition: Open login to admin page*/

    @Before
    public void preconditionOpenLoginToAdminPage (){
        //login and navigate to System -> Permissions -> Users page
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
    }

    //Test case "Restore password with empty "Forgot password field"":

    @Issue("MAT-63")
    @Pending @Test
    public void restorePasswordWithEmptyField (){
        loginPageSteps.click_Forgot_Password_Link();
        adminForgotPasswordPageSteps.enter_Email_Address("");
        adminForgotPasswordPageSteps.click_Retrieve_Password_Button();
        //verifications:
        adminForgotPasswordPageSteps.verify_That_Email_Is_Required_Error_Message_Is_Displayed();
    }

    // Test case "Restore password with invalid email":

    @Issue("MAT-64")
    @Pending @Test
    public void restorePasswordWithInvalidEmail (){
        loginPageSteps.click_Forgot_Password_Link();
        adminForgotPasswordPageSteps.enter_Email_Address(invalidEmail);
        adminForgotPasswordPageSteps.click_Retrieve_Password_Button();
        //verifications:
        adminForgotPasswordPageSteps.verify_That_Invalid_Email_Error_Message_Is_Displayed();
    }

    //Test case "Restore password with correct email":

    @Issue("MAT-65")
    @Pending @Test
    public void restorePasswordWithCorrectEmail (){
        loginPageSteps.click_Forgot_Password_Link();
        adminForgotPasswordPageSteps.enter_Email_Address(newAdminEmail);
        adminForgotPasswordPageSteps.click_Retrieve_Password_Button();
        //verifications:
        adminForgotPasswordPageSteps.verify_That_Restore_Password_Success_Message_Is_Displayed();
    }

}
