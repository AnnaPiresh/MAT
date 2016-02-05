package com.qamadness.steps.frontendSteps.shoppingCartSteps;

import com.qamadness.pages.frontend.shoppingCartPage.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Anna Piresh on 28.01.2016.
 */
public class ShoppingCartSteps extends ScenarioSteps{

    ShoppingCartPage shoppingCartPage;

    @Step
    public void proceed_to_multiple_addresses_checkout(){shoppingCartPage.proceedToMultipleAddressesCheckout();}

    @Step
    public void empty_shopping_cart() {shoppingCartPage.emptyShoppingCart();}

    @Step
    public void check_product_is_added_to_cart(String productMessage){
        shoppingCartPage.checkProductIsAddedToCart(productMessage);}

    @Step
    public void change_products_qty(String productQty){shoppingCartPage.changeProductsQty(productQty);}

}
