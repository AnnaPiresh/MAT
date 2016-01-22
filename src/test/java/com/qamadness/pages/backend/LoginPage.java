package com.qamadness.pages.backend;

import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maksim on 14-Dec-15
 */

/*@DefaultUrl("http://qamad:f3Vh!@www.qamadness.dev/admin")*/

public class LoginPage extends PageObject{

    //Messages:
    @FindBy (xpath = ".//li[@class='error-msg']/ul/li/span[contains(.,'This account is inactive')]")
    WebElementFacade errorInactiveAccountMessage;

    @FindBy (xpath = ".//li[@class='error-msg']/ul/li/span[contains(.,'Access denied')]")
    WebElementFacade errorAccessDeniedMessage;

    @FindBy (xpath = ".//*[@id='advice-required-entry-username' and contains(.,'This is a required field')]")
    WebElementFacade errorUserNameIsRequiredFieldMessage;

    @FindBy (xpath = ".//*[@id='advice-required-entry-login' and contains (.,'This is a required field')]")
    WebElementFacade errorPasswordIsRequiredFieldMessage;

    @FindBy (xpath = ".//span[contains(.,'Invalid User Name or Password')]")
    WebElementFacade errorInvalidUserNameOrPasswordMessage;

    //Fields:
    @FindBy(xpath = ".//*[@id='username']")
    WebElementFacade loginInput;

    @FindBy(xpath = ".//*[@id='login']")
    WebElementFacade passInput;

    //Buttons:
    @FindBy(css = ".form-button")
    WebElementFacade loginButton;

    //Links:

    @FindBy (xpath = ".//a[contains(.,'Forgot')]")
    WebElementFacade forgotPasswordLink;

    public void openPage() {
        getDriver().navigate().to("http://qamad:f3Vh!@www.qamadness.dev/admin");
        getDriver().manage().window().maximize();
    }

    public void loginInput(String login){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.sendKeys(login);
    }

    public void passInput(String password){ passInput.sendKeys(password);
    }

    public void loginButton(){
        loginButton.click();
    }

    public void clickForgotPasswordLink (){
        forgotPasswordLink.click();
    }

    //Verifications:

    public void verifyThatInactiveAccountErrorIsDisplayed (){
        Assert.assertTrue("Error message is displayed", errorInactiveAccountMessage.isDisplayed());
    }

    public void verifyThatAccessDeniedErrorIsDisplayed (){
        Assert.assertTrue("Error message is displayed", errorAccessDeniedMessage.isDisplayed());
    }

    public void verifyThatUserNameIsRequiredErrorIsDisplayed (){
        Assert.assertTrue("Error message is displayed",errorUserNameIsRequiredFieldMessage.isDisplayed());
    }

    public void verifyThatPasswordIsRequiredErrorIsDisplayed (){
        Assert.assertTrue("Error message is displayed",errorPasswordIsRequiredFieldMessage.isDisplayed());
    }
    public void verifyThatInvalidUserNameOrPasswordErrorIsDisplayed (){
        Assert.assertTrue("Error message is displayed", errorInvalidUserNameOrPasswordMessage.isDisplayed());
    }
}

