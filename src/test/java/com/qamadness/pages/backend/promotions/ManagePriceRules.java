package com.qamadness.pages.backend.promotions;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class ManagePriceRules extends PageObject {

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

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

    @FindBy(xpath = ".//*[@id='promo_catalog_grid_filter_name']")
    WebElementFacade catRuleNameField;
    //field for search for rule by name in Catalog price rules grid

    @FindBy(xpath = ".//*[@id='promo_catalog_grid_table']/tbody/tr[1]/td[2]")
    WebElementFacade firstRuleInCatGrid;
    //first found rule in Catalog price rules grid

    @FindBy(xpath = ".//button[@title='Delete']")
    WebElementFacade deleteBtn;

//---------------------------------Objects for Adding Shopping Cart Price Rule-----------------------------------------//

    @FindBy(xpath = ".//*[@id='rule_coupon_type']")
    WebElementFacade couponDropdown;

    @FindBy(xpath = ".//*[@id='rule_coupon_code']")
    WebElementFacade couponCodeField;

    @FindBy(xpath = ".//*[@id='global_search']")
    WebElementFacade globalSearch;

    @FindBy(xpath = ".//*[@id='promo_quote_grid_filter_name']")
    WebElementFacade shopRuleNameField;
    //field for search for rule by name in CShopping cart price rules grid

    @FindBy(xpath = ".//*[@id='promo_quote_grid_table']/tbody/tr/td[2]")
    WebElementFacade firstRuleInShopGrid;
    //first found rule in Shopping  price rules grid

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

    public void selectCustomerGroupsApplyTo(char[] customerGroups){
        customerGroupsSelect.sendKeys(Keys.CONTROL);
        customerGroupsSelect.selectByValue(String.valueOf(customerGroups[0]));
        customerGroupsSelect.selectByValue(String.valueOf(customerGroups[1]));
        customerGroupsSelect.selectByValue(String.valueOf(customerGroups[2]));
        customerGroupsSelect.selectByValue(String.valueOf(customerGroups[3]));
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

    public void checkSuccessMsg(String message){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(message)){
            System.out.println("Success message is present");
        } else {
            Assert.fail("Success message is not present");
        }
    }

    public void findCreatedCatRule(String ruleId){
        catRuleNameField.click();
        catRuleNameField.sendKeys(ruleId);
        catRuleNameField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstRuleInCatGrid));
        if (firstRuleInCatGrid.containsText(ruleId)){
            firstRuleInCatGrid.click();
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

//--------------------------------Methods for Adding Shopping Cart Price Rule------------------------------------------//

    public void selectCouponTypeFromDropdown(String couponType){
        couponDropdown.click();
        couponDropdown.selectByValue(couponType).click();
    }

    public void enterCouponCode(String couponCode){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(couponCodeField));
        couponCodeField.click();
        couponCodeField.sendKeys(couponCode);
    }

    public void clearGlobalSearch () { globalSearch.clear();}

    public void findCreatedShopRule(String ruleId){
        shopRuleNameField.click();
        shopRuleNameField.sendKeys(ruleId);
        shopRuleNameField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(firstRuleInShopGrid));
        if (firstRuleInShopGrid.containsText(ruleId)){
            firstRuleInShopGrid.click();
        }else {
            Assert.fail("Rule cannot be found");
        }
    }


}
