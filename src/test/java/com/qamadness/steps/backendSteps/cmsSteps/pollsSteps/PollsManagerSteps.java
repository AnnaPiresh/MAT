package com.qamadness.steps.backendSteps.cmsSteps.pollsSteps;

import com.qamadness.pages.backend.cms.polls.PollsManagerPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

/**
 * Created by Alexandra on 2/2/16.
 */
public class PollsManagerSteps extends ScenarioSteps {

    PollsManagerPage pollsManagerPage;

    //Click general buttons methods:

    @Step
    public void click_Add_New_Poll_Button (){
        pollsManagerPage.clickAddNewPollButton();
    }

    //Verifications:

    @Step
    public void verify_That_Success_Saved_Poll_Message_Is_Displayed (){
        pollsManagerPage.verifyThatSuccessSavedPollMessageIsDisplayed();
    }

    //Actions with grid:

    @Step
    public List<String> close_All_Open_Polls (){
        return pollsManagerPage.closeAllOpenPolls();
    }

    @Step
    public void open_All_Closed_Polls (List<String> closedQuestions){
        pollsManagerPage.openAllClosedPolls(closedQuestions);
    }

    @Step
    public void find_Poll_By_Question (String question){
        pollsManagerPage.findPollByQuestion(question);
    }

    @Step
    public void open_First_Poll_In_Grid (){
        pollsManagerPage.openFirstPollInGrid();
    }
}
