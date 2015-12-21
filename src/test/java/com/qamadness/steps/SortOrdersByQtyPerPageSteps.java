package com.qamadness.steps;

import com.qamadness.pages.SortOrdersByQtyPerPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class SortOrdersByQtyPerPageSteps extends ScenarioSteps {
    SortOrdersByQtyPerPage sortOrdersByQtyPerPage;

    @Step
    public void can_user_change_qty_of_orders(){
        sortOrdersByQtyPerPage.canUserChangeQtyOfOrders();
    }

    @Step
    public void check_new_qty_of_orders(){
        sortOrdersByQtyPerPage.checkNewQtyOfOrders();
    }
}
