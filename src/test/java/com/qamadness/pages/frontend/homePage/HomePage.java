package com.qamadness.pages.frontend.homePage;

import net.serenitybdd.core.pages.PageObject;

/**
 * Created by Alexandra on 1/25/16.
 */
public class HomePage extends PageObject {

    public void openHomePage() {
        getDriver().navigate().to("http://qamad:f3Vh!@www.qamadness.dev/");
        getDriver().manage().window().maximize();
    }
}
