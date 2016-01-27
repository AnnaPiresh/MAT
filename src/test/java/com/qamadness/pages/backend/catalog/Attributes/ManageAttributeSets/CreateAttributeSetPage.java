package com.qamadness.pages.backend.catalog.Attributes.ManageAttributeSets;

import com.thoughtworks.selenium.webdriven.commands.DragAndDrop;
import net.serenitybdd.core.annotations.findby.*;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

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

    @FindBy(xpath = ".//button[@title='Add New']")
    WebElementFacade addNewAttributeGroupBtn;

    @FindBy(xpath = ".//*[@id='skeleton_set']")
    WebElementFacade basedOnDropdown;

    @FindBy(xpath = ".//div[@id='tree-div1']")
    WebElementFacade listWithAttributeGroups;

    @FindBy(xpath = ".//div[@id='tree-div2']")
    WebElementFacade unassignedAttributes;

    @FindBy(xpath = ".//div[@id='tree-div1']/ul/div/li[last()]/div/a")
    WebElementFacade createdGroup;

    @FindBy(xpath = ".//div[@id='tree-div2']/ul/div/li[last()]/div/a")
    WebElementFacade lastAttribute;

    @FindBy(xpath = ".//button[@title='Delete Attribute Set']")
    WebElementFacade deleteAttributeSetBtn;

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

    public void addNewAttributeGroup(String groupTitle){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewAttributeGroupBtn));
        addNewAttributeGroupBtn.click();
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(groupTitle);
        alert.accept();
    }

    public void scrollDownToCreatedAttributeGroup(){
        listWithAttributeGroups.click();
        JavascriptExecutor jsexecutor = (JavascriptExecutor)getDriver();
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", createdGroup);
    }

    public void dragAndDropUnassignedAttribute(){
        unassignedAttributes.click();
        JavascriptExecutor jsexecutor = (JavascriptExecutor)getDriver();
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", lastAttribute);
        new Actions(getDriver()).dragAndDrop(lastAttribute,createdGroup).perform();
        new Actions(getDriver()).dragAndDrop(lastAttribute,createdGroup).perform();
    }

    public void selectBasedOnValue(String basedOnValue){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(basedOnDropdown));
        basedOnDropdown.click();
        basedOnDropdown.selectByValue(basedOnValue);
        basedOnDropdown.click();
    }

    public void clickDeleteAttributeSetButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(deleteAttributeSetBtn));
        deleteAttributeSetBtn.click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void checkDeleteButtonIsNotPresent(){
        if (deleteAttributeSetBtn.isPresent()){
            Assert.fail("It's possible to delete Default attribute set");
        } else{
            System.out.println("Delete button is not present on page");
        }
    }



}
