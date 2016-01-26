package com.qamadness.steps.frontendSteps.cmsPageSteps;

import com.qamadness.pages.frontend.cmsPage.NewCMSPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class NewCMSPageSteps extends ScenarioSteps {

    NewCMSPage NewCMSPage;

    @Step
    public void open_New_CMS_Page(String urlKey){
        NewCMSPage.openCMSPage(urlKey);
    }

    //Verifications:

   @Step
    public void verify_That_Page_Contains_Heading_And_Content (String heading, String content){
       NewCMSPage.verifyThatPageContainsHeadingAndContent(heading,content);
   }
}
