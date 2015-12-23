package com.qamadness.pages.sales;



import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PlaceOrderAsExistingCustomer extends PageObject{

    @FindBy(xpath = ".//button[@title='Create New Order']")
    WebElementFacade createOrderBtn;

    @FindBy(xpath = ".//*[@id='sales_order_create_customer_grid_filter_email']")
    WebElementFacade emailfield;

    @FindBy(xpath = ".//button[@title='Search']")
    WebElementFacade searchBtn;

    @FindBy(xpath = ".//*[@id='sales_order_create_customer_grid_table']/tbody/tr/td[1]")
    WebElementFacade selectedCustomer;

    @FindBy(xpath = ".//*[@id='store_1']")
    WebElementFacade englishStoreview;

    @FindBy(xpath = ".//*[@id='order-items']/div/div[1]/div/button")
    WebElementFacade addProductsBtn;

    @FindBy(xpath = ".//*[@id='sales_order_create_search_grid_table']/tbody/tr[1]/td[5]/input")
    WebElementFacade productCheckbox;

    @FindBy(xpath = ".//button[@title='Add Selected Product(s) to Order']")
    WebElementFacade addSelectedToCartBtn;

    @FindBy(xpath = ".//input[@id='p_method_checkmo']")
    WebElementFacade checkOrderPayment;

    @FindBy(xpath = ".//*[@id='order-shipping-method-summary']/a")
    WebElementFacade getRates;

    @FindBy(xpath = ".//input[@id='s_method_ups_GND']")
    WebElementFacade flatRate;

    @FindBy(xpath = ".//button[@title='Submit Order']")
    WebElementFacade submitBtn;

    @FindBy(xpath = ".//*[@id='messages']")
    WebElementFacade successMessage;

    public void clickCreateOrderBtn(){
        createOrderBtn.click();
    }
    public void selectCustomer(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(emailfield));
        emailfield.click();
        emailfield.sendKeys("testersunny377@gmail.com");
        searchBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        selectedCustomer.click();
        wait.until(ExpectedConditions.elementToBeClickable(englishStoreview));
    }
    public void selectStoreview(){
        WebDriverWait wait4 = new WebDriverWait(getDriver(), 60);
        wait4.until(ExpectedConditions.elementToBeClickable(englishStoreview));
        englishStoreview.click();
    }

    public void addProductstoCart(){
        WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
        wait1.until(ExpectedConditions.elementToBeClickable(addProductsBtn));
        addProductsBtn.click();
        wait1.until(ExpectedConditions.elementToBeClickable(productCheckbox));
        productCheckbox.click();
        addSelectedToCartBtn.click();
    }
    public void selectPaymentShipment() {
        WebDriverWait wait2 = new WebDriverWait(getDriver(), 60);
        wait2.until(ExpectedConditions.elementToBeClickable(getRates));
        getRates.click();
        wait2.until(ExpectedConditions.visibilityOf(flatRate));
        flatRate.click();
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        wait2.until(ExpectedConditions.elementToBeClickable(checkOrderPayment));
        checkOrderPayment.click();
    }
    public void clickSubmit(){
        JavascriptExecutor jsexecute = (JavascriptExecutor)getDriver();
        jsexecute.executeScript("order.submit()");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
    }

    public void checkSuccessMsg (){
       Assert.assertTrue("Success message is present", successMessage.isVisible());
       Assert.assertEquals("Order have been created successfully","The order has been created.", successMessage.getText());
    }


}
