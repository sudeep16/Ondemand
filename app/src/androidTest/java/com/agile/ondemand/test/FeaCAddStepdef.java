package com.agile.ondemand.test;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.rule.ActivityTestRule;

import com.agile.ondemand.activity.LoginActivity;
import com.agile.ondemand.activity.MainActivity;
import com.agile.ondemand.fragments.AddFragment;
import com.agile.ondemand.R;

import org.hamcrest.Matchers;
import org.junit.Rule;

import java.util.Calendar;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.Calendar.AM;
import static java.util.Calendar.AM_PM;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class FeaCAddStepdef {
    @Rule
    private ActivityTestRule<MainActivity> mainTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before("@exp-feature")
    public void setup() {
        mainTestRule.launchActivity(new Intent());
    }

    @After("@exp-feature")
    public void tearDown() {
        mainTestRule.finishActivity();
    }
    @cucumber.api.java.en.Given("^I am on add service screen$")
    public void iAmOnTheAddServiceDashboard(){
        onView(withId(R.id.nav_add)).perform(click());
    }

    @When("^I select category$")
    public void isSelectType(){
        onView(withId(R.id.Spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Plumber"))).perform(click());
    }

    @And("^I enter description (\\S+)$")
    public void iEnterDescription(String description){
        onView(withId(R.id.etDescription)).perform(typeText(description));
    }

    @And("^I enter starting time$")
    public void iEnterStartTime(){

        onView(withId(R.id.time1)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(9, 30));
        onView(withText("OK")).perform(click());
    }


    @And("^I enter closing time$")
    public void iEnterCloseTime(){
        onView(withId(R.id.time2)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(16, 30));
        onView(withText("OK")).perform(click());
    }

    @And("^I enter starting day (\\S+)$")
    public void iEnterStartDay(String start_day){
        onView(withId(R.id.etDaysFrom)).perform(typeText(start_day));
    }

    @And("^I enter ending day (\\S+)$")
    public void iEnterEndDay(String end_day){
        onView(withId(R.id.etDaysTo)).perform(typeText(end_day));
    }

    @And("^I enter price (\\S+)$")
    public void iEnterPrice(String price){
        onView(withId(R.id.etPrice)).perform(typeText(price));
    }

    @And("^I click on post button$")
    public void iClickPostButton(){
        onView(withId(R.id.btnPost)).perform(click());
    }

    @Then("^I receive a success message$")
    public void iReceiveSuccessMessage(){

    }

}