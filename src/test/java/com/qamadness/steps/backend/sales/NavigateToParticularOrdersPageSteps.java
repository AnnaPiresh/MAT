package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.NavigateToParticularOrdersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NavigateToParticularOrdersPageSteps extends ScenarioSteps{
    NavigateToParticularOrdersPage navigateToParticularOrdersPage;

    @Step
    public void enter_orders_page(String ordersPage){
        navigateToParticularOrdersPage.enterOrdersPage(ordersPage);
    }

    @Step
    public void check_the_page_is_correct(String ordersPage){
        navigateToParticularOrdersPage.checkThePageIsCorrect(ordersPage);
    }

}
