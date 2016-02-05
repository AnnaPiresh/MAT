package com.qamadness.steps.frontendSteps.registrationSteps;

import com.qamadness.pages.frontend.registrationPage.RegistrationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Vladislav.E on 04.02.2016.
 */
public class RegistrationPageSteps extends ScenarioSteps {

    RegistrationPage registrationPage;

    @Step
    public void enter_First_Name(String firstName) {registrationPage.enterFirstName(firstName);}

    @Step
    public void enter_Last_Name(String lastName) {registrationPage.enterLastName(lastName);}

    @Step
    public void enter_Email_Address(String email) {registrationPage.enterEmailAddress(email);}

    @Step
    public void enter_Password(String password) {registrationPage.enterPassword(password);}

    @Step
    public void enter_Password_To_Confirm_Fld(String password) {registrationPage.enterPasswordToConfirmFld(password);}

    @Step
    public void click_Sign_Up_Newsletter_Checkbox() {registrationPage.clickSignUpNewsletterCheckbox();}

    @Step
    public void click_Register_Btn() {registrationPage.clickRegisterBtn();}

    @Step
    public void check_Success_Registration_Msg() {registrationPage.checkSuccessRegistrationMsg();}

}
