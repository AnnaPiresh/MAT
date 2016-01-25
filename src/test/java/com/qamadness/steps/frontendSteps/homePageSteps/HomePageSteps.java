package com.qamadness.steps.frontendSteps.homePageSteps;

import com.qamadness.pages.frontend.homePage.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class HomePageSteps extends ScenarioSteps {

    HomePage homePage;

    @Step
    public void open_Home_Page (){
        homePage.openHomePage();
    }
}
