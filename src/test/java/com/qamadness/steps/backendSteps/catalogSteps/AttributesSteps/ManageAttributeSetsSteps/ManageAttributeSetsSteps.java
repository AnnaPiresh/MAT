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
    public boolean check_correct_attribute_set_is_filtered(String searchterm){
        manageAttributeSetsPage.checkCorrectAttributeSetIsFiltered(searchterm);
        return false;
    }
}
