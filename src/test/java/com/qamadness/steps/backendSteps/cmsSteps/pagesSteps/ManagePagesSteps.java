package com.qamadness.steps.backendSteps.cmsSteps.pagesSteps;

import com.qamadness.pages.backend.cms.pages.ManagePagesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class ManagePagesSteps extends ScenarioSteps{

    ManagePagesPage managePagesPage;

    //Click General buttons steps:

    @Step
    public void click_Add_New_Page_Button (){
        managePagesPage.clickAddNewPageButton();
    }

    //Methods for grid:

    @Step
    public void filter_Pages_By_Url_Key (String urlKey){
        managePagesPage.filterPagesByUrlKey(urlKey);
    }

    @Step
    public void click_First_Page_In_The_Grid (){
        managePagesPage.clickFirstPageInTheGrid();
    }

    //Verifications:

    @Step
    public void verify_That_Success_Saved_Page_Message_Is_Displayed(){
        managePagesPage.verifyThatSuccessSavedPageMessageIsDisplayed();
    }

    @Step
    public void verify_That_Existing_URL_Key_Error_Message_Is_Displayed (){
        managePagesPage.verifyThatExistingURLKeyErrorMessageIsDisplayed();
    }

    @Step
    public void verify_That_Invalid_URL_Key_With_Numbers_Only_Error_Message_Is_Displayed (){
        managePagesPage.verifyThatInvalidURLKeyWithNumbersOnlyErrorMessageIsDisplayed();
    }

    @Step
    public void verify_That_Deleted_CMS_Page_Success_Message_Is_Displayed (){
        managePagesPage.verifyThatDeletedCMSPageSuccessMessageIsDisplayed();
    }

}
