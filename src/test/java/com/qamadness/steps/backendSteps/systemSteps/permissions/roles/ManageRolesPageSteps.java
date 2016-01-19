package com.qamadness.steps.backendSteps.systemSteps.permissions.roles;

import com.qamadness.pages.backend.system.permissions.roles.ManageRolesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/19/16.
 */
public class ManageRolesPageSteps extends ScenarioSteps {

    ManageRolesPage manageRolesPage;

    //Click buttons steps:

    @Step
    public void click_Add_New_Role_Button (){
        manageRolesPage.clickAddNewRoleButton();
    }

    //Verifications:

    @Step
    public void verify_That_Role_Is_Created (String roleName){
        manageRolesPage.verifyThatRoleIsCreated(roleName);
    }

    //Grid methods:

    @Step
    public void find_Role_And_Open(String roleName){
        manageRolesPage.findRoleAndOpen(roleName);
    }
}
