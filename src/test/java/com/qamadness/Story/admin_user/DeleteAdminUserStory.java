package com.qamadness.Story.admin_user;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.LogoutFromAdminSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.roles.ManageRolesPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.roles.NewRolePageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.CreateNewUserPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.ManageUsersPageSteps;
import jline.internal.TestAccessible;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 1/20/16.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/admin_user/DeleteAdminUserData.csv")
public class DeleteAdminUserStory {

    //Fields in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String userRoleName;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String thisAccountIsActive;

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

    /*Precondition:
    * 1) Login ad navigate to System -> Permissions -> Users page
    * 2) Create new admin user with Admin role
    * */

    @Before
    public void preconditionNavigateAndCreateAdminUser (){
        //login and navigate to System -> Permissions -> Users page
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        //create Administrator role
        mainMenuSteps.open_Manage_Roles_Page();
        manageRolesPageSteps.click_Add_New_Role_Button();
        newRolePageSteps.fill_Role_Name_Field(userRoleName);
        newRolePageSteps.fill_Current_Admin_Password_Field(adminPassword);
        newRolePageSteps.open_Role_Resources_Tab();
        newRolePageSteps.select_All_Resources_Access();
        newRolePageSteps.click_Save_Button();
        manageRolesPageSteps.verify_That_Role_Is_Created(userRoleName);
        //create user with Administrator role
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.open_User_Role_Tab();
        createNewUserPageSteps.search_For_Role(userRoleName);
        createNewUserPageSteps.select_First_Role_In_The_List();
        createNewUserPageSteps.click_Save_User_Button();
    }

    //Test case "Delete current admin user"

    @Issue("MAT-55")
    @Test
    public void deleteCurrentAdminUser (){
        //login as created user
        logoutFromAdminSteps.logout_from_admin();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(userName);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        //navigate to Manage Users page find created user and try to remove
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
        //verifications
        createNewUserPageSteps.verify_That_Cannot_Delete_Accoun_tMessage_Is_Displayed();
        //logout and login as another user
        logoutFromAdminSteps.logout_from_admin();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        //remove created user and Role
        mainMenuSteps.open_Manage_Admin_Users_Page();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
        mainMenuSteps.open_Manage_Roles_Page();
        manageRolesPageSteps.find_Role_And_Open(userRoleName);
        newRolePageSteps.click_Delete_Role_Button_And_Confirm();
    }
}
