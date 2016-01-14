package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateShipment extends PageObject{

//------------------------------------------Objects for Creating Shipment-------------------------------------------------//

    @FindBy(xpath = ".//button[@title='Ship']")
    WebElementFacade shipmentBtn;
    //"Ship" button at order's page

    @FindBy(xpath = ".//button[@title='Submit Shipment']")
    WebElementFacade submitShipmentBtn;
    //"Submit shipment" button at new shipment page

//------------------------------------------Methods for Creating Shipment-------------------------------------------------//

    public void createShipmentForOrder(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
        shipmentBtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order_shipment/new/order_id/"));
        submitShipmentBtn.click();
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
    }

}
