package com.agile.ondemand.test;

import android.app.Activity;
import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.LoginActivity;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertNotNull;

public class SigninStepdefs {

    @Rule
    public ActivityTestRule<LoginActivity> signInTestRule = new ActivityTestRule<>(LoginActivity.class);

    private Activity loginActivity;

    @Before("@login-feature")
    public void setup() {
        signInTestRule.launchActivity(new Intent());
        loginActivity = signInTestRule.getActivity();
    }

    @After("@login-feature")
    public void teardown(){
        signInTestRule.finishActivity();
    }

    @cucumber.api.java.en.Given("^I am on login screen$")
    public void iAmOnTheLoginScreen(){
        assertNotNull(loginActivity);
    }

    @cucumber.api.java.en.When("^I enter username (\\S+)$")
    public void iEnterUsernameUsername(String username){
        onView(withId(R.id.etLoginUsername)).perform(typeText(username));
        closeSoftKeyboard();
    }

//    @cucumber.api.java.en.And("^I enter password (\\S+)$")
//    public void iEnterPasswordPassword(String password) {
//        onView(withId(R.id.etLoginPassword)).perform(typeText((password)));
//        closeSoftKeyboard();
//    }

    @cucumber.api.java.en.And("^I click on the login button$")
    public void iClickOnTheLoginButton() {
        onView(withId(R.id.btnLogin)).perform(click());
    }

    @Then("^I receive a field required message$")
    public void iReceiveAFieldRequiredMessage() {

        onView(withText("")).check(matches(hasErrorText("Input Password")));
    }


}
