package com.qamadness.pages.sales;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;


public class NavigateToParticularOrdersPage extends PageObject{

    @FindBy(xpath = ".//*[@id='sales_order_grid']/table/tbody/tr/td[1]/input")
    WebElementFacade fieldWithPageNo;  //number of pages of orders user is now at

    public void enterOrdersPage() {
        fieldWithPageNo.click();
        fieldWithPageNo.clear();
        fieldWithPageNo.sendKeys("5");
        fieldWithPageNo.sendKeys(Keys.ENTER);
    }

    public void checkThePageIsCorrect(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        assertEquals("The page is correct", "5", fieldWithPageNo.getValue());
    }

}
