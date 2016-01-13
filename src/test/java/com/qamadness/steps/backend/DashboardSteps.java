package com.qamadness.steps.backend;

import com.qamadness.pages.backend.DashboardPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class DashboardSteps {

    DashboardPage dashboard;

    @Step
    public void closePopup(){dashboard.closePopup();}
}
