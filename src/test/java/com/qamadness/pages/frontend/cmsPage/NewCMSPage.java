package com.qamadness.pages.frontend.cmsPage;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by Alexandra on 1/25/16.
 */
public class NewCMSPage extends PageObject {

    //Meta data:

    @FindBy (xpath = ".//meta[@name='keywords']")
    WebElementFacade keywordsMetaData;

    @FindBy (xpath = ".//meta[@name='description']")
    WebElementFacade descriptionMetaData;

    //Widgets:

    @FindBy (xpath = ".//*[@class='widget widget-cms-link-inline']")
    WebElementFacade cmsPageLinkWidget;

    @FindBy (xpath = ".//*[@class='widget widget-category-link']")
    WebElementFacade categoryLinkWidget;

    @FindBy (xpath = ".//*[@class='widget widget-static-block']")
    WebElementFacade cmsStaticBlockWidget;

    @FindBy (xpath = ".//*[@class='widget widget-new-products']")
    WebElementFacade newProductsWidget;

    @FindBy (xpath = ".//*[@class='widget widget-product-link']")
    WebElementFacade productLinkWidget;

    @FindBy (xpath = ".//*[@class='widget' and contains (.,'Orders and Returns')]")
    WebElementFacade ordersAndReturnsWidget;

    public void openCMSPage (String urlKey){
        JavascriptExecutor javascript = (JavascriptExecutor) getDriver();
        String domain=(String)javascript.executeScript("return document.domain");
        getDriver().navigate().to(domain+"/"+urlKey);
    }

    //Verifications:

    public void verifyThatPageContainsHeadingAndContent (String heading, String content){
        Assert.assertTrue(getDriver().findElement(By.xpath("//h1[contains(.,'"+heading+"')]")).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[contains(.,'"+content+"')]")).isDisplayed());
    }


    public void verifyThatThreeColumnsLayoutIsUsed (){
        Assert.assertTrue(getDriver().findElement(By.xpath(".//*[@class='main-container col3-layout']")).isDisplayed());
    }


    public void verifyThatKeywordsAreAdded (String keywords){
        Assert.assertTrue(getDriver().findElement(By.xpath(".//meta[@name='keywords']")).getAttribute("content").equalsIgnoreCase(keywords));
    }


    public void verifyThatMetaDescriptionIsAdded(String description){
        Assert.assertTrue(getDriver().findElement(By.xpath(".//meta[@name='description']")).getAttribute("content").equalsIgnoreCase(description));
    }


    public void verifyThatCMSPageLinkWidgetIsAdded (){
        Assert.assertTrue(cmsPageLinkWidget.isDisplayed());
    }


    public void verifyThatCategoryLinkWidgetIsAdded (){
        Assert.assertTrue(categoryLinkWidget.isDisplayed());
    }


    public void verifyThatCmsStaticBlockWidgetIsAdded (){
        Assert.assertTrue(cmsStaticBlockWidget.isDisplayed());
    }


    public void verifyThatNewProductsWidgetIsAdded (){
        Assert.assertTrue(newProductsWidget.isDisplayed());
    }


    public void verifyThatProductLinkWidgetIsAdded (){
        Assert.assertTrue(productLinkWidget.isDisplayed());
    }

    public void verifyThatOrdersAndReturnsWidgetIsAdded (){
        Assert.assertTrue(ordersAndReturnsWidget.isDisplayed());
    }
}
