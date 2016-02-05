package com.qamadness.pages.frontend.registrationPage;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.Matchers.is;

/**
 * Created by Vladislav.E on 04.02.2016.
 */
public class RegistrationPage extends PageObject {



//-----------------------------------------------Objects for Register Page--------------------------------------------//

    @FindBy(xpath = ".//*[@id='firstname']")
    WebElementFacade firstNameFld;

    @FindBy(xpath = ".//*[@id='lastname']")
    WebElementFacade lastNameFld;

    @FindBy(xpath = ".//*[@id='email_address']")
    WebElementFacade emailAddressFld;

    @FindBy(xpath = ".//*[@id='password']")
    WebElementFacade passwordFld;

    @FindBy(xpath = ".//*[@id='confirmation']")
    WebElementFacade confirmPasswordFld;

    @FindBy(xpath = ".//*[@id='is_subscribed']")
    WebElementFacade signUpForNewsletterCheckbox;

    @FindBy(xpath = ".//button[@class='button'][@title='Register']")
    WebElementFacade registerBtn;

    @FindBy(xpath = ".//li[@class='success-msg']/ul/li/span")
    WebElementFacade registrationSuccessMsg;


//---------------------------------------------Methods for Register Page----------------------------------------------//

    public void enterFirstName(String firstName) { firstNameFld.sendKeys(firstName);}

    public void enterLastName(String lastName) {lastNameFld.sendKeys(lastName);}

    public void enterEmailAddress(String email) {emailAddressFld.sendKeys(email);}

    public void enterPassword(String passwordRegister) {passwordFld.sendKeys(passwordRegister);}

    public void enterPasswordToConfirmFld(String passwordRegister) {confirmPasswordFld.sendKeys(passwordRegister);}

    public void clickSignUpNewsletterCheckbox() {signUpForNewsletterCheckbox.click();}

    public void clickRegisterBtn() {registerBtn.click();}

    public void checkSuccessRegistrationMsg() {
        Assert.assertThat(registrationSuccessMsg.getText(), is("Thank you for registering with Madison Island."));}


}
