package com.qamadness.pages.backend.newsletter;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.is;

/**
 * Created by Vladislav.E on 03.02.2016.
 */
public class NewsletterSubscribersPage extends PageObject {

    @FindBy(xpath = ".//input[@id='subscriberGrid_filter_email']")
    WebElementFacade searchByEmailField;

    @FindBy(xpath = ".//*[@id='subscriberGrid_table']/tbody/tr/td[3]")
    WebElementFacade searchResult;

    @FindBy(xpath = ".//*[@id='subscriberGrid_table']/tbody/tr/td[1]/input")
    WebElementFacade selectCheckbox;

    @FindBy(xpath = ".//*[@id='subscriberGrid_massaction-select']")
    WebElementFacade actionsDropdown;

    @FindBy(xpath = ".//*[@type='button'][@title='Submit']")
    WebElementFacade submitBtn;

    @FindBy(xpath = ".//*[@class='empty-text a-center'][@colspan='11']")
    WebElementFacade noRecordsMsg;

    @FindBy(xpath = ".//*[@id='messages']/ul/li/ul/li/span")
    WebElementFacade successMsg;


    public void searchUserByEmail(String subscribeEmail) {
        searchByEmailField.sendKeys(subscribeEmail);
        searchByEmailField.sendKeys(Keys.ENTER);
    }

    public void selectSubscriber() {selectCheckbox.click();}

    public void deleteSubscriber() {
        Select dropdown = new Select(actionsDropdown);
        dropdown.selectByValue("delete");
        submitBtn.click();}

    public void checkThatUserWasDeleted() {Assert.assertThat(noRecordsMsg.getText(), is("No records found."));}

    public void unsubscribeSubscriber() {
        Select dropdown = new Select(actionsDropdown);
        dropdown.selectByValue("unsubscribe");
        submitBtn.click();
    }

    public void checkThatUserUnsubscribe() {Assert.assertThat(successMsg.getText(),is("Total of 1 record(s) were updated"));}

}