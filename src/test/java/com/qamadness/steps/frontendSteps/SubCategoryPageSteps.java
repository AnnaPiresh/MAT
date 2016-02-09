package com.qamadness.steps.frontendSteps;

import com.qamadness.pages.frontend.SubCategoryPage;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 2/9/16.
 */
public class SubCategoryPageSteps extends ScenarioSteps {

    SubCategoryPage subCategoryPage;

    //Methods for Poll block:

    public void check_That_Poll_Question_Matches_Expected (String expectedQuestion){
        subCategoryPage.checkThatPollQuestionMatchesExpected(expectedQuestion);
    }
}
