package com.qamadness.steps.backend.sales;


import com.qamadness.pages.backend.sales.ReorderFromAdmin;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ReorderFromAdminSteps extends ScenarioSteps{
    ReorderFromAdmin reorderFromAdmin;

    @Step
    public void click_reorder_btn(){
        reorderFromAdmin.clickReorderBtn();
    }

    @Step
    public void check_correct_product_reordered(){
        reorderFromAdmin.checkCorrectProductReordered();
    }

    @Step
    public void check_shipment_method_is_selected(){
        reorderFromAdmin.checkShipmentMethodSelected();
    }

    @Step
    public void check_payment_method_is_selected(){
        reorderFromAdmin.checkPaymentMethodSelected();
    }
}
