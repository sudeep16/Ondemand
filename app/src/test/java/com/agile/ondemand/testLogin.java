package com.agile.ondemand;

import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.bll.SignUpBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLogin {

@Test
public void testLogin(){
    LoginBLL loginBLL=new LoginBLL();
    boolean result=loginBLL.checkUser("nischalshk","nischal123");
    assertEquals(true,result);
}

    @Test
    public void testSignup(){
        SignUpBLL signUpBLL=new SignUpBLL();
        boolean result=signUpBLL.signupUser("nischal","shakya","mangal","nischalshk","nis@gmail.com","9860172363","Male","nischal123");
        assertEquals(true,result);
    }




    @Test
    public void testUserType(){



    }




}
