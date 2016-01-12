package com.qamadness.Story.catalog;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
import com.qamadness.steps.catalog.AddAnAttributeSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class AddAnAttributeStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    AddAnAttributeSteps addAnAttributeSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Issue("MAT-34")
    @Pending
    @Test
    public void add_an_attribute_in_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Attributes_Page();
        addAnAttributeSteps.click_add_new_attribute_btn();
        addAnAttributeSteps.add_attribute_code("test_robot_attribute");
        addAnAttributeSteps.select_scope("2");
        addAnAttributeSteps.select_input_type("select");
        addAnAttributeSteps.select_apply_to("1");
        addAnAttributeSteps.select_product_types_to_apply("simple");
        addAnAttributeSteps.switch_to_options_tab();
        addAnAttributeSteps.add_admin_value_in_manage_titles("test_robot");
        addAnAttributeSteps.add_options_to_dropdown();
        addAnAttributeSteps.add_first_dropdown_option("Bender");
        addAnAttributeSteps.add_options_to_dropdown();
        addAnAttributeSteps.add_second_dropdown_option("Terminator");
        addAnAttributeSteps.save_an_attribute();
        successMessagesSteps.check_success_message("The product attribute has been saved.");
        addAnAttributeSteps.delete_attribute("test_robot_attribute");
        successMessagesSteps.check_success_message("The product attribute has been deleted.");
    }
}
