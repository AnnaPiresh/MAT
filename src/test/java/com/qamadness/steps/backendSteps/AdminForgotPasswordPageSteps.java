package com.qamadness.steps.backendSteps;

import com.qamadness.pages.backend.AdminForgotPasswordPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/22/16.
 */
public class AdminForgotPasswordPageSteps extends ScenarioSteps {

    AdminForgotPasswordPage adminForgotPasswordPage;

    @Step
    public void enter_Email_Address (String email){
        adminForgotPasswordPage.enterEmailAddress(email);
    }

    @Step
    public void click_Retrieve_Password_Button (){
        adminForgotPasswordPage.clickRetrievePasswordButton();
    }

    @Step
    public void click_Back_To_Login_Link (){
        adminForgotPasswordPage.clickBackToLoginLink();
    }

    //verifications:

    @Step
    public void verify_That_Email_Is_Required_Error_Message_Is_Displayed (){
        adminForgotPasswordPage.verifyThatEmailIsRequiredErrorMessageIsDisplayed();
    }

    @Step
    public void verify_That_Invalid_Email_Error_Message_Is_Displayed (){
        adminForgotPasswordPage.verifyThatInvalidEmailErorrMessageIsDisplayed();
    }

    @Step
    public void verify_That_Restore_Password_Success_Message_Is_Displayed (){
        adminForgotPasswordPage.verifyThatRestorePasswordSuccessMessageIsDisplayed();
    }
}
