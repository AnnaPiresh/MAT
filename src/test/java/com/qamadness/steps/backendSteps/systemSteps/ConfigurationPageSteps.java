package com.qamadness.steps.backendSteps.systemSteps;

import com.qamadness.pages.backend.system.ConfigurationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 2/2/16.
 */
public class ConfigurationPageSteps extends ScenarioSteps {

    ConfigurationPage configurationPage;

    //Steps for Advanced tab:

    @Step
    public void open_Advanced_Tab (){
        configurationPage.openAdvancedTab();
    }

    @Step
    public void enable_Cms_Pool_Module (){
        configurationPage.enableCmsPoolModule();
    }
}
