package com.qamadness.Story.promotions;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.promotionsSteps.ManagePriceRulesSteps;
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
 * Created by Serhii_Boiko on 15.01.2016.
 */

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="src/test/resources/promotions/ManagePriceRulesData.csv")
public class ManagePriceRulesStory {

    private String login;
    private String password;
    private String ruleId;
    private String status;
    private String website;
    private String customerGroups;
    private String conditionCatalogue;
    private String conditionShoppingCart;
    private String equalty;
    private String value;
    private String applyValue;
    private String discount;
    private String successSavingMessage;
    private String successDeletionMessage;
    private String couponCode;
    private String couponType;

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
    @Pending
    @Test
    public void create_catalog_price_rule_from_admin(){
        char[] customerGroupsArray = customerGroups.toCharArray();
        mainMenuSteps.open_Catalog_Price_Rules_Page();
        managePriceRulesSteps.click_add_new_rule_btn();
        managePriceRulesSteps.enter_rule_Id(ruleId);
        managePriceRulesSteps.select_rule_status(status);
        managePriceRulesSteps.select_website_scope(website);
        managePriceRulesSteps.select_customer_groups_apply_to(customerGroupsArray);
        managePriceRulesSteps.switch_to_conditions_tab();
        managePriceRulesSteps.add_condition_to_rule(conditionCatalogue);
        managePriceRulesSteps.select_condition_equalty(equalty);
        managePriceRulesSteps.select_condition_value(value);
        managePriceRulesSteps.switch_to_actions_tab();
        managePriceRulesSteps.select_apply_to_action(applyValue);
        managePriceRulesSteps.enter_discount_amount(discount);
        managePriceRulesSteps.save_rule();
        managePriceRulesSteps.check_success_message(successSavingMessage);
        managePriceRulesSteps.find_created_catalog_rule(ruleId);
        managePriceRulesSteps.delete_created_rule();
        managePriceRulesSteps.check_success_message(successDeletionMessage);
    }

    @Issue("MAT-42")
    @Pending
    @Test
    public void create_shopping_cart_price_rule_from_admin(){
        char[] customerGroupsArray = customerGroups.toCharArray();
        mainMenuSteps.open_Shopping_Cart_Price_Rules_Page();
        managePriceRulesSteps.click_add_new_rule_btn();
        managePriceRulesSteps.enter_rule_Id(ruleId);
        managePriceRulesSteps.select_rule_status(status);
        managePriceRulesSteps.select_website_scope(website);
        managePriceRulesSteps.select_customer_groups_apply_to(customerGroupsArray);
        managePriceRulesSteps.select_coupon_type_from_dropdown(couponType);
        managePriceRulesSteps.enter_coupon_code(couponCode);
        managePriceRulesSteps.clear_global_search();
        managePriceRulesSteps.switch_to_conditions_tab();
        managePriceRulesSteps.add_condition_to_rule(conditionShoppingCart);
        managePriceRulesSteps.select_condition_equalty(equalty);
        managePriceRulesSteps.select_condition_value(value);
        managePriceRulesSteps.switch_to_actions_tab();
        managePriceRulesSteps.select_apply_to_action(applyValue);
        managePriceRulesSteps.enter_discount_amount(discount);
        managePriceRulesSteps.save_rule();
        managePriceRulesSteps.check_success_message(successSavingMessage);
        managePriceRulesSteps.find_created_shopping_cart_rule(ruleId);
        managePriceRulesSteps.delete_created_rule();
        managePriceRulesSteps.check_success_message(successDeletionMessage);
    }

}
