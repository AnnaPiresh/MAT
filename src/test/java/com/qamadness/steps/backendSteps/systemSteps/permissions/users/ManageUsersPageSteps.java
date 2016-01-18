package com.qamadness.steps.backendSteps.systemSteps.permissions.users;

import com.qamadness.pages.system.permissions.users.ManageUsersPage;


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

    //Methods for search in Users grid:

    @Step
    public void search_By_User_Email (String email){
        manageUsersPage.searchByUserEmail(email);
    }

    //Verification methods:

    @Step
    public void check_That_Success_Saved_User_Message_Is_Displayed (){
        manageUsersPage.checkThatSuccessSavedUserMessageIsDisplayed();
    }
}
