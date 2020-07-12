package com.agile.ondemand.test;

import android.app.Activity;
import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import com.agile.ondemand.R;
import com.agile.ondemand.activity.RegisterActivity;

import org.junit.Rule;

import cucumber.api.CucumberOptions;
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

@CucumberOptions(features = "features")
public class FeaASignupStepdef {

    @Rule
    private ActivityTestRule<RegisterActivity> signUpTestRule = new ActivityTestRule<>(RegisterActivity.class);
    private Activity registerActivity;

    @Before("@register-feature")
    public void setup() {
        signUpTestRule.launchActivity(new Intent());
        registerActivity = signUpTestRule.getActivity();
    }

    @After("@register-feature")
    public void tearDown(){
        signUpTestRule.finishActivity();
    }

    @cucumber.api.java.en.Given("^I am at register screen$")
    public void iAmOnTheSignUpScreen() {
        assertNotNull(registerActivity);
    }

    @cucumber.api.java.en.When("^I input a firstName (\\S+)$")
    public void iInputFirstNameFirstName(String firstName) {
        onView(withId(R.id.etFirstName)).perform(typeText(firstName));
    }

    @cucumber.api.java.en.And("^I input a lastName (\\S+)$")
    public void iInputLastNameLastName(String lastName) {
        onView(withId(R.id.etLastName)).perform(typeText(lastName));
    }

    @cucumber.api.java.en.And("^I input an address (\\S+)$")
    public void iInputAddressAddress(String address) {
        onView(withId(R.id.etAddress)).perform(typeText(address));
    }

    @cucumber.api.java.en.And("^I input a username (\\S+)$")
    public void iInputUserName(String username) {
        onView(withId(R.id.etUsername)).perform(typeText(username));
    }

    @cucumber.api.java.en.And("^I input an email (\\S+)$")
    public void iInputEmail(String email) {
        onView(withId(R.id.etEmail)).perform(typeText(email));
    }

    @cucumber.api.java.en.And("^I input a phone (\\S+)$")
    public void iInputPhone(String phone) {
        onView(withId(R.id.etPhone)).perform(typeText(phone));
    }

    @cucumber.api.java.en.And("^I input a gender (\\S+)$")
    public void iInputGender(String gender) {
        onView(withId(R.id.rbMale)).perform(click());
    }

    @cucumber.api.java.en.And("^I input a password (\\S+)$")
    public void iInputPassword(String password) {
        onView(withId(R.id.etPassword)).perform(typeText(password));
        closeSoftKeyboard();
    }

    @cucumber.api.java.en.And("^I input a confirm password (\\S+)$")
    public void iInputConfirmPassword(String confirmPassword) {
        onView(withId(R.id.etConfirmPassword)).perform(typeText(confirmPassword));
        closeSoftKeyboard();
    }

    @cucumber.api.java.en.And("^I click signup button$")
    public void iClickOnTheGetStartedButton() {
        onView(withId(R.id.btnRegister)).perform(click());
    }

    @Then("^I should receive message success$")
    public void iShouldSeeEmailExistsMessage() {
//        onView(withText("success")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Then("^I should receive field required message$")
    public void iShouldSeeFieldRequiredMessage() {
        onView(withText("")).check(matches(hasErrorText("Required")));
    }

    @Then("^I should receive invalid email message$")
    public void iShouldSeeInvalidEmailMessage() {
        onView(hasErrorText("Please enter valid email")).check(matches(isDisplayed()));
    }

    @Then("^I should receive invalid password message$")
    public void iShouldSeeInvalidPasswordMessage() {
        onView(hasErrorText("Password is too weak")).check(matches(isDisplayed()));
    }
}