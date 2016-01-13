package com.qamadness.pages.backend.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertEquals;

public class FilterOrdersById extends PageObject {

//------------------------------------Objects for Filtering orders by ID-----------------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid_filter_real_order_id']")
    WebElementFacade orderIdInputFld;

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr/td[2]")
    WebElementFacade firstFilteredOrder; //order displayed first in table after filtering

//------------------------------------Methods for Filtering orders by ID-----------------------------------------------//

    public void filterOrdersInGrid(String orderId) {
        orderIdInputFld.click();
        orderIdInputFld.sendKeys(orderId);
        orderIdInputFld.sendKeys(Keys.ENTER);
    }

    public void checkFilteredOrderNo(String orderId){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        assertEquals("Correct order is in grid", orderId, firstFilteredOrder.getText());
    }
}
