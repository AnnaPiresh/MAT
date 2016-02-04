package com.qamadness.Story.newsletter;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.customersSteps.CustomerInformationSteps;
import com.qamadness.steps.backendSteps.customersSteps.ManageCustomersSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.LogoutFromAdminSteps;
import com.qamadness.steps.backendSteps.newsletterSteps.NewsletterSubscribersSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import com.qamadness.steps.frontendSteps.registrationSteps.RegistrationPageSteps;
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

import java.awt.*;

/**
 * Created by Vladislav.E on 03.02.2016.
 */
@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/newsletter/NewsletterSubscribersData.csv")
public class NewsletterSubscribersStory {

    private String login;
    private String password;
    private String passwordRegister;
    private String firstName;
    private String lastName;
    private String email;

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    RegistrationPageSteps registrationPageSteps;

    @Steps
    NewsletterSubscribersSteps newsletterSubscribersSteps;

    @Steps
    ManageCustomersSteps manageCustomersSteps;

    @Steps
    CustomerInformationSteps customerInformationSteps;

    @Steps
    LogoutFromAdminSteps logoutFromAdminSteps;

    @Steps
    DashboardSteps dashboardSteps;


    @Issue("MAT-229")
    @Pending
    @Test
    public void with_Valid_Email () {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        homePageSteps.open_Home_Page();
        homePageSteps.enter_Email_To_Newsletter_Field(email);
        homePageSteps.click_Subscribe_Btn();
        homePageSteps.check_Success_Subscribe_Msg();
        loginPageSteps.navigate_to_dashboard();
        mainMenuSteps.open_Newsletter_Subscribers();
        webDriver.navigate().refresh();
        newsletterSubscribersSteps.search_User_By_Email(email);
        newsletterSubscribersSteps.select_Subscriber();
        newsletterSubscribersSteps.delete_Subscriber();
        newsletterSubscribersSteps.search_User_By_Email(email);
        newsletterSubscribersSteps.check_That_User_Was_Deleted();
        logoutFromAdminSteps.logout_from_admin();

    }

    @Issue("MAT-230")
    @Pending
    @Test
    public void with_valid_email_that_used_for_registered_customer() throws AWTException {
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        homePageSteps.open_Home_Page();
        homePageSteps.open_account_menu_in_header();
        homePageSteps.click_register_link();
        registrationPageSteps.enter_First_Name(firstName);
        registrationPageSteps.enter_Last_Name(lastName);
        registrationPageSteps.enter_Email_Address(email);
        registrationPageSteps.enter_Password(passwordRegister);
        registrationPageSteps.enter_Password_To_Confirm_Fld(passwordRegister);
        registrationPageSteps.click_Sign_Up_Newsletter_Checkbox();
        registrationPageSteps.click_Register_Btn();
        registrationPageSteps.check_Success_Registration_Msg();
        homePageSteps.open_account_menu_in_header();
        homePageSteps.logout_from_website();
        homePageSteps.enter_Email_To_Newsletter_Field(email);
        homePageSteps.click_Subscribe_Btn();
        homePageSteps.check_Subscribe_Error_Msg();
        loginPageSteps.navigate_to_dashboard();
        mainMenuSteps.open_Manage_Customers_Page();
        manageCustomersSteps.search_Customer_By_Email(email);
        manageCustomersSteps.open_First_Customer_Profile();
        customerInformationSteps.click_Delete_Customer_Button();
        logoutFromAdminSteps.logout_from_admin();


    }
}


