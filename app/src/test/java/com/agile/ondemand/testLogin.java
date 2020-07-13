package com.agile.ondemand;

import com.agile.ondemand.bll.CategoryBLL;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.bll.PlumberBLL;
import com.agile.ondemand.bll.SignUpBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testLogin {

@Test
public void testLogin_correct(){
    LoginBLL loginBLL=new LoginBLL();
    boolean result=loginBLL.checkUser("nischalshk","nischal123");
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
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","nischalshk","nis@gmail.com","9860172363","Male","nischal123");
        assertTrue(result);
    }

    @Test
    public void testCategory(){
        CategoryBLL categoryBLL=new CategoryBLL();
        boolean result=categoryBLL.addCategory("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ1NDk5MTB9.xVhKTWFyId6clLQfbtVLIfyPUYOBDlHfkTv75-ruIbU","plumber","mangal","12","5","Sunday","Friday","200");
        assertEquals(true,result);
    }


    @Test
    public void testPlumber(){
        PlumberBLL plumberBLL=new PlumberBLL();
        boolean result=plumberBLL.getCategory("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ1NDk5MTB9.xVhKTWFyId6clLQfbtVLIfyPUYOBDlHfkTv75-ruIbU");
        assertEquals(true,result);
    }








    @Test
    public void testUserType(){



    }




}
