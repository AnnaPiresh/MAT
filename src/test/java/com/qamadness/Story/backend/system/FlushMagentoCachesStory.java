package com.qamadness.Story.backend.system;

import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.MainMenuSteps;
import com.qamadness.steps.backend.SuccessMessagesSteps;
import com.qamadness.steps.backend.system.FlushMagentoCachesSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class FlushMagentoCachesStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Steps
    FlushMagentoCachesSteps flushMagentoCachesSteps;

    @Issue("MAT-36")
    @Pending
    @Test
    public void flush_magento_caches_from_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Cache_Management_Page();
        flushMagentoCachesSteps.click_flush_cache_btn();
        successMessagesSteps.check_success_message("The Magento cache storage has been flushed.");
    }
}
