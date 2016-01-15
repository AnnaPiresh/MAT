package com.qamadness.Story.promotions;

import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.promotionsSteps.ManagePriceRulesSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/ManagePriceRulesData.csv")
public class ManagePriceRulesStory {

    private String login;
    private String password;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManagePriceRulesSteps managePriceRulesSteps;

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
    }

    @Issue("MAT-40")
    //@Pending
    @Test
    public void create_catalog_price_rule_from_admin(){
        String customerGroups[] = {"0", "1", "2", "4"};
        mainMenuSteps.open_Catalog_Price_Rules_Page();
        managePriceRulesSteps.click_add_new_rule_btn();
        managePriceRulesSteps.enter_rule_Id("test robot rule");
        managePriceRulesSteps.select_rule_status("1");
        managePriceRulesSteps.select_website_scope("1");
        managePriceRulesSteps.select_customer_groups_apply_to(customerGroups);
        managePriceRulesSteps.switch_to_conditions_tab();
        managePriceRulesSteps.add_condition_to_rule("catalogrule/rule_condition_product|price");
        managePriceRulesSteps.select_condition_equalty(">=");
        managePriceRulesSteps.select_condition_value("100");
        managePriceRulesSteps.switch_to_actions_tab();
        managePriceRulesSteps.select_apply_to_action("by_fixed");
        managePriceRulesSteps.enter_discount_amount("10");
        managePriceRulesSteps.save_rule();
        managePriceRulesSteps.check_success_message("The rule has been saved.");
        managePriceRulesSteps.find_created_catalog_rule("test robot rule");
        managePriceRulesSteps.delete_created_rule();
        managePriceRulesSteps.check_success_message("The rule has been deleted.");
    }

    @Issue("MAT-42")
    //@Pending
    @Test
    public void create_shopping_cart_price_rule_from_admin(){
        String customerGroups[] = {"0", "1", "2", "4"};
        mainMenuSteps.open_Shopping_Cart_Price_Rules_Page();
        managePriceRulesSteps.click_add_new_rule_btn();
        managePriceRulesSteps.enter_rule_Id("test robot rule");
        managePriceRulesSteps.select_rule_status("1");
        managePriceRulesSteps.select_website_scope("1");
        managePriceRulesSteps.select_customer_groups_apply_to(customerGroups);
        managePriceRulesSteps.select_coupon_type_from_dropdown("2");
        managePriceRulesSteps.enter_coupon_code("test_robot_code");
        managePriceRulesSteps.clear_global_search();
        managePriceRulesSteps.switch_to_conditions_tab();
        managePriceRulesSteps.add_condition_to_rule("salesrule/rule_condition_address|base_subtotal");
        managePriceRulesSteps.select_condition_equalty(">=");
        managePriceRulesSteps.select_condition_value("100");
        managePriceRulesSteps.switch_to_actions_tab();
        managePriceRulesSteps.select_apply_to_action("by_fixed");
        managePriceRulesSteps.enter_discount_amount("10");
        managePriceRulesSteps.save_rule();
        managePriceRulesSteps.check_success_message("The rule has been saved.");
        managePriceRulesSteps.find_created_shopping_cart_rule("test robot rule");
        managePriceRulesSteps.delete_created_rule();
        managePriceRulesSteps.check_success_message("The rule has been deleted.");
    }

}
