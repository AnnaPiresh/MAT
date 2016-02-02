package com.qamadness.steps.backendSteps;

import com.qamadness.pages.backend.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class LoginPageSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void openPage(){loginPage.openPage();}

    @Step
    public void navigate_to_dashboard() {loginPage.navigateToDashboard();}

    @Step
    public void loginInput(String login){loginPage.loginInput(login);}

    @Step
    public void passInput(String password){loginPage.passInput(password);}

    @Step
    public void loginButton(){loginPage.loginButton();}

    @Step
    public void click_Forgot_Password_Link (){
        loginPage.clickForgotPasswordLink();
    }

    //Verifications:

    @Step
    public void verify_That_Inactive_Account_Error_Is_Displayed (){
        loginPage.verifyThatInactiveAccountErrorIsDisplayed();
    }

    @Step
    public void verify_That_Access_Denied_Error_Is_Displayed (){
        loginPage.verifyThatAccessDeniedErrorIsDisplayed();
    }

    @Step
    public void verify_That_User_Name_Is_Required_Error_Is_Displayed (){
        loginPage.verifyThatUserNameIsRequiredErrorIsDisplayed();
    }

    @Step
    public void verify_That_Password_Is_Required_Error_Is_Displayed (){
        loginPage.verifyThatPasswordIsRequiredErrorIsDisplayed();
    }

    @Step
    public void verify_That_Invalid_User_Name_Or_Password_Error_Is_Displayed (){
        loginPage.verifyThatInvalidUserNameOrPasswordErrorIsDisplayed();
    }
}
