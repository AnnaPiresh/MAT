package com.qamadness.steps.system;


import com.qamadness.pages.system.DisableAndEnableMagentoCaching;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class DisableAndEnableMagentoCachingSteps extends ScenarioSteps{
    DisableAndEnableMagentoCaching disableAndEnableMagentoCaching;

    @Step
    public void select_all_caches() {
        disableAndEnableMagentoCaching.selectAllCaches();}

    @Step
    public void choose_value_from_actions_dropdown(String cachesAction) {
        disableAndEnableMagentoCaching.chooseValueFromActionsDropdown(cachesAction);}

    @Step
    public void click_submit_btn() { disableAndEnableMagentoCaching.clickSubmitBtn();}

    @Step
    public void check_sucess_msg(String messageCaches){disableAndEnableMagentoCaching.checkSuccessMsg(messageCaches);}
}
