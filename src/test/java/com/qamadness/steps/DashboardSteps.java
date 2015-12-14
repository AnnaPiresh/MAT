package com.qamadness.steps;

import com.qamadness.pages.Dashboard;
import net.thucydides.core.annotations.Step;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class DashboardSteps {

    Dashboard dashboard;

    @Step
    public void closePopup(){dashboard.closePopup();}
}
