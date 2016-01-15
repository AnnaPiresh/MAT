package com.qamadness.steps.backendSteps.promotionsSteps;

import com.qamadness.pages.backend.promotions.ManagePriceRules;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 15.01.2016.
 */
public class ManagePriceRulesSteps extends ScenarioSteps {

    ManagePriceRules managePriceRules;

    @Step
    public void click_add_new_rule_btn(){managePriceRules.clickAddNewRuleBtn();}

    @Step
    public void enter_rule_Id(String ruleId){ managePriceRules.enterRuleId(ruleId);}

    @Step
    public void select_rule_status(String status){managePriceRules.selectRuleStatus(status);}

    @Step
    public void select_website_scope(String website){managePriceRules.selectWebsiteScope(website);}

    @Step
    public void select_customer_groups_apply_to(String customerGroups[]){
        managePriceRules.selectCustomerGroupsApplyTo(customerGroups);}

    @Step
    public void switch_to_conditions_tab(){managePriceRules.switchToConditionsTab();}

    @Step
    public void add_condition_to_rule(String condition) {managePriceRules.addConditionToRule(condition);}

    @Step
    public void select_condition_equalty(String equalty){managePriceRules.selectConditionEqualty(equalty);}

    @Step
    public void select_condition_value(String value){managePriceRules.selectConditionValue(value);}

    @Step
    public void switch_to_actions_tab(){managePriceRules.switchToActionsTab();}

    @Step
    public void select_apply_to_action(String applyValue){managePriceRules.selectApplyToAction(applyValue);}

    @Step
    public void enter_discount_amount(String discount) {managePriceRules.enterDiscountAmount(discount);}

    @Step
    public void save_rule(){managePriceRules.saveRule();}

    @Step
    public void check_success_message(String message) {managePriceRules.checkSuccessMsg(message);}

    @Step
    public void find_created_catalog_rule(String ruleId){ managePriceRules.findCreatedCatRule(ruleId);}

    @Step
    public void delete_created_rule(){managePriceRules.deleteCreatedRule();}

    @Step
    public void select_coupon_type_from_dropdown(String couponType){
        managePriceRules.selectCouponTypeFromDropdown(couponType);}

    @Step
    public void enter_coupon_code(String couponCode){ managePriceRules.enterCouponCode(couponCode);}

    @Step
    public void clear_global_search(){managePriceRules.clearGlobalSearch();}

    @Step
    public void find_created_shopping_cart_rule(String ruleId){ managePriceRules.findCreatedShopRule(ruleId);}
}
