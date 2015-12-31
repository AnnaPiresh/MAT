package com.qamadness.pages.sales;



import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PlaceOrderAsExistingCustomer extends PageObject{

//--------------------------------------------------Objects for Placing an order----------------------------------------//

    @FindBy(xpath = ".//button[@title='Create New Order']")
    WebElementFacade createOrderBtn;
    //Create new order button in grid

    @FindBy(xpath = ".//*[@id='sales_order_create_customer_grid_filter_email']")
    WebElementFacade emailfield;
    //field to enter email to search for customer

    @FindBy(xpath = ".//button[@title='Search']")
    WebElementFacade searchBtn;
    //search button in grid

    @FindBy(xpath = ".//*[@id='sales_order_create_customer_grid_table']/tbody/tr/td[1]")
    WebElementFacade selectedCustomer;
    //selected customer after filtering

    @FindBy(xpath = ".//*[@id='store_1']")
    WebElementFacade englishStoreview;
    //radio button for an English storeview

    @FindBy(xpath = ".//*[@id='order-items']/div/div[1]/div/button")
    WebElementFacade addProductsBtn;
    //Add product to Cart button at new order's page

    @FindBy(xpath = ".//*[@id='sales_order_create_search_grid_filter_entity_id']")
    WebElementFacade productSearchFld;
    //field for search for a product by id at list with products

    @FindBy(xpath = ".//input[@class='checkbox']")
    WebElementFacade productCheckbox;
    //checkbox to tick for adding to cart a needed product

    @FindBy(xpath = ".//button[@title='Add Selected Product(s) to Order']")
    WebElementFacade addSelectedToCartBtn;
    //adds selected product to cart

    @FindBy(xpath = ".//input[@id='p_method_checkmo']")
    WebElementFacade checkOrderPayment;
    //Check/Money order payment method

    @FindBy(xpath = ".//*[@id='order-shipping-method-summary']/a")
    WebElementFacade getRates;
    //Link "Get rates"

    @FindBy(xpath = ".//*[@id='s_method_flatrate_flatrate']")
    WebElementFacade flatRate;
    //Flat Rate shipping method

    @FindBy(xpath = ".//*[@id='messages']")
    WebElementFacade successMessage;
    //Success message after placing an order

//--------------------------------------------------Methods for Placing an order----------------------------------------//

    public void clickCreateOrderBtn(){
        createOrderBtn.click();
    }

    public void selectCustomer(String email){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(emailfield));
        emailfield.click();
        emailfield.sendKeys(email);
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

    public void addProductstoCart(String SKU){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addProductsBtn));
        addProductsBtn.click();
        productSearchFld.click();
        productSearchFld.sendKeys(SKU);
        productSearchFld.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        wait.until(ExpectedConditions.elementToBeClickable(productCheckbox));
        productCheckbox.click();
        addSelectedToCartBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
    }
    public void selectPaymentShipment() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(getRates));
        getRates.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        wait.until(ExpectedConditions.visibilityOf(flatRate));
        flatRate.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        wait.until(ExpectedConditions.elementToBeClickable(checkOrderPayment));
        checkOrderPayment.click();
    }
    public void clickSubmit(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        JavascriptExecutor jsexecute = (JavascriptExecutor)getDriver();
        jsexecute.executeScript("order.submit()");
        wait.until(ExpectedConditions.urlContains("sales_order/view/order_id"));
    }

    public void checkSuccessMsg (){
       Assert.assertTrue("Success message is present", successMessage.isVisible());
       Assert.assertEquals("Order have been created successfully","The order has been created.", successMessage.getText());
    }


}
