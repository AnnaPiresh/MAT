package com.qamadness.steps.backend;

import com.qamadness.pages.backend.LogoutFromAdmin;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class LogoutFromAdminSteps extends ScenarioSteps {
    LogoutFromAdmin logoutFromAdmin;

    @Step
    public void logout_from_admin(){
        logoutFromAdmin.logoutfromAdmin();
    }
}
