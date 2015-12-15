package com.qamadness.Story;

import com.qamadness.steps.OpOrdersSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class OpOrdersStory {

    @Steps
    OpOrdersSteps opOrdersSteps;
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Test
    public void loggingIn() {
        opOrdersSteps.openPage();
        opOrdersSteps.loginInput();
        opOrdersSteps.ordersSe();
    }
}
