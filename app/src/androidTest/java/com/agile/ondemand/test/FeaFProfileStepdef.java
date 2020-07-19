package com.agile.ondemand.test;

import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.MainActivity;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FeaFProfileStepdef {
    @Rule
    private ActivityTestRule<MainActivity> profileTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before("@profile-feature")
    public void setup() {
        profileTestRule.launchActivity(new Intent());
    }

    @After("@profile-feature")
    public void tearDown() {
        profileTestRule.finishActivity();
    }

    @cucumber.api.java.en.Given("^I am at profile screen$")
    public void iAmOnTheProfileDashboard(){
    onView(withId(R.id.nav_profile)).perform(click());    }

    @When("^I change address (\\S+)$")
    public void iChangeAddress(String address) {
        onView(withId(R.id.etPAddresss)).perform(typeText(address));
    }
    @cucumber.api.java.en.And("^I change phone number (\\S+)$")
    public void iChangePhoneNumber(String phone) {
        onView(withId(R.id.etPPhone)).perform(typeText(phone));
    }
    @cucumber.api.java.en.And("^I click update button$")
    public void iClickOnUpdateButton() {
        onView(withId(R.id.btnPUpdate)).perform(click());
    }
    @cucumber.api.java.en.Then("^I should receive updated message$")
    public void iReceiveUpdateMessage() {

    }
}