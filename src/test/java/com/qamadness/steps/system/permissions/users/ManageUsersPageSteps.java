package com.qamadness.steps.system.permissions.users;

import com.qamadness.pages.system.permissions.users.ManageUsersPage;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/14/16.
 */
public class ManageUsersPageSteps extends ScenarioSteps {

    ManageUsersPage manageUsersPage;

    //Buttons:

    public void click_Add_New_User_Button (){
        manageUsersPage.clickAddNewUserButton();
    }
}
