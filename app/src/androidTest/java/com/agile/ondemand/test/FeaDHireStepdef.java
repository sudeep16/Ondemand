package com.agile.ondemand.test;

import android.content.Intent;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.rule.ActivityTestRule;
import com.agile.ondemand.R;
import com.agile.ondemand.activity.HireActivity;
import com.agile.ondemand.activity.MainActivity;
import org.hamcrest.Matchers;
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
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class FeaDHireStepdef {
    @Rule
    private ActivityTestRule<MainActivity> hireTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before("@hire-feature")
    public void setup() {
        hireTestRule.launchActivity(new Intent());
    }

    @After("@hire-feature")
    public void tearDown() {
        hireTestRule.finishActivity();
    }

    @Given("^I am on hire service screen$")
    public void iAmOnTheHireServiceDashboard() {
        onView(withId(R.id.nav_home)).perform(click());
    }

    @When("^I select a card")
    public void isSelectCard() {
        onView(withId(R.id.cardPlumber)).perform(click());
    }

    @And("^I click on hire button")
    public void isClickHireButton() {
        onView(withId(R.id.btnHire)).perform(click());
    }

    @And("^I enter payment method$")
    public void isSelectPaymentType() {
        onView(withId(R.id.Spinner1)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Cash on Delivery"))).perform(click());
    }

    @And("^I enter location (\\S+)$")
    public void iEnterLocation(String location) {
        onView(withId(R.id.etLocation)).perform(typeText(location));
    }

    @And("^I pick a date$")
    public void iPickADate() {
        onView(withId(R.id.tvDatePicker)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020, 12, 12));
        onView(withText("OK")).perform(click());
    }

    @And("^I enter time$")
    public void iEnterTime() {
        onView(withId(R.id.tvHireTime)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(11, 30));
        onView(withText("OK")).perform(click());
    }

    @And("^I click on confirm button$")
    public void iClickPostButton() {
        onView(withId(R.id.btnConfirm)).perform(click());
        closeSoftKeyboard();
    }

    @Then("^I should get notification$")
    public void iReceiveNotification() {

    }


}