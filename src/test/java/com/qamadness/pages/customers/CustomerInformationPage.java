package com.qamadness.pages.customers;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.awt.*;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class CustomerInformationPage extends PageObject {

    @FindBy (xpath = ".//*[@id='customer_info_tabs_account']")
    WebElementFacade accountInfoTab;

    @FindBy (xpath = ".//*[@id='_accountwebsite_id']/option[@selected='selected']")
    WebElementFacade associateToWebsiteSelectedOption;

    @FindBy (xpath = ".//*[@id='_accountgroup_id']/option[@selected='selected']")
    WebElementFacade groupSelectedOption;

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

    @FindBy (xpath = ".//*[@id='_accountgender']/option[@selected='selected']")
    WebElementFacade genderSelectedOption;

    @FindBy (xpath = ".//button[@title='Delete Customer']")
    WebElementFacade deleteCustomerBtn;

    public void openAccountInformationTab (){
        accountInfoTab.click();
    }

    public void checkThatSavedAssociateToWebsiteOptionIsCorrect (String siteOption){
        Assert.assertTrue("Associate to website value is saved correctly", associateToWebsiteSelectedOption.getText().equalsIgnoreCase(siteOption));
    }

    public void checkThatGroupSelectedOptionIsSavedCorrectly (String groupOption){
        Assert.assertTrue("Group option is saved correctly", groupSelectedOption.getText().equalsIgnoreCase(groupOption));
    }

    public void checkThatPrefixIsSavedCorrectly (String prefix){
        Assert.assertTrue("Prefix is saved correctly", prefixField.getValue().equalsIgnoreCase(prefix));
    }

    public void checkThatFirstNameIsSavedCorrectly (String firstName){
        Assert.assertTrue("First name is saved correctly", firstNameField.getValue().equalsIgnoreCase(firstName));
    }

    public void checkThatMiddleNameIsSavedCorrectly (String middleName){
        Assert.assertTrue("Middle name is saved correctly", middleNameField.getValue().equalsIgnoreCase(middleName));
    }

    public void checkThatLastNameIsSavedCorrectly (String lastName){
        Assert.assertTrue("Last name is saved correctly", lastNameField.getValue().equalsIgnoreCase(lastName));
    }

    public void checkThatSuffixIsSavedCorrectly (String suffix){
        Assert.assertTrue("Suffix is saved correctly", suffixField.getValue().equalsIgnoreCase(suffix));
    }

    public void checkThatEmailIsSavedCorrectly (String email){
        Assert.assertTrue("Email is saved correctly", emailField.getValue().equalsIgnoreCase(email));
    }

    public void checkThatDateOfBirthIsSavedCorrectly (String dob){
        Assert.assertTrue("Date of birth is saved correctly", dobField.getValue().equalsIgnoreCase(dob));
    }

    public void checkThatTaxNumberIsSavedCorrectly (String tax){
        Assert.assertTrue("Tax number is saved correctly", taxNumberField.getValue().equalsIgnoreCase(tax));
    }

    public void checkThatGenderIsSavedCorrectly (String gender){
        Assert.assertTrue("Gender is saved correctly", genderSelectedOption.getText().equalsIgnoreCase(gender));
    }

    public void clickDeleteCustomerBtn () throws AWTException {
        deleteCustomerBtn.click();
        getDriver().switchTo().alert();
        getAlert().accept();
    }
}
