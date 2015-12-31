package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrderAsNewCustomer extends PageObject {

//--------------------------------------------------Methods for Placing an order----------------------------------------//

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

    public void clickCreateCustomerBtn(){
        createNewCustomerBtn.click();
    }

    public void enterEmailToEmailField(String email){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        enterEmailField.click();
        enterEmailField.sendKeys(email);
    }

    public void enterFirstName(String firstName){
        firstnameBillingField.click();
        firstnameBillingField.sendKeys(firstName);
    }

    public void enterLastName(String lastname) {
        lastnameBillingField.click();
        lastnameBillingField.sendKeys(lastname);
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
