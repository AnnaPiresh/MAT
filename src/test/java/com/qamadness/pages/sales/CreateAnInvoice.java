package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnInvoice extends PageObject{

    @FindBy(xpath = ".//button[@title='Invoice']")
    WebElementFacade invoiceBtn;
    //invoice button at order's page

    @FindBy(xpath = ".//button[@title='Submit Invoice']")
    WebElementFacade submitInvoiceBtn;
    //"Submit invoice" button at new invoice page

    @FindBy(xpath = ".//*[@id='messages']")
    WebElementFacade successMsg;
    //Success message after creating the invoice

    public void createAnInvoiceForOrder(){
        invoiceBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("/sales_order_invoice/new/order_id/"));
        submitInvoiceBtn.click();
    }
}
