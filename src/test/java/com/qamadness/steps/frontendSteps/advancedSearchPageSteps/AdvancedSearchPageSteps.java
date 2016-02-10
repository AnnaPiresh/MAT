package com.qamadness.steps.frontendSteps.advancedSearchPageSteps;

import com.qamadness.pages.frontend.advancedSearchPage.AdvancedSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Vladislav.E on 08.02.2016.
 */
public class AdvancedSearchPageSteps extends ScenarioSteps {

    AdvancedSearchPage advancedSearchPage;

    @Step
    public void check_Compared_Product(String productName) {advancedSearchPage.checkComparedProduct(productName);}

    @Step
    public void clear_compare_block() {advancedSearchPage.clearCompare();}

    @Step
    public void check_That_Product_In_Compare_Block() {advancedSearchPage.checkThatProductInCompareBlock();}

}
