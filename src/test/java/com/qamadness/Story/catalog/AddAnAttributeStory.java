package com.qamadness.Story.catalog;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributesSteps.AddAnAttributeSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/Attributes/ManageAttributes/AddAnAttributeData.csv")
public class AddAnAttributeStory {

    private String login;
    private String password;
    private String attrCode;
    private String scope;
    private String inptype;
    private String products;
    private String type;
    private String title;
    private String firstOption;
    private String secondOption;
    private String successSaveMessage;
    private String successDeleteMessage;


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



    @Issue("MAT-34")
    @Pending
    @Test
    public void add_an_attribute_in_admin(){
        loginPageSteps.openPage();
        loginPageSteps.loginInput(login);
        loginPageSteps.passInput(password);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Manage_Attributes_Page();
        addAnAttributeSteps.click_add_new_attribute_btn();
        addAnAttributeSteps.add_attribute_code(attrCode);
        addAnAttributeSteps.select_scope(scope);
        addAnAttributeSteps.select_input_type(inptype);
        addAnAttributeSteps.select_apply_to(products);
        addAnAttributeSteps.select_product_types_to_apply(type);
        addAnAttributeSteps.switch_to_options_tab();
        addAnAttributeSteps.add_admin_value_in_manage_titles(title);
        addAnAttributeSteps.add_options_to_dropdown();
        addAnAttributeSteps.add_first_dropdown_option(firstOption);
        addAnAttributeSteps.add_options_to_dropdown();
        addAnAttributeSteps.add_second_dropdown_option(secondOption);
        addAnAttributeSteps.save_an_attribute();
        addAnAttributeSteps.check_success_message(successSaveMessage);
        addAnAttributeSteps.delete_attribute(attrCode);
        addAnAttributeSteps.check_success_message(successDeleteMessage);
   }
}
