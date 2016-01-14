package com.qamadness.steps.frontend;


import com.qamadness.pages.frontend.Homepage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomepageSteps extends ScenarioSteps{

    Homepage homepage;

    @Step
    public void open_website(){
        homepage.open();}

    @Step
    public void open_product_overview_page(){homepage.openProductOverviewPage();}
}
