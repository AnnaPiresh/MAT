package com.qamadness.Story.admin_user;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.CreateNewUserPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.ManageUsersPageSteps;
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
 * Created by Alexandra on 1/14/16.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/admin_user/CreateAdminUserData.csv")
public class CreateAdminUserStory {

    //Fields in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
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
    @Test
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
        manageUsersPageSteps.check_That_Success_Saved_User_Message_Is_Displayed();
        manageUsersPageSteps.search_By_User_Email(email);
    }
}
