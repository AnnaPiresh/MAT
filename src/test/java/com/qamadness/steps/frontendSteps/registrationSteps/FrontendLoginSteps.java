package com.qamadness.steps.frontendSteps.registrationSteps;

import com.qamadness.pages.frontend.registrationPage.FrontendLoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Anna Piresh on 28.01.2016.
 */
public class FrontendLoginSteps extends ScenarioSteps {

    FrontendLoginPage frontendLoginPage;

    @Step
    public void enter_customer_email(String email) { frontendLoginPage.enterCustomerEmail(email);}

    @Step
    public void enter_customer_password(String password) { frontendLoginPage.enterCustomerPassword(password);}

    @Step
    public void untick_remember_me_checkbox() { frontendLoginPage.untickRememberMeCheckbox();}

    @Step
    public void click_login_button() {frontendLoginPage.clickLoginButton();}

    @Step
    public void click_create_account_button() {frontendLoginPage.clickCreateAccountButton();}

}
