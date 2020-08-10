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
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;


@CucumberOptions(features = "features")
public class FeaFWishlistStepdef {
    @Rule
    private ActivityTestRule<MainActivity> wishlistTestRule = new ActivityTestRule<>(MainActivity.class);
    private Activity mainActivity;

    @Before("@wishlist-feature")
    public void setup() {
        wishlistTestRule.launchActivity(new Intent());
        mainActivity = wishlistTestRule.getActivity();
    }

    @After("@wishlist-feature")
    public void tearDown() {
        wishlistTestRule.finishActivity();
    }

    @Given("^I am in a service screen$")
    public void iAmOnTheHireServiceDashboard(){
        assertNotNull(mainActivity);
        onView(withId(com.agile.ondemand.R.id.nav_home)).perform(click());
    }

    @When("^I now select a service card$")
    public void isSelectCard() {
        onView(withId(com.agile.ondemand.R.id.cardPlumber)).perform(click());
    }

    @And("^I click on add to wishlist button$")
    public void isClickWishListButton() {
        onView(withId(R.id.btnWishList)).perform(click());
    }

    @And("^I go to wishlist screen$")
    public void isAmOnWishListScreen() {
        onView(withId(R.id.nav_wishList)).perform(click());
    }

    @And("^I click on view profile$")
    public void isAmOnViewProfileScreen() {
        onView(withId(R.id.btnViewProfile)).perform(click());
    }

    @And("^I go to view post$")
    public void isAmOnViewPostScreen() {
        onView(withId(R.id.btnViewPost)).perform(click());
    }

    @Then("^I can view my post$")
    public void iViewWishList(){
    }



}
