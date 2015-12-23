package com.qamadness.steps.sales;


import com.qamadness.pages.sales.FilterOrdersById;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FilterOrdersByIdSteps extends ScenarioSteps{
    FilterOrdersById filterOrdersById;

    @Step
    public void filter_orders_in_grid(){
        filterOrdersById.filterOrdersInGrid();
    }

    @Step
    public void check_filtered_order_number(){
        filterOrdersById.checkFilteredOrderNo();
    }

}
