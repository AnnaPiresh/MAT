package com.qamadness.steps.catalog;


import com.qamadness.pages.catalog.AddAnAttribute;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AddAnAttributeSteps extends ScenarioSteps{
    AddAnAttribute addAnAttribute;

    @Step
    public void click_add_new_attribute_btn(){ addAnAttribute.clickAddNewAttributeBtn(); }

    @Step
    public void add_attribute_code(String attrCode){ addAnAttribute.addAttrCode(attrCode); }

    @Step
    public void select_scope(String scope){ addAnAttribute.selectScope(scope); }

    @Step
    public void select_input_type(String inptype){ addAnAttribute.selectInputType(inptype); }

    @Step
    public void select_apply_to(String products){ addAnAttribute.selectApplyTo(products); }

    @Step
    public void select_product_types_to_apply(String type){ addAnAttribute.selectProductTypesToApply(type);}

    @Step
    public void switch_to_options_tab(){ addAnAttribute.switchToOptionsTab(); }

    @Step
    public void add_admin_value_in_manage_titles(String title){ addAnAttribute.addAdminValueInManageTitles(title); }

    @Step
    public void add_options_to_dropdown(){ addAnAttribute.addOptionsToDropdown(); }

    @Step
    public void add_first_dropdown_option(String fOption){ addAnAttribute.addFirstDropdownOption(fOption); }

    @Step
    public void add_second_dropdown_option(String sOption){ addAnAttribute.addSecondDropdownOption(sOption); }

    @Step
    public void save_an_attribute() { addAnAttribute.saveAnAttribute(); }

    @Step
    public void check_attribute_is_saved(){ addAnAttribute.checkAttributeIsSaved(); }

    @Step
    public void delete_attribute(String attrCode){ addAnAttribute.deleteAttribute(attrCode);}

    @Step
    public void check_attribute_deleted(){ addAnAttribute.checkAttributeIsDeleted(); }
}
