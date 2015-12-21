package com.qamadness.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertEquals;

public class SortingAndFilteringOfOrders extends PageObject{

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction-count']")
    WebElementFacade qtyOfOrdersPerPageDropdown;

    public void canUserChangeQtyOfOrders(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//select[@name='limit']"))));
        Select orders_qty = new Select(getDriver().findElement(By.xpath(".//select[@name='limit']")));
        orders_qty.selectByValue("50");
    }
    public void checkNewQtyOfOrders(){
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("return sales_order_grid_massactionJsObject.selectVisible()");
        assertEquals("Qty of orders is correct","50",qtyOfOrdersPerPageDropdown.getText());
    }



}
