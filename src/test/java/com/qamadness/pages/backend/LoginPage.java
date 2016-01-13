package com.qamadness.pages.backend;

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



    public void openPage() {
        getDriver().navigate().to("http://qamad:f3Vh!@www.qamadness.dev/admin");
        getDriver().manage().window().maximize();
    }


    @FindBy(xpath = ".//*[@id='username']")
    WebElementFacade loginInput;
    public void loginInput(){
        loginInput.sendKeys("admin");
    }

    @FindBy(xpath = ".//*[@id='login']")
    WebElementFacade passInput;
    public void passInput(){
        passInput.sendKeys("3HSYOFf");
    }

    @FindBy(css = ".form-button")
    WebElementFacade loginButton;
    public void loginButton(){
        getDriver().manage().window().maximize();
        loginButton.click();
        //loginButton.click();
    }

    @FindBy(name = "DELAY")
    WebElementFacade delay;
    public void delay(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(delay));
        delay.click();
    }







}

