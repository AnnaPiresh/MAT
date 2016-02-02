package com.qamadness.steps.frontendSteps.productOverviewPageSteps;

import com.qamadness.pages.frontend.productOverviewPage.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Serhii_Boiko on 28.01.2016.
 */
public class SearchResultsSteps extends ScenarioSteps {

    SearchResultsPage searchResultsPage;

    @Step
    public void select_first_product_from_results(){searchResultsPage.selectFirstProductFromResults();}

    @Step
    public void select_second_product_from_results() {searchResultsPage.selectSecondProductFromResults();}

    @Step
    public void return_to_previous_page(){searchResultsPage.returnToPreviousPage();}

    @Step
    public void select_virtual_product_from_results() {searchResultsPage.selectVirtualProductFromResults();}
}
