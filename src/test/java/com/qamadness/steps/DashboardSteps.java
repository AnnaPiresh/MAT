package com.qamadness.steps;

import com.qamadness.pages.DashboardTest;
import net.thucydides.core.annotations.Step;

/**
 * Created by Maksim on 14-Dec-15.
 */
public class DashboardSteps {

    DashboardTest dashboard;

    @Step
    public void closePopup(){dashboard.closePopup();}
}
