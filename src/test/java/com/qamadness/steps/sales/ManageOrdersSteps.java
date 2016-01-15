package com.qamadness.steps.sales;

import com.qamadness.pages.sales.ManageOrders;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 14.01.2016.
 */
public class ManageOrdersSteps extends ScenarioSteps {

    ManageOrders manageOrders;

    @Step
    public void see_orders_in_pending_status(String status){ manageOrders.seeOrdersInPendingStatus(status); }

    @Step
    public void cancel_selected_order(String action){
        manageOrders.cancelSelectedOrder(action);
    }

    @Step
    public void filter_orders_in_grid(String orderId){
        manageOrders.filterOrdersInGrid(orderId);
    }

    @Step
    public void check_filtered_order_number(String orderId){
        manageOrders.checkFilteredOrderNo(orderId);
    }

    @Step
    public void enter_orders_page(String ordersPage){
        manageOrders.enterOrdersPage(ordersPage);
    }

    @Step
    public void check_the_page_is_correct(String ordersPage){ manageOrders.checkThePageIsCorrect(ordersPage); }

    @Step
    public void change_sort_order_by_id(){
        manageOrders.changeSortOrderById();
    }

    @Step
    public void check_that_sorting_changed(){
        manageOrders.checkThatSortingChanged();
    }

    @Step
    public void can_user_change_qty_of_orders(String value){
        manageOrders.canUserChangeQtyOfOrders(value);
    }

    @Step
    public void check_new_qty_of_orders(){
        manageOrders.checkNewQtyOfOrders();
    }

    @Step
    public void unselect_orders(){manageOrders.unselectOrders();}

    @Step
    public void switch_to_next_orders_page (int nextPage){
        manageOrders.switchToNextOrdersPage(nextPage);
    }

    @Step
    public void switch_to_previous_orders_page(int previousPage){ manageOrders.switchToPreviousOrdersPage(previousPage); }

    @Step
    public void check_success_message(String message) {manageOrders.checkSuccessMsg(message);}

    @Step
    public void reset_filter() { manageOrders.resetFilter(); }

}
