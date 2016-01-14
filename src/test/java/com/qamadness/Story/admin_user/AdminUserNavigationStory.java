package com.qamadness.Story.admin_user;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.system.permissions.users.CreateNewUserPageSteps;
import com.qamadness.steps.system.permissions.users.ManageUsersPageSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alexandra on 1/14/16.
 */
@RunWith(ThucydidesRunner.class)
public class AdminUserNavigationStory {

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
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Admin_Users_Page();
        manageUsersPageSteps.click_Add_New_User_Button();
        createNewUserPageSteps.verify_That_Back_Button_Is_Present();
        createNewUserPageSteps.verify_That_Save_User_Button_Is_Present();
        createNewUserPageSteps.verify_That_Reset_Button_Is_Present();
    }

}
