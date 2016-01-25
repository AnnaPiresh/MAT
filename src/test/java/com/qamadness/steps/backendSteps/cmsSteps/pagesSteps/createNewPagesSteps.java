package com.qamadness.steps.backendSteps.cmsSteps.pagesSteps;

import com.qamadness.pages.backend.cms.pages.CreateNewPagePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class CreateNewPagesSteps extends ScenarioSteps{

    CreateNewPagePage createNewPagePage;

    //Steps for General buttons:

    @Step
    public void click_Save_Page_Button (){
        createNewPagePage.clickSavePageButton();
    }

    @Step
    public void click_Delete_Page_Button_And_Confirm (){
        createNewPagePage.clickDeletePageButtonAndConfirm();
    }

    //Steps for Page Information tab:

    @Step
    public void enter_Page_Title (String pageTitle){
        createNewPagePage.enterPageTitle(pageTitle);
    }

    @Step
    public void enter_Url_Key (String urlKey){
        createNewPagePage.enterUrlKey(urlKey);
    }

    @Step
    public void select_Store_View (String storeView){
        createNewPagePage.selectStoreView(storeView);
    }

    @Step
    public void select_Status (String status){
        createNewPagePage.selectStatus(status);
    }

    //Steps for Content tab:

    @Step
    public void open_Content_Tab (){
        createNewPagePage.openContentTab();
    }

    @Step
    public void enter_Content_Heading (String contentHeading){
        createNewPagePage.enterContentHeading(contentHeading);
    }

    @Step
    public void enter_Main_Content (String content){
        createNewPagePage.enterMainContent(content);
    }
}
