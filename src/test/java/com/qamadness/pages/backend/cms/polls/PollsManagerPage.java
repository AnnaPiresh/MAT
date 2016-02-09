package com.qamadness.pages.backend.cms.polls;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandra on 2/2/16.
 */
public class PollsManagerPage extends PageObject {

    CreateNewPollPage createNewPollPage;

    //General buttons:

    @FindBy(xpath = "//button[span='Add New Poll']")
    WebElementFacade addNewPollButton;

    @FindBy (xpath = "//button[span='Reset Filter']")
    WebElementFacade resetFilterButton;

    @FindBy (xpath = "//button[span='Search']")
    WebElementFacade searchButton;

    //Dropdowns:

    @FindBy (xpath = "//select[@name='visible_in']")
    WebElementFacade visibleInDropdown;

    @FindBy (xpath = "//select[@name='closed']")
    WebElementFacade statusDropdown;

    //Fields:

    @FindBy (xpath = "//input[@name='poll_id']")
    WebElementFacade idField;

    @FindBy (xpath = "//input[@name='poll_title']")
    WebElementFacade questionField;

    @FindBy (xpath = "//input[@name='votes_count[from]']")
    WebElementFacade numberOfResponsesFromField;

    @FindBy (xpath = "//input[@name='votes_count[to]']")
    WebElementFacade numberOfResponsesToField;

    @FindBy (xpath = "//input[@name='date_posted[from]']")
    WebElementFacade datePostedFromField;

    @FindBy (xpath = "//input[@name='date_posted[to]']")
    WebElementFacade datePostedToField;

    @FindBy (xpath = "//input[@name='date_closed[from]']")
    WebElementFacade dateClosedFromField;

    @FindBy (xpath = "//input[@name='date_closed[to]']")
    WebElementFacade dateClosedToField;

    //Grid:

    @FindBy (xpath = ".//*[@id='pollGrid_table']/tbody/tr")
    WebElementFacade firstElementInGrid;

    @FindBy (xpath = ".//*[@id='pollGrid_table']/tbody/tr[1]/td[2]")
    WebElementFacade firstElementQuestion;

    //Messages:

    @FindBy (xpath = "//li[normalize-space(@class)='success-msg' and contains(.,'The poll has been saved.')]")
    WebElementFacade successSavedPollMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='success-msg' and contains(.,'The poll has been deleted.')]")
    WebElementFacade successDeletedPollMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'Poll with the same question already exists.'")
    WebElementFacade existingPollMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'Your answers contain duplicates.')]")
    WebElementFacade duplicatePollAnswerMessage;

    @FindBy (xpath = "//li[normalize-space(@class)='error-msg' and contains(.,'Please, add some answers to this poll first.')]")
    WebElementFacade addAnswersMessage;

    //Click general buttons methods:

    public void clickAddNewPollButton (){
        addNewPollButton.click();
    }

    //Verifications:

    public void verifyThatSuccessSavedPollMessageIsDisplayed (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successSavedPollMessage));
        Assert.assertTrue("Success message is displayed", successSavedPollMessage.isDisplayed());
    }

    public void verifyThatSuccessDeletedPollMessageIsDisplayed (){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successDeletedPollMessage));
        Assert.assertTrue("Success message is displayed", successDeletedPollMessage.isDisplayed());
    }

    // Actions with grid:

    public List<String> closeAllOpenPolls (){
        List<String> openQuestions = new ArrayList<String>();
        statusDropdown.selectByVisibleText("Open");
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        if (getDriver().findElements(By.xpath(".//td[contains(text(),'No records found.')]")).size() == 0){
            int qtyOfOpenPolls = getDriver().findElements(By.xpath(".//*[@id='pollGrid_table']/tbody/tr")).size();
            System.out.println("Qty of elements is:" + Integer.toString(qtyOfOpenPolls));
            for (int i =0; i<qtyOfOpenPolls; i++){
                openQuestions.add(i,firstElementQuestion.getText());
                firstElementInGrid.click();
                createNewPollPage.selectPollStatus("Closed");
                createNewPollPage.clickSavePollButton();
                this.verifyThatSuccessSavedPollMessageIsDisplayed();
            }
        }
        return openQuestions;
    }

    public void openAllClosedPolls (List<String> closedQuestions){
        int qtyOfClosedQuestions = closedQuestions.size();
        if (qtyOfClosedQuestions>0){
            for (int i=0; qtyOfClosedQuestions>i; i++){
                System.out.println(closedQuestions.get(i));
                //Find element by question and status "Closed":
                questionField.type(closedQuestions.get(i));
                statusDropdown.selectByVisibleText("Closed");
                searchButton.click();
                WebDriverWait wait = new WebDriverWait(getDriver(), 60);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
                //Open found element and change status to "Open":
                firstElementInGrid.click();
                createNewPollPage.selectPollStatus("Open");
                createNewPollPage.clickSavePollButton();
                this.verifyThatSuccessSavedPollMessageIsDisplayed();
            }
        }
    }

    public void findPollByQuestion (String question){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        resetFilterButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        questionField.type(question);
        searchButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
    }

    public void openFirstPollInGrid (){
        firstElementInGrid.click();
    }
}
