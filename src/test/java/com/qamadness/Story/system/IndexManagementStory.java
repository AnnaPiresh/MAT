package com.qamadness.Story.system;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.systemSteps.IndexManagementSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
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

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput();
            loginPageSteps.passInput();
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
        } else { }
        mainMenuSteps.open_Index_Management_Page();
    }

    @Issue("MAT-39")
    //@Pending
    @Test
    public void can_user_reindex_all_data_from_admin(){
        indexManagementSteps.click_select_all_indexes();
        indexManagementSteps.select_action_from_dropdown("reindex");
        indexManagementSteps.click_submit_btn();
        indexManagementSteps.check_success_message("index(es) have reindexed data.");
    }
}
