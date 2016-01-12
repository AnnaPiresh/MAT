package com.qamadness.pages.sales;

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

public class SortOrdersByQtyPerPage extends PageObject{

//------------------------------------Objects for Sorting orders by Qty per page---------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction-count']")
    WebElementFacade qtyOfOrdersPerPageDropdown;

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction']/table/tbody/tr/td[1]/a[1]")
    WebElementFacade selectVisibleOrdersBtn;

//------------------------------------Methods for sorting orders by Qty per page---------------------------------------//

    public void canUserChangeQtyOfOrders(String value){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//select[@name='limit']"))));
        Select orders_qty = new Select(getDriver().findElement(By.xpath(".//select[@name='limit']")));
        orders_qty.selectByValue(value);
    }
    public void checkNewQtyOfOrders(){
        selectVisibleOrdersBtn.click();
        assertEquals("Qty of orders is correct","50",qtyOfOrdersPerPageDropdown.getText());
    }



}
