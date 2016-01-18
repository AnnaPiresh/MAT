package com.qamadness.pages.backend.system.permissions.users;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexandra on 1/14/16.
 */
public class ManageUsersPage extends PageObject {

    //Buttons:

    @FindBy (xpath = "//button[span='Add New User' or span='Add New']")
    WebElementFacade addNewUserButton;

    //PermissionsUserGrid:

    @FindBy (xpath = "//div[@id='permissionsUserGrid']")
    WebElementFacade usersGrid;

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetFilterButton;

    @FindBy (xpath = "//button[span='Search']")
    WebElementFacade searchButton;

    @FindBy (xpath = "//input[@name='user_id']")
    WebElementFacade idField;

    @FindBy (xpath = "//input[@name='username']")
    WebElementFacade userNameField;

    @FindBy (xpath = "//input[@name='firstname']")
    WebElementFacade firstNameField;

    @FindBy (xpath = "//input[@name='lastname']")
    WebElementFacade lastNameField;

    @FindBy (xpath = "//input[@name='email']")
    WebElementFacade emailField;

    @FindBy (xpath = ".//*[@id='permissionsUserGrid_table']/tbody/tr/td[@class='empty-text a-center']")
    WebElementFacade noRecordsFoundResult;

    //Messages:

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'You cannot delete your own account.')]")
    WebElementFacade cannotDeleteAccountMessage;

    @FindBy (xpath = "//div[@id='advice-required-entry-role_name']")
    WebElementFacade errorRequiredFieldRoleName;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'Email already exists.')]")
    WebElementFacade errorExistEmail;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'A user with the same user name or email aleady exists.')]")
    WebElementFacade errorExistEmailOrName;

    @FindBy (xpath = "//div[@id='advice-validate-email-user_email']")
    WebElementFacade errorInvalidEmail;

    @FindBy (xpath = "//div[@id='advice-validate-admin-password-user_password']")
    WebElementFacade errorInvalidPassword;

    @FindBy (xpath = "//div[@id='advice-validate-cpassword-user_confirmation']")
    WebElementFacade errorPasswordUnMatch;

    @FindBy (xpath = "//li[normalize-space(@class)='success-msg' and contains(.,'The user has been deleted.')]")
    WebElementFacade successDeletedUserMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='success-msg' and contains(.,'The user has been saved.')]")
    WebElementFacade successSavedUserMessage;

    @FindBy (xpath = "//div[@id='messages']//li[span='The role has been deleted.']")
    WebElementFacade successDeletedRoleMessage;

    @FindBy (xpath = "//div[@id='messages']//li[span='The role has been successfully saved.']")
    WebElementFacade successSavedRoleMessage;

    //Click general buttons methods:

    public void clickAddNewUserButton (){
        addNewUserButton.click();
    }

    //Methods for search in Users grid:


    public void findUserAndOpen (String email){
        emailField.type(email);
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        WebElement firstEmailInList = getDriver().findElement(By.xpath(".//*[@id='permissionsUserGrid_table']/tbody/tr[1]/td[5]"));
        firstEmailInList.click();
    }


    //Verification methods:

    public void checkThatUserIsCreated (String email){
        emailField.type(email);
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        WebElement firstEmailInList = getDriver().findElement(By.xpath(".//*[@id='permissionsUserGrid_table']/tbody/tr[1]/td[5]"));
        Assert.assertTrue("Correct user is found", firstEmailInList.getText().equals(email));
    }

    public void checkThatSuccessSavedUserMessageIsDisplayed (){
        Assert.assertTrue(successSavedUserMessage.isDisplayed());
    }

    public void checkThatExistEmailOrNameErrorIsDisplayed (){
        Assert.assertTrue("Error message is displayed", errorExistEmailOrName.isDisplayed());
    }

    public void checkByEmailThatUserIsNotCreated (String email){
        emailField.type(email);
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        Assert.assertTrue("User with such email wasn't found", noRecordsFoundResult.isDisplayed());
    }

    public void checkByUserNameThatUserIsNotCreated (String name){
        userNameField.type(name);
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-mask")));
        Assert.assertTrue("User with such email wasn't found", noRecordsFoundResult.isDisplayed());
    }


}
