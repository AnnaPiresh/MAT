package com.qamadness.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenOrders extends PageObject {

    public void openPage() {

        getDriver().navigate().to("http://qamad:f3Vh!@www.qamadness.dev/admin");
    }

    @FindBy(xpath = ".//*[@id='username']")
    WebElementFacade loginInput;

    @FindBy(xpath = ".//*[@id='login']")
    WebElementFacade passInput;

    @FindBy(css = ".form-button")
    WebElementFacade loginButton;

    @FindBy(xpath = ".//*[@id='nav']/li[2]/a/span")
    WebElementFacade salesMenuItem;

    public void loginInput() {

        loginInput.sendKeys("admin");
        passInput.sendKeys("3HSYOFf");
        loginButton.click();
    }

    public void ordersSee() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.elementToBeClickable(salesMenuItem));
        getDriver().findElement(By.xpath(".//*[@id='message-popup-window']/div[1]/a/span")).click();
        salesMenuItem.click();
        getDriver().findElement(By.className(" level1")).click();


    }


}
