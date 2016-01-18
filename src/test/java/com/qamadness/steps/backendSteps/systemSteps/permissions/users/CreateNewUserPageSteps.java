package com.qamadness.steps.backendSteps.systemSteps.permissions.users;

import com.qamadness.pages.backend.system.permissions.users.CreateNewUserPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/14/16.
 */
public class CreateNewUserPageSteps extends ScenarioSteps {

    CreateNewUserPage createNewUserPage;

    //Verification methods:

    @Step
    public void verify_That_Back_Button_Is_Present (){
        createNewUserPage.verifyThatBackButtonIsPresent();
    }

    @Step
    public void verify_That_Save_User_Button_Is_Present (){
        createNewUserPage.verifyThatSaveUserButtonIsPresent();
    }

    @Step
    public void verify_That_Reset_Button_Is_Present (){
        createNewUserPage.verifyThatResetButtonIsPresent();
    }

    //Fill fields on User Info tab methods:

    @Step
    public void fill_User_Name_Field (String userName){
        createNewUserPage.fillUserNameField(userName);
    }

    @Step
    public void fill_First_Name_Field (String firstName){
        createNewUserPage.fillFirstNameField(firstName);
    }

    @Step
    public void fill_Last_Name_Field (String lastName){
        createNewUserPage.fillLastNameField(lastName);
    }

    @Step
    public void fill_Email_Field (String email){
        createNewUserPage.fillEmailField(email);
    }

    @Step
    public void fill_Current_Admin_Password_Field (String currentPass){
        createNewUserPage.fillCurrentAdminPasswordField(currentPass);
    }

    @Step
    public void fill_Password_Field (String password){
        createNewUserPage.fillPasswordField(password);
    }

    @Step
    public void fill_Password_Confirmation_Field (String passConfirmation){
        createNewUserPage.fillPasswordConfirmationField(passConfirmation);
    }

    @Step
    public void select_Is_Account_Active (String status){
        createNewUserPage.selectIsAccountActive(status);
    }

    //Click general buttons methods:

    @Step
    public void click_Save_User_Button (){
        createNewUserPage.clickSaveUserButton();
    }

    @Step
    public void click_Back_Button (){
        createNewUserPage.clickBackButton();
    }

    @Step
    public void click_Delete_Button_And_Confirm (){
        createNewUserPage.clickDeleteButtonAndConfirm();
    }
}
