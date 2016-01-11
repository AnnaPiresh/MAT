package com.qamadness.Story.promotions;

import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
import com.qamadness.steps.promotions.AddCatalogPriceRuleSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class AddCatalogPriceRuleStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    AddCatalogPriceRuleSteps addCatalogPriceRuleSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Issue("MAT-40")
    @Test
    public void create_catalog_price_rule_from_admin(){
        String customerGroups[] = {"0", "1", "2", "4"};
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Catalog_Price_Rules_Page();
        addCatalogPriceRuleSteps.click_add_new_rule_btn();
        addCatalogPriceRuleSteps.enter_rule_Id("test robot rule");
        addCatalogPriceRuleSteps.select_rule_status("1");
        addCatalogPriceRuleSteps.select_website_scope("1");
        addCatalogPriceRuleSteps.select_customer_groups_apply_to(customerGroups);
        addCatalogPriceRuleSteps.switch_to_conditions_tab();
        addCatalogPriceRuleSteps.add_condition_to_rule("catalogrule/rule_condition_product|price");
        addCatalogPriceRuleSteps.select_condition_equalty(">=");
        addCatalogPriceRuleSteps.select_condition_value("100");
        addCatalogPriceRuleSteps.switch_to_actions_tab();
        addCatalogPriceRuleSteps.select_apply_to_action("by_fixed");
        addCatalogPriceRuleSteps.enter_discount_amount("10");
        addCatalogPriceRuleSteps.save_rule();
        successMessagesSteps.check_success_message("The rule has been saved.");
        addCatalogPriceRuleSteps.find_created_rule("test robot rule");
        addCatalogPriceRuleSteps.delete_created_rule();
        successMessagesSteps.check_success_message("The rule has been deleted.");
    }
}
