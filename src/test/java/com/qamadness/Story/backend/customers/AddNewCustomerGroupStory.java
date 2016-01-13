package com.qamadness.Story.backend.customers;


import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.MainMenuSteps;
import com.qamadness.steps.backend.customers.AddNewCustomerGroupSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class AddNewCustomerGroupStory  {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    AddNewCustomerGroupSteps addNewCustomerGroupSteps;

    @Issue("MAT-35")
    @Pending@Test
    public void check_that_customer_group_can_be_created_from_agmin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Customer_Groups_Page();
        addNewCustomerGroupSteps.click_add_customer_group_btn();
        addNewCustomerGroupSteps.select_tax_class("7");
        addNewCustomerGroupSteps.enter_group_code("robot_customer_group");
        addNewCustomerGroupSteps.click_save_customer_group_btn();
        addNewCustomerGroupSteps.check_success_msg("The customer group has been saved.");
        addNewCustomerGroupSteps.find_created_group("robot_customer_group");
        addNewCustomerGroupSteps.delete_created_group("The customer group has been deleted.");
    }
}
