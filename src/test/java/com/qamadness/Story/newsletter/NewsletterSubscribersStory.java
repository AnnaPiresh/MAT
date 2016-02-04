package com.qamadness.Story.newsletter;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.newsletterSteps.NewsletterSubscribersSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by Vladislav.E on 03.02.2016.
 */
@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/newsletter/NewsletterSubscribersData.csv")
public class NewsletterSubscribersStory {

    private String login;
    private String password;
    private String subscribeEmail;

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    NewsletterSubscribersSteps newsletterSubscribersSteps;


    @Issue("MAT-229")
    @Pending
    @Test
    public void with_Valid_Email () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        homePageSteps.open_Home_Page();
        homePageSteps.enter_Email_To_Newsletter_Field(subscribeEmail);
        homePageSteps.click_Subscribe_Btn();
        homePageSteps.check_Success_Subscribe_Msg();
        loginPageSteps.navigate_to_dashboard();
        mainMenuSteps.open_Newsletter_Subscribers();
        webDriver.navigate().refresh();
        newsletterSubscribersSteps.search_User_By_Email(subscribeEmail);
        newsletterSubscribersSteps.select_Subscriber();
        newsletterSubscribersSteps.delete_Subscriber();
        newsletterSubscribersSteps.search_User_By_Email(subscribeEmail);
        newsletterSubscribersSteps.check_That_User_Was_Deleted();
    }
}


