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
    public void loginInput(){loginPage.loginInput();}

    @Step
    public void passInput(){loginPage.passInput();}

    @Step
    public void loginButton(){loginPage.loginButton();}

    @Step
    public void delay(){loginPage.delay();}
}
