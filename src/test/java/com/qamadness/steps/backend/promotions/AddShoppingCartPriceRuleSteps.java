package com.qamadness.steps.backend.promotions;


import com.qamadness.pages.backend.promotions.AddShoppingCartPriceRule;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AddShoppingCartPriceRuleSteps extends ScenarioSteps{
    AddShoppingCartPriceRule addShoppingCartPriceRule;

    @Step
    public void select_coupon_type_from_dropdown(String couponType){
        addShoppingCartPriceRule.selectCouponTypeFromDropdown(couponType);}

    @Step
    public void enter_coupon_code(String couponCode){ addShoppingCartPriceRule.enterCouponCode(couponCode);}
}
