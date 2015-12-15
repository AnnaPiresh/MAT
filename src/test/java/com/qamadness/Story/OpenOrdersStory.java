package com.qamadness.Story;

import com.qamadness.steps.OpenOrdersSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class OpenOrdersStory {

    @Steps
    OpenOrdersSteps opOrdersSteps;


    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Issue("MAT-5")
    @Test
    public void check_orders_page_is_opened() {
        opOrdersSteps.openPage();
        opOrdersSteps.loginInput();
        opOrdersSteps.ordersOpen();

    }
}
