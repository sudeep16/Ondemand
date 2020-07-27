package com.agile.ondemand.test;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

import androidx.test.rule.ActivityTestRule;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.MainActivity;

import org.junit.Rule;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertNotNull;

@CucumberOptions(features = "features")
public class FeaGProfileStepdef {

    @Rule
    private ActivityTestRule<MainActivity> profileTestRule = new ActivityTestRule<>(MainActivity.class);
    private Activity mainActivity;

    @Before("@profile-feature")
    public void setup() {
        profileTestRule.launchActivity(new Intent());
        mainActivity = profileTestRule.getActivity();
    }

    @After("@profile-feature")
    public void tearDown() {
        profileTestRule.finishActivity();
    }

    @Given("^I am in home screen$")
    public void iAmOnTheHomeDashboard(){
        assertNotNull(mainActivity);
        onView(withId(R.id.nav_home)).perform(click());
    }

    @When("^I click on profile$")
        public void iAmOnProfile(){
        onView(withId(R.id.nav_profile)).perform(click());
        }

    @And("^I erase and add new phone number (\\S+)$")
    public void iUpdatePhone(String phone) {
        onView(withId(R.id.etPPhone))
                .perform(replaceText(phone))
                .perform(click())
                .perform(pressKey(KeyEvent.KEYCODE_DEL));
        closeSoftKeyboard();
    }

    @And("^I click on update button$")
    public void isClickUpdateButton() {
        onView(withId(R.id.btnPUpdate)).perform(click());
    }

    @Then("^I should receive updated message$")
    public void iGetMessage(){

    }

}
