package com.qamadness.steps.backendSteps.cmsSteps.pollsSteps;

import com.qamadness.pages.backend.cms.polls.CreateNewPollPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Alexandra on 2/2/16.
 */
public class CreateNewPollSteps extends ScenarioSteps {

    CreateNewPollPage createNewPollPage;

    //Methods for Poll Information tab:

   @Step
    public void enter_Poll_Question (String question){
        createNewPollPage.enterPollQuestion(question);
    }

    @Step
    public void select_Poll_Status (String status){
        createNewPollPage.selectPollStatus(status);
    }

    @Step
    public void select_Visible_In (){
        createNewPollPage.selectVisibleIn();
    }

    //Methods for Poll Answers tab:

    @Step
    public void open_Poll_Answers_Tab (){
        createNewPollPage.openPollAnswersTab();
    }

    @Step
    public void click_Add_New_Answer_Button (){
        createNewPollPage.clickAddNewAnswerButton();
    }

    @Step
    public void enter_New_Answer_Title_And_Count (String answer, String count){
        createNewPollPage.enterNewAnswerTitleAndCount(answer, count);
    }

    //Methods for general buttons:

    @Step
    public void click_Save_Poll_Button (){
        createNewPollPage.clickSavePollButton();
    }

    @Step
    public void click_Delete_Poll_Button (){
        createNewPollPage.clickDeletePollButton();
    }

    //Verifications:

    @Step
    public void verify_That_Poll_Question_Required_Field_Message_Is_Displayed (){
        createNewPollPage.verifyThatPollQuestionRequiredFieldMessageIsDisplayed();
    }

    @Step
    public void verify_That_Answer_Title_Is_Required_Field_Message_Is_Displayed (){
        createNewPollPage.verifyThatAnswerTitleIsRequiredFieldMessageIsDisplayed();
    }

    @Step
    public void verify_That_Votes_Count_Is_Required_Field_Message_Is_Displayed (){
        createNewPollPage.verifyThatVotesCountIsRequiredFieldMessageIsDisplayed();
    }
}
