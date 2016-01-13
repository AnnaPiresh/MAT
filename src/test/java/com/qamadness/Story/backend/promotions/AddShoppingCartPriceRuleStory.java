package com.qamadness.Story.backend.promotions;


import com.qamadness.steps.backend.DashboardSteps;
import com.qamadness.steps.backend.LoginPageSteps;
import com.qamadness.steps.backend.MainMenuSteps;
import com.qamadness.steps.backend.SuccessMessagesSteps;
import com.qamadness.steps.backend.promotions.AddCatalogPriceRuleSteps;
import com.qamadness.steps.backend.promotions.AddShoppingCartPriceRuleSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddShoppingCartPriceRuleStory {

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

    @Issue("MAT-42")
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
    }


}
