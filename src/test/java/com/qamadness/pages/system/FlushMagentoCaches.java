package com.qamadness.pages.system;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlushMagentoCaches extends PageObject{

//--------------------------------------------------Objects for Flushing Caches----------------------------------------//


    @FindBy(xpath = ".//button[@title='Flush Magento Cache']")
    WebElementFacade flushMagentoCachesBtn;

    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;

//--------------------------------------------------Methods for Flushing Caches----------------------------------------//

    public void clickFlushCacheBtn(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(flushMagentoCachesBtn));
        flushMagentoCachesBtn.click();
    }
}
