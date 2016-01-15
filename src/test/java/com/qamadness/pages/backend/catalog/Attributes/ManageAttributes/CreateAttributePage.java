package com.qamadness.pages.backend.catalog.Attributes.ManageAttributes;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAttributePage extends PageObject{

//--------------------------------------------------Objects for Creating attribute----------------------------------------//

    @FindBy(xpath = ".//button[@title='Add New Attribute']")
    WebElementFacade addNewAttributeBtn;
    //Add New attribute button on page with attributes grid

    @FindBy(xpath = ".//*[@id='product_attribute_tabs_main']/span")
    WebElementFacade propertiesTab;

    @FindBy(xpath = ".//*[@id='attribute_code']")
    WebElementFacade attrCodeFld;
    //Attribute code field

    @FindBy(xpath = ".//*[@id='is_global']")
    WebElementFacade scopeDropdown;
    //Dropdown to select of a scope for attribute

    @FindBy(xpath = ".//*[@id='frontend_input']")
    WebElementFacade catalogInputTypeDropdown;
    //Catalog Input Type for Store Owner dropdown

    @FindBy(xpath = ".//*[@id='base_fieldset']/div/table/tbody/tr[11]/td[2]/select[1]")
    WebElementFacade applyToDropdown;
    //Apply To dropdown

    @FindBy(xpath = ".//*[@id='apply_to']")
    WebElementFacade slctProductType;

    @FindBy(xpath = ".//*[@id='product_attribute_tabs_labels']/span")
    WebElementFacade labelOptionsTab;

    @FindBy(xpath = ".//input[@name='frontend_label[0]']")
    WebElementFacade adminTitleFld;
    //value for Admin in Manage Titles

    @FindBy(xpath = ".//*[@id='add_new_option_button']")
    WebElementFacade addNewOptionBtn;
    //Add new option button

    @FindBy(xpath = ".//input[@name='option[value][option_0][0]']")
    WebElementFacade firstOption;
    //First option in dropdown values in Manage options in admin

    @FindBy(xpath = ".//input[@name='option[value][option_1][0]']")
    WebElementFacade secondOption;
    //Second option in dropdown values in Manage options in admin

    @FindBy(xpath = ".//button[@title='Save Attribute']")
    WebElementFacade saveAttrBtn;

    @FindBy(xpath = ".//*[@title='Delete Attribute']")
    WebElementFacade deleteAttrBtn;

   /* @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;*/

    @FindBy(xpath = ".//input[@id='attributeGrid_filter_attribute_code']")
    WebElementFacade attributeCodeFld;
    //field for entering attribute code in grid

    @FindBy(xpath = ".//*[@id='attributeGrid_table']/tbody/tr/td[1]")
    WebElementFacade selectedAttribute;
    //selected attribute after filtering

//--------------------------------------------------Methods for Creating attribute----------------------------------------//

    public void clickAddNewAttributeBtn(){
        addNewAttributeBtn.click();
    }

    public void addAttrCode(String attrCode){
        attrCodeFld.click();
        attrCodeFld.sendKeys(attrCode);
    }

    public void selectScope(String scope){
        scopeDropdown.click();
        scopeDropdown.selectByValue(scope);
    }

    public void selectInputType(String inptype){
        catalogInputTypeDropdown.click();
        catalogInputTypeDropdown.selectByValue(inptype);
    }

    public void selectApplyTo(String products){
        applyToDropdown.click();
        applyToDropdown.selectByValue(products);
    }
    public void selectProductTypesToApply(String type){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(slctProductType));
        wait.until(ExpectedConditions.elementToBeClickable(slctProductType));
        slctProductType.click();
        slctProductType.selectByValue(type);
    }

    public void switchToOptionsTab(){
        labelOptionsTab.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(addNewOptionBtn));
    }

    public void addAdminValueInManageTitles(String title){
        adminTitleFld.click();
        adminTitleFld.sendKeys(title);
    }

    public void addOptionsToDropdown(){
        addNewOptionBtn.click();
    }

    public void addFirstDropdownOption(String fOption){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(firstOption));
        firstOption.click();
        firstOption.sendKeys(fOption);
    }

    public void addSecondDropdownOption(String sOption){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(secondOption));
        secondOption.click();
        secondOption.sendKeys(sOption);
    }

    public void saveAnAttribute(){
        saveAttrBtn.click();
    }

    public void deleteAttribute(String attrCode){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(attributeCodeFld));
        attributeCodeFld.click();
        attributeCodeFld.sendKeys(attrCode);
        attributeCodeFld.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        selectedAttribute.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        deleteAttrBtn.click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }
}
