package com.qamadness.steps.backendSteps.customersSteps;


import com.qamadness.pages.backend.customers.AddNewCustomerGroup;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AddNewCustomerGroupSteps extends ScenarioSteps{
    AddNewCustomerGroup addNewCustomerGroup;

    @Step
    public void click_add_customer_group_btn() {addNewCustomerGroup.clickAddCustomerGroupBtn();}

    @Step
    public void enter_group_code(String groupcode) {addNewCustomerGroup.enterGroupCode(groupcode);}

    @Step
    public void select_tax_class (String taxvalue) {addNewCustomerGroup.selectTaxClass(taxvalue);}

    @Step
    public void click_save_customer_group_btn() {addNewCustomerGroup.clickSaveCustomerGroupBtn();}

    @Step
    public void check_success_msg(String successMText) {addNewCustomerGroup.checkSuccessMsg(successMText);}

    @Step
    public void find_created_group(String groupcode) { addNewCustomerGroup.findCreatedGroup(groupcode);}

    @Step
    public void delete_created_group(String confirmDelete) {addNewCustomerGroup.deleteCreatedGroup(confirmDelete);}

}
