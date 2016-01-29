package com.qamadness.Story.cms_page;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pagesSteps.CreateNewPagesSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pagesSteps.ManagePagesSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.frontendSteps.cmsPageSteps.NewCMSPageSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 1/27/16.
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/cms_page/CreateCMSPageData.csv")
public class DeleteCMSPageStory {

    //Data in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String pageTitle;
    private String urlKey;
    private String englishStoreView;
    private String allStoreViews;
    private String contentHeading;
    private String mainContent;

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ManagePagesSteps managePagesSteps;

    @Steps
    CreateNewPagesSteps createNewPagesSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    NewCMSPageSteps newCMSPageSteps;

    //Test case "Create CMS page and delete it":

    @Issue("MAt-182")
    @Pending @Test
    public void createCMSPageAndDeleteIt (){
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
        mainMenuSteps.open_CMS_Pages_Page();
        Random generator = new Random();
        int i = generator.nextInt(1000);
        String generatedUrlKey = urlKey+i;
        //create new page with filling all required fields:
        managePagesSteps.click_Add_New_Page_Button();
        createNewPagesSteps.enter_Page_Title(pageTitle);
        createNewPagesSteps.enter_Url_Key(generatedUrlKey);
        createNewPagesSteps.select_Store_View(allStoreViews);
        createNewPagesSteps.select_Status("Enabled");
        createNewPagesSteps.open_Content_Tab();
        createNewPagesSteps.enter_Content_Heading(contentHeading);
        createNewPagesSteps.enter_Main_Content(mainContent);
        createNewPagesSteps.click_Save_Page_Button();
        //remove created page
        loginPageSteps.openPage();
        mainMenuSteps.open_CMS_Pages_Page();
        managePagesSteps.filter_Pages_By_Url_Key(generatedUrlKey);
        managePagesSteps.click_First_Page_In_The_Grid();
        createNewPagesSteps.click_Delete_Page_Button_And_Confirm();
        //verification
        //managePagesSteps.verify_That_Deleted_CMS_Page_Success_Message_Is_Displayed();
    }
}
