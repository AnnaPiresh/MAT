package com.qamadness.steps.backendSteps.customersSteps;

import com.qamadness.pages.backend.customers.AddNewCustomerPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class AddNewCustomerSteps extends ScenarioSteps {

    AddNewCustomerPage addNewCustomerPage;


    @Step
    public void select_Associate_To_Website_Option (String option){
        addNewCustomerPage.selectAssociateToWebsiteOption(option);
    }

    @Step
    public void select_Group (String value){
        addNewCustomerPage.selectGroup(value);
    }

    @Step
    public void enter_Prefix (String prefix){
        addNewCustomerPage.enterPrefix(prefix);
    }

    @Step
    public void enter_First_Name (String firstName){
        addNewCustomerPage.enterFirstName(firstName);
    }

    @Step
    public void enter_Middle_Name (String middleName){
        addNewCustomerPage.enterMiddleName(middleName);
    }

    @Step
    public void enter_Last_Name (String lastName){
        addNewCustomerPage.enterLastName(lastName);
    }

    @Step
    public void enter_Suffix (String suffix){
        addNewCustomerPage.enterSuffix(suffix);
    }

    @Step
    public void enter_Email (String email){
        addNewCustomerPage.enterEmail(email);
    }

    @Step
    public void enter_Date_Of_Birth (String dob){
        addNewCustomerPage.enterDateOfBirth(dob);
    }

    @Step
    public void enter_Tax_Number (String taxNumber){
        addNewCustomerPage.enterTaxNumber(taxNumber);
    }

    @Step
    public void select_Gender (String value){
        addNewCustomerPage.selectGender(value);
    }

    @Step
    public void enter_Password (String password){
        addNewCustomerPage.enterPassword(password);
    }

    @Step
    public void click_Save_Customer_Button (){
        addNewCustomerPage.clickSaveCustomerButton();
    }
}
