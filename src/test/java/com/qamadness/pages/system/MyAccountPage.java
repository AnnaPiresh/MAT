package com.qamadness.pages.system;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 1/15/16.
 */
public class MyAccountPage extends PageObject {

    //Fields:

    @FindBy (xpath = "//input[@id='username']")
    WebElementFacade userNameField;

    @FindBy (xpath = "//input[@id='firstname']")
    WebElementFacade firstNameField;

    @FindBy (xpath = "//input[@id='lastname']")
    WebElementFacade LastNameField;

    @FindBy (xpath = "//input[@id='email']")
    WebElementFacade emailField;

    @FindBy (xpath = "//input[@id='password']")
    WebElementFacade newPasswordField;

    @FindBy (xpath = "//input[@id='user_confirmation']")
    WebElementFacade passwordConfirmationField;

    //Buttons:

    @FindBy (xpath = "//button[span='Save Account']")
    WebElementFacade saveAccountButton;

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetButton;

}
