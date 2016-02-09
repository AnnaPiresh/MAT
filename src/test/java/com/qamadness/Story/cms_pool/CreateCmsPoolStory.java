package com.qamadness.Story.cms_pool;

import com.qamadness.steps.backendSteps.LoginPageSteps;
import com.qamadness.steps.backendSteps.MainMenuSteps;
import com.qamadness.steps.backendSteps.catalogSteps.ManageCategoriesSteps.ManageCategoriesPageSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pollsSteps.CreateNewPollSteps;
import com.qamadness.steps.backendSteps.cmsSteps.pollsSteps.PollsManagerSteps;
import com.qamadness.steps.backendSteps.dashboardSteps.DashboardSteps;
import com.qamadness.steps.backendSteps.systemSteps.ConfigurationPageSteps;
import com.qamadness.steps.frontendSteps.SubCategoryPageSteps;
import com.qamadness.steps.frontendSteps.headerSteps.FrontEndMainMenuSteps;
import com.qamadness.steps.frontendSteps.homePageSteps.HomePageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Alexandra on 2/2/16.
 */

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/cms_poll/CreateCmsPoolData.csv")
public class CreateCmsPoolStory {

    //Data in CSV file:

    private String adminLogin;
    private String adminPassword;
    private String pollQuestion;
    private String visibleIn;
    private String answerTitle;
    private String votesCount;
    public String categoryName = "Robot Test Category";

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    LoginPageSteps loginPageSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    MainMenuSteps mainMenuSteps;

    @Steps
    ConfigurationPageSteps configurationPageSteps;

    @Steps
    PollsManagerSteps pollsManagerSteps;

    @Steps
    ManageCategoriesPageSteps manageCategoriesPageSteps;

    @Steps
    CreateNewPollSteps createNewPollSteps;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    FrontEndMainMenuSteps frontEndMainMenuSteps;

    @Steps
    SubCategoryPageSteps subCategoryPageSteps;

     /*Precondition for each test:
    * 1) Clear cookies and l ogin as admin user
    */

    @Before
    public void preconditionForEachTest() {
        getDriver().manage().deleteAllCookies();
        loginPageSteps.openPage();
        loginPageSteps.loginInput(adminLogin);
        loginPageSteps.passInput(adminPassword);
        loginPageSteps.loginButton();
        dashboardSteps.closePopup();
    }

    //Test case "Create new CMS Pool":

    @Issue("MAT-183")
    @Pending @Test
    public void createNewCmsPool() {
        /*Precondition:
       * 1) Create new sub-category
       * 2) Navigate to CMS -> Polls
       * 3) Close all open polls and remember their questions*/
        mainMenuSteps.openManageCategoriesPage();
        manageCategoriesPageSteps.selectCategoryByName("Default");
        manageCategoriesPageSteps.addNewSubCategory();
        manageCategoriesPageSteps.enterCategoryName(categoryName);
        manageCategoriesPageSteps.selectCategoryActivity("Yes");
        manageCategoriesPageSteps.saveCategory();
        manageCategoriesPageSteps.checkSuccessMessage();
        mainMenuSteps.open_Cms_Polls_Page();
        List<String> closedQuestions = pollsManagerSteps.close_All_Open_Polls();
        //Create new open poll:
        pollsManagerSteps.click_Add_New_Poll_Button();
        createNewPollSteps.enter_Poll_Question(pollQuestion);
        createNewPollSteps.select_Poll_Status("Open");
        createNewPollSteps.select_Visible_In();
        createNewPollSteps.open_Poll_Answers_Tab();
        createNewPollSteps.click_Add_New_Answer_Button();
        createNewPollSteps.enter_New_Answer_Title_And_Count(answerTitle, votesCount);
        createNewPollSteps.click_Save_Poll_Button();
        /* Verifications:
        * 1) Check that success message was displayed after poll is saved
        * 2) Check that poll is displayed on the created sub-category page*/
        pollsManagerSteps.verify_That_Success_Saved_Poll_Message_Is_Displayed();
        homePageSteps.open_Home_Page();
        frontEndMainMenuSteps.open_Category_By_Name(categoryName);
        subCategoryPageSteps.check_That_Poll_Question_Matches_Expected(pollQuestion);
        /*Post-condition:
        * 1) Go to admin and open all polls that were closed
        * 2) Remove created poll
        * 3) Remove created sub-category*/
        loginPageSteps.openPage();
        mainMenuSteps.open_Cms_Polls_Page();
        pollsManagerSteps.open_All_Closed_Polls(closedQuestions);
        pollsManagerSteps.find_Poll_By_Question(pollQuestion);
        pollsManagerSteps.open_First_Poll_In_Grid();
        createNewPollSteps.click_Delete_Poll_Button();
        mainMenuSteps.openManageCategoriesPage();
        manageCategoriesPageSteps.selectCategoryByName(categoryName);
        manageCategoriesPageSteps.deleteCategory();
    }

    //Test case "Create CMS poll with empty required fields"

    @Issue("MAT-184")
    @Pending @Test
    public void createCmsPollWithEmptyRequiredFields (){
        //Create new CMS poll with empty required fields:
        mainMenuSteps.open_Cms_Polls_Page();
        pollsManagerSteps.click_Add_New_Poll_Button();
        createNewPollSteps.enter_Poll_Question("");
        createNewPollSteps.select_Poll_Status("Open");
        createNewPollSteps.select_Visible_In();
        createNewPollSteps.open_Poll_Answers_Tab();
        createNewPollSteps.click_Add_New_Answer_Button();
        createNewPollSteps.enter_New_Answer_Title_And_Count("", "");
        createNewPollSteps.click_Save_Poll_Button();
        /*Verifications:
        * 1) Check that error message is displayed*/
        createNewPollSteps.verify_That_Poll_Question_Required_Field_Message_Is_Displayed();
        createNewPollSteps.open_Poll_Answers_Tab();
        createNewPollSteps.verify_That_Answer_Title_Is_Required_Field_Message_Is_Displayed();
        createNewPollSteps.verify_That_Votes_Count_Is_Required_Field_Message_Is_Displayed();
    }

    // Test case "Create CMS poll without answers"

    @Issue("MAT-185")
    @Pending @Test
    public void createCmsPollWithoutAnswers (){
        //Create new CMS poll without answers:
        mainMenuSteps.open_Cms_Polls_Page();
        pollsManagerSteps.click_Add_New_Poll_Button();
        createNewPollSteps.enter_Poll_Question(pollQuestion);
        createNewPollSteps.select_Poll_Status("Open");
        createNewPollSteps.select_Visible_In();
        createNewPollSteps.click_Save_Poll_Button();
        /*Verifications:
        * 1) Check that error message is displayed*/
        createNewPollSteps.verify_That_Add_Some_Answers_Error_Message_Is_Displayed();
    }

}
