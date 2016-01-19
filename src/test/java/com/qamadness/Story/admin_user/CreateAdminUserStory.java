package com.qamadness.Story.admin_user;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.LogoutFromAdminSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.CreateNewUserPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.ManageUsersPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 1/14/16.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/admin_user/CreateAdminUserData.csv")
public class CreateAdminUserStory {

    //Fields in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String userName;
    private String userName2;
    private String firstName;
    private String lastName;
    private String email;
    private String email2;
    private String invalidEmail;
    private String password;
    private String passwordConfirmation;
    private String thisAccountIsInactive;
    private String thisAccountIsActive;
    private String userRoleAdmin;
    private String userRoleUser;
    private String userNameSpecial;
    private String firstNameSpecial;
    private String lastNameSpecial;
    private String emailSpecial;
    private String passwordSpecial;
    private String passwordConfirmationSpecial;
    private String wrongPassword;
    private String wrongPasswordConfirmation;

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

    //Precondition: login as admin user and navigate to System -> Permissions -> Users page

    @Before
    public void preconditionLoginAndNavigate(){
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
    }

    //Test case "Create Admin User (all required fields are filled)":

    @Issue("MAT-44")
    @Pending @Test
    public void createAdminWithRequiredFieldsOnly (){
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Success_Saved_User_Message_Is_Displayed();
        manageUsersPageSteps.check_That_User_Is_Created(email);
        //remove created user:
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }

    //Test case "Create Admin User. Use user name that already exist":

    @Issue("MAT-45")
    @Pending @Test
    public void createAdminWithUserNameThatAlreadyExist (){
        //create first user:
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //create second user with name that first user has
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email2);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Exist_Email_Or_Name_Error_Is_Displayed();
        createNewUserPageSteps.click_Back_Button();
        manageUsersPageSteps.check_By_Email_That_User_Is_Not_Created(email2);
        //remove created user:
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }

    //Test case "Create Admin User. Use email that already exist"

    @Issue("MAT-46")
    @Pending @Test
    public void createAdminUserWithEmailThatAlreadyExist (){
        //create first user:
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //create second user with email that first user has
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName2);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Exist_Email_Or_Name_Error_Is_Displayed();
        createNewUserPageSteps.click_Back_Button();
        manageUsersPageSteps.check_By_User_Name_That_User_Is_Not_Created(userName2);
        //remove created user
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }

    //Test case "Create Admin User with one empty required field":

    @Issue("MAT-47")
    @Pending @Test
    public void createAdminWithOneEmptyRequiredField(){
        //create user without email:
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        createNewUserPageSteps.verify_That_Email_Is_Required_Error_Message_Is_Displayed();
        createNewUserPageSteps.click_Back_Button();
        manageUsersPageSteps.check_By_User_Name_That_User_Is_Not_Created(userName);
    }

    //Test case "Create Admin User (all required fields are filled by special characters)"

    @Issue("MAT-48")
    @Pending @Test
    public void createAdminUserWithSpecialCharactersExceptEmail (){
        //create new user with special characters except email and current admin password
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userNameSpecial);
        createNewUserPageSteps.fill_First_Name_Field(firstNameSpecial);
        createNewUserPageSteps.fill_Last_Name_Field(lastNameSpecial);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(passwordSpecial);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmationSpecial);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Success_Saved_User_Message_Is_Displayed();
        manageUsersPageSteps.check_That_User_Is_Created(email);
        //remove created user:
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }

    //Test case "Create Admin User (all required fields are filled by long value data)":

    @Issue("MAT-49")
    @Pending @Test
    public void createAdminUserWithLongValues (){
        //create new user with long values except email and current admin password
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field( UUID.randomUUID().toString());
        createNewUserPageSteps.fill_First_Name_Field( UUID.randomUUID().toString());
        createNewUserPageSteps.fill_Last_Name_Field( UUID.randomUUID().toString());
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        String longPassword =  UUID.randomUUID().toString();
        createNewUserPageSteps.fill_Password_Field(longPassword);
        createNewUserPageSteps.fill_Password_Confirmation_Field(longPassword);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Success_Saved_User_Message_Is_Displayed();
        manageUsersPageSteps.check_That_User_Is_Created(email);
        //remove created user:
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }

    //Test case "Create Admin User. Use wrong values for 'password' fields":

    @Issue("MAT-50")
    @Pending @Test
    public void createAdminWithInvalidPassword (){
        //create new admin user with invalid password and password confirmation:
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(wrongPassword);
        createNewUserPageSteps.fill_Password_Confirmation_Field(wrongPasswordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        createNewUserPageSteps.verify_That_Invalid_Password_Message_Is_Displayed();
        createNewUserPageSteps.verify_That_Invalid_Password_Confirmation_Message_Is_Displayed();
        createNewUserPageSteps.click_Back_Button();
        manageUsersPageSteps.check_By_User_Name_That_User_Is_Not_Created(userName);
    }

    //Test case "Create Admin User (with invalid data in the 'email' field)":

    @Issue("MAT-51")
    @Pending @Test
    public void createAdminUserWithInvalidEmail(){
        //create admin user with invalid email:
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(invalidEmail);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        createNewUserPageSteps.verify_That_Invalid_Email_Message_Is_Displayed();
        createNewUserPageSteps.click_Back_Button();
        manageUsersPageSteps.check_By_User_Name_That_User_Is_Not_Created(userName);
    }

    //Test case "Create Admin User  (as Inactive)"

    @Issue("MAT-52")
    @Pending @Test
    public void createInactiveUser (){
        //create inactive admin user
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsInactive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Success_Saved_User_Message_Is_Displayed();
        manageUsersPageSteps.check_That_User_Is_Created(email);
        logoutFromAdminSteps.logout_from_admin();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(userName);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        loginPageSteps.verify_That_Inactive_Account_Error_Is_Displayed();
        //remove created user:
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }

    //Test case "Create Admin User (without Role)"

    @Issue("MAT-54")
    @Pending @Test
    public void createAdminUserWithoutRole (){
        //create admin user without role
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.fill_User_Name_Field(userName);
        createNewUserPageSteps.fill_First_Name_Field(firstName);
        createNewUserPageSteps.fill_Last_Name_Field(lastName);
        createNewUserPageSteps.fill_Email_Field(email);
        createNewUserPageSteps.fill_Current_Admin_Password_Field(adminPassword);
        createNewUserPageSteps.fill_Password_Field(password);
        createNewUserPageSteps.fill_Password_Confirmation_Field(passwordConfirmation);
        createNewUserPageSteps.select_Is_Account_Active(thisAccountIsActive);
        createNewUserPageSteps.click_Save_User_Button();
        //verifications:
        manageUsersPageSteps.check_That_Success_Saved_User_Message_Is_Displayed();
        manageUsersPageSteps.check_That_User_Is_Created(email);
        logoutFromAdminSteps.logout_from_admin();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(userName);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        loginPageSteps.verify_That_Access_Denied_Error_Is_Displayed();
        //remove created user:
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Reset_Filter_Button();
        manageUsersPageSteps.find_User_By_Email_And_Open(email);
        createNewUserPageSteps.click_Delete_Button_And_Confirm();
    }
}
