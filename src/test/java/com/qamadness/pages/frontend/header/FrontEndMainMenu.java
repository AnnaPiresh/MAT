package com.qamadness.pages.frontend.header;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

/**
 * Created by Alexandra on 2/8/16.
 */
public class FrontEndMainMenu extends PageObject {

    //Methods:

    public void openCategoryByName (String categoryName){
        getDriver().findElement(By.xpath("//a[contains(.,'"+categoryName+"')]")).click();
    }
}
