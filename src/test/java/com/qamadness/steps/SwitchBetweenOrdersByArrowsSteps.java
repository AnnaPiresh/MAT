package com.qamadness.steps;


import com.qamadness.pages.SwitchBetweenOrdersByArrows;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SwitchBetweenOrdersByArrowsSteps extends ScenarioSteps{
    SwitchBetweenOrdersByArrows switchBetweenOrdersByArrows;

    @Step
    public void switch_to_next_orders_page (){
        switchBetweenOrdersByArrows.switchToNextOrdersPage();
    }

    @Step
    public void switch_to_previous_orders_page(){
        switchBetweenOrdersByArrows.switchToPreviousOrdersPage();
    }
}
