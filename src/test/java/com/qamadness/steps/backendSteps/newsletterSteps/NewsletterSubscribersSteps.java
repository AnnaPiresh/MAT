package com.qamadness.steps.backendSteps.newsletterSteps;

import com.qamadness.pages.backend.newsletter.NewsletterSubscribersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Vladislav.E on 03.02.2016.
 */
public class NewsletterSubscribersSteps extends ScenarioSteps {

    NewsletterSubscribersPage newsletterSubscribers;

    @Step
    public void search_User_By_Email(String subscribeEmail) {
        newsletterSubscribers.searchUserByEmail(subscribeEmail);
    }

    @Step
    public void select_Subscriber() {
        newsletterSubscribers.selectSubscriber();
    }

    @Step
    public void delete_Subscriber() {
        newsletterSubscribers.deleteSubscriber();
    }

    @Step
    public void check_That_User_Was_Deleted() {
        newsletterSubscribers.checkThatUserWasDeleted();
    }

    @Step
    public void unsubscribe_Subscriber() {newsletterSubscribers.unsubscribeSubscriber();}

    @Step
    public void check_That_User_Unsubscribe() {newsletterSubscribers.checkThatUserUnsubscribe();}
}