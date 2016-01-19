package com.qamadness.pages.backend.catalog.Attributes.ManageAttributeSets;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kampa on 15.01.2016.
 */
public class CreateAttributeSetPage extends PageObject{

//----------------------------------Objects for Creating an Attribute Set----------------------------------------------//

    @FindBy(xpath = ".//button[@title='Add New Set']")
    WebElementFacade addNewSetButton;

    @FindBy(xpath = ".//*[@id='attribute_set_name']")
    WebElementFacade attributeNameField;

    @FindBy(xpath = ".//button[@title='Save Attribute Set']")
    WebElementFacade saveAttributeSetButton;

    @FindBy(xpath = ".//*[@id='advice-required-entry-attribute_set_name']")
    WebElementFacade requiredFieldMessage;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

    @FindBy(xpath = ".//*[@class='error-msg']")
    WebElementFacade errorMsg;

//--------------------------------Methods for Creating an Attribute Set------------------------------------------------//

    public void clickAddNewAttributeSetBtn(){
        addNewSetButton.click();
    }

    public void enterAttributeSetName(String setName){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(attributeNameField));
        attributeNameField.click();
        attributeNameField.sendKeys(setName);
    }

    public void saveAttributeSet(){
        saveAttributeSetButton.click();
    }

    public void checkSuccessMsg(String message){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(message)){
            System.out.println("Success message is present");
        } else {
            Assert.fail("Success message is not present");
        }
    }

    public void checkErrorMsg(String eMessage){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.isPresent());
        Assert.assertEquals(eMessage, errorMsg.getText());
    }

    public void checkRequiredFieldMsg(String requiredMessage){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(requiredFieldMessage));
        Assert.assertTrue(requiredFieldMessage.isPresent());
        if (requiredFieldMessage.containsText(requiredMessage)){
            System.out.println("Error message is correct");
        } else {
            Assert.fail("Error message is incorrect");
        }
    }


}
