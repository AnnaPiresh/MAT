package com.qamadness.pages.frontend.checkout;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Anna Piresh on 01.02.2016.
 */
public class SuccessPage extends PageObject {

//---------------------------------------------Objects for Success page------------------------------------------------//

    @FindBy(xpath = ".//div[div/h1[text()='Order Success']]")
    WebElementFacade successMessageLine;

//---------------------------------------------Methods for Success page------------------------------------------------//

    public void checkOrderIsPlacedSuccessfully(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMessageLine));
        Assert.assertTrue(successMessageLine.isPresent());
    }

    public void checkTheQtyOfOrders(int expectedQty){
        int actualQty = getDriver().findElements(By.cssSelector(".multiple-checkout>p>a")).size();
        Assert.assertEquals(expectedQty,actualQty);
    }
}
