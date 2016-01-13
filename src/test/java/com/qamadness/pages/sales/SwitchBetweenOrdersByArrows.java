package com.qamadness.pages.sales;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertEquals;


public class SwitchBetweenOrdersByArrows extends PageObject{

//------------------------------------Objects for Switching Between orders by arrows------------------------------------//

    @FindBy(xpath = ".//*[@alt='Go to Next page']")
    WebElementFacade nextPageArrow;

    @FindBy(xpath = ".//*[@id='sales_order_grid']/table/tbody/tr/td[1]/input")
    WebElementFacade fieldWithPageNo;  //number of pages of orders user is now at

    @FindBy(xpath = ".//*[@alt='Go to Previous page']")
    WebElementFacade previousPageArrow;

//------------------------------------Methods for Switching Between orders by arrows------------------------------------//

    public void switchToNextOrdersPage(String nextPage){
        nextPageArrow.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        assertEquals("User is redirected to next page",nextPage, fieldWithPageNo.getValue());
    }

    public void switchToPreviousOrdersPage(String previousPage){
        previousPageArrow.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        assertEquals("User is redirected to previous page", previousPage, fieldWithPageNo.getValue());
    }

}
