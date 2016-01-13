package com.qamadness.Story.backend.system;

import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.MainMenuSteps;
import com.qamadness.steps.backend.SuccessMessagesSteps;
import com.qamadness.steps.backend.system.ReidexDataSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class ReindexDataStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ReidexDataSteps reidexDataSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Issue("MAT-39")
    @Pending
    @Test
    public void can_user_reindex_data_from_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Index_Management_Page();
        reidexDataSteps.click_select_all_indexes();
        reidexDataSteps.select_action_from_dropdown("reindex");
        reidexDataSteps.click_submit_btn();
        successMessagesSteps.check_success_message("index(es) have reindexed data.");
    }
}
