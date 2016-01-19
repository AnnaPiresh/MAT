package com.qamadness.steps.backendSteps.systemSteps.permissions.users;

import com.qamadness.pages.backend.system.permissions.users.ManageUsersPage;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


/**
 * Created by Alexandra on 1/14/16.
 */
public class ManageUsersPageSteps extends ScenarioSteps {

    ManageUsersPage manageUsersPage;

    //Click general buttons methods:

    @Step
    public void click_Add_New_User_Button (){
        manageUsersPage.clickAddNewUserButton();
    }

    @Step
    public void click_Reset_Filter_Button (){
        manageUsersPage.clickResetFilterButton();
    }

    //Methods for search in Users grid:

    @Step
    public void find_User_By_Email_And_Open (String email){
        manageUsersPage.findUserAndOpen(email);
    }

    //Verification methods:

    @Step
    public void check_That_Success_Saved_User_Message_Is_Displayed (){
        manageUsersPage.checkThatSuccessSavedUserMessageIsDisplayed();
    }

    @Step
    public void check_That_Exist_Email_Or_Name_Error_Is_Displayed (){
        manageUsersPage.checkThatExistEmailOrNameErrorIsDisplayed();
    }

    @Step
    public void check_By_Email_That_User_Is_Not_Created (String email){
        manageUsersPage.checkByEmailThatUserIsNotCreated(email);
    }

    @Step
    public void check_By_User_Name_That_User_Is_Not_Created (String name){
        manageUsersPage.checkByUserNameThatUserIsNotCreated(name);
    }

    @Step
    public void check_That_User_Is_Created (String email){
        manageUsersPage.checkThatUserIsCreated(email);
    }
}
