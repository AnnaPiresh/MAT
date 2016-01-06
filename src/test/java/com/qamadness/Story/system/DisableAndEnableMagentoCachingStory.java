package com.qamadness.Story.system;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.system.DisableAndEnableMagentoCachingSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class DisableAndEnableMagentoCachingStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    DisableAndEnableMagentoCachingSteps disableAndEnableMagentoCachingSteps;

    @Issue("MAT-37")
    @Pending
    @Test
    public void disable_magento_caching_from_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Cache_Management_Page();
        disableAndEnableMagentoCachingSteps.select_all_caches();
        disableAndEnableMagentoCachingSteps.choose_value_from_actions_dropdown("disable");
        disableAndEnableMagentoCachingSteps.click_submit_btn();
        disableAndEnableMagentoCachingSteps.check_sucess_msg("cache type(s) disabled.");
        disableAndEnableMagentoCachingSteps.select_all_caches();
        disableAndEnableMagentoCachingSteps.choose_value_from_actions_dropdown("enable");
        disableAndEnableMagentoCachingSteps.click_submit_btn();
        disableAndEnableMagentoCachingSteps.check_sucess_msg("cache type(s) enabled.");
    }
}
