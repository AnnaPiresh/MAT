package com.qamadness.steps.frontendSteps.productDetailsPageSteps;

import com.qamadness.pages.frontend.productDetailsPage.ProductDetailsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class ProductDetailsPageSteps extends ScenarioSteps {

    ProductDetailsPage productDetailsPage;

    @Step
    public void click_add_to_cart_button(){ productDetailsPage.clickAddToCartButton();}

    @Step
    public void enter_qty_of_products(String firstProductQty, String secondProductQty){
        productDetailsPage.enterQtyOfProducts(firstProductQty, secondProductQty);}

}
