package com.qamadness.steps.backendSteps.systemSteps.permissions.roles;

import com.qamadness.pages.backend.system.permissions.roles.NewRolePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/19/16.
 */
public class NewRolePageSteps extends ScenarioSteps {

    NewRolePage newRolePage;

    //Methods for Role Info tabs:

    @Step
    public void fill_Role_Name_Field (String roleName){
        newRolePage.fillRoleNameField(roleName);
    }

    @Step
    public void fill_Current_Admin_Password_Field (String password){
        newRolePage.fillCurrentAdminPasswordField(password);
    }

    //Methods for Role Resources tab:

    @Step
    public void open_Role_Resources_Tab(){
        newRolePage.openRoleResourcesTab();
    }

    @Step
    public void select_All_Resources_Access (){
        newRolePage.selectAllResourcesAccess();
    }

    //Methods for general buttons:

    @Step
    public void click_Save_Button (){
        newRolePage.clickSaveButton();
    }

    @Step
    public void click_Delete_Role_Button_And_Confirm (){
        newRolePage.clickDeleteRoleButtonAndConfirm();
    }
}
