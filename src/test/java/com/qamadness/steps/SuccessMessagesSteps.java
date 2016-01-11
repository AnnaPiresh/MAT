package com.qamadness.steps;


import com.qamadness.pages.SuccessMessages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SuccessMessagesSteps extends ScenarioSteps{
    SuccessMessages successMessages;

    @Step
    public void check_success_message(String message) {successMessages.checkSuccessMsg(message);}
}
