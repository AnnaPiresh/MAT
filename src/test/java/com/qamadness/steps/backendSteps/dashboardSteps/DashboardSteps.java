package com.qamadness.steps.backendSteps.dashboardSteps;

import com.qamadness.pages.backend.dashboard.DashboardPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class DashboardSteps {

    DashboardPage dashboard;

    @Step
    public void closePopup(){dashboard.closePopup();}

    //Verifications:

    @Step
    public void verify_That_Current_Page_Is_Dashboard (){
        dashboard.verifyThatCurrentPageIsDashboard();
    }
}
