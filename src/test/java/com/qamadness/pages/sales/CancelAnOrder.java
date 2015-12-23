package com.qamadness.pages.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelAnOrder extends PageObject{

    @FindBy(xpath = ".//button[@title='Search']")
    WebElementFacade searchBtn;

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[2]/td[1]/input")
    WebElementFacade selectOrderinput; //checkbox to tick an order

    @FindBy(xpath = ".//button[@title='Submit']")
    WebElementFacade submitBtn;

    @FindBy(xpath = ".//*[@id='messages']")
    WebElementFacade successMsg; //success message after cancelling an order

    public void seeOrdersInPendingStatus(){
        Select status_dropdown = new Select(getDriver().findElement(By.xpath(".//*[@id='sales_order_grid_filter_status']")));
        status_dropdown.selectByValue("pending");
        searchBtn.click();
    }

    public void cancelSelectedOrder(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        selectOrderinput.click();
        Select actions_dropdown = new Select(getDriver().findElement(By.xpath(".//*[@id='sales_order_grid_massaction-select']")));
        actions_dropdown.selectByValue("cancel_order");
        submitBtn.click();
    }

    public void checkCancellationSuccess(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        Assert.assertTrue("Success message is present", successMsg.isVisible());
        Assert.assertEquals("Message text is correct", "1 order(s) have been canceled.", successMsg.getText());
    }

}
