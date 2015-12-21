package com.qamadness.steps;

import com.qamadness.pages.SortingAndFilteringOfOrders;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class SortingAndFilteringOfOrdersSteps extends ScenarioSteps {
    SortingAndFilteringOfOrders sortingAndFilteringOfOrders;

    @Step
    public void can_user_change_qty_of_orders(){
        sortingAndFilteringOfOrders.canUserChangeQtyOfOrders();
    }

    @Step
    public void check_new_qty_of_orders(){
        sortingAndFilteringOfOrders.checkNewQtyOfOrders();
    }
}
