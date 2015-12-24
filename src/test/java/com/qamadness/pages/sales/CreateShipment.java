package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateShipment extends PageObject{

    @FindBy(xpath = ".//button[@title='Ship']")
    WebElementFacade shipmentBtn;
    //"Ship" button at order's page

    @FindBy(xpath = ".//button[@title='Submit Shipment']")
    WebElementFacade submitShipmentBtn;
    //"Submit shipment" button at new shipment page

    @FindBy(xpath = ".//*[@id='messages']")
    WebElementFacade successMsg;
    //Success message after creating an order

    public void createShipmentForOrder(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
        shipmentBtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order_shipment/new/order_id/"));
        submitShipmentBtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
    }

    public void checkShipmentIsCreated(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        Assert.assertTrue(successMsg.isVisible());
        Assert.assertEquals("Shipment is created", "The shipment has been created.", successMsg.getText());
    }


}
