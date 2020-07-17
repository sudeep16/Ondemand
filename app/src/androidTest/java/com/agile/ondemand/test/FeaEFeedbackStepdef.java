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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class FeaEFeedbackStepdef {
    @Rule
    private ActivityTestRule<FeedbackActivity> feedbackTestRule = new ActivityTestRule<>(FeedbackActivity.class);
    private Activity feedbackActivity;

    @Before("@review-feature")
    public void setup() {
        feedbackTestRule.launchActivity(new Intent());
        feedbackActivity = feedbackTestRule.getActivity();
    }

    @After("@review-feature")
    public void tearDown() {
        feedbackTestRule.finishActivity();
    }
    @cucumber.api.java.en.Given("^I am on feedback service screen$")
    public void iAmOnTheHireServiceDashboard(){
        assertNotNull(feedbackActivity);
    }

    @When("^I enter rating$")
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
//        onView(withId(R.id.btnFeedback)).perform(click());
//        closeSoftKeyboard();
    }
    @Then("^I should get message$")
    public void iReceiveMessage(){

    }
}
