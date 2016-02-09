package com.qamadness.pages.backend.cms.polls;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexandra on 2/2/16.
 */
public class CreateNewPollPage extends PageObject {

    //Tabs:

    @FindBy (xpath = "//a[@title='Poll Information']/span")
    WebElementFacade pollInformationTab;

    @FindBy (xpath = "//a[@title='Poll Answers']/span")
    WebElementFacade pollAnswersTab;

    //Elements on Poll Information tab:

    @FindBy (xpath = "//select[@id='closed']")
    WebElementFacade pollStatusDropdown;

    @FindBy (xpath = "//input[@id='poll_title']")
    WebElementFacade pollQuestionField;

    @FindBy (xpath = "//select[@name='store_ids[]']")
    WebElementFacade visibleInMultiselect;

    //Elements on Poll Answers tab:

    @FindBy (xpath = "//button[span='Add New Answer']")
    WebElementFacade addNewAnswerButton;

    @FindBy (xpath = ".//*[@id='answer_-1']")
    WebElementFacade firstAnswerTitleField;

    @FindBy (xpath = ".//*[@id='answer_votes_-1']")
    WebElementFacade firstVotesCountField;

    //General buttons:

    @FindBy (xpath = "//button[span='Back']")
    WebElementFacade backButton;

    @FindBy (xpath = "//button[span='Reset']")
    WebElementFacade resetButton;

    @FindBy (xpath = "//button[span='Save Poll']")
    WebElementFacade savePollButton;

    @FindBy (xpath = "//button[span='Delete Poll']")
    WebElementFacade deletePollButton;

    //Methods for Poll Information tab:

    public void enterPollQuestion (String question){
        pollQuestionField.type(question);
    }

    public void selectPollStatus (String status){
        pollStatusDropdown.selectByVisibleText(status);
    }

    public void selectVisibleIn (){
        visibleInMultiselect.selectByIndex(0);
    }

    //Methods for Poll Answers tab:

    public void openPollAnswersTab (){
        pollAnswersTab.click();
    }

    public void clickAddNewAnswerButton (){
        addNewAnswerButton.click();
    }

    public void enterNewAnswerTitleAndCount (String answer, String count){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(firstAnswerTitleField));
        firstAnswerTitleField.type(answer);
        firstVotesCountField.type(count);
    }

    //Methods for general buttons:

    public void clickSavePollButton (){
        savePollButton.click();
    }

    public void clickDeletePollButton (){
        deletePollButton.click();
        getDriver().switchTo().alert().accept();
    }


}
