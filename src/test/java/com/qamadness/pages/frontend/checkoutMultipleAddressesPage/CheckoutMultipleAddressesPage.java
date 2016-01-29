package com.qamadness.pages.frontend.checkoutMultipleAddressesPage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Anna Piresh on 27.01.2016.
 */
public class CheckoutMultipleAddressesPage extends PageObject{

//-------------------------------------Objects for Create Shipping Address Tab-----------------------------------------//

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

//----------------------------------------Methods for Create Shipping Address Tab-------------------------------------//

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
        dropdown.selectByValue(state);
    }

    public void enterZipCode(String zipcode) {zipCodeField.sendKeys(zipcode);}

    public void selectCountry (String country){
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue(country);
    }

    public void clickSaveAddressButton() {saveAddressButton.click();}

    public void clickBackLink() {backLink.click();}

}
