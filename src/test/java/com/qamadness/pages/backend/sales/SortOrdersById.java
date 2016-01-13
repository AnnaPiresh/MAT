package com.qamadness.pages.backend.sales;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertTrue;

public class SortOrdersById extends PageObject{

//------------------------------------Objects for Sorting orders by ID-----------------------------------------------//

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/thead/tr[1]/th[2]/span/a/span")
    WebElementFacade OrderNoColumnTitle; //title of the column, also clickable

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[1]/td[2]")
    WebElementFacade upperOrderInTable; //the 1st order in grid

    @FindBy(xpath = ".//*[@id='sales_order_grid_table']/tbody/tr[2]/td[2]")
    WebElementFacade lowerOrderInTable; //the 2nd order in grid

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
        assertTrue(!(secondOrderInt <= fisrtOrderInt));
    }
}
