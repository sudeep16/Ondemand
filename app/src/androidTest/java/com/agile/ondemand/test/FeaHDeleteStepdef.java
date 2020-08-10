package com.agile.ondemand.test;

import android.app.Activity;
import android.content.Intent;

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

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;

@CucumberOptions(features = "features")
public class FeaHDeleteStepdef {
        @Rule
        private ActivityTestRule<MainActivity> deletewishlistTestRule = new ActivityTestRule<>(MainActivity.class);
        private Activity mainActivity;

        @Before("@delete-feature")
        public void setup() {
            deletewishlistTestRule.launchActivity(new Intent());
            mainActivity = deletewishlistTestRule.getActivity();
        }

        @After("@delete-feature")
        public void tearDown() {
            deletewishlistTestRule.finishActivity();
        }

        @Given("^I am in service screen$")
        public void iAmOnTheServiceDashboard(){
            assertNotNull(mainActivity);
            onView(withId(com.agile.ondemand.R.id.nav_home)).perform(click());
        }

        @When("^I browse to wishlist screen$")
        public void isSelectOnWishlist() {
            onView(withId(R.id.nav_wishList)).perform(click());
        }

        @And("^I click on delete button$")
        public void isClickDeleteButton() {
            onView(withId(R.id.btnRemove)).perform(click());
        }

        @Then("^I can view delete success message$")
        public void iViewDeleteMessage(){
        }





}
