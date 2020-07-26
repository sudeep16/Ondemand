package com.agile.ondemand;

import com.agile.ondemand.bll.LoginBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLogin {

@Test
public void testLoginPass(){
    LoginBLL loginBLL=new LoginBLL("username","password");
    //boolean result=loginBLL.checkUser("username","password");
    boolean result=loginBLL.checkUser();
    assertEquals(true,result);

}



    @Test
    public void testUserType(){



    }




}
