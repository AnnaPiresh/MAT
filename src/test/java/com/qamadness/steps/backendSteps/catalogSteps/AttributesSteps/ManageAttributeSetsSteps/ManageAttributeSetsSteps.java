package com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributeSetsSteps;

import com.qamadness.pages.backend.catalog.Attributes.ManageAttributeSets.ManageAttributeSetsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Anna Piresh on 19.01.2016.
 */
public class ManageAttributeSetsSteps extends ScenarioSteps{

    ManageAttributeSetsPage manageAttributeSetsPage;

    @Step
    public void search_for_attribute_set(String searchterm) {manageAttributeSetsPage.searchForAttributeSet(searchterm);}

    @Step
    public void check_correct_attribute_set_is_filtered(String searchterm){
        manageAttributeSetsPage.checkCorrectAttributeSetIsFiltered(searchterm); }

    @Step
    public void click_delete_attribute_set_button(){manageAttributeSetsPage.clickDeleteAttributeSetButton(); }

    @Step
    public void select_attribute_set_found() {manageAttributeSetsPage.selectAttributeSetFound();}

    @Step
    public void check_delete_button_is_not_present() {manageAttributeSetsPage.checkDeleteButtonIsNotPresent();}

}
