package com.qamadness.pages.frontend;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexandra on 2/9/16.
 */
public class SubCategoryPage extends PageObject {

    //Elements of poll block:

    @FindBy (xpath = ".//*[@id='pollForm']//*[@class='block-subtitle']")
    WebElementFacade pollQuestion;

    //Methods for Poll block:

    public void checkThatPollQuestionMatchesExpected (String expectedQuestion){
        String actualQuestion = pollQuestion.getText();
        Assert.assertTrue(actualQuestion.equalsIgnoreCase(expectedQuestion));
    }

}
