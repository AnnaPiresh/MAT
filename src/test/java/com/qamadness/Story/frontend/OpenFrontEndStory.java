package com.qamadness.Story.frontend;

import com.qamadness.steps.frontend.HomepageSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpenFrontEndStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    HomepageSteps homepageSteps;

    @Pending
    @Test
    public void openWebsitePage(){
        homepageSteps.open_website();
        homepageSteps.open_product_overview_page();
    }

}
