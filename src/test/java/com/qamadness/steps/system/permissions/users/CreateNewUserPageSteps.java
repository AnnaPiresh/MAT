package com.qamadness.steps.system.permissions.users;

import com.qamadness.pages.system.permissions.users.CreateNewUserPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/14/16.
 */
public class CreateNewUserPageSteps extends ScenarioSteps {

    CreateNewUserPage createNewUserPage;

    //General verifications:

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
}
