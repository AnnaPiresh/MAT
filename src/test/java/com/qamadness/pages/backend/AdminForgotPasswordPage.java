package com.qamadness.pages.backend;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexandra on 1/22/16.
 */
public class AdminForgotPasswordPage extends PageObject {

    //Elements on the page:

    @FindBy (xpath = ".//input[@id='email']")
    WebElementFacade emailAddressField;

    @FindBy (xpath = ".//button[@class='forgot-password']")
    WebElementFacade retrievePasswordButton;

    @FindBy (xpath = ".//a[contains(.,'Back')]")
    WebElementFacade backToLoginLink;

    //Messages:

    @FindBy (xpath = ".//*[@id='advice-required-entry-email']")
    WebElementFacade errorEmailIsRequiredMessage;

    @FindBy (xpath = ".//*[@id='advice-validate-email-email']")
    WebElementFacade errorInvalidEmailMessage;

    @FindBy (xpath = ".//span[contains(.,'you will receive an email with a link to reset your password')]")
    WebElementFacade successRestorePasswordLinkWasSentMessage;

    public void enterEmailAddress (String email){
        emailAddressField.type(email);
    }

    public void clickRetrievePasswordButton (){
        retrievePasswordButton.click();
    }

    public void clickBackToLoginLink (){
        backToLoginLink.click();
    }

    //verifications:

    public void verifyThatEmailIsRequiredErrorMessageIsDisplayed (){
        waitFor(errorEmailIsRequiredMessage);
        Assert.assertTrue(errorEmailIsRequiredMessage.isDisplayed());
    }

    public void verifyThatInvalidEmailErorrMessageIsDisplayed (){
        waitFor(errorInvalidEmailMessage);
        Assert.assertTrue(errorInvalidEmailMessage.isDisplayed());
    }

    public void verifyThatRestorePasswordSuccessMessageIsDisplayed (){
        waitFor(successRestorePasswordLinkWasSentMessage);
        Assert.assertTrue(successRestorePasswordLinkWasSentMessage.isDisplayed());
    }

}
