package com.qamadness.pages.backend.sales;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class CreateAnOrder extends PageObject {

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

    @FindBy(xpath = ".//*[@id='sales_order_create_customer_grid_table']/tbody/tr/td[2]")
    WebElementFacade selectedCustomer;
    //selected customer after filtering

    @FindBy(xpath = ".//*[@id='store_1']")
    WebElementFacade englishStoreview;
    //radio button for an English storeview

    @FindBy(xpath = ".//*[@id='order-items']/div/div[1]/div/button")
    WebElementFacade addProductsBtn;
    //Add product to Cart button at new order's page

    @FindBy(xpath = ".//*[@id='sales_order_create_search_grid_filter_sku']")
    WebElementFacade productSearchFld;
    //field for search for a product by SKU at list with products

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

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

//------------------------------------Objects for Adding a New Customer------------------------------------------------//

    @FindBy(xpath = ".//button[@title='Create New Customer']")
    WebElementFacade createNewCustomerBtn;

    @FindBy(xpath = ".//*[@id='email']")
    WebElementFacade enterEmailField;

    @FindBy(xpath = ".//*[@id='order-billing_address_firstname']")
    WebElementFacade firstnameBillingField;

    @FindBy(xpath = ".//*[@id='order-billing_address_lastname']")
    WebElementFacade lastnameBillingField;

    @FindBy(xpath = ".//*[@id='order-billing_address_street0']")
    WebElementFacade streetBillingField;

    @FindBy(xpath = ".//*[@id='order-billing_address_city']")
    WebElementFacade cityBillingField;

    @FindBy(id = "order-billing_address_region_id")
    WebElementFacade regionBillingDropdown;

    @FindBy(xpath = ".//*[@id='order-billing_address_postcode']")
    WebElementFacade zipcodeBillingField;

    @FindBy(xpath = ".//*[@id='order-billing_address_telephone']")
    WebElementFacade telephoneFieldBilling;

    @FindBy(xpath = ".//*[@id='order-billing_address_save_in_address_book']")
    WebElementFacade saveAdressCheckbox;


//--------------------------------------------------Methods for Placing an order----------------------------------------//

    public void clickCreateOrderBtn(){
        createOrderBtn.click();
    }

    public void selectCustomer(String emailExisting){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(emailfield));
        emailfield.click();
        emailfield.sendKeys(emailExisting);
        searchBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        wait.until(ExpectedConditions.elementToBeClickable(selectedCustomer));
        selectedCustomer.click();
    }
    public void selectStoreview(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(englishStoreview));
        englishStoreview.click();
    }

    public void addProductstoCart(String productID){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addProductsBtn));
        addProductsBtn.click();
        productSearchFld.click();
        productSearchFld.sendKeys(productID);
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

    public void checkSuccessMsg(String message){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(message)){
            System.out.println("Success message is present");
        } else {
            Assert.fail("Success message is not present");
        }
    }

//-------------------------------------Methods for adding a new customer----------------------------------------------//

    public void clickCreateCustomerBtn(){
        createNewCustomerBtn.click();
    }

    public void enterEmailToEmailField(String emailNew){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        enterEmailField.click();
        enterEmailField.sendKeys(emailNew);
    }

    public void enterFirstName(String firstName){
        firstnameBillingField.click();
        firstnameBillingField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastnameBillingField.click();
        lastnameBillingField.sendKeys(lastName);
    }

    public void enterStreet(String street) {
        streetBillingField.click();
        streetBillingField.sendKeys(street);
    }

    public void enterCity(String city) {
        cityBillingField.click();
        cityBillingField.sendKeys(city);
    }

    public void selectRegion(String region) {
        Select dropdown = new Select(regionBillingDropdown);
        dropdown.selectByValue(region);
    }

    public void enterZipcode(String zipcode) {
        zipcodeBillingField.click();
        zipcodeBillingField.sendKeys(zipcode);
    }

    public void enterTelephone(String telephone){
        telephoneFieldBilling.click();
        telephoneFieldBilling.sendKeys(telephone);
    }

    public void saveAddressCheckbox(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(saveAdressCheckbox));
        saveAdressCheckbox.click();
    }

}
