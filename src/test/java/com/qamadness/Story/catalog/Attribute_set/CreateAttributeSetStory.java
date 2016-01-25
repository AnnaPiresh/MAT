package com.qamadness.Story.catalog.Attribute_set;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributeSetsSteps.CreateAttributeSetSteps;
import com.qamadness.steps.backendSteps.catalogSteps.AttributesSteps.ManageAttributeSetsSteps.ManageAttributeSetsSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
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
import org.yecht.Data;

/**
 * Created by Serhii_Boiko on 18.01.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value = "src/test/resources/catalog/Attributes/ManageAttributeSets/CreateAttributeSetData.csv")
public class CreateAttributeSetStory {

    private String login;
    private String password;
    private String setName;
    private String successMessage;
    private String errorMessage;
    private String requiredMessage;
    private String charName;
    private String userProductsName;
    private String groupTitle;
    private String customSetName;
    private String basedOnValue;
    private String deleteMessage;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    CreateAttributeSetSteps createAttributeSetSteps;

    @Steps
    ManageAttributeSetsSteps manageAttributeSetsSteps;

    @Before
    public void openPage () {
        loginPageSteps.openPage();
        int size = webdriver.findElements(org.openqa.selenium.By.xpath(".//*[@id='username']")).size();
        if (size > 0) {
            loginPageSteps.loginInput(login);
            loginPageSteps.passInput(password);
            loginPageSteps.loginButton();
            dashboardSteps.closePopup();
        } else {}
        mainMenuSteps.open_Manage_Attribute_Sets_page();
    }

    @Issue("MAT-67")
    @Pending
    @Test
    public void create_attribute_set_based_on_default(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(setName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(successMessage);
        manageAttributeSetsSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteMessage);
    }

    @Issue("MAT-68")
    @Pending
    @Test
    public void create_attribute_set_with_existing_name(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(setName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(successMessage);
        manageAttributeSetsSteps.search_for_attribute_set(setName);
        manageAttributeSetsSteps.check_correct_attribute_set_is_filtered(setName);
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(setName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_error_message(errorMessage);
    }

    @Issue("MAT-69")
    @Pending
    @Test
    public void create_attribute_set_with_empty_name(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_required_field_message(requiredMessage);
    }

    @Issue("MAT-70")
    @Pending
    @Test
    public void create_attribute_set_with_long_name(){
        String longName = new String(new char[52]).replace("\0", "Test ");
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(longName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(successMessage);
        manageAttributeSetsSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteMessage);
    }

    @Issue("MAT-71")
    @Pending
    @Test
    public void create_attribute_set_using_special_characters_for_set_name(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(charName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(successMessage);
        manageAttributeSetsSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteMessage);
    }

    @Issue("MAT-72")
    //@Pending
    @Test
    public void create_attribute_set_with_adding_user_product_attributes(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(userProductsName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.add_new_attribute_group(groupTitle);
        createAttributeSetSteps.assign_attributes_to_created_group();
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(successMessage);
        manageAttributeSetsSteps.search_for_attribute_set(userProductsName);
        manageAttributeSetsSteps.select_attribute_set_found();
        manageAttributeSetsSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteMessage);
    }

    @Issue("MAT-73")
    @Pending
    @Test
    public void create_attribute_set_based_on_custom(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(customSetName);
        createAttributeSetSteps.select_based_on_value(basedOnValue);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(successMessage);
        manageAttributeSetsSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteMessage);
    }

}
