package com.qamadness.Story.customers;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
import com.qamadness.steps.customers.CustomerInformationSteps;
import com.qamadness.steps.customers.ManageCustomersSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.awt.*;

@RunWith(ThucydidesRunner.class)
public class DeleteCustomerFromAdminStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManageCustomersSteps manageCustomersSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Steps
    CustomerInformationSteps customerInformationSteps;

    @Issue("MAT-41")
    @Pending
    @Test
    public void delete_a_customer_from_admin() throws AWTException {
        String email = "testersunny377+2@gmail.com";
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Customers_Page();
        manageCustomersSteps.search_Customer_By_Email(email);
        manageCustomersSteps.check_Search_Result(email);
        manageCustomersSteps.open_First_Customer_Profile();
        customerInformationSteps.click_Delete_Customer_Button();
        successMessagesSteps.check_success_message("The customer has been deleted.");
    }
}
