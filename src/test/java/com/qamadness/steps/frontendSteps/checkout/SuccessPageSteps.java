package com.qamadness.steps.frontendSteps.checkout;

import com.qamadness.pages.frontend.checkout.SuccessPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Anna Piresh on 01.02.2016.
 */
public class SuccessPageSteps extends ScenarioSteps {

    SuccessPage successPage;

    @Step
    public void check_order_is_placed_successfully() { successPage.checkOrderIsPlacedSuccessfully();}

    @Step
    public void check_the_qty_of_orders(int expectedQty) {successPage.checkTheQtyOfOrders(expectedQty);}
}
