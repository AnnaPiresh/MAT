package com.qamadness.pages.backend.sales;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by Serhii_Boiko on 14.01.2016.
 */
public class ManageOrders extends PageObject {

//-------------------------------------Objects for Canceling Order----------------------------------------------------//

    @FindBy(xpath = ".//button[@title='Search']")
    WebElementFacade searchBtn;

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[2]/td[1]/input")
    WebElementFacade selectOrderInput;
    //checkbox to tick an order

    @FindBy(xpath = ".//*[@id='sales_order_grid_filter_status']")
    WebElementFacade statusDropdown;

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction-select']")
    WebElementFacade actionsDropdown;

    @FindBy(xpath = ".//button[@title='Submit']")
    WebElementFacade submitBtn;

//------------------------------------Objects for Filtering orders by ID-----------------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid_filter_real_order_id']")
    WebElementFacade orderIdInputFld;

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr/td[2]")
    WebElementFacade firstFilteredOrder; //order displayed first in table after filtering

    @FindBy(xpath = ".//button[@title='Reset Filter']")
    WebElementFacade resetFilterBtn; //Reset Filter button

//------------------------------------Objects for Navigating to Particular page-----------------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid']/table/tbody/tr/td[1]/input")
    WebElementFacade fieldWithPageNo;  //number of pages of orders user is now at

//------------------------------------Objects for Sorting orders by ID-----------------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/thead/tr[1]/th[2]/span/a/span")
    WebElementFacade OrderNoColumnTitle; //title of the column, also clickable

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[1]/td[2]")
    WebElementFacade upperOrderInTable; //the 1st order in grid

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[2]/td[2]")
    WebElementFacade lowerOrderInTable; //the 2nd order in grid

//------------------------------------Objects for Sorting orders by Qty per page---------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction-count']")
    WebElementFacade qtyOfOrdersPerPageDropdown;

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction']/table/tbody/tr/td[1]/a[1]")
    WebElementFacade selectVisibleOrdersBtn;

    @FindBy(xpath = ".//*[@id='sales_order_grid_massaction']/table/tbody/tr/td[1]/a[2]")
    WebElementFacade unselectVisibleOrdersBtn;

//------------------------------------Objects for Switching Between orders by arrows------------------------------------//

    @FindBy(xpath = ".//*[@alt='Go to Next page']")
    WebElementFacade nextPageArrow;

    @FindBy(xpath = ".//*[@alt='Go to Previous page']")
    WebElementFacade previousPageArrow;

//-------------------------------Objects for Success Messages---------------------------------------------------------//
    @FindBy(xpath = ".//*[@class='success-msg']")
    WebElementFacade successMsg;



//---------------------------------------Methods for Canceling Order--------------------------------------------------//

    public void seeOrdersInPendingStatus(String status){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown));
        statusDropdown.click();
        statusDropdown.selectByValue(status).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        searchBtn.click();
    }

    public void cancelSelectedOrder(String action){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        selectOrderInput.click();
        actionsDropdown.click();
        actionsDropdown.selectByValue(action).click();
        submitBtn.click();
    }

//------------------------------------Methods for Filtering orders by ID-----------------------------------------------//

    public void filterOrdersInGrid(String orderId) {
        orderIdInputFld.click();
        orderIdInputFld.sendKeys(orderId);
        orderIdInputFld.sendKeys(Keys.ENTER);
    }

    public void checkFilteredOrderNo(String orderId){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        Assert.assertEquals("Correct order is in grid", orderId, firstFilteredOrder.getText());
    }

    public void resetFilter(){
        resetFilterBtn.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
    }

//------------------------------------Methods for Navigating to Particular Page-----------------------------------------------//

    public void enterOrdersPage(String ordersPage) {
        fieldWithPageNo.click();
        fieldWithPageNo.clear();
        fieldWithPageNo.sendKeys(ordersPage);
        fieldWithPageNo.sendKeys(Keys.ENTER);
    }

    public void checkThePageIsCorrect(String ordersPage){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        Assert.assertEquals("The page is correct", ordersPage, fieldWithPageNo.getValue());
    }

//------------------------------------Methods for Sorting orders by ID-----------------------------------------------//

    public void changeSortOrderById(){
        OrderNoColumnTitle.click();
    }

    public void checkThatSortingChanged(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        String firstOrder = upperOrderInTable.getText();
        String secondorder = lowerOrderInTable.getText();
        int fisrtOrderInt = Integer.parseInt(firstOrder);
        int secondOrderInt = Integer.parseInt(secondorder);
        Assert.assertTrue(!(secondOrderInt <= fisrtOrderInt));
    }

//------------------------------------Methods for sorting orders by Qty per page---------------------------------------//

    public void canUserChangeQtyOfOrders(String value){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(".//select[@name='limit']"))));
        Select orders_qty = new Select(getDriver().findElement(By.xpath(".//select[@name='limit']")));
        orders_qty.selectByValue(value);
    }
    public void checkNewQtyOfOrders(){
        selectVisibleOrdersBtn.click();
        Assert.assertEquals("Qty of orders is correct","50",qtyOfOrdersPerPageDropdown.getText());
    }

    public void unselectOrders(){
        unselectVisibleOrdersBtn.click();
    }

 //------------------------------------Methods for Switching Between orders by arrows------------------------------------//

    public void switchToNextOrdersPage() {
        String firstPageValue = fieldWithPageNo.getValue();
        int firstValue = Integer.parseInt(firstPageValue);
        nextPageArrow.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        String secondPageValue = fieldWithPageNo.getValue();
        int secondValue = Integer.parseInt(secondPageValue);
        Assert.assertTrue(secondValue>firstValue);
    }


    public void switchToPreviousOrdersPage() {
        String firstPageValue = fieldWithPageNo.getValue();
        int firstValue = Integer.parseInt(firstPageValue);
        previousPageArrow.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='loading_mask_loader']")));
        String secondPageValue = fieldWithPageNo.getValue();
        int secondValue = Integer.parseInt(secondPageValue);
        Assert.assertTrue(secondValue<firstValue);
    }

//-------------------------------Methods for Success Messages---------------------------------------------------------//

    public void checkSuccessMsg(String message){
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        if (successMsg.containsText(message)){
            System.out.println("Success message is present");
        } else {
            Assert.fail("Success message is not present");
        }
    }



}
