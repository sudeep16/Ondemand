package com.agile.ondemand;

import com.agile.ondemand.bll.CategoryBLL;
import com.agile.ondemand.bll.FeedbackBLL;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.bll.HireBLL;
import com.agile.ondemand.bll.SignUpBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class unitTest {

@Test
public void testLogin_correct(){
    LoginBLL loginBLL=new LoginBLL();
    boolean result=loginBLL.checkUser("nischalsed","nischal12@");
    assertEquals(true,result);
}

    @Test
    public void testLogin_if_no_username(){
        LoginBLL loginBLL=new LoginBLL();
        boolean result=loginBLL.checkUser(" ","nischal123");
        assertEquals(false,result);
    }

    @Test
    public void testLogin_if_no_password(){
        LoginBLL loginBLL=new LoginBLL();
        boolean result=loginBLL.checkUser("nischalshk "," ");
        assertEquals(false,result);
    }

    @Test
    public void testLogin_if_username_criteria_not_met(){
        LoginBLL loginBLL=new LoginBLL();
        boolean result=loginBLL.checkUser("nisc ","nischal123");
        assertEquals(false,result);
    }

    @Test
    public void testSignup_correct(){
        SignUpBLL signUpBLL=new SignUpBLL();
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","nischalsed","nischal@gmail.com","9860172363","Male","nischal12@");
        assertTrue(result);
    }

    @Test
    public void testSignup_if_username_exists(){
        SignUpBLL signUpBLL=new SignUpBLL();
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","nischalsed","nischal@gmail.com","9860172363","Male","nischal12@");
        assertEquals(false,result);
    }
    @Test
    public void testSignup_if_fields_missing(){
        SignUpBLL signUpBLL=new SignUpBLL();
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","","nischal@gmail.com","9860172363","Male","nischal12@");
        assertEquals(false,result);
    }



    @Test
    public void testSignup_if_password_weak(){
        SignUpBLL signUpBLL=new SignUpBLL();
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","nischalsed1","nischal@gmail.com","9860172363","Male","nischa");
        assertEquals(false,result);
    }

    @Test
    public void testSignup_if_email_format_incorrect(){
        SignUpBLL signUpBLL=new SignUpBLL();
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","nischalsed","nischal@gmail","9860172363","Male","nischal12@");
        assertEquals(false,result);
    }
////

    @Test
    public void testCategory_correct(){
        CategoryBLL categoryBLL=new CategoryBLL();
        boolean result=categoryBLL.addCategory("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBkMDEzOTY0YjlmMDBkMTMxZjllNzgiLCJpYXQiOjE1OTQ2ODc4OTR9.gG_sGP9OAKIVhSJ9vVGb6rbG1rNgwZ00iDyxEGHb-CQ","plumber","mangal","12","5","Sunday","Friday","200");
        assertEquals(true,result);
    }
    @Test
    public void testCategory_incorrect_token(){
        CategoryBLL categoryBLL=new CategoryBLL();
        boolean result=categoryBLL.addCategory("eyJhbGciOiJI","plumber","mangal","12","5","Sunday","Friday","200");
        assertEquals(false,result);
    }

    @Test
public void testHirePost_correct(){
        HireBLL hireBLL =new HireBLL();
        boolean result= hireBLL.hirePost("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBkMDEzOTY0YjlmMDBkMTMxZjllNzgiLCJpYXQiOjE1OTQ2ODc4OTR9.gG_sGP9OAKIVhSJ9vVGb6rbG1rNgwZ00iDyxEGHb-CQ",
                "Cash On Delivery","Sunday","12pm","hire","nischalsed");
        assertEquals(true,result);
    }
    @Test
    public void testHirePost_if_token_not_found(){
        HireBLL hireBLL =new HireBLL();
        boolean result= hireBLL.hirePost(" ",
                "Cash On Delivery","Sunday","12pm","hire","nischalsed");
        assertEquals(false,result);
    }



    @Test
    public void testFeedback_correct(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
        assertEquals(true,result);
    }

    @Test
    public void testFeedback_empty(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
        assertEquals(true,result);
    }

    @Test
    public void testProfile_load(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
        assertEquals(true,result);
    }



//    @Test
//    public void testProfile_delete(){
//        FeedbackBLL feedbackBLL=new FeedbackBLL();
//        boolean result=feedbackBLL.addFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
//        assertEquals(true,result);
//    }
//
//
//    @Test
//    public void testProfile_update(){
//        FeedbackBLL feedbackBLL=new FeedbackBLL();
//        boolean result=feedbackBLL.addFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
//        assertEquals(true,result);
//    }
//
//
//
//
//    @Test
//    public void testNotification_load(){
//        FeedbackBLL feedbackBLL=new FeedbackBLL();
//        boolean result=feedbackBLL.addFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
//        assertEquals(true,result);
//    }
//
//
//
//
//
//    @Test
//    public void testNotification_load(){
//        FeedbackBLL feedbackBLL=new FeedbackBLL();
//        boolean result=feedbackBLL.addFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
//        assertEquals(true,result);
//    }
//
//













    @Test
    public void testUserType(){



    }

    //        @Test
//        public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
//            assertTrue(Validation.validateEmail("name@email.com"));
//        }




}
