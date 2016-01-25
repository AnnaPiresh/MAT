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

    // Test case "Restore password with valid email and login with old password"

    @Issue("MAT-66")
    @Pending @Test
    public void restorePasswordWithValidEmailAdnLoginWithOldPassword (){
        //login and navigate to System -> Permissions -> Users page
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        //create Administrator role
        mainMenuSteps.open_Manage_Roles_Page();
        manageRolesPageSteps.click_Add_New_Role_Button();
        newRolePageSteps.fill_Role_Name_Field(newAdminRole);
        newRolePageSteps.fill_Current_Admin_Password_Field(adminPassword);
        newRolePageSteps.open_Role_Resources_Tab();
        newRolePageSteps.select_All_Resources_Access();
        newRolePageSteps.click_Save_Button();
        manageRolesPageSteps.verify_That_Role_Is_Created(newAdminRole);
        //create new Admin user and log out from admin
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(newAdminUserName);
        createNewUserPageSteps.fill_First_Name_Field(newAdminFirstName);
        createNewUserPageSteps.fill_Last_Name_Field(newAdminLastName);
        createNewUserPageSteps.fill_Email_Field(newAdminEmail);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(newAdminPassword);
        createNewUserPageSteps.fill_Password_Confirmation_Field(newAdminPassword);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.open_User_Role_Tab();
        createNewUserPageSteps.search_For_Role(newAdminRole);
        createNewUserPageSteps.search_For_Role(newAdminRole);
        createNewUserPageSteps.select_First_Role_In_The_List();
        createNewUserPageSteps.click_Save_User_Button();
        logoutFromAdminSteps.logout_from_admin();
        //restore password for new admin account
        loginPageSteps.openPage();
        loginPageSteps.click_Forgot_Password_Link();
        adminForgotPasswordPageSteps.enter_Email_Address(newAdminEmail);
        adminForgotPasswordPageSteps.click_Retrieve_Password_Button();
        adminForgotPasswordPageSteps.verify_That_Restore_Password_Success_Message_Is_Displayed();
        //login with old password
        loginPageSteps.loginInput(newAdminUserName);
        loginPageSteps.passInput(newAdminPassword);
        loginPageSteps.loginButton();
        //verification:
        dashboardSteps.verify_That_Current_Page_Is_Dashboard();
        logoutFromAdminSteps.logout_from_admin();
        //remove created user and Role
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(newAdminEmail);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
        mainMenuSteps.open_Manage_Roles_Page();
        manageRolesPageSteps.find_Role_And_Open(newAdminRole);
        newRolePageSteps.click_Delete_Role_Button_And_Confirm();
    }
}
