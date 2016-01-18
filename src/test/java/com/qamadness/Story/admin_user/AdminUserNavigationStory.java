package com.qamadness.Story.admin_user;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.CreateNewUserPageSteps;
import com.qamadness.steps.backendSteps.systemSteps.permissions.users.ManageUsersPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alexandra on 1/14/16.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/admin_user/CreateAdminUserData.csv")
public class AdminUserNavigationStory {

    private String adminLogin;
    private String adminPassword;

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

    @Issue("MAT-43")
    @Test
    public void navigationToAdminUsersPage (){
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.verify_That_Back_Button_Is_Present();
        createNewUserPageSteps.verify_That_Save_User_Button_Is_Present();
        createNewUserPageSteps.verify_That_Reset_Button_Is_Present();
    }

}
