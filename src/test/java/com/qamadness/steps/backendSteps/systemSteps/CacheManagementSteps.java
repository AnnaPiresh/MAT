package com.qamadness.steps.backendSteps.systemSteps;

import com.qamadness.pages.backend.system.CacheManagement;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class CacheManagementSteps extends ScenarioSteps {

    CacheManagement cacheManagement;

    @Step
    public void click_flush_cache_btn(){ cacheManagement.clickFlushCacheBtn();}

    @Step
    public void select_all_caches() { cacheManagement.selectAllCaches();}

    @Step
    public void choose_value_from_actions_dropdown(String cachesAction) {
        cacheManagement.chooseValueFromActionsDropdown(cachesAction);}

    @Step
    public void click_submit_btn() { cacheManagement.clickSubmitBtn();}

    @Step
    public void check_success_message(String message) {cacheManagement.checkSuccessMsg(message);}

}
