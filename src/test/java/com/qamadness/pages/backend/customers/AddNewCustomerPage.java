package com.qamadness.pages.backend.customers;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


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

}
