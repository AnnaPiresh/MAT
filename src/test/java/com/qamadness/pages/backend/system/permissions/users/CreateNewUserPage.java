package com.qamadness.pages.backend.system.permissions.users;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 1/14/16.
 */
public class CreateNewUserPage extends PageObject {

    //Page title:

    @FindBy (xpath = ".//h3[contains(.,'New User')]")
    WebElementFacade newUserPageTitle;

    //Buttons:
    @FindBy (xpath = "//button[span='Back']")
    WebElementFacade backButton;

    @FindBy (xpath = "//button[span='Reset']")
    WebElementFacade resetButton;

    @FindBy (xpath = "//button[span='Save User']")
    WebElementFacade saveAdminUserButton;

    @FindBy (xpath = "//button[span='Delete User']")
    WebElementFacade deleteUserButton;

    //User Info tab:

    @FindBy (xpath = "//a[@id='page_tabs_main_section']/span")
    WebElementFacade userInfoTab;

    @FindBy (xpath = "//input[@id='user_username']")
    WebElementFacade userNameField;

    @FindBy (xpath = "//input[@id='user_firstname']")
    WebElementFacade firstNameField;

    @FindBy (xpath = "//input[@id='user_lastname']")
    WebElementFacade lastNameField;

    @FindBy (xpath = "//input[@id='user_email']")
    WebElementFacade emailField;

    @FindBy (xpath = "//input[@id='user_current_password']")
    WebElementFacade currentAdminPassword;

    @FindBy (xpath = "//input[@id='user_password']")
    WebElementFacade passwordField;

    @FindBy (xpath = "//input[@id='user_confirmation']")
    WebElementFacade passwordConfirmationField;

    @FindBy (xpath = "//select[@id='user_is_active']")
    WebElementFacade thisAccountIsDropDown;

    //User Role tab:

    @FindBy (xpath = "//a[@id='page_tabs_roles_section']/span")
    WebElementFacade userRoleTab;

    @FindBy (xpath = "//div[@id='permissionsUserRolesGrid']")
    WebElementFacade userRoleGrid;

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetFilterButton;

    @FindBy (xpath = "//button[span='Search']")
    WebElementFacade searchButton;

    @FindBy (xpath = "//input[@name='assigned_user_role']")
    WebElementFacade assignedDropdown;

    @FindBy (xpath = "//input[@name='role_name']")
    WebElementFacade roleNameField;

    @FindBy (xpath = "//tr//input[@class='radio']")
    WebElementFacade selectByRoleNameRadioButtons;

    //Messages:

    @FindBy (xpath = ".//*[@id='advice-required-entry-user_email' and contains(.,'This is a required field')]")
    WebElementFacade errorEmailIsRequired;

    //Verification methods:

    public void verifyThatBackButtonIsPresent (){
        Assert.assertTrue("Back button is present", backButton.isDisplayed());
    }

    public void verifyThatSaveUserButtonIsPresent (){
        Assert.assertTrue("Save user is displayed",saveAdminUserButton.isDisplayed());
    }

    public void verifyThatResetButtonIsPresent (){
        Assert.assertTrue("Reset buttn is displayed", resetButton.isDisplayed());
    }

    public void verifyThatEmailIsRequiredErrorMessageIsDisplayed (){
        Assert.assertTrue("Error message is displayed", errorEmailIsRequired.isDisplayed());
    }

    //Fill fields on User Info tab methods:

    public void fillUserNameField (String userName){
        userNameField.type(userName);
    }

    public void fillFirstNameField (String firstName){
        firstNameField.type(firstName);
    }

    public void fillLastNameField (String lastName){
        lastNameField.type(lastName);
    }

    public void fillEmailField (String email){
        emailField.type(email);
    }

    public void fillCurrentAdminPasswordField (String currentPass){
        currentAdminPassword.type(currentPass);
    }

    public void fillPasswordField (String password){
        passwordField.type(password);
    }

    public void fillPasswordConfirmationField (String passConfirmation){
        passwordConfirmationField.type(passConfirmation);
    }

    public void selectIsAccountActive (String status){
        thisAccountIsDropDown.selectByVisibleText(status);
    }

    //Click general buttons methods:

    public void clickSaveUserButton (){
        saveAdminUserButton.click();
    }

    public void clickBackButton (){
        backButton.click();
    }

    public void clickDeleteButtonAndConfirm (){
        deleteUserButton.click();
        getDriver().switchTo().alert().accept();
    }

}
