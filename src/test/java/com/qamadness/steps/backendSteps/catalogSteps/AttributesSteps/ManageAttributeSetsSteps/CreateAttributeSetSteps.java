package com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributeSetsSteps;

import com.qamadness.pages.backend.catalog.Attributes.ManageAttributeSets.CreateAttributeSetPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 18.01.2016.
 */
public class CreateAttributeSetSteps extends ScenarioSteps {

    CreateAttributeSetPage createAttributeSetPage;

    @Step
    public void click_add_new_attribute_set_button() {createAttributeSetPage.clickAddNewAttributeSetBtn();}

    @Step
    public void enter_attribute_set_name(String setName) {createAttributeSetPage.enterAttributeSetName(setName);}

    @Step
    public void save_attribute_set(){createAttributeSetPage.saveAttributeSet();}

    @Step
    public void check_success_message(String successMessage){createAttributeSetPage.checkSuccessMsg(successMessage);}

    @Step
    public void check_error_message(String errorMessage) {createAttributeSetPage.checkErrorMsg(errorMessage);}

    @Step
    public void check_required_field_message(String requiredMessage) {
        createAttributeSetPage.checkRequiredFieldMsg(requiredMessage);}

    @Step
    public void add_new_attribute_group(String groupTitle) {createAttributeSetPage.addNewAttributeGroup(groupTitle);}

    @Step
    public void scroll_down_to_created_attribute_group(){
        createAttributeSetPage.scrollDownToCreatedAttributeGroup();}

    @Step
    public void drag_and_drop_unassigned_attribute(){
        createAttributeSetPage.dragAndDropUnassignedAttribute();
    }

    @Step
    public void select_based_on_value(String basedOnValue) {createAttributeSetPage.selectBasedOnValue(basedOnValue);}

    @Step
    public void click_delete_attribute_set_button(){createAttributeSetPage.clickDeleteAttributeSetButton(); }

    @Step
    public void check_delete_button_is_not_present() {createAttributeSetPage.checkDeleteButtonIsNotPresent();}

}
