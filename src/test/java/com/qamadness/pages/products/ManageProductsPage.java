package com.qamadness.pages.products;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.ws.WebEndpoint;

public class ManageProductsPage extends PageObject {

    @FindBy (css = "button[title='Add Product']")
    WebElementFacade addProduct;

    public void addProduct () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addProduct));
        addProduct.click();
    }

    @FindBy(css = "#productGrid_product_filter_sku")
    WebElementFacade searchBySku;

    public void searchBySku (String SKU) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(searchBySku));
        searchBySku.sendKeys(SKU);}

    public void clearSKUFilter () {
        searchBySku.clear();
        searchBySku.sendKeys(Keys.ENTER);}

    @FindBy(css = "button[title='Search']")
    WebElementFacade searchButton;

    public void searchButton () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();}

    @FindBy(css = ".massaction-checkbox")
    WebElementFacade checkProduct;

    public void checkProduct () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(checkProduct));
        checkProduct.click();}

    @FindBy (xpath = ".//*[@id='productGrid_massaction-select']")
    WebElementFacade selectActionDropdown;

    public void selectAction (String value) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(selectActionDropdown));
        Select dropdown = new Select(selectActionDropdown);
        dropdown.selectByValue(value);
    }

    @FindBy(css = "button[title='Submit']")
    WebElementFacade submit;

    public void submitAction() { /*submit.click();*/}

    public void submitActionn() { submit.click();}

    public void deletionApproveAlert () {
        submit.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();

    }

    @FindBy(xpath = ".//*[@id='productGrid_table']/tbody/tr/td[12]/a")
    WebElementFacade edit;

    public void edit () { edit.click();}

    @FindBy (xpath = ".//*[@id='name-checkbox']")
    WebElementFacade updateProductNameCheckbox;

    public void updateProductNameCheckboxClick () { updateProductNameCheckbox.click();}

    public void checkNameUpdated (String name) {
        int size = getDriver().findElements(org.openqa.selenium.By.xpath(name)).size();
        if (size > 0) {
            checkProduct();}

        else {
            Assert.fail("Name is wrong");}
    }






}
