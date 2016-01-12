package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelAnOrder extends PageObject{

    @FindBy(xpath = ".//button[@title='Search']")
    WebElementFacade searchBtn;

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[2]/td[1]/input")
    WebElementFacade selectOrderInput;
    //checkbox to tick an order

    @FindBy(xpath = ".//*[@id='sales_order_grid_filter_status']")
    WebElementFacade statusDropdown;

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction-select']")
    WebElementFacade actionsDropdown;

    @FindBy(xpath = ".//button[@title='Submit']")
    WebElementFacade submitBtn;

    public void seeOrdersInPendingStatus(String status){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown));
        statusDropdown.click();
        statusDropdown.selectByValue(status).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        searchBtn.click();
    }

    public void cancelSelectedOrder(String action){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        selectOrderInput.click();
        actionsDropdown.click();
        actionsDropdown.selectByValue(action).click();
        submitBtn.click();
    }



}
