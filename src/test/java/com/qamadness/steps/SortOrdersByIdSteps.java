package com.qamadness.steps;


import com.qamadness.pages.SortOrdersById;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SortOrdersByIdSteps extends ScenarioSteps{
    SortOrdersById sortOrdersById;

    @Step
    public void change_sort_order_by_id(){
        sortOrdersById.changeSortOrderById();
    }

    @Step
    public void check_that_sorting_changed(){
        sortOrdersById.checkThatSortingChanged();
    }

}
