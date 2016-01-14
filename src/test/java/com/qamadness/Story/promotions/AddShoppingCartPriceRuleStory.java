package com.qamadness.Story.promotions;


import com.qamadness.steps.DashboardSteps;
import com.qamadness.steps.LoginPageSteps;
import com.qamadness.steps.MainMenuSteps;
import com.qamadness.steps.SuccessMessagesSteps;
import com.qamadness.steps.frontend.HomepageSteps;
import com.qamadness.steps.frontend.ProductOverviewPageSteps;
import com.qamadness.steps.promotions.AddCatalogPriceRuleSteps;
import com.qamadness.steps.promotions.AddShoppingCartPriceRuleSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class  AddShoppingCartPriceRuleStory {

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
    AddShoppingCartPriceRuleSteps addShoppingCartPriceRuleSteps;

    @Steps
    SuccessMessagesSteps successMessagesSteps;

    @Steps
    HomepageSteps homepageSteps;

    @Steps
    ProductOverviewPageSteps productOverviewPageSteps;

    @Issue("MAT-42")
    //@Pending
    @Test
    public void create_shopping_cart_price_rule_from_admin(){
        String customerGroups[] = {"0", "1", "2", "4"};
        loginPageSteps.openPage();
        loginPageSteps.loginInput();
        loginPageSteps.passInput();
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_Shopping_Cart_Price_Rules_Page();
        addCatalogPriceRuleSteps.click_add_new_rule_btn();
        addCatalogPriceRuleSteps.enter_rule_Id("test robot rule");
        addCatalogPriceRuleSteps.select_rule_status("1");
        addCatalogPriceRuleSteps.select_website_scope("1");
        addCatalogPriceRuleSteps.select_customer_groups_apply_to(customerGroups);
        addShoppingCartPriceRuleSteps.select_coupon_type_from_dropdown("2");
        addShoppingCartPriceRuleSteps.enter_coupon_code("test_robot_code");
        addShoppingCartPriceRuleSteps.clear_global_search();
        addCatalogPriceRuleSteps.switch_to_conditions_tab();
        addCatalogPriceRuleSteps.add_condition_to_rule("salesrule/rule_condition_address|base_subtotal");
        addCatalogPriceRuleSteps.select_condition_equalty(">=");
        addCatalogPriceRuleSteps.select_condition_value("100");
        addCatalogPriceRuleSteps.switch_to_actions_tab();
        addCatalogPriceRuleSteps.select_apply_to_action("by_fixed");
        addCatalogPriceRuleSteps.enter_discount_amount("10");
        addCatalogPriceRuleSteps.save_rule();
        successMessagesSteps.check_success_message("The rule has been saved.");
        homepageSteps.open_website();
        homepageSteps.open_product_overview_page();
        productOverviewPageSteps.open_product_details_page();
    }


}
