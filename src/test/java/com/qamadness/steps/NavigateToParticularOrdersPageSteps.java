package com.qamadness.steps;


import com.qamadness.pages.NavigateToParticularOrdersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NavigateToParticularOrdersPageSteps extends ScenarioSteps{
    NavigateToParticularOrdersPage navigateToParticularOrdersPage;

    @Step
    public void enter_orders_page(){
        navigateToParticularOrdersPage.enterOrdersPage();
    }

    @Step
    public void check_the_page_is_correct(){
        navigateToParticularOrdersPage.checkThePageIsCorrect();
    }

}
