package com.agile.ondemand;

import com.agile.ondemand.model.User;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private User user;

    private List<User> userList;


    @Before
    public void setup() {
        userList = new ArrayList<>();
    //    user = new User(userList);
    }

//    @Test
//    public void testFindAll() {
//        User user1 = new User("","","","","","","","");
//        userList.addAll(asList(user1));
//        assertThat(User.findAll())
//                .containsExactly(user1);
//    }





}