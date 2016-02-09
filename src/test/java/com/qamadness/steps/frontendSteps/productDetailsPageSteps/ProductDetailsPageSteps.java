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

    @Step
    public void select_bundle_item(){productDetailsPage.selectBundleItem();}

    @Step
    public void click_add_to_cart_button_bundle(){productDetailsPage.clickAddToCartButtonBundle();}

    @Step
    public void select_configurable_option(String productColour){
        productDetailsPage.selectConfigurableOption(productColour);}

    @Step
    public void select_downloadable_link(){productDetailsPage.selectDownloadableLink();}

    @Step
    public void click_add_to_cart_button_grouped() {productDetailsPage.clickAddToCartButtonGrouped();}

    @Step
    public void click_add_to_compare_btn() {productDetailsPage.clickAddToCompareBtn();}

    @Step
    public void check_Success_Compare_Msg(String productName) {productDetailsPage.checkSuccessCompareMsg(productName);}

    @Step
    public void select_custom_option_for_product(String customOption){
        productDetailsPage.selectCustomOptionForProduct(customOption);
    }


}
