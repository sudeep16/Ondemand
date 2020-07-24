package com.agile.ondemand.test;

import android.app.Activity;
import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.FeedbackActivity;
import com.agile.ondemand.activity.MainActivity;
import com.agile.ondemand.activity.RegisterActivity;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class FeaEFeedbackStepdef {
    @Rule
    private ActivityTestRule<MainActivity> feedbackTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before("@review-feature")
    public void setup() {
        feedbackTestRule.launchActivity(new Intent());
    }

    @After("@review-feature")
    public void tearDown() {
        feedbackTestRule.finishActivity();
    }

    @Given("^I am in hire service screen$")
    public void iAmOnTheHireServiceDashboard(){
        onView(withId(R.id.nav_home)).perform(click());
    }

    @When("^I select a service card")
    public void isSelectCard() {
        onView(withId(R.id.cardPlumber)).perform(click());
    }

    @And("^I click on feedback button")
    public void isClickHireButton() {
        onView(withId(R.id.feedbackBtn)).perform(click());
    }

    @And("^I enter rating$")
    public void isSelectRating(){
        onView(withId(R.id.ratingBar)).perform(click());
        closeSoftKeyboard();
    }

    @And("^I enter feedback (\\S+)$")
    public void iEnterFeedback(String feedback){
        onView(withId(R.id.etFeedback)).perform(typeText(feedback));
        closeSoftKeyboard();
    }

    @And("^I click on submit button$")
    public void iClickFeedbackButton(){
        onView(withId(R.id.btnFeedback)).perform(click());
        closeSoftKeyboard();
    }
    @Then("^I should get message$")
    public void iReceiveMessage(){

    }
}
