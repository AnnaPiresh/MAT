package com.qamadness.steps.sales;


import com.qamadness.pages.sales.SwitchBetweenOrdersByArrows;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SwitchBetweenOrdersByArrowsSteps extends ScenarioSteps{
    SwitchBetweenOrdersByArrows switchBetweenOrdersByArrows;

    @Step
    public void switch_to_next_orders_page (String nextPage){
        switchBetweenOrdersByArrows.switchToNextOrdersPage(nextPage);
    }

    @Step
    public void switch_to_previous_orders_page(String previousPage){
        switchBetweenOrdersByArrows.switchToPreviousOrdersPage(previousPage);
    }
}
