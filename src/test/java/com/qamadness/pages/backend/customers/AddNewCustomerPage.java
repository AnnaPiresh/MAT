package com.qamadness.pages.backend.customers;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class AddNewCustomerPage extends PageObject {

    @FindBy (xpath = ".//select[@id='_accountwebsite_id']")
    WebElementFacade associateToWebsiteDropDown;

    @FindBy (xpath = ".//select[@id='_accountgroup_id']")
    WebElementFacade groupDropDown;

    @FindBy (xpath = ".//*[@id='_accountprefix']")
    WebElementFacade prefixField;

    @FindBy (xpath = ".//*[@id='_accountfirstname']")
    WebElementFacade firstNameField;

    @FindBy (xpath = ".//*[@id='_accountmiddlename']")
    WebElementFacade middleNameField;

    @FindBy (xpath = ".//*[@id='_accountlastname']")
    WebElementFacade lastNameField;

    @FindBy (xpath = ".//*[@id='_accountsuffix']")
    WebElementFacade suffixField;

    @FindBy (xpath = ".//*[@id='_accountemail']")
    WebElementFacade emailField;

    @FindBy (xpath = ".//*[@id='_accountdob']")
    WebElementFacade dobField;

    @FindBy (xpath = ".//*[@id='_accounttaxvat']")
    WebElementFacade taxNumberField;

    @FindBy (xpath = ".//*[@id='_accountgender']")
    WebElementFacade genderDropDown;

    @FindBy (xpath = ".//*[@id='_accountpassword']")
    WebElementFacade passwordField;

    @FindBy (xpath = ".//button[@title='Save Customer']")
    WebElementFacade saveCustomerBtn;

    @FindBy(css = "#customer_info_tabs_addresses>span")
    WebElementFacade customerAddressTab;

    @FindBy(css = "#add_address_button")
    WebElementFacade addNewAddressBtn;

    @FindBy(css = "#address_item_billing_item1")
    WebElementFacade defaultBillingRadioButton;

    @FindBy(css = "#address_item_shipping_item1")
    WebElementFacade defaultShippingRadioButton;

    @FindBy(css = "#_item1firstname")
    WebElementFacade firstNameAddressField;

    @FindBy(css = "#_item1lastname")
    WebElementFacade lastNameAddressField;

    @FindBy(css = "#_item1street0")
    WebElementFacade streetAddressField;

    @FindBy(css = "#_item1city")
    WebElementFacade cityField;

    @FindBy(css = "#_item1country_id")
    WebElementFacade countryDropdown;

    @FindBy(css = "#_item1region_id")
    WebElementFacade stateDropdown;

    @FindBy(css = "#_item1postcode")
    WebElementFacade zipcodeField;

    @FindBy(css = "#_item1telephone")
    WebElementFacade telephoneField;


    public void selectAssociateToWebsiteOption (String option){
        associateToWebsiteDropDown.selectByVisibleText(option);
    }

    public void selectGroup (String value){
        groupDropDown.selectByVisibleText(value);
    }

    public void enterPrefix (String prefix){
        prefixField.type(prefix);
    }

    public void enterFirstName (String firstName){
        firstNameField.type(firstName);
    }

    public void enterMiddleName (String middleName){
        middleNameField.type(middleName);
    }

    public void enterLastName (String lastName){
        lastNameField.type(lastName);
    }

    public void enterSuffix (String suffix){
        suffixField.type(suffix);
    }

    public void enterEmail (String email){
        emailField.type(email);
    }

    public void enterDateOfBirth (String dob){
        dobField.type(dob);
    }

    public void enterTaxNumber (String taxNumber){
        taxNumberField.type(taxNumber);
    }

    public void selectGender (String value){
        genderDropDown.selectByVisibleText(value);
    }

    public void enterPassword (String password){
        passwordField.type(password);
    }

    public void clickSaveCustomerButton (){
        saveCustomerBtn.click();
    }

    public void switchToAddressesTab(){customerAddressTab.click();}

    public void clickAddNewAddressButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(addNewAddressBtn));
        addNewAddressBtn.click();
    }

    public void selectBillingAddressAsDefault(){defaultBillingRadioButton.click();}

    public void selectShippingAddressAsDefault(){defaultShippingRadioButton.click();}

    public void enterFirstNameAddress(String firstName) {firstNameAddressField.sendKeys(firstName);}

    public void enterLastNameAddress(String lastName) {lastNameAddressField.sendKeys(lastName);}

    public void enterStreetAddress(String street){streetAddressField.sendKeys(street);}

    public void enterCityAddress(String city) {cityField.sendKeys(city);}

    public void selectCountry(String country) {
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue(country);
    }

    public void selectState (String region){
        Select dropdown = new Select(stateDropdown);
        dropdown.selectByValue(region);
    }

    public void enterZipcode( String zipcode){ zipcodeField.sendKeys(zipcode); }

    public void enterTelephone(String telephone) {telephoneField.sendKeys(telephone);}
}
