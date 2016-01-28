package com.qamadness.pages.frontend.registrationPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anna Piresh on 28.01.2016.
 */
public class FrontendLoginPage extends PageObject {

//----------------------------------------------Objects for Login page-------------------------------------------------//

    @FindBy(xpath = ".//*[@id='email']")
    WebElementFacade emailField;

    @FindBy(xpath = ".//*[@id='pass']")
    WebElementFacade passField;

    @FindBy(xpath = ".//*[@title='Remember Me']")
    WebElementFacade rememberMeCheckbox;

    @FindBy(xpath = ".//button[@title='Login']")
    WebElementFacade loginButton;

    @FindBy(xpath = ".//button[@title='Create an Account']")
    WebElementFacade createAccountButton;

//----------------------------------------------Methods for Login page-------------------------------------------------//

    public void enterCustomerEmail(String email){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    public void enterCustomerPassword(String password){passField.sendKeys(password);}

    public void untickRememberMeCheckbox(){rememberMeCheckbox.click();}

    public void clickLoginButton() {loginButton.click();}

    public void clickCreateAccountButton() {createAccountButton.click();}

}
