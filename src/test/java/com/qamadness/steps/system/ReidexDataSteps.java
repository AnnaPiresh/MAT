package com.qamadness.steps.system;


import com.qamadness.pages.system.ReindexData;
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

    @Step
    public void check_sucess_msg(String messageIndex) {reindexData.checkSuccessMsg(messageIndex);}
}
