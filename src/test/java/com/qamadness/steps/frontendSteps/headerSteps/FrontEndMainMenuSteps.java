package com.qamadness.steps.frontendSteps.headerSteps;

import com.qamadness.pages.frontend.header.FrontEndMainMenu;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 2/8/16.
 */
public class FrontEndMainMenuSteps extends ScenarioSteps {

    FrontEndMainMenu frontEndMainMenu;

    @Step
    public void open_Category_By_Name (String categoryName){
        frontEndMainMenu.openCategoryByName(categoryName);
    }
}
