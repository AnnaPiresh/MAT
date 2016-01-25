package com.qamadness.Story.system;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.systemSteps.CacheManagementSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
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

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/system/CacheManagementData.csv")
public class CacheManagementStory {

    private String login;
    private String password;
    private String flushCachesMessage;
    private String cachesActionEnable;
    private String cachesActionDisable;
    private String successEnableMessage;
    private String successDisableMessage;

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
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
        } else {}
        mainMenuSteps.open_Cache_Management_Page();
    }

    @Issue("MAT-36")
    @Pending
    @Test
    public void flush_magento_caches_from_admin(){
        cacheManagementSteps.click_flush_cache_btn();
        cacheManagementSteps.check_success_message(flushCachesMessage);
    }

    @Issue("MAT-37")
    @Pending
    @Test
    public void disable_magento_caching_from_admin(){
        cacheManagementSteps.select_all_caches();
        cacheManagementSteps.choose_value_from_actions_dropdown(cachesActionDisable);
        cacheManagementSteps.click_submit_btn();
        cacheManagementSteps.check_success_message(successDisableMessage);
        cacheManagementSteps.select_all_caches();
        cacheManagementSteps.choose_value_from_actions_dropdown(cachesActionEnable);
        cacheManagementSteps.click_submit_btn();
        cacheManagementSteps.check_success_message(successEnableMessage);
    }
}
