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
    public void loginInput(String login){loginPage.loginInput(login);}

    @Step
    public void passInput(String password){loginPage.passInput(password);}

    @Step
    public void loginButton(){loginPage.loginButton();}


    //Verifications:

    @Step
    public void verify_That_Inactive_Account_Error_Is_Displayed (){
        loginPage.verifyThatInactiveAccountErrorIsDisplayed();
    }
}
