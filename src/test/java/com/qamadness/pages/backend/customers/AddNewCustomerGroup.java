package com.qamadness.pages.backend.customers;


import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomerGroup extends PageObject{

//---------------------------------------------Objects for Adding New Customer Group----------------------------------------//


    @FindBy(xpath = ".//*[text()='Add New Customer Group']")
    WebElementFacade addNewCustomerGroupBtn;

    @FindBy(xpath = ".//*[@id='customer_group_code']")
    WebElementFacade customerGroupCodeFld;

    @FindBy(xpath = ".//*[@id='tax_class_id']")
    WebElementFacade taxClassDropdown;

    @FindBy(xpath = ".//*[text()='Save Customer Group']")
    WebElementFacade saveCustomerGroupBtn;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

    @FindBy(xpath = ".//*[@id='customerGroupGrid_filter_type']")
    WebElementFacade groupNameFld;

    @FindBy(xpath = ".//*[@id='customerGroupGrid_table']/tbody/tr/td[2]")
    WebElementFacade gridFirstLine;

    @FindBy(xpath = ".//*[text()='Delete Customer Group']")
    WebElementFacade deleteCustomerGroupBtn;

//---------------------------------------------Methods for Adding New Customer Group----------------------------------------//

    public void clickAddCustomerGroupBtn(){
        addNewCustomerGroupBtn.click();
    }

    public void enterGroupCode(String groupcode){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(customerGroupCodeFld));
        customerGroupCodeFld.click();
        customerGroupCodeFld.sendKeys(groupcode);
    }

    public void selectTaxClass(String taxvalue){
        taxClassDropdown.click();
        taxClassDropdown.selectByValue(taxvalue);
    }

    public void clickSaveCustomerGroupBtn(){
        saveCustomerGroupBtn.click();
    }

    public void checkSuccessMsg(String successMText){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(successMText)){
            System.out.println("Customer group is saved");
        }else {
            Assert.fail("Customer group is not saved");
        }
    }

    public void findCreatedGroup(String groupcode){
        groupNameFld.click();
        groupNameFld.sendKeys(groupcode);
        groupNameFld.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.textToBePresentInElement(gridFirstLine, groupcode));
        if (gridFirstLine.containsText(groupcode)){
        gridFirstLine.click();
    } else {
     Assert.fail("Created customer group cannot be found");}
     }

    public void deleteCreatedGroup(String confirmDelete){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(deleteCustomerGroupBtn));
        deleteCustomerGroupBtn.click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if(successMsg.containsText(confirmDelete)){
            System.out.println("Customer group is successfully deleted");
        } else {
            Assert.fail("Customer group is not deleted");
        }
    }




}
