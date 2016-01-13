package com.qamadness.steps.backend.system;


import com.qamadness.pages.backend.system.ReindexData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ReidexDataSteps extends ScenarioSteps{
    ReindexData reindexData;

    @Step
    public void click_select_all_indexes(){ reindexData.clickSelectAllIndexes();}

    @Step
    public void select_action_from_dropdown(String indexAction) { reindexData.selectActionFromDropdown(indexAction);}

    @Step
    public void click_submit_btn() {reindexData.clickSubmitBtn();}

}
