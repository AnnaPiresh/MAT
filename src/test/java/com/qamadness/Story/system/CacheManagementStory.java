package com.qamadness.Story.system;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.system.CacheManagementSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CacheManagementStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    CacheManagementSteps cacheManagementSteps;

    @Before
    public void login_to_admin_panel() {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Cache_Management_Page();
    }

    @Issue("MAT-36")
    @Pending
    @Test
    public void flush_magento_caches_from_admin(){
        cacheManagementSteps.click_flush_cache_btn();
        cacheManagementSteps.check_success_message("The Magento cache storage has been flushed.");
    }

    @Issue("MAT-37")
    @Pending
    @Test
    public void disable_magento_caching_from_admin(){
        cacheManagementSteps.select_all_caches();
        cacheManagementSteps.choose_value_from_actions_dropdown("disable");
        cacheManagementSteps.click_submit_btn();
        cacheManagementSteps.check_success_message("cache type(s) disabled.");
        cacheManagementSteps.select_all_caches();
        cacheManagementSteps.choose_value_from_actions_dropdown("enable");
        cacheManagementSteps.click_submit_btn();
        cacheManagementSteps.check_success_message("cache type(s) enabled.");
    }
}
