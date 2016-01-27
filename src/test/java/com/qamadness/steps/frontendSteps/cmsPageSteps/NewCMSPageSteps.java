package com.qamadness.steps.frontendSteps.cmsPageSteps;

import com.qamadness.pages.frontend.cmsPage.NewCMSPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 1/25/16.
 */
public class NewCMSPageSteps extends ScenarioSteps {

    NewCMSPage newCMSPage;

    @Step
    public void open_New_CMS_Page(String urlKey){
        newCMSPage.openCMSPage(urlKey);
    }

    //Verifications:

   @Step
    public void verify_That_Page_Contains_Heading_And_Content (String heading, String content){
       newCMSPage.verifyThatPageContainsHeadingAndContent(heading,content);
   }

    @Step
    public void verify_That_Three_Columns_Layout_Is_Used (){
        newCMSPage.verifyThatThreeColumnsLayoutIsUsed();
    }

    @Step
    public void verify_That_Keywords_Are_Added (String keywords){
        newCMSPage.verifyThatKeywordsAreAdded(keywords);
    }

    @Step
    public void verify_That_Meta_Description_Is_Added (String description){
        newCMSPage.verifyThatMetaDescriptionIsAdded(description);
    }

    @Step
    public void verify_That_CMS_Page_Link_Widget_Is_Added (){
        newCMSPage.verifyThatCMSPageLinkWidgetIsAdded();
    }

    @Step
    public void verify_That_Category_Link_Widget_Is_Added (){
        newCMSPage.verifyThatCategoryLinkWidgetIsAdded();
    }

    @Step
    public void verify_That_Cms_Static_Block_Widget_Is_Added (){
        newCMSPage.verifyThatCmsStaticBlockWidgetIsAdded();
    }

    @Step
    public void verify_That_New_Products_Widget_Is_Added (){
        newCMSPage.verifyThatNewProductsWidgetIsAdded();
    }

    @Step
    public void verify_That_Product_Link_Widget_Is_Added (){
        newCMSPage.verifyThatProductLinkWidgetIsAdded();
    }

    @Step
    public void verify_That_Orders_And_Returns_Widget_Is_Added (){
        newCMSPage.verifyThatOrdersAndReturnsWidgetIsAdded();
    }
}
