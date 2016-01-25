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

/**
 * Created by Anna Piresh on 25.01.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value = "src/test/resources/catalog/Attributes/ManageAttributeSets/DeleteAttributeSetData.csv")
public class DeleteAttributeSetStory {

    private String login;
    private String password;
    private String setName;
    private String createSuccessMessage;
    private String deleteSuccessMessage;

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

    @Issue("MAT-74")
    @Pending
    @Test
    public void delete_attribute_set_without_related_products(){
        createAttributeSetSteps.click_add_new_attribute_set_button();
        createAttributeSetSteps.enter_attribute_set_name(setName);
        createAttributeSetSteps.save_attribute_set();
        createAttributeSetSteps.check_success_message(createSuccessMessage);
        manageAttributeSetsSteps.click_delete_attribute_set_button();
        createAttributeSetSteps.check_success_message(deleteSuccessMessage);
    }
}

