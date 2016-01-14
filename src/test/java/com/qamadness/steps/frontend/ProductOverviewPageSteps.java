package com.qamadness.steps.frontend;


import com.qamadness.pages.frontend.ProductOverviewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductOverviewPageSteps extends ScenarioSteps{

    ProductOverviewPage productOverviewPage;

    @Step
    public void open_product_details_page(){productOverviewPage.openProductDetailsPage();}

}
