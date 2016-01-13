package com.qamadness.Story.backend.system;

import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.system.ChangeInterfaceLanguageSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class ChangeInterfaceLanguageStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    ChangeInterfaceLanguageSteps changeInterfaceLanguageSteps;

    @Issue("MAT-38")
    @Pending@Test
    public void can_user_change_the_language_of_interface_of_admin_panel(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
    }
}
