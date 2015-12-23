package com.qamadness.Story.sales;

import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.sales.OpenOrdersSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class OpenOrdersStory {

    @Managed(uniqueSession = true)
    public WebDriver driver;


    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    OpenOrdersSteps openOrdersSteps;

    @Issue("MAT-5")
    @Pending@Test
    public void check_orders_page_is_opened() {
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        openOrdersSteps.orders_Open();

    }
}
