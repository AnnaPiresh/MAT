package com.qamadness.pages.promotions;


import junit.framework.Assert;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCatalogPriceRule extends PageObject{

//---------------------------------Objects for Adding New Catalog Price Rule------------------------------------------//

    @FindBy(xpath = ".//button[@title='Add New Rule']")
    WebElementFacade addNewRuleBtn;

    @FindBy(xpath = ".//*[@id='rule_name']")
    WebElementFacade addRuleIdField;

    @FindBy(xpath = ".//*[@id='rule_is_active']")
    WebElementFacade ruleStatusDropdown;

    @FindBy(xpath = ".//*[@id='rule_website_ids']")
    WebElementFacade websiteForRuleSelect;

    @FindBy(xpath = ".//*[@id='rule_customer_group_ids']")
    WebElementFacade customerGroupsSelect;

    @FindBy(xpath = ".//*[@id='promo_catalog_edit_tabs_conditions_section']")
    WebElementFacade conditionsTab;

    @FindBy(xpath = ".//*[@title='Add']")
    WebElementFacade plusAddBtn;
    //plus button to add conditions to a rule

    @FindBy(xpath = ".//*[@id='conditions__1__new_child']")
    WebElementFacade conditionsDropdown;
    //dropdown with posible conditions for a rule

    @FindBy(xpath = ".//*[text()='is']")
    WebElementFacade equaltyDropdown;
    //dropdown with equalty of the conditions

    @FindBy(xpath = ".//*[@id='conditions__1--1__operator']")
    WebElementFacade selectEqualtyDropdown;

    @FindBy(xpath = ".//*[text()='...']")
    WebElementFacade conditionValueDots;
    //dropdown with parameters that can be set

    @FindBy(xpath = ".//*[@id='conditions__1--1__value']")
    WebElementFacade enterConditionValueFld;
    //field to enter value of the condition of rule

    @FindBy(xpath = ".//*[@id='promo_catalog_edit_tabs_actions_section']")
    WebElementFacade actionsTab;

    @FindBy(xpath = ".//*[@id='rule_simple_action']")
    WebElementFacade applyToDropdown;

    @FindBy(xpath = ".//*[@id='rule_discount_amount']")
    WebElementFacade discountAmountFld;

    @FindBy(xpath = ".//button[@title='Save']")
    WebElementFacade saveRuleBtn;

    @FindBy(xpath = ".//*[@id='promo_catalog_grid_filter_name']")
    WebElementFacade ruleNameField;

    @FindBy(xpath = ".//*[@id='promo_catalog_grid_table']/tbody/tr[1]/td[2]")
    WebElementFacade firstRuleInGrid;

    @FindBy(xpath = ".//button[@title='Delete']")
    WebElementFacade deleteBtn;

//--------------------------------Methods for Adding New Catalog Price Rule-------------------------------------------//

    public void clickAddNewRuleBtn(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewRuleBtn));
        addNewRuleBtn.click();
    }

    public void enterRuleId(String ruleId){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addRuleIdField));
        addRuleIdField.click();
        addRuleIdField.sendKeys(ruleId);
    }

    public void selectRuleStatus(String status){
        ruleStatusDropdown.click();
        ruleStatusDropdown.selectByValue(status);
    }

    public void selectWebsiteScope(String website){
        websiteForRuleSelect.click();
        websiteForRuleSelect.selectByValue(website);
    }

    public void selectCustomerGroupsApplyTo(String customerGroups[]){
        customerGroupsSelect.sendKeys(Keys.CONTROL);
        customerGroupsSelect.selectByValue(customerGroups[0]);
        customerGroupsSelect.selectByValue(customerGroups[1]);
        customerGroupsSelect.selectByValue(customerGroups[2]);
        customerGroupsSelect.selectByValue(customerGroups[3]);
    }

    public void switchToConditionsTab(){
        conditionsTab.click();
    }

    public void addConditionToRule(String condition){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(plusAddBtn));
        plusAddBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(conditionsDropdown));
        conditionsDropdown.click();
        conditionsDropdown.selectByValue(condition);
    }

    public void selectConditionEqualty(String equalty){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(equaltyDropdown));
        equaltyDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectEqualtyDropdown));
        selectEqualtyDropdown.click();
        selectEqualtyDropdown.selectByValue(equalty);
    }

    public void selectConditionValue(String value){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(conditionValueDots));
        conditionValueDots.click();
        wait.until(ExpectedConditions.elementToBeClickable(enterConditionValueFld));
        enterConditionValueFld.sendKeys(value);
    }

    public void switchToActionsTab(){
        actionsTab.click();
    }

    public void selectApplyToAction(String applyValue){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(applyToDropdown));
        applyToDropdown.click();
        applyToDropdown.selectByValue(applyValue).click();
    }

    public void enterDiscountAmount(String discount){
        discountAmountFld.click();
        discountAmountFld.clear();
        discountAmountFld.sendKeys(discount);
    }

    public void saveRule(){
        saveRuleBtn.click();
    }

    public void findCreatedRule(String ruleId){
        ruleNameField.click();
        ruleNameField.sendKeys(ruleId);
        ruleNameField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstRuleInGrid));
        if (firstRuleInGrid.containsText(ruleId)){
            firstRuleInGrid.click();
        }else {
            Assert.fail("Rule cannot be found");
        }
    }

    public void deleteCreatedRule(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        deleteBtn.click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }



}
