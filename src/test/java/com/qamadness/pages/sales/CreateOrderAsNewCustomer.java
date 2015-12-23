package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrderAsNewCustomer extends PageObject {

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

    @FindBy(xpath = ".//*[@id='order-billing_address_postcode']")
    WebElementFacade zipcodeBillingField;

    @FindBy(xpath = ".//*[@id='order-billing_address_telephone']")
    WebElementFacade telephoneFieldBilling;

    @FindBy(xpath = ".//*[@id='order-billing_address_save_in_address_book']")
    WebElementFacade saveAdressCheckbox;


    public void clickCreateCustomerBtn(){
        createNewCustomerBtn.click();
    }

    public void enterEmailToEmailField(){
        int i = 1;
        i=++i;
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        enterEmailField.click();
        enterEmailField.sendKeys("testersunny377+"+i+"@gmail.com");
    }

    public void enterBillingAddress(){
        firstnameBillingField.click();
        firstnameBillingField.sendKeys("Anna");
        lastnameBillingField.click();
        lastnameBillingField.sendKeys("Tester");
        streetBillingField.click();
        streetBillingField.sendKeys("251 S Olive St");
        cityBillingField.click();
        cityBillingField.sendKeys("Los Angeles");
        Select dropdown = new Select(getDriver().findElement(By.id("order-billing_address_region_id")));
        dropdown.selectByValue("12");
        zipcodeBillingField.click();
        zipcodeBillingField.sendKeys("90012");
        telephoneFieldBilling.click();
        telephoneFieldBilling.sendKeys("+1 213-617-3300");
    }

    public void saveAddressCheckbox(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(saveAdressCheckbox));
        saveAdressCheckbox.click();
    }






}
