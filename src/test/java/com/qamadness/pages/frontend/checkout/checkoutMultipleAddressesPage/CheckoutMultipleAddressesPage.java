package com.qamadness.pages.frontend.checkout.checkoutMultipleAddressesPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertFalse;
import java.util.List;

/**
 * Created by Anna Piresh on 27.01.2016.
 */
public class CheckoutMultipleAddressesPage extends PageObject{

//-------------------------------------Objects for Create Shipping Address step-----------------------------------------//

    @FindBy(xpath = ".//*[@id='firstname']")
    WebElementFacade firstNameField;

    @FindBy(xpath = ".//*[@id='lastname']")
    WebElementFacade lastNameField;

    @FindBy(xpath = ".//*[@id='company']")
    WebElementFacade companyField;

    @FindBy(xpath = ".//*[@id='telephone']")
    WebElementFacade telephoneField;

    @FindBy(xpath = ".//*[@id='fax']")
    WebElementFacade faxField;

    @FindBy(xpath = ".//*[@id='street_1']")
    WebElementFacade streetAddressField;

    @FindBy(xpath = ".//*[@id='street_2']")
    WebElementFacade streetAddress2Field;

    @FindBy(xpath = ".//*[@id='vat_id']")
    WebElementFacade vatField;

    @FindBy(xpath = ".//*[@id='city']")
    WebElementFacade cityField;

    @FindBy(xpath = ".//*[@id='region_id']")
    WebElementFacade stateRegionDropdown;

    @FindBy(xpath = ".//*[@id='zip']")
    WebElementFacade zipCodeField;

    @FindBy(xpath = ".//*[@id='country']")
    WebElementFacade countryDropdown;

    @FindBy(xpath = ".//button[@title='Save Address']")
    WebElementFacade saveAddressButton;

    @FindBy(xpath = ".//*[text()='Back']")
    WebElementFacade backLink;

    @FindBy(xpath = ".//*[@id='checkout-progress-state']")
    WebElementFacade checkoutProgressState;

    @FindBy(css = "div[id^='advice-required-']")
    WebElementFacade requiredFieldMessage;

//---------------------------------------Objects for Select Addresses step--------------------------------------------//

    @FindBy(xpath = ".//button[@title='Enter a New Address']")
    WebElementFacade enterNewAddressBtn;

    @FindBy(xpath = ".//button[@title='Continue to Shipping Information']")
    WebElementFacade continueToShippingInformationButton;

//--------------------------------------Objects for Select Shipping Method step----------------------------------------//

    @FindBy(xpath = ".//button[@title='Continue to Billing Information']")
    WebElementFacade continueToBillingInformationButton;

//---------------------------------------Objects for Select Billing Method step----------------------------------------//

    @FindBy(xpath = ".//input[@id='p_method_checkmo']")
    WebElementFacade checkMoneyOrderMethodRadioButton;

    @FindBy(xpath = ".//button[@id='payment-continue']")
    WebElementFacade continueToReviewStepButton;

//--------------------------------------------Objects for Review step--------------------------------------------------//

    @FindBy(xpath = ".//*[@id='review-button']")
    WebElementFacade placeOrderButton;

//---------------------------------------Methods for Create Shipping Address step--------------------------------------//

    public void enterFirstName(String firstName){firstNameField.sendKeys(firstName);}

    public void enterLastName(String lastName) {lastNameField.sendKeys(lastName);}

    public void enterCompanyName(String company) {companyField.sendKeys(company);}

    public void enterTelephone(String telephone) {telephoneField.sendKeys(telephone);}

    public void enterFax(String fax) {faxField.sendKeys(fax);}

    public void enterStreetAddress(String streetAddress) {streetAddressField.sendKeys(streetAddress);}

    public void enterStreetAddress2(String streetAddress2) {streetAddress2Field.sendKeys(streetAddress2);}

    public void enterVAT(String vat) {vatField.sendKeys(vat);}

    public void enterCity (String city) {cityField.sendKeys(city);}

    public void selectState(String state) {
        Select dropdown = new Select(stateRegionDropdown);
        dropdown.selectByVisibleText(state);
    }

    public void enterZipCode(String zipcode) {zipCodeField.sendKeys(zipcode);}

    public void selectCountry (String country){
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByVisibleText(country);
    }

    public void clickSaveAddressButton() {saveAddressButton.click();}

    public void clickBackLink() {backLink.click();}

    public Boolean checkIfUserHasADefaultAddress(){
        WebDriverWait wait = new WebDriverWait(getDriver(),60);
        wait.until(ExpectedConditions.visibilityOf(checkoutProgressState));
        if (firstNameField.isPresent()){
            System.out.println("User has no saved shipping addresses");
            return false;
        } else{
           System.out.println("User has a saved shipping address");
            return true;
        }
    }

    public void checkRequiredFieldMessage(){
        if (zipCodeField.getText().isEmpty()){
            Assert.assertTrue(requiredFieldMessage.isDisplayed());
            System.out.println("Message that required field is not filled in is displayed");
        }else{
            System.out.println("Oh, no! Product can be saved");
        }
    }

//---------------------------------------Methods for Select Addresses step--------------------------------------------//

    public void clickEnterNewAddressButton(){
        enterNewAddressBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(backLink));
    }

    public void selectAnAddressFromDropdown(String productName, String fullCustomerAddress){
        String xpath = String.format(".//tr[.//a='%s']//select", productName);
        Select select = new Select(getDriver().findElement(By.xpath(xpath)));
        select.selectByVisibleText(fullCustomerAddress);
    }

    public void clickContinueToShippingInformationButton(){ continueToShippingInformationButton.click();}

    public void checkNoDropdownForProduct(String productName){
        String xpath = String.format(".//tr[.//a='%s']//td[contains(text(),'Shipping selection is not applicable.')]", productName);
        WebElement cellWithMessage = getDriver().findElement(By.xpath(xpath));
        Assert.assertTrue(cellWithMessage.isDisplayed());
}

//------------------------------------Methods for Selecting Shipping Method step---------------------------------------//

    public List<WebElement> li() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(continueToBillingInformationButton));
        return getDriver().findElements(By.cssSelector(".sp-methods>dd>ul>li>label"));}

    public void selectShippingMethods(int firstMethod, int secondMethod){
        li().get(firstMethod).click();
        li().get(secondMethod).click();
    }

    public void selectParticularShippingMethod(String methodTitle, String methodName){
        String xpath1stPart = String.format(".//dt[text()='%s']", methodTitle);
        String xpath2ndPart = String.format("/following-sibling::*[contains(.//label,'%s')]//input", methodName);
        System.out.println(xpath1stPart+xpath2ndPart);
        String fullXpath = xpath1stPart+xpath2ndPart;
        WebElement selectedMethod = getDriver().findElement(By.xpath(fullXpath));
        selectedMethod.click();
    }

     public void clickContinueToBillingInformationButton(){ continueToBillingInformationButton.click();}

//----------------------------------Methods for Selecting Billing Method step------------------------------------------//

    public void selectPaymentMethod(){checkMoneyOrderMethodRadioButton.click();}

    public void clickContinueToReviewYourOrderButton(){continueToReviewStepButton.click();}

//------------------------------------------Methods for Review step----------------------------------------------------//

    public void clickPlaceOrderButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();
    }
}
