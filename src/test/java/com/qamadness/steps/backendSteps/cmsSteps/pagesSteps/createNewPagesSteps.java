package com.qamadness.steps.backendSteps.cmsSteps.pagesSteps;

import com.qamadness.pages.backend.cms.pages.СreateNewPagePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class CreateNewPagesSteps extends ScenarioSteps{

    СreateNewPagePage createNewPagePage;

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

    //Steps for Design tab:

    @Step
    public void open_Design_Tab (){
        createNewPagePage.openDesignTab();
    }

    @Step
    public void select_Page_Layout (String layoutValue){
        createNewPagePage.selectPageLayout(layoutValue);
    }

    @Step
    public void set_Current_Date_For_Custom_Design_From_Date (){
        createNewPagePage.setCurrentDateForCustomDesignFromDate();
    }

    @Step
    public void set_Current_Date_For_Custom_Design_To_Field (){
        createNewPagePage.setCurrentDateForCustomDesignToField();
    }

    @Step
    public void select_Custom_Theme (String themeValue){
        createNewPagePage.selectCustomTheme(themeValue);
    }

    @Step
    public void select_Custom_Layout (String customLayoutValue){
        createNewPagePage.selectCustomLayout(customLayoutValue);
    }

    //Steps for Meta Data tab:

    @Step
    public void open_Meta_Data_Tab (){
        createNewPagePage.openMetaDataTab();
    }

    @Step
    public void enter_Keywords (String keywords){
        createNewPagePage.enterKeywords(keywords);
    }

    @Step
    public void enter_Description (String description){
        createNewPagePage.enterDescription(description);
    }
}
