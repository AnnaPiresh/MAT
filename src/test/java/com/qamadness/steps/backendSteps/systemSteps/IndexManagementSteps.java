package com.qamadness.steps.backendSteps.systemSteps;


import com.qamadness.pages.backend.system.IndexManagement;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class IndexManagementSteps extends ScenarioSteps{
    IndexManagement indexManagement;

    @Step
    public void click_select_all_indexes(){ indexManagement.clickSelectAllIndexes();}

    @Step
    public void select_action_from_dropdown(String indexAction) { indexManagement.selectActionFromDropdown(indexAction);}

    @Step
    public void click_submit_btn() { indexManagement.clickSubmitBtn();}

    @Step
    public void check_success_message(String message) { indexManagement.checkSuccessMsg(message);}

}
