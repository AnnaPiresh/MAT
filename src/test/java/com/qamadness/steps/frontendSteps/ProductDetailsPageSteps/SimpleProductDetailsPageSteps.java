package com.qamadness.steps.frontendSteps.productDetailsPageSteps;

import com.qamadness.pages.frontend.productDetailsPage.SimpleProductDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class SimpleProductDetailsPageSteps extends ScenarioSteps {

    SimpleProductDetailsPage simpleProductDetailsPage;

    @Step
    public void click_add_to_cart_button(){
        simpleProductDetailsPage.clickAddToCartButton();}

    @Step
    public void check_product_is_added_to_cart(String productMessage){
        simpleProductDetailsPage.checkProductIsAddedToCart(productMessage);}

}
