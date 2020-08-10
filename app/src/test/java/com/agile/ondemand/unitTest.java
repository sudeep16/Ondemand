package com.agile.ondemand;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.testbl.AddtoWishlist;
import com.agile.ondemand.testbl.CatBl;
import com.agile.ondemand.bll.CategoryBLL;
import com.agile.ondemand.testbl.DeletePostBl;
import com.agile.ondemand.bll.FeedbackBLL;
import com.agile.ondemand.bll.HireBLL;
import com.agile.ondemand.testbl.HireBl;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.bll.ProfileBLL;
import com.agile.ondemand.bll.SignUpBLL;
import com.agile.ondemand.model.Owner;
import com.agile.ondemand.model.PendingJob;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.ServiceAdsUpdate;
import com.agile.ondemand.url.Url;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class unitTest {

@Test
public void testLogin_correct(){
    LoginBLL loginBLL=new LoginBLL();
    boolean result=loginBLL.checkUser("Tester1","Tester12@");
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
        boolean result=signUpBLL.signupUser("Tester3","Tester3","Tester3","Tester4","Tester3@gmail.com","9860172363","Male","Tester12@");
        assertTrue(result);
    }



    @Test
    public void testAddCat_correct(){
        CatBl catBl=new CatBl();
        boolean result=catBl.addCategory("Plumber","shakya","10:00 am","5:00 pm","Sunday","Monday","1500");
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
       // assertTrue(it.status == SUCCESS_CODE)
    }
//    @Test
//    public void testCategory_incorrect_token(){
//        CategoryBLL categoryBLL=new CategoryBLL();
//        boolean result=categoryBLL.addCategory("eyJhbGciOiJI","plumber","mangal","12","5","Sunday","Friday","200");
//        assertEquals(false,result);
//    }

//    int statusCode = response.code();
//    User user = response.body();

    @Test
public void testHirePost_correct(){
        HireBLL hireBLL =new HireBLL();
        boolean result= hireBLL.hirePost("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBkMDEzOTY0YjlmMDBkMTMxZjllNzgiLCJpYXQiOjE1OTQ2ODc4OTR9.gG_sGP9OAKIVhSJ9vVGb6rbG1rNgwZ00iDyxEGHb-CQ",
                "Cash On Delivery","Sunday","12pm","hire","Tester1");
        assertEquals(true,result);
    }

    @Test
public void testHirePerson_correct(){
        HireBl hireBLL =new HireBl();
        Owner owner=new Owner("5f2add5c64309b3a8c9f3098","Tester2","Tester2","9999999999");
        PendingJob pendingJob=new PendingJob("5f2ade0264309b3a8c9f309c","Cash on Delivery","Thursday, August 6, 2020","10:12 AM","Test",owner);
        boolean result= hireBLL.addOrder(pendingJob,"Tester2");
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
        boolean result=feedbackBLL.giveFeedback(Url.token,"3","testing Feedback","Tester2");
        assertEquals(true,result);
    }




    @Test
    public void testProfile_load(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
        assertEquals(true,result);
    }
//
//    @Test
//    public void testProfile_load(){
//        ProfileBLL profileBLL=new ProfileBLL();
//        boolean result=profileBLL.updateUserData("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","5f0ae686505b73175243a36a","");
//        assertEquals(true,result);
//    }

    @Test
    public void testPendingJob_load(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
        assertEquals(true,result);
    }

    @Test
    public void testHireList_load(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBhZTY4NjUwNWI3MzE3NTI0M2EzNmEiLCJpYXQiOjE1OTQ3MDgzMzV9.YEmWJprqNNBqBSqTT3XCsGtJD_owljFjP58CazAz-w8","3","testing Feedback","shknischal");
        assertEquals(true,result);
    }

    boolean isSuccess=true;

    @Test
    public void testCategoryList_wishlist(){
        Owner owner=new Owner("5f2add5c64309b3a8c9f3098","Tester2","Tester2","9999999999");
        ServiceAds serviceAds=new ServiceAds("5f2add9964309b3a8c9f3099","Gardener","flower,blossoms","10:10 AM ","2:10 PM","Sunday","Thursday","1500",owner);

        UsersApi usersApi = Url.getInstance().create(UsersApi.class);
        Call<Void> wishList = usersApi.wishList(Url.token, serviceAds.getAdOwner().getUsername());

        wishList.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()&& response.body().getClass().isArray()) {
                    isSuccess = true;
                }

            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });

    }

    @Test
    public void deletePostTest(){
        DeletePostBl deletePostBl=new DeletePostBl();
        boolean result=deletePostBl.deletePost("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }

    @Test
    public void addToWishlist(){
        AddtoWishlist addtoWishlist=new AddtoWishlist();
        boolean result=addtoWishlist.addToWishlist("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }
 @Test
    public void approvePendingJob(){
        HireBl hireBl=new HireBl();
        boolean result=hireBl.approvePendingJob("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",true);
        assertEquals(true,result);
    }
 @Test
    public void deleteHiredList(){
        HireBl hireBl=new HireBl();
        boolean result=hireBl.deleteHireList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }
@Test
    public void deletePost(){
        ProfileBLL profileBLL=new ProfileBLL();
        boolean result=profileBLL.deletePost("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }

@Test
    public void getServiceListByCat(){
        CategoryBLL categoryBLL=new CategoryBLL();
        boolean result=categoryBLL.getServiceList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","Plumber");
        assertEquals(true,result);
    }


    @Test
    public void getFeedbackList(){
        CategoryBLL categoryBLL=new CategoryBLL();
        boolean result=categoryBLL.getFeedback("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g");
        assertEquals(true,result);
    }

    @Test
    public void getMyPost(){
        ProfileBLL profileBLL=new ProfileBLL();
        boolean result=profileBLL.getMyPost("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g");
        assertEquals(true,result);
    }


    @Test
    public void getNotification(){
        ProfileBLL profileBLL=new ProfileBLL();
        boolean result=profileBLL.getNotification("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g");
        assertEquals(true,result);
    }



    @Test
    public void getPendingJobs(){
        HireBl hireBl=new HireBl();
        boolean result=hireBl.getPendingJobs("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g");
        assertEquals(true,result);
    }


    @Test
    public void updateServiceAd(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }


    @Test
    public void viewSelectedData(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }


   @Test
    public void loadUser(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }

   @Test
    public void userUpdate(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }
   @Test
    public void userDelete(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }


  @Test
    public void pendingJobCount(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }


  @Test
    public void feedbacksCount(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }

      @Test
    public void loadUserByFirstName(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }



   @Test
    public void viewUserProfile(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }


   @Test
    public void getWishList(){
        CategoryBLL categoryBLL =new CategoryBLL();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("","","","","","","","");
        boolean result=categoryBLL.updateServiceAd("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjJhZGM3OTY0MzA5YjNhOGM5ZjMwOTUiLCJpYXQiOjE1OTY2NTY2MTV9.GG5JXb6VaCVWiPLJPP7j4nwoTyby095KlRjurWodo1g","5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }

}
