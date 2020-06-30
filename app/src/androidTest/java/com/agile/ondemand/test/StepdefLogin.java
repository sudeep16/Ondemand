package com.agile.ondemand.test;

import com.agile.ondemand.R;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class StepdefLogin {

    @Given("^A user is at a \"([^\"]*)\" screen$")
    public void aUserIsAtAScreen(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I input an username, test123")
    public void I_input_an_username() {
        onView(withId(com.agile.ondemand.R.id.etLoginUsername)).perform(typeText("test123"));
    }

    @And("^I input a password, test")
    public void I_input_a_password() {
        onView(withId(com.agile.ondemand.R.id.etLoginPassword)).perform(typeText("test"));
    }

    @And("^I press login button$")
    public void iPressLoginButton() {
        onView(withId(R.id.btnLogin)).perform(click());
    }

    @Then("^I should receive message login success$")
    public void iShouldReceiveMessageLoginSuccess() {
    }
}
