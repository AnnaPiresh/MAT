package com.qamadness.steps.customers;

import com.qamadness.pages.customers.CustomerInformationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.awt.*;

/**
 * Created by alexandrakorniichuk on 15.12.15.
 */
public class CustomerInformationSteps extends ScenarioSteps {

    CustomerInformationPage customerInformationPage;

    @Step
    public void open_Account_Information_Tab (){
        customerInformationPage.openAccountInformationTab();
    }

    @Step
    public void check_That_Saved_Associate_To_Website_Option_Is_Correct (String siteOption){
        customerInformationPage.checkThatSavedAssociateToWebsiteOptionIsCorrect(siteOption);
    }

    @Step
    public void check_That_Group_Selected_Option_Is_Saved_Correctly (String groupOption){
        customerInformationPage.checkThatGroupSelectedOptionIsSavedCorrectly(groupOption);
    }

    @Step
    public void check_That_Prefix_Is_Saved_Correctly (String prefix){
        customerInformationPage.checkThatPrefixIsSavedCorrectly(prefix);
    }

    @Step
    public void check_That_First_Name_Is_Saved_Correctly (String firstName){
        customerInformationPage.checkThatFirstNameIsSavedCorrectly(firstName);
    }

    @Step
    public void check_That_Middle_Name_Is_Saved_Correctly (String middleName){
        customerInformationPage.checkThatMiddleNameIsSavedCorrectly(middleName);
    }

    @Step
    public void check_That_Last_Name_Is_Saved_Correctly (String lastName){
        customerInformationPage.checkThatLastNameIsSavedCorrectly(lastName);
    }

    @Step
    public void check_That_Suffix_Is_Saved_Correctly (String suffix){
        customerInformationPage.checkThatSuffixIsSavedCorrectly(suffix);
    }

    @Step
    public void check_That_Email_Is_Saved_Correctly (String email){
        customerInformationPage.checkThatEmailIsSavedCorrectly(email);
    }

    @Step
    public void check_That_Date_Of_Birth_Is_Saved_Correctly (String dob){
        customerInformationPage.checkThatDateOfBirthIsSavedCorrectly(dob);
    }

    @Step
    public void check_That_Tax_Number_Is_Saved_Correctly (String tax){
        customerInformationPage.checkThatTaxNumberIsSavedCorrectly(tax);
    }

    @Step
    public void check_That_Gender_Is_Saved_Correctly (String gender){
        customerInformationPage.checkThatGenderIsSavedCorrectly(gender);
    }

    @Step
    public void click_Delete_Customer_Button () throws AWTException {
        customerInformationPage.clickDeleteCustomerBtn();
    }


}
