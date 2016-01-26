package com.qamadness.pages.frontend.cmsPage;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by Alexandra on 1/25/16.
 */
public class NewCMSPage extends PageObject {

    //Page elements:

    public void openCMSPage (String urlKey){
        JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
        String domain=(String)javascript.executeScript("return document.domain");
        getDriver().navigate().to(domain+"/"+urlKey);
    }

    //Verifications:

    public void verifyThatPageContainsHeadingAndContent (String heading, String content){
        Assert.assertTrue(getDriver().findElement(By.xpath("//h1[contains(.,'"+heading+"')]")).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(.,'"+content+"')]")).isDisplayed());
    }

}
