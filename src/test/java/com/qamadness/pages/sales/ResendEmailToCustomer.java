package com.qamadness.pages.sales;


import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResendEmailToCustomer extends PageObject{

    @FindBy(xpath = ".//button[@title='Send Email']")
    WebElementFacade sendEmailBtn;
    //button that resends an email to a customer

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMesg;


    public void clickSendEmailBtn(){
        if (sendEmailBtn.isVisible()){
            sendEmailBtn.click();
        } else {
            Assert.fail("Send email button is not present on order's page");
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void checkSuccessMsgPresent(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMesg));
        if (successMesg.containsText("The order email has been sent.")){
            System.out.println("Email to order is successfully sent");
        } else {
            Assert.fail("Email to order is not sent");
        }
    }


}
