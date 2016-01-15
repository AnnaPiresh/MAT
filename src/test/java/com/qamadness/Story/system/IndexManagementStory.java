package com.qamadness.Story.system;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
import com.qamadness.steps.system.IndexManagementSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class IndexManagementStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    IndexManagementSteps indexManagementSteps;

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
        indexManagementSteps.click_select_all_indexes();
        indexManagementSteps.select_action_from_dropdown("reindex");
        indexManagementSteps.click_submit_btn();
        successMessagesSteps.check_success_message("index(es) have reindexed data.");
    }
}
