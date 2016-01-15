package com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributesSteps;


import com.qamadness.pages.backend.catalog.Attributes.ManageAttributes.CreateAttributePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AddAnAttributeSteps extends ScenarioSteps{
    CreateAttributePage createAttributePage;

    @Step
    public void click_add_new_attribute_btn(){ createAttributePage.clickAddNewAttributeBtn(); }

    @Step
    public void add_attribute_code(String attrCode){ createAttributePage.addAttrCode(attrCode); }

    @Step
    public void select_scope(String scope){ createAttributePage.selectScope(scope); }

    @Step
    public void select_input_type(String inptype){ createAttributePage.selectInputType(inptype); }

    @Step
    public void select_apply_to(String products){ createAttributePage.selectApplyTo(products); }

    @Step
    public void select_product_types_to_apply(String type){ createAttributePage.selectProductTypesToApply(type);}

    @Step
    public void switch_to_options_tab(){ createAttributePage.switchToOptionsTab(); }

    @Step
    public void add_admin_value_in_manage_titles(String title){ createAttributePage.addAdminValueInManageTitles(title); }

    @Step
    public void add_options_to_dropdown(){ createAttributePage.addOptionsToDropdown(); }

    @Step
    public void add_first_dropdown_option(String fOption){ createAttributePage.addFirstDropdownOption(fOption); }

    @Step
    public void add_second_dropdown_option(String sOption){ createAttributePage.addSecondDropdownOption(sOption); }

    @Step
    public void save_an_attribute() { createAttributePage.saveAnAttribute(); }

    @Step
    public void delete_attribute(String attrCode){ createAttributePage.deleteAttribute(attrCode);}

}
