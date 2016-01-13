package com.qamadness.steps.backend.promotions;


import com.qamadness.pages.backend.promotions.AddCatalogPriceRule;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AddCatalogPriceRuleSteps extends ScenarioSteps{
    AddCatalogPriceRule addCatalogPriceRule;

    @Step
    public void click_add_new_rule_btn(){addCatalogPriceRule.clickAddNewRuleBtn();}

    @Step
    public void enter_rule_Id(String ruleId){ addCatalogPriceRule.enterRuleId(ruleId);}

    @Step
    public void select_rule_status(String status){addCatalogPriceRule.selectRuleStatus(status);}

    @Step
    public void select_website_scope(String website){addCatalogPriceRule.selectWebsiteScope(website);}

    @Step
    public void select_customer_groups_apply_to(String customerGroups[]){
        addCatalogPriceRule.selectCustomerGroupsApplyTo(customerGroups);}

    @Step
    public void switch_to_conditions_tab(){addCatalogPriceRule.switchToConditionsTab();}

    @Step
    public void add_condition_to_rule(String condition) {addCatalogPriceRule.addConditionToRule(condition);}

    @Step
    public void select_condition_equalty(String equalty){addCatalogPriceRule.selectConditionEqualty(equalty);}

    @Step
    public void select_condition_value(String value){addCatalogPriceRule.selectConditionValue(value);}

    @Step
    public void switch_to_actions_tab(){addCatalogPriceRule.switchToActionsTab();}

    @Step
    public void select_apply_to_action(String applyValue){addCatalogPriceRule.selectApplyToAction(applyValue);}

    @Step
    public void enter_discount_amount(String discount) {addCatalogPriceRule.enterDiscountAmount(discount);}

    @Step
    public void save_rule(){addCatalogPriceRule.saveRule();}

    @Step
    public void find_created_rule(String ruleId){ addCatalogPriceRule.findCreatedRule(ruleId);}

    @Step
    public void delete_created_rule(){addCatalogPriceRule.deleteCreatedRule();}
}
