package com.agile.ondemand;

import com.agile.ondemand.api.UsersApi;
import com.agile.ondemand.bll.ProfileBLL;
import com.agile.ondemand.model.UserUpdate;
import com.agile.ondemand.serverresponse.SignUpResponse;
import com.agile.ondemand.testbl.FeedbackBl;
import com.agile.ondemand.testbl.WishlistBl;
import com.agile.ondemand.testbl.CatBl;
import com.agile.ondemand.testbl.CategoryBl;
import com.agile.ondemand.bll.FeedbackBLL;
import com.agile.ondemand.bll.HireBLL;
import com.agile.ondemand.testbl.HireBl;
import com.agile.ondemand.bll.LoginBLL;
import com.agile.ondemand.testbl.ProfileBl;
import com.agile.ondemand.bll.SignUpBLL;
import com.agile.ondemand.model.Owner;
import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.ServiceAdsUpdate;
import com.agile.ondemand.url.Url;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class unitTest {
    SignUpResponse signUpResponse;

    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjMxZjg3M2RmYTQ2ZDEyMjRhYzhjMjAiLCJpYXQiOjE1OTcxMTAzODd9.6zzg8_rLNjycd_jPZ2Awc77jfTp_6Vlspr3QGDtAnYk";
    //String token1=signUpResponse.getToken();
    String token3=Url.token;

@Test
public void testLogin_correct(){
    LoginBLL loginBLL=new LoginBLL();
    boolean result=loginBLL.checkUser("Tester5","Tester12@");
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

//    @Test
//    public void testSignup_correct(){
//        SignUpBLL signUpBLL=new SignUpBLL();
//        boolean result=signUpBLL.signupUser("Tester5","Tester5","Tester5","Tester5","Tester3@gmail.com","9860172363","Male","Tester12@");
//        assertTrue(result);
//    }


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

   //Service Ads/Jobs
    @Test
    public void testAddCat_correct(){
        CatBl catBl=new CatBl();
        boolean result=catBl.addCategory(token,"Plumber","shakya","10:00 am","5:00 pm","Sunday","Monday","1500");
        assertTrue(result);
    }


//    @Test
//    public void testCategory_correct(){
//        CategoryBLL categoryBLL=new CategoryBLL();
//        boolean result=categoryBLL.addCategory("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZjBkMDEzOTY0YjlmMDBkMTMxZjllNzgiLCJpYXQiOjE1OTQ2ODc4OTR9.gG_sGP9OAKIVhSJ9vVGb6rbG1rNgwZ00iDyxEGHb-CQ","plumber","mangal","12","5","Sunday","Friday","200");
//        assertEquals(true,result);
//       // assertTrue(it.status == SUCCESS_CODE)
//    }

    @Test
    public void getServiceListByCat(){
        CategoryBl categoryBLL=new CategoryBl();
        boolean result=categoryBLL.getServiceList(token,"Plumber");
        assertEquals(true,result);
    }

    @Test
    public void updateServiceAd(){
        CategoryBl categoryBLL =new CategoryBl();
        ServiceAdsUpdate serviceAdsUpdate=new ServiceAdsUpdate("5f2add9964309b3a8c9f3099","Gardener","","","","","","600");
        boolean result=categoryBLL.updateServiceAd(token,"5f2add0364309b3a8c9f3097",serviceAdsUpdate);
        assertEquals(true,result);
    }


//Hire Service Man

    @Test
public void testHirePost_correct(){
        HireBLL hireBLL =new HireBLL();
        boolean result= hireBLL.hirePost(token,"Cash On Delivery","Sunday","12pm","hire","Tester1");
        assertEquals(true,result);
    }

//    @Test
//public void testHirePerson_correct(){
//        HireBl hireBLL =new HireBl();
//        Owner owner=new Owner("5f2add5c64309b3a8c9f3098","Tester2","Tester2","9999999999");
//        PendingJob pendingJob=new PendingJob("5f2ade0264309b3a8c9f309c","Cash on Delivery","Thursday, August 6, 2020","10:12 AM","Test",owner);
//        boolean result= hireBLL.addOrder(pendingJob,"Tester2");
//        assertEquals(true,result);
//    }
    @Test

    public void testHirePost_if_token_not_found(){
        HireBLL hireBLL =new HireBLL();
        boolean result= hireBLL.hirePost(" ",
                "Cash On Delivery","Sunday","12pm","hire","nischalsed");
        assertEquals(false,result);
    }

    @Test

    public void Hire(){
        HireBl hireBLL =new HireBl();
        boolean result= hireBLL.Hire(token,
                "Cash On Delivery","Sunday","12pm","hire","shknischal");
        assertEquals(true,result);
    }

    @Test
    public void testHireList_load(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback(token,"3","testing Feedback","Tester5");
        assertEquals(true,result);
    }

    @Test
    public void deleteHiredList(){
        HireBl hireBl=new HireBl();
        boolean result=hireBl.deleteHireList(token,"5f31f873dfa46d1224ac8c20");
        assertEquals(true,result);
    }

    //Feedback for the service provider.
    @Test
    public void testFeedback_correct(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback(Url.token,"3","testing Feedback","Tester1");
        assertEquals(true,result);
    }

      @Test
    public void getUserFeedback(){
        FeedbackBl feedbackBLL=new FeedbackBl();
        boolean result=feedbackBLL.getUserFeedback(token);
        assertEquals(true,result);
    }



    @Test
    public void getFeedbackList(){
        CategoryBl categoryBLL=new CategoryBl();
        boolean result=categoryBLL.getFeedback(token);
        assertEquals(true,result);
    }

    //Profile Page Functions
    @Test
    public void testProfile_load(){
        FeedbackBLL feedbackBLL=new FeedbackBLL();
        boolean result=feedbackBLL.giveFeedback(token,"3","testing Feedback","shknischal");
        assertEquals(true,result);
    }

    @Test
    public void deletePost(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.deletePost(token,"5f31f873dfa46d1224ac8c20");
        assertEquals(true,result);
    }

    @Test
    public void getMyPost(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.getMyPost(token);
        assertEquals(true,result);
    }
       @Test
    public void getUserDetail(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.getUserDetail(token);
        assertEquals(true,result);
    }


    @Test
    public void userUpdate(){
        ProfileBl profileBl =new ProfileBl();
        UserUpdate userUpdate=new UserUpdate("5f31f873dfa46d1224ac8c20","Tester5","Tester5","Tester5","Tester3","Tester@gmail.com","");
        boolean result= profileBl.updateUserData(token,"5f31f873dfa46d1224ac8c20",userUpdate);
        assertEquals(true,result);
    }

    @Test
    public void viewUserProfile(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.viewUserProfile(token,"Tester5");
        assertEquals(true,result);
    }

       @Test
    public void getViewProfilePost(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.getViewProfilePost(token,"5f31f873dfa46d1224ac8c20");
        assertEquals(true,result);
    }

    @Test
    public void loadUserByFirstName(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.loadUserByFirstName(token,"T");
        assertEquals(true,result);
    }




    // Pending Jobs Loaded in the Profile page.

    @Test
    public void approvePendingJob(){
        HireBl hireBl=new HireBl();
        boolean result=hireBl.approvePendingJob(token,"5f2add0364309b3a8c9f3097",true);
        assertEquals(true,result);
    }

    @Test
    public void getPendingJobs(){
        HireBl hireBl=new HireBl();
        boolean result=hireBl.getPendingJobs(token);
        assertEquals(true,result);
    }


//Wishlists.
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
    public void getWishList(){
        WishlistBl wishlistBl =new WishlistBl();
        boolean result= wishlistBl.getWishList(token);
        assertEquals(true,result);
    }

    @Test
    public void addToWishlist(){
        WishlistBl wishlistBl =new WishlistBl();
        boolean result= wishlistBl.addToWishlist(token,"5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }

        @Test
    public void deleteWishlist(){
        WishlistBl wishlistBl =new WishlistBl();
        boolean result= wishlistBl.deleteWishList(token,"5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }

            @Test
    public void getWishListbyUsername(){
        WishlistBl wishlistBl =new WishlistBl();
        boolean result= wishlistBl.getWishListbyUsername(token,"5f2add0364309b3a8c9f3097");
        assertEquals(true,result);
    }






//Notifications
    @Test
    public void getNotification(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.getNotification(token);
        assertEquals(true,result);
    }





//Count Functions present in the profile page

  @Test
    public void pendingJobCount(){
        ProfileBl profileBl =new ProfileBl();
      boolean result= profileBl.pendingJobCount(token);
        assertEquals(true,result);
    }


  @Test
    public void feedbacksCount(){
      ProfileBl profileBl =new ProfileBl();
      boolean result= profileBl.feedbacksCount(token);
      assertEquals(true,result);
    }





    //Search Function



    @Test
    public void fetchDataToUpdateFragment(){
        CategoryBl categoryBLL =new CategoryBl();
        boolean result= categoryBLL.fetchDataToUpdateFragment(token,"5f31f873dfa46d1224ac8c20");
        assertEquals(true,result);
    }

    @Test
    public void userDelete(){
        ProfileBl profileBl =new ProfileBl();
        boolean result= profileBl.userDelete(token,"5f31f873dfa46d1224ac8c20");
        assertEquals(true,result);
    }





}
