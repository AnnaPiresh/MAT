package com.qamadness.steps.sales;

import com.qamadness.pages.sales.ManageSingleOrder;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class ManageSingleOrderSteps extends ScenarioSteps{

    ManageSingleOrder manageSingleOrder;

    @Step
    public void create_an_invoice_for_order(){
        manageSingleOrder.createAnInvoiceForOrder();
    }

    @Step
    public void start_creating_credit_memo(){
        manageSingleOrder.startCreatingCreditMemo();
    }

    @Step
    public void submit_credit_memo(){
        manageSingleOrder.submitCreditMemo();
    }

    @Step
    public void remove_refund_for_shipment(){
        manageSingleOrder.removeRefundForShipment();
    }

    @Step
    public void check_more_credit_memos_can_be_created(){ manageSingleOrder.checkMoreCreditMemosCanBeCreated();}

    @Step
    public void create_shipment_for_order(){
        manageSingleOrder.createShipmentForOrder();
    }

    @Step
    public void click_reorder_btn(){
        manageSingleOrder.clickReorderBtn();
    }

    @Step
    public void check_correct_product_reordered(){
        manageSingleOrder.checkCorrectProductReordered();
    }

    @Step
    public void check_shipment_method_is_selected(){
        manageSingleOrder.checkShipmentMethodSelected();
    }

    @Step
    public void check_payment_method_is_selected(){
        manageSingleOrder.checkPaymentMethodSelected();
    }

    @Step
    public void click_send_email_bth(){
        manageSingleOrder.clickSendEmailBtn();
    }

    @Step
    public void check_success_message(String message) {manageSingleOrder.checkSuccessMsg(message);}
}
